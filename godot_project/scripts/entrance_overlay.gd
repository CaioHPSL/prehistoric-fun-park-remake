extends Node2D

# Draws the tall entrance pieces above visitors without lifting the whole map.

const PATH_TEXTURE: Texture2D = preload("res://assets/original_sprites/path/gpack1_002.png")
const ENTRANCE_TEXTURE: Texture2D = preload("res://assets/original_sprites/entrance/gpack1_006.png")
const ENTRANCE_ROCK_REGION: Rect2 = Rect2(0.0, 112.0, 15.0, 12.0)
const ENTRANCE_SIGN_REGION_A: Rect2 = Rect2(90.0, 83.0, 15.0, 20.0)
const ENTRANCE_SIGN_REGION_B: Rect2 = Rect2(105.0, 84.0, 18.0, 13.0)

@export var tile_width: int = 40
@export var tile_height: int = 20


func _ready() -> void:
	texture_filter = CanvasItem.TEXTURE_FILTER_NEAREST


func tile_to_screen(tile: Vector2i) -> Vector2:
	return Vector2(
		(tile.x + tile.y) * tile_width * 0.5,
		(tile.x - tile.y) * tile_height * 0.5
	)


func _draw() -> void:
	var entry_tile: Vector2i = GameState.ENTRY_TILE
	var left_tile: Vector2i = Vector2i(entry_tile.x - 1, -1)
	var right_tile: Vector2i = Vector2i(entry_tile.x + 1, -1)
	_draw_external_tile(ENTRANCE_TEXTURE, left_tile, ENTRANCE_ROCK_REGION, Vector2(14.0, -2.0))
	_draw_external_tile(ENTRANCE_TEXTURE, left_tile, ENTRANCE_ROCK_REGION, Vector2(15.0, -8.0))
	_draw_external_tile(ENTRANCE_TEXTURE, left_tile, ENTRANCE_ROCK_REGION, Vector2(17.0, -14.0))
	_draw_external_tile(ENTRANCE_TEXTURE, right_tile, ENTRANCE_ROCK_REGION, Vector2(4.0, -7.0))
	_draw_external_tile(ENTRANCE_TEXTURE, right_tile, ENTRANCE_ROCK_REGION, Vector2(3.0, -15.0))
	_draw_external_tile(ENTRANCE_TEXTURE, right_tile, ENTRANCE_ROCK_REGION, Vector2(2.0, -23.0))
	_draw_external_tile(PATH_TEXTURE, right_tile, ENTRANCE_SIGN_REGION_A, Vector2(-19.0, -44.0))
	_draw_external_tile(PATH_TEXTURE, right_tile, ENTRANCE_SIGN_REGION_B, Vector2(-4.0, -33.0))


func _draw_external_tile(texture: Texture2D, tile: Vector2i, source_region: Rect2, offset: Vector2) -> void:
	var top: Vector2 = tile_to_screen(tile)
	var target_rect: Rect2 = Rect2(
		top + Vector2(tile_width * -0.5, 0.0) + offset,
		source_region.size
	)
	draw_texture_rect_region(texture, target_rect, source_region)
