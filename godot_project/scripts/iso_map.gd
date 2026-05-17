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
@export var use_cached_attraction_chunk_render: bool = false
@export var include_attraction_animated_chunks: bool = false
@export var use_iso_visitor_depth_render: bool = false
@export var debug_disable_attraction_render: bool = false
@export var debug_disable_high_draw_jobs: bool = false
@export var debug_disable_visitor_render_jobs: bool = false
@export var debug_log_render_counters: bool = false

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
var _last_attraction_def_count: int = 0
var _last_attraction_instance_job_count: int = 0
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
	if not use_simple_attraction_render:
		_attraction_frame_timer += delta
		if _attraction_frame_timer >= ATTRACTION_ANIMATION_SECONDS:
			_attraction_frame_timer = 0.0
			if not GameState.buildings.is_empty():
				_attraction_frame = (_attraction_frame + 1) % 1024
				_request_static_high_redraw("attraction animation frame")
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


func _draw_static_high_layer(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	_draw_high_jobs(canvas, visible_bounds)


func _draw_dynamic_depth_layer(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	_draw_dynamic_visitor_jobs(canvas, visible_bounds)


func _draw_overlay_layer(canvas: CanvasItem) -> void:
	if is_inside_map(selected_tile):
		_draw_selected_tile(canvas)
	if _is_build_preview_active() and is_inside_map(preview_tile):
		_draw_build_preview(canvas)


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
	return "simple=%s|chunk=%s|animated=%s|debug_attraction=%s|iso_visitors=%s|entrance_high=%s|fixed_static=%s|fixed_margin=%d|camera_margin=%d" % [
		str(use_simple_attraction_render),
		str(use_cached_attraction_chunk_render),
		str(include_attraction_animated_chunks),
		str(debug_disable_attraction_render),
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


func _draw_high_jobs(canvas: CanvasItem, visible_bounds: Rect2i) -> void:
	if debug_disable_high_draw_jobs:
		_last_high_job_count = 0
		_last_attraction_job_count = 0
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
	_append_visitor_jobs(dynamic_jobs, visible_bounds)
	_last_dynamic_jobs_usec = Time.get_ticks_usec() - dynamic_start_usec
	_last_visitor_job_count = dynamic_jobs.size()
	_last_dynamic_job_count = dynamic_jobs.size()
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
	return "%d,%d,%d,%d|%d,%d|simple=%s|chunk=%s|animated=%s|attractions=%s|entrance_high=%s" % [
		visible_bounds.position.x,
		visible_bounds.position.y,
		visible_bounds.size.x,
		visible_bounds.size.y,
		map_width,
		map_height,
		str(use_simple_attraction_render),
		str(use_cached_attraction_chunk_render),
		str(include_attraction_animated_chunks),
		str(not debug_disable_attraction_render),
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
		var size: Vector2i = attraction_def.get("size", Vector2i.ONE) as Vector2i
		if not _building_intersects_bounds(origin, size, visible_bounds):
			continue
		var instance_jobs: Array = _get_attraction_instance_static_jobs(building_data, attraction_def)
		if instance_jobs.is_empty():
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
	var static_pieces: Array = _build_attraction_piece_defs(catalog_data.get("visual_static_pieces", []) as Array, false)
	var animated_pieces: Array = _build_attraction_piece_defs(catalog_data.get("visual_animated_pieces", []) as Array, true)
	if static_pieces.is_empty() and animated_pieces.is_empty():
		return {}
	return {
		"id": catalog_id,
		"jar_type": int(catalog_data.get("jar_type", -1)),
		"size": Vector2i(int(size_values[0]), int(size_values[1])),
		"static_pieces": static_pieces,
		"animated_pieces": animated_pieces,
		"visual_source": String(catalog_data.get("visual_source", "")),
	}


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
		if is_animated:
			piece_def["animated_offsets_x"] = piece_data.get("animated_offsets_x", []) as Array
			piece_def["animated_offsets_y"] = piece_data.get("animated_offsets_y", []) as Array
		pieces.append(piece_def)
	return pieces


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
	var jobs: Array = []
	var static_pieces: Array = attraction_def.get("static_pieces", []) as Array
	_append_cached_attraction_piece_jobs(jobs, origin, static_pieces)
	if include_attraction_animated_chunks:
		var animated_pieces: Array = attraction_def.get("animated_pieces", []) as Array
		_append_cached_attraction_piece_jobs(jobs, origin, animated_pieces)
	if jobs.size() > 1:
		jobs.sort_custom(Callable(self, "_sort_high_draw_jobs"))
	_attraction_instance_jobs_cache[cache_key] = jobs
	return jobs


func _append_cached_attraction_piece_jobs(jobs: Array, origin: Vector2i, pieces: Array) -> void:
	for piece_entry in pieces:
		var piece: Dictionary = piece_entry
		var anchor_tile: Vector2i = origin + (piece.get("anchor", Vector2i.ZERO) as Vector2i)
		var source_region: Rect2 = piece.get("region", Rect2()) as Rect2
		var offset: Vector2 = piece.get("offset", Vector2.ZERO) as Vector2
		if bool(piece.get("animated", false)):
			offset = _get_static_attraction_animation_offset(piece, offset)
		var job: Dictionary = _make_tile_sprite_job(
			piece.get("texture", null) as Texture2D,
			anchor_tile,
			source_region,
			offset,
			HIGH_DRAW_LAYER_ATTRACTION + int(piece.get("piece_index", 0))
		)
		job["anchor_tile"] = anchor_tile
		jobs.append(job)


func _get_static_attraction_animation_offset(piece: Dictionary, fallback_offset: Vector2) -> Vector2:
	var animated_x: Array = piece.get("animated_offsets_x", []) as Array
	var animated_y: Array = piece.get("animated_offsets_y", []) as Array
	if animated_x.is_empty() or animated_y.is_empty():
		return fallback_offset
	return Vector2(float(animated_x[0]), float(animated_y[0]))


func _make_attraction_instance_cache_key(building_data: Dictionary, attraction_def: Dictionary) -> String:
	return "%s|%d|%d,%d|%d|animated=%s" % [
		String(attraction_def.get("id", building_data.get("id", ""))),
		int(attraction_def.get("jar_type", building_data.get("jar_type", -1))),
		int(building_data.get("x", -1)),
		int(building_data.get("y", -1)),
		int(building_data.get("orientation", 0)),
		str(include_attraction_animated_chunks),
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
	print("[IsoMapRender] fps=%d draws=%d redraws=%d low=%d/%d water=%d/%d path=%d/%d high=%d/%d dynamic=%d/%d overlay=%d/%d buildings=%d high_jobs=%d static_jobs=%d dynamic_jobs=%d total_sorted=%d decor_jobs=%d attraction_jobs=%d attraction_instance_jobs=%d attraction_defs=%d visitor_jobs=%d visible_tiles=%d static_tiles=%d visible_bounds=%s static_bounds=%s fixed_world_cache=%s bounds_changed=%s bounds_changes=%d static_bounds_refreshes=%d static_bounds_reason=%s active_visitors=%d high_jobs_usec=%d static_cache_usec=%d dynamic_jobs_usec=%d static_high_rebuilds=%d static_high_rebuilds_s=%d cache_reason=%s entrance_in_isomap=%s entrance_overlay_visible=%s simple_attractions=%s cached_chunks=%s animated_chunks=%s iso_visitors=%s" % [
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
		str(include_attraction_animated_chunks),
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
