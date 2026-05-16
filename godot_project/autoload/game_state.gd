extends Node

# Shared runtime state for the 0.1 prototype.

const TILE_TYPE_PATH: String = "path"
const TILE_TYPE_ATTRACTION: String = "attraction"
const ENTRY_TILE: Vector2i = Vector2i(15, 0)
const INITIAL_PATH_TILE: Vector2i = Vector2i(15, 1)
const LEGACY_INITIAL_PATH_TILE: Vector2i = Vector2i(15, 28)

var map_width: int = 30
var map_height: int = 30
var current_mode: String = "select"
var selected_tile: Vector2i = Vector2i(-1, -1)
var selected_catalog_id: String = ""
var tiles: Array = []
var terrain_codes: Array = []
var buildings: Array = []
var visitors: Array = []


func reset_session() -> void:
	Economy.reset()
	current_mode = "select"
	selected_tile = Vector2i(-1, -1)
	selected_catalog_id = ""
	tiles = []
	_generate_terrain_codes()
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


func get_terrain_code(tile: Vector2i) -> int:
	if tile.y >= 0 and tile.y < terrain_codes.size():
		if terrain_codes[tile.y] is Array:
			var row: Array = terrain_codes[tile.y] as Array
			if tile.x >= 0 and tile.x < row.size():
				var terrain_code: int = int(row[tile.x])
				if terrain_code >= 1 and terrain_code <= 3:
					return terrain_code
	return _get_default_terrain_code(tile)


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
	if is_tile_reserved(tile):
		return false
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			if String(tile_data.get("type", "")) == TILE_TYPE_PATH:
				tiles.remove_at(i)
				_set_random_terrain_code(tile)
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
		"terrain_codes": terrain_codes,
		"buildings": buildings,
	}


func from_save_data(data: Dictionary) -> void:
	map_width = int(data.get("map_width", 30))
	map_height = int(data.get("map_height", 30))
	tiles = data.get("tiles", [])
	_remove_reserved_path_tiles()
	_migrate_legacy_entry_path()
	_ensure_path_metadata_defaults()
	var saved_terrain_codes: Variant = data.get("terrain_codes", [])
	terrain_codes = []
	if saved_terrain_codes is Array:
		terrain_codes = saved_terrain_codes as Array
	_ensure_terrain_codes()
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


func _remove_reserved_path_tiles() -> void:
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		var tile: Vector2i = Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
		if is_tile_reserved(tile) and String(tile_data.get("type", "")) == TILE_TYPE_PATH:
			tiles.remove_at(i)


func _migrate_legacy_entry_path() -> void:
	if get_tile_type(INITIAL_PATH_TILE) == TILE_TYPE_PATH:
		return
	var legacy_index: int = _find_tile_index(LEGACY_INITIAL_PATH_TILE, TILE_TYPE_PATH)
	if legacy_index >= 0 and not is_tile_used(INITIAL_PATH_TILE):
		tiles[legacy_index]["x"] = INITIAL_PATH_TILE.x
		tiles[legacy_index]["y"] = INITIAL_PATH_TILE.y
		return
	if not is_tile_used(INITIAL_PATH_TILE):
		add_path_tile(INITIAL_PATH_TILE)


func _find_tile_index(tile: Vector2i, tile_type: String = "") -> int:
	for i in range(tiles.size()):
		var tile_data: Dictionary = tiles[i]
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			if tile_type.is_empty() or String(tile_data.get("type", "")) == tile_type:
				return i
	return -1


func _generate_terrain_codes() -> void:
	terrain_codes = []
	for y in range(map_height):
		var row: Array = []
		for x in range(map_width):
			row.append(_get_default_terrain_code(Vector2i(x, y)))
		terrain_codes.append(row)


func _ensure_terrain_codes() -> void:
	var next_terrain_codes: Array = []
	for y in range(map_height):
		var row: Array = []
		var saved_row: Array = []
		if y < terrain_codes.size() and terrain_codes[y] is Array:
			saved_row = terrain_codes[y] as Array
		for x in range(map_width):
			var terrain_code: int = 0
			if x < saved_row.size():
				terrain_code = int(saved_row[x])
			if terrain_code < 1 or terrain_code > 3:
				terrain_code = _get_default_terrain_code(Vector2i(x, y))
			row.append(terrain_code)
		next_terrain_codes.append(row)
	terrain_codes = next_terrain_codes


func _set_random_terrain_code(tile: Vector2i) -> void:
	if tile.x < 0 or tile.y < 0 or tile.x >= map_width or tile.y >= map_height:
		return
	_ensure_terrain_codes()
	var row: Array = terrain_codes[tile.y] as Array
	row[tile.x] = randi_range(1, 3)


func _get_default_terrain_code(tile: Vector2i) -> int:
	var seed := tile.x * 92821 + tile.y * 68917
	seed = seed ^ (seed << 8)
	seed = seed ^ (seed >> 5)
	var variant: int = abs(seed) % 3
	return variant + 1
