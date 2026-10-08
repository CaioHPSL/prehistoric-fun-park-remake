# Mapeamento Java → Godot

Atualizado em: 2026-10-07, America/Cuiaba.

Nenhuma equivalência funcional Java→Godot foi confirmada nesta sessão. O repositório remoto e sua estrutura foram localizados; os destinos abaixo são arquivos existentes, não prova de que uma regra Java foi migrada corretamente. Não inventar métodos, regras, nós internos ou critérios comparativos.

O analista Java e os demais especialistas propõem registros sustentados por evidências; o mestre consolida os registros e confirma seu estado após revisão. O Java permanece imutável.

## Campos de cada registro

| Campo | Conteúdo esperado |
| --- | --- |
| Identificador | Referência estável do mapeamento. |
| Data e estado | Data e estado: proposto, confirmado, em migração ou validado, conforme as evidências. |
| Símbolo Java | Classe, método, campo ou outro elemento real, com arquivo e localização quando disponíveis. |
| Evidência do original | Trecho identificado, observação reproduzível ou verificação que sustente o comportamento. |
| Mecânica e regra exata | Entradas, estados, condições, ordem, valores, unidades, transições e respostas relevantes observadas; dúvidas identificadas. |
| Destino Godot | Cena, nó, script ou recurso proposto ou confirmado, distinguindo claramente os dois estados. |
| Critério comparativo | Cenário, condições iniciais, entrada e resultado esperado que permitam comparar Java e Godot. |
| Verificação | Evidência da comparação, resultado e limitações; pendente enquanto não executada. |
| Dependências e pendências | Outros mapeamentos necessários, dúvidas e trabalho restante. |

## Destinos estruturais confirmados

Referência: `CaioHPSL/prehistoric-fun-park-remake`, `main`, commit `34662b0b2add5d7e90bd7a28b3527cabe18b9a96`. Evidência: árvore remota completa em [árvore da revisão de referência](https://github.com/CaioHPSL/prehistoric-fun-park-remake/tree/34662b0b2add5d7e90bd7a28b3527cabe18b9a96); cena principal e autoloads identificados pela inspeção de `project.godot`.

| Destino existente | Confirmação estrutural | Símbolo Java, regra e comparação |
| --- | --- | --- |
| `godot_project/scenes/Main.tscn` | Cena principal declarada no projeto. | Pendentes de análise; nenhuma equivalência confirmada. |
| `godot_project/scenes/Park.tscn` e `IsoMap.tscn` | Cenas presentes na árvore. | Pendentes de análise; nenhuma equivalência confirmada. |
| `godot_project/scenes/HUD.tscn`, `BuildMenu.tscn` e `BuildingInfoPanel.tscn` | Cenas presentes na árvore. | Pendentes de análise; nenhuma equivalência confirmada. |
| `godot_project/scenes/Visitor.tscn` | Cena presente na árvore. | Pendentes de análise; nenhuma equivalência confirmada. |
| `godot_project/autoload/game_state.gd`, `catalog.gd`, `economy.gd` e `save_system.gd` | Arquivos presentes; autoloads `GameState`, `Catalog`, `Economy` e `SaveSystem` declarados no projeto. | Pendentes de análise; nenhuma equivalência confirmada. |
| `godot_project/scripts/iso_map.gd`, `visitor_system.gd` e `park_controller.gd` | Scripts presentes na árvore. | Pendentes de análise; nenhuma equivalência confirmada. |
| `godot_project/data/buildings.json` e `balance.json` | Arquivos de dados presentes na árvore. | Valores e equivalência pendentes de análise. |

Referências Java disponíveis: o JAR original e `prehistoric_vineflower/` e `prehistoric_decompiled/`. As análises existentes estão em `docs/JAR_FULL_ANALYSIS.md` e `docs/JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md`. Os registros abaixo usam a fonte `prehistoric_vineflower/e.java`; suas associações iniciais não validam a equivalência do port.

## Mapeamentos iniciais com evidências estáticas

Data dos registros: 2026-10-07, America/Cuiaba. Os destinos e trechos abaixo foram identificados em leitura; nenhum registro tem equivalência de execução validada. As linhas se referem à fonte inspecionada no commit fixado acima.

### M-001 — Cadência de atualização

- Estado: referências identificadas; equivalência pendente.
- Java e evidência: `prehistoric_vineflower/e.java`, classe que estende `GameCanvas` e implementa `Runnable` na linha 13; `run`, linhas 1171–1219, com lógica de atualização de 100 ms.
- Regra observada: referência de cadência de 0,1 segundo na atualização do original.
- Destino Godot confirmado: `godot_project/scripts/visitor_system.gd`, linhas 8–18, constante `JAR_TICK_SECONDS = 0.1`.
- Critério comparativo proposto: medir as transições do mesmo cenário e das mesmas entradas em intervalos equivalentes, incluindo variações da taxa de quadros.
- Pendência: confirmar quais rotinas usam cada intervalo e comparar execução; constantes iguais não comprovam cadência equivalente.

### M-002 — Dimensões do mapa e entrada inicial

- Estado: referências identificadas; equivalência pendente.
- Java e evidência: `prehistoric_vineflower/e.java`, `g`/`h`, linhas 1002–1077, com `O = 30` e `ab = O / 2`; `cS`, linhas 8176–8228, usando origem `(ab, 0)` e destino `(ab, 1)` para visitantes.
- Regra observada: dimensão de referência 30 e posição horizontal de entrada 15 nos trechos inspecionados.
- Destino Godot confirmado: `godot_project/autoload/game_state.gd`, linhas 7–13, mapa 30×30, `ENTRY_TILE = Vector2i(15, 0)` e `INITIAL_PATH_TILE = Vector2i(15, 1)`.
- Critério comparativo proposto: verificar limites de coordenadas, célula de entrada, primeiro caminho e estados iniciais equivalentes.
- Pendência: confirmar conversão de coordenadas e uso dessas células nos fluxos reais; geometria e comportamento completos ainda não foram comparados.

### M-003 — Criação e dinheiro dos visitantes

- Estado: referências identificadas; equivalência pendente; hipótese relacionada em `bugs.md`.
- Java e evidência: `prehistoric_vineflower/e.java`, `cS`, linhas 8176–8228; leitura identificou chance limitada a 3..80, capacidade de 200 slots, origem e destino de entrada e dinheiro entre 40 e 79.
- Regra observada: limites e valores acima nos trechos inspecionados; condições completas de spawn ainda precisam ser reconstruídas.
- Destino Godot confirmado: `godot_project/scripts/visitor_system.gd`, linhas 8–18, limites de dinheiro 40..79; linhas 129–140, `spawn_interval = 4`, `spawn_chance = 0.35` e `require_accessible_attraction_for_spawn = true`.
- Critério comparativo proposto: comparar cenários com e sem atração acessível, limites de população, sequência de entrada e distribuição de dinheiro, controlando o tempo e a aleatoriedade quando possível.
- Pendência: identificar todas as condições Java de spawn e relacionar os parâmetros Godot à regra completa; não presumir equivalência ou divergência a partir de um único trecho.

### M-004 — Catálogo e dados de balanceamento

- Estado: fontes e destinos identificados; equivalência dos dados pendente.
- Java e evidência: `prehistoric_vineflower/e.java`, `t`/`u`, linhas 1558–1623, leitura de `arrsi`/`arr`; foram identificados 24 registros e 42 chunks.
- Regra observada: os dados binários alimentam estruturas do original; significado e unidades de cada campo ainda precisam de comparação detalhada.
- Destino Godot confirmado: `godot_project/autoload/catalog.gd`, `Catalog.load_all`, carregando `godot_project/data/buildings.json` e `balance.json`.
- Critério comparativo proposto: associar registros e campos reais, comparando quantidades, identificadores, valores, unidades e interpretação pelos sistemas consumidores.
- Pendência: mapear campos do Java aos JSON e auditar os valores. A economia inicial 2000 observada no port ainda não tem equivalência com o original estabelecida.

### M-005 — Persistência de estado

- Estado: mecanismos identificados; equivalência do estado persistido pendente.
- Java e evidência: `prehistoric_vineflower/e.java`, `dV`, linhas 10485–10518, e `dW`, linhas 10520–10578, usando `RecordStore`.
- Regra observada: persistência por armazenamento Java; campos, ordem e restauração completa ainda precisam ser comparados.
- Destino Godot confirmado: `godot_project/autoload/save_system.gd`, persistência JSON em `user://prehistoric_fun_park_01.save`.
- Critério comparativo proposto: criar um estado representativo no original e no port, salvar, reiniciar e comparar a restauração de todos os campos essenciais identificados.
- Pendência: inventariar o estado persistido e as condições de carga; não exigir igualdade de formato binário e JSON quando o critério necessário é comportamento equivalente.
