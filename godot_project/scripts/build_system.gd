extends Node

# Placeholder for construction validation and placement.


func can_place_building(_catalog_id: String, _tile: Vector2i) -> bool:
	# Version 0.1 will check money, footprint, and map occupancy here.
	return false


func place_building(_catalog_id: String, _tile: Vector2i) -> bool:
	# Version 0.1 will spend money and write to GameState here.
	return false


func sell_building(_building_id: String) -> bool:
	# Version 0.1 will refund part of the cost here.
	return false
