extends Node2D

var owner_map: Node = null
var layer_kind: String = ""
var draw_count: int = 0
var redraw_request_count: int = 0


func configure(map_node: Node, kind: String) -> void:
	owner_map = map_node
	layer_kind = kind
	texture_filter = CanvasItem.TEXTURE_FILTER_NEAREST


func request_redraw() -> void:
	redraw_request_count += 1
	queue_redraw()


func consume_counters() -> Dictionary:
	var counters := {
		"draws": draw_count,
		"redraws": redraw_request_count,
	}
	draw_count = 0
	redraw_request_count = 0
	return counters


func _draw() -> void:
	draw_count += 1
	if owner_map != null and owner_map.has_method("_draw_render_layer"):
		owner_map.call("_draw_render_layer", self, layer_kind)
