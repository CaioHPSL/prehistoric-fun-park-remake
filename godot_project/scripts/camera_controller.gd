extends Camera2D

# Simple touch and mouse drag camera. Bounds will be tuned once the map is playable.

@export var drag_speed: float = 1.0
@export var min_zoom: float = 0.75
@export var max_zoom: float = 1.5
@export var drag_threshold: float = 5.0

var _pressing := false
var _dragging := false
var _press_position := Vector2.ZERO
var _active_touch_index := -1


func _ready() -> void:
	make_current()


func _unhandled_input(event: InputEvent) -> void:
	if event is InputEventScreenTouch:
		if event.pressed:
			_pressing = true
			_dragging = false
			_press_position = event.position
			_active_touch_index = event.index
		elif event.index == _active_touch_index:
			_pressing = false
			_dragging = false
			_active_touch_index = -1
	elif event is InputEventScreenDrag:
		if event.index == _active_touch_index:
			_handle_drag_motion(event.position, event.relative)
	elif event is InputEventMouseButton:
		if event.button_index == MOUSE_BUTTON_LEFT:
			if event.pressed:
				_pressing = true
				_dragging = false
				_press_position = event.position
			else:
				_pressing = false
				_dragging = false
	elif event is InputEventMouseMotion and _pressing:
		_handle_drag_motion(event.position, event.relative)


func _handle_drag_motion(pointer_position: Vector2, relative_motion: Vector2) -> void:
	if not _dragging and pointer_position.distance_to(_press_position) > drag_threshold:
		_dragging = true
	if _dragging:
		position -= relative_motion * drag_speed / zoom.x


func set_zoom_level(value: float) -> void:
	var clamped: float = clampf(value, min_zoom, max_zoom)
	zoom = Vector2(clamped, clamped)
