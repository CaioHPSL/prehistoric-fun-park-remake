extends Control

# Minimal HUD bridge. The buttons will be wired into gameplay in the next step.

signal build_menu_requested
signal save_requested
signal load_requested

var park_controller: Node
var current_active_visitors: int = 0
var current_served_visitors: int = 0

@onready var money_label: Label = $TopBar/MoneyLabel
@onready var earned_label: Label = $TopBar/EarnedLabel
@onready var spent_label: Label = $TopBar/SpentLabel
@onready var selected_tile_label: Label = $TopBar/SelectedTileLabel
@onready var selected_object_label: Label = $TopBar/SelectedObjectLabel
@onready var build_mode_label: Label = $TopBar/BuildModeLabel
@onready var visitor_label: Label = $TopBar/VisitorLabel
@onready var build_button: Button = $TopBar/BuildButton
@onready var stats_button: Button = $TopBar/StatsButton
@onready var save_button: Button = $TopBar/SaveButton
@onready var load_button: Button = $TopBar/LoadButton
@onready var message_label: Label = $MessageLabel
@onready var message_timer: Timer = $MessageTimer
@onready var stats_panel: PanelContainer = $StatsPanel
@onready var stats_details_label: Label = $StatsPanel/Content/StatsDetails


func _ready() -> void:
	build_button.pressed.connect(_on_build_pressed)
	stats_button.pressed.connect(_on_stats_pressed)
	save_button.pressed.connect(func() -> void: save_requested.emit())
	load_button.pressed.connect(func() -> void: load_requested.emit())
	message_timer.timeout.connect(_on_message_timer_timeout)
	update_money()
	show_build_mode("Build: none")
	show_selected_object("")
	update_visitors(0, 0)
	message_label.visible = false


func bind_controller(controller: Node) -> void:
	park_controller = controller


func update_money() -> void:
	money_label.text = "$%d" % Economy.money
	earned_label.text = "Earned: $%d" % Economy.total_earned
	spent_label.text = "Spent: $%d" % Economy.total_spent
	_update_stats_panel()


func show_selected_tile(tile: Vector2i) -> void:
	if tile.x < 0 or tile.y < 0:
		selected_tile_label.text = "Tile: none"
	else:
		selected_tile_label.text = "Tile: %d, %d" % [tile.x, tile.y]


func show_selected_object(object_type: String) -> void:
	if object_type == "path":
		selected_object_label.text = "Selected: Path"
	elif object_type == "attraction":
		selected_object_label.text = "Selected: Balanço"
	else:
		selected_object_label.text = "Selected: none"


func show_build_mode(mode_text: String) -> void:
	build_mode_label.text = mode_text


func update_visitors(active_count: int, served_count: int) -> void:
	current_active_visitors = active_count
	current_served_visitors = served_count
	visitor_label.text = "Visitors: %d/%d Served: %d" % [active_count, 3, served_count]
	_update_stats_panel()


func show_message(message: String) -> void:
	message_label.text = message
	message_label.visible = true
	message_timer.start()


func _update_stats_panel() -> void:
	stats_details_label.text = "Money: $%d\nEarned total: $%d\nSpent total: $%d\nVisitors active: %d\nServed total: %d" % [
		Economy.money,
		Economy.total_earned,
		Economy.total_spent,
		current_active_visitors,
		current_served_visitors,
	]


func _on_build_pressed() -> void:
	build_menu_requested.emit()
	if park_controller and park_controller.has_method("open_build_menu"):
		park_controller.open_build_menu()


func _on_stats_pressed() -> void:
	_update_stats_panel()
	stats_panel.visible = not stats_panel.visible


func _on_message_timer_timeout() -> void:
	message_label.visible = false
