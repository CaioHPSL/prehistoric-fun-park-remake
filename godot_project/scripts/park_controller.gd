extends Node2D

# Coordinates the park scene. Detailed build and visitor behavior will be added later.

const BASIC_PATH_COST: int = 3
const BASIC_PATH_REFUND: int = 1
const STONE_PATH_ID: String = "stone_path"
const STONE_PATH_NAME: String = "Caminho de pedra"
const STONE_PATH_COST: int = 6
const STONE_PATH_REFUND: int = 3
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
@onready var basic_path_button: Button = $UI/BuildMenu/Items/BasicPathButton
@onready var stone_path_button: Button = $UI/BuildMenu/Items/StonePathButton
@onready var water_button: Button = $UI/BuildMenu/Items/WaterButton
@onready var basic_attraction_button: Button = $UI/BuildMenu/Items/BasicAttractionButton
@onready var cancel_build_button: Button = $UI/BuildMenu/Items/CancelButton
@onready var building_title_label: Label = $UI/BuildingInfoPanel/Content/Title
@onready var building_details_label: Label = $UI/BuildingInfoPanel/Content/Details
@onready var building_sell_button: Button = $UI/BuildingInfoPanel/Content/SellButton
@onready var building_close_button: Button = $UI/BuildingInfoPanel/Content/CloseButton


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
	water_button.pressed.connect(_on_water_pressed)
	basic_attraction_button.pressed.connect(_on_basic_attraction_pressed)
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
	if building_id == "basic_path":
		_show_build_mode("Build: Path")
	elif building_id == STONE_PATH_ID:
		_show_build_mode("Build: %s" % STONE_PATH_NAME)
	elif building_id == WATER_ID:
		_show_build_mode("Build: %s" % WATER_NAME)
	elif building_id == "basic_attraction":
		_show_build_mode("Build: %s" % BASIC_ATTRACTION_NAME)
	if iso_map.has_method("refresh_tiles"):
		iso_map.refresh_tiles()


func clear_build_mode() -> void:
	GameState.current_mode = "select"
	GameState.selected_catalog_id = ""
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
	if GameState.current_mode == "build" and GameState.selected_catalog_id == "basic_path":
		_try_build_basic_path(tile)
	elif GameState.current_mode == "build" and GameState.selected_catalog_id == STONE_PATH_ID:
		_try_build_stone_path(tile)
	elif GameState.current_mode == "build" and GameState.selected_catalog_id == WATER_ID:
		_try_build_water(tile)
	elif GameState.current_mode == "build" and GameState.selected_catalog_id == "basic_attraction":
		_try_build_basic_attraction(tile)
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
		building_title_label.text = BASIC_ATTRACTION_NAME
		var attraction_origin: Vector2i = GameState.get_basic_attraction_origin_at(tile)
		var visitors_served: int = 0
		if visitor_system.has_method("get_visitors_served_for_attraction"):
			visitors_served = visitor_system.get_visitors_served_for_attraction(attraction_origin)
		building_details_label.text = "Type: Attraction\nCost: %d\nTicket price: %d\nSatisfaction: %d\nVisitors served: %d" % [BASIC_ATTRACTION_COST, BASIC_ATTRACTION_TICKET_PRICE, BASIC_ATTRACTION_SATISFACTION, visitors_served]
		building_sell_button.visible = true
		building_info_panel.visible = true
	else:
		_hide_building_info()


func _hide_building_info() -> void:
	building_sell_button.visible = false
	building_info_panel.visible = false


func _on_basic_path_pressed() -> void:
	select_building("basic_path")
	close_build_menu()


func _on_stone_path_pressed() -> void:
	select_building(STONE_PATH_ID)
	close_build_menu()


func _on_water_pressed() -> void:
	select_building(WATER_ID)
	close_build_menu()


func _on_basic_attraction_pressed() -> void:
	select_building("basic_attraction")
	close_build_menu()


func _on_build_cancel_pressed() -> void:
	clear_build_mode()
	close_build_menu()


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
		sold = GameState.remove_basic_attraction_at(tile)
		refund = BASIC_ATTRACTION_REFUND
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
	_try_build_path(tile, BASIC_PATH_COST, GameState.PATH_GRAVEL_VARIANT, GameState.PATH_GRAVEL_MASK, "Basic Path")


func _try_build_stone_path(tile: Vector2i) -> void:
	_try_build_path(tile, STONE_PATH_COST, GameState.PATH_STONE_VARIANT, GameState.PATH_STONE_MASK, STONE_PATH_NAME)


func _try_build_water(tile: Vector2i) -> void:
	if not _is_area_inside_map(tile, Vector2i(1, 1)):
		_show_error_message("Outside map")
		return
	if GameState.is_entrance_tile(tile):
		_show_error_message("Entrance blocked")
		return
	if GameState.is_tile_used(tile):
		_show_error_message("Tile occupied")
		print("Tile already used: ", tile)
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
	if GameState.is_tile_used(tile):
		_show_error_message("Tile occupied")
		print("Tile already used: ", tile)
		return
	if not Economy.can_afford(cost):
		_show_error_message("Not enough money")
		print("Not enough money for ", path_name)
		return
	if GameState.add_path_tile(tile, path_variant, path_mask):
		Economy.spend(cost)
		if iso_map.has_method("refresh_tiles"):
			iso_map.refresh_tiles()
		if hud.has_method("update_money"):
			hud.update_money()
		_spawn_simple_visitor()


func _try_build_basic_attraction(tile: Vector2i) -> void:
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
	return STONE_PATH_NAME if _get_path_variant_at(tile) == GameState.PATH_STONE_VARIANT else "Basic Path"


func _get_path_cost_at(tile: Vector2i) -> int:
	return STONE_PATH_COST if _get_path_variant_at(tile) == GameState.PATH_STONE_VARIANT else BASIC_PATH_COST


func _get_path_refund_at(tile: Vector2i) -> int:
	return STONE_PATH_REFUND if _get_path_variant_at(tile) == GameState.PATH_STONE_VARIANT else BASIC_PATH_REFUND


func _get_path_variant_at(tile: Vector2i) -> int:
	for tile_data in GameState.tiles:
		if String(tile_data.get("type", "")) != GameState.TILE_TYPE_PATH:
			continue
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			if tile_data.has("path_meta"):
				return floori(float(maxi(0, int(tile_data.get("path_meta", 0)))) / 4.0)
			return maxi(0, int(tile_data.get("path_variant", 0)))
	return GameState.PATH_GRAVEL_VARIANT


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
