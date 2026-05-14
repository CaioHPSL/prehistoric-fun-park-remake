extends Node2D

# Placeholder for simple visitor spawning and movement.

signal visitor_paid(amount: int)
signal visitor_stats_changed(active_count: int, served_count: int)

const VISITOR_PAYOUT: int = 25

@export var visitor_scene: PackedScene
@export var move_speed: float = 80.0
@export var spawn_interval: float = 4.0
@export var max_active_visitors: int = 3

var iso_map: Node
var active_visitors: Array[Node2D] = []
var spawn_timer: Timer
var total_visitors_served: int = 0
var visitors_served_by_attraction: Dictionary = {}


func _ready() -> void:
	spawn_timer = Timer.new()
	spawn_timer.wait_time = spawn_interval
	spawn_timer.one_shot = false
	spawn_timer.timeout.connect(spawn_single_visitor)
	add_child(spawn_timer)
	start_spawning()


func configure(map_node: Node) -> void:
	iso_map = map_node


func _process(delta: float) -> void:
	for i in range(active_visitors.size() - 1, -1, -1):
		var visitor: Node2D = active_visitors[i]
		if not is_instance_valid(visitor):
			active_visitors.remove_at(i)
			_emit_visitor_stats()
			continue
		var visitor_target_position: Vector2 = visitor.get_meta("target_position", Vector2.ZERO) as Vector2
		visitor.position = visitor.position.move_toward(visitor_target_position, move_speed * delta)
		if visitor.position.distance_to(visitor_target_position) <= 1.0:
			_finish_visit(visitor)


func start_spawning() -> void:
	if spawn_timer != null and spawn_timer.is_stopped():
		spawn_timer.start()


func stop_spawning() -> void:
	if spawn_timer != null:
		spawn_timer.stop()
	clear_visitor()


func spawn_single_visitor() -> void:
	if active_visitors.size() >= max_active_visitors or iso_map == null:
		return
	var attraction: Dictionary = GameState.get_first_connected_basic_attraction()
	if attraction.is_empty():
		return
	var target_origin: Vector2i = Vector2i(int(attraction.get("x", -1)), int(attraction.get("y", -1)))
	var visitor: Node2D = _create_visitor()
	add_child(visitor)
	visitor.position = _tile_to_local_position(Vector2i(0, 0))
	visitor.set_meta("target_origin", target_origin)
	visitor.set_meta("target_position", _tile_to_local_position(target_origin))
	active_visitors.append(visitor)
	_emit_visitor_stats()


func clear_visitor() -> void:
	for i in range(active_visitors.size() - 1, -1, -1):
		var visitor: Node2D = active_visitors[i]
		if is_instance_valid(visitor):
			visitor.queue_free()
	active_visitors.clear()
	_emit_visitor_stats()


func get_total_visitors_served() -> int:
	return total_visitors_served


func get_visitors_served_for_attraction(origin: Vector2i) -> int:
	return int(visitors_served_by_attraction.get(_attraction_key(origin), 0))


func get_visitors_served_by_attraction() -> Dictionary:
	return visitors_served_by_attraction.duplicate(true)


func set_total_visitors_served(served_count: int) -> void:
	total_visitors_served = served_count
	_emit_visitor_stats()


func set_visitors_served_by_attraction(saved_counts: Dictionary) -> void:
	visitors_served_by_attraction = {}
	for key in saved_counts.keys():
		visitors_served_by_attraction[String(key)] = int(saved_counts[key])


func _create_visitor() -> Node2D:
	if visitor_scene != null:
		var instance: Node = visitor_scene.instantiate()
		if instance is Node2D:
			return instance as Node2D
		instance.queue_free()
	var visitor: Node2D = Node2D.new()
	var shape: Polygon2D = Polygon2D.new()
	shape.color = Color(0.15, 0.75, 1.0, 1.0)
	shape.polygon = PackedVector2Array([Vector2(0, -8), Vector2(6, 4), Vector2(-6, 4)])
	visitor.add_child(shape)
	return visitor


func _tile_to_local_position(tile: Vector2i) -> Vector2:
	var tile_position: Vector2 = iso_map.call("tile_to_screen", tile)
	var tile_height: float = float(iso_map.get("tile_height"))
	var centered_position: Vector2 = tile_position + Vector2(0.0, tile_height * 0.5)
	return to_local(iso_map.to_global(centered_position))


func _finish_visit(visitor: Node2D) -> void:
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	if GameState.has_connected_basic_attraction(target_origin):
		total_visitors_served += 1
		_add_attraction_served(target_origin)
		visitor_paid.emit(VISITOR_PAYOUT)
	active_visitors.erase(visitor)
	visitor.queue_free()
	_emit_visitor_stats()


func _add_attraction_served(origin: Vector2i) -> void:
	var key: String = _attraction_key(origin)
	visitors_served_by_attraction[key] = int(visitors_served_by_attraction.get(key, 0)) + 1


func _attraction_key(origin: Vector2i) -> String:
	return "%d,%d" % [origin.x, origin.y]


func _emit_visitor_stats() -> void:
	visitor_stats_changed.emit(active_visitors.size(), total_visitors_served)
