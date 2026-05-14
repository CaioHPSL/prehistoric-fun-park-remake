extends Node

# Scene-facing economy helper. The shared state lives in the Economy autoload.


func get_money() -> int:
	return Economy.money


func can_afford(amount: int) -> bool:
	return Economy.can_afford(amount)
