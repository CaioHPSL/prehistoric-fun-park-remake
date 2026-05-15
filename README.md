# Prehistoric Fun Park Remake / Port

Remake técnico em Godot 4.6 do jogo J2ME **Prehistoric Fun Park**, com foco em recriar o funcionamento original usando engenharia reversa do `.jar`, assets extraídos e implementação moderna para PC/Android.

O objetivo do projeto não é apenas “copiar visualmente”, mas entender como o jogo original funcionava e adaptar a lógica para Godot com suporte real a mouse/touch.

---

## Status atual

### v0.1 — Protótipo jogável

Concluída.

Implementado:

- mapa isométrico
- construção de caminhos
- construção de atração básica 2x2
- venda de construções
- economia básica
- visitantes simples
- visitantes seguem caminhos
- visitantes pagam e voltam para a entrada
- save/load em JSON
- HUD e painel de estatísticas
- mensagens de erro
- preview de construção

### v0.2 — Fidelidade visual ao original

Em andamento.

Implementado até agora:

- projeção isométrica ajustada para seguir a fórmula do JAR original
- entrada lógica seguindo o original
- grama usando sprites originais
- caminhos usando sprites originais com bordas
- visitantes usando sprite original e animação
- clique/preview ajustados para a nova projeção
- início da reconstrução visual da entrada, muro e área externa

---

## Plataforma

Projeto feito em:

- Godot 4.6
- GDScript
- Windows como ambiente principal de desenvolvimento
- alvo futuro: Android com touch real

---

## Estrutura principal

```text
godot_project/
├─ scenes/
│  ├─ Main.tscn
│  ├─ Park.tscn
│  ├─ IsoMap.tscn
│  ├─ HUD.tscn
│  ├─ BuildMenu.tscn
│  ├─ BuildingInfoPanel.tscn
│  └─ Visitor.tscn
│
├─ scripts/
│  ├─ park_controller.gd
│  ├─ iso_map.gd
│  ├─ camera_controller.gd
│  ├─ visitor_system.gd
│  ├─ hud.gd
│  ├─ build_system.gd
│  └─ save_system.gd
│
├─ autoload/
│  ├─ game_state.gd
│  ├─ economy.gd
│  ├─ catalog.gd
│  └─ save_system.gd
│
├─ assets/
│  └─ original_sprites/
│     ├─ terrain/
│     ├─ path/
│     └─ visitors/
│
└─ data/
   ├─ buildings.json
   └─ balance.json
