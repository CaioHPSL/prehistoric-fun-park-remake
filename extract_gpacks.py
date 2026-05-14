from __future__ import annotations

import argparse
from pathlib import Path


PNG_SIGNATURE = b"\x89PNG\r\n\x1a\n"


def read_entry_size(data: bytes, offset: int) -> int:
    return int.from_bytes(data[offset : offset + 2], "little")


def validate_png(path: Path) -> bool:
    with path.open("rb") as file:
        return file.read(len(PNG_SIGNATURE)) == PNG_SIGNATURE


def extract_pack(pack_path: Path, output_root: Path) -> tuple[int, int, list[str]]:
    pack_name = pack_path.stem
    output_dir = output_root / pack_name
    output_dir.mkdir(parents=True, exist_ok=True)

    data = pack_path.read_bytes()
    offset = 0
    entry_index = 0
    extracted = 0
    skipped = 0
    log_lines: list[str] = []

    while offset < len(data):
        if offset + 2 > len(data):
            skipped += 1
            log_lines.append(
                f"{pack_name}: trailing {len(data) - offset} byte(s) at offset {offset}; skipped"
            )
            break

        size = read_entry_size(data, offset)
        offset += 2

        if size == 0:
            skipped += 1
            log_lines.append(f"{pack_name}_{entry_index:03d}: empty entry; skipped")
            entry_index += 1
            continue

        if offset + size > len(data):
            skipped += 1
            log_lines.append(
                f"{pack_name}_{entry_index:03d}: invalid size {size} at offset {offset - 2}; "
                f"entry exceeds file length; stopped"
            )
            break

        payload = data[offset : offset + size]
        offset += size

        if not payload.startswith(PNG_SIGNATURE):
            skipped += 1
            log_lines.append(
                f"{pack_name}_{entry_index:03d}: invalid PNG signature; skipped"
            )
            entry_index += 1
            continue

        output_path = output_dir / f"{pack_name}_{entry_index:03d}.png"
        output_path.write_bytes(payload)

        if not validate_png(output_path):
            skipped += 1
            log_lines.append(
                f"{pack_name}_{entry_index:03d}: written file failed PNG validation"
            )
        else:
            extracted += 1

        entry_index += 1

    return extracted, skipped, log_lines


def validate_all_outputs(output_root: Path) -> list[str]:
    validation_errors: list[str] = []
    for png_path in sorted(output_root.glob("gpack*/gpack*.png")):
        if not validate_png(png_path):
            validation_errors.append(f"{png_path}: invalid PNG signature")
    return validation_errors


def main() -> int:
    script_dir = Path(__file__).resolve().parent
    parser = argparse.ArgumentParser(
        description="Extract PNG images from Prehistoric Fun Park gpack*.dat files."
    )
    parser.add_argument(
        "--input-dir",
        type=Path,
        default=script_dir / "prehistoric_vineflower",
        help="Directory containing gpack*.dat files.",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        default=script_dir / "assets_extracted",
        help="Directory where extracted PNG files and summary are written.",
    )
    args = parser.parse_args()

    input_dir = args.input_dir
    output_dir = args.output_dir
    output_dir.mkdir(parents=True, exist_ok=True)

    pack_paths = sorted(input_dir.glob("gpack*.dat"))
    if not pack_paths:
        raise FileNotFoundError(f"No gpack*.dat files found in {input_dir}")

    summary_lines = [
        "Prehistoric Fun Park gpack extraction summary",
        f"Input directory: {input_dir}",
        f"Output directory: {output_dir}",
        "",
    ]
    log_lines: list[str] = []

    for pack_path in pack_paths:
        extracted, skipped, pack_logs = extract_pack(pack_path, output_dir)
        image_word = "image" if extracted == 1 else "images"
        entry_word = "entry" if skipped == 1 else "entries"
        summary_lines.append(
            f"{pack_path.name}: extracted {extracted} {image_word}, skipped {skipped} {entry_word}"
        )
        log_lines.extend(pack_logs)

    validation_errors = validate_all_outputs(output_dir)
    summary_lines.append("")
    if validation_errors:
        summary_lines.append(f"Validation: {len(validation_errors)} invalid PNG file(s)")
        log_lines.extend(validation_errors)
    else:
        summary_lines.append("Validation: all extracted PNG files have a valid PNG signature")

    if log_lines:
        summary_lines.append(f"Log: {output_dir / 'extract_gpacks.log'}")
    else:
        summary_lines.append("Log: no skipped or invalid entries")

    (output_dir / "summary.txt").write_text(
        "\n".join(summary_lines) + "\n", encoding="utf-8-sig"
    )
    (output_dir / "extract_gpacks.log").write_text(
        "\n".join(log_lines) + ("\n" if log_lines else ""), encoding="utf-8-sig"
    )

    print("\n".join(summary_lines))
    return 1 if validation_errors else 0


if __name__ == "__main__":
    raise SystemExit(main())
