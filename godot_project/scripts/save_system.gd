extends Node

# Scene-facing save helper. File IO lives in the SaveSystem autoload.


func save_current_game() -> bool:
	return SaveSystem.save_game(GameState.to_save_data())


func load_current_game() -> bool:
	var data := SaveSystem.load_game()
	if data.is_empty():
		return false
	GameState.from_save_data(data)
	return true
