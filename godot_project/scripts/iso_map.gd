extends Node2D

# Owns the isometric grid and touch-to-tile conversion.

signal tile_touched(tile: Vector2i)
signal selection_cleared

const PATH_TEXTURE: Texture2D = preload("res://assets/original_sprites/path/gpack1_002.png")
const PATH_TEXTURE_REGION_0: Rect2 = Rect2(0.0, 104.0, 38.0, 20.0)
const PATH_TEXTURE_REGION_1: Rect2 = Rect2(38.0, 104.0, 38.0, 20.0)
const PATH_BORDER_REGION_A: Rect2 = Rect2(76.0, 111.0, 23.0, 13.0)
const PATH_BORDER_REGION_B: Rect2 = Rect2(98.0, 111.0, 23.0, 13.0)
const TERRAIN_TEXTURE: Texture2D = preload("res://assets/original_sprites/terrain/gpack2_000.png")
const TERRAIN_TEXTURE_REGION: Rect2 = Rect2(0.0, 0.0, 38.0, 20.0)

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


func configure(width: int, height: int) -> void:
	map_width = width
	map_height = height
	queue_redraw()


func tile_to_screen(tile: Vector2i) -> Vector2:
	return Vector2(
		(tile.x - tile.y) * tile_width * 0.5,
		(tile.x + tile.y) * tile_height * 0.5
	)


func screen_to_tile(screen_position: Vector2) -> Vector2i:
	var canvas_position: Vector2 = get_viewport().get_canvas_transform().affine_inverse() * screen_position
	var local_position: Vector2 = to_local(canvas_position)
	var half_width: float = tile_width * 0.5
	var half_height: float = tile_height * 0.5
	var tile_x: int = int(floor((local_position.x / half_width + local_position.y / half_height) * 0.5))
	var tile_y: int = int(floor((local_position.y / half_height - local_position.x / half_width) * 0.5))
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
		GameState.selected_catalog_id == "basic_path" or GameState.selected_catalog_id == "basic_attraction"
	)


func _draw() -> void:
	for x in range(map_width):
		for y in range(map_height):
			_draw_terrain_tile(Vector2i(x, y))

	_draw_path_tiles()
	_draw_attraction_tiles()
	_draw_entrance()

	if is_inside_map(selected_tile):
		_draw_selected_tile()

	if _is_build_preview_active() and is_inside_map(preview_tile):
		_draw_build_preview()


func _draw_terrain_tile(tile: Vector2i) -> void:
	var top := tile_to_screen(tile)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0),
		Vector2(tile_width, tile_height)
	)
	# TODO: Use the other gpack2_000 terrain rows when terrain types are modeled.
	draw_texture_rect_region(TERRAIN_TEXTURE, target_rect, TERRAIN_TEXTURE_REGION)


func _draw_path_tiles() -> void:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) == GameState.TILE_TYPE_PATH:
			var tile := Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
			if is_inside_map(tile):
				_draw_path_tile(tile, int(tile_data.get("path_variant", 0)))


func _draw_path_tile(tile: Vector2i, path_variant: int) -> void:
	var top := tile_to_screen(tile)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0),
		Vector2(tile_width, tile_height)
	)
	draw_texture_rect_region(PATH_TEXTURE, target_rect, _get_path_texture_region(path_variant))
	_draw_path_border_overlays(tile, target_rect.position)


func _get_path_texture_region(path_variant: int) -> Rect2:
	# TODO: Real path variations should come from c[][] / 4, as in the original JAR.
	if abs(path_variant) % 2 == 1:
		return PATH_TEXTURE_REGION_1
	return PATH_TEXTURE_REGION_0


func _draw_path_border_overlays(tile: Vector2i, base_position: Vector2) -> void:
	if GameState.get_tile_type(Vector2i(tile.x, tile.y - 1)) != GameState.TILE_TYPE_PATH:
		_draw_path_overlay(base_position, PATH_BORDER_REGION_A, Vector2(18.0, -1.0))
	if GameState.get_tile_type(Vector2i(tile.x - 1, tile.y)) != GameState.TILE_TYPE_PATH:
		_draw_path_overlay(base_position, PATH_BORDER_REGION_B, Vector2(-1.0, -2.0))
	if GameState.get_tile_type(Vector2i(tile.x, tile.y + 1)) != GameState.TILE_TYPE_PATH:
		_draw_path_overlay(base_position, PATH_BORDER_REGION_A, Vector2(-1.0, 7.0))
	if GameState.get_tile_type(Vector2i(tile.x + 1, tile.y)) != GameState.TILE_TYPE_PATH:
		_draw_path_overlay(base_position, PATH_BORDER_REGION_B, Vector2(17.0, 7.0))


func _draw_path_overlay(base_position: Vector2, source_region: Rect2, offset: Vector2) -> void:
	draw_texture_rect_region(
		PATH_TEXTURE,
		Rect2(base_position + offset, source_region.size),
		source_region
	)


func _draw_attraction_tiles() -> void:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) == GameState.TILE_TYPE_ATTRACTION:
			var tile := Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
			if is_inside_map(tile):
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


func _draw_entrance() -> void:
	var tile: Vector2i = GameState.ENTRY_TILE
	if not is_inside_map(tile):
		return
	var top := tile_to_screen(tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	draw_colored_polygon(points, Color(0.2, 0.28, 0.36, 1.0))
	draw_polyline(outline, Color(0.8, 0.9, 1.0, 1.0), 2.0)
	draw_rect(Rect2(top + Vector2(-16, -18), Vector2(4, 25)), Color(0.55, 0.34, 0.18, 1.0))
	draw_rect(Rect2(top + Vector2(12, -18), Vector2(4, 25)), Color(0.55, 0.34, 0.18, 1.0))
	draw_line(top + Vector2(-16, -18), top + Vector2(16, -18), Color(0.85, 0.72, 0.38, 1.0), 4.0)
	draw_string(ThemeDB.fallback_font, top + Vector2(-35, -25), "WELCOME", HORIZONTAL_ALIGNMENT_CENTER, 70.0, 10, Color(1.0, 0.95, 0.75, 1.0))


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
