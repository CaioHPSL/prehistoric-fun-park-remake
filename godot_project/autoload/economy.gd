extends Node

# Shared economy state for the first playable version.

var initial_money: int = 1000
var money: int = initial_money
var total_earned: int = 0
var total_spent: int = 0


func reset() -> void:
	money = initial_money
	total_earned = 0
	total_spent = 0


func can_afford(amount: int) -> bool:
	return money >= amount


func spend(amount: int) -> bool:
	if not can_afford(amount):
		return false
	money -= amount
	total_spent += amount
	return true


func earn(amount: int) -> void:
	money += amount
	total_earned += amount
