extends Node

# Shared runtime state for the 0.1 prototype.

const TILE_TYPE_PATH: String = "path"
const TILE_TYPE_ATTRACTION: String = "attraction"
const TILE_TYPE_WATER: String = "water"
const DEFAULT_MAP_WIDTH: int = 30
const DEFAULT_MAP_HEIGHT: int = 30
const NATURAL_DECOR_CHANCE: int = 20
const ENTRY_TILE: Vector2i = Vector2i(15, 0)
const INITIAL_PATH_TILE: Vector2i = Vector2i(15, 1)
const LEGACY_INITIAL_PATH_TILE: Vector2i = Vector2i(15, 28)
const PATH_GRAVEL_VARIANT: int = 0
const PATH_GRAVEL_MASK: int = 0
const PATH_GRAVEL_META: int = 0
const PATH_STONE_VARIANT: int = 1
const PATH_STONE_MASK: int = 0
const PATH_STONE_META: int = 4
const PATH_BENCH_MASK_C1: int = 1
const PATH_BENCH_MASK_C2: int = 2
const PATH_BENCH_DEFAULT_MASK: int = PATH_BENCH_MASK_C2
const BASIC_ATTRACTION_SIZE: Vector2i = Vector2i(3, 3)
const BASIC_ATTRACTION_JAR_TYPE: int = 6
const BASIC_ATTRACTION_ID: String = "basic_attraction"

var map_width: int = DEFAULT_MAP_WIDTH
var map_height: int = DEFAULT_MAP_HEIGHT
var current_mode: String = "select"
var selected_tile: Vector2i = Vector2i(-1, -1)
var selected_catalog_id: String = ""
var selected_path_addon_mask: int = PATH_BENCH_DEFAULT_MASK
var tiles: Array = []
var terrain_codes: Array = []
var terrain_decor_codes: Array = []
var buildings: Array = []
var visitors: Array = []


func reset_session() -> void:
	Economy.reset()
	map_width = DEFAULT_MAP_WIDTH
	map_height = DEFAULT_MAP_HEIGHT
	current_mode = "select"
	selected_tile = Vector2i(-1, -1)
	selected_catalog_id = ""
	selected_path_addon_mask = PATH_BENCH_DEFAULT_MASK
	tiles = []
	_generate_terrain_codes()
	_generate_terrain_decor_codes()
	buildings = []
	visitors = []
	add_path_tile(INITIAL_PATH_TILE)


func is_inside_map(tile: Vector2i) -> bool:
	return tile.x >= 0 and tile.y >= 0 and tile.x < map_width and tile.y < map_height


func is_tile_used(tile: Vector2i) -> bool:
	if not is_inside_map(tile):
		return false
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


func get_terrain_decor_code(tile: Vector2i) -> int:
	if tile.y >= 0 and tile.y < terrain_decor_codes.size():
		if terrain_decor_codes[tile.y] is Array:
			var row: Array = terrain_decor_codes[tile.y] as Array
			if tile.x >= 0 and tile.x < row.size():
				var decor_code: int = int(row[tile.x])
				if decor_code >= 1 and decor_code <= 12:
					return decor_code
	return 0


func clear_terrain_decor(tile: Vector2i, randomize_terrain: bool = false) -> void:
	if not is_inside_map(tile):
		return
	_ensure_terrain_decor_codes()
	var row: Array = terrain_decor_codes[tile.y] as Array
	row[tile.x] = 0
	if randomize_terrain:
		_set_random_terrain_code(tile)


func is_tile_reserved(tile: Vector2i) -> bool:
	return is_entrance_tile(tile)


func add_path_tile(tile: Vector2i, path_variant: int = PATH_GRAVEL_VARIANT, path_mask: int = PATH_GRAVEL_MASK) -> bool:
	if not is_inside_map(tile) or is_tile_used(tile) or is_tile_reserved(tile):
		return false
	if _has_adjacent_path_addon_conflict(tile):
		return false
	clear_terrain_decor(tile)
	var path_meta: int = _compose_path_meta(path_variant, path_mask)
	tiles.append({
		"x": tile.x,
		"y": tile.y,
		"type": TILE_TYPE_PATH,
		"path_variant": _path_variant_from_meta(path_meta),
		"path_mask": _path_mask_from_meta(path_meta),
		"path_meta": path_meta,
	})
	return true


func add_water_tile(tile: Vector2i) -> bool:
	if not is_inside_map(tile) or is_tile_reserved(tile):
		return false
	var path_index: int = _find_tile_index(tile, TILE_TYPE_PATH)
	if path_index < 0:
		return false
	clear_terrain_decor(tile)
	tiles.remove_at(path_index)
	tiles.append({
		"x": tile.x,
		"y": tile.y,
		"type": TILE_TYPE_WATER,
	})
	return true


func can_upgrade_path_tile(tile: Vector2i, path_variant: int) -> bool:
	if not is_inside_map(tile) or is_tile_reserved(tile):
		return false
	if _find_tile_index(tile, TILE_TYPE_PATH) < 0:
		return false
	if _has_adjacent_path_addon_conflict(tile):
		return false
	return path_variant > get_path_variant_at(tile)


func upgrade_path_tile(tile: Vector2i, path_variant: int) -> bool:
	if not can_upgrade_path_tile(tile, path_variant):
		return false
	var tile_index: int = _find_tile_index(tile, TILE_TYPE_PATH)
	var tile_data: Dictionary = tiles[tile_index]
	_set_path_metadata(tile_data, path_variant, get_path_mask_at(tile))
	return true


func can_add_path_addon(tile: Vector2i, path_mask_bit: int) -> bool:
	if path_mask_bit != PATH_BENCH_MASK_C1 and path_mask_bit != PATH_BENCH_MASK_C2:
		return false
	if not is_inside_map(tile) or is_tile_reserved(tile):
		return false
	var tile_index: int = _find_tile_index(tile, TILE_TYPE_PATH)
	if tile_index < 0:
		return false
	var path_mask: int = get_path_mask_at(tile)
	if not _is_path_addon_side_clear(tile, path_mask_bit):
		return false
	return (path_mask & path_mask_bit) == 0


func add_path_addon(tile: Vector2i, path_mask_bit: int) -> bool:
	if not can_add_path_addon(tile, path_mask_bit):
		return false
	var tile_index: int = _find_tile_index(tile, TILE_TYPE_PATH)
	var tile_data: Dictionary = tiles[tile_index]
	var path_variant: int = get_path_variant_at(tile)
	var path_mask: int = get_path_mask_at(tile) | path_mask_bit
	_set_path_metadata(tile_data, path_variant, path_mask)
	return true


func remove_path_tile(tile: Vector2i) -> bool:
	if not is_inside_map(tile) or is_tile_reserved(tile):
		return false
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			if String(tile_data.get("type", "")) == TILE_TYPE_PATH:
				var path_mask: int = get_path_mask_at(tile)
				if path_mask != 0:
					_set_path_metadata(tile_data, get_path_variant_at(tile), PATH_GRAVEL_MASK)
					return true
				tiles.remove_at(i)
				clear_terrain_decor(tile)
				_set_random_terrain_code(tile)
				return true
	return false


func remove_water_tile(tile: Vector2i) -> bool:
	if not is_inside_map(tile) or is_tile_reserved(tile):
		return false
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		if int(tile_data.get("x", -1)) == tile.x and int(tile_data.get("y", -1)) == tile.y:
			if String(tile_data.get("type", "")) == TILE_TYPE_WATER:
				tiles.remove_at(i)
				clear_terrain_decor(tile)
				_set_random_terrain_code(tile)
				return true
	return false


func has_water_tiles() -> bool:
	for tile_data in tiles:
		if String(tile_data.get("type", "")) == TILE_TYPE_WATER:
			return true
	return false


func get_path_variant_at(tile: Vector2i) -> int:
	var tile_index: int = _find_tile_index(tile, TILE_TYPE_PATH)
	if tile_index < 0:
		return PATH_GRAVEL_VARIANT
	var tile_data: Dictionary = tiles[tile_index]
	if tile_data.has("path_meta"):
		return _path_variant_from_meta(int(tile_data.get("path_meta", PATH_GRAVEL_META)))
	return maxi(0, int(tile_data.get("path_variant", PATH_GRAVEL_VARIANT)))


func get_path_mask_at(tile: Vector2i) -> int:
	var tile_index: int = _find_tile_index(tile, TILE_TYPE_PATH)
	if tile_index < 0:
		return PATH_GRAVEL_MASK
	var tile_data: Dictionary = tiles[tile_index]
	if tile_data.has("path_mask"):
		return clampi(int(tile_data.get("path_mask", PATH_GRAVEL_MASK)), 0, 3)
	return _path_mask_from_meta(int(tile_data.get("path_meta", PATH_GRAVEL_META)))


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


func can_place_building(catalog_id: String, origin: Vector2i) -> bool:
	var catalog_data: Dictionary = Catalog.get_building(catalog_id)
	if catalog_data.is_empty():
		return false
	var occupied_offsets: Array = get_catalog_occupied_offsets(catalog_data)
	if occupied_offsets.is_empty():
		return false
	for offset_entry in occupied_offsets:
		var offset: Vector2i = offset_entry
		var checked_tile: Vector2i = origin + offset
		if not is_inside_map(checked_tile) or is_tile_used(checked_tile) or is_tile_reserved(checked_tile):
			return false
	return true


func add_basic_attraction(origin: Vector2i) -> bool:
	return add_attraction(BASIC_ATTRACTION_ID, origin)


func add_attraction(catalog_id: String, origin: Vector2i) -> bool:
	var catalog_data: Dictionary = Catalog.get_building(catalog_id)
	if catalog_data.is_empty() or String(catalog_data.get("type", "")) != TILE_TYPE_ATTRACTION:
		return false
	if not can_place_building(catalog_id, origin):
		return false
	var size: Vector2i = _get_catalog_size(catalog_data)
	buildings.append({
		"id": catalog_id,
		"name": String(catalog_data.get("name", catalog_id)),
		"type": TILE_TYPE_ATTRACTION,
		"category": String(catalog_data.get("category", TILE_TYPE_ATTRACTION)),
		"jar_type": int(catalog_data.get("jar_type", -1)),
		"x": origin.x,
		"y": origin.y,
		"width": size.x,
		"height": size.y,
		"orientation": 0,
		"served_count": 0,
	})
	for offset_entry in get_catalog_occupied_offsets(catalog_data):
		var offset: Vector2i = offset_entry
		var occupied_tile: Vector2i = origin + offset
		clear_terrain_decor(occupied_tile)
		tiles.append({
			"x": occupied_tile.x,
			"y": occupied_tile.y,
			"type": TILE_TYPE_ATTRACTION,
			"building_id": catalog_id,
			"origin_x": origin.x,
			"origin_y": origin.y,
		})
	return true


func get_first_basic_attraction() -> Dictionary:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) == BASIC_ATTRACTION_ID:
			return building_data
	return {}


func get_first_connected_basic_attraction() -> Dictionary:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) == BASIC_ATTRACTION_ID and is_basic_attraction_connected_to_path(building_data):
			return building_data
	return {}


func has_basic_attraction(origin: Vector2i) -> bool:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("id", "")) != BASIC_ATTRACTION_ID:
			continue
		if int(building_data.get("x", -1)) == origin.x and int(building_data.get("y", -1)) == origin.y:
			return true
	return false


func has_connected_basic_attraction(origin: Vector2i) -> bool:
	return has_connected_attraction(origin)


func has_connected_attraction(origin: Vector2i) -> bool:
	var building_data: Dictionary = get_attraction_building_at(origin)
	if building_data.is_empty():
		return false
	return is_basic_attraction_connected_to_path(building_data)


func get_basic_attraction_origin_at(tile: Vector2i) -> Vector2i:
	return get_attraction_origin_at(tile)


func get_attraction_origin_at(tile: Vector2i) -> Vector2i:
	var building_data: Dictionary = get_attraction_building_at(tile)
	if building_data.is_empty():
		return Vector2i(-1, -1)
	return Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))


func get_attraction_building_at(tile: Vector2i) -> Dictionary:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		if String(building_data.get("type", "")) != TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != TILE_TYPE_ATTRACTION and String(building_data.get("id", "")) != BASIC_ATTRACTION_ID:
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var catalog_data: Dictionary = Catalog.get_building(String(building_data.get("id", BASIC_ATTRACTION_ID)))
		for offset_entry in get_catalog_occupied_offsets(catalog_data):
			if origin + (offset_entry as Vector2i) == tile:
				return building_data
	return {}


func is_basic_attraction_connected_to_path(building_data: Dictionary) -> bool:
	for path_tile in get_adjacent_path_tiles_for_building(building_data):
		if get_tile_type(path_tile) == TILE_TYPE_PATH:
			return true
	return false


func remove_basic_attraction_at(tile: Vector2i) -> bool:
	return remove_attraction_at(tile)


func remove_attraction_at(tile: Vector2i) -> bool:
	for i in range(buildings.size() - 1, -1, -1):
		var building_data: Dictionary = buildings[i]
		if String(building_data.get("type", "")) != TILE_TYPE_ATTRACTION and String(building_data.get("category", "")) != TILE_TYPE_ATTRACTION and String(building_data.get("id", "")) != BASIC_ATTRACTION_ID:
			continue
		var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
		var catalog_data: Dictionary = Catalog.get_building(String(building_data.get("id", BASIC_ATTRACTION_ID)))
		var occupied_offsets: Array = get_catalog_occupied_offsets(catalog_data)
		var contains_tile: bool = false
		for offset_entry in occupied_offsets:
			if origin + (offset_entry as Vector2i) == tile:
				contains_tile = true
				break
		if contains_tile:
			buildings.remove_at(i)
			_remove_attraction_tiles(origin, occupied_offsets)
			return true
	return false


func get_catalog_occupied_offsets(catalog_data: Dictionary) -> Array:
	var offsets: Array = []
	var size: Vector2i = _get_catalog_size(catalog_data)
	var footprint_codes: Array = catalog_data.get("footprint_codes", []) as Array
	if footprint_codes.size() < size.x * size.y:
		for x in range(size.x):
			for y in range(size.y):
				offsets.append(Vector2i(x, y))
		return offsets
	for x in range(size.x):
		for y in range(size.y):
			var code_index: int = x * size.y + y
			if int(footprint_codes[code_index]) != 1:
				offsets.append(Vector2i(x, y))
	return offsets


func get_adjacent_path_tiles_for_building(building_data: Dictionary) -> Array:
	var targets: Array = []
	var origin: Vector2i = Vector2i(int(building_data.get("x", -1)), int(building_data.get("y", -1)))
	var catalog_data: Dictionary = Catalog.get_building(String(building_data.get("id", BASIC_ATTRACTION_ID)))
	var occupied_tiles: Dictionary = {}
	for offset_entry in get_catalog_occupied_offsets(catalog_data):
		var occupied_tile: Vector2i = origin + (offset_entry as Vector2i)
		occupied_tiles[_tile_key(occupied_tile)] = true
	for occupied_key in occupied_tiles.keys():
		var parts: PackedStringArray = String(occupied_key).split(",")
		var occupied_tile: Vector2i = Vector2i(int(parts[0]), int(parts[1]))
		for direction in [Vector2i(1, 0), Vector2i(-1, 0), Vector2i(0, 1), Vector2i(0, -1)]:
			var neighbor: Vector2i = occupied_tile + direction
			if occupied_tiles.has(_tile_key(neighbor)):
				continue
			if get_tile_type(neighbor) == TILE_TYPE_PATH and not targets.has(neighbor):
				targets.append(neighbor)
	return targets


func _get_catalog_size(catalog_data: Dictionary) -> Vector2i:
	var size_data: Array = catalog_data.get("size", [1, 1]) as Array
	return Vector2i(int(size_data[0]), int(size_data[1]))


func _remove_attraction_tiles(origin: Vector2i, occupied_offsets: Array) -> void:
	var occupied_keys: Dictionary = {}
	for offset_entry in occupied_offsets:
		occupied_keys[_tile_key(origin + (offset_entry as Vector2i))] = true
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		var tile: Vector2i = Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
		if String(tile_data.get("type", "")) == TILE_TYPE_ATTRACTION and occupied_keys.has(_tile_key(tile)):
			tiles.remove_at(i)


func _tile_key(tile: Vector2i) -> String:
	return "%d,%d" % [tile.x, tile.y]


func _remove_tiles_in_area(origin: Vector2i, size: Vector2i, tile_type: String) -> void:
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		var tile_x: int = int(tile_data.get("x", -1))
		var tile_y: int = int(tile_data.get("y", -1))
		if String(tile_data.get("type", "")) == tile_type:
			if tile_x >= origin.x and tile_y >= origin.y and tile_x < origin.x + size.x and tile_y < origin.y + size.y:
				tiles.remove_at(i)


func to_save_data() -> Dictionary:
	_remove_out_of_bounds_tiles()
	_ensure_path_metadata_defaults()
	_ensure_terrain_codes()
	_ensure_terrain_decor_codes()
	return {
		"version": 1,
		"map_width": map_width,
		"map_height": map_height,
		"money": Economy.money,
		"total_earned": Economy.total_earned,
		"total_spent": Economy.total_spent,
		"tiles": tiles,
		"terrain_codes": terrain_codes,
		"terrain_decor_codes": terrain_decor_codes,
		"buildings": buildings,
	}


func from_save_data(data: Dictionary) -> void:
	map_width = DEFAULT_MAP_WIDTH
	map_height = DEFAULT_MAP_HEIGHT
	tiles = data.get("tiles", [])
	_remove_out_of_bounds_tiles()
	_remove_reserved_path_tiles()
	_migrate_legacy_entry_path()
	_ensure_path_metadata_defaults()
	var saved_terrain_codes: Variant = data.get("terrain_codes", [])
	terrain_codes = []
	if saved_terrain_codes is Array:
		terrain_codes = saved_terrain_codes as Array
	_ensure_terrain_codes()
	var saved_terrain_decor_codes: Variant = data.get("terrain_decor_codes", [])
	terrain_decor_codes = []
	if saved_terrain_decor_codes is Array:
		terrain_decor_codes = saved_terrain_decor_codes as Array
	_ensure_terrain_decor_codes()
	buildings = data.get("buildings", [])
	_ensure_building_defaults()
	visitors = data.get("visitors", [])
	Economy.money = int(data.get("money", Economy.initial_money))
	Economy.total_earned = int(data.get("total_earned", 0))
	Economy.total_spent = int(data.get("total_spent", 0))


func _ensure_path_metadata_defaults() -> void:
	for tile_data in tiles:
		if String(tile_data.get("type", "")) == TILE_TYPE_PATH:
			var path_meta: int = PATH_GRAVEL_META
			if tile_data.has("path_meta"):
				path_meta = maxi(0, int(tile_data.get("path_meta", PATH_GRAVEL_META)))
			else:
				var path_variant: int = maxi(0, int(tile_data.get("path_variant", PATH_GRAVEL_VARIANT)))
				var path_mask: int = int(tile_data.get("path_mask", PATH_GRAVEL_MASK))
				if path_mask == 3:
					path_mask = PATH_GRAVEL_MASK
				path_mask = clampi(path_mask, 0, 3)
				path_meta = _compose_path_meta(path_variant, path_mask)
			_set_path_metadata(tile_data, _path_variant_from_meta(path_meta), _path_mask_from_meta(path_meta))


func _ensure_building_defaults() -> void:
	for building_entry in buildings:
		var building_data: Dictionary = building_entry
		var catalog_id: String = String(building_data.get("id", BASIC_ATTRACTION_ID))
		if catalog_id == "":
			catalog_id = BASIC_ATTRACTION_ID
			building_data["id"] = catalog_id
		var catalog_data: Dictionary = Catalog.get_building(catalog_id)
		if catalog_data.is_empty() and int(building_data.get("jar_type", -1)) == BASIC_ATTRACTION_JAR_TYPE:
			catalog_id = BASIC_ATTRACTION_ID
			catalog_data = Catalog.get_building(catalog_id)
			building_data["id"] = catalog_id
		if catalog_data.is_empty():
			continue
		var size: Vector2i = _get_catalog_size(catalog_data)
		building_data["type"] = String(catalog_data.get("type", TILE_TYPE_ATTRACTION))
		building_data["category"] = String(catalog_data.get("category", building_data.get("type", "")))
		building_data["name"] = String(catalog_data.get("name", catalog_id))
		building_data["jar_type"] = int(catalog_data.get("jar_type", building_data.get("jar_type", -1)))
		building_data["width"] = int(building_data.get("width", size.x))
		building_data["height"] = int(building_data.get("height", size.y))
		building_data["orientation"] = int(building_data.get("orientation", 0))
		building_data["served_count"] = int(building_data.get("served_count", 0))


func _remove_reserved_path_tiles() -> void:
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		var tile: Vector2i = Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
		var tile_type: String = String(tile_data.get("type", ""))
		if is_tile_reserved(tile) and (tile_type == TILE_TYPE_PATH or tile_type == TILE_TYPE_WATER):
			tiles.remove_at(i)


func _remove_out_of_bounds_tiles() -> void:
	for i in range(tiles.size() - 1, -1, -1):
		var tile_data: Dictionary = tiles[i]
		var tile: Vector2i = Vector2i(int(tile_data.get("x", -1)), int(tile_data.get("y", -1)))
		if not is_inside_map(tile):
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
			row.append(randi_range(1, 3))
		terrain_codes.append(row)


func _generate_terrain_decor_codes() -> void:
	terrain_decor_codes = []
	for y in range(map_height):
		var row: Array = []
		for x in range(map_width):
			var tile: Vector2i = Vector2i(x, y)
			if _can_generate_natural_decor(tile) and randi_range(0, NATURAL_DECOR_CHANCE - 1) == 0:
				row.append(randi_range(1, 12))
			else:
				row.append(0)
		terrain_decor_codes.append(row)


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


func _ensure_terrain_decor_codes() -> void:
	var next_terrain_decor_codes: Array = []
	for y in range(map_height):
		var row: Array = []
		var saved_row: Array = []
		if y < terrain_decor_codes.size() and terrain_decor_codes[y] is Array:
			saved_row = terrain_decor_codes[y] as Array
		for x in range(map_width):
			var tile: Vector2i = Vector2i(x, y)
			var decor_code: int = 0
			if x < saved_row.size():
				decor_code = int(saved_row[x])
			if decor_code < 1 or decor_code > 12 or not _can_keep_natural_decor(tile):
				decor_code = 0
			row.append(decor_code)
		next_terrain_decor_codes.append(row)
	terrain_decor_codes = next_terrain_decor_codes


func _set_random_terrain_code(tile: Vector2i) -> void:
	if tile.x < 0 or tile.y < 0 or tile.x >= map_width or tile.y >= map_height:
		return
	_ensure_terrain_codes()
	var row: Array = terrain_codes[tile.y] as Array
	row[tile.x] = randi_range(1, 3)


func _compose_path_meta(path_variant: int, path_mask: int) -> int:
	return maxi(0, path_variant) * 4 + clampi(path_mask, 0, 3)


func _path_variant_from_meta(path_meta: int) -> int:
	return floori(float(maxi(0, path_meta)) / 4.0)


func _path_mask_from_meta(path_meta: int) -> int:
	return maxi(0, path_meta) % 4


func _set_path_metadata(tile_data: Dictionary, path_variant: int, path_mask: int) -> void:
	var path_meta: int = _compose_path_meta(path_variant, path_mask)
	tile_data["path_meta"] = path_meta
	tile_data["path_variant"] = _path_variant_from_meta(path_meta)
	tile_data["path_mask"] = _path_mask_from_meta(path_meta)


func _is_path_addon_side_clear(tile: Vector2i, path_mask_bit: int) -> bool:
	var side_tile: Vector2i = tile + Vector2i(-1, 0) if path_mask_bit == PATH_BENCH_MASK_C2 else tile + Vector2i(0, 1)
	if not is_inside_map(side_tile):
		return true
	return not is_tile_reserved(side_tile) and not is_tile_used(side_tile)


func _has_adjacent_path_addon_conflict(tile: Vector2i) -> bool:
	var right_tile: Vector2i = tile + Vector2i(1, 0)
	if is_inside_map(right_tile) and get_tile_type(right_tile) == TILE_TYPE_PATH:
		if (get_path_mask_at(right_tile) & PATH_BENCH_MASK_C2) != 0:
			return true
	var upper_tile: Vector2i = tile + Vector2i(0, -1)
	if is_inside_map(upper_tile) and get_tile_type(upper_tile) == TILE_TYPE_PATH:
		if (get_path_mask_at(upper_tile) & PATH_BENCH_MASK_C1) != 0:
			return true
	return false


func _can_generate_natural_decor(tile: Vector2i) -> bool:
	return _can_keep_natural_decor(tile) and tile != INITIAL_PATH_TILE


func _can_keep_natural_decor(tile: Vector2i) -> bool:
	return is_inside_map(tile) and not is_tile_reserved(tile) and not is_tile_used(tile)


func _get_default_terrain_code(tile: Vector2i) -> int:
	var seed := tile.x * 92821 + tile.y * 68917
	seed = seed ^ (seed << 8)
	seed = seed ^ (seed >> 5)
	var variant: int = abs(seed) % 3
	return variant + 1
