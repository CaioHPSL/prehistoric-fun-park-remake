extends Node

# Shared runtime state for the 0.1 prototype.

const TILE_TYPE_PATH: String = "path"

var map_width: int = 60
var map_height: int = 60
var current_mode: String = "select"
var selected_tile: Vector2i = Vector2i(-1, -1)
var selected_catalog_id: String = ""
var tiles: Array = []
var buildings: Array = []
var visitors: Array = []


func reset_session() -> void:
	current_mode = "select"
	selected_tile = Vector2i(-1, -1)
	selected_catalog_id = ""
	tiles = []
	buildings = []
	visitors = []


func is_tile_used(tile: Vector2i) -> bool:
	for tile_data in tiles:
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			return true
	return false


func add_path_tile(tile: Vector2i) -> bool:
	if is_tile_used(tile):
		return false
	tiles.append({
		"x": tile.x,
		"y": tile.y,
		"type": TILE_TYPE_PATH,
	})
	return true


func to_save_data() -> Dictionary:
	return {
		"version": 1,
		"map_width": map_width,
		"map_height": map_height,
		"money": Economy.money,
		"tiles": tiles,
		"buildings": buildings,
		"visitors": visitors,
	}


func from_save_data(data: Dictionary) -> void:
	map_width = int(data.get("map_width", 60))
	map_height = int(data.get("map_height", 60))
	tiles = data.get("tiles", [])
	buildings = data.get("buildings", [])
	visitors = data.get("visitors", [])
	Economy.money = int(data.get("money", Economy.initial_money))
