extends Node2D

# Placeholder for simple visitor spawning and movement.

signal visitor_paid(amount: int)
signal visitor_stats_changed(active_count: int, served_count: int)

const VISITOR_MIN_MONEY: int = 40
const VISITOR_MAX_MONEY: int = 79
const VISITOR_MIN_INITIAL_SATISFACTION: int = 80
const VISITOR_MAX_INITIAL_SATISFACTION: int = 99
const VISITOR_MIN_SPEED_STEP: int = 1
const VISITOR_MAX_SPEED_STEP: int = 4
const VISITOR_SPEED_MULTIPLIERS: Array[float] = [0.85, 1.0, 1.15, 1.3]
const VISITOR_ANIMATION_FRAME_TIME: float = 0.14
const VISITOR_WALK_SEQUENCE: Array[int] = [0, 1, 0, 2]
const EXTERNAL_ENTRY_VISUAL_OFFSET: Vector2 = Vector2(-100.0, 50.0)
const JAR_TICK_SECONDS: float = 0.1
const VISITOR_INITIAL_SATISFACTION: int = VISITOR_MIN_INITIAL_SATISFACTION
const VISITOR_EXIT_MONEY_THRESHOLD: int = 4
const QUEUE_SATISFACTION_PENALTY_PER_INDEX: int = 1
const LOW_SATISFACTION_THRESHOLD: int = 30
const MEDIUM_SATISFACTION_THRESHOLD: int = 60
const LOW_SATISFACTION_EXIT_CHANCE: float = 0.85
const MEDIUM_SATISFACTION_EXIT_CHANCE: float = 0.45
const HIGH_SATISFACTION_EXIT_CHANCE: float = 0.20
const NEED_Q_EXIT_THRESHOLD: int = 96
const NEED_R_EXIT_THRESHOLD: int = 100
const VISITOR_NEED_UPDATE_SECONDS: float = 1.0
const NEED_Q_INCREASE_PER_TICK: int = 1
const NEED_R_INCREASE_PER_TICK: int = 1
const NEED_T_INCREASE_PER_TICK: int = 1
const BENCH_NEED_Q_THRESHOLD: int = 50
const BENCH_NEED_Q_RELIEF: int = 50
const BENCH_USE_DURATION_SECONDS: float = 3.0
const BENCH_MAX_VISITORS_PER_SIDE: int = 2
const ATTRACTION_QUEUE_MAX_SIZE: int = 10
const QUEUE_VISUAL_SPACING: float = 6.0
const ROAMING_LOCAL_STEP_CHANCE: float = 0.65
const ROAMING_BFS_FALLBACK_STEPS: int = 5
const ATTRACTION_INTEREST_BASE_CHANCE: float = 0.70
const ATTRACTION_INTEREST_QUEUE_PENALTY: float = 0.05
const LOW_SATISFACTION_INTEREST_MULTIPLIER: float = 0.50
const SPAWN_CHANCE_MIN: float = 0.03
const SPAWN_CHANCE_MAX: float = 0.80
const STATE_ENTERING_PARK: int = -100
const STATE_RETURNING_TO_ENTRY: int = -101
const STATE_ROAMING: int = -1
const STATE_USING_BENCH: int = 1
const STATE_GOING_TO_ATTRACTION: int = 7
const STATE_APPROACHING_QUEUE: int = 9
const STATE_QUEUED: int = 11
const STATE_USING_SERVICE: int = 12
const STATE_USING_ATTRACTION: int = 13
const STATE_SPECIAL_WATER_INTERACTION: int = 14
const STATE_SOCIAL_PRIMARY: int = 15
const STATE_SOCIAL_SECONDARY: int = 16
const STATE_SOCIAL_WATCHING: int = 17
const STATE_LEAVING_PARK: int = 18
const NEXT_TILE_NONE: Vector2i = Vector2i(-9999, -9999)
const NEXT_TILE_INVALID: Vector2i = Vector2i(-9998, -9998)
const VISITOR_TEXTURES: Array[Texture2D] = [
	preload("res://assets/original_sprites/visitors/gpack0_000.png"),
	preload("res://assets/original_sprites/visitors/gpack0_001.png"),
	preload("res://assets/original_sprites/visitors/gpack0_002.png"),
	preload("res://assets/original_sprites/visitors/gpack0_003.png"),
	preload("res://assets/original_sprites/visitors/gpack0_004.png"),
	preload("res://assets/original_sprites/visitors/gpack0_005.png"),
	preload("res://assets/original_sprites/visitors/gpack0_006.png"),
	preload("res://assets/original_sprites/visitors/gpack0_007.png"),
]
const VISITOR_FRAMES: Array = [
	[
		[Rect2(0, 0, 8, 16), Rect2(8, 0, 9, 16), Rect2(17, 0, 11, 16)],
		[Rect2(0, 16, 8, 16), Rect2(8, 16, 9, 16), Rect2(17, 16, 11, 16)],
		[Rect2(0, 32, 8, 16), Rect2(8, 32, 9, 16), Rect2(17, 32, 10, 16)],
		[Rect2(0, 48, 8, 16), Rect2(8, 48, 9, 16), Rect2(17, 48, 10, 16)],
	],
	[
		[Rect2(0, 0, 10, 18), Rect2(10, 0, 10, 18), Rect2(20, 0, 10, 18)],
		[Rect2(0, 18, 10, 18), Rect2(10, 18, 10, 18), Rect2(20, 18, 10, 18)],
		[Rect2(0, 36, 9, 18), Rect2(9, 36, 10, 18), Rect2(19, 36, 11, 18)],
		[Rect2(0, 54, 9, 18), Rect2(9, 54, 10, 18), Rect2(19, 54, 11, 18)],
	],
	[
		[Rect2(0, 0, 7, 18), Rect2(7, 0, 8, 18), Rect2(15, 0, 8, 18)],
		[Rect2(0, 18, 7, 18), Rect2(7, 18, 8, 18), Rect2(15, 18, 8, 18)],
		[Rect2(0, 36, 7, 18), Rect2(7, 36, 8, 18), Rect2(15, 36, 7, 18)],
		[Rect2(0, 54, 7, 18), Rect2(7, 54, 8, 18), Rect2(15, 54, 7, 18)],
	],
	[
		[Rect2(0, 0, 9, 18), Rect2(9, 0, 9, 18), Rect2(18, 0, 9, 18)],
		[Rect2(0, 18, 9, 18), Rect2(9, 18, 9, 18), Rect2(18, 18, 9, 18)],
		[Rect2(0, 36, 9, 18), Rect2(9, 36, 9, 18), Rect2(18, 36, 9, 18)],
		[Rect2(0, 54, 9, 18), Rect2(9, 54, 9, 18), Rect2(18, 54, 9, 18)],
	],
	[
		[Rect2(0, 0, 7, 20), Rect2(7, 0, 8, 20), Rect2(15, 0, 8, 20)],
		[Rect2(0, 20, 7, 20), Rect2(7, 20, 8, 20), Rect2(15, 20, 8, 20)],
		[Rect2(0, 40, 7, 20), Rect2(7, 40, 8, 20), Rect2(15, 40, 8, 20)],
		[Rect2(0, 60, 7, 20), Rect2(7, 60, 8, 20), Rect2(15, 60, 8, 20)],
	],
	[
		[Rect2(0, 0, 10, 17), Rect2(10, 0, 10, 17), Rect2(20, 0, 10, 17)],
		[Rect2(0, 17, 10, 17), Rect2(10, 17, 10, 17), Rect2(20, 17, 10, 17)],
		[Rect2(0, 34, 10, 17), Rect2(10, 34, 10, 17), Rect2(20, 34, 10, 17)],
		[Rect2(0, 51, 10, 17), Rect2(10, 51, 10, 17), Rect2(20, 51, 10, 17)],
	],
	[
		[Rect2(0, 17, 9, 17), Rect2(8, 17, 9, 17), Rect2(17, 17, 9, 17)],
		[Rect2(0, 0, 9, 17), Rect2(8, 0, 9, 17), Rect2(17, 0, 9, 17)],
		[Rect2(0, 34, 8, 17), Rect2(8, 34, 9, 17), Rect2(17, 34, 9, 17)],
		[Rect2(0, 51, 8, 17), Rect2(8, 51, 9, 17), Rect2(17, 51, 9, 17)],
	],
	[
		[Rect2(0, 0, 10, 20), Rect2(10, 0, 10, 20), Rect2(20, 0, 10, 20)],
		[Rect2(0, 20, 10, 20), Rect2(10, 20, 10, 20), Rect2(20, 20, 10, 20)],
		[Rect2(0, 40, 9, 20), Rect2(9, 40, 10, 20), Rect2(19, 40, 10, 20)],
		[Rect2(0, 60, 9, 20), Rect2(9, 60, 10, 20), Rect2(19, 60, 10, 20)],
	],
]

@export var visitor_scene: PackedScene
@export var move_speed: float = 80.0
@export var spawn_interval: float = 4.0
@export var spawn_chance: float = 0.35
@export var require_accessible_attraction_for_spawn: bool = true
@export var debug_spawn_logs: bool = false
@export var debug_visitor_ai_logs: bool = false
@export var debug_visitor_state_logs: bool = false
# The JAR has 200 normal visitor slots; the port keeps this low until rendering/depth is cheaper.
@export var max_active_visitors: int = 3

var iso_map: Node
var active_visitors: Array[Node2D] = []
var spawn_timer: Timer
var total_visitors_served: int = 0
var visitors_served_by_attraction: Dictionary = {}
var attraction_queues: Dictionary = {}
var attraction_active_counts: Dictionary = {}
var attraction_queue_anchor_tiles: Dictionary = {}


func _ready() -> void:
	spawn_timer = Timer.new()
	spawn_timer.wait_time = spawn_interval
	spawn_timer.one_shot = false
	spawn_timer.timeout.connect(spawn_single_visitor)
	add_child(spawn_timer)
	start_spawning()


func configure(map_node: Node) -> void:
	iso_map = map_node


func _set_visitor_state(visitor: Node2D, state: int) -> void:
	var old_state: int = _get_visitor_state(visitor)
	visitor.set_meta("visitor_state", state)
	if old_state != state:
		_log_visitor_state(visitor, "%s -> %s" % [_get_visitor_state_name(old_state), _get_visitor_state_name(state)])


func _get_visitor_state(visitor: Node2D) -> int:
	return int(visitor.get_meta("visitor_state", STATE_ROAMING))


func _is_visitor_queued(visitor: Node2D) -> bool:
	return _get_visitor_state(visitor) == STATE_QUEUED or bool(visitor.get_meta("queued_attraction", false))


func _is_visitor_using_attraction(visitor: Node2D) -> bool:
	return _get_visitor_state(visitor) == STATE_USING_ATTRACTION or bool(visitor.get_meta("using_attraction", false))


func _is_visitor_leaving(visitor: Node2D) -> bool:
	return _get_visitor_state(visitor) == STATE_LEAVING_PARK or bool(visitor.get_meta("leaving_park", false))


func _is_visitor_entering(visitor: Node2D) -> bool:
	return _get_visitor_state(visitor) == STATE_ENTERING_PARK or bool(visitor.get_meta("entering_park", false))


func _get_visitor_state_name(state: int) -> String:
	match state:
		STATE_ENTERING_PARK:
			return "ENTERING_PARK"
		STATE_RETURNING_TO_ENTRY:
			return "RETURNING_TO_ENTRY"
		STATE_ROAMING:
			return "ROAMING"
		STATE_USING_BENCH:
			return "USING_BENCH"
		STATE_GOING_TO_ATTRACTION:
			return "GOING_TO_ATTRACTION"
		STATE_APPROACHING_QUEUE:
			return "APPROACHING_QUEUE"
		STATE_QUEUED:
			return "QUEUED"
		STATE_USING_SERVICE:
			return "USING_SERVICE"
		STATE_USING_ATTRACTION:
			return "USING_ATTRACTION"
		STATE_SPECIAL_WATER_INTERACTION:
			return "SPECIAL_WATER_INTERACTION"
		STATE_SOCIAL_PRIMARY:
			return "SOCIAL_PRIMARY"
		STATE_SOCIAL_SECONDARY:
			return "SOCIAL_SECONDARY"
		STATE_SOCIAL_WATCHING:
			return "SOCIAL_WATCHING"
		STATE_LEAVING_PARK:
			return "LEAVING_PARK"
		_:
			return "UNKNOWN_%d" % state


func _process(delta: float) -> void:
	for i in range(active_visitors.size() - 1, -1, -1):
		var visitor: Node2D = active_visitors[i]
		if not is_instance_valid(visitor):
			active_visitors.remove_at(i)
			_emit_visitor_stats()
			continue
		_update_visitor_needs(visitor, delta)
		if _process_visitor_ai(visitor, delta):
			continue
		var visitor_target_position: Vector2 = visitor.get_meta("target_position", Vector2.ZERO) as Vector2
		var is_moving: bool = visitor.position.distance_to(visitor_target_position) > 1.0
		visitor.position = visitor.position.move_toward(visitor_target_position, _get_visitor_move_speed(visitor) * delta)
		_update_visitor_animation(visitor, delta, is_moving)
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
	_log_spawn("tick")
	_log_spawn("active/max = %d/%d" % [active_visitors.size(), max_active_visitors])
	if active_visitors.size() >= max_active_visitors:
		_log_spawn("blocked reason = limite ativo")
		return
	if iso_map == null:
		_log_spawn("blocked reason = iso_map ausente")
		return
	var target_origin: Vector2i = _find_reachable_attraction_origin()
	var spawn_probability: float = _calculate_spawn_chance(target_origin != Vector2i(-1, -1))
	_log_spawn("accessible_attraction = %s" % [str(target_origin != Vector2i(-1, -1))])
	_log_spawn("target_origin = %s" % [str(target_origin)])
	_log_spawn("chance = %.2f" % spawn_probability)
	if spawn_probability <= 0.0:
		_log_spawn("blocked reason = sem atracao acessivel")
		return
	var spawn_roll: float = randf()
	_log_spawn("roll = %.2f" % spawn_roll)
	if spawn_roll >= spawn_probability:
		_log_spawn("blocked reason = roll falhou")
		return
	var visitor: Node2D = _create_visitor()
	add_child(visitor)
	var entry_position: Vector2 = _tile_to_local_position(GameState.ENTRY_TILE)
	visitor.position = _get_external_entry_position()
	visitor.set_meta("current_tile", GameState.ENTRY_TILE)
	visitor.set_meta("target_tile", GameState.INITIAL_PATH_TILE)
	visitor.set_meta("target_position", entry_position)
	visitor.set_meta("target_origin", Vector2i(-1, -1))
	visitor.set_meta("reachable_attraction_origin", target_origin)
	visitor.set_meta("previous_tile", Vector2i(-1, -1))
	visitor.set_meta("roaming_steps", 0)
	visitor.set_meta("returning", false)
	visitor.set_meta("entering_park", true)
	visitor.set_meta("leaving_park", false)
	visitor.set_meta("using_attraction", false)
	visitor.set_meta("use_time_remaining", 0.0)
	visitor.set_meta("queued_attraction", false)
	visitor.set_meta("queue_index", -1)
	visitor.set_meta("queue_origin", Vector2i(-1, -1))
	visitor.set_meta("last_queue_index", 0)
	visitor.set_meta("visitor_money", randi_range(VISITOR_MIN_MONEY, VISITOR_MAX_MONEY))
	visitor.set_meta("visitor_satisfaction", _create_initial_satisfaction())
	_initialize_visitor_needs(visitor)
	# Mirrors the JAR's I=1..4, mapped to a small Godot speed multiplier.
	visitor.set_meta("visitor_speed_step", randi_range(VISITOR_MIN_SPEED_STEP, VISITOR_MAX_SPEED_STEP))
	visitor.set_meta("prefer_initial_entry_step", true)
	visitor.set_meta("last_attraction_key", "")
	visitor.set_meta("state_time_remaining", 0.0)
	visitor.set_meta("bench_tile", Vector2i(-1, -1))
	visitor.set_meta("bench_side", -1)
	visitor.set_meta("paid", false)
	# The JAR keeps W=-1 and starts outside visually with H=-100; this explicit state preserves that Godot-only entry leg.
	_set_visitor_state(visitor, STATE_ENTERING_PARK)
	_update_visitor_direction(visitor, Vector2i(0, 1))
	active_visitors.append(visitor)
	_log_spawn("spawned visitor at %s" % [str(target_origin)])
	_emit_visitor_stats()


func _process_visitor_ai(visitor: Node2D, delta: float) -> bool:
	var state: int = _get_visitor_state(visitor)
	if state == STATE_USING_ATTRACTION or _is_visitor_using_attraction(visitor):
		_update_attraction_use(visitor, delta)
		return true
	if state == STATE_QUEUED or _is_visitor_queued(visitor):
		_update_visitor_animation(visitor, delta, false)
		return true
	if state == STATE_USING_BENCH:
		_update_bench_use(visitor, delta)
		return true
	if state == STATE_USING_SERVICE:
		_update_placeholder_timed_state(visitor, delta)
		return true
	if state == STATE_SPECIAL_WATER_INTERACTION:
		_update_placeholder_timed_state(visitor, delta)
		return true
	if state == STATE_SOCIAL_PRIMARY or state == STATE_SOCIAL_SECONDARY or state == STATE_SOCIAL_WATCHING:
		_update_placeholder_timed_state(visitor, delta)
		return true
	return false


func _calculate_spawn_chance(has_reachable_attraction: bool) -> float:
	if require_accessible_attraction_for_spawn and not has_reachable_attraction:
		return 0.0
	# The JAR computes a dynamic aU and clamps it to 3..80; this port keeps the exported base chance until the full park attractiveness model exists.
	return clampf(spawn_chance, SPAWN_CHANCE_MIN, SPAWN_CHANCE_MAX)


func _create_initial_satisfaction() -> int:
	return randi_range(VISITOR_MIN_INITIAL_SATISFACTION, VISITOR_MAX_INITIAL_SATISFACTION)


func _get_visitor_move_speed(visitor: Node2D) -> float:
	var speed_step: int = clampi(int(visitor.get_meta("visitor_speed_step", 2)), VISITOR_MIN_SPEED_STEP, VISITOR_MAX_SPEED_STEP)
	var speed_multiplier: float = VISITOR_SPEED_MULTIPLIERS[speed_step - 1]
	return move_speed * speed_multiplier


func _initialize_visitor_needs(visitor: Node2D) -> void:
	# Mirrors the JAR spawn ranges without assigning unconfirmed human-readable meanings to Q/R/S/T/U/V yet.
	visitor.set_meta("need_q", randi_range(0, 59))
	visitor.set_meta("need_r", randi_range(0, 59))
	visitor.set_meta("need_s", randi_range(0, 19))
	visitor.set_meta("need_t", randi_range(0, 59))
	visitor.set_meta("need_u", randi_range(80, 99))
	visitor.set_meta("need_v", randi_range(0, 19))
	visitor.set_meta("need_update_accumulator", 0.0)


func _update_visitor_needs(visitor: Node2D, delta: float) -> void:
	var state: int = _get_visitor_state(visitor)
	if state == STATE_USING_ATTRACTION or state == STATE_LEAVING_PARK:
		return
	var accumulator: float = float(visitor.get_meta("need_update_accumulator", 0.0)) + delta
	if accumulator < VISITOR_NEED_UPDATE_SECONDS:
		visitor.set_meta("need_update_accumulator", accumulator)
		return
	var ticks: int = floori(accumulator / VISITOR_NEED_UPDATE_SECONDS)
	visitor.set_meta("need_update_accumulator", accumulator - float(ticks) * VISITOR_NEED_UPDATE_SECONDS)
	# cV() updates several need arrays through data tables; until all tables are mapped, only the confirmed exit-related pressure values drift upward.
	_adjust_visitor_need(visitor, "need_q", NEED_Q_INCREASE_PER_TICK * ticks)
	_adjust_visitor_need(visitor, "need_r", NEED_R_INCREASE_PER_TICK * ticks)
	_adjust_visitor_need(visitor, "need_t", NEED_T_INCREASE_PER_TICK * ticks)


func _adjust_visitor_need(visitor: Node2D, need_name: String, delta: int) -> void:
	visitor.set_meta(need_name, clampi(int(visitor.get_meta(need_name, 0)) + delta, 0, 100))


func clear_visitor() -> void:
	for i in range(active_visitors.size() - 1, -1, -1):
		var visitor: Node2D = active_visitors[i]
		if is_instance_valid(visitor):
			visitor.queue_free()
	active_visitors.clear()
	attraction_queues.clear()
	attraction_active_counts.clear()
	attraction_queue_anchor_tiles.clear()
	_emit_visitor_stats()


func revalidate_active_routes() -> void:
	var changed: bool = false
	for i in range(active_visitors.size() - 1, -1, -1):
		var visitor: Node2D = active_visitors[i]
		if not is_instance_valid(visitor):
			active_visitors.remove_at(i)
			changed = true
			continue
		if (
			_is_visitor_entering(visitor)
			or _is_visitor_leaving(visitor)
			or _is_visitor_using_attraction(visitor)
			or _is_visitor_queued(visitor)
		):
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
			var scene_visitor: Node2D = instance as Node2D
			_apply_visitor_visual_variation(scene_visitor)
			_reset_visitor_animation(scene_visitor)
			return scene_visitor
		instance.queue_free()
	var visitor: Node2D = Node2D.new()
	var shape: Polygon2D = Polygon2D.new()
	shape.color = Color(0.15, 0.75, 1.0, 1.0)
	shape.polygon = PackedVector2Array([Vector2(0, -8), Vector2(6, 4), Vector2(-6, 4)])
	visitor.add_child(shape)
	return visitor


func _apply_visitor_visual_variation(visitor: Node2D) -> void:
	var sprite: Sprite2D = visitor.get_node_or_null("Sprite2D") as Sprite2D
	if sprite == null:
		return
	var visual_variant: int = randi_range(0, VISITOR_TEXTURES.size() - 1)
	visitor.set_meta("visual_variant", visual_variant)
	sprite.texture = VISITOR_TEXTURES[visual_variant]
	sprite.centered = true
	sprite.region_enabled = true


func _update_visitor_animation(visitor: Node2D, delta: float, is_moving: bool) -> void:
	if not is_moving:
		_reset_visitor_animation(visitor)
		return
	var animation_time: float = float(visitor.get_meta("animation_time", 0.0)) + delta
	var sequence_index: int = int(visitor.get_meta("animation_index", 0))
	while animation_time >= VISITOR_ANIMATION_FRAME_TIME:
		animation_time -= VISITOR_ANIMATION_FRAME_TIME
		sequence_index = (sequence_index + 1) % VISITOR_WALK_SEQUENCE.size()
	visitor.set_meta("animation_time", animation_time)
	visitor.set_meta("animation_index", sequence_index)
	_apply_visitor_frame(
		visitor,
		int(visitor.get_meta("visual_direction", 0)),
		VISITOR_WALK_SEQUENCE[sequence_index]
	)


func _reset_visitor_animation(visitor: Node2D) -> void:
	visitor.set_meta("animation_time", 0.0)
	visitor.set_meta("animation_index", 0)
	_apply_visitor_frame(visitor, int(visitor.get_meta("visual_direction", 0)), 0)


func _apply_visitor_frame(visitor: Node2D, direction: int, frame: int) -> void:
	var sprite: Sprite2D = visitor.get_node_or_null("Sprite2D") as Sprite2D
	if sprite == null:
		return
	var frame_region: Rect2 = _get_visitor_frame_region(visitor, direction, frame)
	sprite.region_rect = frame_region
	sprite.offset = Vector2(0.0, -frame_region.size.y * 0.5)


func _get_visitor_frame_region(visitor: Node2D, direction: int, frame: int) -> Rect2:
	var visual_variant: int = clampi(int(visitor.get_meta("visual_variant", 0)), 0, VISITOR_FRAMES.size() - 1)
	var clamped_direction: int = clampi(direction, 0, 3)
	var clamped_frame: int = clampi(frame, 0, 2)
	var variant_frames: Array = VISITOR_FRAMES[visual_variant] as Array
	var direction_frames: Array = variant_frames[clamped_direction] as Array
	return direction_frames[clamped_frame] as Rect2


func _tile_to_local_position(tile: Vector2i) -> Vector2:
	var tile_position: Vector2 = iso_map.call("tile_to_screen", tile)
	var tile_height: float = float(iso_map.get("tile_height"))
	var centered_position: Vector2 = tile_position + Vector2(0.0, tile_height * 0.5)
	return to_local(iso_map.to_global(centered_position))


func _advance_visitor_route(visitor: Node2D) -> void:
	if _is_visitor_leaving(visitor):
		_finish_visit(visitor)
		return
	if bool(visitor.get_meta("entering_park", false)):
		visitor.set_meta("entering_park", false)
		visitor.set_meta("current_tile", GameState.ENTRY_TILE)
		_set_visitor_state(visitor, STATE_ROAMING)
		if not _recalculate_next_step(visitor):
			active_visitors.erase(visitor)
			print("Visitor removed: no route from entrance")
			visitor.queue_free()
			_emit_visitor_stats()
		return
	var reached_tile: Vector2i = visitor.get_meta("target_tile", GameState.ENTRY_TILE) as Vector2i
	visitor.set_meta("current_tile", reached_tile)
	if bool(visitor.get_meta("returning", false)) and reached_tile == GameState.ENTRY_TILE:
		_start_visual_exit(visitor)
		return
	if not _recalculate_next_step(visitor):
		active_visitors.erase(visitor)
		print("Visitor removed: no route to attraction or entrance")
		visitor.queue_free()
		_emit_visitor_stats()


func _recalculate_next_step(visitor: Node2D) -> bool:
	var next_tile: Vector2i = _choose_next_tile(visitor)
	if next_tile == NEXT_TILE_NONE:
		return true
	if next_tile == NEXT_TILE_INVALID:
		return false
	return _set_next_tile(visitor, next_tile)


func _choose_next_tile(visitor: Node2D) -> Vector2i:
	var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
	if not _can_stand_on_tile(current_tile):
		visitor.set_meta("returning", true)
		_set_visitor_state(visitor, STATE_RETURNING_TO_ENTRY)
		return _choose_next_tile_to_entry(visitor, current_tile)
	if bool(visitor.get_meta("returning", false)):
		return _choose_next_tile_to_entry(visitor, current_tile)
	if _get_visitor_state(visitor) == STATE_ROAMING:
		return _choose_roaming_next_tile(visitor, current_tile)
	if _is_at_destination_path(visitor, current_tile):
		_set_visitor_state(visitor, STATE_APPROACHING_QUEUE)
		if _start_attraction_use(visitor):
			return NEXT_TILE_NONE
		return NEXT_TILE_INVALID
	var destination_tile: Vector2i = _choose_next_tile_to_destination(visitor, current_tile)
	if destination_tile != NEXT_TILE_INVALID:
		return destination_tile
	visitor.set_meta("returning", true)
	_set_visitor_state(visitor, STATE_RETURNING_TO_ENTRY)
	print("Visitor returning: no route to attraction")
	return _choose_next_tile_to_entry(visitor, current_tile)


func _choose_roaming_next_tile(visitor: Node2D, current_tile: Vector2i) -> Vector2i:
	if bool(visitor.get_meta("prefer_initial_entry_step", false)) and current_tile == GameState.ENTRY_TILE:
		visitor.set_meta("prefer_initial_entry_step", false)
		var first_step: Vector2i = _choose_first_entry_step()
		if first_step != NEXT_TILE_INVALID:
			return first_step
	if _try_start_bench_use(visitor):
		return NEXT_TILE_NONE
	if _try_start_service_use(visitor):
		return NEXT_TILE_NONE
	if _try_start_social_interaction(visitor):
		return NEXT_TILE_NONE
	var nearby_attraction: Dictionary = _find_nearby_usable_attraction(visitor)
	if not nearby_attraction.is_empty():
		var origin: Vector2i = nearby_attraction.get("origin", Vector2i(-1, -1)) as Vector2i
		var approach_tile: Vector2i = nearby_attraction.get("approach_tile", current_tile) as Vector2i
		visitor.set_meta("target_origin", origin)
		visitor.set_meta("roaming_steps", 0)
		if approach_tile == current_tile:
			_set_visitor_state(visitor, STATE_APPROACHING_QUEUE)
			if _start_attraction_use(visitor):
				return NEXT_TILE_NONE
			return NEXT_TILE_INVALID
		_set_visitor_state(visitor, STATE_GOING_TO_ATTRACTION)
		return approach_tile
	var roaming_steps: int = int(visitor.get_meta("roaming_steps", 0))
	if roaming_steps < ROAMING_BFS_FALLBACK_STEPS and randf() < ROAMING_LOCAL_STEP_CHANCE:
		var local_next_tile: Vector2i = _choose_local_roaming_next_tile(visitor, current_tile)
		if local_next_tile != NEXT_TILE_INVALID:
			visitor.set_meta("roaming_steps", roaming_steps + 1)
			return local_next_tile
	var fallback_target_origin: Vector2i = visitor.get_meta("reachable_attraction_origin", Vector2i(-1, -1)) as Vector2i
	if (visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i) == Vector2i(-1, -1) and fallback_target_origin != Vector2i(-1, -1):
		visitor.set_meta("target_origin", fallback_target_origin)
	var destination_tile: Vector2i = _choose_next_tile_to_destination(visitor, current_tile)
	if destination_tile != NEXT_TILE_INVALID and destination_tile != NEXT_TILE_NONE:
		visitor.set_meta("roaming_steps", 0)
		_set_visitor_state(visitor, STATE_GOING_TO_ATTRACTION)
		return destination_tile
	if _should_visitor_leave(visitor):
		visitor.set_meta("returning", true)
		_set_visitor_state(visitor, STATE_RETURNING_TO_ENTRY)
		return _choose_next_tile_to_entry(visitor, current_tile)
	var fallback_local_tile: Vector2i = _choose_local_roaming_next_tile(visitor, current_tile)
	if fallback_local_tile != NEXT_TILE_INVALID:
		visitor.set_meta("roaming_steps", roaming_steps + 1)
		return fallback_local_tile
	visitor.set_meta("returning", true)
	_set_visitor_state(visitor, STATE_RETURNING_TO_ENTRY)
	return _choose_next_tile_to_entry(visitor, current_tile)


func _choose_first_entry_step() -> Vector2i:
	# cS() initializes D/E as ab,1; if that tile exists as Path in the port, keep that first.
	if _can_stand_on_tile(GameState.INITIAL_PATH_TILE):
		return GameState.INITIAL_PATH_TILE
	var lateral_entry_tiles: Array = [GameState.ENTRY_TILE + Vector2i(-1, 0), GameState.ENTRY_TILE + Vector2i(1, 0)]
	for tile_entry in lateral_entry_tiles:
		var tile: Vector2i = tile_entry
		if _can_stand_on_tile(tile):
			return tile
	return NEXT_TILE_INVALID


func _choose_next_tile_to_destination(visitor: Node2D, current_tile: Vector2i) -> Vector2i:
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	var building_data: Dictionary = _get_basic_attraction_data(target_origin)
	if building_data.is_empty():
		return NEXT_TILE_INVALID
	var path_targets: Array = _get_adjacent_path_tiles(building_data)
	if current_tile == GameState.ENTRY_TILE:
		var route_from_entry: Array = _find_path_route(GameState.ENTRY_TILE, path_targets)
		if route_from_entry.is_empty() or route_from_entry.size() < 2:
			return NEXT_TILE_INVALID
		return route_from_entry[1] as Vector2i
	if not _is_path_tile(current_tile):
		return NEXT_TILE_INVALID
	var route: Array = _find_path_route(current_tile, path_targets)
	if route.is_empty():
		return NEXT_TILE_INVALID
	if route.size() == 1:
		return NEXT_TILE_NONE
	return route[1] as Vector2i


func _choose_next_tile_to_entry(visitor: Node2D, current_tile: Vector2i) -> Vector2i:
	if current_tile == GameState.ENTRY_TILE:
		_start_visual_exit(visitor)
		return NEXT_TILE_NONE
	var local_next_tile: Vector2i = _choose_next_tile_to_entry_local(current_tile)
	if local_next_tile != NEXT_TILE_INVALID:
		return local_next_tile
	if not _is_path_tile(current_tile):
		print("Visitor removed: no route back to entrance")
		return NEXT_TILE_INVALID
	var route: Array = _find_path_route(current_tile, [GameState.ENTRY_TILE])
	if route.is_empty():
		print("Visitor removed: no route back to entrance")
		return NEXT_TILE_INVALID
	return route[1] as Vector2i


func _choose_next_tile_to_entry_local(current_tile: Vector2i) -> Vector2i:
	# The JAR's W=18 exit flow biases movement toward the gate through dr()/ds(); BFS remains the fallback.
	if not _is_path_tile(current_tile):
		return NEXT_TILE_INVALID
	var current_distance: int = _tile_manhattan_distance(current_tile, GameState.ENTRY_TILE)
	var best_tile: Vector2i = NEXT_TILE_INVALID
	var best_distance: int = current_distance
	var directions: Array = [Vector2i(1, 0), Vector2i(-1, 0), Vector2i(0, 1), Vector2i(0, -1)]
	for direction_entry in directions:
		var neighbor: Vector2i = current_tile + (direction_entry as Vector2i)
		if not _can_stand_on_tile(neighbor):
			continue
		var neighbor_distance: int = _tile_manhattan_distance(neighbor, GameState.ENTRY_TILE)
		if neighbor_distance < best_distance:
			best_tile = neighbor
			best_distance = neighbor_distance
	return best_tile


func _find_nearby_usable_attraction(visitor: Node2D) -> Dictionary:
	var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
	var candidate_tiles: Array = [current_tile]
	for neighbor_entry in _get_path_neighbors(current_tile):
		var neighbor: Vector2i = neighbor_entry
		if not candidate_tiles.has(neighbor):
			candidate_tiles.append(neighbor)
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if not _is_supported_attraction_building(building_data):
			continue
		if not _should_visit_attraction(visitor, building_data):
			continue
		var path_targets: Array = _get_adjacent_path_tiles(building_data)
		for candidate_entry in candidate_tiles:
			var candidate_tile: Vector2i = candidate_entry
			if path_targets.has(candidate_tile):
				return {
					"origin": _get_building_origin(building_data),
					"approach_tile": candidate_tile,
				}
	return {}


func _should_visit_attraction(visitor: Node2D, building_data: Dictionary) -> bool:
	var origin: Vector2i = _get_building_origin(building_data)
	if origin == Vector2i(-1, -1):
		return false
	if int(visitor.get_meta("visitor_money", 0)) < _get_attraction_ticket_price(origin):
		return false
	var queue_size: int = _get_attraction_queue_size(origin)
	if queue_size >= ATTRACTION_QUEUE_MAX_SIZE:
		return false
	var interest_chance: float = ATTRACTION_INTEREST_BASE_CHANCE - float(queue_size) * ATTRACTION_INTEREST_QUEUE_PENALTY
	if int(visitor.get_meta("visitor_satisfaction", VISITOR_INITIAL_SATISFACTION)) < LOW_SATISFACTION_THRESHOLD:
		interest_chance *= LOW_SATISFACTION_INTEREST_MULTIPLIER
	if _attraction_key(origin) == String(visitor.get_meta("last_attraction_key", "")):
		interest_chance -= 0.20
	var need_q: int = int(visitor.get_meta("need_q", 0))
	var need_r: int = int(visitor.get_meta("need_r", 0))
	if need_q > 70 or need_r > 70:
		interest_chance -= 0.15
	# The JAR's dA()/dB() also use needs, repeat visits and queue pressure; those systems are still deferred.
	return randf() < clampf(interest_chance, 0.05, 0.95)


func _choose_local_roaming_next_tile(visitor: Node2D, current_tile: Vector2i) -> Vector2i:
	var candidates: Array = _get_walkable_neighbor_tiles(current_tile)
	if candidates.is_empty():
		return NEXT_TILE_INVALID
	var previous_tile: Vector2i = visitor.get_meta("previous_tile", Vector2i(-1, -1)) as Vector2i
	var non_backtracking_candidates: Array = []
	for candidate_entry in candidates:
		var candidate_tile: Vector2i = candidate_entry
		if candidate_tile != previous_tile:
			non_backtracking_candidates.append(candidate_tile)
	if not non_backtracking_candidates.is_empty():
		candidates = non_backtracking_candidates
	var goal_biased_candidates: Array = _get_goal_biased_candidates(visitor, current_tile, candidates)
	if not goal_biased_candidates.is_empty():
		candidates = goal_biased_candidates
	return candidates[randi() % candidates.size()] as Vector2i


func _get_walkable_neighbor_tiles(tile: Vector2i) -> Array:
	var neighbors: Array = []
	for neighbor_entry in _get_path_neighbors(tile):
		var neighbor: Vector2i = neighbor_entry
		if _can_stand_on_tile(neighbor):
			neighbors.append(neighbor)
	return neighbors


func _get_path_mask(tile: Vector2i) -> int:
	for tile_data_entry in GameState.tiles:
		var tile_data: Dictionary = tile_data_entry
		if int(tile_data.get("x", -1)) != tile.x or int(tile_data.get("y", -1)) != tile.y:
			continue
		if String(tile_data.get("type", "")) != GameState.TILE_TYPE_PATH:
			return 0
		if tile_data.has("path_mask"):
			return clampi(int(tile_data.get("path_mask", 0)), 0, 3)
		return maxi(0, int(tile_data.get("path_meta", 0))) % 4
	return 0


func _get_bench_occupancy(tile: Vector2i, side: int) -> int:
	var occupancy: int = 0
	for visitor in active_visitors:
		if not is_instance_valid(visitor):
			continue
		if _get_visitor_state(visitor) != STATE_USING_BENCH:
			continue
		if (visitor.get_meta("bench_tile", Vector2i(-1, -1)) as Vector2i) != tile:
			continue
		if int(visitor.get_meta("bench_side", -1)) == side:
			occupancy += 1
	return occupancy


func _get_goal_biased_candidates(visitor: Node2D, current_tile: Vector2i, candidates: Array) -> Array:
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	if target_origin == Vector2i(-1, -1):
		return []
	var building_data: Dictionary = _get_basic_attraction_data(target_origin)
	if building_data.is_empty():
		return []
	var path_targets: Array = _get_adjacent_path_tiles(building_data)
	if path_targets.is_empty():
		return []
	var current_distance: int = _get_min_distance_to_tiles(current_tile, path_targets)
	var best_distance: int = current_distance
	var best_candidates: Array = []
	for candidate_entry in candidates:
		var candidate_tile: Vector2i = candidate_entry
		var distance: int = _get_min_distance_to_tiles(candidate_tile, path_targets)
		if distance < best_distance:
			best_distance = distance
			best_candidates = [candidate_tile]
		elif distance == best_distance and distance < current_distance:
			best_candidates.append(candidate_tile)
	return best_candidates


func _get_min_distance_to_tiles(from_tile: Vector2i, target_tiles: Array) -> int:
	var best_distance: int = 999999
	for target_entry in target_tiles:
		var target_tile: Vector2i = target_entry
		best_distance = mini(best_distance, _tile_manhattan_distance(from_tile, target_tile))
	return best_distance


func _tile_manhattan_distance(from_tile: Vector2i, to_tile: Vector2i) -> int:
	return abs(from_tile.x - to_tile.x) + abs(from_tile.y - to_tile.y)


func _set_next_tile(visitor: Node2D, next_tile: Vector2i) -> bool:
	if not _can_stand_on_tile(next_tile):
		return false
	var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
	visitor.set_meta("previous_tile", current_tile)
	_update_visitor_direction(visitor, next_tile - current_tile)
	visitor.set_meta("target_tile", next_tile)
	visitor.set_meta("target_position", _tile_to_local_position(next_tile))
	return true


func _start_visual_exit(visitor: Node2D) -> void:
	visitor.set_meta("leaving_park", true)
	visitor.set_meta("target_tile", GameState.ENTRY_TILE)
	visitor.set_meta("target_position", _get_external_entry_position())
	_set_visitor_state(visitor, STATE_LEAVING_PARK)
	_update_visitor_direction(visitor, Vector2i(0, -1))


func _get_external_entry_position() -> Vector2:
	return _tile_to_local_position(GameState.ENTRY_TILE) + EXTERNAL_ENTRY_VISUAL_OFFSET


func _start_attraction_use(visitor: Node2D) -> bool:
	var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	if int(visitor.get_meta("visitor_money", 0)) < _get_attraction_ticket_price(target_origin):
		_send_visitor_to_exit_after_attraction(visitor, current_tile)
		return true
	if not _enqueue_attraction(visitor, target_origin):
		_send_visitor_to_exit_after_attraction(visitor, current_tile)
		return true
	return true


func _try_start_bench_use(visitor: Node2D) -> bool:
	# JAR e() lets visitors with high Q use c&1/c&2 path add-ons as benches.
	if int(visitor.get_meta("need_q", 0)) <= BENCH_NEED_Q_THRESHOLD:
		return false
	var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
	var path_mask: int = _get_path_mask(current_tile)
	if path_mask == 0:
		return false
	for side in range(2):
		var side_bit: int = 1 if side == 0 else 2
		if (path_mask & side_bit) == 0:
			continue
		if _get_bench_occupancy(current_tile, side) >= BENCH_MAX_VISITORS_PER_SIDE:
			continue
		visitor.set_meta("bench_tile", current_tile)
		visitor.set_meta("bench_side", side)
		visitor.set_meta("state_time_remaining", BENCH_USE_DURATION_SECONDS)
		visitor.set_meta("target_position", visitor.position)
		_set_visitor_state(visitor, STATE_USING_BENCH)
		_reset_visitor_animation(visitor)
		_log_visitor_ai(visitor, "using bench side=%d tile=%s" % [side, str(current_tile)])
		return true
	return false


func _try_start_service_use(_visitor: Node2D) -> bool:
	# W=12 is confirmed in the JAR, but services are not represented in the current port data yet.
	return false


func _try_start_social_interaction(_visitor: Node2D) -> bool:
	# W=15/16/17 require the JAR's social pairing rules from dk()/later social helpers; keep the hooks inert for now.
	return false


func _update_bench_use(visitor: Node2D, delta: float) -> void:
	var remaining_time: float = float(visitor.get_meta("state_time_remaining", 0.0)) - delta
	visitor.set_meta("state_time_remaining", remaining_time)
	_update_visitor_animation(visitor, delta, false)
	if remaining_time <= 0.0:
		_finish_bench_use(visitor)


func _finish_bench_use(visitor: Node2D) -> void:
	_adjust_visitor_need(visitor, "need_q", -BENCH_NEED_Q_RELIEF)
	visitor.set_meta("bench_tile", Vector2i(-1, -1))
	visitor.set_meta("bench_side", -1)
	visitor.set_meta("state_time_remaining", 0.0)
	_set_visitor_state(visitor, STATE_ROAMING)
	if not _recalculate_next_step(visitor):
		var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
		_send_visitor_to_exit_after_attraction(visitor, current_tile)


func _update_placeholder_timed_state(visitor: Node2D, delta: float) -> void:
	# Services, water/special objects and social states are represented so W[] is complete, but their systems are still mapped incrementally.
	var remaining_time: float = float(visitor.get_meta("state_time_remaining", 0.0)) - delta
	visitor.set_meta("state_time_remaining", remaining_time)
	_update_visitor_animation(visitor, delta, false)
	if remaining_time <= 0.0:
		visitor.set_meta("state_time_remaining", 0.0)
		_set_visitor_state(visitor, STATE_ROAMING)
		if not _recalculate_next_step(visitor):
			var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
			_send_visitor_to_exit_after_attraction(visitor, current_tile)


func _update_attraction_use(visitor: Node2D, delta: float) -> void:
	var remaining_time: float = float(visitor.get_meta("use_time_remaining", 0.0)) - delta
	visitor.set_meta("use_time_remaining", remaining_time)
	_update_visitor_animation(visitor, delta, false)
	if remaining_time <= 0.0:
		_finish_attraction_use(visitor)


func _finish_attraction_use(visitor: Node2D) -> void:
	visitor.set_meta("using_attraction", false)
	visitor.set_meta("paid", false)
	_apply_attraction_satisfaction(visitor)
	var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	visitor.set_meta("last_attraction_key", _attraction_key(target_origin))
	_release_attraction_slot(target_origin)
	_try_board_attraction_queue(target_origin)
	if _should_visitor_leave(visitor):
		_send_visitor_to_exit_after_attraction(visitor, current_tile)
		return
	var next_target_origin: Vector2i = _find_reachable_attraction_origin()
	if next_target_origin == Vector2i(-1, -1):
		_send_visitor_to_exit_after_attraction(visitor, current_tile)
		return
	visitor.set_meta("returning", false)
	visitor.set_meta("target_origin", Vector2i(-1, -1))
	visitor.set_meta("reachable_attraction_origin", next_target_origin)
	_set_visitor_state(visitor, STATE_ROAMING)
	if not _recalculate_next_step(visitor):
		_send_visitor_to_exit_after_attraction(visitor, current_tile)


func _enqueue_attraction(visitor: Node2D, origin: Vector2i) -> bool:
	var building_data: Dictionary = _get_basic_attraction_data(origin)
	if building_data.is_empty() or _get_adjacent_path_tiles(building_data).is_empty():
		return false
	var key: String = _attraction_key(origin)
	var queue: Array = attraction_queues.get(key, []) as Array
	_cleanup_attraction_queue(queue)
	if queue.size() >= ATTRACTION_QUEUE_MAX_SIZE:
		attraction_queues[key] = queue
		return false
	var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
	_ensure_queue_anchor_tile(origin, current_tile)
	visitor.set_meta("queued_attraction", true)
	_set_visitor_state(visitor, STATE_QUEUED)
	visitor.set_meta("queue_origin", origin)
	visitor.set_meta("target_position", visitor.position)
	queue.append(visitor)
	attraction_queues[key] = queue
	_refresh_queue_positions(origin)
	_try_board_attraction_queue(origin)
	return true


func _try_board_attraction_queue(origin: Vector2i) -> void:
	if origin == Vector2i(-1, -1):
		return
	var key: String = _attraction_key(origin)
	var queue: Array = attraction_queues.get(key, []) as Array
	_cleanup_attraction_queue(queue)
	var active_count: int = int(attraction_active_counts.get(key, 0))
	var attraction_capacity: int = _get_attraction_capacity(origin)
	while active_count < attraction_capacity and not queue.is_empty():
		var visitor: Node2D = queue.pop_front() as Node2D
		if not is_instance_valid(visitor):
			continue
		var boarded_queue_index: int = maxi(0, int(visitor.get_meta("queue_index", 0)))
		visitor.set_meta("last_queue_index", boarded_queue_index)
		visitor.set_meta("queued_attraction", false)
		visitor.set_meta("queue_index", -1)
		visitor.set_meta("queue_origin", Vector2i(-1, -1))
		if not _begin_attraction_use(visitor, origin):
			var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
			_send_visitor_to_exit_after_attraction(visitor, current_tile)
			continue
		active_count += 1
	attraction_queues[key] = queue
	if active_count > 0:
		attraction_active_counts[key] = active_count
	else:
		attraction_active_counts.erase(key)
	_refresh_queue_positions(origin)


func _begin_attraction_use(visitor: Node2D, origin: Vector2i) -> bool:
	visitor.set_meta("target_origin", origin)
	if not _pay_visit(visitor):
		return false
	visitor.set_meta("using_attraction", true)
	_set_visitor_state(visitor, STATE_USING_ATTRACTION)
	visitor.set_meta("use_time_remaining", _get_attraction_use_duration(origin))
	visitor.set_meta("target_position", visitor.position)
	_reset_visitor_animation(visitor)
	return true


func _apply_attraction_satisfaction(visitor: Node2D) -> void:
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	var queue_wait_index: int = maxi(0, int(visitor.get_meta("last_queue_index", 0)))
	var satisfaction_gain: int = maxi(0, _get_attraction_satisfaction_gain(target_origin) - queue_wait_index * QUEUE_SATISFACTION_PENALTY_PER_INDEX)
	var current_satisfaction: int = int(visitor.get_meta("visitor_satisfaction", VISITOR_INITIAL_SATISFACTION))
	visitor.set_meta("visitor_satisfaction", clampi(current_satisfaction + satisfaction_gain, 0, 100))


func _should_visitor_leave(visitor: Node2D) -> bool:
	var visitor_money: int = int(visitor.get_meta("visitor_money", 0))
	if visitor_money < VISITOR_EXIT_MONEY_THRESHOLD:
		return true
	if int(visitor.get_meta("need_q", 0)) >= NEED_Q_EXIT_THRESHOLD:
		return true
	if int(visitor.get_meta("need_r", 0)) >= NEED_R_EXIT_THRESHOLD:
		return true
	var visitor_satisfaction: int = int(visitor.get_meta("visitor_satisfaction", VISITOR_INITIAL_SATISFACTION))
	if visitor_satisfaction < LOW_SATISFACTION_THRESHOLD:
		return randf() < LOW_SATISFACTION_EXIT_CHANCE
	if visitor_satisfaction < MEDIUM_SATISFACTION_THRESHOLD:
		return randf() < MEDIUM_SATISFACTION_EXIT_CHANCE
	# The JAR also checks Q/R/S/T/U/V needs in dz(); those are intentionally deferred.
	return randf() < HIGH_SATISFACTION_EXIT_CHANCE


func _release_attraction_slot(origin: Vector2i) -> void:
	if origin == Vector2i(-1, -1):
		return
	var key: String = _attraction_key(origin)
	var active_count: int = int(attraction_active_counts.get(key, 0)) - 1
	if active_count > 0:
		attraction_active_counts[key] = active_count
	else:
		attraction_active_counts.erase(key)


func _refresh_queue_positions(origin: Vector2i) -> void:
	var key: String = _attraction_key(origin)
	var queue: Array = attraction_queues.get(key, []) as Array
	_cleanup_attraction_queue(queue)
	var anchor_tile: Vector2i = _get_queue_anchor_tile(origin)
	var anchor_position: Vector2 = _tile_to_local_position(anchor_tile)
	for index in range(queue.size()):
		var visitor: Node2D = queue[index] as Node2D
		visitor.set_meta("queue_index", index)
		# TODO: use attraction orientation like the JAR's dv()/dw() once rotation is represented.
		var queue_position: Vector2 = anchor_position + Vector2(0.0, QUEUE_VISUAL_SPACING * float(index))
		visitor.position = queue_position
		visitor.set_meta("target_position", queue_position)
		_reset_visitor_animation(visitor)
	attraction_queues[key] = queue


func _ensure_queue_anchor_tile(origin: Vector2i, fallback_tile: Vector2i) -> void:
	var key: String = _attraction_key(origin)
	if attraction_queue_anchor_tiles.has(key):
		return
	if _is_path_tile(fallback_tile):
		attraction_queue_anchor_tiles[key] = fallback_tile
		return
	var building_data: Dictionary = _get_basic_attraction_data(origin)
	var path_targets: Array = _get_adjacent_path_tiles(building_data)
	if path_targets.is_empty():
		attraction_queue_anchor_tiles[key] = GameState.INITIAL_PATH_TILE
	else:
		attraction_queue_anchor_tiles[key] = path_targets[0]


func _get_queue_anchor_tile(origin: Vector2i) -> Vector2i:
	var key: String = _attraction_key(origin)
	if attraction_queue_anchor_tiles.has(key):
		return attraction_queue_anchor_tiles[key] as Vector2i
	return GameState.INITIAL_PATH_TILE


func _cleanup_attraction_queue(queue: Array) -> void:
	for index in range(queue.size() - 1, -1, -1):
		var visitor: Node2D = queue[index] as Node2D
		if not is_instance_valid(visitor):
			queue.remove_at(index)


func _send_visitor_to_exit_after_attraction(visitor: Node2D, current_tile: Vector2i) -> void:
	visitor.set_meta("returning", true)
	_set_visitor_state(visitor, STATE_RETURNING_TO_ENTRY)
	var next_tile: Vector2i = _choose_next_tile_to_entry(visitor, current_tile)
	if next_tile == NEXT_TILE_NONE:
		return
	if next_tile == NEXT_TILE_INVALID or not _set_next_tile(visitor, next_tile):
		active_visitors.erase(visitor)
		print("Visitor removed: no route back after attraction use")
		visitor.queue_free()
		_emit_visitor_stats()


func _update_visitor_direction(visitor: Node2D, delta: Vector2i) -> void:
	if delta == Vector2i(0, -1):
		visitor.set_meta("visual_direction", 0)
	elif delta == Vector2i(1, 0):
		visitor.set_meta("visual_direction", 1)
	elif delta == Vector2i(-1, 0):
		visitor.set_meta("visual_direction", 2)
	elif delta == Vector2i(0, 1):
		visitor.set_meta("visual_direction", 3)
	_reset_visitor_animation(visitor)


func _find_reachable_attraction_origin() -> Vector2i:
	var checked_attractions: int = 0
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		_log_spawn("building id=%s name=%s jar_type=%d type=%s origin=%s size=%dx%d" % [
			String(building_data.get("id", "")),
			_get_building_debug_name(building_data),
			int(building_data.get("jar_type", -1)),
			String(building_data.get("type", "")),
			str(Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))),
			int(building_data.get("width", 1)),
			int(building_data.get("height", 1)),
		])
		if not _is_supported_attraction_building(building_data):
			continue
		checked_attractions += 1
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var path_targets: Array = _get_adjacent_path_tiles(building_data)
		_log_spawn("checking attraction %s path_targets=%d" % [str(origin), path_targets.size()])
		if path_targets.is_empty():
			_log_spawn("attraction %s blocked reason = sem Path adjacente" % [str(origin)])
			continue
		if _find_path_route(GameState.ENTRY_TILE, path_targets).is_empty():
			_log_spawn("attraction %s blocked reason = BFS sem rota" % [str(origin)])
			continue
		_log_spawn("attraction %s reachable = true" % [str(origin)])
		return origin
	if checked_attractions == 0:
		_log_spawn("blocked reason = nenhuma atracao reconhecida no GameState")
	return Vector2i(-1, -1)


func _log_spawn(message: String) -> void:
	if debug_spawn_logs:
		print("[Spawn] %s" % message)


func _log_visitor_ai(visitor: Node2D, message: String) -> void:
	if debug_visitor_ai_logs:
		var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
		print("[VisitorAI] state=%s tile=%s %s" % [_get_visitor_state_name(_get_visitor_state(visitor)), str(current_tile), message])


func _log_visitor_state(visitor: Node2D, message: String) -> void:
	if debug_visitor_state_logs:
		var current_tile: Vector2i = visitor.get_meta("current_tile", GameState.ENTRY_TILE) as Vector2i
		print("[VisitorState] tile=%s %s" % [str(current_tile), message])


func _is_supported_attraction_building(building_data: Dictionary) -> bool:
	if String(building_data.get("id", "")) == "basic_attraction":
		return true
	if int(building_data.get("jar_type", -1)) == 6:
		return true
	return String(building_data.get("type", "")) == "attraction"


func _get_building_debug_name(building_data: Dictionary) -> String:
	if building_data.has("name"):
		return String(building_data.get("name", ""))
	var catalog_data: Dictionary = Catalog.get_building(String(building_data.get("id", "")))
	return String(catalog_data.get("name", ""))


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
		if not _is_supported_attraction_building(building_data):
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
		if _can_connect_logically_between_tiles(tile, neighbor):
			neighbors.append(neighbor)
	return neighbors


func _can_connect_logically_between_tiles(from_tile: Vector2i, to_tile: Vector2i) -> bool:
	if from_tile == GameState.ENTRY_TILE:
		return GameState.is_inside_map(to_tile) and _is_path_tile(to_tile)
	if _is_path_tile(from_tile):
		return to_tile == GameState.ENTRY_TILE or _is_path_tile(to_tile)
	return false


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


func _pay_visit(visitor: Node2D) -> bool:
	if bool(visitor.get_meta("paid", false)):
		return true
	var target_origin: Vector2i = visitor.get_meta("target_origin", Vector2i(-1, -1)) as Vector2i
	var building_data: Dictionary = _get_basic_attraction_data(target_origin)
	if not building_data.is_empty() and not _get_adjacent_path_tiles(building_data).is_empty():
		var ticket_price: int = _get_attraction_ticket_price(target_origin)
		var visitor_money: int = int(visitor.get_meta("visitor_money", 0))
		if visitor_money < ticket_price:
			return false
		visitor.set_meta("visitor_money", visitor_money - ticket_price)
		total_visitors_served += 1
		_add_attraction_served(target_origin)
		visitor_paid.emit(ticket_price)
		visitor.set_meta("paid", true)
		return true
	return false


func _get_attraction_ticket_price(origin: Vector2i) -> int:
	var catalog_data: Dictionary = _get_attraction_catalog_data(origin)
	return maxi(0, int(catalog_data.get("ticket_price", 1)))


func _get_attraction_capacity(origin: Vector2i) -> int:
	var catalog_data: Dictionary = _get_attraction_catalog_data(origin)
	return maxi(1, int(catalog_data.get("visitor_capacity", 1)))


func _get_attraction_use_duration(origin: Vector2i) -> float:
	var catalog_data: Dictionary = _get_attraction_catalog_data(origin)
	if catalog_data.has("use_duration_ticks"):
		var use_ticks: float = float(catalog_data.get("use_duration_ticks", 0))
		return maxf(0.1, use_ticks * JAR_TICK_SECONDS)
	return maxf(0.1, float(catalog_data.get("use_duration_seconds", 3.0)))


func _get_attraction_satisfaction_gain(origin: Vector2i) -> int:
	var catalog_data: Dictionary = _get_attraction_catalog_data(origin)
	return maxi(0, int(catalog_data.get("satisfaction_gain", 0)))


func _get_attraction_catalog_data(origin: Vector2i) -> Dictionary:
	var building_data: Dictionary = _get_basic_attraction_data(origin)
	var catalog_id: String = String(building_data.get("id", "basic_attraction"))
	var catalog_data: Dictionary = Catalog.get_building(catalog_id)
	if catalog_data.is_empty():
		catalog_data = Catalog.get_building("basic_attraction")
	return catalog_data


func _finish_visit(visitor: Node2D) -> void:
	active_visitors.erase(visitor)
	visitor.queue_free()
	_emit_visitor_stats()


func _add_attraction_served(origin: Vector2i) -> void:
	var key: String = _attraction_key(origin)
	visitors_served_by_attraction[key] = int(visitors_served_by_attraction.get(key, 0)) + 1


func _attraction_key(origin: Vector2i) -> String:
	return "%d,%d" % [origin.x, origin.y]


func _get_attraction_queue_size(origin: Vector2i) -> int:
	var queue: Array = attraction_queues.get(_attraction_key(origin), []) as Array
	_cleanup_attraction_queue(queue)
	return queue.size()


func _get_building_origin(building_data: Dictionary) -> Vector2i:
	return Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))


func _emit_visitor_stats() -> void:
	visitor_stats_changed.emit(active_visitors.size(), total_visitors_served)
