#!/usr/bin/env python3
"""Extract auditable JAR attraction visual chunks for the Godot port.

This keeps the raw arr.dat chunk data while also decoding the base render
structures used by e.java: footprint chunk 37, visual mask chunk 38, static
pieces chunks 5..11, static tile ranges 32/33, and static frame mask 40.
"""
from __future__ import annotations

import json
from pathlib import Path
from typing import Any

ROOT = Path(__file__).resolve().parents[1]
ARRSI_PATH = ROOT / "prehistoric_vineflower" / "arrsi.dat"
ARR_PATH = ROOT / "prehistoric_vineflower" / "arr.dat"
OUTPUT_PATH = ROOT / "godot_project" / "data" / "attraction_visual_chunks.json"

HEADER_NAMES = [
    "duration_ticks",
    "animation_frame_limit",
    "visual_frame_modulo",
    "static_piece_count",
    "animated_piece_count",
    "static_line_count",
    "animated_line_count",
    "visitor_capacity",
    "unknown_ar",
    "unknown_av",
    "unknown_aw",
    "unknown_ax",
    "unknown_ay",
    "cost_units",
    "satisfaction_gain",
    "unknown_aB",
    "ticket_price",
]

ATTRACTION_NAMES = [
    "Roda gigante",
    "Torre",
    "Torre grande",
    "Bungee jump grande",
    "Bungee jump",
    "Caverna do terror",
    "Balanco",
    "Salto de agua",
    "Salto trampolim",
    "Tobogan aquatico",
    "Tobogan",
    "Trampolim",
    "Gira-gira",
    "Gira-gira grande",
    "Gangorra",
    "Salto Grande",
    "Banho de agua",
    "Campo de tiro",
    "Catapulta",
    "Ursa Maior",
    "Montanha russa media",
    "Montanha russa",
    "Circuito de agua",
    "Cafeteria",
]

STATIC_LINE_COLORS = [
    [],
    [0],
    [0],
    [0],
    [0],
    [],
    [],
    [],
    [],
    [],
    [],
    [],
    [],
    [],
    [],
    [0],
    [],
    [8022300, 8022300],
    [],
    [],
    [],
    [],
    [],
    [],
]

ANIMATED_LINE_COLORS = [
    [],
    [0],
    [0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [],
    [0, 0, 0],
    [],
    [],
    [],
    [],
    [],
    [],
    [],
    [2166272, 2166272, 3745030, 3745030, 2166272, 2166272, 3745030],
    [],
    [0],
    [0],
    [0, 0, 0, 0],
    [],
    [],
    [],
    [],
    [],
]

# e.a(boolean), e.b(boolean), e.c(boolean) -> e.aK(). The values are aK
# sprite indices in aI chunks 59..64, in the same draw order used by the JAR.
def chunk38_ak_indices(mask_unsigned: int, footprint_code: int) -> list[int]:
    indices: list[int] = []
    if mask_unsigned & 64:
        indices.append(2)
    if mask_unsigned & 4:
        indices.append(8)
    if mask_unsigned & 128:
        indices.append(1)
    if mask_unsigned & 8:
        indices.append(7)
    if (mask_unsigned & 74) == 74:
        indices.append(15)
    if (mask_unsigned & 133) == 133:
        indices.append(16)
    if mask_unsigned & 16:
        indices.append(18)
    if mask_unsigned & 1:
        indices.append(10)
    if mask_unsigned & 32:
        indices.append(17)
    if mask_unsigned & 2:
        indices.append(9)
    if footprint_code == 5:
        indices.append(3)
    if footprint_code == 6:
        indices.append(4)
    return indices


def footprint_base_ak_indices(footprint_code: int) -> list[int]:
    if footprint_code <= 3 or footprint_code > 12:
        return []
    indices = [0]
    if footprint_code == 7:
        indices.append(11)
    elif footprint_code == 8:
        indices.append(14)
    elif footprint_code == 5:
        indices.append(13)
    elif footprint_code == 6:
        indices.append(12)
    return indices


def s8(value: int) -> int:
    return value - 256 if value > 127 else value


def rgb_int_to_array(value: int) -> list[int]:
    return [(value >> 16) & 0xFF, (value >> 8) & 0xFF, value & 0xFF]


def line_color(colors: list[list[int]], jar_type: int, line_index: int) -> tuple[int, list[int]]:
    if 0 <= jar_type < len(colors) and line_index < len(colors[jar_type]):
        value = int(colors[jar_type][line_index])
    else:
        value = 0
    return value, rgb_int_to_array(value)


def read_u16le(data: bytes, pos: int) -> tuple[int, int]:
    return data[pos] + data[pos + 1] * 256, pos + 2


def read_arrsi(path: Path) -> tuple[list[dict[str, Any]], int]:
    data = path.read_bytes()
    pos = 0
    headers: list[dict[str, Any]] = []
    for jar_type in range(24):
        raw_fields = list(data[pos:pos + 17])
        pos += 17
        blob_length, pos = read_u16le(data, pos)
        fields = dict(zip(HEADER_NAMES, raw_fields))
        # Compatibility aliases for older tooling. In the JAR these are
        # am[type], as[type], at[type]: duration, full animation frame limit,
        # and visual frame modulo used by chunks.
        fields["use_frame_count"] = fields["animation_frame_limit"]
        fields["visual_frame_count"] = fields["visual_frame_modulo"]
        fields["special_piece_count"] = fields["unknown_ar"]
        headers.append({
            "jar_type": jar_type,
            "name": ATTRACTION_NAMES[jar_type],
            "fields": fields,
            "raw_fields": raw_fields,
            "blob_length": blob_length,
        })
    for _ in range(27):
        pos += 3
        _, pos = read_u16le(data, pos)
    ai_length, pos = read_u16le(data, pos)
    if pos != len(data):
        raise ValueError(f"arrsi.dat parse stopped at {pos}, file has {len(data)} bytes")
    return headers, ai_length


def read_arr(path: Path) -> tuple[list[dict[str, Any]], list[list[int]]]:
    data = path.read_bytes()
    pos = 0
    attractions: list[dict[str, Any]] = []
    for jar_type in range(24):
        chunks: list[list[int]] = []
        lengths: list[int] = []
        offsets: list[int] = [0]
        raw_blob: list[int] = []
        blob_pos = 0
        for chunk_index in range(42):
            length, pos = read_u16le(data, pos)
            lengths.append(length)
            raw = data[pos:pos + length]
            pos += length
            decoded_chunk = [s8(byte) for byte in raw]
            chunks.append(decoded_chunk)
            raw_blob.extend(decoded_chunk)
            blob_pos += length
            if chunk_index < 41:
                offsets.append(blob_pos)
        attractions.append({
            "jar_type": jar_type,
            "g_offsets": offsets,
            "o_blob": raw_blob,
            "chunk_lengths": lengths,
            "chunk_offsets": offsets,
            "chunks": {str(index): chunk for index, chunk in enumerate(chunks)},
        })
    for _ in range(27):
        for _chunk_index in range(16):
            length, pos = read_u16le(data, pos)
            pos += length
    ai_chunks: list[list[int]] = []
    for _ in range(177):
        length, pos = read_u16le(data, pos)
        ai_chunks.append([s8(byte) for byte in data[pos:pos + length]])
        pos += length
    if pos != len(data):
        raise ValueError(f"arr.dat parse stopped at {pos}, file has {len(data)} bytes")
    return attractions, ai_chunks


def chunk_value(chunks: dict[str, list[int]], chunk_index: int, index: int, default: int = 0) -> int:
    chunk = chunks.get(str(chunk_index), [])
    if 0 <= index < len(chunk):
        return int(chunk[index])
    return default


def make_ak_piece_table(ai_chunks: list[list[int]]) -> list[dict[str, Any]]:
    piece_count = min(len(ai_chunks[59]), len(ai_chunks[60]), len(ai_chunks[61]), len(ai_chunks[62]), len(ai_chunks[63]), len(ai_chunks[64]))
    pieces: list[dict[str, Any]] = []
    for index in range(piece_count):
        pieces.append({
            "piece_index": index,
            "ak_index": index,
            "sheet": "gpack1_002",
            "region": [ai_chunks[59][index], ai_chunks[60][index], ai_chunks[61][index], ai_chunks[62][index]],
            "offset": [ai_chunks[63][index], ai_chunks[64][index]],
            "anchor": [0, 0],
            "source": "aI chunks 59..64 via aK()/aI()",
        })
    return pieces


def make_static_piece_defs(chunks: dict[str, list[int]], header_fields: dict[str, int]) -> list[dict[str, Any]]:
    count = int(header_fields["static_piece_count"])
    frame_count = max(1, int(header_fields["visual_frame_modulo"]))
    chunk4 = chunks.get("4", [])
    chunk40 = chunks.get("40", [])
    ignore_chunk40 = len(chunk4) > 1 and int(chunk4[1]) == 1
    pieces: list[dict[str, Any]] = []
    for index in range(count):
        visible_frames: list[bool] = []
        frame_dependent = False
        if not ignore_chunk40 and len(chunk40) >= frame_count * max(1, count):
            visible_frames = [bool(chunk40[frame * count + index]) for frame in range(frame_count)]
            frame_dependent = any(visible_frames) and not all(visible_frames)
        sheet_index = chunk_value(chunks, 11, index)
        source_y = chunk_value(chunks, 6, index)
        pieces.append({
            "piece_index": index,
            "sheet": f"gpack1_{sheet_index:03d}",
            "sheet_index": sheet_index,
            "region": [
                chunk_value(chunks, 5, index),
                source_y,
                chunk_value(chunks, 7, index),
                chunk_value(chunks, 8, index),
            ],
            "offset": [chunk_value(chunks, 9, index), chunk_value(chunks, 10, index)],
            "anchor": [0, 0],
            "chunk": "static_5_11",
            "visible_frames": visible_frames,
            "frame_dependent": frame_dependent,
            "chunk40_ignored_by_chunk4": ignore_chunk40,
        })
    return pieces


def make_animated_piece_defs(chunks: dict[str, list[int]], header_fields: dict[str, int]) -> list[dict[str, Any]]:
    count = int(header_fields["animated_piece_count"])
    frame_count = max(1, int(header_fields["visual_frame_modulo"]))
    chunk2 = chunks.get("2", [])
    chunk3 = chunks.get("3", [])
    chunk4 = chunks.get("4", [])
    chunk41 = chunks.get("41", [])
    y_offset_by_frame = len(chunk2) > 0 and int(chunk2[0]) == 1
    x_offset_by_frame = len(chunk2) > 1 and int(chunk2[1]) == 1
    anchor_static = len(chunk3) > 1 and int(chunk3[1]) == 1
    ignore_chunk41 = len(chunk4) > 1 and int(chunk4[1]) == 1
    pieces: list[dict[str, Any]] = []
    for index in range(count):
        offset_x_frames: list[int] = []
        offset_y_frames: list[int] = []
        anchor_frames: list[list[int]] = []
        visible_frames: list[bool] = []
        for frame in range(frame_count):
            offset_index = frame * count + index
            offset_x_frames.append(chunk_value(chunks, 17, offset_index if y_offset_by_frame else index))
            offset_y_frames.append(chunk_value(chunks, 18, offset_index if x_offset_by_frame else index))
            anchor_frame = 0 if anchor_static else frame
            anchor_frames.append([
                chunk_value(chunks, 34, anchor_frame * 2),
                chunk_value(chunks, 34, anchor_frame * 2 + 1),
            ])
            if ignore_chunk41:
                visible_frames.append(True)
            elif len(chunk41) >= frame_count * max(1, count):
                visible_frames.append(bool(chunk41[offset_index]))
            else:
                visible_frames.append(True)
        sheet_index = chunk_value(chunks, 16, index)
        pieces.append({
            "piece_index": index,
            "sheet": f"gpack1_{sheet_index:03d}",
            "sheet_index": sheet_index,
            "region": [
                chunk_value(chunks, 12, index),
                chunk_value(chunks, 13, index),
                chunk_value(chunks, 14, index),
                chunk_value(chunks, 15, index),
            ],
            "offset": [offset_x_frames[0] if offset_x_frames else 0, offset_y_frames[0] if offset_y_frames else 0],
            "anchor": anchor_frames[0] if anchor_frames else [0, 0],
            "animated_offsets_x": offset_x_frames,
            "animated_offsets_y": offset_y_frames,
            "anchor_frames": anchor_frames,
            "visible_frames": visible_frames,
            "frame_count": frame_count,
            "chunk": "animated_12_18",
            "source": "aF chunks 12..18, anchor chunk34, visibility chunk41",
            "offset_y_by_frame_chunk2_0": y_offset_by_frame,
            "offset_x_by_frame_chunk2_1": x_offset_by_frame,
            "anchor_static_chunk3_1": anchor_static,
            "chunk41_ignored_by_chunk4": ignore_chunk41,
        })
    return pieces


def line_anchor(chunks: dict[str, list[int]]) -> list[int]:
    return [
        chunk_value(chunks, 36, 0),
        chunk_value(chunks, 36, 1),
    ]


def make_static_line_defs(chunks: dict[str, list[int]], header_fields: dict[str, int], jar_type: int) -> list[dict[str, Any]]:
    count = int(header_fields["static_line_count"])
    lines: list[dict[str, Any]] = []
    anchor = line_anchor(chunks)
    for index in range(count):
        base = index * 4
        color_int, color = line_color(STATIC_LINE_COLORS, jar_type, index)
        lines.append({
            "line_index": index,
            "anchor": anchor,
            "start": [chunk_value(chunks, 19, base), chunk_value(chunks, 19, base + 1)],
            "end": [chunk_value(chunks, 19, base + 2), chunk_value(chunks, 19, base + 3)],
            "color_int": color_int,
            "color": color,
            "chunk": "static_line_19",
            "source": "aE chunk19 static lines; anchor aM + chunk36[0..1]; color b.a[jar_type][line]",
        })
    return lines


def make_animated_line_defs(chunks: dict[str, list[int]], header_fields: dict[str, int], jar_type: int) -> list[dict[str, Any]]:
    count = int(header_fields["animated_line_count"])
    frame_count = max(1, int(header_fields["visual_frame_modulo"]))
    chunk4 = chunks.get("4", [])
    draw_odd_segments = len(chunk4) > 2 and int(chunk4[2]) != 0
    lines: list[dict[str, Any]] = []
    anchor = line_anchor(chunks)
    points_per_frame = count + 1
    for index in range(count):
        color_int, color = line_color(ANIMATED_LINE_COLORS, jar_type, index)
        start_frames: list[list[int]] = []
        end_frames: list[list[int]] = []
        for frame in range(frame_count):
            base = frame * points_per_frame * 2 + index * 2
            start_frames.append([chunk_value(chunks, 20, base), chunk_value(chunks, 20, base + 1)])
            end_frames.append([chunk_value(chunks, 20, base + 2), chunk_value(chunks, 20, base + 3)])
        lines.append({
            "line_index": index,
            "anchor": anchor,
            "start_frames": start_frames,
            "end_frames": end_frames,
            "frame_count": frame_count,
            "color_int": color_int,
            "color": color,
            "draw_odd_segments_chunk4_2": draw_odd_segments,
            "skipped_by_chunk4_2": (not draw_odd_segments and index % 2 != 0),
            "chunk": "animated_line_20",
            "source": "aD chunk20 animated lines; frame ab%at; (aq+1) points per frame; color b.b[jar_type][line]",
        })
    return lines


def make_special_piece_defs(chunks: dict[str, list[int]], header_fields: dict[str, int]) -> list[dict[str, Any]]:
    count = int(header_fields["special_piece_count"])
    frame_count = max(1, int(header_fields["visual_frame_modulo"]))
    chunk1 = chunks.get("1", [])
    chunk3 = chunks.get("3", [])
    anchor_static = len(chunk3) > 3 and int(chunk3[3]) == 1
    pieces: list[dict[str, Any]] = []
    offset_base = 0
    for index in range(count):
        frame_start = chunk_value(chunks, 1, index * 2)
        frame_end = chunk_value(chunks, 1, index * 2 + 1, frame_start)
        if frame_end < frame_start:
            frame_start, frame_end = frame_end, frame_start
        offset_frames: list[list[int]] = []
        for frame in range(frame_start, frame_end + 1):
            offset_index = offset_base + frame - frame_start
            offset_frames.append([
                chunk_value(chunks, 30, offset_index),
                chunk_value(chunks, 31, offset_index),
            ])
        offset_base += frame_end - frame_start + 1
        anchor_frames: list[list[int]] = []
        for frame in range(frame_count):
            anchor_frame = 0 if anchor_static else frame
            anchor_frames.append([
                chunk_value(chunks, 36, anchor_frame * 2),
                chunk_value(chunks, 36, anchor_frame * 2 + 1),
            ])
        sheet_index = chunk_value(chunks, 29, index)
        pieces.append({
            "piece_index": index,
            "sheet": f"gpack1_{sheet_index:03d}",
            "sheet_index": sheet_index,
            "region": [
                chunk_value(chunks, 25, index),
                chunk_value(chunks, 26, index),
                chunk_value(chunks, 27, index),
                chunk_value(chunks, 28, index),
            ],
            "anchor": anchor_frames[0] if anchor_frames else [0, 0],
            "anchor_frames": anchor_frames,
            "offset_frames": offset_frames,
            "frame_start": frame_start,
            "frame_end": frame_end,
            "frame_count": frame_count,
            "chunk": "special_25_31",
            "source": "aD chunks 25..31; active range chunk1; anchor chunk36; chunk3[3] selects fixed/per-frame anchor",
            "anchor_static_chunk3_3": anchor_static,
        })
    return pieces


def make_passenger_frame_defs(chunks: dict[str, list[int]], header_fields: dict[str, int]) -> dict[str, Any]:
    capacity = max(0, int(header_fields["visitor_capacity"]))
    visual_frame_count = max(1, int(header_fields["visual_frame_modulo"]))
    raw_frame_count = max(1, int(header_fields["animation_frame_limit"]))
    chunk2 = chunks.get("2", [])
    chunk3 = chunks.get("3", [])
    chunk4 = chunks.get("4", [])
    render_enabled = len(chunk4) > 0 and int(chunk4[0]) == 1 and capacity > 0
    dynamic_x = len(chunk2) > 2 and int(chunk2[2]) == 1
    dynamic_y = len(chunk2) > 3 and int(chunk2[3]) == 1
    dynamic_direction = len(chunk2) > 4 and int(chunk2[4]) == 1
    dynamic_frame = len(chunk2) > 5 and int(chunk2[5]) == 1
    move_tile_by_frame = not (len(chunk3) > 2 and int(chunk3[2]) == 1)
    chunk21 = chunks.get("21", [])
    chunk22 = chunks.get("22", [])
    chunk23 = chunks.get("23", [])
    chunk24 = chunks.get("24", [])
    chunk35 = chunks.get("35", [])
    chunk39 = chunks.get("39", [])
    clip_start = int(chunk39[0]) if len(chunk39) > 0 else -1
    clip_end = int(chunk39[1]) if len(chunk39) > 1 else -1
    clip_pixels = max(0, int(header_fields["unknown_ax"]))

    initial_tile = [
        chunk_value(chunks, 35, 0),
        chunk_value(chunks, 35, 1),
    ]
    tile_offsets: list[list[int]] = []
    current_tile = [initial_tile[0], initial_tile[1]]
    for raw_frame in range(raw_frame_count):
        visual_frame = raw_frame % visual_frame_count
        if raw_frame > 0 and move_tile_by_frame:
            dx = chunk_value(chunks, 35, visual_frame * 2)
            dy = chunk_value(chunks, 35, visual_frame * 2 + 1)
            if dx != 0 or dy != 0:
                current_tile = [current_tile[0] + dx, current_tile[1] + dy]
        tile_offsets.append([current_tile[0], current_tile[1]])

    frames: list[list[dict[str, Any]]] = []
    for raw_frame in range(raw_frame_count):
        visual_frame = raw_frame % visual_frame_count
        lap = raw_frame // visual_frame_count
        frame_entries: list[dict[str, Any]] = []
        for seat in range(capacity):
            rotating_seat = (lap + seat) % capacity
            seat_frame_index = visual_frame * capacity + rotating_seat
            visual_seat_index = visual_frame * capacity + seat
            base_seat = seat
            screen_x = chunk21[seat_frame_index] if dynamic_x and seat_frame_index < len(chunk21) else (
                chunk21[base_seat] if base_seat < len(chunk21) else 10
            )
            screen_y = chunk22[seat_frame_index] if dynamic_y and seat_frame_index < len(chunk22) else (
                chunk22[base_seat] if base_seat < len(chunk22) else 10
            )
            direction = chunk23[seat_frame_index] if dynamic_direction and seat_frame_index < len(chunk23) else (
                chunk23[base_seat] if base_seat < len(chunk23) else 0
            )
            visitor_frame = chunk24[visual_seat_index] if dynamic_frame and visual_seat_index < len(chunk24) else (
                chunk24[base_seat] if base_seat < len(chunk24) else 0
            )
            clip_active = clip_start >= 0 and clip_end >= clip_start and visual_frame >= clip_start and visual_frame <= clip_end
            frame_entries.append({
                "seat_index": seat,
                "rotating_seat_index": rotating_seat,
                "screen_offset": [screen_x, screen_y],
                "direction": direction,
                "visitor_frame": visitor_frame,
                "tile_offset": tile_offsets[raw_frame],
                "clip_pixels": clip_pixels if clip_active else 0,
            })
        frames.append(frame_entries)

    return {
        "render_enabled": render_enabled,
        "capacity": capacity,
        "raw_frame_count": raw_frame_count,
        "visual_frame_count": visual_frame_count,
        "flags_chunk2": chunk2,
        "flags_chunk3": chunk3,
        "flags_chunk4": chunk4,
        "dynamic_x_chunk2_2": dynamic_x,
        "dynamic_y_chunk2_3": dynamic_y,
        "dynamic_direction_chunk2_4": dynamic_direction,
        "dynamic_frame_chunk2_5": dynamic_frame,
        "move_tile_by_frame_chunk3_2": move_tile_by_frame,
        "initial_tile_offset_chunk35": initial_tile,
        "tile_offsets_by_raw_frame": tile_offsets,
        "clip_range_chunk39": [clip_start, clip_end],
        "clip_pixels_ax": clip_pixels,
        "frames": frames,
        "raw_chunks": {
            "21": chunk21,
            "22": chunk22,
            "23": chunk23,
            "24": chunk24,
            "35": chunk35,
            "39": chunk39,
        },
        "source": "cP()/cN()/aL(): chunks 21..24 provide G/H/F/J, chunk35 moves passenger tile, chunk39 clips visitor height",
    }


def piece_visibility(pieces: list[dict[str, Any]], piece_index: int) -> tuple[bool, bool]:
    if piece_index < 0 or piece_index >= len(pieces):
        return False, False
    visible_frames = pieces[piece_index].get("visible_frames", [])
    if not visible_frames:
        return True, False
    if all(visible_frames):
        return True, False
    if any(visible_frames):
        return False, True
    return False, False


def make_tile_groups(chunks: dict[str, list[int]], pieces: list[dict[str, Any]], width: int, height: int, orientation_count: int) -> tuple[list[dict[str, Any]], list[dict[str, Any]]]:
    chunk32 = chunks.get("32", [])
    chunk33 = chunks.get("33", [])
    chunk37 = chunks.get("37", [])
    static_groups: list[dict[str, Any]] = []
    frame_static_groups: list[dict[str, Any]] = []
    for orientation in range(orientation_count):
        for local_x in range(width):
            for local_y in range(height):
                footprint_index = (orientation * width + local_x) * height + local_y
                if footprint_index >= len(chunk37):
                    continue
                footprint_code = int(chunk37[footprint_index])
                if footprint_code not in (9, 10, 11, 12):
                    continue
                local_tile_index = local_x * (height - 1) + local_y - 1
                if local_tile_index < 0 or local_tile_index + 1 >= len(chunk33):
                    continue
                start = int(chunk33[local_tile_index])
                end = int(chunk33[local_tile_index + 1])
                if start < 0 or end < start or start > len(chunk32):
                    continue
                end = min(end, len(chunk32))
                static_indices: list[int] = []
                frame_indices: list[int] = []
                for piece_index in [int(value) for value in chunk32[start:end]]:
                    is_static, is_frame_static = piece_visibility(pieces, piece_index)
                    if is_static:
                        static_indices.append(piece_index)
                    elif is_frame_static:
                        frame_indices.append(piece_index)
                base_entry = {
                    "orientation": orientation,
                    "anchor": [local_x, local_y],
                    "local_tile_index": local_tile_index,
                    "range": [start, end],
                    "footprint_code": footprint_code,
                    "source": "aE chunks 32/33, range end exclusive",
                }
                if static_indices:
                    entry = dict(base_entry)
                    entry["piece_indices"] = static_indices
                    static_groups.append(entry)
                if frame_indices:
                    entry = dict(base_entry)
                    entry["piece_indices"] = frame_indices
                    entry["frame_dependent"] = True
                    frame_static_groups.append(entry)
    return static_groups, frame_static_groups


def make_footprint_base_groups(chunks: dict[str, list[int]], width: int, height: int, orientation_count: int) -> list[dict[str, Any]]:
    chunk37 = chunks.get("37", [])
    groups: list[dict[str, Any]] = []
    for orientation in range(orientation_count):
        for local_x in range(width):
            for local_y in range(height):
                footprint_index = (orientation * width + local_x) * height + local_y
                if footprint_index >= len(chunk37):
                    continue
                footprint_code = int(chunk37[footprint_index])
                indices = footprint_base_ak_indices(footprint_code)
                if indices:
                    groups.append({
                        "orientation": orientation,
                        "anchor": [local_x, local_y],
                        "footprint_code": footprint_code,
                        "piece_indices": indices,
                        "source": "G()/aI() footprint base pieces",
                    })
    return groups


def make_chunk38_groups(chunks: dict[str, list[int]], width: int, height: int, orientation_count: int) -> list[dict[str, Any]]:
    chunk37 = chunks.get("37", [])
    chunk38 = chunks.get("38", [])
    groups: list[dict[str, Any]] = []
    for orientation in range(orientation_count):
        for local_x in range(width):
            for local_y in range(height):
                index = (orientation * width + local_x) * height + local_y
                if index >= len(chunk37) or index >= len(chunk38):
                    continue
                footprint_code = int(chunk37[index])
                if footprint_code <= 3 or footprint_code > 12:
                    continue
                mask_signed = int(chunk38[index])
                mask_unsigned = mask_signed & 0xFF
                indices = chunk38_ak_indices(mask_unsigned, footprint_code)
                if not indices:
                    continue
                groups.append({
                    "orientation": orientation,
                    "anchor": [local_x, local_y],
                    "footprint_code": footprint_code,
                    "mask": mask_signed,
                    "mask_unsigned": mask_unsigned,
                    "piece_indices": indices,
                    "source": "am chunk38 -> a()/b()/c() -> aK()",
                })
    return groups


def make_ride_anchors(chunks: dict[str, list[int]], width: int, height: int, orientation_count: int) -> list[list[int]]:
    chunk37 = chunks.get("37", [])
    anchors: list[list[int]] = []
    for orientation in range(orientation_count):
        anchor = [0, 0]
        for local_x in range(width):
            for local_y in range(height):
                index = (orientation * width + local_x) * height + local_y
                if index < len(chunk37) and int(chunk37[index]) == 10:
                    anchor = [local_x, local_y]
                    break
            if anchor != [0, 0]:
                break
        anchors.append(anchor)
    return anchors


def make_visual_data() -> dict[str, Any]:
    headers, ai_length = read_arrsi(ARRSI_PATH)
    attraction_records, ai_chunks = read_arr(ARR_PATH)
    ak_table = make_ak_piece_table(ai_chunks)
    attractions: dict[str, Any] = {}
    for header, record in zip(headers, attraction_records):
        jar_type = int(header["jar_type"])
        chunks: dict[str, list[int]] = record["chunks"]
        fields: dict[str, int] = header["fields"]
        chunk0 = chunks.get("0", [])
        width = int(chunk0[0]) if len(chunk0) > 0 else 1
        height = int(chunk0[1]) if len(chunk0) > 1 else 1
        footprint_tile_count = max(1, width * height)
        orientation_count = max(1, len(chunks.get("37", [])) // footprint_tile_count)
        static_pieces = make_static_piece_defs(chunks, fields)
        animated_pieces = make_animated_piece_defs(chunks, fields)
        static_lines = make_static_line_defs(chunks, fields, jar_type)
        animated_lines = make_animated_line_defs(chunks, fields, jar_type)
        special_pieces = make_special_piece_defs(chunks, fields)
        passenger_chunks = make_passenger_frame_defs(chunks, fields)
        static_groups, frame_static_groups = make_tile_groups(chunks, static_pieces, width, height, orientation_count)
        chunk38_groups = make_chunk38_groups(chunks, width, height, orientation_count)
        footprint_base_groups = make_footprint_base_groups(chunks, width, height, orientation_count)
        ride_anchors = make_ride_anchors(chunks, width, height, orientation_count)
        frame_dependent_indices = [int(piece["piece_index"]) for piece in static_pieces if piece.get("frame_dependent", False)]
        attractions[str(jar_type)] = {
            "jar_type": jar_type,
            "name": header["name"],
            "header": header,
            "size": [width, height],
            "footprint_width": width,
            "footprint_height": height,
            "orientation_count": orientation_count,
            "static_piece_count": int(fields["static_piece_count"]),
            "animated_piece_count": int(fields["animated_piece_count"]),
            "static_line_count": int(fields["static_line_count"]),
            "animated_line_count": int(fields["animated_line_count"]),
            "special_piece_count": int(fields["special_piece_count"]),
            "visitor_capacity": int(fields["visitor_capacity"]),
            "animation_frame_limit": max(1, int(fields["animation_frame_limit"])),
            "visual_frame_modulo": max(1, int(fields["visual_frame_modulo"])),
            "visual_animation_frame_count": max(1, int(fields["visual_frame_modulo"])),
            "visual_ride_anchor": ride_anchors[0] if ride_anchors else [0, 0],
            "visual_ride_anchors": ride_anchors,
            "visual_animation_flags": {
                "chunk2": chunks.get("2", []),
                "chunk3": chunks.get("3", []),
                "chunk4": chunks.get("4", []),
            },
            "visual_source": "arrsi.dat/arr.dat reextract; e.u(), e.am(), e.aE(), e.aK()",
            "g_offsets": record["g_offsets"],
            "o_blob": record["o_blob"],
            "raw_chunk_lengths": record["chunk_lengths"],
            "raw_chunk_offsets": record["chunk_offsets"],
            "raw_chunks": chunks,
            "visual_ak_pieces": ak_table,
            "visual_static_pieces": static_pieces,
            "visual_animated_pieces": animated_pieces,
            "visual_static_lines": static_lines,
            "visual_animated_lines": animated_lines,
            "visual_special_pieces": special_pieces,
            "visual_passenger_chunks": passenger_chunks,
            "visual_special_flags": {
                "chunk1": chunks.get("1", []),
                "chunk3": chunks.get("3", []),
                "chunk36": chunks.get("36", []),
                "anchor_static_chunk3_3": len(chunks.get("3", [])) > 3 and int(chunks.get("3", [0, 0, 0, 0])[3]) == 1,
            },
            "visual_line_flags": {
                "chunk4": chunks.get("4", []),
                "chunk36": chunks.get("36", []),
                "draw_odd_animated_segments_chunk4_2": len(chunks.get("4", [])) > 2 and int(chunks.get("4", [0, 0, 0])[2]) != 0,
            },
            "visual_static_tiles": static_groups,
            "visual_frame_static_tiles": frame_static_groups,
            "visual_frame_dependent_static_piece_indices": frame_dependent_indices,
            "visual_chunk38_tiles": chunk38_groups,
            "visual_footprint_base_tiles": footprint_base_groups,
            "visual_chunk40_mode": "split_frame_dependent_static_tiles; no destructive frame-0 filtering",
            "visual_static_tile_source": "aE(): local=x*(height-1)+y-1; start=chunk33[local]; end=chunk33[local+1]; piece indices from chunk32[start:end]",
            "visual_chunk38_source": "am() reads chunk38 per footprint tile; a()/b()/c() map mask bits to aK indices from aI chunks 59..64",
        }
    return {
        "format_version": 1,
        "source_files": ["prehistoric_vineflower/arrsi.dat", "prehistoric_vineflower/arr.dat"],
        "ai_blob_length": ai_length,
        "ak_piece_table": ak_table,
        "attractions": attractions,
    }


def main() -> None:
    data = make_visual_data()
    OUTPUT_PATH.parent.mkdir(parents=True, exist_ok=True)
    OUTPUT_PATH.write_text(json.dumps(data, indent=2, ensure_ascii=False) + "\n", encoding="utf-8")
    for jar_type, attraction in data["attractions"].items():
        print(
            f"jar_type={jar_type:>2} static={len(attraction['visual_static_pieces']):>2} "
            f"tiles={len(attraction['visual_static_tiles']):>2} frame_tiles={len(attraction['visual_frame_static_tiles']):>2} "
            f"chunk38={len(attraction['visual_chunk38_tiles']):>2} footprint={len(attraction['visual_footprint_base_tiles']):>2}"
        )
    print(f"wrote {OUTPUT_PATH}")


if __name__ == "__main__":
    main()
