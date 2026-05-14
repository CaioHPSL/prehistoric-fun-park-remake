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
			_advance_visitor_route(visitor)


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
	var target_origin: Vector2i = _find_reachable_attraction_origin()
	if target_origin == Vector2i(-1, -1):
		return
	var visitor: Node2D = _create_visitor()
	add_child(visitor)
	visitor.position = _tile_to_local_position(GameState.ENTRY_TILE)
	visitor.set_meta("current_tile", GameState.ENTRY_TILE)
	visitor.set_meta("target_tile", GameState.ENTRY_TILE)
	visitor.set_meta("target_origin", target_origin)
	visitor.set_meta("returning", false)
	visitor.set_meta("paid", false)
	if not _recalculate_next_step(visitor):
		visitor.queue_free()
		return
	active_visitors.append(visitor)
	_emit_visitor_stats()


func clear_visitor() -> void:
	for i in range(active_visitors.size() - 1, -1, -1):
		var visitor: Node2D = active_visitors[i]
		if is_instance_valid(visitor):
			visitor.queue_free()
	active_visitors.clear()
	_emit_visitor_stats()


func revalidate_active_routes() -> void:
	var changed: bool = false
	for i in range(active_visitors.size() - 1, -1, -1):
		var visitor: Node2D = active_visitors[i]
		if not is_instance_valid(visitor):
			active_visitors.remove_at(i)
			changed = true
			continue
		if not _recalculate_next_step(visitor):
			active_visitors.remove_at(i)
			print("Visitor removed: no route to attraction or entrance")
			visitor.queue_free()
			changed = true
	if changed:
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


func _advance_visitor_route(visitor: Node2D) -> void:
	var reached_tile: Vector2i = visitor.get_meta("target_tile", GameState.ENTRY_TILE) as Vector2i
	visitor.set_meta("current_tile", reached_tile)
	if bool(visitor.get_meta("returning", false)) and reached_tile == GameState.ENTRY_TILE:
		_finish_visit(visitor)
		return
	if not _recalculate_next_step(visitor):
		active_visitors.erase(visitor)
		print("Visitor removed: no route to attraction or entrance")
		visitor.queue_free()
		_emit_visitor_stats()


func _recalculate_next_step(visitor: Node2D) -> bool:
	var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
	if not _can_stand_on_tile(current_tile):
		visitor.set_meta("returning", true)
		return _set_next_step_to_entry(visitor, current_tile)
	if bool(visitor.get_meta("returning", false)):
		return _set_next_step_to_entry(visitor, current_tile)
	if _is_at_destination_path(visitor, current_tile):
		_pay_visit(visitor)
		visitor.set_meta("returning", true)
		return _set_next_step_to_entry(visitor, current_tile)
	if _set_next_step_to_destination(visitor, current_tile):
		return true
	visitor.set_meta("returning", true)
	print("Visitor returning: no route to attraction")
	return _set_next_step_to_entry(visitor, current_tile)


func _set_next_step_to_destination(visitor: Node2D, current_tile: Vector2i) -> bool:
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	var building_data: Dictionary = _get_basic_attraction_data(target_origin)
	if building_data.is_empty():
		return false
	var path_targets: Array = _get_adjacent_path_tiles(building_data)
	if current_tile == GameState.ENTRY_TILE:
		if not _is_path_tile(GameState.INITIAL_PATH_TILE):
			return false
		if _find_path_route(GameState.INITIAL_PATH_TILE, path_targets).is_empty():
			return false
		return _set_next_tile(visitor, GameState.INITIAL_PATH_TILE)
	if not _is_path_tile(current_tile):
		return false
	var route: Array = _find_path_route(current_tile, path_targets)
	if route.is_empty():
		return false
	if route.size() == 1:
		return true
	var next_tile: Vector2i = route[1]
	return _set_next_tile(visitor, next_tile)


func _set_next_step_to_entry(visitor: Node2D, current_tile: Vector2i) -> bool:
	if current_tile == GameState.ENTRY_TILE:
		_finish_visit(visitor)
		return true
	if current_tile == GameState.INITIAL_PATH_TILE:
		return _set_next_tile(visitor, GameState.ENTRY_TILE)
	if not _is_path_tile(current_tile) or not _is_path_tile(GameState.INITIAL_PATH_TILE):
		print("Visitor removed: no route back to entrance")
		return false
	var route: Array = _find_path_route(current_tile, [GameState.INITIAL_PATH_TILE])
	if route.is_empty():
		print("Visitor removed: no route back to entrance")
		return false
	if route.size() == 1:
		return _set_next_tile(visitor, GameState.ENTRY_TILE)
	var next_tile: Vector2i = route[1]
	return _set_next_tile(visitor, next_tile)


func _set_next_tile(visitor: Node2D, next_tile: Vector2i) -> bool:
	if not _can_stand_on_tile(next_tile):
		return false
	visitor.set_meta("target_tile", next_tile)
	visitor.set_meta("target_position", _tile_to_local_position(next_tile))
	return true


func _find_reachable_attraction_origin() -> Vector2i:
	if not _is_path_tile(GameState.INITIAL_PATH_TILE):
		return Vector2i(-1, -1)
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) != "basic_attraction":
			continue
		var path_targets: Array = _get_adjacent_path_tiles(building_data)
		if _find_path_route(GameState.INITIAL_PATH_TILE, path_targets).is_empty():
			continue
		return Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	return Vector2i(-1, -1)


func _is_at_destination_path(visitor: Node2D, current_tile: Vector2i) -> bool:
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	var building_data: Dictionary = _get_basic_attraction_data(target_origin)
	if building_data.is_empty():
		return false
	return _get_adjacent_path_tiles(building_data).has(current_tile)


func _can_stand_on_tile(tile: Vector2i) -> bool:
	return tile == GameState.ENTRY_TILE or _is_path_tile(tile)


func _get_basic_attraction_data(origin: Vector2i) -> Dictionary:
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) != "basic_attraction":
			continue
		if int(building_data.get("x", -1)) == origin.x and int(building_data.get("y", -1)) == origin.y:
			return building_data
	return {}


func _get_adjacent_path_tiles(building_data: Dictionary) -> Array:
	var targets: Array = []
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var size: Vector2i = Vector2i(int(building_data.get("width", 1)), int(building_data.get("height", 1)))
	for x in range(origin.x, origin.x + size.x):
		_add_path_target(targets, Vector2i(x, origin.y - 1))
		_add_path_target(targets, Vector2i(x, origin.y + size.y))
	for y in range(origin.y, origin.y + size.y):
		_add_path_target(targets, Vector2i(origin.x - 1, y))
		_add_path_target(targets, Vector2i(origin.x + size.x, y))
	return targets


func _add_path_target(targets: Array, tile: Vector2i) -> void:
	if _is_path_tile(tile) and not targets.has(tile):
		targets.append(tile)


func _find_path_route(start: Vector2i, goals: Array) -> Array:
	if goals.is_empty():
		return []
	var goal_keys: Dictionary = {}
	for goal_entry in goals:
		var goal: Vector2i = goal_entry
		goal_keys[_tile_key(goal)] = true
	var queue: Array = [start]
	var visited: Dictionary = {
		_tile_key(start): true,
	}
	var previous: Dictionary = {}
	var found: Vector2i = Vector2i(-1, -1)
	while not queue.is_empty():
		var current: Vector2i = queue.pop_front()
		if goal_keys.has(_tile_key(current)):
			found = current
			break
		for neighbor_entry in _get_path_neighbors(current):
			var neighbor: Vector2i = neighbor_entry
			var neighbor_key: String = _tile_key(neighbor)
			if visited.has(neighbor_key):
				continue
			visited[neighbor_key] = true
			previous[neighbor_key] = current
			queue.append(neighbor)
	if found == Vector2i(-1, -1):
		return []
	return _reconstruct_path(start, found, previous)


func _get_path_neighbors(tile: Vector2i) -> Array:
	var neighbors: Array = []
	var directions: Array = [Vector2i(1, 0), Vector2i(-1, 0), Vector2i(0, 1), Vector2i(0, -1)]
	for direction_entry in directions:
		var direction: Vector2i = direction_entry
		var neighbor: Vector2i = tile + direction
		if _is_path_tile(neighbor):
			neighbors.append(neighbor)
	return neighbors


func _reconstruct_path(start: Vector2i, goal: Vector2i, previous: Dictionary) -> Array:
	var route: Array = [goal]
	var current: Vector2i = goal
	while current != start:
		var current_key: String = _tile_key(current)
		if not previous.has(current_key):
			return []
		current = previous[current_key]
		route.push_front(current)
	return route


func _is_path_tile(tile: Vector2i) -> bool:
	return GameState.get_tile_type(tile) == GameState.TILE_TYPE_PATH


func _tile_key(tile: Vector2i) -> String:
	return "%d,%d" % [tile.x, tile.y]


func _pay_visit(visitor: Node2D) -> void:
	if bool(visitor.get_meta("paid", false)):
		return
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	if GameState.has_connected_basic_attraction(target_origin):
		total_visitors_served += 1
		_add_attraction_served(target_origin)
		visitor_paid.emit(VISITOR_PAYOUT)
		visitor.set_meta("paid", true)


func _finish_visit(visitor: Node2D) -> void:
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
