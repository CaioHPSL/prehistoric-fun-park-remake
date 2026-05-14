extends Camera2D

# Simple touch and mouse drag camera. Bounds will be tuned once the map is playable.

@export var drag_speed: float = 1.0
@export var min_zoom: float = 0.75
@export var max_zoom: float = 1.5
@export var drag_threshold: float = 5.0
@export var zoom_step: float = 0.1

var _pressing := false
var _dragging := false
var _press_position := Vector2.ZERO
var _active_touch_index := -1
var _touch_points: Dictionary = {}
var _pinching := false
var _last_pinch_distance: float = 0.0


func _ready() -> void:
	make_current()


func _unhandled_input(event: InputEvent) -> void:
	if event is InputEventScreenTouch:
		_handle_screen_touch(event)
	elif event is InputEventScreenDrag:
		if _pinching:
			_update_touch_position(event.index, event.position)
			_handle_pinch_zoom()
		elif event.index == _active_touch_index:
			_handle_drag_motion(event.position, event.relative)
	elif event is InputEventMouseButton:
		if event.button_index == MOUSE_BUTTON_WHEEL_UP and event.pressed:
			set_zoom_level(zoom.x + zoom_step)
		elif event.button_index == MOUSE_BUTTON_WHEEL_DOWN and event.pressed:
			set_zoom_level(zoom.x - zoom_step)
		elif event.button_index == MOUSE_BUTTON_LEFT:
			if event.pressed:
				_pressing = true
				_dragging = false
				_press_position = event.position
			else:
				_pressing = false
				_dragging = false
	elif event is InputEventMouseMotion and _pressing:
		_handle_drag_motion(event.position, event.relative)


func _handle_screen_touch(event: InputEventScreenTouch) -> void:
	if event.pressed:
		_touch_points[event.index] = event.position
		if _touch_points.size() == 1:
			_pressing = true
			_dragging = false
			_press_position = event.position
			_active_touch_index = event.index
		elif _touch_points.size() == 2:
			_start_pinch_zoom()
	else:
		_touch_points.erase(event.index)
		if _touch_points.size() < 2:
			_pinching = false
			_last_pinch_distance = 0.0
		if event.index == _active_touch_index:
			_pressing = false
			_dragging = false
			_active_touch_index = -1
		if _touch_points.size() == 1:
			var remaining_index: int = int(_touch_points.keys()[0])
			_active_touch_index = remaining_index
			_pressing = true
			_dragging = false
			_press_position = _touch_points[remaining_index] as Vector2


func _handle_drag_motion(pointer_position: Vector2, relative_motion: Vector2) -> void:
	if not _dragging and pointer_position.distance_to(_press_position) > drag_threshold:
		_dragging = true
	if _dragging:
		position -= relative_motion * drag_speed / zoom.x


func _update_touch_position(touch_index: int, touch_position: Vector2) -> void:
	if _touch_points.has(touch_index):
		_touch_points[touch_index] = touch_position


func _start_pinch_zoom() -> void:
	_pinching = true
	_pressing = false
	_dragging = false
	_last_pinch_distance = _get_pinch_distance()


func _handle_pinch_zoom() -> void:
	var current_distance: float = _get_pinch_distance()
	if _last_pinch_distance <= 0.0 or current_distance <= 0.0:
		_last_pinch_distance = current_distance
		return
	var zoom_factor: float = current_distance / _last_pinch_distance
	set_zoom_level(zoom.x * zoom_factor)
	_last_pinch_distance = current_distance


func _get_pinch_distance() -> float:
	if _touch_points.size() < 2:
		return 0.0
	var touch_keys: Array = _touch_points.keys()
	var first_position: Vector2 = _touch_points[touch_keys[0]] as Vector2
	var second_position: Vector2 = _touch_points[touch_keys[1]] as Vector2
	return first_position.distance_to(second_position)


func set_zoom_level(value: float) -> void:
	var clamped: float = clampf(value, min_zoom, max_zoom)
	zoom = Vector2(clamped, clamped)
