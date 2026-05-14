extends Node

# Shared runtime state for the 0.1 prototype.

const TILE_TYPE_PATH: String = "path"
const TILE_TYPE_ATTRACTION: String = "attraction"
const ENTRY_TILE: Vector2i = Vector2i(15, 29)
const INITIAL_PATH_TILE: Vector2i = Vector2i(15, 28)

var map_width: int = 30
var map_height: int = 30
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
	add_path_tile(INITIAL_PATH_TILE)


func is_tile_used(tile: Vector2i) -> bool:
	for tile_data in tiles:
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			return true
	return false


func get_tile_type(tile: Vector2i) -> String:
	for tile_data in tiles:
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			return String(tile_data.get("type", ""))
	return ""


func is_entrance_tile(tile: Vector2i) -> bool:
	return tile == ENTRY_TILE


func is_tile_reserved(tile: Vector2i) -> bool:
	return is_entrance_tile(tile)


func add_path_tile(tile: Vector2i) -> bool:
	if is_tile_used(tile) or is_tile_reserved(tile):
		return false
	tiles.append({
		"x": tile.x,
		"y": tile.y,
		"type": TILE_TYPE_PATH,
		"path_variant": 0,
		"path_mask": 3,
	})
	return true


func remove_path_tile(tile: Vector2i) -> bool:
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			if String(tile_data.get("type", "")) == TILE_TYPE_PATH:
				tiles.remove_at(i)
				return true
	return false


func can_place_area(origin: Vector2i, size: Vector2i) -> bool:
	if origin.x < 0 or origin.y < 0:
		return false
	if origin.x + size.x > map_width or origin.y + size.y > map_height:
		return false
	for x in range(origin.x, origin.x + size.x):
		for y in range(origin.y, origin.y + size.y):
			var checked_tile: Vector2i = Vector2i(x, y)
			if is_tile_used(checked_tile) or is_tile_reserved(checked_tile):
				return false
	return true


func add_basic_attraction(origin: Vector2i) -> bool:
	var size: Vector2i = Vector2i(2, 2)
	if not can_place_area(origin, size):
		return false
	buildings.append({
		"id": "basic_attraction",
		"x": origin.x,
		"y": origin.y,
		"width": size.x,
		"height": size.y,
	})
	for x in range(origin.x, origin.x + size.x):
		for y in range(origin.y, origin.y + size.y):
			tiles.append({
				"x": x,
				"y": y,
				"type": TILE_TYPE_ATTRACTION,
			})
	return true


func get_first_basic_attraction() -> Dictionary:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) == "basic_attraction":
			return building_data
	return {}


func get_first_connected_basic_attraction() -> Dictionary:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) == "basic_attraction" and is_basic_attraction_connected_to_path(building_data):
			return building_data
	return {}


func has_basic_attraction(origin: Vector2i) -> bool:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) != "basic_attraction":
			continue
		if int(building_data.get("x", -1)) == origin.x and int(building_data.get("y", -1)) == origin.y:
			return true
	return false


func has_connected_basic_attraction(origin: Vector2i) -> bool:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) != "basic_attraction":
			continue
		if int(building_data.get("x", -1)) == origin.x and int(building_data.get("y", -1)) == origin.y:
			return is_basic_attraction_connected_to_path(building_data)
	return false


func get_basic_attraction_origin_at(tile: Vector2i) -> Vector2i:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) != "basic_attraction":
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var size: Vector2i = Vector2i(int(building_data.get("width", 1)), int(building_data.get("height", 1)))
		if tile.x >= origin.x and tile.y >= origin.y and tile.x < origin.x + size.x and tile.y < origin.y + size.y:
			return origin
	return Vector2i(-1, -1)


func is_basic_attraction_connected_to_path(building_data: Dictionary) -> bool:
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var size: Vector2i = Vector2i(int(building_data.get("width", 1)), int(building_data.get("height", 1)))
	for x in range(origin.x, origin.x + size.x):
		if get_tile_type(Vector2i(x, origin.y - 1)) == TILE_TYPE_PATH:
			return true
		if get_tile_type(Vector2i(x, origin.y + size.y)) == TILE_TYPE_PATH:
			return true
	for y in range(origin.y, origin.y + size.y):
		if get_tile_type(Vector2i(origin.x - 1, y)) == TILE_TYPE_PATH:
			return true
		if get_tile_type(Vector2i(origin.x + size.x, y)) == TILE_TYPE_PATH:
			return true
	return false


func remove_basic_attraction_at(tile: Vector2i) -> bool:
	for i in range(buildings.size() - 1, -1, -1):
		var building_data: Dictionary = buildings[i]
		if String(building_data.get("id", "")) != "basic_attraction":
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var size: Vector2i = Vector2i(int(building_data.get("width", 1)), int(building_data.get("height", 1)))
		if tile.x >= origin.x and tile.y >= origin.y and tile.x < origin.x + size.x and tile.y < origin.y + size.y:
			buildings.remove_at(i)
			_remove_tiles_in_area(origin, size, TILE_TYPE_ATTRACTION)
			return true
	return false


func _remove_tiles_in_area(origin: Vector2i, size: Vector2i, tile_type: String) -> void:
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		var tile_x: int = int(tile_data.get("x", -1))
		var tile_y: int = int(tile_data.get("y", -1))
		if String(tile_data.get("type", "")) == tile_type:
			if tile_x >= origin.x and tile_y >= origin.y and tile_x < origin.x + size.x and tile_y < origin.y + size.y:
				tiles.remove_at(i)


func to_save_data() -> Dictionary:
	return {
		"version": 1,
		"map_width": map_width,
		"map_height": map_height,
		"money": Economy.money,
		"total_earned": Economy.total_earned,
		"total_spent": Economy.total_spent,
		"tiles": tiles,
		"buildings": buildings,
	}


func from_save_data(data: Dictionary) -> void:
	map_width = int(data.get("map_width", 30))
	map_height = int(data.get("map_height", 30))
	tiles = data.get("tiles", [])
	_ensure_path_metadata_defaults()
	buildings = data.get("buildings", [])
	visitors = data.get("visitors", [])
	Economy.money = int(data.get("money", Economy.initial_money))
	Economy.total_earned = int(data.get("total_earned", 0))
	Economy.total_spent = int(data.get("total_spent", 0))


func _ensure_path_metadata_defaults() -> void:
	for tile_data in tiles:
		if String(tile_data.get("type", "")) == TILE_TYPE_PATH:
			if not tile_data.has("path_variant"):
				tile_data["path_variant"] = 0
			if not tile_data.has("path_mask"):
				tile_data["path_mask"] = 3
