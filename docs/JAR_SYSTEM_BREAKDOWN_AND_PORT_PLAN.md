# Auditoria tecnica por sistemas - Prehistoric Fun Park

Documento criado para guiar o remake em Godot/Android por porcoes inteiras e fieis ao JAR original.

Fontes usadas nesta auditoria:

- `prehistoric_vineflower/e.java` como fonte principal.
- `prehistoric_vineflower/Park.java`, `a.java`, `b.java`, `c.java`, `d.java`, `f.java`.
- `prehistoric_decompiled/e.java` como referencia paralela quando o Vineflower fica ambiguo.
- `docs/JAR_FULL_ANALYSIS.md` como relatorio tecnico anterior ja confirmado.
- `arr.dat`, `arrsi.dat`, `text.da*`, `warntext.da*`, `helptext.da*`.
- `assets_extracted/gpack0`, `gpack1`, `gpack2`, `gpack3`.
- `godot_project/` apenas na secao de comparacao.

Convencoes:

- **Confirmado**: sustentado por metodo, campo, array, arquivo, indice ou recorte de sprite.
- **Inferencia**: o codigo sustenta o comportamento, mas o nome semantico vem de interpretacao.
- **Incerteza**: a ofuscacao ou tabelas binarias impedem fechar a conclusao.
- Nomes como `balanc[o` aparecem assim nos textos extraidos por causa da codificacao do J2ME; neste documento uso `Balanco` quando estiver falando do remake.

## 1. Como o jogo original inicia

Sequencia confirmada:

1. `Park.startApp()` e o ponto de entrada do MIDlet. Na primeira execucao cria `new c(this)`, cria `new f(this)`, seta o estado inicial da splash task para `-2`, chama `Display.getDisplay(this).setCurrent(this.a)` e inicia `f.a()`. Fonte: `Park.java`, `startApp()`.
2. `c` e o Canvas de splash/loading. `c.paint(Graphics)` desenha `/splash0.png`, `/splash1.png`, `/splash2.png` conforme o campo de estado `a`, pinta fundo branco e barra de progresso quando `a >= 2`. Fonte: `c.java`, `paint(Graphics)`.
3. `f.run()` controla a transicao temporizada da splash. Ele dorme cerca de `700L` ms por passo. Quando `a == 2`, chama `System.gc()`, instancia `new e(Park)`, troca o `Display` para o `GameCanvas` e chama `e.a()`. Fonte: `f.java`, `run()`.
4. `e.a()` carrega splash final, atualiza barra, chama `t()` para ler dados binarios/textos, chama `dH()` para carregar localizacao/recursos de texto, cria audio `new a("entry.mid", "audio/midi")`, chama `dU()` para ler save/progresso global, chama `b()` para carregar `gpack0.dat` ate `gpack3.dat`, inicializa buffers graficos e chama `c()` para iniciar a thread principal. Fonte: `e.java`, `a()` e `b()`.
5. `b()` le os `gpack*.dat`. Cada entrada e lida com dois bytes de tamanho em ordem little-endian (`u = read(); v = read(); var2 = v * 256 + u`) e vira `Image.createImage(...)`. Fonte: `e.java`, `b()`.
6. `c()` cria `new Thread(this)` e inicia `run()`. Fonte: `e.java`, `c()`.
7. `run()` executa tick logico de aproximadamente 100 ms. Ele processa input (`aS()`), simulacao (`k()`), redraw de mundo (`x()` quando `aa != 0`), renderiza gameplay ou telas e finaliza em `p()` com `flushGraphics`. Fonte: `e.java`, `run()` e `p()`.
8. A criacao/estado inicial do mapa acontece por `g()`, que chama `h()`, `i()`, `j()`, define dinheiro, arrays de estatistica e seta `b[ab][0] = 0`. Fonte: `e.java`, `g()`.

Respostas diretas:

| Pergunta | Resposta | Fonte |
|---|---|---|
| Classe que inicia tudo | `Park`, o MIDlet | `Park.startApp()` |
| Classe principal do jogo | `e`, `GameCanvas` com `Runnable` | `f.run()` instancia `new e(this.a)` |
| Recursos carregados primeiro | splash PNGs, dados de `arr*.dat`/textos, audio MIDI, save global, gpacks | `c.paint()`, `e.a()`, `e.b()`, `e.dU()` |
| Quando o mapa e criado | em `g()`, chamado durante novo jogo/load antes de entrar em gameplay | `e.g()`, `e.ea()` chama `g()` antes de carregar save |
| Quando visitantes aparecem | a simulacao chama `cS()` para tentar spawn por chance `aU`; eles so aparecem depois do loop principal estar rodando | `e.cS()` |
| Quando o jogador interage | apos `e.c()` iniciar `run()` e o estado principal `b` permitir input por `aS()` | `e.run()`, `e.aS()` |

Estado inicial importante:

- Dinheiro inicial vem de `this.k = this.b[this.K][this.M][this.L]` em `g()`. O valor confirmado no relatorio anterior para modo livre/estado inicial usado no remake e `2000`. Fonte: `e.g()` e `docs/JAR_FULL_ANALYSIS.md`.
- Entrada logica inicial: `b[ab][0] = 0`, com `ab = O / 2`. Em mapa 30x30, `ab = 15`. Fonte: `e.g()`, `e.h()`.
- Mapa livre: `O = 30` quando `K == 0`. Fonte: `e.h()`.

## 2. Visao geral dos sistemas do jogo

| Sistema | Metodos principais | Campos/arrays principais | Papel no jogo | Dependencias | Equivalente Godot atual | Fidelidade | Prioridade |
|---|---|---|---|---|---|---|---|
| Inicializacao/MIDlet | `Park.startApp()`, `c.paint()`, `f.run()`, `e.a()` | `Park.a`, `c.a`, `f.a` | Splash, carregamento e entrada no loop | Assets, textos, save | `project.godot`, `Main.tscn`, `Park.tscn` | media | baixa |
| Loop principal | `run()`, `k()`, `x()`, `p()` | `b`, `aa`, `s`, `c` | Tick, simulacao, render final | Todos os sistemas | Godot `_process`/signals dispersos | baixa | media |
| Mapa/terreno | `g()`, `h()`, `i()`, `F()`, `G()`, `I()`, `J()` | `O`, `ab`, `b[][]`, `c[][]`, `f[][]` | Mapa isometrico, terreno, tiles externos | Render, construcao, save | `GameState`, `iso_map.gd` | media | alta |
| Entrada/muro/externo | `I()`, `J()`, `aw()`, `aK()`, `as()`, `at()`, `aJ()` | `ab`, `b[ab][0]`, `h[65..70]` | Portao, WELCOME, estrada e bordas | Mapa, render, visitantes | `iso_map.gd` | media | alta |
| Camera/viewport/profundidade | `r()`, `al()`, `a(int,int,int,int)`, `am()`, `ai()`, `aL()` | `f[][]`, `a[]`, `X/Y/W`, `Z/aa` | Culling, ordem isometrica, sprite alto | Render, visitantes, atracoes | `camera_controller.gd`, `_draw()` simples | baixa | alta, mas risco FPS |
| Path/caminhos | `F()`, `ch()`, `bX()`, `bK()`, `bP()`, `Y()`, `Z()` | `b=0`, `c[][]`, `c/4`, `c&1`, `c&2` | Caminhos andaveis, variantes e bordas | Visitantes, construcao, entrada | `GameState.tiles`, `path_variant`, `path_mask` | media | alta |
| Visitantes | `cS()`, `cU()`, `dr()`, `dm()`, `dn()`, `do()`, `dz()`, `aL()` | `A[]..J[]`, `L[]`, `P..V`, `W[]` | Spawn, movimento, dinheiro, estados, animacao | Path, atracoes, servicos | `visitor_system.gd` | media | alta |
| Atracoes | `u()`, `cc()`, `cd()`, `ce()`, `aD()`, `aE()`, `aF()` | `Z[]`, `aa[]`, `l/m/n`, `am/au/aA/az/al`, `o[][]` | Catalogo, footprint, ciclo, sprites | Construcao, fila, render | `buildings.json`, `GameState.buildings` | baixa/media | alta |
| Fila/uso de atracoes | `dt()`, `dv()`, `dw()`, `cL()`, `cP()`, `cQ()`, `cN()`, `cR()` | `f[][]`, `ad[]`, `e[][]`, `ac[]`, `W=11`, `W=13` | Fila, embarque, pagamento, ciclo, satisfacao | Visitantes, atracoes | `visitor_system.gd` | media | alta |
| Servicos/necessidades | `v()`, `da()`, `dj()`, `dp()`, `cV()`, `cW()` | `aF/aG/aH`, `P/Q/R/S/T/U/V`, `ak[]` | Fome, sede, banheiro, saude, descanso, felicidade | Visitantes, funcionarios | inexistente | inexistente | media |
| Funcionarios/manutencao | `cj()`, `dk()`, `dl()`, `dq()` | entidades 200..221, `A[]`, `ai[]`, `ah[]`, `W=17` | Contratacao, reparo, guarda, medico etc. | Atracoes, servicos, economia | inexistente | inexistente | media |
| Economia | `cr()`, `ci()`, `cQ()`, `dW()`, `n()` | `k`, `d`, `e`, `L[]`, `az[]`, `al[]` | Dinheiro, custos, receita, derrota | Todos | `Economy`, `balance.json` | media | alta |
| Menus/UI/input | `keyPressed()`, `aS()`, `S()`, `ak()`, `L()`, `T()`, `E()`, `Q()` | `b`, `R`, `n`, `aX`, `aW`, `B/C`, `at` | Telas, softkeys, construcao, paineis | Textos, construcao | `HUD`, `BuildMenu`, paineis | baixa/media | media |
| Save/load | `dT()..ef()` | `RecordStore`, `b/c`, entidades, rides, stats | Persistencia completa | Todos | JSON simples | baixa | media |
| Campanha/progresso | `q()`, `n()`, `dT()`, `dU()` | `K`, `L`, `M`, `D`, `Q`, unlocks | Livre/campanha, objetivos, vitoria/derrota | Economia, UI, save | inexistente | inexistente | baixa/media |
| Assets/sprites | `b()`, `aE()`, `aF()`, `aL()` | `gpack0..3`, tabelas `b.java`, chunks `arr.dat` | Atlas, recortes, animacoes | Render | assets parcialmente importados | media parcial | alta para visual |
| Audio | `a.java`, `e.a()` | `entry.mid`, `VolumeControl`, `Player` | Musica MIDI | Opcoes/UI | inexistente | inexistente | baixa |
| Estatisticas | `R=26`, `cv()`, `dZ()` | `c[0..7][]`, `e[][]`, `d.k` | Graficos de dinheiro/visitas/felicidade | Economia, visitantes, save | HUD simples | baixa | media |

## 3. Mapa, chao e terreno

### Chao jogavel

- Area jogavel real: `0 <= x < O`, `0 <= y < O`. Em modo livre `O = 30`; em campanha `O = aI[h[134] + L]`, com tamanhos confirmados `[12, 15, 20, 25, 25, 30]`. Fonte: `e.h()`.
- Centro horizontal/entrada: `ab = O / 2`. Em mapa 30x30, `ab = 15`. Fonte: `e.h()`.
- Arrays reais do mapa: `b[30][30]` e `c[30][30]`. Fonte: construtor de `e` e `e.dW()/ea()`.
- `i()` gera o terreno inicial. Se `(random % 20) == 0`, coloca decoracao natural negativa `-1 - random%12`; senao, grama `1..3`. Fonte: `e.i()`.
- `G()` desenha grama quando `b[x][y] <= 3`: `drawRegion(this.c[0], 0, 20 * (b[x][y] - 1), 38, 20, ...)`. Fonte: `e.G()`.
- Sprite de terreno: `gpack2_000.png`, regioes `(0,0,38,20)`, `(0,20,38,20)`, `(0,40,38,20)`. Confirmado por `G()` e `b.B={40,20}` em `b.java`.

### Valores de `b[][]`

| Valor | Significado | Fonte | Certeza |
|---|---|---|---|
| `0` | Path/caminho | `F()` desenha path; `g()` seta `b[ab][0] = 0` | alta |
| `1..3` | Grama/chao base | `G()` usa `b-1` como linha do sprite | alta |
| `<0` | Objeto/servico/decoracao | `H()`, `cf()`, `cg()`, `bZ()` | alta |
| `>3` ate `12/13` | Footprint/codigos internos de atracao/objeto | `ce()`, `G()`, `bY()` | alta |

### Valores de `c[][]`

- Para path, `F()` usa `c[x][y] / 4` como variante visual de base. Fonte: `e.F()`.
- Bits baixos sao usados com `c % 4`, `c & 1`, `c & 2` em logica de path/conexao/demolicao. Fonte: `bX()`, `ch()`, `bK()` no relatorio anterior. Significado exato de cada bit: **inferencia media**, mas a divisao `path_variant = c / 4` e `path_mask = c % 4` e consistente.
- Para atracoes/servicos, `c[x][y]` guarda o slot/dono do objeto. Fonte: `ce()` escreve `c[...] = ay`; `ca()` usa `c[a[0]][a[1]]` para achar slot.
- Para visitantes, `c[B][C]` tambem pode guardar indice de entidade quando ela ocupa tile. Fonte: `cS()` escreve `c[B][C] = aO`; `dq()` restaura/limpa ocupacao. Este uso compartilhado precisa ser redesenhado no Godot para evitar acoplamento excessivo.

### Chao fora do mapa

- Coordenadas externas aparecem no render, mas nao sao salvas como tiles reais. `J()` trata `Z == -1`, `Z == O`, `aa == -1`, `aa == O` para bordas. Fonte: `e.J()`.
- `I()` trata fora do mapa quando a conversao tela->tile cai fora. Se `Z == ab && aa < 0`, desenha caminho externo com o mesmo path base e chama `aw()` para WELCOME/portao. Fonte: `e.I()`.
- Para outros pontos externos, `I()` desenha grama default e decoracoes condicionais por `d[(Z mod 10)][(aa mod 10)]`. Fonte: `e.I()`.
- Conclusao: coordenadas negativas sao **virtuais de render**, nao dados persistentes. Fonte: `dW()` salva apenas 30 linhas de `b[][]`/`c[][]`.

### Estrada externa

- A estrada externa usa a condicao `Z == ab && aa < 0`. Fonte: `e.I()`.
- Ela nao e um tile jogavel, mas visualmente continua para varios `y` negativos.
- O visitante nasce logicamente em `(ab,0)`, porem com `H=-100`, o que desloca visualmente o sprite para fora, aproximadamente `Vector2(-100, 50)` em relacao ao ponto da entrada no port. Fonte: `cS()`, campos `B/C/D/E/G/H`.
- Adaptacao Godot: manter `ENTRY_TILE=(15,0)` como logico, desenhar estrada externa virtual em `x=15, y=-1..-6`, nao salvar esses tiles e nao coloca-los no pathfinding.

### Bordas externas

- `J()` desenha bordas/cantos externos usando tabelas `h[65]..h[70]` e `drawRegion(this.b[2], ...)`. Fonte: `e.J()`.
- `aJ()` e chamado para lados `Z == -1`, `Z == O`, `aa == -1`, `aa == O`. Fonte: `e.J()`.
- As bordas externas sao render condicionais, nao dados no save.

### Dados salvos

- `dW()` salva os 30x30 de `b[][]` e `c[][]` por bit packing. Fonte: `e.dW()`.
- `ea()/eb()` carregam os blocos do save. Fonte: `e.ea()`, `e.eb()`.
- Nada indica persistencia de coordenadas negativas. Confirmado por loop fixo `for bs=0; bs<30; bs++` em `dW()`.

### Renderizacao

- A camada base e desenhada em `F()/G()/H()/I()` para cada tile/posicao convertida.
- Sprites altos, objetos, visitantes e overlays entram em camadas posteriores por `al()`, `am()`, `ai()`, `aD()`, `aE()`, `aF()`, `aL()`.
- Adaptacao Godot: separar dados logicos de dados virtuais externos; renderizar externos em um passo controlado antes/depois do terreno, sem inclui-los no save.

## 4. Entrada do parque, WELCOME, muro e bordas externas

| Aspecto | Metodo/campo | Comportamento encontrado | Recomendacao Godot |
|---|---|---|---|
| Entrada logica | `b[ab][0] = 0`, `ab=O/2` | Tile `(15,0)` e path real no JAR, mas especial por ser entrada | Manter `ENTRY_TILE=(15,0)` reservado: visualmente path, nao construivel/demolivel |
| Primeiro destino interno | `cS()`: `D=ab`, `E=1` | Visitante nasce em `(15,0)` e mira `(15,1)` | Manter `INITIAL_PATH_TILE=(15,1)` como primeiro path interno |
| Estrada externa | `I()`: `Z == ab && aa < 0` | Desenha path para y negativo na coluna da entrada | Renderizar `x=15, y=-1..-6` apenas visual |
| Offset de entrada visual | `cS()`: `H=-100`, `G=aI[h[36]+F*2]` | Visitante vem de fora sem tile negativo logico | Usar offset visual `Vector2(-100,50)` ou equivalente |
| WELCOME/portao | `aw()` chama `aK()` com `an=21` e `an=24` | WELCOME/portao e overlay quando estrada externa aparece | Desenhar overlay separado, acima do path externo |
| Pedras/cantos | `as()`, `at()`, `aK()`, `gpack1_006` | Pedras laterais em torno da abertura | Manter como decoracao externa independente |
| Bordas/muro | `J()`, `aJ()`, `h[65..70]` | Borda externa em `x=-1/O` e `y=-1/O`, exceto abertura da entrada | Implementar por recortes fixos primeiro; depois tabelas completas |

Recortes confirmados:

- Path externo/base: `gpack1_002.png`, `b.O[0]=0`, `b.P[0]=104`, regiao `38x20`. Fonte: `b.java` arrays `O/P`, `e.F()/I()`.
- Variante base 1: `gpack1_002.png`, `(38,104,38,20)`. Fonte: `b.O[1]=38`, `b.P[1]=104`.
- WELCOME/placa: `gpack1_002.png`, `b.R={90,105}`, `b.S={83,84}`, `b.T={15,18}`, `b.U={20,13}`, offsets `b.V={-19,-4}`, `b.W={-44,-33}`. Fonte: `b.java`, `aK()/aw()`.
- Pedras: `gpack1_006.png` recorte usado no port e confirmado no relatorio anterior: `(0,112,15,12)`. Fonte: `docs/JAR_FULL_ANALYSIS.md`, `assets_extracted/gpack1/gpack1_006.png`.

Incerteza:

- A exata ordem de todos os overlays do muro em cada canto depende das tabelas `h[39]`, `h[65]..h[70]` carregadas de `arr.dat`. A estrutura esta confirmada por `J()`, mas todos os indices de recorte ainda precisam de tabela dedicada se o objetivo for 1:1.

## 5. Projecao isometrica, camera, viewport e profundidade

### Formula exata do JAR

Dimensoes:

- `b.B = {40,20}`. Fonte: `b.java`.

Formula direta, reescrita semanticamente:

```text
screen_x = (tile_x + tile_y - camera_x - camera_y) * 20 + camera_screen_x
screen_y = (tile_x - tile_y - camera_x + camera_y) * 10 + camera_screen_y
```

Fonte: usos em `l()`, `m()`, `K()` e a conversao inversa em `F()/J()`. A formula atual do Godot `screen_x=(x+y)*20`, `screen_y=(x-y)*10` corresponde ao caso sem camera.

### Camera e viewport

- `r()` calcula quatro pontos/limites visiveis em `f[0..3][0..1]` a partir do centro `a[0]/a[1]`, largura `l`, altura `m` e `b.B`. Fonte: `e.r()`.
- `s()` recalcula o centro medio a partir de `f[][]`. Fonte: `e.s()`.
- `F()`/`J()` convertem posicao de varredura/tela para tile com base em `f[0][0]`, `f[0][1]` e offsets `W/X/Y`. Fonte: `e.F()`, `e.J()`.

### Varredura

- `al()` percorre a tela em linhas isometricas. Ele incrementa `X` de `b.B[1]/2` em `b.B[1]/2` e, dependendo da paridade, inicia `Y` em meio tile ou tile inteiro. Fonte: `e.al()`.
- Para cada posicao calcula `Z` e `aa`, chama `as()/at()` para entrada lateral quando `Z==ab±1 && aa==-1`, depois desenha camada de objeto se estiver dentro do mapa. Fonte: `e.al()`.
- `a(int,int,int,int)` faz varredura parecida para regioes/blocos de redraw. Fonte: `e.java`, metodo `a(int,int,int,int)`.

### Profundidade

- O JAR resolve profundidade por ordem de varredura isometrica e por desenho em pecas.
- Terreno/path sao desenhados como base em `F()/G()/H()/I()`.
- A parte alta de atracoes e objetos entra por `am()/ai()/aD()/aE()/aF()`.
- Visitantes sao desenhados por `aL()`, usando `B/C` tile e offsets `G/H` para posicionar o sprite dentro do tile. Fonte: `e.aL()`, `cU()`, `cN()`.
- Atracoes sao compostas por varias pecas porque partes precisam aparecer atras/na frente de visitantes e de outros objetos. Fonte: `aD()` linhas/cordas, `aE()` pecas estaticas, `aF()` pecas animadas.

### Diferenca atual no Godot

- `iso_map.gd` desenha tudo em `_draw()` com loops completos: terreno, externos, path, atracao placeholder, entrada, selecao/preview.
- Visitantes sao `Node2D` separados, nao entram numa varredura isometrica unificada com atracoes altas.
- Nao ha culling por viewport similar a `r()/al()`.
- Risco: implementar profundidade 1:1 de uma vez pode derrubar FPS, como ja aconteceu em tentativa anterior.

### Recomendacoes

Etapa segura minima:

- Manter `_draw()` simples, mas ordenar entidades visuais por `sort_key = tile_x - tile_y` ou por `global_position.y`, sem recomputar todas as pecas pesadas por frame.
- Nao mexer em pathfinding/save junto.

Etapa intermediaria:

- Criar lista de draw commands apenas para tiles visiveis.
- Separar camadas: terreno/path, externos, objetos baixos, visitantes, pecas altas.
- Cachear terreno/path estatico em buffer ou TileMap/mesh leve.

Etapa fiel completa:

- Implementar varredura por diagonal inspirada em `al()`.
- Registrar pecas de atracoes com anchors, offsets e prioridade local, usando chunks `arr.dat`.
- Integrar visitantes na mesma ordenacao, incluindo offsets `G/H` e frames `J`.

## 6. Path / caminhos

### Armazenamento

- Path e `b[x][y] == 0`. Fonte: `F()`, `g()`, `ch()`.
- `c[x][y]` guarda metadata do path. `F()` usa `c[x][y] / 4` para escolher a regiao base do atlas. Fonte: `e.F()`.
- Bits baixos `c % 4`, `c & 1`, `c & 2` controlam conexoes/passagem logica ou subtipos. Fonte: `bX()`, `ch()`, `bK()`; significado exato: **inferencia**.

### Desenho

- Base: `gpack1_002.png`, regioes `(0,104,38,20)` e `(38,104,38,20)`. Fonte: `b.O`, `b.P`, `F()`.
- Bordas/overlays: `J()/aJ()` e relatorio anterior confirmam recortes como `(76,111,23,13)` e `(98,111,23,13)` para bordas claras do path.
- Conexoes internas adicionais foram identificadas em recortes `(0,0,18,17)` e `(0,17,17,11)` do mesmo atlas. Fonte: `docs/JAR_FULL_ANALYSIS.md`.

### Conexao com entrada

- Entrada `(ab,0)` e `b=0`. Fonte: `g()`.
- Estrada externa `y<0` e so visual. Fonte: `I()`.
- O path interno `(ab,1)` deve considerar `(ab,0)` conectado visual e logicamente para visitantes.

### Construcao

- `cc()` despacha por categoria; path e `aX==3`, chama `ch()`. Fonte: `e.cc()`.
- `ch()` seta `b[a[0]][a[1]]=0` e incrementa `c` por `aW + av`, depois chama `bK()` para atualizar conexoes. Fonte: `e.ch()`.
- Custo e mostrado/calculado por `cr()`, `aX==3`, usando `aI[h[133]+aW]`. Fonte: `e.cr()`.

### Demolicao

- `bX()` remove path. Se `c%4 != 0`, reduz metadado para variante base; senao transforma o tile em grama aleatoria `1..3`, zera `c`, chama `bK()` e marca redraw. Fonte: `e.bX()`.
- Warntext contem "Nao pode remover esta estrada", indicando protecao para estrada/entrada especial. Fonte: `warntext.da4`.

### Falta no Godot

- O Godot atual tem `path_variant` e `path_mask` simples, mas nao replica `bK()/bP()/Y()/Z()` nem a logica completa de conexoes.
- Desenho de bordas existe, mas ainda e simplificado.
- Construcao/demolicao basica existe; falta diferenciar tipos de caminho originais, custo por path e conforto.

## 7. Visitantes

### Estrutura principal

| Campo/array | Funcao encontrada | Fonte | Certeza |
|---|---|---|---|
| `A[]` | variacao visual/tipo de entidade | `cS()` seta `random%8`; staff usa tipos altos | alta |
| `B[]`, `C[]` | tile atual/logico | `cS()`, `cU()`, `cR()` | alta |
| `D[]`, `E[]` | proximo tile/destino imediato | `cS()`, `dn()/do()` | alta |
| `F[]` | direcao visual/logica | `cS()`, `dn()/do()`, `cR()` | alta |
| `G[]`, `H[]` | offset visual dentro/fora do tile | `cS()` usa `H=-100`; `cN()` altera passageiros | alta |
| `I[]` | velocidade | `cS()` seta `1..4` | media |
| `J[]` | frame de animacao | `cS()` seta `1`; `aL()` usa frame | alta |
| `L[]` | dinheiro individual do visitante | `cS()` seta `60 +/- 20`; `cQ()` subtrai | alta |
| `P/Q/R/S/T/U/V` | satisfacao/necessidades/timers | `cS()`, `cV()`, `cR()` | media |
| `W[]` | estado do visitante | `cU()` despacha por valores; `dt()`, `cQ()`, `dm()` setam estados | alta |

### Spawn

- `cS()` calcula chance `aU = 5 + ...`, limita para `3..80`, entao faz `(random % 100) < aU`. Fonte: `e.cS()`.
- Se houver slot livre `B[aO] < 0`, cria visitante:
  - `A=random%8`
  - `B=ab`, `C=0`
  - `D=ab`, `E=1`
  - `F=3`
  - `G=aI[h[36]+F*2]`
  - `H=-100`
  - `I=random%4+1`
  - `J=1`
  - `W=-1`
  - `L=60 + random%40 - 20`
  - necessidades/timers inicializados em `P/Q/R/S/T/U/V`
- Fonte: `e.cS()`.

### Entrada e saida visual

- O visitante nasce logicamente em `(ab,0)`, mas visualmente vem de fora por `H=-100`. Fonte: `cS()`.
- O estado de saida e `W=18`; metodos como `dz()` podem mandar visitante sair. Fonte: `dz()`, `dm()`.
- `dm()` remove visitante quando ele termina a saida externa. Fonte: `e.dm()` e relatorio anterior.

### Movimento

- `cU()` percorre ate 222 entidades e despacha por `W`. Fonte: `e.cU()`.
- O visitante nao guarda rota completa; guarda tile atual (`B/C`), proximo (`D/E`), direcao (`F`) e offsets (`G/H`), recalculando decisoes localmente. Fonte: `dr()`, `dn()`, `do()`, `ds()`.
- Adaptacao: o Godot atual usa BFS por tile. Isso e funcional, mas mais global que o JAR. Para fidelidade maior, recalcular proximo passo por tile, nao uma rota longa persistente.

### Uso de atracao

- Visitante entra em fila com `W=11` por `dt()`.
- No embarque, `cQ()` cobra, move para `e[ride][seat]`, seta `W=13`.
- `cN()` atualiza ciclo/frames da atracao e offsets/direcao dos passageiros.
- `cR()` libera passageiro, seta `W=-1` e aplica satisfacao `P += aA[Z] - b.ap[queuePenalty]`.

### Tabela de estados `W`

| Estado W | Significado | Metodo | Quando entra | O que acontece | Quando sai | Adaptacao Godot |
|---|---|---|---|---|---|---|
| `-1` | livre/andando | `cS()`, `cR()`, `du()` | spawn, fim de atracao, desistencias | Decide caminho/objetivo por `dr()/dz()` | alvo/servico/fila/saida | Estado default de locomocao |
| `7` | entrando/interagindo com objeto | `cU()/cW()` | ao chegar em service/ride tile | aproximacao/uso curto | `cW()`/outros | futuro |
| `9` | aproximando da fila/embarque | `cP()` seta fila restante para `9` | quando primeiro embarca e fila avanca | reanda ate posicao nova | vira `11` ou livre | simplificar com reposicionamento de fila |
| `10` | retorno para path/ajuste | `cU()` condicional | apos sair de objeto/footprint | ajusta offsets | volta livre | futuro |
| `11` | na fila | `dt()` | fila aceita visitante | fica parado em posicao calculada por `dv()/dw()` | `cP()/cQ()` embarca | ja existe simplificado |
| `12` | usando servico/objeto | `cU()` observa `W==12` | servicos como banco/bar/fonte | timer ate `c==100`, chama `dj()` | livre | inexistente |
| `13` | usando atracao | `cQ()` | embarque/cobranca | `cN()` atualiza ciclo e passageiro | `cR()` | ja existe simplificado |
| `14` | ride especial/circuito | `cL()` trata `Z==14` de modo especial | atracao especifica | ciclo especial | incerto | futuro |
| `15/16` | briga/incidente | `warntext`, `cU()` | eventos de ordem/saude | visitante imobilizado/efeito negativo | guarda/tempo | futuro |
| `17` | acao de funcionario/manutencao | `dl()` | funcionario indo reparar | muda ride `ai/ag` | fim reparo | futuro |
| `18` | saindo do parque | `dz()`, `ds()`, `dm()` | dinheiro/necessidade/decisao | caminha para entrada e sai visualmente | removido por `cT()/dm()` | ja existe visualmente simplificado |

### Sprites e animacao

- `A=random%8` usa `gpack0_000.png` ate `gpack0_007.png`. Fonte: `cS()`, `aL()`, `assets_extracted/gpack0`.
- Sequencia de caminhada confirmada em analises anteriores: `[0,1,0,2]`.
- Direcoes logicas usadas no port:
  - `F=0`: delta `(0,-1)`
  - `F=1`: delta `(+1,0)`
  - `F=2`: delta `(-1,0)`
  - `F=3`: delta `(0,+1)`
- O `gpack0_006` tem ordem de linha diferente para F0/F1; o Godot atual ja tem tabela propria em `visitor_system.gd`.

### O que falta no Godot

- Estados `W` explicitos como enum e nao varios metadados soltos.
- Necessidades completas `P/Q/R/S/T/U/V`.
- Emocoes/baloes de pensamento.
- Decisao local do JAR sem BFS completo.
- Interacao com servicos e funcionarios.
- Passageiro preso no assento/offsets internos da atracao via chunks.

## 8. Atracoes

### Catalogo e dados

- `u()` le 24 registros de atracoes de `arrsi.dat`. Para cada `R` le campos `am, as, at, an, ap, ao, aq, au, ar, av, aw, ax, ay, az, aA, aB, aC` e depois bloco de chunks em `o[R]`. Fonte: `e.u()`.
- `Z[slot]` guarda o tipo da atracao construida. Fonte: `cd()`.
- `aa[slot]` guarda orientacao. Fonte: `cd()`.
- `l[0/1][slot]` origem da atracao. Fonte: `cd()`.
- `m[0/1][slot]` ponto de embarque/entrada. Fonte: `ce()` quando footprint code `10`.
- `n[0/1][slot]` ponto de saida. Fonte: `ce()` quando footprint code `7` ou `8`.
- `ac[slot]` passageiros ativos, `ad[slot]` fila, `e[slot][seat]` passageiros embarcados. Fonte: `cP()/cQ()/cR()`.
- `ah[slot]` condicao/durabilidade, `ai[slot]` estado de manutencao/quebra, `ag[slot]` estado de ciclo. Fonte: `cL()/cO()/cN()`.

### Primeira atracao: Balanco

Confirmado:

| Dado | Valor | Fonte |
|---|---|---|
| Nome | `balanc[o` em portugues extraido, Balanco no remake | `text.da4`, indice 48 aproximado no bloco de atracoes |
| Tipo `aW/Z` | `6` | `u()` tabela; relatorio anterior |
| Custo construcao | `30` | `az[6]=3`, `cr()` multiplica por 10 |
| Footprint | `3x3` | chunk 37 de `arrsi.dat/arr.dat`, `ce()` |
| Duracao | `am[6]=61` ticks | `u()`, tabela do relatorio |
| Capacidade | `au[6]=2` | `u()`, `cP()/cQ()` |
| Satisfacao | `aA[6]=5` | `u()`, `cR()` |
| Ingresso/preco uso | `al[6]=1` | calculado por `aA[6]/b.au[0]`, usado como valor pendente/cobranca |

Pecas do Balanco ja identificadas:

| Peca | Arquivo | Recorte | Offset | Ordem | Animacao | Certeza |
|---|---|---|---|---|---|---|
| Poste A | `gpack1_001.png` | `(66,0,8,25)` | `+1,-23` em local `(1,1)` | estatica | nao | alta |
| Poste B | `gpack1_001.png` | `(66,0,8,25)` | `+5,-47` em local `(1,1)` | estatica | nao | alta |
| Poste C | `gpack1_001.png` | `(67,19,7,25)` | `+10,-41` em local `(1,1)` | estatica | nao | alta |
| Poste D | `gpack1_001.png` | `(67,19,7,25)` | `+14,-17` em local `(1,1)` | estatica | nao | alta |
| Postes duplicados | `gpack1_001.png` | mesmos recortes | offsets em local `(1,2)` | estatica | nao | alta |
| Travessa | `gpack1_000.png` | `(3,37,22,13)` | `-11,-45` em local `(1,2)` | estatica | nao | alta |
| Assento | `gpack1_001.png` | `(4,0,16,12)` base | offsets por frame | sim | alta |
| Cordas | chunks de linha | `aD()` | chunk 20 | sim/linha | media |

### Tabela resumida das 24 atracoes

Valores confirmados no relatorio anterior por `arrsi.dat`, `text.da4`, `u()` e arrays de catalogo. Preco de construcao = `az * 10`.

| aW | Nome PT extraido | Custo | Footprint | Duracao `am` | Capacidade `au` | Satisfacao `aA` | Observacao |
|---|---:|---:|---|---:|---:|---:|---|
| 0 | roda gigante | 400 | 3x3 | 97 | 4 | 25 | atracao grande |
| 1 | torre | 180 | 3x3 | 61 | 2 | 20 | vertical |
| 2 | torre grande | 600 | 3x3 | 96 | 4 | 35 | vertical |
| 3 | bungee jump grande | 450 | 3x4 | 92 | 1 | 50 | alta satisfacao |
| 4 | bungee jump | 150 | 3x3 | 81 | 1 | 25 | alta |
| 5 | caverna do terror | 100 | 3x3 | 61 | 3 | 10 | indoor |
| 6 | balanc[o | 30 | 3x3 | 61 | 2 | 5 | primeira atracao |
| 7 | Salto de agua | 150 | 4x3 | 66 | 1 | 25 | agua |
| 8 | Salto tramp. | 120 | 5x3 | 56 | 1 | 20 | trampolim |
| 9 | Tobogan aquat. | 200 | 5x3 | 70 | 1 | 30 | agua |
| 10 | Tobogan | 120 | 5x3 | 69 | 1 | 20 | slide |
| 11 | trampolin | 40 | 3x3 | 81 | 1 | 15 | simples |
| 12 | gira-gira | 100 | 3x3 | 85 | 3 | 10 | rotativa |
| 13 | gira-gira grande | 300 | 3x3 | 85 | 6 | 15 | rotativa |
| 14 | Gangorra | 60 | 4x3 | 65 | 2 | 10 | tratamento especial em `cL()` |
| 15 | Salto Grande | 200 | 5x3 | 62 | 1 | 30 | salto |
| 16 | banho de agua | 150 | 5x4 | 55 | 1 | 25 | agua |
| 17 | Campo de tiro | 60 | 5x4 | 59 | 1 | 15 | jogo |
| 18 | catapulta | 450 | 3x4 | 84 | 1 | 50 | alta |
| 19 | Ursa Maior | 900 | 5x8 | 105 | 4 | 50 | montanha russa grande |
| 20 | mont. russa media | 750 | 4x6 | 55 | 4 | 40 | track/ride |
| 21 | montanha russa | 600 | 4x5 | 53 | 4 | 35 | track/ride |
| 22 | Circuito de agua | 70 | 2x2 | 0 | 0 | 10 | especial de caminho/circuito |
| 23 | cafeteria | 150 | 2x3 | 11 | 12 | 0 | hibrido servico/atracao |

### Construir/ocupar mapa

- `cc()` chama `cd()` para registrar slot e `ce()` para escrever footprint no mapa.
- `ce()` usa chunk 37 do bloco `o[aW]`. Codigos do footprint:
  - `10`: ponto `m` de embarque/entrada.
  - `7/8`: ponto `n` de saida.
  - `5/6`: conexoes/tiles especiais de acesso.
  - `1`: vazio/sem escrita.
- Fonte: `e.ce()`.

### Render/animacao

- `aE()` desenha pecas estaticas.
- `aF()` desenha pecas animadas.
- `aD()` desenha linhas/cordas.
- `cN()` atualiza `ab[slot]` frame de ciclo e tambem `G/H/F/J` dos passageiros se chunks indicarem offsets de passageiro. Fonte: `e.cN()`.

### Adaptacao em etapas

1. Dados do Balanco completos e footprint 3x3.
2. Slot real de atracao com origem, orientacao, entrada `m`, saida `n`, fila `f/ad`, ocupantes `e/ac`.
3. Visual estatico por pecas.
4. Animacao do assento/cordas e posicao de passageiros.
5. Outras atracoes por catalogo.

## 9. Fila de atracoes

| Item | Comportamento original | Fonte | Adaptacao |
|---|---|---|---|
| Tamanho maximo | 10 visitantes por fila | `dt()` checa `ad[slot] >= 10` | manter max 10 |
| Estrutura da fila | `f[ride_slot][queue_index]` | `dt()`, `cP()` | array por atracao |
| Quantidade na fila | `ad[ride_slot]` | `dt()`, `cP()` | contador por atracao |
| Estado em fila | `W=11` | `dt()` | enum/meta `QUEUED` |
| Posicao visual | `aP = ad * 6`; `dv()` ou `dw()` conforme `aa[slot]` | `dt()`, `dv()`, `dw()` | espacamento 6 px; depois orientacao real |
| Embarque | `cP()` chama `cQ()` e reposiciona fila restante | `cP()` | embarcar enquanto houver vaga |
| Pagamento | `cQ()` soma `b[visitor]` ao parque e subtrai de `L[]` | `cQ()` | cobrar no embarque |
| Passageiros ativos | `e[slot][seat]`, `ac[slot]` | `cQ()`, `cR()` | ocupantes por atracao |
| Capacidade | `au[Z]` | `cP()/cQ()` | ler de catalogo |
| Uso | `W=13` | `cQ()` | estado `USING_ATTRACTION` |
| Saida | `cR()` move para `n[slot]`, `W=-1`, aplica satisfacao | `cR()` | soltar no ponto de saida futuro |

Incerteza:

- A orientacao completa da fila depende de `aa[slot]`, `ae[slot]`, `dv()/dw()` e codigos de footprint. A primeira versao pode manter uma fila visual simples, mas a versao fiel deve usar estes metodos como referencia.

## 10. Servicos, necessidades e emocoes

### Servicos e decoracoes

- `v()` le 27 registros de objetos/servicos de `arrsi.dat`, preenchendo arrays como `aH`, `aF`, `aG` e chunks de `p[]`. Fonte: `e.v()`.
- Textos em `text.da4` indicam objetos/servicos: arvore, placa, bilheteria, bar, sorvete, fonte, Banheiro, baloes, Primeiros socorros, dinomotor, palmeira, arbustos, flores.
- `cf()/cg()` constroem servicos/decoracoes; valores negativos em `b[][]` representam estes objetos.
- `H()` desenha objeto negativo sobre base path ou grama dependendo de `aI[h[89] + -1 - b]`. Fonte: `e.H()`.

### Necessidades

Campos provaveis:

| Campo | Significado provavel | Fonte | Certeza |
|---|---|---|---|
| `P[]` | felicidade/satisfacao geral | `cS()` inicializa 80..100; `cR()` aumenta por atracao | alta para satisfacao, media para nome |
| `Q[]`, `R[]` | fome/sede ou timers de necessidade | `cS()`, `cV()`, `da()/dj()` | media/baixa |
| `S[]`, `T[]` | fadiga/descanso ou paciencia | `cS()`, `cV()` | media/baixa |
| `U[]`, `V[]` | saude/ordem ou variaveis auxiliares | `cS()`, `cV()` | baixa/media |

Textos de ajuda confirmam necessidades:

- Fadiga, fome, precos, conforto, bancos, comida, banheiros, saude.
- Baloes sobre a cabeca indicam necessidades.
- Fonte: `helptext.da4`.

### Decisao

- `da()`, `dj()`, `dp()`, `cV()`, `cW()` sao pontos principais de servico/necessidade.
- `dz()` pode decidir saida do parque, incluindo dinheiro baixo (`L[]`) e estados de necessidade. Fonte: `e.dz()` e relatorio anterior.

Adaptacao por etapas:

1. Adicionar satisfacao/felicidade individual ja iniciada.
2. Adicionar fome/sede/fadiga como tres barras simples.
3. Criar servicos: bar/sorvete/fonte/banheiro/banco/primeiros socorros.
4. Baloes de pensamento com sprites gpack/UI.
5. Decisao completa de procurar servico versus atracao versus sair.

## 11. Funcionarios

Textos confirmados em `text.da4`:

- guarda
- Mantimentos
- cozinheiro
- vendedor
- Medico
- Montador de dinossauro

Funcoes indicadas pelos textos:

| Funcionario | Texto de funcao | Sistema dependente |
|---|---|---|
| Guarda | mantem a ordem | brigas/incidentes |
| Mantimentos | repara atracoes | condicao/quebra |
| Cozinheiro | cozinha na cafeteria | cafeteria/servico |
| Vendedor | vende artigos | bar/sorvete/baloes |
| Medico | cura visitantes | saude/primeiros socorros |
| Montador de dinossauro | monta dinossauros | dinomotor/dinossauros |

Codigo:

- Categoria de empregados e `aX==2`; custo vem de `aI[h[131]+C]`. Fonte: `cr()`.
- `cc()` com `aX==2` incrementa contadores e chama `cj()`. Fonte: `cc()`, `cj()`.
- Staff compartilha arrays de entidades com visitantes, provavelmente indices 200..221. Fonte: `cL()` procura `aP=200..222` quando `A[aP] == 9` para manutencao.
- `dl()` verifica manutencao e manda funcionario reparar atracao (`ai[slot]`, `ag[slot]`). Fonte: `e.dl()` e `cL()`.
- Estados como `W=17` parecem ligados a acao de funcionario. Fonte: `cU()`/relatorio anterior.

Prioridade recomendada:

1. Manutencao simples primeiro, porque `ah[]` condicao de atracao ja existe no JAR.
2. Vendedor/cozinheiro para servicos que exigem funcionario.
3. Guarda/medico quando brigas/saude existirem.
4. Montador/dinomotor por ultimo.

## 12. Economia

### Dinheiro

- Dinheiro do parque: campo `k`. Fonte: `g()`, `cQ()`, `dW()`.
- Inicial do modo livre confirmado como `2000` no relatorio anterior. Fonte: `docs/JAR_FULL_ANALYSIS.md`, `e.g()`.
- Receita de atracao: `cQ()` faz `k += b[visitor]`, `d += b[visitor]`, `L[visitor] -= b[visitor]`. Fonte: `e.cQ()`.
- Dinheiro individual do visitante: `L[] = 60 + random%40 - 20`, portanto 40..79/80 conforme modulo. Fonte: `e.cS()`.

### Custos

- Atracao: `cr()` usa `az[aW] * 10`. Fonte: `e.cr()`.
- Servico/decoracao: `aI[h[58]+aW]`. Fonte: `e.cr()`.
- Funcionario: `aI[h[131]+C]`. Fonte: `e.cr()`.
- Path: `aI[h[133]+aW]`. Fonte: `e.cr()`.
- Construcao/demolicao efetiva: `ci()` subtrai `i` ou `i/2` dependendo de modo `j` (compra/venda). Fonte: `e.ci()`.

### Precos

- Ingresso por atracao vem de tabela `al[Z]` ou valor derivado de satisfacao/categoria. Para Balanco, confirmado `al[6]=1`. Fonte: `cQ()`, `u()`, relatorio anterior.
- Help text indica que precos altos reduzem felicidade. Fonte: `helptext.da4`.

### Salarios/despesas

- Textos indicam empregados cobram salario ao serem contratados e em cada lua nova. Fonte: `helptext.da4`.
- Warntext tem "Salario pago". Fonte: `warntext.da4`.
- Implementacao detalhada de ciclo mensal/salario fica em `n()`/economia/estatisticas, ainda nao mapeada por completo neste documento.

### Derrota financeira

- `n()` aciona tela/estado de derrota financeira quando dinheiro fica muito baixo; relatorio anterior identifica limite em torno de `k < -50` e aviso de 3 meses. Fonte: `e.n()`, `warntext.da4`.

Adaptacao Godot:

- Manter `Economy` simples, mas mover custos/precos para catalogo e balance.
- Depois adicionar historico mensal, salarios, derrota por divida e graficos.

## 13. Construcao e demolicao

### Selecionar item

- `aX` = categoria de construcao/menu.
- `aW` = item dentro da categoria.
- `B/C` = footprint calculado.
- `at` = orientacao.
- Fonte: `cp()/cq()/cr()/ct()/cs()/cc()` no `e.java`.

Categorias confirmadas:

| `aX` | Categoria | Confirmacao |
|---|---|---|
| 0 | Atracoes | `cc()` chama `cd()/ce()` |
| 1 | Servicos/decoracoes | `cc()` chama `cf()/cg()` |
| 2 | Empregados | `cc()` chama `cj()` |
| 3 | Paths/caminhos | `cc()` chama `ch()` |

### Footprint e preview

- Atracoes usam `ct()`:
  - `B = o[aW][g[aW][0]]`
  - `C = o[aW][g[aW][0]+1]`
  - calcula dimensoes de preview em pixels.
- Servicos usam `cs()`; dinomotor/objeto especial pode ser `2x2`.
- Fonte: `ct()`, `cs()`.

### Confirmacao

- `cc()` e o ponto de confirmacao de construcao. Ele despacha por categoria e chama `ci()` no final para custo/feedback. Fonte: `e.cc()`.
- Atracoes registram slot em `cd()` e escrevem mapa em `ce()`.
- Paths escrevem `b=0` em `ch()`.
- Servicos/decoracoes escrevem negativos em `cf()/cg()`.
- Empregados sao criados em `cj()`.

### Demolicao/venda

- `bX()` e o ponto principal de demolicao:
  - atracao/footprint: `ca()` ou `bY()`
  - path: restaura grama `1..3` ou limpa subvariant
  - objeto negativo: `bZ()`
- Fonte: `e.bX()`.

### Bloqueios importantes

- Entrada `(ab,0)` deve ser protegida. Evidencia: tile e path especial (`b[ab][0]=0`) e warntext "Nao pode remover esta estrada".
- Atracoes em uso nao podem ser removidas: warntext "Ainda ha pessoas usando este objeto"; codigo de demolicao tambem verifica usuarios em estruturas de slot. Fonte: `warntext.da4`, `ca()/bY()`.

Adaptacao Godot:

- Formalizar um `BuildSystem` com validacao por footprint e tipos.
- Separar demolicao de path, atracao e servico.
- Guardar origem/orientacao/entrada/saida/slot no building, nao apenas lista de tiles.

## 14. Menus e UI

### Estados de tela

| Campo | Papel | Fonte |
|---|---|---|
| `b` | estado/tela principal | `run()`, `o()` |
| `R` | subestado/painel dentro de `b==3` | `b(int)`, `L()` |
| `n` | acao de input mapeada | `keyPressed()`, `aS()` |
| `aX/aW` | categoria/item de construcao | `cr()/cc()` |
| `B/C/at` | footprint/orientacao | `ct()/cs()` |

Estados principais:

- `b==0`: parque rodando.
- `b==1`: menu/overlay via `S()`.
- `b==2`: construcao/preview via `ak()`.
- `b==3`: paineis/dialogos via `L()` e `R`.
- `b==4`: minimapa/tela especial via `T()`.
- `b==5`: ajuda/tutorial via `E()` e `Q()`.

Fonte: `o()` e relatorio anterior.

### Input J2ME

- `keyPressed(int)` mapeia softkeys/direcoes/fire para `n`.
- Fire/5 vira `n=5`.
- Direcoes viram `n=1..4`.
- Softkey esquerda vira `n=-6`; direita `n=-7`.
- Fonte: `e.keyPressed()`, `keyReleased()`.

### Textos

- `text.da4`: menu principal, dinheiro, felicidade, visitantes, atracoes, servicos, empregados, nomes de atracoes/servicos/staff.
- `warntext.da4`: avisos de limite, sem estrada, nao pode remover estrada, salarios, atracao quebrada, tutorial.
- `helptext.da4`: ajuda extensa de controles, visitantes, atracoes, empregados, graficos, campanha.

Adaptacao touch:

- Nao copiar softkeys literalmente.
- Manter funcoes equivalentes:
  - abrir build/menu
  - confirmar item/compra
  - cancelar/voltar
  - selecionar objeto
  - pausar/ajuda/minimapa
- Para touch real, a selecao deve vir das areas reais desenhadas: tiles, construcoes, visitantes, paineis.

## 15. Save/load

### RecordStores

- `pssav`: progresso/opcoes globais. Fonte: `dT()/dU()`.
- `pCuSav`: save do modo livre. Fonte: `dV()/ea()`.
- `pCaSav`: save de campanha. Fonte: `dV()/ea()`.

### Blocos

| Metodo | Conteudo salvo/carregado | Fonte |
|---|---|---|
| `dT()` | progresso/opcoes globais, flags/unlocks | `RecordStore("pssav")` |
| `dU()` | carrega progresso/opcoes globais | `RecordStore("pssav")` |
| `dV()` | save principal, chama `dW/dX/dY/dZ` | `e.dV()` |
| `dW()` | estado global, dinheiro, estatisticas, mapa `b/c` | `e.dW()` |
| `dX()` | entidades/visitantes/funcionarios, `B/C/D/E/G/H/A/F/I/W/L/...` | `e.dX()` |
| `dY()` | atracoes/objetos/slots, `Z/aa/ab/ad/ae/af/ag/ah/ai/aj/l/m/n/ak` | `e.dY()` |
| `dZ()` | unlocks, precos, medias/graficos | `e.dZ()` |
| `ea()`..`ef()` | leitura dos blocos equivalentes | `e.ea()` etc |

### O que precisa existir no save Godot fiel

- Versao de save.
- Modo livre/campanha, nivel, dificuldade.
- Mapa `b/c` ou equivalente forte: terrain, path metadata, owners, footprint.
- Dinheiro, historico financeiro, estatisticas mensais.
- Atracoes por slot: tipo `Z`, origem `l`, orientacao `aa`, entrada `m`, saida `n`, fila `ad/f`, passageiros `e/ac`, estado `ag`, timer `af/ab`, condicao `ah`, manutencao `ai`.
- Servicos/objetos e empregados.
- Visitantes ativos se a meta for 1:1; para versao simples pode ficar fora.
- Unlocks/progresso/campanha.

Godot atual salva JSON simples com dinheiro, `tiles`, `terrain_codes`, `buildings`, `total_earned`, `total_spent`. Isso e suficiente para prototipo, mas baixa fidelidade ao JAR.

## 16. Campanha e progressao

### Modos

- `K==0`: modo livre, `O=30`, todos os itens marcados como disponiveis em `h()`. Fonte: `e.h()`.
- `K==1`: campanha, `O = aI[h[134]+L]` e unlocks dependem de nivel/progresso. Fonte: `e.h()`.

### Tamanhos de mapa

- Confirmado no relatorio anterior: `[12,15,20,25,25,30]` por nivel de campanha. Fonte: `aI[h[134]+L]`.

### Objetivos/vitoria/derrota

- `q()` prepara tela de objetivo/progresso.
- `n()` verifica condicoes de progresso, vitoria, derrota financeira e desbloqueios/tutorial.
- `dT()/dU()` persistem progresso global.
- Textos de `helptext.da4` indicam competicao: vencer rivais por tres anos consecutivos.

Incertezas:

- A formula exata de pontuacao/competicao depende de arrays de `d.java`, `arr.dat` e ramos longos de `n()`. Nao e necessario para v0.x do remake, mas sera necessario para campanha fiel.

Adaptacao futura:

1. Modo livre estavel primeiro.
2. Sistema de unlocks simples.
3. Objetivos por nivel.
4. Competicao anual.
5. Campanha completa.

## 17. Assets, sprites e audio

### Gpacks

| Pacote | Uso confirmado/provavel | Evidencia |
|---|---|---|
| `gpack0` | visitantes/personagens/staff | `A=random%8`, `aL()`, PNGs `gpack0_000..007` |
| `gpack1` | paths, atracoes, entrada/WELCOME, objetos grandes | `F()/I()/J()/aE()/aF()/aw()` |
| `gpack2` | terreno/grama e possiveis elementos base/UI | `G()` usa `this.c[0]`, `gpack2_000` |
| `gpack3` | UI, fontes, paineis, icones | metodos de UI e relatorio anterior |

### Identificacoes ja seguras

- Terreno: `assets_extracted/gpack2/gpack2_000.png`, regioes de 38x20 por linha.
- Path: `assets_extracted/gpack1/gpack1_002.png`, base `(0,104,38,20)` e `(38,104,38,20)`.
- Path bordas: `gpack1_002.png`, regioes `(76,111,23,13)`, `(98,111,23,13)`.
- Entrada/pedras: `gpack1_006.png`, recorte `(0,112,15,12)` conforme mapeamento anterior.
- WELCOME/placa: `gpack1_002.png`, arrays `b.R/S/T/U/V/W`.
- Visitantes: `gpack0_000.png` ate `gpack0_007.png`, cada spritesheet com recortes proprios.
- Balanco: `gpack1_000.png` e `gpack1_001.png` por pecas, chunks em `arrsi.dat/arr.dat`.

### Audio

- `a.java` carrega `Player` via `Manager.createPlayer(getResourceAsStream("/sound/" + nome), mime)`.
- `e.a()` cria `new a("entry.mid", "audio/midi")`.
- `a.playerUpdate()` reinicia ao fim (`endOfMedia`) e respeita volume/mudo. Fonte: `a.java`.
- Textos incluem "sem sons" e "com sons". Fonte: `text.da4`.

Organizacao recomendada no Godot:

- `assets/original_sprites/terrain/`
- `assets/original_sprites/path/`
- `assets/original_sprites/entrance/`
- `assets/original_sprites/visitors/`
- `assets/original_sprites/attractions/balanco/`
- `assets/original_sprites/ui/`
- `assets/audio/entry.mid` ou conversao para OGG se Godot/Android exigir.

## 18. Comparacao com o Godot atual

| Area | JAR original | Godot atual | Fidelidade | Riscos tecnicos/FPS | Arquivos Godot | O que precisa mudar | O que nao mexer ainda |
|---|---|---|---|---|---|---|---|
| Mapa/chao | `b/c` 30x30, terreno 1..3, negativos naturais | `terrain_codes`, `tiles`, textura grama | media | baixo | `game_state.gd`, `iso_map.gd` | formalizar `b/c` equivalente e decoracoes | nao adicionar todos decorativos junto |
| Entrada/externo | `(15,0)` path especial, estrada `y<0`, WELCOME/muro | entrada reservada, estrada ate `-6`, overlays simples | media | baixo/medio | `iso_map.gd`, `game_state.gd` | ajustar recortes/tabelas completas | nao transformar y negativo em tile jogavel |
| Path | `b=0`, `c/4`, `c%4`, `bK()` conexoes | `path_variant`, `path_mask`, bordas simples | media | baixo | `game_state.gd`, `iso_map.gd`, `park_controller.gd` | implementar conexoes reais por mascara | nao mexer pathfinding pesado junto |
| Visitantes | arrays A-J/L/P-V/W, decisao local | `visitor_system.gd` com metas, BFS, dinheiro, fila, satisfacao | media | medio | `visitor_system.gd`, `Visitor.tscn` | criar estado/struct claro, necessidades | nao salvar ativos ainda |
| Atracoes | 24 tipos, slots, footprint chunks, render por pecas | so `basic_attraction` Balanco dados, visual placeholder | baixa/media | medio/alto se render por pecas bruto | `game_state.gd`, `iso_map.gd`, `buildings.json` | slot real e visual Balanco por etapas | nao importar todas atracoes |
| Fila | `f/ad/e/ac`, posicao por `dv/dw`, capacidade | fila simples, capacidade 2, ticket/duracao do catalogo | media | baixo | `visitor_system.gd` | orientacao/entrada/saida reais | nao implementar fila por todas atracoes ainda |
| Economia | dinheiro, visitante L, salarios, historico, derrota | dinheiro, earned/spent, ticket | media | baixo | `economy.gd`, `balance.json`, `hud.gd` | salarios, mensal, derrota, precos ajustaveis | nao fazer graficos completos agora |
| Construcao | categorias `aX`, footprint/orientacao, demolicao | build path/Balanco, preview touch | media | baixo/medio | `park_controller.gd`, `GameState`, `BuildMenu` | orientacao, categorias completas, servicos | nao refatorar UI inteira junto |
| Save/load | RecordStore completo por blocos | JSON simples | baixa | medio para migracoes | `save_system.gd`, `game_state.gd` | versionar save e slots completos | nao salvar visitantes ativos antes de estabilizar |
| UI | softkeys, estados `b/R`, menus, ajuda, stats | HUD simples, BuildMenu, Stats | baixa/media | baixo | `hud.gd`, cenas UI | paineis fieis e localizacao | nao copiar layout J2ME 1:1 se for ruim para touch |
| Render/profundidade | `r()/al()` varredura, pecas altas, visitantes integrados | `_draw()` simples e Node2D visitantes | baixa | alto | `iso_map.gd`, `visitor_system.gd` | ordenar por profundidade com cache | nao redesenhar tudo por frame sem culling |
| Servicos | 27 objetos, necessidades, staff requerido | inexistente | inexistente | medio | futuro | implementar apos visitantes/atracoes | nao agora |
| Funcionarios | 6 tipos, manutencao, ordem, venda, medico | inexistente | inexistente | medio | futuro | manutencao primeiro | nao agora |
| Campanha | livre/campanha, objetivos, competicao | inexistente | inexistente | baixo/medio | futuro | depois do modo livre | nao agora |
| Assets | gpacks por sistema, chunks | alguns assets importados | media parcial | medio | `assets/original_sprites`, `iso_map.gd` | mapear atlas restante | nao trocar tudo sem plano |
| Audio | MIDI `entry.mid`, mute | inexistente | inexistente | baixo | futuro | musica opcional | nao prioridade |

## 19. Plano de implementacao por porcoes inteiras

### 1. Chao/mapa/base externa

- Objetivo: reproduzir a base visual/logica do parque original sem visitantes/atracoes novas.
- Inclui: area 30x30, `b/c` equivalente, grama 1..3, decoracoes naturais opcionais, estrada externa, muro, entrada visual, WELCOME.
- Nao mexer: visitantes, fila, atracoes, economia avancada.
- Dependencias: `gpack2_000`, `gpack1_002`, `gpack1_006`, tabelas de borda.
- Arquivos provaveis: `game_state.gd`, `iso_map.gd`, `data/terrain.json` se criado.
- Risco FPS: medio se desenhar externos/tiles sem cache; mitigar com cache ou culling simples.
- Risco save: medio se mudar formato de `tiles`; criar migracao.
- Testes: mapa abre, entrada 15,0 visivel, estrada externa longa, FPS estavel, save antigo carrega.
- Prompt recomendado: "Implemente apenas a porcao Chao/mapa/base externa conforme docs/JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md, sem visitantes/atracoes."

### 2. Path/caminhos

- Objetivo: tornar path fiel ao `b=0` e `c[][]` do JAR.
- Inclui: variantes `c/4`, mask `c%4`, conexoes, entrada especial, construcao, demolicao para grama 1..3.
- Nao mexer: visitantes alem de manter pathfinding funcionando.
- Dependencias: porcao 1.
- Arquivos: `game_state.gd`, `iso_map.gd`, `park_controller.gd`, `save_system.gd`.
- Risco FPS: baixo.
- Risco save: medio por metadata; migrar `path_variant/path_mask`.
- Testes: path isolado, linha, curva, cruzamento, entrada, venda/demolicao.
- Prompt recomendado: "Implemente apenas a porcao Path/caminhos, baseada em b=0 e c[][], sem mudar visitantes."

### 3. Visitantes

- Objetivo: estruturar visitantes como sistema inteiro inspirado em `A-J/L/P-V/W`.
- Inclui: spawn por chance, entrada/saida externa, dinheiro, variacao visual, estados, movimento local, satisfacao, decisao de sair.
- Nao mexer: servicos, funcionarios, todas atracoes.
- Dependencias: path estavel.
- Arquivos: `visitor_system.gd`, `Visitor.tscn`, talvez `data/visitors.json`.
- Risco FPS: medio por quantidade/animacao; limitar e perfilar.
- Risco save: baixo se visitantes ativos nao forem salvos.
- Testes: spawn, rota, animacao, saida, sem atracao acessivel nao spawnar.
- Prompt recomendado: "Implemente a porcao Visitantes inteira, mantendo os dados atuais e sem mexer em render profundo."

### 4. Atracoes

- Objetivo: implementar Balanco como primeira atracao real de slot.
- Inclui: dados aW=6, footprint 3x3, origem, orientacao, entrada `m`, saida `n`, condicao, visual estatico/animado em etapas.
- Nao mexer: outras atracoes, servicos, funcionarios.
- Dependencias: path, visitantes basicos.
- Arquivos: `game_state.gd`, `buildings.json`, `iso_map.gd`, possivel `attraction_system.gd`.
- Risco FPS: alto se pecas desenhadas sem cache; comecar estatico.
- Risco save: medio por slot/orientacao.
- Testes: construir, vender, bloquear area, fila usa entrada/saida, FPS.
- Prompt recomendado: "Implemente apenas a porcao Atracoes com Balanco real, sem outras atracoes."

### 5. Fila e ciclo de uso

- Objetivo: aproximar `dt/dv/dw/cP/cQ/cN/cR`.
- Inclui: fila 10, capacidade, pagamento no embarque, duracao `am`, satisfacao `aA`, saida `n`, posicao visual por orientacao.
- Nao mexer: necessidades completas.
- Dependencias: Balanco com entrada/saida.
- Arquivos: `visitor_system.gd`, futuro `attraction_system.gd`.
- Risco FPS: baixo/medio.
- Risco save: medio se salvar filas.
- Testes: 3 visitantes, 2 embarcam, 1 espera, pagamento correto, saida correta.
- Prompt recomendado: "Implemente a porcao Fila e ciclo de uso fiel ao JAR para o Balanco."

### 6. Servicos e necessidades

- Objetivo: adicionar fome/sede/banheiro/saude/descanso e servicos correspondentes.
- Inclui: objetos de `v()`, valores negativos em `b`, estados `W=12`, baloes.
- Nao mexer: campanha, todos funcionarios.
- Dependencias: visitantes estruturados.
- Arquivos: `service_system.gd`, `visitor_system.gd`, `game_state.gd`, dados JSON.
- Risco FPS: medio.
- Risco save: medio.
- Testes: visitante procura servico e necessidade muda.

### 7. Funcionarios e manutencao

- Objetivo: implementar primeiro mantimentos/manutencao, depois demais tipos.
- Inclui: contratar, salario, movimento, reparar `ah/ai/ag`, staff visual.
- Nao mexer: competicao/campanha.
- Dependencias: atracoes com condicao.
- Risco FPS: medio.
- Risco save: medio.
- Testes: atracao quebra, funcionario repara, salario.

### 8. Economia avancada e estatisticas

- Objetivo: historico mensal, salarios, precos, derrota/vitoria financeira.
- Inclui: graficos de receita/visitas/felicidade, `R=26`.
- Dependencias: visitantes/servicos/staff.
- Risco FPS: baixo.
- Risco save: medio.

### 9. Menus/UI

- Objetivo: organizar UI touch baseada em funcoes do JAR, nao em softkeys puras.
- Inclui: categorias, paineis de atracao/servico/staff, ajuda, minimapa, avisos.
- Dependencias: sistemas ja existentes.
- Risco FPS: baixo.
- Risco save: baixo.

### 10. Save/load completo

- Objetivo: salvar dados fieis por versao.
- Inclui: mapa `b/c`, slots, visitantes opcionais, servicos, funcionarios, stats, campanha.
- Dependencias: dados estabilizados.
- Risco FPS: baixo.
- Risco save: alto; usar migracoes.

### 11. Campanha/progressao

- Objetivo: modo campanha com objetivos e desbloqueios.
- Inclui: tamanhos de mapa, objetivos, competicao anual, vitoria/derrota.
- Dependencias: economia/stats.
- Risco FPS: baixo.
- Risco save: medio.

### 12. Audio e polimento

- Objetivo: musica/sons, polish visual, localizacao.
- Inclui: `entry.mid` convertido se necessario, toggle som, textos PT.
- Dependencias: UI.
- Risco FPS: baixo.

## 20. Entrega final

### Resumo executivo

A arquitetura real do JAR e monolitica: a classe `e` concentra loop, input, render, mapa, visitantes, atracoes, economia, UI e save. Os dados mais importantes sao:

- mapa `b[][]/c[][]`
- slots de atracoes `Z/aa/l/m/n/ac/ad/e/f`
- entidades `A/B/C/D/E/F/G/H/I/J/L/P/Q/R/S/T/U/V/W`
- catalogos de `arrsi.dat/arr.dat`
- render isometrico por `r()/al()` e pecas de atlas

Os sistemas mais importantes para fidelidade sao, nesta ordem:

1. mapa/chao/entrada/path
2. visitantes
3. Balanco e fila/ciclo de uso
4. servicos/necessidades
5. funcionarios/manutencao
6. economia/estatisticas/save/campanha

Onde o port mais diverge:

- Render/profundidade ainda nao segue `r()/al()`.
- Atracoes ainda nao sao slots fieis com entrada/saida/orientacao/pecas.
- Visitantes ja tem muitos comportamentos, mas ainda nao usam a arquitetura completa `W[]`/necessidades.
- Save e simples demais comparado ao `RecordStore` em blocos.
- Servicos, funcionarios e campanha ainda nao existem.

### Lista completa por area

| Area | Estado ideal JAR | Estado atual port |
|---|---|---|
| mapa | `b/c`, 30x30/variavel, externos virtuais | mapa 30x30, dados simplificados |
| chao | grama 1..3, decoracoes naturais | grama 1..3 visual |
| path | `b=0`, `c/4`, masks, conexoes | path simples com variante/mask parcial |
| entrada | `(15,0)` path especial, estrada y<0, WELCOME | entrada reservada, estrada externa simples |
| visitantes | arrays A-J/L/P-V/W, necessidades, estados | sistema com BFS, dinheiro, fila, satisfacao parcial |
| atracoes | 24 tipos, slots, chunks, condicao | Balanco dados, visual placeholder |
| fila | `f/ad/e/ac`, capacidade, orientacao | fila simples com capacidade 2 |
| servicos | 27 objetos/servicos, necessidades | inexistente |
| funcionarios | 6 tipos, manutencao/ordem/venda/saude | inexistente |
| menus | estados `b/R`, softkeys, textos | HUD/BuildMenu simples |
| economia | custos, salarios, precos, graficos, derrota | dinheiro/earned/spent basico |
| save | RecordStore completo por blocos | JSON simples |
| campanha | niveis, objetivos, competicao | inexistente |
| render | varredura isometrica e profundidade | `_draw()` simples |
| assets | gpacks/chunks por sistema | parte importada |
| audio | MIDI `entry.mid`, toggle | inexistente |

### Tabela de fidelidade

| Area | Fidelidade atual | O que falta | Prioridade |
|---|---|---|---|
| mapa/chao | media | decoracoes, `b/c` forte, externos completos | alta |
| entrada/externo | media | offsets/recortes finais e abertura do muro fiel | alta |
| path | media | `bK()`/conexoes/masks reais | alta |
| visitantes | media | estados `W`, necessidades, decisao local completa | alta |
| atracoes | baixa/media | slot real, visual/animacao, orientacao | alta |
| fila | media | orientacao `dv/dw`, saida `n`, passageiros no assento | alta |
| servicos | inexistente | todo o sistema | media |
| funcionarios | inexistente | todo o sistema | media |
| economia | media | salarios, mensal, derrota, graficos | media |
| construcao | media | categorias, rotacao, validacao por chunk | alta |
| save/load | baixa | formato completo/versionado | media |
| UI | baixa/media | paineis, ajuda, minimapa, localizacao | media |
| render/profundidade | baixa | culling/ordem/pecas altas | alta com cuidado |
| campanha | inexistente | objetivos, unlocks, competicao | baixa/media |
| assets | media parcial | mapear sprites restantes/chunks | alta visual |
| audio | inexistente | musica/toggle | baixa |

### Plano de porcoes

Ordem recomendada:

1. Chao/mapa/base externa.
2. Path/caminhos.
3. Visitantes.
4. Atracoes: Balanco primeiro.
5. Fila e ciclo de uso.
6. Servicos e necessidades.
7. Funcionarios e manutencao.
8. Economia avancada e estatisticas.
9. Menus/UI.
10. Save/load completo.
11. Campanha/progressao.
12. Audio e polimento.

Por que essa ordem:

- Mapa e path sao a base de todos os outros sistemas.
- Visitantes dependem de path e entrada.
- Atracoes dependem de path, mapa e construcao.
- Fila/ciclo so faz sentido com atracao e visitantes estabilizados.
- Servicos/funcionarios dependem de visitantes e economia.
- Save completo deve vir depois dos modelos de dados estabilizarem.
- Campanha depende de economia, stats, unlocks e UI.

### Alertas

Pode derrubar FPS:

- Reimplementar `al()` fiel desenhando todos os sprites altos toda frame sem culling/cache.
- Transformar cada tile/peca em muitos `Node2D` dinamicos.
- Animar todas as atracoes por `_process` individual sem centralizar update.
- Fazer pathfinding completo para muitos visitantes a cada frame. O JAR recalcula localmente; no Godot, limitar BFS a chegada de tile e cachear metas.

Pode quebrar save:

- Trocar `tiles` simples por `b/c` sem migracao.
- Alterar formato de `buildings` sem default para saves antigos.
- Salvar visitantes ativos antes dos estados ficarem estaveis.
- Mudar `ENTRY_TILE` ou `INITIAL_PATH_TILE`.

Nao deve ser implementado ainda:

- Todas as atracoes de uma vez.
- Campanha completa antes de modo livre.
- Funcionarios antes de servicos/manutencao basica.
- Render 1:1 completo antes de cache/culling.
- Necessidades completas antes de visitantes estarem em estados claros.

Incertezas ainda abertas no JAR:

- Mapeamento exato de cada necessidade `Q/R/S/T/U/V`.
- Todos os recortes de muro/bordas das tabelas `h[65..70]`.
- Formula completa de competicao/campanha em `n()`.
- Todos os chunks de cada atracao alem do Balanco.
- Todos os valores e efeitos de servicos em `arrsi.dat`.
- Ordem final de profundidade para casos raros de sprites altos com visitantes no mesmo tile.

Conclusao tecnica:

O caminho mais seguro e tratar o remake como uma reimplementacao por sistemas, nao como porta direta do Java. A fidelidade deve vir dos dados e regras do JAR: `b/c` para mapa, slots para atracoes, estados `W` para visitantes, catalogos de `arrsi.dat`, e render por pecas com culling. O port atual ja tem uma boa base jogavel, mas ainda precisa consolidar dados e arquitetura antes de expandir para servicos, funcionarios e campanha.
