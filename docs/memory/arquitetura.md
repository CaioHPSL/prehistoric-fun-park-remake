# Arquitetura

Atualizado em: 2026-10-07, America/Cuiaba.

## Estado verificado

Antes da configuração, a pasta local continha apenas `work/` e `outputs/`, sem arquivos de aplicação, manifestos, configuração local ou repositório `.git`. Evidência: inspeção inicial do diretório e busca de arquivos. Esse fato descreve a pasta local inicial, não o estado do jogo no repositório remoto.

Fonte localizada: repositório privado `CaioHPSL/prehistoric-fun-park-remake`, branch `main`, commit `34662b0b2add5d7e90bd7a28b3527cabe18b9a96`. A árvore remota completa foi inspecionada; não foram encontrados `AGENTS.md`, `.codex/`, testes ou configuração de CI nessa árvore. Evidência: inventário remoto preservado em [árvore da revisão de referência](https://github.com/CaioHPSL/prehistoric-fun-park-remake/tree/34662b0b2add5d7e90bd7a28b3527cabe18b9a96), com `truncated = false`.

## Base de jogo existente

| Componente confirmado | Evidência e limite de confiança |
| --- | --- |
| `godot_project/project.godot` | Projeto Godot existente; configuração lida na inspeção informa Godot 4.6 e cena principal `Main.tscn`. Isso não confirma um motor instalado nem execução bem-sucedida. |
| GDScript | Arquivos `.gd` confirmados na árvore remota. Preservar a linguagem do port existente, salvo nova decisão fundamentada. |
| Autoloads `GameState`, `Catalog`, `Economy`, `SaveSystem` | Configuração inspecionada e arquivos em `godot_project/autoload/`. Contratos e regras internas ainda precisam de análise detalhada. |
| Cenas `Main`, `Park`, `IsoMap`, `HUD`, `BuildMenu`, `BuildingInfoPanel`, `Visitor` | Arquivos `.tscn` confirmados em `godot_project/scenes/`; nomes não comprovam equivalência funcional com o Java. |
| `iso_map.gd`, `visitor_system.gd`, `park_controller.gd` | Scripts existentes em `godot_project/scripts/`, aproximadamente 73 KB, 63 KB e 24 KB; comportamento ainda não validado. |
| `game_state.gd` | Script existente em `godot_project/autoload/`, aproximadamente 25 KB; comportamento ainda não validado. |
| `buildings.json`, `balance.json` | Dados existentes em `godot_project/data/`; valores e equivalência ainda não auditados. |

A leitura direta do port confirmou `Catalog.load_all` carregando `buildings.json` e `balance.json`, economia inicial de 2000 e persistência JSON em `user://prehistoric_fun_park_01.save`. Esses fatos descrevem a implementação Godot; a equivalência dos valores e do conteúdo persistido com o Java continua pendente.

Constantes observadas: mapa 30×30, `ENTRY_TILE = Vector2i(15, 0)` e `INITIAL_PATH_TILE = Vector2i(15, 1)` em `game_state.gd`, linhas 7–13; dinheiro inicial de visitantes entre 40 e 79 e `JAR_TICK_SECONDS = 0.1` em `visitor_system.gd`, linhas 8–18. Referências Java e critérios de comparação estão em `mapeamento-java-godot.md`.

Nenhum executável Godot foi encontrado no `PATH` durante a inspeção. Isso não comprova ausência de instalação em outro local. Nem o port Godot nem o JAR original foram executados, e nenhum emulador foi validado nesta sessão.

O README remoto declara protótipo v0.1 concluído e trabalho visual v0.2 em curso. Essa é uma declaração do projeto, ainda sem validação de execução nesta sessão. Há arquitetura de port existente a preservar; a equivalência detalhada com o jogo Java ainda não foi estabelecida.

## Referências protegidas

Não modificar `Prehistoric Fun Park 240x320 [BR].jar`, `prehistoric_vineflower/**`, `prehistoric_decompiled/**` ou `assets_extracted/**`. Preservar também as análises existentes `docs/JAR_FULL_ANALYSIS.md` e `docs/JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md`. São fontes para reconstruir regras e comparar o port, não alvos desta configuração inicial.

## Estrutura de coordenação aprovada

| Componente | Responsabilidade |
| --- | --- |
| Agente principal, regido por `AGENTS.md` | Mestre: planejar, distribuir trabalho independente, acompanhar, integrar, validar e manter a memória. |
| `.codex/agents/analista_java.toml` | Analista Java: reconstruir as regras do original com evidências, sem alterar o código Java. |
| `.codex/agents/arquiteto_godot.toml` | Arquiteto Godot: propor cenas, nós, scripts e contratos de migração a partir do comportamento observado. |
| `.codex/agents/programador.toml` | Programador: implementar somente o escopo de migração autorizado e os arquivos atribuídos. |
| `.codex/agents/especialista_gameplay.toml` | Especialista em gameplay: preservar regras, estados, entradas e respostas do jogo original. |
| `.codex/agents/especialista_visual.toml` | Especialista visual: mapear e preservar apresentação, recursos e interface conforme as evidências do original. |
| `.codex/agents/testador.toml` | Testador: comparar Java e Godot, verificar critérios de aceite e reportar regressões sustentadas por evidências. |
| `.codex/config.toml` | Habilitar multiagentes e controlar a concorrência das tarefas delegadas. |
| `docs/memory/` | Preservar o contexto do projeto sob manutenção do mestre. |
| `work/` | Arquivos intermediários e temporários. |
| `outputs/` | Entregáveis destinados ao usuário. |

Configuração local criada: `features.multi_agent = true`, `agents.enabled = true` e até três subagentes simultâneos além do mestre. Os especialistas usam arquivos TOML independentes no formato de descoberta automática documentado. Sintaxe e campos foram validados; execução real dos perfis ainda não foi testada. O carregamento da configuração local exige confiança no projeto.

A configuração global manteve seu SHA-256 anterior. A verificação de entrada do Codex confirmou a inclusão de `AGENTS.md` nas instruções, mas não expôs schemas de ferramentas e, portanto, não atestou a descoberta dos especialistas.

## Contratos de trabalho

Cada delegação define objetivo, contexto, escopo, arquivos permitidos, dependências, critérios de aceite, verificações e formato de retorno. Um arquivo deve ter apenas um agente escritor por vez. Contratos compartilhados e mudanças que ultrapassem o escopo retornam ao mestre para coordenação.

O mestre aceita resultados somente após revisar evidências, resolver conflitos, conferir contratos e validar o conjunto integrado. O limite de concorrência orienta a distribuição; os seis especialistas podem atuar em etapas.

## Contrato de migração

O Java é uma referência imutável: não editar, reformatar ou refatorar os arquivos originais. O port Godot existente deve reproduzir as mecânicas, os comportamentos e as funcionalidades essenciais identificados, sem novas funcionalidades não autorizadas. Cada etapa deve associar evidências do original a um destino Godot e a critérios comparativos explícitos; hipóteses permanecem identificadas como hipóteses até confirmação. A configuração inicial será levada a um PR contendo somente novos arquivos de configuração e documentação, sem alterar o código do jogo.

Mapeamentos são mantidos em `mapeamento-java-godot.md`; funcionalidades só entram como concluídas em `funcionalidades-migradas.md` depois da comparação e da integração. Divergências observadas devem ser registradas em `bugs.md`.

## Pendências de arquitetura

- Preservar e identificar a base do port existente antes de alterar código em tarefas futuras.
- Analisar o Java e as análises já existentes para identificar mecânicas e regras exatas com evidências.
- Confirmar o ambiente de execução Godot 4.6 e verificar o port; a configuração do projeto não comprova disponibilidade local.
- Estabelecer verificações de equivalência entre o original e o port existente.
- Investigar a hipótese sobre exigência de atração acessível no spawn e a divergência documental de tamanho 2×2 versus constante 3×3, registradas em `bugs.md`; não tratar esses achados como defeitos de gameplay confirmados.
- Verificar os arquivos de configuração criados e a descoberta dos especialistas.
- Validar o primeiro fluxo de migração gradual com delegação, comparação e integração.
