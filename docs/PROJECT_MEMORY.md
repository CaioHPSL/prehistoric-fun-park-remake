# Memória durável do projeto

> Registros compartilhados entre sessões e agentes do Codex. Não substituir por memórias automáticas locais.

## Identidade
- Projeto: **Prehistoric Fun Park Remake / Port**.
- Origem: jogo de gerenciamento de parque **Java ME (J2ME/MIDP)** distribuído em JAR 240x320.
- Destino: **Godot 4.6 + GDScript** no Windows, com PC/mouse e futura adaptação Android/touch.
- Meta: **fidelidade mecânica e visual com modernização de controles**, não tradução linha a linha.

## Onde buscar fatos
- `docs/JAR_FULL_ANALYSIS.md`: comportamento do original, evidências e níveis de confiança.
- `docs/JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md`: mapeamento de sistemas e prioridades.
- `prehistoric_vineflower/`: decompilação principal; `prehistoric_decompiled/`: comparação CFR.
- `assets_extracted/`: PNGs do JAR; `godot_project/assets/original_sprites/`: cópias/importações usadas no jogo.
- `godot_project/project.godot`: autoloads e cena inicial.
- `README.md`: marcos de implementação declarados; confirmar estado no código antes de afirmar conclusão.

## Contratos arquiteturais observados em main (snapshot 2026-10-07)
- `godot_project/project.godot`: cena principal `res://scenes/Main.tscn`; autoloads `GameState`, `Catalog`, `Economy`, `SaveSystem`; janela 1280x720 e renderer mobile.
- `godot_project/autoload/game_state.gd`: valores-padrão de mapa 30x30; tile de entrada `Vector2i(15, 0)`; caminho inicial `Vector2i(15, 1)`.
- `godot_project/scripts/park_controller.gd`: coordena interação, construção e sinais de visitantes/UI.
- `godot_project/scripts/iso_map.gd`: desenho e camadas do mapa, texturas/crops originais; mudanças aqui exigem cuidado com profundidade/performance.
- `godot_project/scripts/build_system.gd`: contém placeholders; não confundir com implementação efetiva em `park_controller.gd`.
- `godot_project/autoload/save_system.gd` é o autoload registrado; existe também `godot_project/scripts/save_system.gd`, cuja finalidade precisa ser checada antes de qualquer mudança.

## Princípios permanentes
1. O original e assets extraídos são evidência de referência; não os sobrescrever.
2. Distinguir fatos confirmados, inferências e comportamento efetivamente testado.
3. Implementar por sistema, manter o jogo jogável, evitar agentes com escrita paralela no mesmo arquivo.
4. Verificar impacto no save, controles, renderização e economia.
5. Usar os arquivos versionados como memória compartilhada; memória nativa do Codex é opcional/complementar.

## Política de qualidade e refatoração
- O mestre pode solicitar manutenção e melhoria do código existente, não apenas migração de novas funcionalidades.
- Regra: eliminar necessidade e duplicação antes de criar mais código, sem sacrificar legibilidade nem equivalência com o JAR original.
- `code_quality_reviewer` faz auditoria somente leitura; um implementador designado faz alterações e `qa_reviewer` verifica regressões.
- Otimizações exigem indicação de custo/medição sempre que possível; refatorações devem ser pequenas, isoladas e testáveis.

## Especialistas adicionados
- Performance: diagnostico com evidencias e medicoes quando possivel, sem edicao.
- Testes: implementacao de testes sob atribuicao, separada da revisao QA.
- Recursos J2ME: leitura e mapeamento de atlas, sprites e dados originais, sem edicao.
- Delegar somente quando necessario; manter escopos distintos e evitar alteracoes concorrentes.

## Decisões novas
| Data | Decisão | Motivo/evidência | Status |
| --- | --- | --- | --- |
| 2026-10-07 | Adicionar mestre em AGENTS.md e subagentes de port, revisão e memória | Permitir divisão de tarefas com revisão e preservação do código original | Configuração proposta; validar no cliente Codex |
| 2026-10-07 | Exigir avaliação da menor mudança segura e auditoria de código existente | Evitar duplicação, abstrações sem valor e reescritas sem necessidade | Regra e novo revisor definidos; testes locais pendentes |

## Perguntas em aberto
- Quais partes da v0.2 já foram testadas manualmente na Godot e em qual versão?
- Quais sistemas originais têm prioridade após o acabamento visual atual?
- Qual é a estratégia de testes automáticos para cenas e simulação?

Atualize esta memória apenas após constatar novos fatos ou decisões aprovadas. Anexe referências de arquivo/método sempre que possível.
