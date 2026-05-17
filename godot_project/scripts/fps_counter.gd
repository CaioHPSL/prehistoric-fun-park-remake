extends CanvasLayer

@export var update_interval: float = 0.5

@onready var fps_label: Label = $FPSLabel

var _elapsed: float = 0.0


func _ready() -> void:
	process_mode = Node.PROCESS_MODE_ALWAYS
	_update_fps_label()


func _process(delta: float) -> void:
	_elapsed += delta
	if _elapsed < update_interval:
		return
	_elapsed = 0.0
	_update_fps_label()


func _input(event: InputEvent) -> void:
	if event is InputEventKey and event.pressed and not event.echo and event.keycode == KEY_F3:
		visible = not visible
		get_viewport().set_input_as_handled()


func _update_fps_label() -> void:
	fps_label.text = "FPS: %d" % Engine.get_frames_per_second()
