extends Node2D

# Owns the isometric grid and touch-to-tile conversion.

signal tile_touched(tile: Vector2i)
signal selection_cleared

const PATH_TEXTURE: Texture2D = preload("res://assets/original_sprites/path/gpack1_002.png")
const WATER_TEXTURE: Texture2D = preload("res://assets/original_sprites/path/gpack1_005.png")
const ENTRANCE_TEXTURE: Texture2D = preload("res://assets/original_sprites/entrance/gpack1_006.png")
const MAP_RENDER_LAYER_SCRIPT: Script = preload("res://scripts/map_render_layer.gd")
const RENDER_LAYER_STATIC_LOW: String = "static_low"
const RENDER_LAYER_WATER: String = "water"
const RENDER_LAYER_STATIC_PATH: String = "static_path"
const RENDER_LAYER_STATIC_HIGH: String = "static_high"
const RENDER_LAYER_DYNAMIC_DEPTH: String = "dynamic_depth"
const RENDER_LAYER_OVERLAY: String = "overlay"
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
const ENTRANCE_ROCK_REGION: Rect2 = Rect2(0.0, 112.0, 15.0, 12.0)
const ENTRANCE_SIGN_REGION_A: Rect2 = Rect2(90.0, 83.0, 15.0, 20.0)
const ENTRANCE_SIGN_REGION_B: Rect2 = Rect2(105.0, 84.0, 18.0, 13.0)
const VISIBLE_TILE_MARGIN: int = 8
const EXTERNAL_DECOR_GRID_SIZE: int = 10
const EXTERNAL_ROAD_SIDE_DECOR_CODE: int = 11
const EXTERNAL_TOP_DECOR_CODE: int = 12
const HIGH_DRAW_DEPTH_SCALE: float = 100.0
const HIGH_DRAW_LAYER_DECOR: int = 20
const HIGH_DRAW_LAYER_ATTRACTION: int = 30
const HIGH_DRAW_LAYER_VISITOR: int = 40
const HIGH_DRAW_LAYER_ENTRANCE: int = 80
const ATTRACTION_BASE_LAYER_OFFSET: int = HIGH_DRAW_LAYER_ATTRACTION - 200
const ATTRACTION_HIGH_CHUNK38_LAYER_OFFSET: int = HIGH_DRAW_LAYER_ATTRACTION + 800
const ATTRACTION_ANIMATION_SECONDS: float = 0.12
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
@export var use_fixed_world_static_cache: bool = true
@export var fixed_world_static_cache_margin: int = VISIBLE_TILE_MARGIN
@export var static_render_cache_margin: int = 4
@export var use_simple_attraction_render: bool = true
@export var use_cached_attraction_chunk_render: bool = true
@export var include_attraction_frame_static_chunks: bool = true
@export var include_attraction_animated_chunks: bool = true
@export var include_attraction_line_chunks: bool = true
@export var include_attraction_special_chunks: bool = true
@export var include_attraction_passenger_chunks: bool = true
@export var use_iso_visitor_depth_render: bool = false
@export var debug_disable_attraction_render: bool = false
@export var debug_disable_high_draw_jobs: bool = false
@export var debug_disable_visitor_render_jobs: bool = false
@export var debug_log_render_counters: bool = false
@export var debug_attraction_visual_mode: String = "all"
@export var debug_attraction_only_jar_type: int = -1
@export var debug_draw_chunk38: bool = true
@export var debug_draw_static_chunks: bool = true
@export var debug_draw_animated_chunks: bool = true
@export var debug_draw_line_chunks: bool = true
@export var debug_draw_static_lines: bool = true
@export var debug_draw_animated_lines: bool = true
@export var debug_show_line_points: bool = false
@export var debug_draw_special_chunks: bool = true
@export var debug_show_special_anchors: bool = false
@export var debug_draw_passenger_chunks: bool = true
@export var debug_show_passenger_anchors: bool = false
@export var debug_draw_chunk_labels: bool = false
@export var debug_draw_chunk_anchors: bool = false
@export var debug_show_animation_frame: bool = false
@export var debug_freeze_attraction_animation: bool = false
@export var debug_forced_attraction_frame: int = -1

var selected_tile: Vector2i = Vector2i(-1, -1)
var preview_tile: Vector2i = Vector2i(-1, -1)
var _press_active := false
var _press_position := Vector2.ZERO
var _press_moved := false
var _active_touch_index := -1
var _water_frame: int = 0
var _water_frame_timer: float = 0.0
var _attraction_frame_timer: float = 0.0
var _attraction_frame: int = 0
var _external_decor_codes: Array = []
var _visitor_system: Node = null
var _entrance_overlay: Node2D = null
var _draw_entrance_high_in_isomap: bool = true
var _attraction_texture_cache: Dictionary = {}
var _attraction_def_cache: Dictionary = {}
var _attraction_def_cache_prepared: bool = false
var _attraction_instance_jobs_cache: Dictionary = {}
var _attraction_instance_frame_static_jobs_cache: Dictionary = {}
var _attraction_instance_animated_jobs_cache: Dictionary = {}
var _attraction_instance_animated_line_jobs_cache: Dictionary = {}
var _attraction_instance_special_jobs_cache: Dictionary = {}
var _last_attraction_def_count: int = 0
var _last_attraction_instance_job_count: int = 0
var _last_frame_static_attraction_job_count: int = 0
var _last_animated_attraction_job_count: int = 0
var _last_attraction_line_job_count: int = 0
var _last_special_attraction_job_count: int = 0
var _last_passenger_attraction_job_count: int = 0
var _attraction_runtime_frames: Dictionary = {}
var _attraction_runtime_states: Dictionary = {}
var _last_animated_attraction_instances_advanced: int = 0
var _render_draw_count: int = 0
var _render_redraw_request_count: int = 0
var _render_log_timer: float = 0.0
var _last_high_job_count: int = 0
var _last_attraction_job_count: int = 0
var _last_visitor_job_count: int = 0
var _last_decor_job_count: int = 0
var _last_visible_tile_count: int = 0
var _last_high_jobs_usec: int = 0
var _last_static_job_count: int = 0
var _last_dynamic_job_count: int = 0
var _last_total_sorted_job_count: int = 0
var _last_static_cache_usec: int = 0
var _last_dynamic_jobs_usec: int = 0
var _static_high_jobs_cache: Array = []
var _static_high_jobs_cache_key: String = ""
var _static_high_jobs_cache_dirty: bool = true
var _static_high_jobs_cache_reason: String = "initial"
var _static_high_jobs_rebuild_count: int = 0
var _last_static_cache_rebuild_reason: String = "initial"
var _iso_depth_renderer_enabled: bool = false
var _iso_depth_renderer_synced: bool = false
var _last_observed_visible_bounds_key: String = ""
var _last_render_mode_key: String = ""
var _static_render_bounds: Rect2i = Rect2i()
var _static_render_bounds_valid: bool = false
var _static_render_bounds_refresh_count: int = 0
var _last_static_render_bounds_refresh_count_for_log: int = 0
var _last_static_render_bounds_reason: String = "initial"
var _last_static_render_tile_count: int = 0
var _visible_bounds_change_count: int = 0
var _last_visible_bounds_changed: bool = false
var _last_static_high_rebuild_count_for_log: int = 0
var _static_low_layer: Node2D = null
var _water_layer: Node2D = null
var _static_path_layer: Node2D = null
var _static_high_layer: Node2D = null
var _dynamic_depth_layer: Node2D = null
var _overlay_layer: Node2D = null
var _last_static_low_draws: int = 0
var _last_static_low_redraws: int = 0
var _last_water_draws: int = 0
var _last_water_redraws: int = 0
var _last_static_path_draws: int = 0
var _last_static_path_redraws: int = 0
var _last_static_high_draws: int = 0
var _last_static_high_redraws: int = 0
var _last_dynamic_draws: int = 0
var _last_dynamic_redraws: int = 0
var _last_overlay_draws: int = 0
var _last_overlay_redraws: int = 0


func _ready() -> void:
	texture_filter = CanvasItem.TEXTURE_FILTER_NEAREST
	_ensure_render_layers()
	_generate_external_decor_codes()
	_prepare_attraction_def_cache()
	_bind_visitor_system_from_parent()
	_bind_entrance_overlay_from_parent()
	_sync_entrance_overlay_mode()
	_request_all_layers_redraw("ready")


func _process(delta: float) -> void:
	_render_log_timer += delta
	_sync_visitor_render_mode()
	_sync_entrance_overlay_mode()
	_check_render_mode_changed()
	_check_visible_bounds_changed()
	_water_frame_timer += delta
	if _water_frame_timer >= WATER_ANIMATION_SECONDS:
		_water_frame_timer = 0.0
		if _has_visible_water_tiles(_get_visible_tile_bounds()):
			_water_frame = (_water_frame + 1) % WATER_TEXTURE_REGIONS.size()
			_request_water_redraw()
	if include_attraction_frame_static_chunks or include_attraction_animated_chunks or include_attraction_line_chunks or include_attraction_special_chunks or include_attraction_passenger_chunks:
		_attraction_frame_timer += delta
		if _attraction_frame_timer >= ATTRACTION_ANIMATION_SECONDS:
			_attraction_frame_timer = 0.0
			if _advance_visible_attraction_animation_frames(_get_visible_tile_bounds()):
				_attraction_frame = (_attraction_frame + 1) % 1024
				_request_dynamic_redraw()
	if _should_redraw_for_visitors():
		_request_dynamic_redraw()
	if debug_log_render_counters and _render_log_timer >= 1.0:
		_render_log_timer = 0.0
		_log_render_counters()


func configure(width: int, height: int) -> void:
	map_width = width
	map_height = height
	_request_all_layers_redraw("map configured")


func set_visitor_system(visitor_system: Node) -> void:
	_visitor_system = visitor_system
	_iso_depth_renderer_synced = false
	_sync_visitor_render_mode()
	_request_dynamic_redraw()


func _bind_visitor_system_from_parent() -> void:
	var parent_node: Node = get_parent()
	if parent_node == null:
		return
	var found_visitor_system: Node = parent_node.get_node_or_null("VisitorSystem")
	if found_visitor_system != null:
		set_visitor_system(found_visitor_system)


func _bind_entrance_overlay_from_parent() -> void:
	var parent_node: Node = get_parent()
	if parent_node == null:
		return
	_entrance_overlay = parent_node.get_node_or_null("EntranceOverlay") as Node2D
	if _entrance_overlay != null:
		_entrance_overlay.z_index = 4096


func _ensure_render_layers() -> void:
	_static_low_layer = _ensure_render_layer("StaticLowLayer", RENDER_LAYER_STATIC_LOW, 0)
	_water_layer = _ensure_render_layer("WaterLayer", RENDER_LAYER_WATER, 1)
	_static_path_layer = _ensure_render_layer("StaticPathLayer", RENDER_LAYER_STATIC_PATH, 2)
	_dynamic_depth_layer = _ensure_render_layer("DynamicDepthLayer", RENDER_LAYER_DYNAMIC_DEPTH, 10)
	_static_high_layer = _ensure_render_layer("StaticHighLayer", RENDER_LAYER_STATIC_HIGH, 20)
	_overlay_layer = _ensure_render_layer("OverlayLayer", RENDER_LAYER_OVERLAY, 100)


func _ensure_render_layer(node_name: String, layer_kind: String, layer_z_index: int) -> Node2D:
	var layer: Node2D = get_node_or_null(node_name) as Node2D
	if layer == null:
		layer = Node2D.new()
		layer.name = node_name
		add_child(layer)
	layer.set_script(MAP_RENDER_LAYER_SCRIPT)
	layer.z_index = layer_z_index
	layer.texture_filter = CanvasItem.TEXTURE_FILTER_NEAREST
	layer.call("configure", self, layer_kind)
	return layer


func _sync_visitor_render_mode() -> void:
	if _visitor_system == null or not _visitor_system.has_method("set_iso_depth_renderer_enabled"):
		return
	var next_enabled: bool = use_iso_visitor_depth_render and not debug_disable_visitor_render_jobs
	if _iso_depth_renderer_synced and _iso_depth_renderer_enabled == next_enabled:
		return
	_iso_depth_renderer_enabled = next_enabled
	_iso_depth_renderer_synced = true
	_visitor_system.call("set_iso_depth_renderer_enabled", next_enabled)
	_request_dynamic_redraw()


func _sync_entrance_overlay_mode() -> void:
	if _entrance_overlay == null:
		_bind_entrance_overlay_from_parent()
	var use_integrated_visitors: bool = use_iso_visitor_depth_render and not debug_disable_visitor_render_jobs
	var should_draw_in_isomap: bool = use_integrated_visitors or _entrance_overlay == null
	if _entrance_overlay != null:
		_entrance_overlay.set("tile_width", tile_width)
		_entrance_overlay.set("tile_height", tile_height)
		var should_show_overlay: bool = not use_integrated_visitors
		if _entrance_overlay.visible != should_show_overlay:
			_entrance_overlay.visible = should_show_overlay
			_entrance_overlay.queue_redraw()
		_entrance_overlay.z_index = 4096
	if _draw_entrance_high_in_isomap == should_draw_in_isomap:
		return
	_draw_entrance_high_in_isomap = should_draw_in_isomap
	_request_static_high_redraw("entrance overlay mode changed")


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
	_request_overlay_redraw()


func clear_selected_tile() -> void:
	selected_tile = Vector2i(-1, -1)
	_request_overlay_redraw()


func refresh_tiles() -> void:
	_request_all_layers_redraw("tiles refreshed")


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
	_request_overlay_redraw()


func _is_build_preview_active() -> bool:
	return GameState.current_mode == "build" and not Catalog.get_building(GameState.selected_catalog_id).is_empty()


func _draw() -> void:
	# Rendering lives in child CanvasItems so moving visitors can redraw only DynamicDepthLayer.
	pass


func _draw_render_layer(canvas: CanvasItem, layer_kind: String) -> void:
	var visible_bounds: Rect2i = _get_visible_tile_bounds()
	_last_observed_visible_bounds_key = _make_visible_bounds_key(visible_bounds)
	_last_visible_tile_count = visible_bounds.size.x * visible_bounds.size.y
	var static_bounds: Rect2i = _get_static_render_bounds(visible_bounds)
	match layer_kind:
		RENDER_LAYER_STATIC_LOW:
			_draw_static_low_layer(canvas, static_bounds)
		RENDER_LAYER_WATER:
			_draw_water_layer(canvas, static_bounds)
		RENDER_LAYER_STATIC_PATH:
			_draw_static_path_layer(canvas, static_bounds)
		RENDER_LAYER_STATIC_HIGH:
			_draw_static_high_layer(canvas, static_bounds)
		RENDER_LAYER_DYNAMIC_DEPTH:
			_draw_dynamic_depth_layer(canvas, visible_bounds)
		RENDER_LAYER_OVERLAY:
			_draw_overlay_layer(canvas)


func _draw_static_low_layer(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	_draw_external_ground(canvas, visible_bounds)
	_draw_terrain_tiles(canvas, visible_bounds)
	_draw_external_road(canvas, visible_bounds)


func _draw_water_layer(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	_draw_water_tiles(canvas, visible_bounds)


func _draw_static_path_layer(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	_draw_path_tiles(canvas, visible_bounds)
	_draw_external_border(canvas, visible_bounds)
	_draw_attraction_base_jobs(canvas, visible_bounds)


func _draw_static_high_layer(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	_draw_high_jobs(canvas, visible_bounds)


func _draw_dynamic_depth_layer(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	_draw_dynamic_visitor_jobs(canvas, visible_bounds)


func _draw_overlay_layer(canvas: CanvasItem) -> void:
	if is_inside_map(selected_tile):
		_draw_selected_tile(canvas)
	if _is_build_preview_active() and is_inside_map(preview_tile):
		_draw_build_preview(canvas)


func _draw_attraction_base_jobs(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	if debug_disable_attraction_render or not use_cached_attraction_chunk_render:
		return
	_prepare_attraction_def_cache()
	var jobs: Array = []
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var attraction_def: Dictionary = _get_attraction_def(String(building_data.get("id", "basic_attraction")), int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty():
			continue
		if not _debug_allows_attraction_jar_type(int(attraction_def.get("jar_type", building_data.get("jar_type", -1)))):
			continue
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		var orientation: int = int(building_data.get("orientation", 0))
		if _debug_allows_attraction_part("footprint"):
			_append_cached_attraction_tile_group_phase_jobs(
				jobs,
				origin,
				attraction_def.get("footprint_base_tile_groups", []) as Array,
				orientation,
				"base",
				ATTRACTION_BASE_LAYER_OFFSET
			)
		if debug_draw_chunk38 and _debug_allows_attraction_part("chunk38"):
			_append_cached_attraction_tile_group_phase_jobs(
				jobs,
				origin,
				attraction_def.get("chunk38_tile_groups", []) as Array,
				orientation,
				"base",
				ATTRACTION_BASE_LAYER_OFFSET + 20
			)
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	for job_entry in jobs:
		_draw_high_job(canvas, job_entry as Dictionary)


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


func _check_visible_bounds_changed() -> void:
	var visible_bounds: Rect2i = _get_visible_tile_bounds()
	var bounds_key: String = _make_visible_bounds_key(visible_bounds)
	_last_visible_bounds_changed = false
	if _last_observed_visible_bounds_key == "":
		_last_observed_visible_bounds_key = bounds_key
		if use_fixed_world_static_cache:
			_ensure_fixed_world_static_render_bounds("initial fixed world bounds")
		else:
			_ensure_static_render_bounds_for_visible(visible_bounds, "initial visible bounds")
		return
	if _last_observed_visible_bounds_key == bounds_key:
		return
	_last_observed_visible_bounds_key = bounds_key
	_last_visible_bounds_changed = true
	_visible_bounds_change_count += 1
	if use_fixed_world_static_cache:
		_ensure_fixed_world_static_render_bounds("fixed world bounds")
		return
	if _ensure_static_render_bounds_for_visible(visible_bounds, "visible bounds left static cache"):
		_request_static_cached_layers_redraw("static render bounds changed")


func _check_render_mode_changed() -> void:
	var render_mode_key: String = _make_render_mode_key()
	if _last_render_mode_key == "":
		_last_render_mode_key = render_mode_key
		return
	if _last_render_mode_key == render_mode_key:
		return
	_last_render_mode_key = render_mode_key
	_static_render_bounds_valid = false
	_request_static_cached_layers_redraw("render mode changed")


func _make_render_mode_key() -> String:
	return "simple=%s|chunk=%s|frame_static=%s|animated=%s|lines=%s|special=%s|passengers=%s|debug_attraction=%s|debug_mode=%s|debug_jar=%d|draw38=%s|draw_static=%s|draw_anim=%s|draw_lines=%s|draw_static_lines=%s|draw_animated_lines=%s|show_line_points=%s|draw_special=%s|show_special_anchors=%s|draw_passengers=%s|show_passenger_anchors=%s|chunk_labels=%s|chunk_anchors=%s|show_frame=%s|freeze_frame=%s|forced_frame=%d|iso_visitors=%s|entrance_high=%s|fixed_static=%s|fixed_margin=%d|camera_margin=%d" % [
		str(use_simple_attraction_render),
		str(use_cached_attraction_chunk_render),
		str(include_attraction_frame_static_chunks),
		str(include_attraction_animated_chunks),
		str(include_attraction_line_chunks),
		str(include_attraction_special_chunks),
		str(include_attraction_passenger_chunks),
		str(debug_disable_attraction_render),
		debug_attraction_visual_mode,
		debug_attraction_only_jar_type,
		str(debug_draw_chunk38),
		str(debug_draw_static_chunks),
		str(debug_draw_animated_chunks),
		str(debug_draw_line_chunks),
		str(debug_draw_static_lines),
		str(debug_draw_animated_lines),
		str(debug_show_line_points),
		str(debug_draw_special_chunks),
		str(debug_show_special_anchors),
		str(debug_draw_passenger_chunks),
		str(debug_show_passenger_anchors),
		str(debug_draw_chunk_labels),
		str(debug_draw_chunk_anchors),
		str(debug_show_animation_frame),
		str(debug_freeze_attraction_animation),
		debug_forced_attraction_frame,
		str(use_iso_visitor_depth_render and not debug_disable_visitor_render_jobs),
		str(_draw_entrance_high_in_isomap),
		str(use_fixed_world_static_cache),
		fixed_world_static_cache_margin,
		static_render_cache_margin,
	]


func _make_visible_bounds_key(visible_bounds: Rect2i) -> String:
	return "%d,%d,%d,%d" % [
		visible_bounds.position.x,
		visible_bounds.position.y,
		visible_bounds.size.x,
		visible_bounds.size.y,
	]


func _bounds_end_x(bounds: Rect2i) -> int:
	return bounds.position.x + bounds.size.x - 1


func _bounds_end_y(bounds: Rect2i) -> int:
	return bounds.position.y + bounds.size.y - 1


func _tile_in_bounds(tile: Vector2i, bounds: Rect2i) -> bool:
	return tile.x >= bounds.position.x and tile.x <= _bounds_end_x(bounds) and tile.y >= bounds.position.y and tile.y <= _bounds_end_y(bounds)


func _has_visible_water_tiles(visible_bounds: Rect2i) -> bool:
	for tile_data_entry in GameState.tiles:
		var tile_data: Dictionary = tile_data_entry
		if String(tile_data.get("type", "")) != GameState.TILE_TYPE_WATER:
			continue
		var tile: Vector2i = Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
		if _tile_in_bounds(tile, visible_bounds):
			return true
	return false


func _has_visible_animated_attractions(visible_bounds: Rect2i) -> bool:
	if not use_cached_attraction_chunk_render or debug_disable_attraction_render:
		return false
	_prepare_attraction_def_cache()
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var attraction_def: Dictionary = _get_attraction_def(String(building_data.get("id", "basic_attraction")), int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty():
			continue
		var has_frame_static_pieces: bool = include_attraction_frame_static_chunks and not (attraction_def.get("frame_static_tile_groups", []) as Array).is_empty()
		var has_animated_pieces: bool = include_attraction_animated_chunks and debug_draw_animated_chunks and not (attraction_def.get("animated_pieces", []) as Array).is_empty()
		var has_animated_lines: bool = include_attraction_line_chunks and debug_draw_line_chunks and debug_draw_animated_lines and not (attraction_def.get("animated_lines", []) as Array).is_empty()
		var has_special_pieces: bool = include_attraction_special_chunks and debug_draw_special_chunks and not (attraction_def.get("special_pieces", []) as Array).is_empty()
		var has_passenger_pieces: bool = include_attraction_passenger_chunks and debug_draw_passenger_chunks and bool((attraction_def.get("passenger_data", {}) as Dictionary).get("render_enabled", false))
		if not has_frame_static_pieces and not has_animated_pieces and not has_animated_lines and not has_special_pieces and not has_passenger_pieces:
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if _building_intersects_bounds(origin, size, visible_bounds):
			return true
	return false


func _advance_visible_attraction_animation_frames(visible_bounds: Rect2i) -> bool:
	_last_animated_attraction_instances_advanced = 0
	if debug_freeze_attraction_animation:
		return false
	_prepare_attraction_def_cache()
	var should_redraw_dynamic_layer: bool = false
	var active_counts: Dictionary = _get_attraction_active_counts_snapshot()
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var attraction_def: Dictionary = _get_attraction_def(String(building_data.get("id", "basic_attraction")), int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty():
			continue
		if not _attraction_def_has_dynamic_chunk_jobs(attraction_def):
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		var is_visible: bool = _building_intersects_bounds(origin, size, visible_bounds)
		var instance_key: String = _make_attraction_instance_cache_key(building_data, attraction_def)
		var active_count: int = int(active_counts.get(_attraction_origin_key(origin), 0))
		var current_frame: int = int(_attraction_runtime_frames.get(instance_key, int(building_data.get("animation_frame", 0))))
		if active_count <= 0:
			_attraction_runtime_states[instance_key] = 0
			if current_frame != 0:
				_attraction_runtime_frames[instance_key] = 0
				if is_visible:
					should_redraw_dynamic_layer = true
			continue
		var frame_limit: int = maxi(1, int(attraction_def.get("animation_frame_limit", attraction_def.get("animation_frame_count", 1))))
		_attraction_runtime_states[instance_key] = 3
		_attraction_runtime_frames[instance_key] = posmod(current_frame + 1, frame_limit)
		_last_animated_attraction_instances_advanced += 1
		if is_visible:
			should_redraw_dynamic_layer = true
	return should_redraw_dynamic_layer


func _get_attraction_active_counts_snapshot() -> Dictionary:
	if _visitor_system != null and _visitor_system.has_method("get_attraction_active_counts_snapshot"):
		return _visitor_system.call("get_attraction_active_counts_snapshot") as Dictionary
	return {}


func _draw_high_jobs(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	if debug_disable_high_draw_jobs:
		_last_high_job_count = 0
		_last_attraction_job_count = 0
		_last_frame_static_attraction_job_count = 0
		_last_animated_attraction_job_count = 0
		_last_attraction_line_job_count = 0
		_last_special_attraction_job_count = 0
		_last_passenger_attraction_job_count = 0
		_last_visitor_job_count = 0
		_last_decor_job_count = 0
		_last_static_job_count = 0
		_last_high_jobs_usec = 0
		return
	var start_usec: int = Time.get_ticks_usec()
	var static_jobs: Array = _get_static_high_jobs(visible_bounds)
	_last_static_job_count = static_jobs.size()
	_last_high_job_count = static_jobs.size()
	_last_total_sorted_job_count = static_jobs.size()
	for job_entry in static_jobs:
		_draw_high_job(canvas, job_entry as Dictionary)
	_last_high_jobs_usec = Time.get_ticks_usec() - start_usec


func _draw_dynamic_visitor_jobs(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	var start_usec: int = Time.get_ticks_usec()
	var dynamic_start_usec: int = Time.get_ticks_usec()
	var dynamic_jobs: Array = []
	_append_frame_static_attraction_jobs(dynamic_jobs, visible_bounds)
	_append_animated_attraction_jobs(dynamic_jobs, visible_bounds)
	_append_animated_attraction_line_jobs(dynamic_jobs, visible_bounds)
	_append_special_attraction_jobs(dynamic_jobs, visible_bounds)
	_append_attraction_passenger_jobs(dynamic_jobs, visible_bounds)
	_append_visitor_jobs(dynamic_jobs, visible_bounds)
	_last_dynamic_jobs_usec = Time.get_ticks_usec() - dynamic_start_usec
	_last_dynamic_job_count = dynamic_jobs.size()
	_last_visitor_job_count = dynamic_jobs.size() - _last_frame_static_attraction_job_count - _last_animated_attraction_job_count - _last_attraction_line_job_count - _last_special_attraction_job_count - _last_passenger_attraction_job_count
	if dynamic_jobs.size() > 1:
		dynamic_jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	for job_entry in dynamic_jobs:
		_draw_high_job(canvas, job_entry as Dictionary)
	_last_total_sorted_job_count = _last_static_job_count + dynamic_jobs.size()
	_last_high_jobs_usec = Time.get_ticks_usec() - start_usec


func _get_static_high_jobs(visible_bounds: Rect2i) -> Array:
	var cache_key: String = _make_static_high_jobs_cache_key(visible_bounds)
	if _static_high_jobs_cache_dirty or _static_high_jobs_cache_key != cache_key:
		var rebuild_reason: String = _static_high_jobs_cache_reason
		if not _static_high_jobs_cache_dirty and _static_high_jobs_cache_key != cache_key:
			rebuild_reason = "visible bounds/render mode changed"
		_rebuild_static_high_jobs_cache(visible_bounds, cache_key, rebuild_reason)
	return _static_high_jobs_cache


func _rebuild_static_high_jobs_cache(visible_bounds: Rect2i, cache_key: String, reason: String) -> void:
	var start_usec: int = Time.get_ticks_usec()
	var jobs: Array = []
	var before_count: int = jobs.size()
	_append_external_decor_jobs(jobs, visible_bounds)
	_append_natural_decor_jobs(jobs, visible_bounds)
	_last_decor_job_count = jobs.size() - before_count
	before_count = jobs.size()
	_append_attraction_jobs(jobs, visible_bounds)
	_last_attraction_job_count = jobs.size() - before_count
	_append_entrance_high_jobs(jobs, visible_bounds)
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	_static_high_jobs_cache = jobs
	_static_high_jobs_cache_key = cache_key
	_static_high_jobs_cache_dirty = false
	_static_high_jobs_cache_reason = ""
	_static_high_jobs_rebuild_count += 1
	_last_static_cache_rebuild_reason = reason
	_last_static_cache_usec = Time.get_ticks_usec() - start_usec


func _make_static_high_jobs_cache_key(visible_bounds: Rect2i) -> String:
	return "%d,%d,%d,%d|%d,%d|simple=%s|chunk=%s|frame_static=%s|animated=%s|lines=%s|special=%s|passengers=%s|attractions=%s|debug_mode=%s|debug_jar=%d|draw38=%s|draw_static=%s|draw_anim=%s|draw_lines=%s|draw_static_lines=%s|draw_animated_lines=%s|show_line_points=%s|draw_special=%s|show_special_anchors=%s|draw_passengers=%s|show_passenger_anchors=%s|chunk_labels=%s|chunk_anchors=%s|entrance_high=%s" % [
		visible_bounds.position.x,
		visible_bounds.position.y,
		visible_bounds.size.x,
		visible_bounds.size.y,
		map_width,
		map_height,
		str(use_simple_attraction_render),
		str(use_cached_attraction_chunk_render),
		str(include_attraction_frame_static_chunks),
		str(include_attraction_animated_chunks),
		str(include_attraction_line_chunks),
		str(include_attraction_special_chunks),
		str(include_attraction_passenger_chunks),
		str(not debug_disable_attraction_render),
		debug_attraction_visual_mode,
		debug_attraction_only_jar_type,
		str(debug_draw_chunk38),
		str(debug_draw_static_chunks),
		str(debug_draw_animated_chunks),
		str(debug_draw_line_chunks),
		str(debug_draw_static_lines),
		str(debug_draw_animated_lines),
		str(debug_show_line_points),
		str(debug_draw_special_chunks),
		str(debug_show_special_anchors),
		str(debug_draw_passenger_chunks),
		str(debug_show_passenger_anchors),
		str(debug_draw_chunk_labels),
		str(debug_draw_chunk_anchors),
		str(_draw_entrance_high_in_isomap),
	]
func _get_static_render_bounds(visible_bounds: Rect2i) -> Rect2i:
	if use_fixed_world_static_cache:
		_ensure_fixed_world_static_render_bounds("draw fixed world bounds initialized")
		_last_static_render_tile_count = _static_render_bounds.size.x * _static_render_bounds.size.y
		return _static_render_bounds
	_ensure_static_render_bounds_for_visible(visible_bounds, "draw bounds initialized")
	_last_static_render_tile_count = _static_render_bounds.size.x * _static_render_bounds.size.y
	return _static_render_bounds


func _ensure_static_render_bounds_for_visible(visible_bounds: Rect2i, reason: String) -> bool:
	if use_fixed_world_static_cache:
		return _ensure_fixed_world_static_render_bounds(reason)
	if _static_render_bounds_valid and _bounds_contains(_static_render_bounds, visible_bounds):
		return false
	var cache_margin: int = maxi(0, static_render_cache_margin)
	_static_render_bounds = Rect2i(
		visible_bounds.position - Vector2i(cache_margin, cache_margin),
		visible_bounds.size + Vector2i(cache_margin * 2, cache_margin * 2)
	)
	_static_render_bounds_valid = true
	_static_render_bounds_refresh_count += 1
	_last_static_render_bounds_reason = reason
	_last_static_render_tile_count = _static_render_bounds.size.x * _static_render_bounds.size.y
	return true


func _ensure_fixed_world_static_render_bounds(reason: String) -> bool:
	var next_bounds: Rect2i = _make_fixed_world_static_bounds()
	if _static_render_bounds_valid and _static_render_bounds == next_bounds:
		return false
	_static_render_bounds = next_bounds
	_static_render_bounds_valid = true
	_static_render_bounds_refresh_count += 1
	_last_static_render_bounds_reason = reason
	_last_static_render_tile_count = _static_render_bounds.size.x * _static_render_bounds.size.y
	return true


func _make_fixed_world_static_bounds() -> Rect2i:
	var cache_margin: int = maxi(1, fixed_world_static_cache_margin)
	return Rect2i(
		Vector2i(-cache_margin, -cache_margin),
		Vector2i(map_width + cache_margin * 2, map_height + cache_margin * 2)
	)


func _bounds_contains(outer_bounds: Rect2i, inner_bounds: Rect2i) -> bool:
	return (
		inner_bounds.position.x >= outer_bounds.position.x
		and inner_bounds.position.y >= outer_bounds.position.y
		and _bounds_end_x(inner_bounds) <= _bounds_end_x(outer_bounds)
		and _bounds_end_y(inner_bounds) <= _bounds_end_y(outer_bounds)
	)


func _invalidate_static_high_jobs_cache(reason: String) -> void:
	_static_high_jobs_cache_dirty = true
	_static_high_jobs_cache_reason = reason
	_attraction_instance_jobs_cache.clear()
	_attraction_instance_frame_static_jobs_cache.clear()
	_attraction_instance_animated_jobs_cache.clear()
	_attraction_instance_animated_line_jobs_cache.clear()
	_attraction_instance_special_jobs_cache.clear()


func _draw_merged_high_jobs(canvas: CanvasItem, static_jobs: Array, dynamic_jobs: Array) -> void:
	if dynamic_jobs.is_empty():
		for job_entry in static_jobs:
			_draw_high_job(canvas, job_entry as Dictionary)
		return
	if static_jobs.is_empty():
		for job_entry in dynamic_jobs:
			_draw_high_job(canvas, job_entry as Dictionary)
		return
	var static_index: int = 0
	var dynamic_index: int = 0
	while static_index < static_jobs.size() and dynamic_index < dynamic_jobs.size():
		var static_job: Dictionary = static_jobs[static_index] as Dictionary
		var dynamic_job: Dictionary = dynamic_jobs[dynamic_index] as Dictionary
		if int(static_job.get("depth_key", 0)) <= int(dynamic_job.get("depth_key", 0)):
			_draw_high_job(canvas, static_job)
			static_index += 1
		else:
			_draw_high_job(canvas, dynamic_job)
			dynamic_index += 1
	while static_index < static_jobs.size():
		_draw_high_job(canvas, static_jobs[static_index] as Dictionary)
		static_index += 1
	while dynamic_index < dynamic_jobs.size():
		_draw_high_job(canvas, dynamic_jobs[dynamic_index] as Dictionary)
		dynamic_index += 1


func _draw_high_job(canvas: CanvasItem, job: Dictionary) -> void:
	var draw_type: String = String(job.get("draw_type", "texture"))
	if draw_type == "attraction_placeholder":
		canvas.draw_colored_polygon(job.get("points", PackedVector2Array()) as PackedVector2Array, job.get("fill_color", Color.WHITE) as Color)
		canvas.draw_polyline(job.get("outline", PackedVector2Array()) as PackedVector2Array, job.get("outline_color", Color.WHITE) as Color, float(job.get("outline_width", 1.0)))
		return
	if draw_type == "attraction_line":
		canvas.draw_line(
			job.get("start", Vector2.ZERO) as Vector2,
			job.get("end", Vector2.ZERO) as Vector2,
			job.get("color", Color.BLACK) as Color,
			float(job.get("width", 1.0))
		)
		return
	if draw_type == "debug_anchor":
		var center: Vector2 = job.get("position", Vector2.ZERO) as Vector2
		var color: Color = job.get("color", Color.YELLOW) as Color
		canvas.draw_circle(center, float(job.get("radius", 2.0)), color)
		canvas.draw_line(center + Vector2(-4.0, 0.0), center + Vector2(4.0, 0.0), color, 1.0)
		canvas.draw_line(center + Vector2(0.0, -4.0), center + Vector2(0.0, 4.0), color, 1.0)
		return
	if draw_type == "debug_label":
		var font: Font = ThemeDB.fallback_font
		if font != null:
			canvas.draw_string(
				font,
				job.get("position", Vector2.ZERO) as Vector2,
				String(job.get("text", "")),
				HORIZONTAL_ALIGNMENT_LEFT,
				-1.0,
				8,
				job.get("color", Color.WHITE) as Color
			)
		return
	var texture: Texture2D = job.get("texture", null) as Texture2D
	if texture == null:
		return
	canvas.draw_texture_rect_region(
		texture,
		Rect2(job.get("position", Vector2.ZERO) as Vector2, job.get("region_size", Vector2.ZERO) as Vector2),
		job.get("region", Rect2()) as Rect2
	)


func _append_natural_decor_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
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
				_append_natural_decor_tile_jobs(jobs, tile, decor_code)


func _append_external_decor_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	_ensure_external_decor_codes()
	for x in range(visible_bounds.position.x, _bounds_end_x(visible_bounds) + 1):
		for y in range(visible_bounds.position.y, _bounds_end_y(visible_bounds) + 1):
			var tile: Vector2i = Vector2i(x, y)
			var decor_code: int = _get_external_decor_code(tile)
			if decor_code > 0:
				_append_natural_decor_tile_jobs(jobs, tile, decor_code)


func _append_natural_decor_tile_jobs(jobs: Array, tile: Vector2i, decor_code: int) -> void:
	var decor_index: int = decor_code - 1
	if decor_index < 0 or decor_index >= NATURAL_DECOR_PIECES.size():
		return
	var decor_pieces: Array = NATURAL_DECOR_PIECES[decor_index] as Array
	for piece_index in range(decor_pieces.size()):
		var piece: Array = decor_pieces[piece_index] as Array
		var source_region: Rect2 = piece[0] as Rect2
		var offset: Vector2 = piece[1] as Vector2
		jobs.append(_make_tile_sprite_job(
			NATURAL_DECOR_TEXTURE,
			tile,
			source_region,
			offset,
			HIGH_DRAW_LAYER_DECOR + piece_index
		))


func _append_entrance_high_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	if not _draw_entrance_high_in_isomap:
		return
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	var left_tile: Vector2i = Vector2i(entry_tile.x - 1, -1)
	var right_tile: Vector2i = Vector2i(entry_tile.x + 1, -1)
	if _tile_in_bounds(left_tile, visible_bounds):
		jobs.append(_make_tile_sprite_job(ENTRANCE_TEXTURE, left_tile, ENTRANCE_ROCK_REGION, Vector2(14.0, -2.0), HIGH_DRAW_LAYER_ENTRANCE))
		jobs.append(_make_tile_sprite_job(ENTRANCE_TEXTURE, left_tile, ENTRANCE_ROCK_REGION, Vector2(15.0, -8.0), HIGH_DRAW_LAYER_ENTRANCE + 1))
		jobs.append(_make_tile_sprite_job(ENTRANCE_TEXTURE, left_tile, ENTRANCE_ROCK_REGION, Vector2(17.0, -14.0), HIGH_DRAW_LAYER_ENTRANCE + 2))
	if _tile_in_bounds(right_tile, visible_bounds):
		jobs.append(_make_tile_sprite_job(ENTRANCE_TEXTURE, right_tile, ENTRANCE_ROCK_REGION, Vector2(4.0, -7.0), HIGH_DRAW_LAYER_ENTRANCE))
		jobs.append(_make_tile_sprite_job(ENTRANCE_TEXTURE, right_tile, ENTRANCE_ROCK_REGION, Vector2(3.0, -15.0), HIGH_DRAW_LAYER_ENTRANCE + 1))
		jobs.append(_make_tile_sprite_job(ENTRANCE_TEXTURE, right_tile, ENTRANCE_ROCK_REGION, Vector2(2.0, -23.0), HIGH_DRAW_LAYER_ENTRANCE + 2))
		jobs.append(_make_tile_sprite_job(PATH_TEXTURE, right_tile, ENTRANCE_SIGN_REGION_A, Vector2(-19.0, -44.0), HIGH_DRAW_LAYER_ENTRANCE + 8))
		jobs.append(_make_tile_sprite_job(PATH_TEXTURE, right_tile, ENTRANCE_SIGN_REGION_B, Vector2(-4.0, -33.0), HIGH_DRAW_LAYER_ENTRANCE + 9))


func _append_attraction_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	if debug_disable_attraction_render:
		return
	if use_cached_attraction_chunk_render:
		_append_cached_attraction_chunk_jobs(jobs, visible_bounds)
		return
	if use_simple_attraction_render:
		_append_simple_attraction_jobs(jobs, visible_bounds)
		return
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var catalog_data: Dictionary = Catalog.get_building(String(building_data.get("id", "basic_attraction")))
		if catalog_data.is_empty():
			continue
		var size_data: Array = catalog_data.get("size", [1, 1]) as Array
		var size: Vector2i = Vector2i(int(size_data[0]), int(size_data[1]))
		var bounds_tile: Vector2i = origin + Vector2i(floori(float(size.x) * 0.5), floori(float(size.y) * 0.5))
		if not _tile_in_bounds(bounds_tile, visible_bounds) and not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		_append_attraction_piece_jobs(jobs, origin, catalog_data.get("visual_static_pieces", []) as Array)
		_append_attraction_piece_jobs(jobs, origin, catalog_data.get("visual_animated_pieces", []) as Array)


func _append_cached_attraction_chunk_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	_prepare_attraction_def_cache()
	var before_count: int = jobs.size()
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var catalog_id: String = String(building_data.get("id", "basic_attraction"))
		var attraction_def: Dictionary = _get_attraction_def(catalog_id, int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty():
			_append_simple_attraction_building_jobs(jobs, building_data, visible_bounds)
			continue
		if not _debug_allows_attraction_jar_type(int(attraction_def.get("jar_type", building_data.get("jar_type", -1)))):
			continue
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		var instance_jobs: Array = _get_attraction_instance_static_jobs(building_data, attraction_def)
		var has_cached_base_jobs: bool = not (attraction_def.get("footprint_base_tile_groups", []) as Array).is_empty() or not (attraction_def.get("chunk38_tile_groups", []) as Array).is_empty()
		if instance_jobs.is_empty() and not _attraction_def_has_dynamic_chunk_jobs(attraction_def) and not has_cached_base_jobs:
			_append_simple_attraction_building_jobs(jobs, building_data, visible_bounds)
			continue
		for job_entry in instance_jobs:
			var job: Dictionary = job_entry as Dictionary
			var anchor_tile: Vector2i = job.get("anchor_tile", Vector2i(-9999, -9999)) as Vector2i
			if _tile_in_bounds(anchor_tile, visible_bounds):
				jobs.append(job)
	_last_attraction_instance_job_count = jobs.size() - before_count


func _prepare_attraction_def_cache() -> void:
	if _attraction_def_cache_prepared:
		return
	_attraction_def_cache_prepared = true
	var unique_defs: int = 0
	for catalog_id_entry in Catalog.buildings.keys():
		var catalog_id: String = String(catalog_id_entry)
		var catalog_data: Dictionary = Catalog.get_building(catalog_id)
		if String(catalog_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(catalog_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var attraction_def: Dictionary = _build_attraction_def(catalog_id, catalog_data)
		if attraction_def.is_empty():
			continue
		_attraction_def_cache[catalog_id] = attraction_def
		_attraction_def_cache["jar:%d" % int(catalog_data.get("jar_type", -1))] = attraction_def
		unique_defs += 1
	_last_attraction_def_count = unique_defs


func _build_attraction_def(catalog_id: String, catalog_data: Dictionary) -> Dictionary:
	var size_values: Array = catalog_data.get("size", [1, 1]) as Array
	var size: Vector2i = Vector2i(int(size_values[0]), int(size_values[1]))
	var jar_type: int = int(catalog_data.get("jar_type", -1))
	var visual_data: Dictionary = catalog_data
	if Catalog.has_method("get_attraction_visual"):
		var loaded_visual_data: Variant = Catalog.call("get_attraction_visual", catalog_id, jar_type)
		if loaded_visual_data is Dictionary and not (loaded_visual_data as Dictionary).is_empty():
			visual_data = loaded_visual_data as Dictionary
	var static_pieces: Array = _build_attraction_piece_defs(visual_data.get("visual_static_pieces", []) as Array, false)
	var animated_piece_entries: Array = visual_data.get("visual_animated_pieces", catalog_data.get("visual_animated_pieces", [])) as Array
	var static_line_entries: Array = visual_data.get("visual_static_lines", catalog_data.get("visual_static_lines", [])) as Array
	var animated_line_entries: Array = visual_data.get("visual_animated_lines", catalog_data.get("visual_animated_lines", [])) as Array
	var special_piece_entries: Array = visual_data.get("visual_special_pieces", catalog_data.get("visual_special_pieces", [])) as Array
	var passenger_data: Dictionary = visual_data.get("visual_passenger_chunks", catalog_data.get("visual_passenger_chunks", {})) as Dictionary
	var animated_pieces: Array = _build_attraction_piece_defs(animated_piece_entries, true)
	var static_lines: Array = _build_attraction_line_defs(static_line_entries, false)
	var animated_lines: Array = _build_attraction_line_defs(animated_line_entries, true)
	var special_pieces: Array = _build_attraction_special_piece_defs(special_piece_entries)
	var static_tile_groups: Array = _build_attraction_static_tile_groups(visual_data.get("visual_static_tiles", []) as Array, static_pieces)
	var frame_static_tile_groups: Array = _build_attraction_static_tile_groups(visual_data.get("visual_frame_static_tiles", []) as Array, static_pieces)
	var ak_pieces: Array = _build_attraction_piece_defs(visual_data.get("visual_ak_pieces", visual_data.get("visual_chunk38_ak_pieces", [])) as Array, false)
	var chunk38_tile_groups: Array = _build_attraction_static_tile_groups(visual_data.get("visual_chunk38_tiles", []) as Array, ak_pieces)
	var footprint_base_tile_groups: Array = _build_attraction_static_tile_groups(visual_data.get("visual_footprint_base_tiles", []) as Array, ak_pieces)
	if static_pieces.is_empty() and static_tile_groups.is_empty() and frame_static_tile_groups.is_empty() and chunk38_tile_groups.is_empty() and footprint_base_tile_groups.is_empty() and animated_pieces.is_empty() and static_lines.is_empty() and animated_lines.is_empty() and special_pieces.is_empty() and passenger_data.is_empty():
		return {}
	return {
		"id": catalog_id,
		"jar_type": jar_type,
		"size": size,
		"ride_anchor": _get_attraction_ride_anchor(visual_data, size),
		"ride_anchors": _get_attraction_ride_anchors(visual_data, size),
		"static_pieces": static_pieces,
		"static_tile_groups": static_tile_groups,
		"frame_static_tile_groups": frame_static_tile_groups,
		"chunk38_tile_groups": chunk38_tile_groups,
		"footprint_base_tile_groups": footprint_base_tile_groups,
		"animated_pieces": animated_pieces,
		"static_lines": static_lines,
		"animated_lines": animated_lines,
		"special_pieces": special_pieces,
		"passenger_data": passenger_data,
		"animation_frame_limit": int(visual_data.get("animation_frame_limit", visual_data.get("use_frame_count", catalog_data.get("use_frame_count", 1)))),
		"visual_frame_modulo": int(visual_data.get("visual_frame_modulo", visual_data.get("visual_animation_frame_count", catalog_data.get("visual_animation_frame_count", 1)))),
		"animation_frame_count": int(visual_data.get("visual_frame_modulo", visual_data.get("visual_animation_frame_count", catalog_data.get("visual_animation_frame_count", 1)))),
		"visual_source": String(visual_data.get("visual_source", catalog_data.get("visual_source", ""))),
	}
func _attraction_def_has_dynamic_chunk_jobs(attraction_def: Dictionary) -> bool:
	if include_attraction_frame_static_chunks and not (attraction_def.get("frame_static_tile_groups", []) as Array).is_empty():
		return true
	if include_attraction_animated_chunks and debug_draw_animated_chunks and not (attraction_def.get("animated_pieces", []) as Array).is_empty():
		return true
	if include_attraction_line_chunks and debug_draw_line_chunks and debug_draw_animated_lines and not (attraction_def.get("animated_lines", []) as Array).is_empty():
		return true
	if include_attraction_special_chunks and debug_draw_special_chunks and not (attraction_def.get("special_pieces", []) as Array).is_empty():
		return true
	if include_attraction_passenger_chunks and debug_draw_passenger_chunks and bool((attraction_def.get("passenger_data", {}) as Dictionary).get("render_enabled", false)):
		return true
	return false
func _debug_allows_attraction_part(part: String) -> bool:
	var mode: String = debug_attraction_visual_mode.strip_edges().to_lower()
	if mode == "" or mode == "all":
		return true
	if mode == "none":
		return false
	if mode == "base":
		return part == "footprint" or part == "chunk38"
	if mode == "footprint":
		return part == "footprint"
	if mode == "chunk38":
		return part == "chunk38"
	if mode == "static" or mode == "static_chunks":
		return part == "static"
	if mode == "animated" or mode == "animated_chunks":
		return part == "animated"
	if mode == "lines" or mode == "line_chunks":
		return part == "static_line" or part == "animated_line"
	if mode == "static_lines":
		return part == "static_line"
	if mode == "animated_lines":
		return part == "animated_line"
	if mode == "special" or mode == "special_chunks":
		return part == "special"
	if mode == "passenger" or mode == "passengers" or mode == "passenger_chunks":
		return part == "passenger"
	return true


func _debug_allows_attraction_jar_type(jar_type: int) -> bool:
	return debug_attraction_only_jar_type < 0 or debug_attraction_only_jar_type == jar_type


func _get_attraction_ride_anchor(catalog_data: Dictionary, size: Vector2i) -> Vector2i:
	var anchor_values: Array = catalog_data.get("visual_ride_anchor", []) as Array
	if anchor_values.size() >= 2:
		return Vector2i(int(anchor_values[0]), int(anchor_values[1]))
	var footprint_codes: Array = catalog_data.get("footprint_codes", []) as Array
	var footprint_height: int = maxi(1, size.y)
	for index in range(footprint_codes.size()):
		if int(footprint_codes[index]) == 10:
			return Vector2i(floori(float(index) / float(footprint_height)), index % footprint_height)
	return Vector2i.ZERO


func _get_attraction_ride_anchors(catalog_data: Dictionary, size: Vector2i) -> Array:
	var anchors: Array = []
	var anchor_entries: Array = catalog_data.get("visual_ride_anchors", []) as Array
	for anchor_entry in anchor_entries:
		var anchor_values: Array = anchor_entry as Array
		if anchor_values.size() >= 2:
			anchors.append(Vector2i(int(anchor_values[0]), int(anchor_values[1])))
	if anchors.is_empty():
		anchors.append(_get_attraction_ride_anchor(catalog_data, size))
	return anchors


func _get_attraction_ride_anchor_for_orientation(attraction_def: Dictionary, orientation: int) -> Vector2i:
	var anchors: Array = attraction_def.get("ride_anchors", []) as Array
	if anchors.is_empty():
		return attraction_def.get("ride_anchor", Vector2i.ZERO) as Vector2i
	return anchors[clampi(orientation, 0, anchors.size() - 1)] as Vector2i


func _build_attraction_piece_defs(piece_entries: Array, is_animated: bool) -> Array:
	var pieces: Array = []
	for piece_entry in piece_entries:
		var piece_data: Dictionary = piece_entry
		var texture: Texture2D = _get_or_load_attraction_texture(String(piece_data.get("sheet", "")))
		if texture == null:
			continue
		var region_values: Array = piece_data.get("region", []) as Array
		var offset_values: Array = piece_data.get("offset", [0, 0]) as Array
		var anchor_values: Array = piece_data.get("anchor", [0, 0]) as Array
		if region_values.size() < 4 or offset_values.size() < 2 or anchor_values.size() < 2:
			continue
		var piece_def: Dictionary = {
			"texture": texture,
			"region": Rect2(float(region_values[0]), float(region_values[1]), float(region_values[2]), float(region_values[3])),
			"offset": Vector2(float(offset_values[0]), float(offset_values[1])),
			"anchor": Vector2i(int(anchor_values[0]), int(anchor_values[1])),
			"piece_index": int(piece_data.get("piece_index", pieces.size())),
			"animated": is_animated,
		}
		var visible_frames: Array = piece_data.get("visible_frames", []) as Array
		if not visible_frames.is_empty():
			piece_def["visible_frames"] = visible_frames
			piece_def["frame_dependent"] = bool(piece_data.get("frame_dependent", false))
		if is_animated:
			piece_def["animated_offsets_x"] = piece_data.get("animated_offsets_x", []) as Array
			piece_def["animated_offsets_y"] = piece_data.get("animated_offsets_y", []) as Array
			piece_def["anchor_frames"] = piece_data.get("anchor_frames", []) as Array
			piece_def["visible_frames"] = piece_data.get("visible_frames", []) as Array
			piece_def["frame_count"] = int(piece_data.get("frame_count", 1))
		pieces.append(piece_def)
	return pieces
func _build_attraction_special_piece_defs(piece_entries: Array) -> Array:
	var pieces: Array = []
	for piece_entry in piece_entries:
		var piece_data: Dictionary = piece_entry
		var texture: Texture2D = _get_or_load_attraction_texture(String(piece_data.get("sheet", "")))
		if texture == null:
			continue
		var region_values: Array = piece_data.get("region", []) as Array
		var anchor_values: Array = piece_data.get("anchor", [0, 0]) as Array
		var offset_frames: Array = piece_data.get("offset_frames", []) as Array
		if region_values.size() < 4 or anchor_values.size() < 2 or offset_frames.is_empty():
			continue
		pieces.append({
			"texture": texture,
			"region": Rect2(float(region_values[0]), float(region_values[1]), float(region_values[2]), float(region_values[3])),
			"region_size": Vector2(float(region_values[2]), float(region_values[3])),
			"anchor": Vector2i(int(anchor_values[0]), int(anchor_values[1])),
			"anchor_frames": piece_data.get("anchor_frames", []) as Array,
			"offset_frames": offset_frames,
			"frame_start": int(piece_data.get("frame_start", 0)),
			"frame_end": int(piece_data.get("frame_end", -1)),
			"piece_index": int(piece_data.get("piece_index", pieces.size())),
			"frame_count": int(piece_data.get("frame_count", 1)),
		})
	return pieces


func _build_attraction_line_defs(line_entries: Array, is_animated: bool) -> Array:
	var lines: Array = []
	for line_entry in line_entries:
		var line_data: Dictionary = line_entry
		if bool(line_data.get("skipped_by_chunk4_2", false)):
			continue
		var anchor_values: Array = line_data.get("anchor", [0, 0]) as Array
		var color_values: Array = line_data.get("color", [0, 0, 0]) as Array
		if anchor_values.size() < 2 or color_values.size() < 3:
			continue
		var line_def: Dictionary = {
			"anchor": Vector2i(int(anchor_values[0]), int(anchor_values[1])),
			"color": Color8(int(color_values[0]), int(color_values[1]), int(color_values[2])),
			"line_index": int(line_data.get("line_index", lines.size())),
			"animated": is_animated,
			"source": String(line_data.get("source", "")),
		}
		if is_animated:
			var start_frames: Array = line_data.get("start_frames", []) as Array
			var end_frames: Array = line_data.get("end_frames", []) as Array
			if start_frames.is_empty() or end_frames.is_empty():
				continue
			line_def["start_frames"] = start_frames
			line_def["end_frames"] = end_frames
			line_def["frame_count"] = int(line_data.get("frame_count", 1))
		else:
			var start_values: Array = line_data.get("start", []) as Array
			var end_values: Array = line_data.get("end", []) as Array
			if start_values.size() < 2 or end_values.size() < 2:
				continue
			line_def["start"] = Vector2(float(start_values[0]), float(start_values[1]))
			line_def["end"] = Vector2(float(end_values[0]), float(end_values[1]))
		lines.append(line_def)
	return lines


func _build_attraction_static_tile_groups(tile_entries: Array, static_pieces: Array) -> Array:
	var pieces_by_index: Dictionary = {}
	for piece_entry in static_pieces:
		var piece: Dictionary = piece_entry
		pieces_by_index[int(piece.get("piece_index", 0))] = piece
	var tile_groups: Array = []
	for tile_entry in tile_entries:
		var tile_data: Dictionary = tile_entry
		var anchor_values: Array = tile_data.get("anchor", [0, 0]) as Array
		var piece_indices: Array = tile_data.get("piece_indices", []) as Array
		if anchor_values.size() < 2 or piece_indices.is_empty():
			continue
		var group_pieces: Array = []
		for piece_index_entry in piece_indices:
			var piece_index: int = int(piece_index_entry)
			if pieces_by_index.has(piece_index):
				group_pieces.append(pieces_by_index[piece_index])
		if group_pieces.is_empty():
			continue
		tile_groups.append({
			"orientation": int(tile_data.get("orientation", 0)),
			"anchor": Vector2i(int(anchor_values[0]), int(anchor_values[1])),
			"pieces": group_pieces,
			"chunk_group": int(tile_data.get("chunk_group", tile_groups.size())),
			"mask_unsigned": int(tile_data.get("mask_unsigned", 0)),
			"footprint_code": int(tile_data.get("footprint_code", 0)),
			"source": String(tile_data.get("source", "")),
		})
	return tile_groups
func _get_attraction_def(catalog_id: String, jar_type: int) -> Dictionary:
	if _attraction_def_cache.has(catalog_id):
		return _attraction_def_cache[catalog_id] as Dictionary
	var jar_key: String = "jar:%d" % jar_type
	if _attraction_def_cache.has(jar_key):
		return _attraction_def_cache[jar_key] as Dictionary
	return {}


func _get_attraction_instance_static_jobs(building_data: Dictionary, attraction_def: Dictionary) -> Array:
	var cache_key: String = _make_attraction_instance_cache_key(building_data, attraction_def)
	if _attraction_instance_jobs_cache.has(cache_key):
		return _attraction_instance_jobs_cache[cache_key] as Array
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var orientation: int = int(building_data.get("orientation", 0))
	var ride_anchor: Vector2i = origin + _get_attraction_ride_anchor_for_orientation(attraction_def, orientation)
	var jobs: Array = []
	if debug_draw_chunk38 and _debug_allows_attraction_part("chunk38"):
		_append_cached_attraction_tile_group_phase_jobs(
			jobs,
			origin,
			attraction_def.get("chunk38_tile_groups", []) as Array,
			orientation,
			"high",
			ATTRACTION_HIGH_CHUNK38_LAYER_OFFSET
		)
	if debug_draw_static_chunks and _debug_allows_attraction_part("static"):
		var static_tile_groups: Array = attraction_def.get("static_tile_groups", []) as Array
		if not static_tile_groups.is_empty():
			_append_cached_attraction_tile_group_jobs(jobs, origin, static_tile_groups, orientation)
		else:
			var static_pieces: Array = attraction_def.get("static_pieces", []) as Array
			_append_cached_attraction_piece_jobs(jobs, origin, static_pieces)
	var static_lines: Array = attraction_def.get("static_lines", []) as Array
	_append_cached_attraction_line_jobs(jobs, ride_anchor, static_lines)
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	_attraction_instance_jobs_cache[cache_key] = jobs
	return jobs
func _append_frame_static_attraction_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	_last_frame_static_attraction_job_count = 0
	if not include_attraction_frame_static_chunks or debug_disable_attraction_render or not use_cached_attraction_chunk_render:
		return
	_prepare_attraction_def_cache()
	var before_count: int = jobs.size()
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var catalog_id: String = String(building_data.get("id", "basic_attraction"))
		var attraction_def: Dictionary = _get_attraction_def(catalog_id, int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty() or (attraction_def.get("frame_static_tile_groups", []) as Array).is_empty():
			continue
		if not _debug_allows_attraction_jar_type(int(attraction_def.get("jar_type", building_data.get("jar_type", -1)))):
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		var frame: int = _get_attraction_animation_frame(building_data, attraction_def)
		var instance_jobs: Array = _get_attraction_instance_frame_static_jobs(building_data, attraction_def, frame)
		for job_entry in instance_jobs:
			var job: Dictionary = job_entry as Dictionary
			var anchor_tile: Vector2i = job.get("anchor_tile", Vector2i(-9999, -9999)) as Vector2i
			if _tile_in_bounds(anchor_tile, visible_bounds):
				jobs.append(job)
	_last_frame_static_attraction_job_count = jobs.size() - before_count


func _get_attraction_instance_frame_static_jobs(building_data: Dictionary, attraction_def: Dictionary, frame: int) -> Array:
	var cache_key: String = _make_attraction_animated_instance_cache_key(building_data, attraction_def, frame) + "|frame_static"
	if _attraction_instance_frame_static_jobs_cache.has(cache_key):
		return _attraction_instance_frame_static_jobs_cache[cache_key] as Array
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var orientation: int = int(building_data.get("orientation", 0))
	var jobs: Array = []
	if debug_draw_static_chunks and _debug_allows_attraction_part("static"):
		_append_cached_attraction_tile_group_jobs(jobs, origin, attraction_def.get("frame_static_tile_groups", []) as Array, orientation, frame)
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	_attraction_instance_frame_static_jobs_cache[cache_key] = jobs
	return jobs


func _append_animated_attraction_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	_last_animated_attraction_job_count = 0
	if not include_attraction_animated_chunks or not debug_draw_animated_chunks or debug_disable_attraction_render or not use_cached_attraction_chunk_render:
		return
	_prepare_attraction_def_cache()
	var before_count: int = jobs.size()
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var catalog_id: String = String(building_data.get("id", "basic_attraction"))
		var attraction_def: Dictionary = _get_attraction_def(catalog_id, int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty() or (attraction_def.get("animated_pieces", []) as Array).is_empty():
			continue
		if not _debug_allows_attraction_jar_type(int(attraction_def.get("jar_type", building_data.get("jar_type", -1)))):
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		var frame: int = _get_attraction_animation_frame(building_data, attraction_def)
		var instance_jobs: Array = _get_attraction_instance_animated_jobs(building_data, attraction_def, frame)
		for job_entry in instance_jobs:
			var job: Dictionary = job_entry as Dictionary
			var anchor_tile: Vector2i = job.get("anchor_tile", Vector2i(-9999, -9999)) as Vector2i
			if _tile_in_bounds(anchor_tile, visible_bounds):
				jobs.append(job)
	_last_animated_attraction_job_count = jobs.size() - before_count


func _get_attraction_instance_animated_jobs(building_data: Dictionary, attraction_def: Dictionary, frame: int) -> Array:
	var cache_key: String = _make_attraction_animated_instance_cache_key(building_data, attraction_def, frame)
	if _attraction_instance_animated_jobs_cache.has(cache_key):
		return _attraction_instance_animated_jobs_cache[cache_key] as Array
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var orientation: int = int(building_data.get("orientation", 0))
	var ride_anchor: Vector2i = origin + _get_attraction_ride_anchor_for_orientation(attraction_def, orientation)
	var jobs: Array = []
	var animated_pieces: Array = attraction_def.get("animated_pieces", []) as Array
	if _debug_allows_attraction_part("animated"):
		for piece_entry in animated_pieces:
			var piece: Dictionary = piece_entry
			var visible_frames: Array = piece.get("visible_frames", []) as Array
			if not _get_frame_bool(visible_frames, frame, true):
				continue
			var anchor_offset: Vector2i = _get_frame_anchor_offset(piece, frame)
			var offset: Vector2 = _get_frame_offset(piece, frame)
			var anchor_tile: Vector2i = ride_anchor + anchor_offset
			var job: Dictionary = _make_attraction_piece_job(
				piece.get("texture", null) as Texture2D,
				anchor_tile,
				piece.get("region", Rect2()) as Rect2,
				offset,
				HIGH_DRAW_LAYER_ATTRACTION + 200 + int(piece.get("piece_index", 0))
			)
			job["anchor_tile"] = anchor_tile
			jobs.append(job)
			if debug_draw_chunk_anchors:
				_append_attraction_debug_anchor_job(jobs, anchor_tile, {
					"source": "aF animated chunk34",
					"chunk_group": int(piece.get("piece_index", 0)),
				})
	if debug_show_animation_frame:
		_append_attraction_animation_frame_label_job(jobs, ride_anchor, building_data, attraction_def, frame)
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	_attraction_instance_animated_jobs_cache[cache_key] = jobs
	return jobs


func _append_animated_attraction_line_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	_last_attraction_line_job_count = 0
	if not include_attraction_line_chunks or not debug_draw_line_chunks or not debug_draw_animated_lines or not _debug_allows_attraction_part("animated_line") or debug_disable_attraction_render or not use_cached_attraction_chunk_render:
		return
	_prepare_attraction_def_cache()
	var before_count: int = jobs.size()
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var catalog_id: String = String(building_data.get("id", "basic_attraction"))
		var attraction_def: Dictionary = _get_attraction_def(catalog_id, int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty() or (attraction_def.get("animated_lines", []) as Array).is_empty():
			continue
		if not _debug_allows_attraction_jar_type(int(attraction_def.get("jar_type", building_data.get("jar_type", -1)))):
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		var frame: int = _get_attraction_animation_frame(building_data, attraction_def)
		var instance_jobs: Array = _get_attraction_instance_animated_line_jobs(building_data, attraction_def, frame)
		for job_entry in instance_jobs:
			var job: Dictionary = job_entry as Dictionary
			var anchor_tile: Vector2i = job.get("anchor_tile", Vector2i(-9999, -9999)) as Vector2i
			if _tile_in_bounds(anchor_tile, visible_bounds):
				jobs.append(job)
	_last_attraction_line_job_count = jobs.size() - before_count


func _get_attraction_instance_animated_line_jobs(building_data: Dictionary, attraction_def: Dictionary, frame: int) -> Array:
	var cache_key: String = _make_attraction_animated_instance_cache_key(building_data, attraction_def, frame) + "|lines"
	if _attraction_instance_animated_line_jobs_cache.has(cache_key):
		return _attraction_instance_animated_line_jobs_cache[cache_key] as Array
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var orientation: int = int(building_data.get("orientation", 0))
	var ride_anchor: Vector2i = origin + _get_attraction_ride_anchor_for_orientation(attraction_def, orientation)
	var jobs: Array = []
	var animated_lines: Array = attraction_def.get("animated_lines", []) as Array
	for line_entry in animated_lines:
		var line_def: Dictionary = line_entry
		var anchor_tile: Vector2i = ride_anchor + (line_def.get("anchor", Vector2i.ZERO) as Vector2i)
		var start_offset: Vector2 = _get_frame_vector(line_def.get("start_frames", []) as Array, frame)
		var end_offset: Vector2 = _get_frame_vector(line_def.get("end_frames", []) as Array, frame)
		jobs.append(_make_attraction_line_job(
			anchor_tile,
			start_offset,
			end_offset,
			line_def.get("color", Color.BLACK) as Color,
			HIGH_DRAW_LAYER_ATTRACTION + 300 + int(line_def.get("line_index", 0))
		))
		if debug_show_line_points:
			_append_attraction_debug_line_points_jobs(jobs, anchor_tile, start_offset, end_offset, line_def.get("color", Color.BLACK) as Color)
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	_attraction_instance_animated_line_jobs_cache[cache_key] = jobs
	return jobs


func _append_special_attraction_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	_last_special_attraction_job_count = 0
	if not include_attraction_special_chunks or not debug_draw_special_chunks or not _debug_allows_attraction_part("special") or debug_disable_attraction_render or not use_cached_attraction_chunk_render:
		return
	_prepare_attraction_def_cache()
	var before_count: int = jobs.size()
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var catalog_id: String = String(building_data.get("id", "basic_attraction"))
		var attraction_def: Dictionary = _get_attraction_def(catalog_id, int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty() or (attraction_def.get("special_pieces", []) as Array).is_empty():
			continue
		if not _debug_allows_attraction_jar_type(int(attraction_def.get("jar_type", building_data.get("jar_type", -1)))):
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		var frame: int = _get_attraction_animation_frame(building_data, attraction_def)
		var instance_jobs: Array = _get_attraction_instance_special_jobs(building_data, attraction_def, frame)
		for job_entry in instance_jobs:
			var job: Dictionary = job_entry as Dictionary
			var anchor_tile: Vector2i = job.get("anchor_tile", Vector2i(-9999, -9999)) as Vector2i
			if _tile_in_bounds(anchor_tile, visible_bounds):
				jobs.append(job)
	_last_special_attraction_job_count = jobs.size() - before_count


func _get_attraction_instance_special_jobs(building_data: Dictionary, attraction_def: Dictionary, frame: int) -> Array:
	var cache_key: String = _make_attraction_animated_instance_cache_key(building_data, attraction_def, frame) + "|special"
	if _attraction_instance_special_jobs_cache.has(cache_key):
		return _attraction_instance_special_jobs_cache[cache_key] as Array
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var orientation: int = int(building_data.get("orientation", 0))
	var ride_anchor: Vector2i = origin + _get_attraction_ride_anchor_for_orientation(attraction_def, orientation)
	var jobs: Array = []
	var special_pieces: Array = attraction_def.get("special_pieces", []) as Array
	for piece_entry in special_pieces:
		var piece: Dictionary = piece_entry
		var frame_start: int = int(piece.get("frame_start", 0))
		var frame_end: int = int(piece.get("frame_end", -1))
		if frame < frame_start or frame > frame_end:
			continue
		var offset_index: int = frame - frame_start
		var offset: Vector2 = _get_frame_vector_at(piece.get("offset_frames", []) as Array, offset_index)
		var anchor_offset: Vector2i = _get_special_piece_anchor_offset(piece, frame)
		var job: Dictionary = _make_attraction_piece_job(
			piece.get("texture", null) as Texture2D,
			ride_anchor + anchor_offset,
			piece.get("region", Rect2()) as Rect2,
			offset,
			HIGH_DRAW_LAYER_ATTRACTION + 400 + int(piece.get("piece_index", 0))
		)
		job["anchor_tile"] = ride_anchor + anchor_offset
		jobs.append(job)
		if debug_show_special_anchors:
			_append_attraction_debug_anchor_job(jobs, ride_anchor + anchor_offset, {
				"source": "aD special chunk36",
				"chunk_group": int(piece.get("piece_index", 0)),
			})
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	_attraction_instance_special_jobs_cache[cache_key] = jobs
	return jobs


func _append_attraction_passenger_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	_last_passenger_attraction_job_count = 0
	if not include_attraction_passenger_chunks or not debug_draw_passenger_chunks or not _debug_allows_attraction_part("passenger") or debug_disable_attraction_render or not use_cached_attraction_chunk_render:
		return
	if _visitor_system == null or not _visitor_system.has_method("get_attraction_occupant_render_snapshot"):
		return
	var occupant_snapshot: Dictionary = _visitor_system.call("get_attraction_occupant_render_snapshot") as Dictionary
	if occupant_snapshot.is_empty():
		return
	_prepare_attraction_def_cache()
	var before_count: int = jobs.size()
	for building_entry in GameState.buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var key: String = _attraction_origin_key(origin)
		if not occupant_snapshot.has(key):
			continue
		var catalog_id: String = String(building_data.get("id", "basic_attraction"))
		var attraction_def: Dictionary = _get_attraction_def(catalog_id, int(building_data.get("jar_type", -1)))
		if attraction_def.is_empty() or not bool((attraction_def.get("passenger_data", {}) as Dictionary).get("render_enabled", false)):
			continue
		if not _debug_allows_attraction_jar_type(int(attraction_def.get("jar_type", building_data.get("jar_type", -1)))):
			continue
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		var raw_frame: int = _get_attraction_raw_animation_frame(building_data, attraction_def)
		var occupants: Array = occupant_snapshot.get(key, []) as Array
		var instance_jobs: Array = _get_attraction_instance_passenger_jobs(building_data, attraction_def, raw_frame, occupants)
		for job_entry in instance_jobs:
			var job: Dictionary = job_entry as Dictionary
			var anchor_tile: Vector2i = job.get("anchor_tile", Vector2i(-9999, -9999)) as Vector2i
			if _tile_in_bounds(anchor_tile, visible_bounds):
				jobs.append(job)
	_last_passenger_attraction_job_count = jobs.size() - before_count


func _get_attraction_instance_passenger_jobs(building_data: Dictionary, attraction_def: Dictionary, raw_frame: int, occupants: Array) -> Array:
	var passenger_data: Dictionary = attraction_def.get("passenger_data", {}) as Dictionary
	if not bool(passenger_data.get("render_enabled", false)):
		return []
	var passenger_frames: Array = passenger_data.get("frames", []) as Array
	if passenger_frames.is_empty():
		return []
	var frame_entries: Array = passenger_frames[posmod(raw_frame, passenger_frames.size())] as Array
	var entries_by_seat: Dictionary = {}
	for frame_entry in frame_entries:
		var entry: Dictionary = frame_entry as Dictionary
		entries_by_seat[int(entry.get("seat_index", 0))] = entry
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var orientation: int = int(building_data.get("orientation", 0))
	var ride_anchor: Vector2i = origin + _get_attraction_ride_anchor_for_orientation(attraction_def, orientation)
	var jobs: Array = []
	for occupant_entry in occupants:
		var occupant_data: Dictionary = occupant_entry as Dictionary
		var seat_index: int = int(occupant_data.get("seat_index", 0))
		if not entries_by_seat.has(seat_index):
			continue
		var frame_data: Dictionary = entries_by_seat[seat_index] as Dictionary
		var texture: Texture2D = occupant_data.get("texture", null) as Texture2D
		if texture == null:
			continue
		var direction: int = int(frame_data.get("direction", 0))
		var visitor_frame: int = int(frame_data.get("visitor_frame", 0))
		var source_region: Rect2 = occupant_data.get("region", Rect2()) as Rect2
		var visitor_node: Node2D = occupant_data.get("visitor", null) as Node2D
		if _visitor_system != null and visitor_node != null and _visitor_system.has_method("get_visitor_frame_region_for_render"):
			source_region = _visitor_system.call("get_visitor_frame_region_for_render", visitor_node, direction, visitor_frame) as Rect2
		var clip_pixels: int = maxi(0, int(frame_data.get("clip_pixels", 0)))
		if clip_pixels > 0:
			source_region.size = Vector2(source_region.size.x, maxf(1.0, source_region.size.y - float(clip_pixels)))
		var tile_values: Array = frame_data.get("tile_offset", [0, 0]) as Array
		var screen_values: Array = frame_data.get("screen_offset", [10, 10]) as Array
		if tile_values.size() < 2 or screen_values.size() < 2:
			continue
		var anchor_tile: Vector2i = ride_anchor + Vector2i(int(tile_values[0]), int(tile_values[1]))
		var foot_offset: Vector2 = Vector2(float(screen_values[0]), float(screen_values[1]))
		jobs.append(_make_attraction_passenger_job(texture, source_region, anchor_tile, foot_offset, seat_index))
		if debug_show_passenger_anchors:
			_append_attraction_debug_anchor_job(jobs, anchor_tile, {
				"source": "passenger chunks 21..24/35/39",
				"chunk_group": seat_index,
			})
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	return jobs


func _get_attraction_animation_frame(building_data: Dictionary, attraction_def: Dictionary) -> int:
	if debug_forced_attraction_frame >= 0:
		return posmod(debug_forced_attraction_frame, maxi(1, int(attraction_def.get("visual_frame_modulo", attraction_def.get("animation_frame_count", 1)))))
	var visual_frame_modulo: int = maxi(1, int(attraction_def.get("visual_frame_modulo", attraction_def.get("animation_frame_count", 1))))
	return posmod(_get_attraction_raw_animation_frame(building_data, attraction_def), visual_frame_modulo)


func _get_attraction_raw_animation_frame(building_data: Dictionary, attraction_def: Dictionary) -> int:
	if debug_forced_attraction_frame >= 0:
		return debug_forced_attraction_frame
	var instance_key: String = _make_attraction_instance_cache_key(building_data, attraction_def)
	return int(_attraction_runtime_frames.get(instance_key, int(building_data.get("animation_frame", 0))))


func _get_attraction_runtime_state(building_data: Dictionary, attraction_def: Dictionary) -> int:
	var instance_key: String = _make_attraction_instance_cache_key(building_data, attraction_def)
	return int(_attraction_runtime_states.get(instance_key, 0))


func _append_cached_attraction_tile_group_jobs(jobs: Array, origin: Vector2i, tile_groups: Array, orientation: int = 0, frame: int = -1) -> void:
	for group_entry in tile_groups:
		var tile_group: Dictionary = group_entry
		if int(tile_group.get("orientation", 0)) != orientation:
			continue
		var anchor_tile: Vector2i = origin + (tile_group.get("anchor", Vector2i.ZERO) as Vector2i)
		if debug_draw_chunk_anchors:
			_append_attraction_debug_anchor_job(jobs, anchor_tile, tile_group)
		if debug_draw_chunk_labels:
			_append_attraction_debug_label_job(jobs, anchor_tile, tile_group)
		var pieces: Array = tile_group.get("pieces", []) as Array
		for piece_entry in pieces:
			var piece: Dictionary = piece_entry as Dictionary
			if frame >= 0 and not _get_frame_bool(piece.get("visible_frames", []) as Array, frame, true):
				continue
			_append_cached_attraction_piece_job(jobs, anchor_tile, piece)


func _append_cached_attraction_tile_group_phase_jobs(jobs: Array, origin: Vector2i, tile_groups: Array, orientation: int, phase: String, layer_offset_base: int) -> void:
	for group_entry in tile_groups:
		var tile_group: Dictionary = group_entry
		if int(tile_group.get("orientation", 0)) != orientation:
			continue
		var anchor_tile: Vector2i = origin + (tile_group.get("anchor", Vector2i.ZERO) as Vector2i)
		if debug_draw_chunk_anchors:
			_append_attraction_debug_anchor_job(jobs, anchor_tile, tile_group)
		if debug_draw_chunk_labels:
			_append_attraction_debug_label_job(jobs, anchor_tile, tile_group)
		var pieces: Array = tile_group.get("pieces", []) as Array
		for piece_entry in pieces:
			var piece: Dictionary = piece_entry as Dictionary
			var piece_index: int = int(piece.get("piece_index", 0))
			if _get_attraction_ak_draw_phase(piece_index) != phase:
				continue
			_append_cached_attraction_piece_job(jobs, anchor_tile, piece, layer_offset_base + piece_index)


func _get_attraction_ak_draw_phase(piece_index: int) -> String:
	# JAR order: ap()->a(false) draws low/base aK pieces; ao()->b(false)/c(false)
	# draws the raised footprint sides after aD()/visitors.
	match piece_index:
		0, 1, 2, 7, 8, 11, 12, 13, 14, 15, 16:
			return "base"
		3, 4, 5, 6, 9, 10, 17, 18:
			return "high"
		_:
			return "high"


func _append_attraction_debug_anchor_job(jobs: Array, anchor_tile: Vector2i, tile_group: Dictionary) -> void:
	var base_position: Vector2 = tile_to_screen(anchor_tile) + Vector2(tile_width * -0.5, 0.0)
	var foot_position: Vector2 = tile_to_screen(anchor_tile) + Vector2(0.0, tile_height * 0.5)
	jobs.append({
		"draw_type": "debug_anchor",
		"position": base_position.round(),
		"radius": 2.0,
		"color": _get_attraction_debug_color(String(tile_group.get("source", ""))),
		"anchor_tile": anchor_tile,
		"depth_key": _depth_key_for_local_position(foot_position, HIGH_DRAW_LAYER_ATTRACTION + 900),
	})


func _append_attraction_debug_label_job(jobs: Array, anchor_tile: Vector2i, tile_group: Dictionary) -> void:
	var base_position: Vector2 = tile_to_screen(anchor_tile) + Vector2(tile_width * -0.5, 0.0)
	var foot_position: Vector2 = tile_to_screen(anchor_tile) + Vector2(0.0, tile_height * 0.5)
	var source: String = String(tile_group.get("source", ""))
	var label: String = "%s #%d" % [
		source.split(" ")[0] if source != "" else "chunk",
		int(tile_group.get("chunk_group", 0)),
	]
	jobs.append({
		"draw_type": "debug_label",
		"position": (base_position + Vector2(2.0, -4.0)).round(),
		"text": label,
		"color": _get_attraction_debug_color(source),
		"anchor_tile": anchor_tile,
		"depth_key": _depth_key_for_local_position(foot_position, HIGH_DRAW_LAYER_ATTRACTION + 901),
	})


func _append_attraction_animation_frame_label_job(jobs: Array, anchor_tile: Vector2i, building_data: Dictionary, attraction_def: Dictionary, visual_frame: int) -> void:
	var base_position: Vector2 = tile_to_screen(anchor_tile) + Vector2(tile_width * -0.5, 0.0)
	var foot_position: Vector2 = tile_to_screen(anchor_tile) + Vector2(0.0, tile_height * 0.5)
	var raw_frame: int = _get_attraction_raw_animation_frame(building_data, attraction_def)
	jobs.append({
		"draw_type": "debug_label",
		"position": (base_position + Vector2(2.0, -12.0)).round(),
		"text": "ab=%d at=%d ag=%d" % [
			raw_frame,
			visual_frame,
			_get_attraction_runtime_state(building_data, attraction_def),
		],
		"color": Color(1.0, 0.8, 0.1, 1.0),
		"anchor_tile": anchor_tile,
		"depth_key": _depth_key_for_local_position(foot_position, HIGH_DRAW_LAYER_ATTRACTION + 902),
	})


func _get_attraction_debug_color(source: String) -> Color:
	if source.contains("chunk38"):
		return Color(0.2, 0.85, 1.0, 1.0)
	if source.contains("footprint"):
		return Color(1.0, 0.9, 0.25, 1.0)
	if source.contains("aE"):
		return Color(0.35, 1.0, 0.35, 1.0)
	return Color(1.0, 0.45, 0.9, 1.0)


func _append_cached_attraction_piece_jobs(jobs: Array, origin: Vector2i, pieces: Array) -> void:
	for piece_entry in pieces:
		var piece: Dictionary = piece_entry
		var anchor_tile: Vector2i = origin + (piece.get("anchor", Vector2i.ZERO) as Vector2i)
		_append_cached_attraction_piece_job(jobs, anchor_tile, piece)


func _append_cached_attraction_line_jobs(jobs: Array, origin: Vector2i, lines: Array) -> void:
	if not include_attraction_line_chunks or not debug_draw_line_chunks or not debug_draw_static_lines or not _debug_allows_attraction_part("static_line"):
		return
	for line_entry in lines:
		var line_def: Dictionary = line_entry
		var anchor_tile: Vector2i = origin + (line_def.get("anchor", Vector2i.ZERO) as Vector2i)
		var start_offset: Vector2 = line_def.get("start", Vector2.ZERO) as Vector2
		var end_offset: Vector2 = line_def.get("end", Vector2.ZERO) as Vector2
		jobs.append(_make_attraction_line_job(
			anchor_tile,
			start_offset,
			end_offset,
			line_def.get("color", Color.BLACK) as Color,
			HIGH_DRAW_LAYER_ATTRACTION + 100 + int(line_def.get("line_index", 0))
		))
		if debug_show_line_points:
			_append_attraction_debug_line_points_jobs(jobs, anchor_tile, start_offset, end_offset, line_def.get("color", Color.BLACK) as Color)


func _append_attraction_debug_line_points_jobs(jobs: Array, anchor_tile: Vector2i, start_offset: Vector2, end_offset: Vector2, color: Color) -> void:
	var base_position: Vector2 = tile_to_screen(anchor_tile) + Vector2(tile_width * -0.5, 0.0)
	var foot_position: Vector2 = tile_to_screen(anchor_tile) + Vector2(0.0, tile_height * 0.5)
	jobs.append({
		"draw_type": "debug_anchor",
		"position": (base_position + start_offset).round(),
		"radius": 1.5,
		"color": color,
		"anchor_tile": anchor_tile,
		"depth_key": _depth_key_for_local_position(foot_position, HIGH_DRAW_LAYER_ATTRACTION + 998),
	})
	jobs.append({
		"draw_type": "debug_anchor",
		"position": (base_position + end_offset).round(),
		"radius": 1.5,
		"color": color,
		"anchor_tile": anchor_tile,
		"depth_key": _depth_key_for_local_position(foot_position, HIGH_DRAW_LAYER_ATTRACTION + 999),
	})


func _append_cached_attraction_piece_job(jobs: Array, anchor_tile: Vector2i, piece: Dictionary, layer_offset_override: int = -999999) -> void:
	var source_region: Rect2 = piece.get("region", Rect2()) as Rect2
	var offset: Vector2 = piece.get("offset", Vector2.ZERO) as Vector2
	if bool(piece.get("animated", false)):
		offset = _get_static_attraction_animation_offset(piece, offset)
	var layer_offset: int = layer_offset_override
	if layer_offset == -999999:
		layer_offset = HIGH_DRAW_LAYER_ATTRACTION + int(piece.get("piece_index", 0))
	var job: Dictionary = _make_attraction_piece_job(
		piece.get("texture", null) as Texture2D,
		anchor_tile,
		source_region,
		offset,
		layer_offset
	)
	job["anchor_tile"] = anchor_tile
	jobs.append(job)


func _make_attraction_piece_job(texture: Texture2D, tile: Vector2i, source_region: Rect2, offset: Vector2, layer_offset: int) -> Dictionary:
	var base_position: Vector2 = tile_to_screen(tile) + Vector2(tile_width * -0.5, 0.0)
	var target_position: Vector2 = (base_position + offset).round()
	var foot_position: Vector2 = tile_to_screen(tile) + Vector2(0.0, tile_height * 0.5)
	return {
		"texture": texture,
		"region": source_region,
		"region_size": source_region.size,
		"position": target_position,
		"depth_key": _depth_key_for_local_position(foot_position, layer_offset),
	}


func _make_attraction_passenger_job(texture: Texture2D, source_region: Rect2, tile: Vector2i, foot_offset: Vector2, seat_index: int) -> Dictionary:
	var base_position: Vector2 = tile_to_screen(tile) + Vector2(tile_width * -0.5, 0.0)
	var foot_position: Vector2 = base_position + foot_offset
	var target_position: Vector2 = (foot_position + Vector2(-source_region.size.x * 0.5, -source_region.size.y)).round()
	return {
		"texture": texture,
		"region": source_region,
		"region_size": source_region.size,
		"position": target_position,
		"anchor_tile": tile,
		"depth_key": _depth_key_for_local_position(foot_position, HIGH_DRAW_LAYER_VISITOR + seat_index),
	}


func _make_attraction_line_job(tile: Vector2i, start_offset: Vector2, end_offset: Vector2, color: Color, layer_offset: int) -> Dictionary:
	var base_position: Vector2 = tile_to_screen(tile) + Vector2(tile_width * -0.5, 0.0)
	var foot_position: Vector2 = tile_to_screen(tile) + Vector2(0.0, tile_height * 0.5)
	return {
		"draw_type": "attraction_line",
		"start": (base_position + start_offset).round(),
		"end": (base_position + end_offset).round(),
		"color": color,
		"width": 1.0,
		"anchor_tile": tile,
		"depth_key": _depth_key_for_local_position(foot_position, layer_offset),
	}


func _get_static_attraction_animation_offset(piece: Dictionary, fallback_offset: Vector2) -> Vector2:
	var animated_x: Array = piece.get("animated_offsets_x", []) as Array
	var animated_y: Array = piece.get("animated_offsets_y", []) as Array
	if animated_x.is_empty() or animated_y.is_empty():
		return fallback_offset
	return Vector2(float(animated_x[0]), float(animated_y[0]))


func _get_frame_anchor_offset(piece: Dictionary, frame: int) -> Vector2i:
	var anchor_frames: Array = piece.get("anchor_frames", []) as Array
	if anchor_frames.is_empty():
		return piece.get("anchor", Vector2i.ZERO) as Vector2i
	var frame_values: Array = anchor_frames[posmod(frame, anchor_frames.size())] as Array
	if frame_values.size() < 2:
		return piece.get("anchor", Vector2i.ZERO) as Vector2i
	return Vector2i(int(frame_values[0]), int(frame_values[1]))


func _get_frame_offset(piece: Dictionary, frame: int) -> Vector2:
	var fallback_offset: Vector2 = piece.get("offset", Vector2.ZERO) as Vector2
	var animated_x: Array = piece.get("animated_offsets_x", []) as Array
	var animated_y: Array = piece.get("animated_offsets_y", []) as Array
	if animated_x.is_empty() or animated_y.is_empty():
		return fallback_offset
	return Vector2(
		float(animated_x[posmod(frame, animated_x.size())]),
		float(animated_y[posmod(frame, animated_y.size())])
	)


func _get_frame_vector(frame_values: Array, frame: int) -> Vector2:
	if frame_values.is_empty():
		return Vector2.ZERO
	var values: Array = frame_values[posmod(frame, frame_values.size())] as Array
	if values.size() < 2:
		return Vector2.ZERO
	return Vector2(float(values[0]), float(values[1]))


func _get_frame_vector_at(frame_values: Array, frame_index: int) -> Vector2:
	if frame_values.is_empty():
		return Vector2.ZERO
	var clamped_index: int = clampi(frame_index, 0, frame_values.size() - 1)
	var values: Array = frame_values[clamped_index] as Array
	if values.size() < 2:
		return Vector2.ZERO
	return Vector2(float(values[0]), float(values[1]))


func _get_special_piece_anchor_offset(piece: Dictionary, frame: int) -> Vector2i:
	var anchor_frames: Array = piece.get("anchor_frames", []) as Array
	if anchor_frames.is_empty():
		return piece.get("anchor", Vector2i.ZERO) as Vector2i
	var frame_values: Array = anchor_frames[posmod(frame, anchor_frames.size())] as Array
	if frame_values.size() < 2:
		return piece.get("anchor", Vector2i.ZERO) as Vector2i
	return Vector2i(int(frame_values[0]), int(frame_values[1]))


func _get_frame_bool(values: Array, frame: int, fallback: bool) -> bool:
	if values.is_empty():
		return fallback
	return bool(values[posmod(frame, values.size())])


func _make_attraction_instance_cache_key(building_data: Dictionary, attraction_def: Dictionary) -> String:
	return "%s|%d|%d,%d|%d" % [
		String(attraction_def.get("id", building_data.get("id", ""))),
		int(attraction_def.get("jar_type", building_data.get("jar_type", -1))),
		int(building_data.get("x", -1)),
		int(building_data.get("y", -1)),
		int(building_data.get("orientation", 0)),
	]


func _attraction_origin_key(origin: Vector2i) -> String:
	return "%d,%d" % [origin.x, origin.y]


func _make_attraction_animated_instance_cache_key(building_data: Dictionary, attraction_def: Dictionary, frame: int) -> String:
	return "%s|%d|%d,%d|%d|frame=%d" % [
		String(attraction_def.get("id", building_data.get("id", ""))),
		int(attraction_def.get("jar_type", building_data.get("jar_type", -1))),
		int(building_data.get("x", -1)),
		int(building_data.get("y", -1)),
		int(building_data.get("orientation", 0)),
		frame,
	]


func _append_simple_attraction_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	for tile_data_entry in GameState.tiles:
		var tile_data: Dictionary = tile_data_entry
		if String(tile_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION:
			continue
		var tile: Vector2i = Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
		if is_inside_map(tile) and _tile_in_bounds(tile, visible_bounds):
			jobs.append(_make_attraction_placeholder_job(tile))


func _append_simple_attraction_building_jobs(jobs: Array, building_data: Dictionary, visible_bounds: Rect2i) -> void:
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var width: int = maxi(1, int(building_data.get("width", 1)))
	var height: int = maxi(1, int(building_data.get("height", 1)))
	for x in range(origin.x, origin.x + width):
		for y in range(origin.y, origin.y + height):
			var tile: Vector2i = Vector2i(x, y)
			if is_inside_map(tile) and _tile_in_bounds(tile, visible_bounds):
				jobs.append(_make_attraction_placeholder_job(tile))


func _make_attraction_placeholder_job(tile: Vector2i) -> Dictionary:
	var top := tile_to_screen(tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	return {
		"draw_type": "attraction_placeholder",
		"points": points,
		"outline": outline,
		"fill_color": Color(0.72, 0.32, 0.2, 1.0),
		"outline_color": Color(0.36, 0.12, 0.08, 1.0),
		"outline_width": 1.5,
		"depth_key": _depth_key_for_local_position(top + Vector2(0.0, tile_height * 0.5), HIGH_DRAW_LAYER_ATTRACTION),
	}


func _append_attraction_piece_jobs(jobs: Array, origin: Vector2i, pieces: Array) -> void:
	for piece_entry in pieces:
		var piece: Dictionary = piece_entry
		var texture: Texture2D = _get_attraction_texture(String(piece.get("sheet", "")))
		if texture == null:
			continue
		var region_values: Array = piece.get("region", []) as Array
		var offset_values: Array = piece.get("offset", [0, 0]) as Array
		var anchor_values: Array = piece.get("anchor", [0, 0]) as Array
		if region_values.size() < 4 or offset_values.size() < 2 or anchor_values.size() < 2:
			continue
		var offset: Vector2 = Vector2(float(offset_values[0]), float(offset_values[1]))
		if piece.has("animated_offsets_x") and piece.has("animated_offsets_y"):
			var animated_x: Array = piece.get("animated_offsets_x", []) as Array
			var animated_y: Array = piece.get("animated_offsets_y", []) as Array
			if not animated_x.is_empty() and not animated_y.is_empty():
				var frame: int = _attraction_frame % mini(animated_x.size(), animated_y.size())
				offset = Vector2(float(animated_x[frame]), float(animated_y[frame]))
		var anchor_tile: Vector2i = origin + Vector2i(int(anchor_values[0]), int(anchor_values[1]))
		jobs.append(_make_tile_sprite_job(
			texture,
			anchor_tile,
			Rect2(float(region_values[0]), float(region_values[1]), float(region_values[2]), float(region_values[3])),
			offset,
			HIGH_DRAW_LAYER_ATTRACTION + int(piece.get("piece_index", 0))
		))


func _append_visitor_jobs(jobs: Array, visible_bounds: Rect2i) -> void:
	if debug_disable_visitor_render_jobs or not use_iso_visitor_depth_render:
		return
	if _visitor_system == null or not _visitor_system.has_method("get_visitor_render_jobs"):
		return
	var visitor_jobs: Array = _visitor_system.call("get_visitor_render_jobs") as Array
	for visitor_entry in visitor_jobs:
		var visitor_job: Dictionary = visitor_entry as Dictionary
		var texture: Texture2D = visitor_job.get("texture", null) as Texture2D
		if texture == null:
			continue
		var source_region: Rect2 = visitor_job.get("region", Rect2()) as Rect2
		if source_region.size == Vector2.ZERO:
			continue
		var foot_global_position: Vector2 = visitor_job.get("global_position", Vector2.ZERO) as Vector2
		var foot_position: Vector2 = to_local(foot_global_position)
		var sprite_offset: Vector2 = visitor_job.get("sprite_offset", Vector2.ZERO) as Vector2
		var target_position: Vector2 = (foot_position + sprite_offset - source_region.size * 0.5).round()
		var visitor_tile: Vector2i = _local_to_tile(foot_position)
		if not _tile_in_bounds(visitor_tile, visible_bounds):
			continue
		jobs.append({
			"texture": texture,
			"region": source_region,
			"region_size": source_region.size,
			"position": target_position,
			"depth_key": _depth_key_for_local_position(foot_position, HIGH_DRAW_LAYER_VISITOR + int(visitor_job.get("local_depth", 0))),
		})


func _make_tile_sprite_job(texture: Texture2D, tile: Vector2i, source_region: Rect2, offset: Vector2, layer_offset: int) -> Dictionary:
	var base_position: Vector2 = tile_to_screen(tile) + Vector2(tile_width * -0.5, 0.0)
	var target_position: Vector2 = (base_position + offset).round()
	var foot_position: Vector2 = tile_to_screen(tile) + Vector2(0.0, tile_height * 0.5)
	return {
		"texture": texture,
		"region": source_region,
		"region_size": source_region.size,
		"position": target_position,
		"depth_key": _depth_key_for_local_position(foot_position, layer_offset),
	}


func _depth_key_for_local_position(local_position: Vector2, layer_offset: int) -> int:
	return int(round((local_position.y + local_position.x * 0.01) * HIGH_DRAW_DEPTH_SCALE)) + layer_offset


func _sort_high_draw_jobs(a: Dictionary, b: Dictionary) -> bool:
	return int(a.get("depth_key", 0)) < int(b.get("depth_key", 0))


func _should_redraw_for_visitors() -> bool:
	if debug_disable_visitor_render_jobs or not use_iso_visitor_depth_render:
		return false
	if _visitor_system == null or not _visitor_system.has_method("has_active_visitors"):
		return false
	return bool(_visitor_system.call("has_active_visitors"))


func _building_intersects_bounds(origin: Vector2i, size: Vector2i, visible_bounds: Rect2i) -> bool:
	return origin.x <= _bounds_end_x(visible_bounds) and origin.x + size.x - 1 >= visible_bounds.position.x and origin.y <= _bounds_end_y(visible_bounds) and origin.y + size.y - 1 >= visible_bounds.position.y


func _get_attraction_texture(sheet_name: String) -> Texture2D:
	if sheet_name == "":
		return null
	if _attraction_texture_cache.has(sheet_name):
		return _attraction_texture_cache[sheet_name] as Texture2D
	return null


func _get_or_load_attraction_texture(sheet_name: String) -> Texture2D:
	if sheet_name == "":
		return null
	if _attraction_texture_cache.has(sheet_name):
		return _attraction_texture_cache[sheet_name] as Texture2D
	var texture: Texture2D = load("res://assets/original_sprites/attractions/%s.png" % sheet_name) as Texture2D
	_attraction_texture_cache[sheet_name] = texture
	return texture


func _draw_terrain_tiles(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	var min_x: int = maxi(0, visible_bounds.position.x)
	var max_x: int = mini(map_width - 1, _bounds_end_x(visible_bounds))
	var min_y: int = maxi(0, visible_bounds.position.y)
	var max_y: int = mini(map_height - 1, _bounds_end_y(visible_bounds))
	if min_x > max_x or min_y > max_y:
		return
	for x in range(min_x, max_x + 1):
		for y in range(min_y, max_y + 1):
			_draw_terrain_tile(canvas, Vector2i(x, y))


func _draw_terrain_tile(canvas: CanvasItem, tile: Vector2i) -> void:
	var top := tile_to_screen(tile)
	var source_region: Rect2 = _get_terrain_texture_region(tile)
	var target_rect: Rect2 = Rect2(
		(top + Vector2(tile_width * -0.5, 0.0)).round(),
		source_region.size
	)
	canvas.draw_texture_rect_region(TERRAIN_TEXTURE, target_rect, source_region)


func _get_terrain_texture_region(tile: Vector2i) -> Rect2:
	if GameState.get_terrain_decor_code(tile) > 0:
		return TERRAIN_TEXTURE_REGIONS[0]
	var terrain_code: int = GameState.get_terrain_code(tile)
	return TERRAIN_TEXTURE_REGIONS[terrain_code - 1]


func _draw_natural_decor_tiles(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
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
				_draw_natural_decor_tile(canvas, tile, decor_code)


func _draw_natural_decor_tile(canvas: CanvasItem, tile: Vector2i, decor_code: int) -> void:
	var decor_index: int = decor_code - 1
	if decor_index < 0 or decor_index >= NATURAL_DECOR_PIECES.size():
		return
	var base_position: Vector2 = tile_to_screen(tile) + Vector2(tile_width * -0.5, 0.0)
	var decor_pieces: Array = NATURAL_DECOR_PIECES[decor_index] as Array
	for piece_entry in decor_pieces:
		var piece: Array = piece_entry as Array
		var source_region: Rect2 = piece[0] as Rect2
		var offset: Vector2 = piece[1] as Vector2
		canvas.draw_texture_rect_region(
			NATURAL_DECOR_TEXTURE,
			Rect2((base_position + offset).round(), source_region.size),
			source_region
		)


func _draw_external_ground(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	for x in range(visible_bounds.position.x, _bounds_end_x(visible_bounds) + 1):
		for y in range(visible_bounds.position.y, _bounds_end_y(visible_bounds) + 1):
			var tile: Vector2i = Vector2i(x, y)
			if not is_inside_map(tile):
				_draw_external_tile(canvas, TERRAIN_TEXTURE, tile, TERRAIN_TEXTURE_REGIONS[0], Vector2.ZERO)


func _draw_external_road(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	if _tile_in_bounds(entry_tile, visible_bounds):
		_draw_entry_path_tile(canvas, entry_tile)
	if entry_tile.x < visible_bounds.position.x or entry_tile.x > _bounds_end_x(visible_bounds):
		return
	var min_road_y: int = visible_bounds.position.y
	var max_road_y: int = mini(-1, _bounds_end_y(visible_bounds))
	if min_road_y > max_road_y:
		return
	for road_y in range(min_road_y, max_road_y + 1):
		_draw_external_road_tile(canvas, Vector2i(entry_tile.x, road_y))


func _draw_external_road_tile(canvas: CanvasItem, road_tile: Vector2i) -> void:
	_draw_external_tile(canvas, PATH_TEXTURE, road_tile, PATH_TEXTURE_REGION_0, Vector2.ZERO)
	_draw_external_tile(canvas, PATH_TEXTURE, road_tile, PATH_BORDER_REGION_B, Vector2(-1.0, -2.0))
	_draw_external_tile(canvas, PATH_TEXTURE, road_tile, PATH_BORDER_REGION_B, Vector2(17.0, 7.0))


func _draw_external_border(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	var min_x: int = maxi(0, visible_bounds.position.x)
	var max_x: int = mini(map_width - 1, _bounds_end_x(visible_bounds))
	if min_x <= max_x and visible_bounds.position.y <= -1 and _bounds_end_y(visible_bounds) >= -1:
		for x in range(min_x, max_x + 1):
			if x != entry_tile.x:
				_draw_external_tile(canvas, PATH_TEXTURE, Vector2i(x, -1), EXTERNAL_WALL_REGION_B, Vector2(3.0, -3.0))
	if min_x <= max_x and visible_bounds.position.y <= map_height and _bounds_end_y(visible_bounds) >= map_height:
		for x in range(min_x, max_x + 1):
			_draw_external_tile(canvas, PATH_TEXTURE, Vector2i(x, map_height), EXTERNAL_WALL_REGION_B, Vector2(1.0, -1.0))
	var min_y: int = maxi(0, visible_bounds.position.y)
	var max_y: int = mini(map_height - 1, _bounds_end_y(visible_bounds))
	if min_y <= max_y and visible_bounds.position.x <= -1 and _bounds_end_x(visible_bounds) >= -1:
		for y in range(min_y, max_y + 1):
			_draw_external_tile(canvas, PATH_TEXTURE, Vector2i(-1, y), EXTERNAL_WALL_REGION_A, Vector2(13.0, -2.0))
	if min_y <= max_y and visible_bounds.position.x <= map_width and _bounds_end_x(visible_bounds) >= map_width:
		for y in range(min_y, max_y + 1):
			_draw_external_tile(canvas, PATH_TEXTURE, Vector2i(map_width, y), EXTERNAL_WALL_REGION_A, Vector2(11.0, -3.0))
	if _tile_in_bounds(Vector2i(-1, -1), visible_bounds):
		_draw_external_corner(canvas, Vector2i(-1, -1), EXTERNAL_CORNER_REGION_A, Vector2(19.0, -3.0), EXTERNAL_CORNER_REGION_B, Vector2(17.0, 4.0))
	if _tile_in_bounds(Vector2i(map_width, -1), visible_bounds):
		_draw_external_corner(canvas, Vector2i(map_width, -1), EXTERNAL_CORNER_REGION_B, Vector2(3.0, -4.0), EXTERNAL_CORNER_REGION_A, Vector2(16.0, -4.0))
	if _tile_in_bounds(Vector2i(-1, map_height), visible_bounds):
		_draw_external_corner(canvas, Vector2i(-1, map_height), EXTERNAL_CORNER_REGION_A, Vector2(5.0, 5.0), EXTERNAL_CORNER_REGION_B, Vector2(13.0, 5.0))
	if _tile_in_bounds(Vector2i(map_width, map_height), visible_bounds):
		_draw_external_corner(canvas, Vector2i(map_width, map_height), EXTERNAL_CORNER_REGION_B, Vector2(-1.0, -2.0), EXTERNAL_CORNER_REGION_A, Vector2(3.0, 3.0))


func _draw_external_decor_tiles(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	_ensure_external_decor_codes()
	for x in range(visible_bounds.position.x, _bounds_end_x(visible_bounds) + 1):
		for y in range(visible_bounds.position.y, _bounds_end_y(visible_bounds) + 1):
			var tile: Vector2i = Vector2i(x, y)
			var decor_code: int = _get_external_decor_code(tile)
			if decor_code > 0:
				_draw_natural_decor_tile(canvas, tile, decor_code)


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


func _draw_external_corner(canvas: CanvasItem, tile: Vector2i, first_region: Rect2, first_offset: Vector2, second_region: Rect2, second_offset: Vector2) -> void:
	_draw_external_tile(canvas, PATH_TEXTURE, tile, first_region, first_offset)
	_draw_external_tile(canvas, PATH_TEXTURE, tile, second_region, second_offset)


func _draw_external_tile(canvas: CanvasItem, texture: Texture2D, tile: Vector2i, source_region: Rect2, offset: Vector2) -> void:
	var top: Vector2 = tile_to_screen(tile)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0) + offset,
		source_region.size
	)
	canvas.draw_texture_rect_region(texture, target_rect, source_region)


func _draw_entry_path_tile(canvas: CanvasItem, tile: Vector2i) -> void:
	if not is_inside_map(tile):
		return
	var top: Vector2 = tile_to_screen(tile)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0),
		PATH_TEXTURE_REGION_0.size
	)
	canvas.draw_texture_rect_region(PATH_TEXTURE, target_rect, PATH_TEXTURE_REGION_0)
	_draw_path_border_overlays(canvas, tile, target_rect.position)


func _draw_path_tiles(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) == GameState.TILE_TYPE_PATH:
			var tile := Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
			if is_inside_map(tile) and _tile_in_bounds(tile, visible_bounds):
				var path_meta: int = _get_path_meta(tile_data)
				_draw_path_tile(canvas, tile, floori(float(maxi(0, path_meta)) / 4.0), _get_path_mask(tile_data))


func _draw_path_tile(canvas: CanvasItem, tile: Vector2i, path_variant: int, path_mask: int) -> void:
	var top := tile_to_screen(tile)
	var source_region: Rect2 = _get_path_texture_region(path_variant)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0),
		source_region.size
	)
	canvas.draw_texture_rect_region(PATH_TEXTURE, target_rect, source_region)
	_draw_path_border_overlays(canvas, tile, target_rect.position)
	_draw_path_addon_overlays(canvas, target_rect.position, path_mask)


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


func _draw_path_border_overlays(canvas: CanvasItem, tile: Vector2i, base_position: Vector2) -> void:
	if not _is_path_visually_connected(tile, Vector2i(tile.x, tile.y + 1)):
		_draw_path_overlay(canvas, base_position, PATH_BORDER_REGION_A, Vector2(18.0, -1.0))
	if not _is_path_visually_connected(tile, Vector2i(tile.x - 1, tile.y)):
		_draw_path_overlay(canvas, base_position, PATH_BORDER_REGION_B, Vector2(-1.0, -2.0))
	if not _is_path_visually_connected(tile, Vector2i(tile.x, tile.y - 1)):
		_draw_path_overlay(canvas, base_position, PATH_BORDER_REGION_A, Vector2(-1.0, 7.0))
	if not _is_path_visually_connected(tile, Vector2i(tile.x + 1, tile.y)):
		_draw_path_overlay(canvas, base_position, PATH_BORDER_REGION_B, Vector2(17.0, 7.0))


func _draw_path_addon_overlays(canvas: CanvasItem, base_position: Vector2, path_mask: int) -> void:
	if (path_mask & GameState.PATH_BENCH_MASK_C2) != 0:
		_draw_path_overlay(canvas, base_position, PATH_BENCH_C2_REGION, Vector2(1.0, -8.0))
	if (path_mask & GameState.PATH_BENCH_MASK_C1) != 0:
		_draw_path_overlay(canvas, base_position, PATH_BENCH_C1_REGION, Vector2(19.0, -2.0))


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


func _draw_path_overlay(canvas: CanvasItem, base_position: Vector2, source_region: Rect2, offset: Vector2) -> void:
	canvas.draw_texture_rect_region(
		PATH_TEXTURE,
		Rect2(base_position + offset, source_region.size),
		source_region
	)


func _draw_water_tiles(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) == GameState.TILE_TYPE_WATER:
			var tile := Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
			if is_inside_map(tile) and _tile_in_bounds(tile, visible_bounds):
				_draw_water_tile(canvas, tile)


func _draw_water_tile(canvas: CanvasItem, tile: Vector2i) -> void:
	var top := tile_to_screen(tile)
	var base_position: Vector2 = top + Vector2(tile_width * -0.5, 0.0)
	var source_region: Rect2 = WATER_TEXTURE_REGIONS[_water_frame]
	canvas.draw_texture_rect_region(
		WATER_TEXTURE,
		Rect2((base_position + Vector2(0.0, -1.0)).round(), source_region.size),
		source_region
	)
	if not _is_water_neighbor(Vector2i(tile.x, tile.y + 1)):
		_draw_water_overlay(canvas, base_position, WATER_EDGE_REGION_A, Vector2(18.0, -7.0))
	if not _is_water_neighbor(Vector2i(tile.x - 1, tile.y)):
		_draw_water_overlay(canvas, base_position, WATER_EDGE_REGION_B, Vector2(-2.0, -7.0))
	if not _is_water_neighbor(Vector2i(tile.x, tile.y - 1)):
		_draw_water_overlay(canvas, base_position, WATER_EDGE_REGION_A, Vector2(-3.0, 3.0))
	if not _is_water_neighbor(Vector2i(tile.x + 1, tile.y)):
		_draw_water_overlay(canvas, base_position, WATER_EDGE_REGION_B, Vector2(17.0, 3.0))


func _is_water_neighbor(tile: Vector2i) -> bool:
	return GameState.get_tile_type(tile) == GameState.TILE_TYPE_WATER


func _draw_water_overlay(canvas: CanvasItem, base_position: Vector2, source_region: Rect2, offset: Vector2) -> void:
	canvas.draw_texture_rect_region(
		PATH_TEXTURE,
		Rect2((base_position + offset).round(), source_region.size),
		source_region
	)


func _draw_attraction_tiles(_visible_bounds: Rect2i) -> void:
	# Attraction visuals are part of the cached static high-job pass.
	if debug_disable_attraction_render:
		return
	return


func _draw_attraction_tile(canvas: CanvasItem, tile: Vector2i) -> void:
	var top := tile_to_screen(tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	canvas.draw_colored_polygon(points, Color(0.72, 0.32, 0.2, 1.0))
	canvas.draw_polyline(outline, Color(0.36, 0.12, 0.08, 1.0), 1.5)


func _draw_selected_tile(canvas: CanvasItem) -> void:
	var top := tile_to_screen(selected_tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	canvas.draw_colored_polygon(points, Color(1.0, 0.86, 0.2, 0.35))
	canvas.draw_polyline(outline, Color(1.0, 0.86, 0.2, 1.0), 3.0)


func _draw_build_preview(canvas: CanvasItem) -> void:
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
	if _is_selected_attraction() and can_build:
		fill_color = Color(1.0, 0.86, 0.18, 0.38)
		outline_color = Color(0.95, 0.7, 0.08, 1.0)
	if not can_build:
		fill_color = Color(1.0, 0.15, 0.12, 0.42)
		outline_color = Color(1.0, 0.08, 0.06, 1.0)
	for x in range(preview_tile.x, preview_tile.x + size.x):
		for y in range(preview_tile.y, preview_tile.y + size.y):
			var area_tile: Vector2i = Vector2i(x, y)
			if is_inside_map(area_tile):
				_draw_preview_tile(canvas, area_tile, fill_color, outline_color)


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
	if _is_selected_attraction():
		return GameState.can_place_building(GameState.selected_catalog_id, preview_tile)
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


func _is_selected_attraction() -> bool:
	var building_data: Dictionary = Catalog.get_building(GameState.selected_catalog_id)
	return String(building_data.get("type", "")) == GameState.TILE_TYPE_ATTRACTION or String(building_data.get("category", "")) == GameState.TILE_TYPE_ATTRACTION


func _draw_preview_tile(canvas: CanvasItem, tile: Vector2i, fill_color: Color, outline_color: Color) -> void:
	var top := tile_to_screen(tile)
	var points := PackedVector2Array([
		top,
		top + Vector2(tile_width * 0.5, tile_height * 0.5),
		top + Vector2(0, tile_height),
		top + Vector2(-tile_width * 0.5, tile_height * 0.5),
	])
	var outline := PackedVector2Array(points)
	outline.append(points[0])
	canvas.draw_colored_polygon(points, fill_color)
	canvas.draw_polyline(outline, outline_color, 3.0)


func _request_redraw() -> void:
	_request_all_layers_redraw("legacy request")


func _request_all_layers_redraw(reason: String) -> void:
	_static_render_bounds_valid = false
	_invalidate_static_high_jobs_cache(reason)
	_request_static_low_redraw()
	_request_water_redraw()
	_request_static_path_redraw()
	_request_static_high_redraw(reason)
	_request_dynamic_redraw()
	_request_overlay_redraw()


func _request_static_cached_layers_redraw(reason: String) -> void:
	_invalidate_static_high_jobs_cache(reason)
	_request_static_low_redraw()
	_request_water_redraw()
	_request_static_path_redraw()
	_request_static_high_redraw(reason)


func _request_static_low_redraw() -> void:
	_request_layer_redraw(_static_low_layer)


func _request_water_redraw() -> void:
	_request_layer_redraw(_water_layer)


func _request_static_path_redraw() -> void:
	_request_layer_redraw(_static_path_layer)


func _request_static_high_redraw(reason: String) -> void:
	_invalidate_static_high_jobs_cache(reason)
	_request_layer_redraw(_static_high_layer)


func _request_dynamic_redraw() -> void:
	_request_layer_redraw(_dynamic_depth_layer)


func _request_overlay_redraw() -> void:
	_request_layer_redraw(_overlay_layer)


func _request_layer_redraw(layer: Node2D) -> void:
	if layer == null:
		return
	_render_redraw_request_count += 1
	if layer.has_method("request_redraw"):
		layer.call("request_redraw")
	else:
		layer.queue_redraw()


func _log_render_counters() -> void:
	var active_visitors: int = 0
	if _visitor_system != null and _visitor_system.has_method("get_visitor_debug_stats"):
		var visitor_stats: Dictionary = _visitor_system.call("get_visitor_debug_stats") as Dictionary
		active_visitors = int(visitor_stats.get("active_visitors", 0))
	_update_layer_counter_snapshot()
	var total_draws: int = _last_static_low_draws + _last_water_draws + _last_static_path_draws + _last_static_high_draws + _last_dynamic_draws + _last_overlay_draws
	var total_redraws: int = _last_static_low_redraws + _last_water_redraws + _last_static_path_redraws + _last_static_high_redraws + _last_dynamic_redraws + _last_overlay_redraws
	var static_high_rebuilds_this_log: int = _static_high_jobs_rebuild_count - _last_static_high_rebuild_count_for_log
	_last_static_high_rebuild_count_for_log = _static_high_jobs_rebuild_count
	var static_bounds_refreshes_this_log: int = _static_render_bounds_refresh_count - _last_static_render_bounds_refresh_count_for_log
	_last_static_render_bounds_refresh_count_for_log = _static_render_bounds_refresh_count
	print("[IsoMapRender] fps=%d draws=%d redraws=%d low=%d/%d water=%d/%d path=%d/%d high=%d/%d dynamic=%d/%d overlay=%d/%d buildings=%d high_jobs=%d static_jobs=%d dynamic_jobs=%d total_sorted=%d decor_jobs=%d attraction_jobs=%d frame_static_attraction_jobs=%d animated_attraction_jobs=%d animated_instances_advanced=%d line_attraction_jobs=%d special_attraction_jobs=%d passenger_attraction_jobs=%d attraction_instance_jobs=%d attraction_defs=%d visitor_jobs=%d visible_tiles=%d static_tiles=%d visible_bounds=%s static_bounds=%s fixed_world_cache=%s bounds_changed=%s bounds_changes=%d static_bounds_refreshes=%d static_bounds_reason=%s active_visitors=%d high_jobs_usec=%d static_cache_usec=%d dynamic_jobs_usec=%d static_high_rebuilds=%d static_high_rebuilds_s=%d cache_reason=%s entrance_in_isomap=%s entrance_overlay_visible=%s simple_attractions=%s cached_chunks=%s frame_static_chunks=%s animated_chunks=%s line_chunks=%s special_chunks=%s passenger_chunks=%s iso_visitors=%s" % [
		Engine.get_frames_per_second(),
		total_draws,
		total_redraws,
		_last_static_low_draws,
		_last_static_low_redraws,
		_last_water_draws,
		_last_water_redraws,
		_last_static_path_draws,
		_last_static_path_redraws,
		_last_static_high_draws,
		_last_static_high_redraws,
		_last_dynamic_draws,
		_last_dynamic_redraws,
		_last_overlay_draws,
		_last_overlay_redraws,
		GameState.buildings.size(),
		_last_high_job_count,
		_last_static_job_count,
		_last_dynamic_job_count,
		_last_total_sorted_job_count,
		_last_decor_job_count,
		_last_attraction_job_count,
		_last_frame_static_attraction_job_count,
		_last_animated_attraction_job_count,
		_last_animated_attraction_instances_advanced,
		_last_attraction_line_job_count,
		_last_special_attraction_job_count,
		_last_passenger_attraction_job_count,
		_last_attraction_instance_job_count,
		_last_attraction_def_count,
		_last_visitor_job_count,
		_last_visible_tile_count,
		_last_static_render_tile_count,
		_last_observed_visible_bounds_key,
		_make_visible_bounds_key(_static_render_bounds) if _static_render_bounds_valid else "invalid",
		str(use_fixed_world_static_cache),
		str(_last_visible_bounds_changed),
		_visible_bounds_change_count,
		static_bounds_refreshes_this_log,
		_last_static_render_bounds_reason,
		active_visitors,
		_last_high_jobs_usec,
		_last_static_cache_usec,
		_last_dynamic_jobs_usec,
		_static_high_jobs_rebuild_count,
		static_high_rebuilds_this_log,
		_last_static_cache_rebuild_reason,
		str(_draw_entrance_high_in_isomap),
		str(_entrance_overlay != null and _entrance_overlay.visible),
		str(use_simple_attraction_render),
		str(use_cached_attraction_chunk_render),
		str(include_attraction_frame_static_chunks),
		str(include_attraction_animated_chunks),
		str(include_attraction_line_chunks),
		str(include_attraction_special_chunks),
		str(include_attraction_passenger_chunks),
		str(use_iso_visitor_depth_render and not debug_disable_visitor_render_jobs),
	])
	_render_draw_count = 0
	_render_redraw_request_count = 0
	_visible_bounds_change_count = 0
	_last_visible_bounds_changed = false


func _update_layer_counter_snapshot() -> void:
	var low_counts: Dictionary = _consume_layer_counters(_static_low_layer)
	var water_counts: Dictionary = _consume_layer_counters(_water_layer)
	var path_counts: Dictionary = _consume_layer_counters(_static_path_layer)
	var high_counts: Dictionary = _consume_layer_counters(_static_high_layer)
	var dynamic_counts: Dictionary = _consume_layer_counters(_dynamic_depth_layer)
	var overlay_counts: Dictionary = _consume_layer_counters(_overlay_layer)
	_last_static_low_draws = int(low_counts.get("draws", 0))
	_last_static_low_redraws = int(low_counts.get("redraws", 0))
	_last_water_draws = int(water_counts.get("draws", 0))
	_last_water_redraws = int(water_counts.get("redraws", 0))
	_last_static_path_draws = int(path_counts.get("draws", 0))
	_last_static_path_redraws = int(path_counts.get("redraws", 0))
	_last_static_high_draws = int(high_counts.get("draws", 0))
	_last_static_high_redraws = int(high_counts.get("redraws", 0))
	_last_dynamic_draws = int(dynamic_counts.get("draws", 0))
	_last_dynamic_redraws = int(dynamic_counts.get("redraws", 0))
	_last_overlay_draws = int(overlay_counts.get("draws", 0))
	_last_overlay_redraws = int(overlay_counts.get("redraws", 0))


func _consume_layer_counters(layer: Node2D) -> Dictionary:
	if layer != null and layer.has_method("consume_counters"):
		return layer.call("consume_counters") as Dictionary
	return {}
