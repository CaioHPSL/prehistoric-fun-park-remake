extends Control

# Minimal HUD bridge. The buttons will be wired into gameplay in the next step.

signal build_menu_requested
signal save_requested
signal load_requested

var park_controller: Node

@onready var money_label: Label = $TopBar/MoneyLabel
@onready var selected_tile_label: Label = $TopBar/SelectedTileLabel
@onready var build_mode_label: Label = $TopBar/BuildModeLabel
@onready var build_button: Button = $TopBar/BuildButton
@onready var save_button: Button = $TopBar/SaveButton
@onready var load_button: Button = $TopBar/LoadButton


func _ready() -> void:
	build_button.pressed.connect(_on_build_pressed)
	save_button.pressed.connect(func() -> void: save_requested.emit())
	load_button.pressed.connect(func() -> void: load_requested.emit())
	update_money()
	show_build_mode("Build: none")


func bind_controller(controller: Node) -> void:
	park_controller = controller


func update_money() -> void:
	money_label.text = "$%d" % Economy.money


func show_selected_tile(tile: Vector2i) -> void:
	if tile.x < 0 or tile.y < 0:
		selected_tile_label.text = "Tile: none"
	else:
		selected_tile_label.text = "Tile: %d, %d" % [tile.x, tile.y]


func show_build_mode(mode_text: String) -> void:
	build_mode_label.text = mode_text


func _on_build_pressed() -> void:
	build_menu_requested.emit()
	if park_controller and park_controller.has_method("open_build_menu"):
		park_controller.open_build_menu()
