# Diagnóstico e plano incremental — Prehistoric Fun Park

Inspeção em 2026-10-07. Repositório acessado pela conexão GitHub do usuário:
[`CaioHPSL/prehistoric-fun-park-remake`](https://github.com/CaioHPSL/prehistoric-fun-park-remake).
Referência examinada: `main`, commit `34662b0b2add5d7e90bd7a28b3527cabe18b9a96`.

## Diagnóstico da estrutura

A pasta local da conversa estava vazia, com apenas `work/` e `outputs/`. O
repositório remoto já contém um port substancial; não é um projeto iniciado do
zero. A árvore remota completa foi inspecionada antes de preparar a configuração.
Não havia `AGENTS.md`, `.codex/`, testes ou workflows de CI nessa árvore.

```text
Prehistoric Fun Park 240x320 [BR].jar   original preservado
prehistoric_vineflower/               Java decompilado e dados originais
prehistoric_decompiled/               segunda decompilação para comparação
assets_extracted/                    sprites extraídos preservados
docs/
  JAR_FULL_ANALYSIS.md                estudo existente
  JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md plano existente
godot_project/
  project.godot                      Godot 4.6, GDScript, cena Main
  scenes/                            Main, Park, IsoMap, HUD, menus, Visitor
  autoload/                          GameState, Catalog, Economy, SaveSystem
  scripts/                           controle do parque, mapa, visitantes, UI
  data/                              buildings.json e balance.json
  assets/original_sprites/            cópias de recursos para o port
```

`project.godot` confirma Godot 4.6 e os quatro autoloads. `Main.tscn` instancia
`Park.tscn`; esta reúne mapa, visitantes, câmera, interface e camadas visuais.
Os scripts `iso_map.gd` (~73 KB), `visitor_system.gd` (~63 KB),
`game_state.gd` (~25 KB) e `park_controller.gd` (~24 KB) concentram trabalho
compartilhado. Isso exige atribuição de um escritor por arquivo e integração
gradual, especialmente quando gameplay e visual dependem do mesmo mapa.

O README informa v0.1 jogável e v0.2 visual em andamento. Essas declarações
foram lidas; não foram confirmadas executando o jogo. A inspeção de código
confirma componentes de mapa, catálogo, economia, save JSON e visitantes.

## O que já foi verificado em leitura

| Sistema | Evidência Java | Evidência Godot e conclusão limitada |
| --- | --- | --- |
| Ciclo principal | `prehistoric_vineflower/e.java:1171`, `run()` usa janela de 100 ms. | `visitor_system.gd` declara `JAR_TICK_SECONDS = 0.1`. Constante compatível; temporização completa ainda não comparada. |
| Mapa e entrada | `e.java:1002`, `g()/h()` configuram modo livre com dimensão 30 e entrada `ab=O/2`. | `game_state.gd` declara mapa 30×30, entrada `(15,0)` e caminho inicial `(15,1)`. Confirmado em leitura; fluxo de criação ainda não executado. |
| Visitantes | `e.java:8176`, `cS()` usa até 200 slots, chance limitada a 3..80 e dinheiro individual 40..79. | `visitor_system.gd` declara limites correspondentes e estados. A equivalência das transições e probabilidades requer testes. |
| Catálogo e gráficos | `e.java:1558`, `t()/u()` leem `arrsi.dat`/`arr.dat`; `b()` carrega gpacks. | `Catalog.load_all()` lê `buildings.json` e `balance.json`; mapa/visitantes usam sprites extraídos. Integridade da conversão de todos os registros ainda não verificada. |
| Persistência | `e.java:10485`, `dV()/dW()` gravam estado em `RecordStore`. | `SaveSystem` grava JSON em `user://prehistoric_fun_park_01.save`. Formato diferente existente; fidelidade do estado salvo e compatibilidade de saves pendentes. |

As referências Java acima são do texto decompilado, no commit fixado. Há
artefatos como campos homônimos com tipos distintos em `Park.java` e expressão
`X-X` em `e.java`. Não representam bugs confirmados do original nem uma fonte
presumivelmente recompilável. Em caso de ambiguidade, comparar a segunda
decompilação, bytecode/dados e observação do JAR.

Dois pontos merecem investigação dirigida:

- O README descreve atração básica 2×2; `GameState` declara
  `BASIC_ATTRACTION_SIZE = Vector2i(3, 3)`. É uma divergência documental
  comprovada, sem conclusão sobre qual dimensão corresponde ao original.
- O port declara `require_accessible_attraction_for_spawn = true`. O plano
  anterior recomenda esse requisito, mas os trechos Java `k()/cS()` inspecionados
  não mostram um teste equivalente explícito. É uma possível divergência a
  investigar, não um defeito confirmado nem autorização para mudar o spawn.

## Plano de migração e validação

O plano abaixo será executado em incrementos futuros, após apresentar este
diagnóstico. Esta entrega configura o ambiente; nenhuma funcionalidade do jogo
foi reescrita ou alterada.

| Etapa | Trabalho e agentes | Critério de saída |
| --- | --- | --- |
| 0 — Preservar a base | Mestre registra revisão e protege JAR, decompilações e assets. Testador prepara cenários do port atual e do original. | Baseline identificada; execução e limitações documentadas, sem substituir sistemas existentes. |
| 1 — Fechar os contratos | Analista Java mapeia regras e dados; Arquiteto Godot confronta o destino existente. Podem trabalhar em paralelo em leitura. | Mapeamento por sistema com evidência, ambiguidades e critérios de comparação; prioridades revistas à luz do código atual. |
| 2 — Mapa, entrada e caminhos | Gameplay verifica regras discretas; Visual verifica projeção, bordas e profundidade. Programador aplica só diferenças confirmadas. | Casos de entrada, construção, limites, seleção e exterior comparados; escrita serial quando compartilharem `iso_map.gd` ou `GameState`. |
| 3 — Visitantes | Gameplay e Programador tratam spawn, caminhos e estados por incremento. Testador compara sem/ com caminhos e atrações. | Limites, distribuição, dinheiro, entradas/saídas e estados com evidência; requisito de atração esclarecido antes de qualquer mudança. |
| 4 — Atração real e filas | Selecionar do catálogo original uma atração, como Balanco apontada no plano existente, após conferir o que já está implementado. | Dimensões, custos, fila, ciclo, capacidade e pagamento comparados; dados sem valores inventados. |
| 5 — Demais sistemas e persistência | Expandir somente o inventário original: serviços, economia, menus, animação e saves, conforme o mapeamento. | Cada sistema verificado separadamente; saves anteriores preservados e alterações de formato documentadas. |

A ordem de mapa/caminhos → visitantes → atração/filas aproveita o plano
existente; não presume que todos esses sistemas estejam ausentes. A primeira
tarefa de cada etapa é verificar o estado corrente e selecionar a menor lacuna
comprovada.

Para cada incremento, registrar cenário, entradas, resultado esperado observado
no original, resultado no port, versão/commit, verificações e limitações. O
mestre revê as entregas, verifica contratos compartilhados e testa o conjunto
antes de declarar conclusão. Novas funcionalidades e mudanças intencionais de
comportamento dependem da autorização do usuário.

## Testes e limites desta inspeção

Foram feitas leitura da árvore completa, leitura das configurações e cenas
centrais, trechos Java e Godot e consulta das análises existentes. A validação
da configuração multiagentes é registrada em `docs/memory/progresso.md`.

Não foram executados o JAR, emulador J2ME, importação/execução Godot, testes de
gameplay, comparação visual ou testes de save. O executável Godot não foi
encontrado no PATH desta sessão; isso não comprova ausência do editor na máquina.
O port não está clonado nesta pasta. Portanto, leitura estática não confirma
fidelidade nem ausência de bugs. Nenhum sistema foi marcado como verificado
por execução nesta entrega.

## Próxima etapa concreta

Abrir um checkout do repositório na revisão registrada, localizar o Godot 4.6 e
um ambiente capaz de executar o JAR, e registrar uma pequena bateria inicial:
carregar parque, selecionar tile, construir/remover caminho, testar entrada e
spawn de visitantes e salvar/carregar. Preservar os saves existentes e executar
comparações em dados de teste separados. Só então escolher a primeira lacuna
de fidelidade para implementação incremental.

Os arquivos de instruções e memória ficam na raiz do repositório. A memória
nativa do Codex já estava habilitada nesta máquina e foi preservada; veja
`docs/ambiente-multiagentes.md` para habilitação em outra instalação.
