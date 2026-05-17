extends Node2D

# Owns the isometric grid and touch-to-tile conversion.

signal tile_touched(tile: Vector2i)
signal selection_cleared

const PATH_TEXTURE: Texture2D = preload("res://assets/original_sprites/path/gpack1_002.png")
const WATER_TEXTURE: Texture2D = preload("res://assets/original_sprites/path/gpack1_005.png")
const PATH_TEXTURE_REGION_0: Rect2 = Rect2(0.0, 104.0, 38.0, 20.0)
const PATH_TEXTURE_REGION_1: Rect2 = Rect2(38.0, 104.0, 38.0, 20.0)
const PATH_BORDER_REGION_A: Rect2 = Rect2(76.0, 111.0, 23.0, 13.0)
const PATH_BORDER_REGION_B: Rect2 = Rect2(98.0, 111.0, 23.0, 13.0)
const PATH_BENCH_C2_REGION: Rect2 = Rect2(0.0, 0.0, 18.0, 17.0)
const PATH_BENCH_C1_REGION: Rect2 = Rect2(0.0, 17.0, 17.0, 11.0)
const WATER_ANIMATION_SECONDS: float = 0.25
const WATER_TEXTURE_REGIONS: Array[Rect2] = [
	Rect2(0.0, 0.0, 38.0, 20.0),
	Rect2(0.0, 19.0, 38.0, 20.0),
	Rect2(0.0, 38.0, 38.0, 20.0),
]
const WATER_EDGE_REGION_A: Rect2 = Rect2(48.0, 29.0, 24.0, 18.0)
const WATER_EDGE_REGION_B: Rect2 = Rect2(48.0, 47.0, 24.0, 18.0)
const EXTERNAL_WALL_REGION_A: Rect2 = Rect2(0.0, 28.0, 27.0, 20.0)
const EXTERNAL_WALL_REGION_B: Rect2 = Rect2(0.0, 48.0, 27.0, 20.0)
const EXTERNAL_CORNER_REGION_A: Rect2 = Rect2(27.0, 29.0, 21.0, 17.0)
const EXTERNAL_CORNER_REGION_B: Rect2 = Rect2(27.0, 46.0, 20.0, 17.0)
const VISIBLE_TILE_MARGIN: int = 8
const EXTERNAL_DECOR_GRID_SIZE: int = 10
const EXTERNAL_ROAD_SIDE_DECOR_CODE: int = 11
const EXTERNAL_TOP_DECOR_CODE: int = 12
const TERRAIN_TEXTURE: Texture2D = preload("res://assets/original_sprites/terrain/gpack2_000.png")
const NATURAL_DECOR_TEXTURE: Texture2D = preload("res://assets/original_sprites/decor/gpack1_003.png")
const TERRAIN_TEXTURE_REGIONS: Array[Rect2] = [
	Rect2(0.0, 0.0, 38.0, 20.0),
	Rect2(0.0, 20.0, 38.0, 20.0),
	Rect2(0.0, 40.0, 38.0, 20.0),
]
const NATURAL_DECOR_PIECES: Array = [
	[[Rect2(52.0, 0.0, 15.0, 33.0), Vector2(15.0, -20.0)]],
	[[Rect2(36.0, 0.0, 16.0, 34.0), Vector2(9.0, -22.0)]],
	[[Rect2(41.0, 16.0, 11.0, 18.0), Vector2(14.0, -6.0)], [Rect2(62.0, 38.0, 18.0, 17.0), Vector2(9.0, -19.0)]],
	[[Rect2(52.0, 14.0, 11.0, 19.0), Vector2(15.0, -6.0)], [Rect2(80.0, 37.0, 19.0, 18.0), Vector2(13.0, -18.0)]],
	[[Rect2(36.0, 0.0, 31.0, 34.0), Vector2(3.0, -19.0)]],
	[[Rect2(36.0, 0.0, 16.0, 34.0), Vector2(3.0, -19.0)], [Rect2(52.0, 14.0, 11.0, 19.0), Vector2(20.0, -6.0)], [Rect2(80.0, 37.0, 19.0, 18.0), Vector2(18.0, -18.0)]],
	[[Rect2(41.0, 16.0, 11.0, 18.0), Vector2(8.0, -6.0)], [Rect2(62.0, 38.0, 18.0, 17.0), Vector2(3.0, -19.0)], [Rect2(52.0, 0.0, 15.0, 33.0), Vector2(20.0, -20.0)]],
	[[Rect2(41.0, 16.0, 11.0, 18.0), Vector2(8.0, -6.0)], [Rect2(62.0, 38.0, 18.0, 17.0), Vector2(3.0, -19.0)], [Rect2(52.0, 14.0, 11.0, 19.0), Vector2(20.0, -6.0)], [Rect2(80.0, 37.0, 19.0, 18.0), Vector2(18.0, -18.0)]],
	[[Rect2(67.0, 0.0, 40.0, 37.0), Vector2(-2.0, -20.0)]],
	[[Rect2(0.0, 0.0, 36.0, 37.0), Vector2(0.0, -20.0)]],
	[[Rect2(0.0, 37.0, 26.0, 18.0), Vector2(6.0, -2.0)]],
	[[Rect2(27.0, 34.0, 35.0, 22.0), Vector2(1.0, -5.0)]],
]
@export var map_width: int = 30
@export var map_height: int = 30
@export var tile_width: int = 40
@export var tile_height: int = 20
@export var tap_drag_threshold: float = 5.0

var selected_tile: Vector2i = Vector2i(-1, -1)
var preview_tile: Vector2i = Vector2i(-1, -1)
var _press_active := false
var _press_position := Vector2.ZERO
var _press_moved := false
var _active_touch_index := -1
var _water_frame: int = 0
var _water_frame_timer: float = 0.0
var _external_decor_codes: Array = []


func _ready() -> void:
	texture_filter = CanvasItem.TEXTURE_FILTER_NEAREST
	_generate_external_decor_codes()


func _process(delta: float) -> void:
	_water_frame_timer += delta
	if _water_frame_timer < WATER_ANIMATION_SECONDS:
		return
	_water_frame_timer = 0.0
	if GameState.has_water_tiles():
		_water_frame = (_water_frame + 1) % WATER_TEXTURE_REGIONS.size()
		queue_redraw()


func configure(width: int, height: int) -> void:
	map_width = width
	map_height = height
	queue_redraw()


func tile_to_screen(tile: Vector2i) -> Vector2:
	return Vector2(
		(tile.x + tile.y) * tile_width * 0.5,
		(tile.x - tile.y) * tile_height * 0.5
	)


func screen_to_tile(screen_position: Vector2) -> Vector2i:
	var canvas_position: Vector2 = get_viewport().get_canvas_transform().affine_inverse() * screen_position
	var local_position: Vector2 = to_local(canvas_position)
	return _local_to_tile(local_position)


func _local_to_tile(local_position: Vector2) -> Vector2i:
	var half_width: float = tile_width * 0.5
	var half_height: float = tile_height * 0.5
	var anchored_position: Vector2 = local_position - Vector2(0.0, half_height)
	var iso_x: float = anchored_position.x / half_width
	var iso_y: float = anchored_position.y / half_height
	var tile_x: int = int(floor(((iso_x + iso_y) * 0.5) + 0.5))
	var tile_y: int = int(floor(((iso_x - iso_y) * 0.5) + 0.5))
	return Vector2i(tile_x, tile_y)


func is_inside_map(tile: Vector2i) -> bool:
	return tile.x >= 0 and tile.y >= 0 and tile.x < map_width and tile.y < map_height


func select_tile(tile: Vector2i) -> void:
	if not is_inside_map(tile):
		clear_selected_tile()
		return
	selected_tile = tile
	queue_redraw()


func clear_selected_tile() -> void:
	selected_tile = Vector2i(-1, -1)
	queue_redraw()


func refresh_tiles() -> void:
	queue_redraw()


func _unhandled_input(event: InputEvent) -> void:
	if event is InputEventScreenTouch:
		_handle_screen_touch(event)
	elif event is InputEventScreenDrag:
		_handle_screen_drag(event)
	elif event is InputEventMouseButton:
		if event.button_index == MOUSE_BUTTON_LEFT:
			_handle_mouse_button(event)
	elif event is InputEventMouseMotion:
		_update_preview_from_screen_position(event.position)
		if _press_active:
			_update_press_movement(event.position)


func _handle_screen_touch(event: InputEventScreenTouch) -> void:
	if event.pressed:
		_update_preview_from_screen_position(event.position)
		_press_active = true
		_press_position = event.position
		_press_moved = false
		_active_touch_index = event.index
	elif _press_active and event.index == _active_touch_index:
		if not _press_moved:
			_select_from_screen_position(event.position)
		_press_active = false
		_active_touch_index = -1


func _handle_screen_drag(event: InputEventScreenDrag) -> void:
	if _press_active and event.index == _active_touch_index:
		_update_preview_from_screen_position(event.position)
		_update_press_movement(event.position)


func _handle_mouse_button(event: InputEventMouseButton) -> void:
	if event.pressed:
		_update_preview_from_screen_position(event.position)
		_press_active = true
		_press_position = event.position
		_press_moved = false
	elif _press_active:
		if not _press_moved:
			_select_from_screen_position(event.position)
		_press_active = false


func _update_press_movement(current_position: Vector2) -> void:
	if current_position.distance_to(_press_position) > tap_drag_threshold:
		_press_moved = true


func _select_from_screen_position(screen_position: Vector2) -> void:
	print("mouse click received")
	print("mouse position: ", screen_position)
	_update_preview_from_screen_position(screen_position)
	var tile: Vector2i = screen_to_tile(screen_position)
	if _is_build_preview_active() and is_inside_map(preview_tile):
		tile = preview_tile
	print("tile calculated: ", tile)
	if is_inside_map(tile):
		print("inside map")
		select_tile(tile)
		tile_touched.emit(tile)
	else:
		print("outside map")
		clear_selected_tile()
		selection_cleared.emit()


func _update_preview_from_screen_position(screen_position: Vector2) -> void:
	if not _is_build_preview_active():
		return
	var next_preview_tile: Vector2i = screen_to_tile(screen_position)
	if preview_tile == next_preview_tile:
		return
	preview_tile = next_preview_tile if is_inside_map(next_preview_tile) else Vector2i(-1, -1)
	queue_redraw()


func _is_build_preview_active() -> bool:
	return GameState.current_mode == "build" and (
		GameState.selected_catalog_id == "basic_path" or GameState.selected_catalog_id == "stone_path" or GameState.selected_catalog_id == "bench" or GameState.selected_catalog_id == "water" or GameState.selected_catalog_id == "basic_attraction"
	)


func _draw() -> void:
	var visible_bounds: Rect2i = _get_visible_tile_bounds()
	_draw_external_ground(visible_bounds)
	_draw_terrain_tiles(visible_bounds)
	_draw_external_road(visible_bounds)
	_draw_water_tiles(visible_bounds)
	_draw_path_tiles(visible_bounds)
	_draw_external_border(visible_bounds)
	_draw_external_decor_tiles(visible_bounds)
	_draw_natural_decor_tiles(visible_bounds)
	_draw_attraction_tiles(visible_bounds)

	if is_inside_map(selected_tile):
		_draw_selected_tile()

	if _is_build_preview_active() and is_inside_map(preview_tile):
		_draw_build_preview()


func _get_visible_tile_bounds() -> Rect2i:
	var viewport_rect: Rect2 = get_viewport_rect()
	var canvas_transform: Transform2D = get_viewport().get_canvas_transform()
	var viewport_corners: Array[Vector2] = [
		viewport_rect.position,
		viewport_rect.position + Vector2(viewport_rect.size.x, 0.0),
		viewport_rect.position + Vector2(0.0, viewport_rect.size.y),
		viewport_rect.position + viewport_rect.size,
	]
	var min_x: int = 1000000
	var min_y: int = 1000000
	var max_x: int = -1000000
	var max_y: int = -1000000
	for corner in viewport_corners:
		var canvas_position: Vector2 = canvas_transform.affine_inverse() * corner
		var local_position: Vector2 = to_local(canvas_position)
		var tile: Vector2i = _local_to_tile(local_position)
		min_x = mini(min_x, tile.x)
		min_y = mini(min_y, tile.y)
		max_x = maxi(max_x, tile.x)
		max_y = maxi(max_y, tile.y)
	min_x -= VISIBLE_TILE_MARGIN
	min_y -= VISIBLE_TILE_MARGIN
	max_x += VISIBLE_TILE_MARGIN
	max_y += VISIBLE_TILE_MARGIN
	return Rect2i(min_x, min_y, max_x - min_x + 1, max_y - min_y + 1)


func _bounds_end_x(bounds: Rect2i) -> int:
	return bounds.position.x + bounds.size.x - 1


func _bounds_end_y(bounds: Rect2i) -> int:
	return bounds.position.y + bounds.size.y - 1


func _tile_in_bounds(tile: Vector2i, bounds: Rect2i) -> bool:
	return tile.x >= bounds.position.x and tile.x <= _bounds_end_x(bounds) and tile.y >= bounds.position.y and tile.y <= _bounds_end_y(bounds)


func _draw_terrain_tiles(visible_bounds: Rect2i) -> void:
	var min_x: int = maxi(0, visible_bounds.position.x)
	var max_x: int = mini(map_width - 1, _bounds_end_x(visible_bounds))
	var min_y: int = maxi(0, visible_bounds.position.y)
	var max_y: int = mini(map_height - 1, _bounds_end_y(visible_bounds))
	if min_x > max_x or min_y > max_y:
		return
	for x in range(min_x, max_x + 1):
		for y in range(min_y, max_y + 1):
			_draw_terrain_tile(Vector2i(x, y))


func _draw_terrain_tile(tile: Vector2i) -> void:
	var top := tile_to_screen(tile)
	var source_region: Rect2 = _get_terrain_texture_region(tile)
	var target_rect: Rect2 = Rect2(
		(top + Vector2(tile_width * -0.5, 0.0)).round(),
		source_region.size
	)
	draw_texture_rect_region(TERRAIN_TEXTURE, target_rect, source_region)


func _get_terrain_texture_region(tile: Vector2i) -> Rect2:
	if GameState.get_terrain_decor_code(tile) > 0:
		return TERRAIN_TEXTURE_REGIONS[0]
	var terrain_code: int = GameState.get_terrain_code(tile)
	return TERRAIN_TEXTURE_REGIONS[terrain_code - 1]


func _draw_natural_decor_tiles(visible_bounds: Rect2i) -> void:
	var min_x: int = maxi(0, visible_bounds.position.x)
	var max_x: int = mini(map_width - 1, _bounds_end_x(visible_bounds))
	var min_y: int = maxi(0, visible_bounds.position.y)
	var max_y: int = mini(map_height - 1, _bounds_end_y(visible_bounds))
	if min_x > max_x or min_y > max_y:
		return
	for x in range(min_x, max_x + 1):
		for y in range(min_y, max_y + 1):
			var tile: Vector2i = Vector2i(x, y)
			var decor_code: int = GameState.get_terrain_decor_code(tile)
			if decor_code > 0:
				_draw_natural_decor_tile(tile, decor_code)


func _draw_natural_decor_tile(tile: Vector2i, decor_code: int) -> void:
	var decor_index: int = decor_code - 1
	if decor_index < 0 or decor_index >= NATURAL_DECOR_PIECES.size():
		return
	var base_position: Vector2 = tile_to_screen(tile) + Vector2(tile_width * -0.5, 0.0)
	var decor_pieces: Array = NATURAL_DECOR_PIECES[decor_index] as Array
	for piece_entry in decor_pieces:
		var piece: Array = piece_entry as Array
		var source_region: Rect2 = piece[0] as Rect2
		var offset: Vector2 = piece[1] as Vector2
		draw_texture_rect_region(
			NATURAL_DECOR_TEXTURE,
			Rect2((base_position + offset).round(), source_region.size),
			source_region
		)


func _draw_external_ground(visible_bounds: Rect2i) -> void:
	for x in range(visible_bounds.position.x, _bounds_end_x(visible_bounds) + 1):
		for y in range(visible_bounds.position.y, _bounds_end_y(visible_bounds) + 1):
			var tile: Vector2i = Vector2i(x, y)
			if not is_inside_map(tile):
				_draw_external_tile(TERRAIN_TEXTURE, tile, TERRAIN_TEXTURE_REGIONS[0], Vector2.ZERO)


func _draw_external_road(visible_bounds: Rect2i) -> void:
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	if _tile_in_bounds(entry_tile, visible_bounds):
		_draw_entry_path_tile(entry_tile)
	if entry_tile.x < visible_bounds.position.x or entry_tile.x > _bounds_end_x(visible_bounds):
		return
	var min_road_y: int = visible_bounds.position.y
	var max_road_y: int = mini(-1, _bounds_end_y(visible_bounds))
	if min_road_y > max_road_y:
		return
	for road_y in range(min_road_y, max_road_y + 1):
		_draw_external_road_tile(Vector2i(entry_tile.x, road_y))


func _draw_external_road_tile(road_tile: Vector2i) -> void:
	_draw_external_tile(PATH_TEXTURE, road_tile, PATH_TEXTURE_REGION_0, Vector2.ZERO)
	_draw_external_tile(PATH_TEXTURE, road_tile, PATH_BORDER_REGION_B, Vector2(-1.0, -2.0))
	_draw_external_tile(PATH_TEXTURE, road_tile, PATH_BORDER_REGION_B, Vector2(17.0, 7.0))


func _draw_external_border(visible_bounds: Rect2i) -> void:
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	var min_x: int = maxi(0, visible_bounds.position.x)
	var max_x: int = mini(map_width - 1, _bounds_end_x(visible_bounds))
	if min_x <= max_x and visible_bounds.position.y <= -1 and _bounds_end_y(visible_bounds) >= -1:
		for x in range(min_x, max_x + 1):
			if x != entry_tile.x:
				_draw_external_tile(PATH_TEXTURE, Vector2i(x, -1), EXTERNAL_WALL_REGION_B, Vector2(3.0, -3.0))
	if min_x <= max_x and visible_bounds.position.y <= map_height and _bounds_end_y(visible_bounds) >= map_height:
		for x in range(min_x, max_x + 1):
			_draw_external_tile(PATH_TEXTURE, Vector2i(x, map_height), EXTERNAL_WALL_REGION_B, Vector2(1.0, -1.0))
	var min_y: int = maxi(0, visible_bounds.position.y)
	var max_y: int = mini(map_height - 1, _bounds_end_y(visible_bounds))
	if min_y <= max_y and visible_bounds.position.x <= -1 and _bounds_end_x(visible_bounds) >= -1:
		for y in range(min_y, max_y + 1):
			_draw_external_tile(PATH_TEXTURE, Vector2i(-1, y), EXTERNAL_WALL_REGION_A, Vector2(13.0, -2.0))
	if min_y <= max_y and visible_bounds.position.x <= map_width and _bounds_end_x(visible_bounds) >= map_width:
		for y in range(min_y, max_y + 1):
			_draw_external_tile(PATH_TEXTURE, Vector2i(map_width, y), EXTERNAL_WALL_REGION_A, Vector2(11.0, -3.0))
	if _tile_in_bounds(Vector2i(-1, -1), visible_bounds):
		_draw_external_corner(Vector2i(-1, -1), EXTERNAL_CORNER_REGION_A, Vector2(19.0, -3.0), EXTERNAL_CORNER_REGION_B, Vector2(17.0, 4.0))
	if _tile_in_bounds(Vector2i(map_width, -1), visible_bounds):
		_draw_external_corner(Vector2i(map_width, -1), EXTERNAL_CORNER_REGION_B, Vector2(3.0, -4.0), EXTERNAL_CORNER_REGION_A, Vector2(16.0, -4.0))
	if _tile_in_bounds(Vector2i(-1, map_height), visible_bounds):
		_draw_external_corner(Vector2i(-1, map_height), EXTERNAL_CORNER_REGION_A, Vector2(5.0, 5.0), EXTERNAL_CORNER_REGION_B, Vector2(13.0, 5.0))
	if _tile_in_bounds(Vector2i(map_width, map_height), visible_bounds):
		_draw_external_corner(Vector2i(map_width, map_height), EXTERNAL_CORNER_REGION_B, Vector2(-1.0, -2.0), EXTERNAL_CORNER_REGION_A, Vector2(3.0, 3.0))


func _draw_external_decor_tiles(visible_bounds: Rect2i) -> void:
	_ensure_external_decor_codes()
	for x in range(visible_bounds.position.x, _bounds_end_x(visible_bounds) + 1):
		for y in range(visible_bounds.position.y, _bounds_end_y(visible_bounds) + 1):
			var tile: Vector2i = Vector2i(x, y)
			var decor_code: int = _get_external_decor_code(tile)
			if decor_code > 0:
				_draw_natural_decor_tile(tile, decor_code)


func _generate_external_decor_codes() -> void:
	_external_decor_codes = []
	var rng := RandomNumberGenerator.new()
	rng.randomize()
	for x in range(EXTERNAL_DECOR_GRID_SIZE):
		var column: Array = []
		for y in range(EXTERNAL_DECOR_GRID_SIZE):
			column.append(rng.randi_range(1, 12))
		_external_decor_codes.append(column)


func _ensure_external_decor_codes() -> void:
	if _external_decor_codes.size() == EXTERNAL_DECOR_GRID_SIZE:
		return
	_generate_external_decor_codes()


func _get_external_decor_code(tile: Vector2i) -> int:
	if is_inside_map(tile):
		return 0
	if tile.x == -1 or tile.y == -1 or tile.x == map_width or tile.y == map_height:
		return 0
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	if tile.x == entry_tile.x and tile.y <= 0:
		return 0
	if (tile.x == entry_tile.x - 1 or tile.x == entry_tile.x + 1) and tile.y < 0:
		return EXTERNAL_ROAD_SIDE_DECOR_CODE
	if tile.y == -2 and tile.x >= 0 and tile.x < map_width:
		return EXTERNAL_TOP_DECOR_CODE
	var column: Array = _external_decor_codes[posmod(tile.x, EXTERNAL_DECOR_GRID_SIZE)] as Array
	return int(column[posmod(tile.y, EXTERNAL_DECOR_GRID_SIZE)])


func _draw_external_corner(tile: Vector2i, first_region: Rect2, first_offset: Vector2, second_region: Rect2, second_offset: Vector2) -> void:
	_draw_external_tile(PATH_TEXTURE, tile, first_region, first_offset)
	_draw_external_tile(PATH_TEXTURE, tile, second_region, second_offset)


func _draw_external_tile(texture: Texture2D, tile: Vector2i, source_region: Rect2, offset: Vector2) -> void:
	var top: Vector2 = tile_to_screen(tile)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0) + offset,
		source_region.size
	)
	draw_texture_rect_region(texture, target_rect, source_region)


func _draw_entry_path_tile(tile: Vector2i) -> void:
	if not is_inside_map(tile):
		return
	var top: Vector2 = tile_to_screen(tile)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0),
		PATH_TEXTURE_REGION_0.size
	)
	draw_texture_rect_region(PATH_TEXTURE, target_rect, PATH_TEXTURE_REGION_0)
	_draw_path_border_overlays(tile, target_rect.position)


func _draw_path_tiles(visible_bounds: Rect2i) -> void:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) == GameState.TILE_TYPE_PATH:
			var tile := Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
			if is_inside_map(tile) and _tile_in_bounds(tile, visible_bounds):
				var path_meta: int = _get_path_meta(tile_data)
				_draw_path_tile(tile, floori(float(maxi(0, path_meta)) / 4.0), _get_path_mask(tile_data))


func _draw_path_tile(tile: Vector2i, path_variant: int, path_mask: int) -> void:
	var top := tile_to_screen(tile)
	var source_region: Rect2 = _get_path_texture_region(path_variant)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0),
		source_region.size
	)
	draw_texture_rect_region(PATH_TEXTURE, target_rect, source_region)
	_draw_path_border_overlays(tile, target_rect.position)
	_draw_path_addon_overlays(target_rect.position, path_mask)


func _get_path_texture_region(path_variant: int) -> Rect2:
	if abs(path_variant) % 2 == 1:
		return PATH_TEXTURE_REGION_1
	return PATH_TEXTURE_REGION_0


func _get_path_meta(tile_data: Dictionary) -> int:
	if tile_data.has("path_meta"):
		return int(tile_data.get("path_meta", 0))
	var path_variant: int = int(tile_data.get("path_variant", 0))
	var path_mask: int = int(tile_data.get("path_mask", 0))
	return maxi(0, path_variant) * 4 + clampi(path_mask, 0, 3)


func _get_path_mask(tile_data: Dictionary) -> int:
	if tile_data.has("path_mask"):
		return clampi(int(tile_data.get("path_mask", 0)), 0, 3)
	return maxi(0, int(tile_data.get("path_meta", 0))) % 4


func _draw_path_border_overlays(tile: Vector2i, base_position: Vector2) -> void:
	if not _is_path_visually_connected(tile, Vector2i(tile.x, tile.y + 1)):
		_draw_path_overlay(base_position, PATH_BORDER_REGION_A, Vector2(18.0, -1.0))
	if not _is_path_visually_connected(tile, Vector2i(tile.x - 1, tile.y)):
		_draw_path_overlay(base_position, PATH_BORDER_REGION_B, Vector2(-1.0, -2.0))
	if not _is_path_visually_connected(tile, Vector2i(tile.x, tile.y - 1)):
		_draw_path_overlay(base_position, PATH_BORDER_REGION_A, Vector2(-1.0, 7.0))
	if not _is_path_visually_connected(tile, Vector2i(tile.x + 1, tile.y)):
		_draw_path_overlay(base_position, PATH_BORDER_REGION_B, Vector2(17.0, 7.0))


func _draw_path_addon_overlays(base_position: Vector2, path_mask: int) -> void:
	if (path_mask & GameState.PATH_BENCH_MASK_C2) != 0:
		_draw_path_overlay(base_position, PATH_BENCH_C2_REGION, Vector2(1.0, -8.0))
	if (path_mask & GameState.PATH_BENCH_MASK_C1) != 0:
		_draw_path_overlay(base_position, PATH_BENCH_C1_REGION, Vector2(19.0, -2.0))


func _is_path_visually_connected(source_tile: Vector2i, neighbor_tile: Vector2i) -> bool:
	if GameState.get_tile_type(neighbor_tile) == GameState.TILE_TYPE_PATH:
		return true
	if GameState.is_entrance_tile(neighbor_tile):
		return true
	if GameState.is_entrance_tile(source_tile) and _is_external_entry_road_tile(neighbor_tile):
		return true
	return false


func _is_external_entry_road_tile(tile: Vector2i) -> bool:
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	return tile.x == entry_tile.x and tile.y < entry_tile.y


func _draw_path_overlay(base_position: Vector2, source_region: Rect2, offset: Vector2) -> void:
	draw_texture_rect_region(
		PATH_TEXTURE,
		Rect2(base_position + offset, source_region.size),
		source_region
	)


func _draw_water_tiles(visible_bounds: Rect2i) -> void:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) == GameState.TILE_TYPE_WATER:
			var tile := Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
			if is_inside_map(tile) and _tile_in_bounds(tile, visible_bounds):
				_draw_water_tile(tile)


func _draw_water_tile(tile: Vector2i) -> void:
	var top := tile_to_screen(tile)
	var base_position: Vector2 = top + Vector2(tile_width * -0.5, 0.0)
	var source_region: Rect2 = WATER_TEXTURE_REGIONS[_water_frame]
	draw_texture_rect_region(
		WATER_TEXTURE,
		Rect2((base_position + Vector2(0.0, -1.0)).round(), source_region.size),
		source_region
	)
	if not _is_water_neighbor(Vector2i(tile.x, tile.y + 1)):
		_draw_water_overlay(base_position, WATER_EDGE_REGION_A, Vector2(18.0, -7.0))
	if not _is_water_neighbor(Vector2i(tile.x - 1, tile.y)):
		_draw_water_overlay(base_position, WATER_EDGE_REGION_B, Vector2(-2.0, -7.0))
	if not _is_water_neighbor(Vector2i(tile.x, tile.y - 1)):
		_draw_water_overlay(base_position, WATER_EDGE_REGION_A, Vector2(-3.0, 3.0))
	if not _is_water_neighbor(Vector2i(tile.x + 1, tile.y)):
		_draw_water_overlay(base_position, WATER_EDGE_REGION_B, Vector2(17.0, 3.0))


func _is_water_neighbor(tile: Vector2i) -> bool:
	return GameState.get_tile_type(tile) == GameState.TILE_TYPE_WATER


func _draw_water_overlay(base_position: Vector2, source_region: Rect2, offset: Vector2) -> void:
	draw_texture_rect_region(
		PATH_TEXTURE,
		Rect2((base_position + offset).round(), source_region.size),
		source_region
	)


func _draw_attraction_tiles(visible_bounds: Rect2i) -> void:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) == GameState.TILE_TYPE_ATTRACTION:
			var tile := Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
			if is_inside_map(tile) and _tile_in_bounds(tile, visible_bounds):
				_draw_attraction_tile(tile)


func _draw_attraction_tile(tile: Vector2i) -> void:
	var top := tile_to_screen(tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	draw_colored_polygon(points, Color(0.72, 0.32, 0.2, 1.0))
	draw_polyline(outline, Color(0.36, 0.12, 0.08, 1.0), 1.5)


func _draw_selected_tile() -> void:
	var top := tile_to_screen(selected_tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	draw_colored_polygon(points, Color(1.0, 0.86, 0.2, 0.35))
	draw_polyline(outline, Color(1.0, 0.86, 0.2, 1.0), 3.0)


func _draw_build_preview() -> void:
	if not _is_build_preview_active() or not is_inside_map(preview_tile):
		return
	var size: Vector2i = _get_preview_size()
	var can_build: bool = _can_build_preview(size)
	var fill_color: Color = Color(0.3, 0.95, 0.35, 0.38)
	var outline_color: Color = Color(0.15, 0.85, 0.25, 1.0)
	if GameState.selected_catalog_id == "water" and can_build:
		fill_color = Color(0.2, 0.55, 1.0, 0.38)
		outline_color = Color(0.1, 0.38, 0.95, 1.0)
	if GameState.selected_catalog_id == "bench" and can_build:
		fill_color = Color(0.62, 0.42, 0.22, 0.38)
		outline_color = Color(0.48, 0.28, 0.12, 1.0)
	if GameState.selected_catalog_id == "basic_attraction" and can_build:
		fill_color = Color(1.0, 0.86, 0.18, 0.38)
		outline_color = Color(0.95, 0.7, 0.08, 1.0)
	if not can_build:
		fill_color = Color(1.0, 0.15, 0.12, 0.42)
		outline_color = Color(1.0, 0.08, 0.06, 1.0)
	for x in range(preview_tile.x, preview_tile.x + size.x):
		for y in range(preview_tile.y, preview_tile.y + size.y):
			var area_tile: Vector2i = Vector2i(x, y)
			if is_inside_map(area_tile):
				_draw_preview_tile(area_tile, fill_color, outline_color)


func _get_preview_size() -> Vector2i:
	var building_data: Dictionary = Catalog.get_building(GameState.selected_catalog_id)
	var size_data: Array = building_data.get("size", [1, 1])
	return Vector2i(int(size_data[0]), int(size_data[1]))


func _can_build_preview(size: Vector2i) -> bool:
	var building_data: Dictionary = Catalog.get_building(GameState.selected_catalog_id)
	var cost: int = int(building_data.get("cost", 0))
	if not Economy.can_afford(cost):
		return false
	if GameState.selected_catalog_id == "bench":
		return GameState.can_add_path_addon(preview_tile, GameState.selected_path_addon_mask)
	if GameState.selected_catalog_id == "stone_path" and GameState.get_tile_type(preview_tile) == GameState.TILE_TYPE_PATH:
		return GameState.can_upgrade_path_tile(preview_tile, GameState.PATH_STONE_VARIANT)
	if GameState.selected_catalog_id == "water":
		return GameState.get_tile_type(preview_tile) == GameState.TILE_TYPE_PATH
	if preview_tile.x < 0 or preview_tile.y < 0:
		return false
	if preview_tile.x + size.x > map_width or preview_tile.y + size.y > map_height:
		return false
	for x in range(preview_tile.x, preview_tile.x + size.x):
		for y in range(preview_tile.y, preview_tile.y + size.y):
			var area_tile: Vector2i = Vector2i(x, y)
			if GameState.is_tile_reserved(area_tile) or GameState.is_tile_used(area_tile):
				return false
	return true


func _draw_preview_tile(tile: Vector2i, fill_color: Color, outline_color: Color) -> void:
	var top := tile_to_screen(tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	draw_colored_polygon(points, fill_color)
	draw_polyline(outline, outline_color, 3.0)
