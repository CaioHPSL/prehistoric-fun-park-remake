extends Node2D

# Coordinates the park scene. Detailed build and visitor behavior will be added later.

const BASIC_PATH_COST: int = 10
const BASIC_ATTRACTION_COST: int = 250

@onready var iso_map: Node = $IsoMap
@onready var visitor_system: Node = $VisitorSystem
@onready var hud: Control = $UI/HUD
@onready var build_menu: Control = $UI/BuildMenu
@onready var building_info_panel: Control = $UI/BuildingInfoPanel
@onready var basic_path_button: Button = $UI/BuildMenu/Items/BasicPathButton
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
	elif building_id == "basic_attraction":
		_show_build_mode("Build: Attraction")


func clear_build_mode() -> void:
	GameState.current_mode = "select"
	GameState.selected_catalog_id = ""
	_show_build_mode("Build: none")


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


func _show_selected_object(tile: Vector2i) -> void:
	if hud.has_method("show_selected_object"):
		hud.show_selected_object(GameState.get_tile_type(tile))


func _show_building_info(tile: Vector2i) -> void:
	var tile_type: String = GameState.get_tile_type(tile)
	if tile_type == GameState.TILE_TYPE_PATH:
		building_title_label.text = "Path"
		building_details_label.text = "Type: Path\nOriginal cost: %d" % BASIC_PATH_COST
		building_sell_button.visible = true
		building_info_panel.visible = true
	elif tile_type == GameState.TILE_TYPE_ATTRACTION:
		building_title_label.text = "Attraction"
		var attraction_origin: Vector2i = GameState.get_basic_attraction_origin_at(tile)
		var visitors_served: int = 0
		if visitor_system.has_method("get_visitors_served_for_attraction"):
			visitors_served = visitor_system.get_visitors_served_for_attraction(attraction_origin)
		building_details_label.text = "Type: Attraction\nCost: %d\nProfit per visitor: 25\nVisitors served: %d" % [BASIC_ATTRACTION_COST, visitors_served]
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
		sold = GameState.remove_path_tile(tile)
		refund = 5
	elif tile_type == GameState.TILE_TYPE_ATTRACTION:
		sold = GameState.remove_basic_attraction_at(tile)
		refund = 125
	if not sold:
		return
	Economy.earn(refund)
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
		if visitor_system.has_method("clear_visitor"):
			visitor_system.clear_visitor()
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
	if GameState.is_tile_used(tile):
		print("Tile already used: ", tile)
		return
	if not Economy.can_afford(BASIC_PATH_COST):
		print("Not enough money for Basic Path")
		return
	if GameState.add_path_tile(tile):
		Economy.spend(BASIC_PATH_COST)
		if iso_map.has_method("refresh_tiles"):
			iso_map.refresh_tiles()
		if hud.has_method("update_money"):
			hud.update_money()
		_spawn_simple_visitor()


func _try_build_basic_attraction(tile: Vector2i) -> void:
	if not GameState.can_place_area(tile, Vector2i(2, 2)):
		print("Cannot place Basic Attraction at: ", tile)
		return
	if not Economy.can_afford(BASIC_ATTRACTION_COST):
		print("Not enough money for Basic Attraction")
		return
	if GameState.add_basic_attraction(tile):
		Economy.spend(BASIC_ATTRACTION_COST)
		if iso_map.has_method("refresh_tiles"):
			iso_map.refresh_tiles()
		if hud.has_method("update_money"):
			hud.update_money()
		_spawn_simple_visitor()


func _spawn_simple_visitor() -> void:
	if visitor_system.has_method("spawn_single_visitor"):
		visitor_system.spawn_single_visitor()


func _on_visitor_paid(amount: int) -> void:
	Economy.earn(amount)
	if hud.has_method("update_money"):
		hud.update_money()


func _on_visitor_stats_changed(active_count: int, served_count: int) -> void:
	if hud.has_method("update_visitors"):
		hud.update_visitors(active_count, served_count)
