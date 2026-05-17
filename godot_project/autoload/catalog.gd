extends Node

# Loads lightweight data files for construction and balance values.

const BUILDINGS_PATH := "res://data/buildings.json"
const BALANCE_PATH := "res://data/balance.json"

var buildings: Dictionary = {}
var balance: Dictionary = {}


func _ready() -> void:
	load_all()


func load_all() -> void:
	buildings = _load_json(BUILDINGS_PATH).get("buildings", {})
	balance = _load_json(BALANCE_PATH)


func get_building(catalog_id: String) -> Dictionary:
	return buildings.get(catalog_id, {})


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
