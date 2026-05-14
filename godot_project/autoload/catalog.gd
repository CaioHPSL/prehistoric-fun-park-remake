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


func _load_json(path: String) -> Dictionary:
	if not FileAccess.file_exists(path):
		return {}
	var text := FileAccess.get_file_as_string(path)
	var parsed = JSON.parse_string(text)
	return parsed if parsed is Dictionary else {}
