extends CanvasLayer

@export var update_interval: float = 0.5
@export var debug_visitor_stats: bool = true

@onready var fps_label: Label = $FPSLabel

var _elapsed: float = 0.0
var visitor_system: Node


func _ready() -> void:
	process_mode = Node.PROCESS_MODE_ALWAYS
	visitor_system = get_parent().get_node_or_null("VisitorSystem")
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
	elif event is InputEventKey and event.pressed and not event.echo and event.keycode == KEY_F4:
		debug_visitor_stats = not debug_visitor_stats
		_update_fps_label()
		get_viewport().set_input_as_handled()


func _update_fps_label() -> void:
	var label_text: String = "FPS: %d" % Engine.get_frames_per_second()
	if debug_visitor_stats and visitor_system != null and visitor_system.has_method("get_visitor_debug_stats"):
		var stats: Dictionary = visitor_system.get_visitor_debug_stats()
		if bool(stats.get("debug_visitor_stats", true)):
			label_text += "\nVisitors: %d/%d" % [
				int(stats.get("active_visitors", 0)),
				int(stats.get("max_active_visitors", 0)),
			]
			label_text += "\nSpawned: %d  Exited: %d  Served: %d" % [
				int(stats.get("total_visitors_spawned", 0)),
				int(stats.get("total_visitors_exited", 0)),
				int(stats.get("total_visitors_served", 0)),
			]
			label_text += "\nSpawn: %d%%  Block: %s" % [
				roundi(float(stats.get("current_spawn_chance", 0.0)) * 100.0),
				String(stats.get("last_spawn_block_reason", "none")),
			]
			label_text += "\nStress: %s  Target: %d  Interval: %.2fs" % [
				"on" if bool(stats.get("visitor_stress_test_mode", false)) else "off",
				int(stats.get("stress_min_active_visitors", 0)),
				float(stats.get("current_spawn_interval", 0.0)),
			]
	fps_label.text = label_text
