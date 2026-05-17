extends Node2D

# Coordinates the park scene. Detailed build and visitor behavior will be added later.

const BASIC_PATH_ID: String = "basic_path"
const BASIC_PATH_NAME: String = "Caminho de cascalho"
const BASIC_PATH_COST: int = 3
const BASIC_PATH_REFUND: int = 1
const STONE_PATH_ID: String = "stone_path"
const STONE_PATH_NAME: String = "Caminho de pedra"
const STONE_PATH_COST: int = 6
const STONE_PATH_REFUND: int = 3
const BENCH_ID: String = "bench"
const BENCH_NAME: String = "Banco"
const BENCH_COST: int = 3
const WATER_ID: String = "water"
const WATER_NAME: String = "Água"
const WATER_COST: int = 10
const BASIC_ATTRACTION_NAME: String = "Balanço"
const BASIC_ATTRACTION_COST: int = 30
const BASIC_ATTRACTION_REFUND: int = 15
const BASIC_ATTRACTION_TICKET_PRICE: int = 1
const BASIC_ATTRACTION_SATISFACTION: int = 5
const BASIC_ATTRACTION_SIZE: Vector2i = Vector2i(3, 3)

@onready var iso_map: Node = $IsoMap
@onready var visitor_system: Node = $VisitorSystem
@onready var camera_2d: Camera2D = $Camera2D
@onready var hud: Control = $UI/HUD
@onready var build_menu: Control = $UI/BuildMenu
@onready var building_info_panel: Control = $UI/BuildingInfoPanel
@onready var build_items_container: VBoxContainer = $UI/BuildMenu/Scroll/Items
@onready var basic_path_button: Button = $UI/BuildMenu/Scroll/Items/BasicPathButton
@onready var stone_path_button: Button = $UI/BuildMenu/Scroll/Items/StonePathButton
@onready var bench_button: Button = $UI/BuildMenu/Scroll/Items/BenchButton
@onready var water_button: Button = $UI/BuildMenu/Scroll/Items/WaterButton
@onready var basic_attraction_button: Button = $UI/BuildMenu/Scroll/Items/BasicAttractionButton
@onready var cancel_build_button: Button = $UI/BuildMenu/Scroll/Items/CancelButton
@onready var building_title_label: Label = $UI/BuildingInfoPanel/Content/Title
@onready var building_details_label: Label = $UI/BuildingInfoPanel/Content/Details
@onready var building_sell_button: Button = $UI/BuildingInfoPanel/Content/SellButton
@onready var building_close_button: Button = $UI/BuildingInfoPanel/Content/CloseButton

var attraction_buttons: Dictionary = {}


func _ready() -> void:
	GameState.reset_session()
	if iso_map.has_method("configure"):
		iso_map.configure(GameState.map_width, GameState.map_height)
	_focus_camera_on_entry()
	if iso_map.has_signal("tile_touched"):
		iso_map.tile_touched.connect(_on_tile_touched)
	if iso_map.has_signal("selection_cleared"):
		iso_map.selection_cleared.connect(_on_selection_cleared)
	if visitor_system.has_method("configure"):
		visitor_system.configure(iso_map)
	if iso_map.has_method("set_visitor_system"):
		iso_map.set_visitor_system(visitor_system)
	if visitor_system.has_signal("visitor_paid"):
		visitor_system.visitor_paid.connect(_on_visitor_paid)
	if visitor_system.has_signal("visitor_stats_changed"):
		visitor_system.visitor_stats_changed.connect(_on_visitor_stats_changed)
	if hud.has_method("bind_controller"):
		hud.bind_controller(self)
	if hud.has_signal("save_requested"):
		hud.save_requested.connect(_on_save_requested)
	if hud.has_signal("load_requested"):
		hud.load_requested.connect(_on_load_requested)
	basic_path_button.pressed.connect(_on_basic_path_pressed)
	stone_path_button.pressed.connect(_on_stone_path_pressed)
	bench_button.pressed.connect(_on_bench_pressed)
	water_button.pressed.connect(_on_water_pressed)
	_populate_attraction_buttons()
	cancel_build_button.pressed.connect(_on_build_cancel_pressed)
	building_close_button.pressed.connect(_on_building_info_close_pressed)
	building_sell_button.pressed.connect(_on_building_sell_pressed)
	building_sell_button.visible = false
	_hide_building_info()
	_show_build_mode("Build: none")
	_on_visitor_stats_changed(0, 0)


func open_build_menu() -> void:
	build_menu.visible = true


func close_build_menu() -> void:
	build_menu.visible = false


func select_building(building_id: String) -> void:
	GameState.current_mode = "build"
	GameState.selected_catalog_id = building_id
	var catalog_data: Dictionary = Catalog.get_building(building_id)
	if building_id == BASIC_PATH_ID:
		_show_build_mode("Build: %s" % BASIC_PATH_NAME)
	elif building_id == STONE_PATH_ID:
		_show_build_mode("Build: %s" % STONE_PATH_NAME)
	elif building_id == BENCH_ID:
		_show_build_mode("Build: %s %s" % [BENCH_NAME, _get_bench_orientation_label()])
	elif building_id == WATER_ID:
		_show_build_mode("Build: %s" % WATER_NAME)
	elif _is_attraction_catalog_id(building_id):
		_show_build_mode("Build: %s" % String(catalog_data.get("name", building_id)))
	if iso_map.has_method("refresh_tiles"):
		iso_map.refresh_tiles()


func clear_build_mode() -> void:
	GameState.current_mode = "select"
	GameState.selected_catalog_id = ""
	GameState.selected_path_addon_mask = GameState.PATH_BENCH_DEFAULT_MASK
	_show_build_mode("Build: none")
	if iso_map.has_method("refresh_tiles"):
		iso_map.refresh_tiles()


func clear_selection() -> void:
	clear_build_mode()
	GameState.selected_tile = Vector2i(-1, -1)
	if iso_map.has_method("clear_selected_tile"):
		iso_map.clear_selected_tile()
	if hud.has_method("show_selected_tile"):
		hud.show_selected_tile(GameState.selected_tile)
	if hud.has_method("show_selected_object"):
		hud.show_selected_object("")
	_hide_building_info()


func _on_tile_touched(tile: Vector2i) -> void:
	GameState.selected_tile = tile
	print("Selected tile: ", tile)
	if hud.has_method("show_selected_tile"):
		hud.show_selected_tile(tile)
	if GameState.current_mode == "build" and GameState.selected_catalog_id == BASIC_PATH_ID:
		_try_build_basic_path(tile)
	elif GameState.current_mode == "build" and GameState.selected_catalog_id == STONE_PATH_ID:
		_try_build_stone_path(tile)
	elif GameState.current_mode == "build" and GameState.selected_catalog_id == BENCH_ID:
		_try_build_bench(tile)
	elif GameState.current_mode == "build" and GameState.selected_catalog_id == WATER_ID:
		_try_build_water(tile)
	elif GameState.current_mode == "build" and _is_attraction_catalog_id(GameState.selected_catalog_id):
		_try_build_attraction(tile, GameState.selected_catalog_id)
	_show_selected_object(tile)
	_show_building_info(tile)


func _on_selection_cleared() -> void:
	GameState.selected_tile = Vector2i(-1, -1)
	print("Selected tile: none")
	if hud.has_method("show_selected_tile"):
		hud.show_selected_tile(GameState.selected_tile)
	if hud.has_method("show_selected_object"):
		hud.show_selected_object("")
	_hide_building_info()


func _show_build_mode(mode_text: String) -> void:
	if hud.has_method("show_build_mode"):
		hud.show_build_mode(mode_text)


func _show_error_message(message: String) -> void:
	if hud.has_method("show_message"):
		hud.show_message(message)


func _show_selected_object(tile: Vector2i) -> void:
	if hud.has_method("show_selected_object"):
		hud.show_selected_object(GameState.get_tile_type(tile))


func _show_building_info(tile: Vector2i) -> void:
	var tile_type: String = GameState.get_tile_type(tile)
	if tile_type == GameState.TILE_TYPE_PATH:
		building_title_label.text = _get_path_name_at(tile)
		building_details_label.text = "Type: Path\nOriginal cost: %d" % _get_path_cost_at(tile)
		building_sell_button.visible = true
		building_info_panel.visible = true
	elif tile_type == GameState.TILE_TYPE_WATER:
		building_title_label.text = WATER_NAME
		building_details_label.text = "Type: Water\nOriginal cost: %d" % WATER_COST
		building_sell_button.visible = true
		building_info_panel.visible = true
	elif tile_type == GameState.TILE_TYPE_ATTRACTION:
		var building_data: Dictionary = GameState.get_attraction_building_at(tile)
		var attraction_id: String = String(building_data.get("id", "basic_attraction"))
		var catalog_data: Dictionary = Catalog.get_building(attraction_id)
		building_title_label.text = String(catalog_data.get("name", building_data.get("name", BASIC_ATTRACTION_NAME)))
		var attraction_origin: Vector2i = GameState.get_attraction_origin_at(tile)
		var visitors_served: int = 0
		if visitor_system.has_method("get_visitors_served_for_attraction"):
			visitors_served = visitor_system.get_visitors_served_for_attraction(attraction_origin)
		building_details_label.text = "Type: Attraction\nCost: %d\nTicket price: %d\nCapacity: %d\nDuration: %d ticks\nSatisfaction: %d\nVisitors served: %d" % [
			int(catalog_data.get("cost", 0)),
			int(catalog_data.get("ticket_price", 0)),
			int(catalog_data.get("visitor_capacity", 0)),
			int(catalog_data.get("use_duration_ticks", 0)),
			int(catalog_data.get("satisfaction_gain", 0)),
			visitors_served,
		]
		building_sell_button.visible = true
		building_info_panel.visible = true
	else:
		_hide_building_info()


func _hide_building_info() -> void:
	building_sell_button.visible = false
	building_info_panel.visible = false


func _on_basic_path_pressed() -> void:
	select_building(BASIC_PATH_ID)
	close_build_menu()


func _on_stone_path_pressed() -> void:
	select_building(STONE_PATH_ID)
	close_build_menu()


func _on_bench_pressed() -> void:
	if GameState.current_mode == "build" and GameState.selected_catalog_id == BENCH_ID:
		_toggle_bench_orientation()
	else:
		GameState.selected_path_addon_mask = GameState.PATH_BENCH_DEFAULT_MASK
		select_building(BENCH_ID)
	close_build_menu()


func _on_water_pressed() -> void:
	select_building(WATER_ID)
	close_build_menu()


func _on_basic_attraction_pressed() -> void:
	select_building("basic_attraction")
	close_build_menu()


func _on_attraction_button_pressed(catalog_id: String) -> void:
	select_building(catalog_id)
	close_build_menu()


func _populate_attraction_buttons() -> void:
	var attraction_ids: Array[String] = Catalog.get_building_ids_by_type("attraction")
	attraction_ids.sort_custom(Callable(self, "_sort_attraction_ids_by_jar_type"))
	for catalog_id in attraction_ids:
		var catalog_data: Dictionary = Catalog.get_building(catalog_id)
		var button: Button = basic_attraction_button if catalog_id == "basic_attraction" else Button.new()
		button.name = _button_name_from_catalog_id(catalog_id)
		button.text = "%s ($%d)" % [String(catalog_data.get("name", catalog_id)), int(catalog_data.get("cost", 0))]
		if button.get_parent() == null:
			build_items_container.add_child(button)
			build_items_container.move_child(button, maxi(0, build_items_container.get_child_count() - 2))
		button.pressed.connect(_on_attraction_button_pressed.bind(catalog_id))
		attraction_buttons[catalog_id] = button


func _button_name_from_catalog_id(catalog_id: String) -> String:
	var button_name: String = ""
	for part in catalog_id.split("_"):
		button_name += String(part).capitalize().replace(" ", "")
	return "%sButton" % button_name


func _sort_attraction_ids_by_jar_type(a: String, b: String) -> bool:
	return int(Catalog.get_building(a).get("jar_type", 999)) < int(Catalog.get_building(b).get("jar_type", 999))


func _on_build_cancel_pressed() -> void:
	clear_build_mode()
	close_build_menu()


func _unhandled_input(event: InputEvent) -> void:
	if event is InputEventKey and event.pressed and not event.echo:
		if event.keycode == KEY_R and GameState.current_mode == "build" and GameState.selected_catalog_id == BENCH_ID:
			_toggle_bench_orientation()


func _on_building_info_close_pressed() -> void:
	_hide_building_info()


func _on_building_sell_pressed() -> void:
	var tile: Vector2i = GameState.selected_tile
	var tile_type: String = GameState.get_tile_type(tile)
	var refund: int = 0
	var sold: bool = false
	if tile_type == GameState.TILE_TYPE_PATH:
		var path_refund: int = _get_path_refund_at(tile)
		sold = GameState.remove_path_tile(tile)
		if sold and GameState.get_tile_type(tile) != GameState.TILE_TYPE_PATH:
			refund = path_refund
	elif tile_type == GameState.TILE_TYPE_WATER:
		sold = GameState.remove_water_tile(tile)
	elif tile_type == GameState.TILE_TYPE_ATTRACTION:
		var building_data: Dictionary = GameState.get_attraction_building_at(tile)
		var catalog_data: Dictionary = Catalog.get_building(String(building_data.get("id", "basic_attraction")))
		sold = GameState.remove_attraction_at(tile)
		refund = int(round(float(catalog_data.get("cost", 0)) * float(catalog_data.get("sell_refund_ratio", 0.5))))
	if not sold:
		return
	Economy.money += refund
	GameState.selected_tile = Vector2i(-1, -1)
	if iso_map.has_method("clear_selected_tile"):
		iso_map.clear_selected_tile()
	if iso_map.has_method("refresh_tiles"):
		iso_map.refresh_tiles()
	if hud.has_method("update_money"):
		hud.update_money()
	if hud.has_method("show_selected_tile"):
		hud.show_selected_tile(GameState.selected_tile)
	if hud.has_method("show_selected_object"):
		hud.show_selected_object("")
	_hide_building_info()
	if tile_type == GameState.TILE_TYPE_PATH or tile_type == GameState.TILE_TYPE_ATTRACTION:
		if visitor_system.has_method("revalidate_active_routes"):
			visitor_system.revalidate_active_routes()
		_spawn_simple_visitor()


func _on_save_requested() -> void:
	var data: Dictionary = GameState.to_save_data()
	if visitor_system.has_method("get_total_visitors_served"):
		data["total_visitors_served"] = visitor_system.get_total_visitors_served()
	if visitor_system.has_method("get_visitors_served_by_attraction"):
		data["visitors_served_by_attraction"] = visitor_system.get_visitors_served_by_attraction()
	if SaveSystem.save_game(data):
		print("Game saved")
	else:
		print("Save failed")


func _on_load_requested() -> void:
	var data: Dictionary = SaveSystem.load_game()
	if data.is_empty():
		print("No save found")
		return
	GameState.from_save_data(data)
	GameState.current_mode = "select"
	GameState.selected_catalog_id = ""
	GameState.selected_path_addon_mask = GameState.PATH_BENCH_DEFAULT_MASK
	GameState.selected_tile = Vector2i(-1, -1)
	if iso_map.has_method("configure"):
		iso_map.configure(GameState.map_width, GameState.map_height)
	_focus_camera_on_entry()
	if iso_map.has_method("clear_selected_tile"):
		iso_map.clear_selected_tile()
	if iso_map.has_method("refresh_tiles"):
		iso_map.refresh_tiles()
	if hud.has_method("update_money"):
		hud.update_money()
	if hud.has_method("show_selected_tile"):
		hud.show_selected_tile(GameState.selected_tile)
	if hud.has_method("show_selected_object"):
		hud.show_selected_object("")
	_show_build_mode("Build: none")
	close_build_menu()
	_hide_building_info()
	if visitor_system.has_method("clear_visitor"):
		visitor_system.clear_visitor()
	if visitor_system.has_method("set_total_visitors_served"):
		visitor_system.set_total_visitors_served(int(data.get("total_visitors_served", 0)))
	if visitor_system.has_method("set_visitors_served_by_attraction"):
		visitor_system.set_visitors_served_by_attraction(data.get("visitors_served_by_attraction", {}))
	_spawn_simple_visitor()
	print("Game loaded")


func _try_build_basic_path(tile: Vector2i) -> void:
	_try_build_path(tile, BASIC_PATH_COST, GameState.PATH_GRAVEL_VARIANT, GameState.PATH_GRAVEL_MASK, BASIC_PATH_NAME)


func _try_build_stone_path(tile: Vector2i) -> void:
	_try_build_path(tile, STONE_PATH_COST, GameState.PATH_STONE_VARIANT, GameState.PATH_STONE_MASK, STONE_PATH_NAME)


func _try_build_bench(tile: Vector2i) -> void:
	if not _is_area_inside_map(tile, Vector2i(1, 1)):
		_show_error_message("Outside map")
		return
	if GameState.is_entrance_tile(tile):
		_show_error_message("Entrance blocked")
		return
	if GameState.get_tile_type(tile) != GameState.TILE_TYPE_PATH:
		_show_error_message("Needs Path")
		return
	if not GameState.can_add_path_addon(tile, GameState.selected_path_addon_mask):
		_show_error_message("Bench already exists")
		return
	if not Economy.can_afford(BENCH_COST):
		_show_error_message("Not enough money")
		print("Not enough money for ", BENCH_NAME)
		return
	if GameState.add_path_addon(tile, GameState.selected_path_addon_mask):
		Economy.spend(BENCH_COST)
		if iso_map.has_method("refresh_tiles"):
			iso_map.refresh_tiles()
		if hud.has_method("update_money"):
			hud.update_money()


func _try_build_water(tile: Vector2i) -> void:
	if not _is_area_inside_map(tile, Vector2i(1, 1)):
		_show_error_message("Outside map")
		return
	if GameState.is_entrance_tile(tile):
		_show_error_message("Entrance blocked")
		return
	if GameState.get_tile_type(tile) != GameState.TILE_TYPE_PATH:
		_show_error_message("Needs Path")
		return
	if not Economy.can_afford(WATER_COST):
		_show_error_message("Not enough money")
		print("Not enough money for ", WATER_NAME)
		return
	if GameState.add_water_tile(tile):
		Economy.spend(WATER_COST)
		if iso_map.has_method("refresh_tiles"):
			iso_map.refresh_tiles()
		if hud.has_method("update_money"):
			hud.update_money()


func _try_build_path(tile: Vector2i, cost: int, path_variant: int, path_mask: int, path_name: String) -> void:
	if not _is_area_inside_map(tile, Vector2i(1, 1)):
		_show_error_message("Outside map")
		return
	if GameState.is_entrance_tile(tile):
		_show_error_message("Entrance blocked")
		return
	if not Economy.can_afford(cost):
		_show_error_message("Not enough money")
		print("Not enough money for ", path_name)
		return
	if GameState.is_tile_used(tile):
		if GameState.upgrade_path_tile(tile, path_variant):
			Economy.spend(cost)
			if iso_map.has_method("refresh_tiles"):
				iso_map.refresh_tiles()
			if hud.has_method("update_money"):
				hud.update_money()
			return
		else:
			_show_error_message("Tile occupied")
			print("Tile already used: ", tile)
			return
	if GameState.add_path_tile(tile, path_variant, path_mask):
		Economy.spend(cost)
		if iso_map.has_method("refresh_tiles"):
			iso_map.refresh_tiles()
		if hud.has_method("update_money"):
			hud.update_money()
		_spawn_simple_visitor()


func _try_build_basic_attraction(tile: Vector2i) -> void:
	_try_build_attraction(tile, "basic_attraction")
	return
	var size: Vector2i = BASIC_ATTRACTION_SIZE
	if not _is_area_inside_map(tile, size):
		_show_error_message("Outside map")
		print("Cannot place Balanço at: ", tile)
		return
	if _area_includes_entrance(tile, size):
		_show_error_message("Entrance blocked")
		print("Cannot place Balanço at: ", tile)
		return
	if _is_area_occupied(tile, size):
		_show_error_message("Tile occupied")
		print("Cannot place Balanço at: ", tile)
		return
	if not Economy.can_afford(BASIC_ATTRACTION_COST):
		_show_error_message("Not enough money")
		print("Not enough money for Balanço")
		return
	if GameState.add_basic_attraction(tile):
		Economy.spend(BASIC_ATTRACTION_COST)
		if iso_map.has_method("refresh_tiles"):
			iso_map.refresh_tiles()
		if hud.has_method("update_money"):
			hud.update_money()
		if not GameState.has_connected_basic_attraction(tile):
			_show_error_message("Attraction needs Path")
		_spawn_simple_visitor()


func _try_build_attraction(tile: Vector2i, catalog_id: String) -> void:
	var catalog_data: Dictionary = Catalog.get_building(catalog_id)
	if catalog_data.is_empty() or String(catalog_data.get("type", "")) != GameState.TILE_TYPE_ATTRACTION:
		_show_error_message("Unknown attraction")
		return
	var size: Vector2i = _get_catalog_size(catalog_data)
	var attraction_name: String = String(catalog_data.get("name", catalog_id))
	var attraction_cost: int = int(catalog_data.get("cost", 0))
	if not _is_area_inside_map(tile, size):
		_show_error_message("Outside map")
		print("Cannot place ", attraction_name, " at: ", tile)
		return
	if _area_includes_entrance(tile, size):
		_show_error_message("Entrance blocked")
		print("Cannot place ", attraction_name, " at: ", tile)
		return
	if not GameState.can_place_building(catalog_id, tile):
		_show_error_message("Tile occupied")
		print("Cannot place ", attraction_name, " at: ", tile)
		return
	if not Economy.can_afford(attraction_cost):
		_show_error_message("Not enough money")
		print("Not enough money for ", attraction_name)
		return
	if GameState.add_attraction(catalog_id, tile):
		Economy.spend(attraction_cost)
		if iso_map.has_method("refresh_tiles"):
			iso_map.refresh_tiles()
		if hud.has_method("update_money"):
			hud.update_money()
		if not GameState.has_connected_attraction(tile):
			_show_error_message("Attraction needs Path")
		_spawn_simple_visitor()


func _is_area_inside_map(origin: Vector2i, size: Vector2i) -> bool:
	return origin.x >= 0 and origin.y >= 0 and origin.x + size.x <= GameState.map_width and origin.y + size.y <= GameState.map_height


func _area_includes_entrance(origin: Vector2i, size: Vector2i) -> bool:
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	return entry_tile.x >= origin.x and entry_tile.y >= origin.y and entry_tile.x < origin.x + size.x and entry_tile.y < origin.y + size.y


func _is_area_occupied(origin: Vector2i, size: Vector2i) -> bool:
	for x in range(origin.x, origin.x + size.x):
		for y in range(origin.y, origin.y + size.y):
			if GameState.is_tile_used(Vector2i(x, y)):
				return true
	return false


func _get_path_name_at(tile: Vector2i) -> String:
	var base_name: String = STONE_PATH_NAME if _get_path_variant_at(tile) == GameState.PATH_STONE_VARIANT else BASIC_PATH_NAME
	if _get_path_mask_at(tile) != 0:
		return "%s + %s" % [base_name, BENCH_NAME]
	return base_name


func _get_path_cost_at(tile: Vector2i) -> int:
	var path_cost: int = STONE_PATH_COST if _get_path_variant_at(tile) == GameState.PATH_STONE_VARIANT else BASIC_PATH_COST
	return path_cost + _get_path_addon_count_at(tile) * BENCH_COST


func _get_path_refund_at(tile: Vector2i) -> int:
	return STONE_PATH_REFUND if _get_path_variant_at(tile) == GameState.PATH_STONE_VARIANT else BASIC_PATH_REFUND


func _get_path_variant_at(tile: Vector2i) -> int:
	return GameState.get_path_variant_at(tile)


func _get_path_mask_at(tile: Vector2i) -> int:
	return GameState.get_path_mask_at(tile)


func _get_path_addon_count_at(tile: Vector2i) -> int:
	var path_mask: int = _get_path_mask_at(tile)
	var addon_count: int = 0
	if (path_mask & GameState.PATH_BENCH_MASK_C1) != 0:
		addon_count += 1
	if (path_mask & GameState.PATH_BENCH_MASK_C2) != 0:
		addon_count += 1
	return addon_count


func _toggle_bench_orientation() -> void:
	if GameState.selected_path_addon_mask == GameState.PATH_BENCH_MASK_C2:
		GameState.selected_path_addon_mask = GameState.PATH_BENCH_MASK_C1
	else:
		GameState.selected_path_addon_mask = GameState.PATH_BENCH_MASK_C2
	_show_build_mode("Build: %s %s" % [BENCH_NAME, _get_bench_orientation_label()])
	if iso_map.has_method("refresh_tiles"):
		iso_map.refresh_tiles()


func _get_bench_orientation_label() -> String:
	return "(c&1)" if GameState.selected_path_addon_mask == GameState.PATH_BENCH_MASK_C1 else "(c&2)"


func _is_attraction_catalog_id(catalog_id: String) -> bool:
	var catalog_data: Dictionary = Catalog.get_building(catalog_id)
	return String(catalog_data.get("type", "")) == GameState.TILE_TYPE_ATTRACTION or String(catalog_data.get("category", "")) == GameState.TILE_TYPE_ATTRACTION


func _get_catalog_size(catalog_data: Dictionary) -> Vector2i:
	var size_data: Array = catalog_data.get("size", [1, 1]) as Array
	return Vector2i(int(size_data[0]), int(size_data[1]))


func _spawn_simple_visitor() -> void:
	if visitor_system.has_method("spawn_single_visitor"):
		visitor_system.spawn_single_visitor()


func _focus_camera_on_entry() -> void:
	if not iso_map.has_method("tile_to_screen"):
		return
	var entry_position: Vector2 = iso_map.call("tile_to_screen", GameState.ENTRY_TILE)
	var viewport_size: Vector2 = get_viewport_rect().size
	var desired_screen_position: Vector2 = Vector2(viewport_size.x * 0.22, viewport_size.y * 0.78)
	var viewport_center: Vector2 = viewport_size * 0.5
	var zoom_value: float = maxf(camera_2d.zoom.x, 0.001)
	camera_2d.position = entry_position - (desired_screen_position - viewport_center) / zoom_value


func _on_visitor_paid(amount: int) -> void:
	Economy.earn(amount)
	if hud.has_method("update_money"):
		hud.update_money()


func _on_visitor_stats_changed(active_count: int, served_count: int) -> void:
	if hud.has_method("update_visitors"):
		hud.update_visitors(active_count, served_count)
	if hud.has_method("update_visitor_debug_stats") and visitor_system.has_method("get_visitor_debug_stats"):
		hud.update_visitor_debug_stats(visitor_system.get_visitor_debug_stats())
