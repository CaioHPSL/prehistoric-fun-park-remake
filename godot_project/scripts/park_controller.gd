extends Node2D

# Coordinates the park scene. Detailed build and visitor behavior will be added later.

const BASIC_PATH_COST: int = 10

@onready var iso_map: Node = $IsoMap
@onready var hud: Control = $UI/HUD
@onready var build_menu: Control = $UI/BuildMenu
@onready var building_info_panel: Control = $UI/BuildingInfoPanel
@onready var basic_path_button: Button = $UI/BuildMenu/Items/BasicPathButton
@onready var cancel_build_button: Button = $UI/BuildMenu/Items/CancelButton


func _ready() -> void:
	GameState.reset_session()
	if iso_map.has_method("configure"):
		iso_map.configure(GameState.map_width, GameState.map_height)
	if iso_map.has_signal("tile_touched"):
		iso_map.tile_touched.connect(_on_tile_touched)
	if iso_map.has_signal("selection_cleared"):
		iso_map.selection_cleared.connect(_on_selection_cleared)
	if hud.has_method("bind_controller"):
		hud.bind_controller(self)
	basic_path_button.pressed.connect(_on_basic_path_pressed)
	cancel_build_button.pressed.connect(_on_build_cancel_pressed)
	_show_build_mode("Build: none")


func open_build_menu() -> void:
	build_menu.visible = true


func close_build_menu() -> void:
	build_menu.visible = false


func select_building(building_id: String) -> void:
	GameState.current_mode = "build"
	GameState.selected_catalog_id = building_id
	if building_id == "basic_path":
		_show_build_mode("Build: Path")


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


func _on_tile_touched(tile: Vector2i) -> void:
	GameState.selected_tile = tile
	print("Selected tile: ", tile)
	if hud.has_method("show_selected_tile"):
		hud.show_selected_tile(tile)
	if GameState.current_mode == "build" and GameState.selected_catalog_id == "basic_path":
		_try_build_basic_path(tile)


func _on_selection_cleared() -> void:
	GameState.selected_tile = Vector2i(-1, -1)
	print("Selected tile: none")
	if hud.has_method("show_selected_tile"):
		hud.show_selected_tile(GameState.selected_tile)


func _show_build_mode(mode_text: String) -> void:
	if hud.has_method("show_build_mode"):
		hud.show_build_mode(mode_text)


func _on_basic_path_pressed() -> void:
	select_building("basic_path")
	close_build_menu()


func _on_build_cancel_pressed() -> void:
	clear_build_mode()
	close_build_menu()


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
