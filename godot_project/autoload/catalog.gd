extends Node

# Loads lightweight data files for construction and balance values.

const BUILDINGS_PATH := "res://data/buildings.json"
const BALANCE_PATH := "res://data/balance.json"
const ATTRACTION_VISUALS_PATH := "res://data/attraction_visual_chunks.json"

var buildings: Dictionary = {}
var balance: Dictionary = {}
var attraction_visuals: Dictionary = {}


func _ready() -> void:
	load_all()


func load_all() -> void:
	buildings = _load_json(BUILDINGS_PATH).get("buildings", {})
	balance = _load_json(BALANCE_PATH)
	attraction_visuals = _load_json(ATTRACTION_VISUALS_PATH).get("attractions", {})


func get_building(catalog_id: String) -> Dictionary:
	return buildings.get(catalog_id, {})


func get_attraction_visual(catalog_id: String, jar_type: int = -1) -> Dictionary:
	var jar_key: String = str(jar_type)
	if attraction_visuals.has(jar_key):
		return attraction_visuals.get(jar_key, {}) as Dictionary
	var building_data: Dictionary = get_building(catalog_id)
	jar_key = str(int(building_data.get("jar_type", -1)))
	return attraction_visuals.get(jar_key, {}) as Dictionary


func get_building_ids_by_type(building_type: String) -> Array[String]:
	var ids: Array[String] = []
	for catalog_id in buildings.keys():
		var building_data: Dictionary = buildings[catalog_id]
		if String(building_data.get("type", "")) == building_type or String(building_data.get("category", "")) == building_type:
			ids.append(String(catalog_id))
	ids.sort()
	return ids


func _load_json(path: String) -> Dictionary:
	if not FileAccess.file_exists(path):
		return {}
	var text := FileAccess.get_file_as_string(path)
	var parsed = JSON.parse_string(text)
	return parsed if parsed is Dictionary else {}
