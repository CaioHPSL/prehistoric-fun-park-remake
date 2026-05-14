extends Node2D

# Owns the isometric grid and touch-to-tile conversion.

signal tile_touched(tile: Vector2i)
signal selection_cleared

@export var map_width: int = 60
@export var map_height: int = 60
@export var tile_width: int = 40
@export var tile_height: int = 20
@export var tap_drag_threshold: float = 5.0

var selected_tile: Vector2i = Vector2i(-1, -1)
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
	elif event is InputEventMouseMotion and _press_active:
		_update_press_movement(event.position)


func _handle_screen_touch(event: InputEventScreenTouch) -> void:
	if event.pressed:
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
		_update_press_movement(event.position)


func _handle_mouse_button(event: InputEventMouseButton) -> void:
	if event.pressed:
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
	var tile := screen_to_tile(screen_position)
	print("tile calculated: ", tile)
	if is_inside_map(tile):
		print("inside map")
		select_tile(tile)
		tile_touched.emit(tile)
	else:
		print("outside map")
		clear_selected_tile()
		selection_cleared.emit()


func _draw() -> void:
	# Temporary placeholder grid. Real sprites come later.
	for x in range(map_width):
		for y in range(map_height):
			var top := tile_to_screen(Vector2i(x, y))
			var points := PackedVector2Array([
				top,
				top + Vector2(tile_width * 0.5, tile_height * 0.5),
				top + Vector2(0, tile_height),
				top + Vector2(-tile_width * 0.5, tile_height * 0.5),
			])
			var outline := PackedVector2Array(points)
			outline.append(points[0])
			var shade := 0.02 if (x + y) % 2 == 0 else 0.0
			draw_colored_polygon(points, Color(0.18 + shade, 0.45 + shade, 0.22 + shade, 1.0))
			draw_polyline(outline, Color(0.08, 0.18, 0.1, 1.0), 1.0)

	_draw_path_tiles()

	if is_inside_map(selected_tile):
		_draw_selected_tile()


func _draw_path_tiles() -> void:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) == GameState.TILE_TYPE_PATH:
			var tile := Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
			if is_inside_map(tile):
				_draw_path_tile(tile)


func _draw_path_tile(tile: Vector2i) -> void:
	var top := tile_to_screen(tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	draw_colored_polygon(points, Color(0.58, 0.48, 0.34, 1.0))
	draw_polyline(outline, Color(0.31, 0.24, 0.14, 1.0), 1.5)


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
