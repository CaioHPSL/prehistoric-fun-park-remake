# Analise completa do JAR original - Prehistoric Fun Park

Documento de referencia para o remake em Godot. Esta analise usa Vineflower como base principal e compara com CFR apenas quando necessario. Nao foram encontrados conflitos materiais entre Vineflower e CFR nas areas verificadas; onde a ofuscacao impede certeza total, o texto marca explicitamente o nivel de certeza.

Convencoes:

- **Certeza alta**: confirmada por codigo, tabela binaria, texto extraido ou sprite/crop usado diretamente.
- **Certeza media**: confirmada por codigo, mas o nome semantico vem de inferencia por contexto ofuscado.
- **Certeza baixa**: comportamento observado parcialmente ou inferido por relacao indireta.
- Fontes citadas usam `arquivo`, `metodo`, campo/array, indice e, quando aplicavel, recorte de sprite.

Fontes principais analisadas: `prehistoric_vineflower/e.java`, `Park.java`, `a.java`, `b.java`, `c.java`, `d.java`, `f.java`, `arr.dat`, `arrsi.dat`, `text.da4`, `warntext.da4`, `helptext.da4`, `gpack0.dat`..`gpack3.dat`, PNGs extraidos em `assets_extracted/`, e arquivos atuais do projeto Godot em `godot_project/`.

---

## 1. Visao geral do jogo

Prehistoric Fun Park e um jogo J2ME de gerenciamento de parque isometrico. O jogador constrói caminhos, atracoes, servicos, decoracoes e empregados; visitantes entram pelo portao, caminham pelos paths, gastam dinheiro, entram em filas/atracoes, tem necessidades e podem sair do parque.

Fluxo geral confirmado:

1. `Park.startApp()` cria e mostra `c`, o canvas de splash/loading. Fonte: `prehistoric_vineflower/Park.java`, `startApp()`.
2. `c.paint()` desenha `/splash0.png` e barra de progresso. Fonte: `prehistoric_vineflower/c.java`, `paint(Graphics)`.
3. `Park.startApp()` cria `f`, uma `TimerTask`. Fonte: `Park.java`, `startApp()`.
4. `f.run()` avanca os estados do splash; quando `a == 2`, instancia `new e(Park)`, coloca esse `GameCanvas` no `Display` e chama `e.a()`. Fonte: `prehistoric_vineflower/f.java`, `run()`.
5. `e.a()` carrega audio, gpack, dados binarios, textos, saves/progresso e inicia a thread principal. Fonte: `e.java`, `a()` linhas 814-857.
6. `e.run()` e o loop principal do jogo. Fonte: `e.java`, `run()` linhas 1171-1214.

Classes principais:

| Classe | Papel | Evidencia | Certeza |
|---|---|---|---|
| `Park` | MIDlet, controla ciclo de vida J2ME, splash e canvas principal | `Park.startApp()`, `pauseApp()`, `destroyApp()` | alta |
| `c` | Canvas de splash/loading | `c.paint(Graphics)` desenha imagens `/splash*.png` | alta |
| `f` | TimerTask que transiciona do splash para o jogo | `f.run()` instancia `e` e chama `e.a()` | alta |
| `e` | Classe central: GameCanvas, loop, mapa, input, simulacao, renderizacao, save/load | `e extends GameCanvas implements Runnable` | alta |
| `a` | Audio MIDI/J2ME | `Manager.createPlayer("/sound/" + nome, mime)` | alta |
| `b` | Tabelas constantes de sprites, dimensoes e menus | `b.B = {40,20}`, arrays `O/P`, `R..W`, etc. | alta |
| `d` | Tabelas constantes de progressao, graficos, UI e balanceamento | arrays estaticos usados por `e` | media |

A logica principal fica em `e.java`. A classe mistura controlador, simulacao, renderizador, input, catalogo, economia, visitantes e persistencia.

---

## 2. Estados principais do jogo

O estado mais importante e o campo inteiro `b` de `e`. A renderizacao/atualizacao principal em `run()` trata `b == 0` como gameplay normal e qualquer outro valor como telas/modos especiais. Fonte: `e.java`, `run()` linhas 1199-1205.

| Variavel | Significado provavel | Evidencia | Certeza |
|---|---|---|---|
| `b` | modo/tela principal | `o()` despacha por `b`: `1 -> S()`, `2 -> ak()`, `3 -> L()`, `4 -> T()`, `5 -> E()+Q()` | alta |
| `R` | subestado/tela dentro de `b == 3` | `b(int var1)` seta `b = 3; R = var1`; `L()` usa `R` para telas | alta |
| `aX` | categoria de construcao/menu | usada em `cp()/cq()/cr()/ct()/cc()` para ride, servico, empregado, path | alta |
| `aW` | item selecionado dentro da categoria | usado como indice em `az[aW]`, `o[aW]`, `p[aW]`, nomes via `aI[h[135/136]]` | alta |
| `B`, `C` | footprint/preview do item selecionado | `ct()` e `cs()` calculam dimensoes | alta |
| `at` | orientacao/rotacao do item | usado em `ct()`, `ce()`, chunks orientados de `arr.dat` | alta |
| `aa` | contador/flag de redraw/transicao | `run()` chama `x()` se `aa != 0`; varios metodos setam `aa = 5` | media |

Estados de `b` confirmados:

| `b` | Significado | Evidencia | Certeza |
|---|---|---|---|
| `0` | parque rodando/gameplay | `run()` chama `l(); m(); n();` quando `b == 0` | alta |
| `1` | menu/overlay especial | `o()` chama `S()` | media |
| `2` | modo construcao/preview/menu de construcao | `o()` chama `ak()`; `cc()` confirma construcao | alta |
| `3` | telas/painel/dialogos | `b(int)` seta `b=3; R=...`; `o()` chama `L()` | alta |
| `4` | minimapa/tela especial | `o()` chama `T()` | media |
| `5` | ajuda/tutorial/mensagem | `o()` chama `E(); Q()`; `n()` usa `b(24/25)` para mensagens | media |

Subestados importantes de `R`:

- `R = 16`: pausa/menu de pausa. Fonte: `e.java`, `e()` linhas 956-967 e `f()` retoma.
- `R = 10`: tela de nivel/objetivo/progresso. Fonte: `q()` linhas 1524-1540.
- `R = 12`: tela de vitoria/progresso de campanha. Fonte: `n()` linhas 1424-1444. Certeza media.
- `R = 13`: derrota/aviso financeiro quando dinheiro fica abaixo do limite. Fonte: `n()` linhas 1388-1402.
- `R = 24/25`: tutorial/desbloqueios/ajuda. Fonte: `n()` linhas 1446-1458.
- `R = 26`: estatisticas/graficos. Fonte: `L()` linhas 2018-2098.

---

## 3. Loop principal

Metodo principal: `e.run()`, linhas 1171-1214.

Ordem confirmada:

1. Se o jogo nao esta pausado (`!s`), dorme 1 ms. Fonte: `run()`.
2. A cada ~100 ms (`System.currentTimeMillis() > last + 100`), executa um tick logico. Fonte: `run()` linhas 1178-1182.
3. Chama `aS()`, dispatcher de input. Fonte: `run()` linha 1181.
4. Chama `k()`, atualizacao/simulacao geral. Fonte: `run()` linha 1182.
5. Se `aa != 0`, redesenha buffer de mundo com `x()`. Fonte: `run()` linhas 1183-1187.
6. Copia o buffer base para a tela com `drawImage(this.e, 0, 0, 20)`. Fonte: `run()` linha 1191.
7. Atualiza contador de cursor/animacao `aF`. Fonte: `run()` linhas 1192-1198.
8. Se `b == 0`, chama `l(); m(); n();` para gameplay/render dinamico. Fonte: `run()` linhas 1199-1204.
9. Caso contrario, chama `o()` para menus/telas. Fonte: `run()` linha 1205.
10. Chama `p()` para UI final e `flushGraphics`. Fonte: `run()` linha 1207.

`p()` faz a etapa final da renderizacao: `cG(); ar(); cF(); dP(); aq(); flushGraphics(0,0,l,m)`. Fonte: `e.java`, `p()` linhas 1501-1513.

Timers/ticks:

- Tick principal: 100 ms. Fonte: `run()` comparacao com `+100L`.
- Ticks de visitantes/atracoes usam contadores byte/int internos (`af[]`, `ab[]`, `ae[]`, `r`, etc.) atualizados dentro dos metodos de simulacao. Fonte: `cN()`, `cU()`, `cV()`.

---

## 4. Sistema de input

Metodo de entrada J2ME: `keyPressed(int)` e `keyReleased(int)`. Fonte: `e.java` linhas 7869-7910.

Mapeamento confirmado:

| Tecla J2ME | Acao interna | Evidencia | Certeza |
|---|---|---|---|
| `-6`, `6`, `*` / `42` | softkey esquerda, `n = -6` | `keyPressed()` | alta |
| `-7`, `7`, `#` / `35` | softkey direita, `n = -7` | `keyPressed()` | alta |
| `0` / `48` | acao especial/atalho, `n = 48` | `keyPressed()` | alta |
| `5` ou FIRE | confirmar, `n = 5` | `keyPressed()` com `getGameAction()` | alta |
| `2` ou UP | direcional cima, `n = 1` | `keyPressed()` | alta |
| `8` ou DOWN | direcional baixo, `n = 2` | `keyPressed()` | alta |
| `6` ou RIGHT | direcional direita, `n = 3` | `keyPressed()` | alta |
| `4` ou LEFT | direcional esquerda, `n = 4` | `keyPressed()` | alta |

`keyReleased()` seta `q = true` e limpa `n` quando `aN > 0`. Fonte: `e.java`, `keyReleased()` linhas 7902-7910.

Processamento por estado:

- O dispatcher `aS()` e chamado antes da simulacao em todo tick. Fonte: `run()` linha 1181.
- Gameplay (`b == 0`) usa cursor/camera, menus radiais e selecao de objetos.
- Construcao (`b == 2`) usa `aX`, `aW`, `B`, `C`, `at` e chama validacao/confirmacao via `cc()`.
- Telas (`b == 3`) usam `R` e metodos de painel como `L()`.

Por causa da ofuscacao, nem todos os handlers de `aS()` receberam nomes seguros. A relacao tecla -> `n` e confirmada; a semantica exata de cada ramo dentro de todos os menus e **certeza media**.

---

## 5. Sistema de mapa

Tamanho base:

- Arrays de mapa: `byte[][] b = new byte[30][30]` e `byte[][] c = new byte[30][30]`. Fonte: `e.java`, construtor linhas 627-628.
- Tamanho jogavel ativo: campo `O`. Em modo livre (`K == 0`) `O = 30`; campanha usa `O = aI[h[134] + L]`, com valores extraidos de `aI[134]`: `12, 15, 20, 25, 25, 30`. Fonte: `h()` linhas 1041-1077 e `arr.dat/aI`.
- Centro/entrada horizontal: `ab = O / 2`. Fonte: `h()` linhas 1067-1069.

Coordenadas:

- Coordenadas jogaveis: `0 <= x < O`, `0 <= y < O`.
- Coordenadas externas virtuais existem para borda/estrada: `x = -1`, `x = O`, `y = -1`, `y = O`. Fonte: `J()` linhas 1967-1989 e `I()` linhas 1922-1940.

Arrays:

| Array | Significado | Evidencia | Certeza |
|---|---|---|---|
| `b[x][y]` | tipo de tile/ocupacao | terreno, path, footprint, negativos, objetos | alta |
| `c[x][y]` | metadado por tile: variante path, dono de atracao/objeto, lista de visitantes | `F()`, `ce()`, `bX()`, `cS()` | alta |

Valores confirmados de `b[][]`:

| Valor | Uso | Evidencia | Certeza |
|---|---|---|---|
| `0` | caminho/path | `F()` desenha path; `g()` seta `b[ab][0] = 0` | alta |
| `1`, `2`, `3` | grama/terreno base, tres variantes | `G()` usa `b[x][y]-1` como faixa vertical em `gpack2_000` | alta |
| `< 0` | decoracao/servico/objeto colocado | `H()` usa `-1 - b[x][y]` como indice em `aI[h[89]...]`; `cf()/cg()` escrevem negativos | alta |
| `> 3` | tiles internos de footprint de atracao/objeto especial | `ce()` escreve valores vindos de `arr.dat` chunk 37 | alta |

Geracao do mapa:

- `i()` percorre o mapa; 1 em 20 tiles vira decoracao negativa aleatoria `-1 - rand%12`; caso contrario vira grama `1..3`. Fonte: `i()` linhas 1079-1118.
- `c[x][y]` e inicializado e termina como `-1` na geracao. Fonte: `i()` linhas 1083-1091.
- `g()` chama `h(); i(); j();`, inicializa recursos e seta o path inicial em `b[ab][0] = 0`. Fonte: `g()` linhas 1002-1039.

Entrada logica:

- Tile inicial do path jogavel: `(ab, 0)`, com `ab = O / 2`. Fonte: `g()` linha 1034 e `h()` linhas 1067-1069.
- Caminho externo/estrada antes do portao e desenhado em coordenadas com `y < 0`. Fonte: `I()` linhas 1922-1940.

Save/load do mapa:

- `dW()` salva `b[30][30]` e `c[30][30]`.
- `ea()` carrega esses arrays.
- Fonte: `e.java`, `dW()/ea()` linhas 10485-10970.

---

## 6. Projecao isometrica

Dimensoes do tile:

- `b.B = {40, 20}`. Fonte: `prehistoric_vineflower/b.java`, campo `B`.

Formula direta confirmada, usada em varios pontos (`l()`, `m()`, `K()`):

```text
screen_x = (tile_x + tile_y - camera_tile_x - camera_tile_y) * (tile_w / 2) + camera_screen_x
screen_y = (tile_x - tile_y - camera_tile_x + camera_tile_y) * (tile_h / 2) + camera_screen_y
```

Evidencia: `e.java`, `l()` linhas 1296-1297; `m()` linhas 1309-1310; `K()` linhas 2006-2007. No decompilado, alguns nomes como `X/Y` aparecem trocados pelo ofuscador, mas a estrutura matematica e consistente.

Formula inversa:

```text
tile_x ~= ((screen_y - camera_screen_y) / (tile_h / 2)
        +  (screen_x - camera_screen_x) / (tile_w / 2)) / 2
        + camera_tile_x

tile_y ~= ((screen_x - camera_screen_x) / (tile_w / 2)
        -  (screen_y - camera_screen_y) / (tile_h / 2)) / 2
        + camera_tile_y
```

Evidencia: `e.java`, `F()` linhas 1849-1850 e `J()` linhas 1944-1945. Certeza alta para a formula; media para o nome de cada variavel de camera por causa de nomes ofuscados.

Varredura e profundidade:

- `r()` calcula quadrilatero/limites visiveis em `f[0..3][0..1]`. Fonte: `r()` linhas 1542-1551.
- `al()` varre linhas de tela de cima para baixo, alternando meio-tile vertical e passos horizontais, chamando `an/am/ap/ao`. Fonte: `al()` linhas 3296-3327.
- `a(int,int,int,int)` faz varredura parecida para blocos de redraw. Fonte: linhas 1756-1770.

Direcao visual dos eixos:

- Aumentar `x` desloca visualmente para direita e para baixo.
- Aumentar `y` desloca visualmente para direita e para cima, pela formula `screen_y = x - y`.
- Assim `y = 0` fica na borda visual inferior/esquerda do losango de entrada; `y = 29` fica na borda visual superior/direita do parque. Certeza media, derivada da formula e do path de entrada em `(ab,0)`.

Adaptacao Godot:

- Manter `tile_w = 40`, `tile_h = 20`.
- Usar a mesma formula para `Vector2(screen_x, screen_y)`, com offset de camera separado.
- Nao deslocar a entrada para `(15,1)` se o objetivo for fidelidade: o JAR coloca o path inicial jogavel em `(ab,0)` e desenha a estrada externa fora do mapa.
- Ordenar desenho por diagonal/varredura equivalente a `x+y` com ajustes de footprint e sprites altos; apenas `z_index = x - y` nao cobre tudo.

---

## 7. Terreno e grama

Sprite base:

- Array de imagem: `c[0]`, carregado de `gpack2.dat`.
- PNG extraido: `assets_extracted/gpack2_000.png`, dimensao `38x60`.
- Recortes usados:
  - `b = 1`: `(0, 0, 38, 20)`
  - `b = 2`: `(0, 20, 38, 20)`
  - `b = 3`: `(0, 40, 38, 20)`
- Evidencia: `G()` linha 1906 usa `drawRegion(c[0], 0, b.B[1] * (b[x][y] - 1), 38, 20, ...)`.

Aleatoriedade:

- Na geracao inicial, cada tile nao decorativo recebe `b = random(1..3)`. Fonte: `i()` linhas 1083-1096.
- Quando um path e demolido, se nao for subvariante, volta a `random(1..3)`. Fonte: `bX()` linhas 6600-6608.

Overlay:

- Para tiles negativos, `H()` decide desenhar base path ou grama antes do objeto dependendo de `aI[h[89] + -1 - b[x][y]]`. Fonte: `H()` linhas 1910-1919. Certeza alta para a decisao; media para o nome do flag.

Adaptacao Godot:

- Reproduzir exatamente os tres recortes verticais de `gpack2_000.png`.
- Guardar o valor de terreno original por tile, nao recalcular por hash visual se for carregar saves ou demolir path fielmente.
- Para objetos negativos, consultar uma tabela equivalente a `aI[h[89]]` antes de escolher se a base e grama ou path.

---

## 8. Caminhos / Path

Representacao:

- `b[x][y] = 0` significa path.
- `c[x][y]` guarda variante/mascara. O desenho base usa `c[x][y] / 4`. Fonte: `F()` linha 1870.

Sprite base:

- Imagem: `b[2]`, carregada de `gpack1.dat`.
- PNG extraido: `assets_extracted/gpack1_002.png`, dimensao `125x124`.
- Recortes base definidos em `b.java`:
  - `b.O = {0, 38}`
  - `b.P = {104, 104}`
- Desenho: `drawRegion(b[2], b.O[c/4], b.P[c/4], 38, 20, ...)`. Fonte: `F()` linhas 1856-1871.

Bits/mascara:

- O codigo usa `c % 4`, `c & 1` e `c & 2` em rotinas de path/overlay/demolicao. Fonte: `bX()` linhas 6600-6608 e metodos de conexao `bK()`/desenho de overlays.
- `c / 4` seleciona a base visual principal.
- `c & 1` e `c & 2` parecem guardar bordas/conectividade/variante fina. Certeza media, porque a funcao e clara no desenho/demolicao, mas os nomes foram ofuscados.

Conexao com entrada:

- O tile `(ab,0)` e path inicial e protegido de demolicao/alteracao. Fonte: `g()` linha 1034 e `bV()` linhas 6538-6554.
- A estrada externa e desenhada fora do mapa por `I()` quando `Z == ab && aa < 0`. Fonte: `I()` linhas 1922-1940.

Visitantes e path:

- Visitantes nascem em `(ab,0)` e miram `(ab,1)`. Fonte: `cS()` linhas 8176-8228.
- Decisao de movimento usa path e conectores de objetos/atracoes. Fonte: `dr()` linhas 9035-9078; `l()` linhas 9479-9508.
- Se nao ha rota valida ou necessidades/dinheiro indicam saida, visitante vai para `W = 18` e sai pela entrada. Fonte: `dz()` linhas 9725-9735 e `dm()` linhas 8927-8929.

Demolicao:

- `bX()` trata path. Se `c % 4 != 0`, remove subvariante (`c -= c % 4`); se nao, transforma o tile em grama aleatoria `1..3`, zera `c` e chama reparo de conexoes `bK()`. Fonte: `bX()` linhas 6600-6608.

Adaptacao Godot:

- Separar `terrain_type` (`b`) de `path_meta` (`c`).
- Implementar primeiro `b=0` com `c/4` e depois adicionar overlays por `c&1`, `c&2`.
- Proteger `(ab,0)` contra demolicao, como o JAR.

---

## 9. Entrada do parque / WELCOME

Tile logico:

- Entrada jogavel: `(ab,0)`, `ab = O / 2`.
- O tile e path normal no array (`b[ab][0] = 0`), mas e tratado como especial por desenho externo e regras de demolicao. Fonte: `g()` linha 1034, `bV()` linhas 6538-6554.

Estrada externa:

- `I()` desenha tiles externos. Se `Z == ab && aa < 0`, desenha path externo e chama `aw()`. Fonte: `I()` linhas 1922-1940.
- Outros tiles externos recebem grama/base, nao path. Fonte: `I()`.

Portao/WELCOME:

- `aw()` desenha elementos do portao/placa usando `b[6]` e `b[2]`. Fonte: `e.java`, metodos `as()/at()/aw()` proximos das linhas 3606-3635.
- Recortes confirmados por tabelas em `b.java`:
  - `b[6]` / `gpack1_006.png`: recorte `(0,112,15,12)` para pedras/apoio, offsets por `aI[h[37]/h[38]]`.
  - `b[2]` / `gpack1_002.png`: recortes de placa por `b.R/S/T/U/V/W`:
    - `b.R = {90,105}`
    - `b.S = {83,84}`
    - `b.T = {15,18}`
    - `b.U = {20,13}`
    - `b.V = {-19,-4}`
    - `b.W = {-44,-33}`
- Certeza alta para recortes/tabelas; media para nomes visuais exatos de cada peca.

Visitantes:

- Entram em `cS()` com `B=ab`, `C=0`, `D=ab`, `E=1`, `F=3`, `H=-100` para offset visual de chegada pela estrada. Fonte: `cS()` linhas 8176-8228.
- Saem em `W=18`; `dm()` remove o visitante quando ele cruza o offset externo (`H <= -100`). Fonte: `dm()` linhas 8927-8929.

Adaptacao Godot:

- Manter path jogavel em `(15,0)` no mapa 30x30.
- Desenhar WELCOME/estrada como elementos externos, nao como tile jogavel `(15,1)`.
- Spawn visual deve comecar fora do tile e interpolar para dentro.

---

## 10. Muro / borda externa do mapa

Coordenadas externas:

- `x = -1`
- `x = O`
- `y = -1`
- `y = O`

Evidencia: `J()` linhas 1967-1989 calcula tile externo pela formula inversa e chama `aJ()` quando cai em uma dessas bordas.

Recortes:

- `aJ()` usa `b[2]` (`gpack1_002.png`) e offsets/tabelas em `aI[h[65]..h[70]]`. Fonte: `J()`/`aJ()` linhas 1967-1989 e referencias a `h[65]..h[70]`.
- Certeza alta para a existencia da borda externa; media para classificacao visual de cada canto/segmento sem nome original.

Ordem:

- A borda participa da mesma varredura isometrica de tiles, usando coordenadas externas e a ordem de desenho do mundo. Fonte: `al()` e `J()`.

Adaptacao Godot:

- Renderizar bordas como tiles virtuais fora do grid jogavel.
- Evitar colocar bordas dentro de `0..O-1`, porque isso muda construcao/pathfinding.

---

## 11. Sistema de construcao

Categorias:

- Menus/labels em portugues via `warntext.da4`:
  - `23`: `Caminho`
  - `24`: `atrac[o_es`
  - `25`: `servicos`
  - `26`: `estati\sticas`
  - `27`: `Empregados`
  - `28`: `decorac[o_es`
  - `29`: `demolic[a_o`
- Fonte: `warntext.da4`, indices 23-29.

Campos:

| Campo | Papel | Evidencia | Certeza |
|---|---|---|---|
| `aX` | categoria selecionada | `cc()` despacha por categoria | alta |
| `aW` | item selecionado | usado em catalogos e custo | alta |
| `B`, `C` | dimensoes/footprint do preview | `ct()`/`cs()` | alta |
| `at` | orientacao | `ct()`/`ce()` usam chunks por orientacao | alta |
| `aA` | codigo de erro/validacao | `bV()` seta `aA = 8` para entrada bloqueada | media |

Custos:

- Atracoes (`aX == 0`): `az[aW] * 10`. Fonte: `cr()` linha 7277.
- Servicos/decoracoes (`aX == 1`): `aI[h[58] + aW]`. Fonte: `cr()` linha 7280.
- Empregados (`aX == 2`): `aI[h[131] + C]`. Fonte: `cr()` linha 7283.
- Paths (`aX == 3`): `aI[h[133] + aW]`. Fonte: `cr()` linha 7286.

Footprint:

- Atracoes: `ct()` le dimensoes de `o[aW][g[aW][0/1]]`. Fonte: `ct()` linhas 7339-7355.
- Servicos/decoracoes: `cs()` define 1x1 por padrao; item `aW == 26` usa 2x2. Fonte: `cs()` linhas 7307-7337.

Confirmacao:

- `cc()` chama:
  - `cd()/ce()` para atracao
  - `cf()/cg()` para servico/decoracao
  - `cj()` para empregado
  - `ch()` para path
  - depois `ci()` para dinheiro/redraw
- Fonte: `cc()` linhas 6737-6768.

Atracao:

- `cd()` escolhe slot livre entre 42 slots, grava `Z[slot]=aW`, `aa[slot]=at`, origem `l[slot][0/1]`.
- `ce()` escreve cada tile do footprint em `b[][]` usando `arr.dat` chunk 37 e grava o slot dono em `c[][]`.
- Tiles de valor `7` ou `8` gravam `n[slot]` (saida/retorno); valor `10` grava `m[slot]` (embarque/load). Fonte: `ce()` linhas 6813-6831.

Demolicao/venda:

- `bX()` trata path.
- `bZ()` trata objetos negativos.
- `ca()` remove atracao e limpa footprint.
- Fonte: `e.java` linhas 6591-6717.

Adaptacao Godot:

- Implementar o catalogo a partir de `arrsi/arr` ou tabela extraida, nao a partir de placeholders.
- Usar slots/ids de construcao separados do tilemap.
- A validacao precisa bloquear a entrada `(ab,0)` e respeitar footprints orientados.

---

## 12. Catalogo de atracoes

Os 24 registros carregados por `u()` de `arrsi.dat` sao usados como catalogo de atracoes/macro-objetos. Cada registro le campos `am, as, at, an, ap, ao, aq, au, ar, av, aw, ax, ay, az, aA, aB, aC` e um bloco de bytes em `arr.dat` com 42 chunks. Fonte: `e.java`, `u()` linhas 1580-1623.

Nomes: `aI[h[135]] = [42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,106,105,61,62,63]`; indices resolvidos em `text.da4`. Certeza alta.

Comecando obrigatoriamente pelo Balanço:

| aW | Nome PT | Texto | Custo | Footprint | Duracao/fonte `am` | Capacidade/fonte `au` | Satisfacao/fonte `aA` | Certeza |
|---:|---|---:|---:|---|---:|---:|---:|---|
| 6 | balanc[o | 48 | 30 | 3x3 | 61 | 2 | 5 | alta p/ valores, media p/ semantica |
| 0 | roda gigante | 42 | 400 | 3x3 | 97 | 4 | 25 | alta/media |
| 1 | torre | 43 | 180 | 3x3 | 61 | 2 | 20 | alta/media |
| 2 | torre grande | 44 | 600 | 3x3 | 96 | 4 | 35 | alta/media |
| 3 | bungee jump grande | 45 | 450 | 3x4 | 92 | 1 | 50 | alta/media |
| 4 | bungee jump | 46 | 150 | 3x3 | 81 | 1 | 25 | alta/media |
| 5 | caverna do terror | 47 | 100 | 3x3 | 61 | 3 | 10 | alta/media |
| 7 | Salto de a\gua | 49 | 150 | 4x3 | 66 | 1 | 25 | alta/media |
| 8 | Salto tramp. | 50 | 120 | 5x3 | 56 | 1 | 20 | alta/media |
| 9 | Tobogan aqua\t. | 51 | 200 | 5x3 | 70 | 1 | 30 | alta/media |
| 10 | Tobogan | 52 | 120 | 5x3 | 69 | 1 | 20 | alta/media |
| 11 | trampolin | 53 | 40 | 3x3 | 81 | 1 | 15 | alta/media |
| 12 | gira-gira | 54 | 100 | 3x3 | 85 | 3 | 10 | alta/media |
| 13 | gira-gira grande | 55 | 300 | 3x3 | 85 | 6 | 15 | alta/media |
| 14 | Gangorra | 56 | 60 | 4x3 | 65 | 2 | 10 | alta/media |
| 15 | Salto Grande | 57 | 200 | 5x3 | 62 | 1 | 30 | alta/media |
| 16 | banho de a\gua | 58 | 150 | 5x4 | 55 | 1 | 25 | alta/media |
| 17 | Campo de tiro | 59 | 60 | 5x4 | 59 | 1 | 15 | alta/media |
| 18 | catapulta | 60 | 450 | 3x4 | 84 | 1 | 50 | alta/media |
| 19 | Ursa Maior | 106 | 900 | 5x8 | 105 | 4 | 50 | alta/media |
| 20 | mont. russa me\dia | 105 | 750 | 4x6 | 55 | 4 | 40 | alta/media |
| 21 | montanha russa | 61 | 600 | 4x5 | 53 | 4 | 35 | alta/media |
| 22 | Circuito de a\gua | 62 | 70 | 2x2 | 0 | 0 | 10 | alta/media |
| 23 | cafeteria | 63 | 150 | 2x3 | 11 | 12 | 0 | alta/media |

Observacoes:

- Custo = `az * 10`, confirmado por `cr()`.
- Duracao de uso = `am` e confirmada por `cN()` comparar `af >= am[Z] - 1`. Fonte: `cN()` linha 8025. Certeza media para o nome "duracao".
- Capacidade/slots = `au`, usado em embarque/ocupacao. Certeza media.
- Satisfacao = `aA`, usado em `cR()` como ganho `P += aA[ride] - b.ap[fila+1]`. Fonte: `cR()` linha 8163. Certeza media para nome do atributo.

Sprites de cada atracao ficam nos chunks de `arr.dat` por ride:

- chunks 5-11: pecas estaticas usadas por `aE()`.
- chunks 12-18: pecas animadas usadas por `aF()`.
- chunk 20: linhas/cordas usadas por `aD()`.
- chunk 37: mascara de footprint usada por `ce()`.
- chunk 38: mascara/camadas de desenho usada por `am()/ai()`.

Fonte: `aD()` linhas 4052-4115, `aE()` linhas 4117-4155, `aF()` linhas 4175-4226, `ce()` linhas 6813-6831, `am()/ai()` linhas 3329-3356 e 3169-3212.

---

## 13. Balanco

Identidade:

- Nome original em portugues: `balanc[o`.
- Indice de texto: `text.da4[48]`.
- Indice no catalogo: `aW = 6`, porque `aI[h[135]][6] = 48`.
- Fonte: `text.da4`, `arr.dat/aI[135]`, `e.java u()/cr()/ct()`.

Balanceamento:

| Dado | Valor | Fonte | Certeza |
|---|---:|---|---|
| `aW` | 6 | `aI[h[135]][6]` | alta |
| custo | 30 | `az[6] = 3`, `cr()` usa `az * 10` | alta |
| footprint | 3x3 | `arr.dat`, ride 6 chunk 0; `ct()` | alta |
| duracao de uso | 61 ticks logicos | `am[6] = 61`, `cN()` | media |
| capacidade/slots | 2 | `au[6] = 2`, embarque usa arrays por ride | media |
| satisfacao gerada | 5 antes de penalidade de fila | `aA[6] = 5`, `cR()` | media |

Header completo do registro 6 em `arrsi.dat`:

```text
[61, 12, 12, 9, 1, 0, 3, 2, 0, 0, 20, 7, 50, 3, 5, 31, 7]
```

Como e construido:

- `cc()` chama `cd()`/`ce()` quando `aX == 0`.
- `cd()` registra slot, tipo `Z[slot] = 6`, orientacao `aa[slot] = at`, origem `l[slot]`.
- `ce()` escreve a mascara do footprint em `b[][]` e o slot dono em `c[][]`.
- Fonte: `e.java`, `cc()` linhas 6737-6768, `cd()/ce()` linhas 6770-6839.

Tiles ocupados:

Footprint 3x3, chunk 37 de `arr.dat`, duas orientacoes confirmadas:

Orientacao 0:

```text
8  12  9
1  10 11
6  4  4
```

Orientacao 1:

```text
4  12  9
4  10 11
5  1  7
```

Interpretacao segura:

- Valor `10` grava `m[slot]`, ponto de embarque/load. Fonte: `ce()` linhas 6824-6826.
- Valores `7` ou `8` gravam `n[slot]`, ponto de saida/retorno. Fonte: `ce()` linhas 6819-6823.
- Valores `5/6` sao conectores/entrada por logica de visitante (`h()` procura `bd == 5 + aT`). Fonte: `h()` linhas 9298-9338.

Desenho:

- A varredura `am()` identifica o owner via `c[x][y]`, tipo `ar = Z[owner]`, frame `as = ab[owner]`, origem `aL`, e mascara de desenho do chunk 38.
- `ai()` decide camadas e chama `aD()`, `aE()`, `aF()`.
- Fonte: `am()` linhas 3329-3356, `ai()` linhas 3169-3212.

Pecas estaticas confirmadas para o Balanco:

| Imagem | PNG | Recorte | Offset | Fonte |
|---|---|---|---|---|
| `b[1]` | `gpack1_001.png` | `(66,0,8,25)` | `(1,-23)` | `arr.dat` ride 6 chunks 5-11, `aE()` |
| `b[1]` | `gpack1_001.png` | `(66,0,8,25)` | `(5,-47)` | `arr.dat`, `aE()` |
| `b[1]` | `gpack1_001.png` | `(67,19,7,25)` | `(10,-41)` | `arr.dat`, `aE()` |
| `b[1]` | `gpack1_001.png` | `(67,19,7,25)` | `(14,-17)` | `arr.dat`, `aE()` |
| `b[0]` | `gpack1_000.png` | `(3,37,22,13)` | `(-11,-45)` | `arr.dat`, `aE()` |

Ha pecas repetidas por camada/orientacao com offsets proximos, vindas dos mesmos chunks. Certeza alta para recortes/offsets extraidos; media para o nome visual de cada peca.

Peca animada:

- Imagem: `b[1]` / `gpack1_001.png`.
- Recorte: `(4,0,16,12)`.
- Offset dinamico X por 12 frames: `[-5, 2, 9, 12, 9, 2, -5, -12, -17, -19, -17, -12]`.
- Offset dinamico Y por 12 frames: `[-1, 1, 0, -1, 0, 1, -1, -4, -9, -12, -9, -4]`.
- Fonte: `arr.dat` ride 6 chunks 12-18, `aF()` linhas 4175-4226.

Cordas/linhas:

- `aq[6] = 3`; `aD()` desenha tres segmentos com cor de `b.b[6]` e dados do chunk 20.
- Frame 0 confirmado:
  - `(7,-40) -> (7,-3)`
  - `(7,-3) -> (-6,3)`
  - `(-6,3) -> (-6,-34)`
- Fonte: `arr.dat` ride 6 chunk 20, `aD()` linhas 4052-4115.

Fila/uso:

- Visitante entra em fila via `dt()`, que coloca o id em `f[ride_slot][queue_index]` e seta `W = 11`. Fonte: `dt()` linhas 9542-9562.
- Embarque/pagamento em `cQ()`: dinheiro do parque `k` aumenta, visitante paga, popup `+amount`, visitante fica `W = 13`. Fonte: `cQ()` linhas 8129-8152.
- Uso termina em `cN()` quando `af >= am[Z] - 1`, e `cR()` devolve visitantes para o ponto `n[slot]`, aplica satisfacao `P += aA - penalidade_fila`, e reduz condicao `ah`. Fonte: `cN()` linhas 8016-8077 e `cR()` linhas 8154-8174.

Adaptacao Godot:

- Criar `aW=6` como primeira atracao real do port, custo 30, footprint 3x3, slots 2.
- Desenhar em camadas: terreno/path, footprint/base, pecas estaticas, cordas, assento animado, visitantes/efeitos conforme profundidade.
- A animacao do assento deve usar offsets por frame do JAR; nao basta girar um sprite em torno do centro.

---

## 14. Visitantes

Arrays principais:

| Array | Significado provavel | Evidencia | Certeza |
|---|---|---|---|
| `A[]` | tipo/skin/funcao da entidade; tambem usado por empregados | `cS()` inicializa; render e staff testam `A` | media |
| `B[]`, `C[]` | tile atual x/y | `cS()`, lista de ocupacao `c[B][C]` | alta |
| `D[]`, `E[]` | tile alvo x/y | `cS()`, movimento/path | alta |
| `F[]` | direcao | `cS()` e offsets `aI[h[36] + F*2]` | alta |
| `G[]`, `H[]` | offset intra-tile/visual | spawn usa `H=-100`; movimento atualiza | alta |
| `I[]` | velocidade | `cS()` sorteia `1..4` | media |
| `J[]` | frame de animacao | `cS()` seta `1`; render usa | media |
| `W[]` | estado da maquina de visitantes | `cU()` despacha por W | alta |
| `L[]` | dinheiro do visitante | `cS()` seta `60 +/- 20`; pagamentos reduzem | alta |
| `P/Q/R/S/T/U/V[]` | necessidades/satisfacao/atributos | `cS()`, `cV()`, `g = {P..W,L}` | media |

Spawn:

- Metodo: `cS()`.
- Probabilidade `aU` depende de estatisticas do parque, numero de visitantes, atracoes e limites, clamp aproximado `3..80`. Fonte: `cS()` linhas 8176-8228.
- Novo visitante:
  - `B = ab`, `C = 0`
  - `D = ab`, `E = 1`
  - `F = 3`
  - `G = aI[h[36] + F*2]`
  - `H = -100`
  - `I = random 1..4`
  - `J = 1`
  - `W = -1`
  - `L = 60 +/- 20`
- Fonte: `cS()` linhas 8176-8228.

Atualizacao:

- `cU()` percorre as 222 entidades, chama `cV()` para necessidades/timers e depois despacha estados. Fonte: `cU()` linhas 8237-8277.
- `cV()` altera atributos de necessidade com base em dificuldade/tempo e pode disparar baloes de pensamento. Fonte: `cV()` linhas 8294-8314.

Path decision:

- `dr()` escolhe acao: procurar servico/atracao, sair, ou continuar andando. Fonte: `dr()` linhas 9035-9078.
- `l()` escolhe path aleatorio/rota proxima e, se bloqueado, pode setar saida. Fonte: `l()` linhas 9479-9508.
- `dz()` decide saida por pouco dinheiro, necessidades ruins ou infelicidade. Fonte: `dz()` linhas 9725-9735.

Entrada em atracao:

- `h()` checa proximidade com conectores de construcao (`bd == 5 + aT`), condicao da atracao, fila menor que 10 e disponibilidade. Fonte: `h()` linhas 9298-9338.
- Ao chegar, `do()` seta `W=9` ou `W=14` dependendo do tipo. Fonte: `do()` linhas 8965-8975.
- `dt()` insere na fila e seta `W=11`. Fonte: `dt()` linhas 9542-9562.

Pagamento/uso/saida:

- `cQ()` cobra e embarca (`W=13`). Fonte: `cQ()`.
- `cN()` controla ciclo da atracao. Fonte: `cN()`.
- `cR()` desembarca e aplica satisfacao. Fonte: `cR()`.

Remocao:

- `W=18` e estado de saida.
- `dm()` remove a entidade quando ela atravessa a estrada externa (`H <= -100`). Fonte: `dm()` linhas 8927-8929.

Adaptacao Godot:

- Separar entidade visual de estado logico.
- Implementar `tile atual`, `tile alvo`, `offset intra-tile`, `estado W`, dinheiro e necessidades antes de tentar filas complexas.
- Spawn deve vir visualmente de fora da entrada, nao aparecer instantaneamente no primeiro tile.

---

## 15. Maquina de estados dos visitantes

| `W` | Nome provavel | Metodo responsavel | Entra quando | O que acontece | Sai quando | Adaptacao Godot |
|---:|---|---|---|---|---|---|
| `-1` | livre/andando em path | `cU()`, `dr()`, `l()` | spawn ou pos-acao | decide destino, caminha, procura atracao/servico | escolhe fila, servico ou saida | estado `Walking` |
| `7` | entrando em atracao/servico | `h()`, `de()/cW()` | detecta conector valido | move do path para footprint | chega ao ponto interno | `EnteringBuilding` |
| `9` | indo para fila/load | `do()`, `df()`, `dt()` | chegou ao tile de atracao normal | aproxima da fila/embarque | entra em `W=11` | `ApproachingQueue` |
| `10` | retornando de conector/servico | `c()`, `dg()` | fim de interacao curta | volta ao path/ajusta offset | volta a livre | `ReturningToPath` |
| `11` | na fila | `dt()`, `dv()/dw()` | fila aceita visitante | fica posicionado por indice da fila | embarque em `cQ()` | `Queued` |
| `12` | usando objeto/servico tipo cafeteria/banco | `dp()`, `dj()` | objeto especial `aW=23`/servico | contador de uso, altera necessidade | contador chega ao fim | `UsingService` |
| `13` | dentro da atracao | `cQ()`, `cN()`, `cR()` | embarque/pagamento | fica oculto/preso ao ride | ride termina | `OnRide` |
| `14` | circuito de agua/ride com movimento proprio | `do()`, `di()` | tipo especial `aW=22` | segue dados de caminho internos | fim do percurso | `OnTrackRide` |
| `15` | conflito/panico/interacao negativa | `dk()` | evento social/seguranca | jitter/tempo de estado | contador termina | `Incident` |
| `16` | estado imobilizado/relacionado a incidente | `dk()`, render exclui | evento especial | semelhante a `15`, menos claro | contador termina | `IncidentSecondary` |
| `17` | empregado atendendo/reparando/intervindo | `dl()`, `dk()` | staff encontra alvo, ex. manutencao | vai para alvo e interage | alvo resolvido | `StaffAction` |
| `18` | saindo do parque | `dz()`, `dm()` | dinheiro/necessidades/rota ruim | caminha ate entrada externa | cruza offset externo e remove | `LeavingPark` |

Certeza: alta para `11`, `13`, `18`; media para `7`, `9`, `10`, `12`, `14`, `17`; baixa/media para `15`, `16` por nomes ofuscados e efeitos sociais menos isolados.

---

## 16. Fila de atracoes

Entrada na fila:

- Metodo: `dt()`.
- Condicao: fila menor que 10 e visitante alcançou o ponto de atracao.
- Armazena o visitante em `f[ride_slot][queue_index]`.
- Seta `W[visitor] = 11`.
- Fonte: `dt()` linhas 9542-9562.

Tamanho maximo:

- Maximo 10 visitantes por fila. Fonte: `dt()` linha 9543.

Posicao visual:

- Metodos `dv()` e `dw()` calculam posicionamento/offset de fila. Fonte: referencias em fluxo de fila. Certeza media para detalhes de espacamento exato sem todos os offsets nomeados.

Embarque:

- `cQ()` remove/consome visitantes da fila conforme slots/capacidade, cobra ingresso, incrementa dinheiro do parque `k`, seta `W=13`. Fonte: `cQ()` linhas 8129-8152.

Desembarque:

- `cR()` envia visitantes para `n[ride_slot]` e aplica ganho de satisfacao com penalidade de fila. Fonte: `cR()` linhas 8154-8174.

Adaptacao Godot:

- Implementar fila como lista por atracao com maximo 10.
- Guardar indice de fila para offset visual.
- Embarque deve ocorrer por capacidade `au[aW]`, nao por visitante individual instantaneo.

---

## 17. Economia

Dinheiro do parque:

- Campo `k`, inicializado como `2000`. Fonte: `e.java`, construtor linha 668.
- Construcoes checam dinheiro e subtraem em `ci()`. Fonte: `ci()` linhas 6943/6950.
- Pagamentos de visitantes somam em `k` em `cQ()`, `da()`, `dj()` conforme tipo de atracao/servico. Fonte: `cQ()` linhas 8129-8152 e metodos relacionados.

Dinheiro dos visitantes:

- Array `L[]`, inicializado em `cS()` com `60 +/- 20`. Fonte: `cS()` linhas 8176-8228.
- Reduzido quando paga atracao/servico. Fonte: `cQ()` e metodos de servico.

Custos:

- Atracoes: `az * 10`.
- Servicos/decoracoes: `aI[h[58] + aW]`.
- Empregados: `aI[h[131] + C]`.
- Paths: `aI[h[133] + aW]`.
- Fonte: `cr()` linhas 7277-7286.

Derrota por dinheiro:

- Se `k < -50`, contador cresce e pode disparar `b(13)`/tela de derrota financeira. Fonte: `n()` linhas 1388-1402.

Receita/lucro/estatisticas:

- Graficos/historico usam arrays de estatistica como `c[][]`, `d[]`, `e[]` e metodos de desenho de grafico. Fonte: `a(int,int,int)` linhas 2274-2360 e `dW()/dZ()` save.
- Semantica exata de todos os indices financeiros e **certeza media**; o armazenamento e desenho sao confirmados.

Adaptacao Godot:

- Ajustar dinheiro inicial para 2000 se a meta for fidelidade.
- Usar custo original por categoria.
- Separar dinheiro do visitante de satisfacao/necessidades.

---

## 18. Felicidade / satisfacao / necessidades

Campos:

- `P/Q/R/S/T/U/V[]` sao atributos de visitante.
- `g = {P, Q, R, S, T, U, V, W, L}` permite iterar atributos por indice. Fonte: construtor de `e.java`, inicializacao dos arrays.

Evidencias:

- `cS()` inicializa atributos de visitante com valores aleatorios.
- `cV()` degrada/altera necessidades ao longo do tempo e dispara baloes de pensamento. Fonte: `cV()` linhas 8294-8314.
- `cR()` aumenta `P` apos ride: `P += aA[ride] - b.ap[fila+1]`. Fonte: `cR()` linha 8163. Logo `P` e forte candidato a diversao/felicidade da experiencia da atracao. Certeza media.
- `dp()/dj()/da()` alteram necessidades ao usar servicos. Fonte: metodos de servico/uso.

Necessidades provaveis:

- fome
- sede
- cansaco
- diversao/felicidade
- banheiro/saude
- dinheiro

O mapeamento exato atributo->necessidade ainda e **certeza media/baixa** sem rotular cada indice por todos os baloes/textos. O comportamento de degradacao e uso de servicos e confirmado.

Balões de pensamento:

- Gerados por `e(true)`/rotinas de visitante quando necessidades passam limites. Fonte: `cV()` e chamadas correlatas. Certeza media.

Adaptacao futura:

- Implementar atributos genericos primeiro (`fun`, `hunger`, `thirst`, `fatigue`, `bathroom`, `health`) e manter uma tabela de mapeamento revisavel para os arrays originais.
- So travar nomes definitivos apos cruzar cada servico com o atributo que ele altera.

---

## 19. Servicos

Registros carregados por `v()` de `arrsi.dat`: 27 objetos/servicos/decoracoes. Fonte: `e.java`, `v()` linhas 1625-1654.

Nomes: `aI[h[136]] = [74,74,74,74,75,75,75,75,64,64,76,76,77,65,66,67,67,68,68,69,70,70,66,71,71,72,73]`; indices resolvidos em `text.da4`.

| aW | Tile `b` | Nome | Custo | Footprint | Header `aH,aF,aG` | Comportamento | Certeza |
|---:|---:|---|---:|---|---|---|---|
| 0 | -1 | palmeira | 4 | 1x1 | `[0,1,0]` | decoracao | alta |
| 1 | -2 | palmeira | 4 | 1x1 | `[0,1,0]` | decoracao | alta |
| 2 | -3 | palmeira | 4 | 1x1 | `[0,2,0]` | decoracao | alta |
| 3 | -4 | palmeira | 4 | 1x1 | `[0,2,0]` | decoracao | alta |
| 4 | -5 | palmeiras | 8 | 1x1 | `[0,1,0]` | decoracao | alta |
| 5 | -6 | palmeiras | 8 | 1x1 | `[0,3,0]` | decoracao | alta |
| 6 | -7 | palmeiras | 8 | 1x1 | `[0,3,0]` | decoracao | alta |
| 7 | -8 | palmeiras | 8 | 1x1 | `[0,4,0]` | decoracao | alta |
| 8 | -9 | a\rvore | 10 | 1x1 | `[0,1,0]` | decoracao | alta |
| 9 | -10 | a\rvore | 10 | 1x1 | `[0,1,0]` | decoracao | alta |
| 10 | -11 | arbustos | 4 | 1x1 | `[0,1,0]` | decoracao | alta |
| 11 | -12 | arbustos | 4 | 1x1 | `[0,1,0]` | decoracao | alta |
| 12 | -13 | flores | 10 | 1x1 | `[0,1,0]` | decoracao | alta |
| 13 | -14 | placa | 5 | 1x1 | `[0,1,0]` | decoracao/info | media |
| 14 | -15 | bilheteria | 20 | 1x1 | `[0,1,0]` | servico/entrada visual | media |
| 15 | -16 | bar | 50 | 1x1 | `[8,4,3]` | bebida/comida | media |
| 16 | -17 | bar | 50 | 1x1 | `[8,4,3]` | bebida/comida | media |
| 17 | -18 | sorvete | 30 | 1x1 | `[0,5,0]` | comida | media |
| 18 | -19 | sorvete | 30 | 1x1 | `[0,5,0]` | comida | media |
| 19 | -20 | fonte | 30 | 1x1 | `[4,6,0]` | sede/agua/decor | media |
| 20 | -21 | Banheiro | 20 | 1x1 | `[0,1,0]` | banheiro | alta |
| 21 | -22 | Banheiro | 20 | 1x1 | `[0,1,0]` | banheiro | alta |
| 22 | -23 | bilheteria | 20 | 1x1 | `[0,1,0]` | bilheteria | media |
| 23 | -24 | balo_es | 30 | 1x1 | `[0,1,0]` | loja/servico | media |
| 24 | -25 | balo_es | 30 | 1x1 | `[0,1,0]` | loja/servico | media |
| 25 | -26 | Primeiros socorros | 30 | 1x1 | `[2,1,2]` | saude | alta |
| 26 | -27 | dinomotor | 40 | 2x2 | `[3,7,7]` | servico/gerador especial | media |

Adaptacao Godot:

- Separar decoracoes puras de servicos usados por visitantes.
- Para cada servico, mapear o atributo alterado observando `da()/dj()/dp()` antes de fechar balanceamento.

---

## 20. Funcionarios

Tipos identificados por textos:

- `text.da4[78]`: guarda
- `text.da4[79]`: mantimentos
- `text.da4[80]`: cozinheiro
- `text.da4[81]`: vendedor
- `text.da4[82]`: medico
- `text.da4[83]`: montador de dinossauro
- Fonte: `aI[h[137]] = [78,79,80,81,82,83]` e `text.da4`.

Contratacao/custo:

- Categoria `aX == 2`.
- Custo lido de `aI[h[131] + C]`. Fonte: `cr()` linha 7283.
- `cj()` cria/posiciona empregado. Fonte: `cc()` chama `cj()` para `aX == 2`.

Movimento/interacao:

- Funcionarios compartilham arrays de entidade com visitantes (`A/B/C/D/E/F/G/H/I/W`), mas `A[]` distingue tipo. Certeza media.
- Manutencao: `dl()` verifica empregado com `A == 9`, atracao com `ah <= 50`, seta `W = 17` e `ai[ride] = 2`. Fonte: `dl()` linhas 8861-8872. Certeza alta para existencia de reparo; media para nome exato do tipo.
- Medico/seguranca/vendedor aparecem em textos e headers, mas as rotinas completas de cada profissao seguem ofuscadas. Certeza media/baixa para comportamento detalhado.

Adaptacao Godot:

- Implementar inicialmente manutencao como staff autonomo que procura rides com condicao baixa.
- Deixar seguranca/medico/vendedores para depois de mapear estados `15/16/17` com mais seguranca.

---

## 21. Atracoes quebrando / manutencao

Campos:

| Campo | Papel | Evidencia | Certeza |
|---|---|---|---|
| `ah[ride]` | condicao/saude da atracao | inicializa 100 em `ce()`; reduz em `cR()` | alta |
| `ai[ride]` | estado de manutencao/reparo | `dl()` seta `ai = 2` ao designar staff | media |
| `ag/af/ae/ab` | timers/frames de ride | usados em `cN()` e render | media |

Quebra/desgaste:

- `ce()` inicializa `ah[slot] = 100`. Fonte: `ce()` linha 6837.
- `cR()` reduz condicao apos uso, usando dificuldade/parametro `ay[ride]`. Fonte: `cR()` linha 8173.
- Visitantes evitam atracao se `ah < 10`. Fonte: `h()` linha 9303 e `dm()` linhas 8911-8915.

Reparo:

- `dl()` procura atracoes com `ah <= 50` e designa empregado, setando `W = 17` e `ai = 2`. Fonte: `dl()` linhas 8861-8872.

Efeito nos visitantes/economia:

- Atracao com condicao baixa deixa de aceitar visitantes. Fonte: `h()`.
- Avisos em `warntext.da4` incluem mensagens sobre atracao quebrada/manutencao. Certeza media para todos os textos exatos.

Adaptacao Godot:

- Adicionar `condition` por ride, desgaste ao final de cada ciclo, bloqueio abaixo de 10 e tarefas de reparo abaixo de 50.

---

## 22. Estatisticas e graficos

Existem estatisticas financeiras, felicidade/necessidades, visitantes, objetivos de campanha e historico.

Evidencias:

- `R = 26` desenha telas de estatistica/grafico. Fonte: `L()` linhas 2018-2098.
- Metodo `a(int,int,int)` desenha graficos/linhas usando arrays historicos. Fonte: linhas 2274-2360.
- Save `dW()/dZ()` armazena historico, progresso, medias e arrays de estatisticas. Fonte: linhas 10485-10970.
- `d.k[4]` aparece como tamanho de historico mensal/periodico. Fonte: `d.java` e inicializacoes de arrays em `e.java`.

Menus relacionados:

- `warntext.da4[26]`: `estati\sticas`.
- `R=26`: painel de estatisticas.

Adaptacao Godot:

- v0.2 nao precisa graficos completos.
- Guardar desde cedo series simples: dinheiro, visitantes ativos, felicidade media, receita/despesa, para nao migrar save depois.

---

## 23. Campanha, objetivos e progressao

Modos:

- `K == 0`: modo livre, `O = 30`. Fonte: `h()` linhas 1041-1077.
- Campanha: `O = aI[h[134] + L]`, com tamanhos por nivel `[12,15,20,25,25,30]`. Fonte: `h()` e `aI[134]`.

Objetivos/progresso:

- `q()` desenha/atualiza tela de objetivo/progresso. Fonte: `q()` linhas 1524-1540.
- `n()` verifica condicoes de vitoria/derrota e chama `b(12)`, `b(13)`, `b(24)`, `b(25)` conforme resultado/progresso. Fonte: `n()` linhas 1388-1458.
- `dT()/dU()` salvam progresso/opcoes em `pssav`. Fonte: linhas 10426-10483.

Desbloqueios:

- Arrays `i[]`, `E..J`, `L`, `K` participam de progresso/unlocks. Fonte: `dT()/dU()/dZ()/ef()`. Certeza media para significado individual.

Adaptacao Godot:

- Separar modo livre de campanha.
- Para campanha, respeitar tamanho de mapa por fase e salvar progresso separado de save do parque.

---

## 24. Save/load original

RecordStores:

| Store | Uso | Evidencia | Certeza |
|---|---|---|---|
| `pssav` | progresso/opcoes globais | `dT()/dU()` | alta |
| `pCuSav` | save de parque no modo livre | `dV()` | alta |
| `pCaSav` | save de campanha | `dV()` | alta |

Metodos:

- `dT()`: salva progresso/opcoes globais.
- `dU()`: carrega progresso/opcoes.
- `dV()`: salva parque, escolhendo RecordStore.
- `dW()`: escreve estado global, mapa `b/c`, economia, tempo e historicos.
- `dX()`: escreve entidades/visitantes/empregados.
- `dY()`: escreve atracoes, objetos, orientacoes, timers, condicao e origem.
- `dZ()`: escreve desbloqueios, empregados/precos/medias.
- `ea()`..`ef()`: carregam blocos e reconstroem estados.
- Fonte: `e.java` linhas 10426-10970.

Compactacao:

- Helpers `a(...)` e `b(...)` fazem bit packing com largura variavel e bias. Fonte: `e.java` linhas 10359-10421.

Blocos salvos:

- mapa `b[30][30]` e `c[30][30]`
- visitantes/entidades: posicoes, offsets, estado `W`, dinheiro/necessidades
- atracoes: `Z`, orientacao `aa`, timers, condicao `ah`, estados, origens `l/m/n`
- dinheiro/tempo/progresso
- estatisticas/historico
- empregados/precos

Adaptacao Godot:

- Nao replicar RecordStore/bit packing; criar save JSON/binario proprio.
- Manter os mesmos campos logicos para permitir comparacao com o JAR.

---

## 25. Assets e gpack

Loader:

- `b()` carrega `/gpack0.dat`..`/gpack3.dat`.
- Cada imagem tem tamanho little-endian e vira `Image.createImage`.
- Arrays:
  - `a[]` recebe gpack0, 11 imagens.
  - `b[]` recebe gpack1, 13 slots; um indice e pulado/aliasado (`b[7] = a[10]`).
  - `c[]` recebe gpack2, 6 imagens.
  - `d[]` recebe gpack3, 6 imagens.
- Fonte: `e.java`, `b()` linhas 859-890.

Dimensoes dos PNGs extraidos:

| gpack | Imagens | Uso provavel | Evidencia |
|---|---:|---|---|
| gpack0 | 11 | visitantes/empregados/personagens e um sprite aliasado | dimensoes 28-30 px largura, alturas altas; usado por render de entidades | alta |
| gpack1 | 12 + slot alias | atracoes, path, entrada, objetos grandes | `F()`, `aD/aE/aF`, entrada | alta |
| gpack2 | 6 | terreno, icones/tiles e alguns elementos UI | `G()` usa `gpack2_000` | alta |
| gpack3 | 6 | UI/fonte/fundos/menus | metodos de texto/UI usam `d[]` | media |

Sprites principais confirmados:

| PNG | Dimensao | Uso | Recorte | Fonte |
|---|---:|---|---|---|
| `gpack2_000.png` | 38x60 | grama 1..3 | `(0,0/20/40,38,20)` | `G()` |
| `gpack1_002.png` | 125x124 | path base e WELCOME | `(0,104,38,20)`, `(38,104,38,20)`, tabelas `R..W` | `F()`, `b.java` |
| `gpack1_006.png` | 112x124 | pedras/entrada | `(0,112,15,12)` | `aw()`/tabelas |
| `gpack1_001.png` | 74x45 | partes do Balanco | varios recortes | `aE()/aF()` |
| `gpack1_000.png` | 64x132 | parte do Balanco e rides | `(3,37,22,13)` | `aE()` |

Imagens ainda desconhecidas:

- Varios recortes de `gpack1` e `gpack3` dependem de chunks de `arr.dat` e rotinas de UI ainda sem nome visual. Eles devem ser catalogados conforme cada atracao/menu for portado.

---

## 26. Textos/localizacao

Arquivos:

- `text.da4`: portugues principal, 115 entradas.
- `warntext.da4`: avisos, categorias e mensagens curtas.
- `helptext.da4`: ajuda/tutorial.

Evidencia de idioma: nomes como `roda gigante`, `atrac[o_es`, `Caminho`, `Primeiros socorros`.

Indices importantes:

| Indice | Texto | Uso |
|---:|---|---|
| 42 | roda gigante | atracao aW 0 |
| 48 | balanc[o | atracao aW 6 |
| 61 | montanha russa | atracao aW 21 |
| 63 | cafeteria | atracao/servico especial aW 23 |
| 70 | Banheiro | servico |
| 72 | Primeiros socorros | servico |
| 78-83 | empregados | staff |
| 90 | Caminho de cascalho | path |
| 91 | Caminho de pedra | path |
| 92 | a\gua | path/agua |
| 93 | banco | path/objeto |
| 105 | mont. russa me\dia | atracao aW 20 |
| 106 | Ursa Maior | atracao aW 19 |

Categorias em `warntext.da4`:

| Indice | Texto |
|---:|---|
| 23 | Caminho |
| 24 | atrac[o_es |
| 25 | servicos |
| 26 | estati\sticas |
| 27 | Empregados |
| 28 | decorac[o_es |
| 29 | demolic[a_o |

Adaptacao Godot:

- Usar `text.da4` como fonte canonica para nomes originais.
- Preservar escapes/acentos normalizados apenas na camada de exibicao.

---

## 27. Audio

Classe:

- `prehistoric_vineflower/a.java`.

Comportamento:

- Cria `Player` com `Manager.createPlayer("/sound/" + file, mime)`.
- Usa `VolumeControl` se disponivel.
- Volume: metodo `a(int)` aplica `level = valor * 50`.
- `e.a()` cria `new a("entry.mid", "audio/midi")`. Fonte: `e.java` linha 838.
- `Park.pauseApp()`/retorno param/retomada recriam ou param audio conforme estado. Fonte: `Park.java`, `e.d()/e.e()/e.f()` e `a.java`.

Arquivos MIDI:

- `entry.mid` confirmado por codigo.
- Outros MIDIs podem existir em `/sound/`, mas nao foram rotulados neste documento sem evidencia direta.

Adaptacao Godot:

- Reproduzir `entry.mid` como musica de entrada/menu se o arquivo estiver convertido/importado.
- Volume deve ser escala propria do Godot; manter opcao de mute/volume separada.

---

## 28. Renderizacao geral

Ordem macro:

1. Redraw do mundo estatico quando `aa != 0`: `x()`.
2. Copia buffer base para tela.
3. Gameplay:
   - `l()` desenha/atualiza cursor/camera/elementos do mundo.
   - `m()` desenha entidades/objetos dinamicos.
   - `n()` processa checks de vitoria/derrota/eventos e overlays.
4. Menus/telas: `o()`.
5. UI final e flush: `p()`.

Fonte: `run()` e `p()`.

Camadas:

- Terreno: `G()`.
- Path: `F()`.
- Objetos negativos/servicos: `H()`.
- Entrada/externo: `I()`, `J()`, `aw()`.
- Atracoes: `am()`, `ai()`, `aD()`, `aE()`, `aF()`, `aG()`, `aH()`.
- Visitantes/empregados: render de entidades chamado pela varredura, com sprites de `gpack0`.
- UI/HUD/menus: `ar()`, `cF()`, `dP()`, `aq()`, `L()`, `Q()`, `S()`, `T()`.

Popups:

- Dinheiro/pagamentos usam `dM()` e aparecem como textos temporarios. Fonte: chamadas em `cQ()`/`ci()`.

Adaptacao Godot:

- Separar TileMap/Node2D em camadas, mas ordenar objetos altos por ponto-base isometrico.
- A renderizacao das atracoes deve seguir chunks/camadas, nao apenas um sprite unico por building.

---

## 29. UI e menus

HUD:

- Dinheiro, indicadores, calendario/tempo e softkeys sao desenhados no fim do frame por `p()`, `ar()`, `cF()`, `dP()`, `aq()`. Fonte: `p()` linhas 1501-1513.

Menu radial/construcao:

- Categorias vêm dos textos em `warntext.da4`.
- `aX/aW` controlam categoria/item.
- `cp()/cq()/cr()` atualizam nome, custo e ajuda.
- `ct()/cs()` calculam footprint.
- Fonte: `cp()`..`ct()` linhas 7185-7355.

Painel de item/atracao:

- `b == 3`, `R` e `L()` controlam telas. Fonte: `b(int)`, `L()`.
- Pausa em `R=16`.
- Estatisticas em `R=26`.

Softkeys:

- Soft esquerda/direita mapeadas para `n=-6` e `n=-7`. Fonte: `keyPressed()`.

Adaptacao mouse/touch:

- Soft esquerda pode virar botao primario/contextual; soft direita, cancelar/voltar.
- Direcionais viram pan/cursor; confirmar vira clique/acao.
- Manter o conceito de categoria/item/preview/confirmacao para preservar fluxo.

---

## 30. Comparacao com o estado atual do Godot

Arquivos lidos:

- `godot_project/scripts/iso_map.gd`
- `godot_project/scripts/build_system.gd`
- `godot_project/scripts/visitor_system.gd`
- `godot_project/scripts/park_controller.gd`
- `godot_project/autoload/game_state.gd`
- `godot_project/autoload/catalog.gd`
- `godot_project/data/buildings.json`
- `godot_project/data/balance.json`

Ja fiel:

- Mapa 30x30 e tile 40x20 estao alinhados ao JAR.
- Grama usa `gpack2_000` com recortes verticais de 38x20.
- Path base usa `gpack1_002` em regioes `(0,104,38,20)` e `(38,104,38,20)`.
- Entrada/borda ja usa alguns recortes originais.
- Visitantes ja usam sprites extraidos de `gpack0` parcialmente.

Parcialmente fiel:

- Formula isometrica basica esta proxima, mas falta reproduzir camera/viewport e varredura de profundidade do JAR.
- Sistema de path existe, mas ainda nao representa fielmente `c[][]`, `c/4`, `c&1`, `c&2`.
- Construcoes existem, mas sem catalogo original, chunks de footprint e slots de ride.
- Visitantes caminham por path, mas usam logica simplificada, sem maquina `W`, dinheiro individual, necessidades reais, fila e ride cycle.

Errado em relacao ao JAR:

- Path inicial atual em Godot aparece como `(15,1)`; o JAR coloca o path jogavel inicial em `(ab,0)`.
- Dinheiro inicial atual difere do JAR se estiver em 1000; original inicializa `k = 2000`.
- Balanco/atracoes placeholders nao correspondem: Balanco original e `aW=6`, custo 30, footprint 3x3, capacidade 2.
- Economia de atracao simplificada nao corresponde ao pagamento/embarque por `cQ()` e satisfacao por `cR()`.

O que falta:

- Catalogo original completo.
- Footprints orientados de `arr.dat`.
- WELCOME/entrada como elemento externo fiel.
- Visitantes com estados `W`.
- Filas reais.
- Manutencao/quebra.
- Servicos e necessidades.
- Campanha/objetivos/save.
- UI J2ME adaptada para mouse/touch.

Riscos atuais:

- Construir mais sistemas sobre coordenada de entrada errada vai espalhar divergencia.
- Se o Godot continuar com buildings simplificados, sprites/footprints originais exigirao retrabalho.
- Visitantes simplificados podem esconder bugs de path/queue ate tarde.

Prioridades v0.2:

1. Corrigir modelo de mapa/entrada/path inicial.
2. Implementar Balanco fiel como primeira atracao real.
3. Implementar visitante minimo com `W=-1`, `11`, `13`, `18`.
4. Trocar custos/footprints para dados originais.

---

## 31. Plano recomendado de implementacao

### v0.2

Objetivo: primeira fatia fiel jogavel.

Implementar:

- Entrada `(ab,0)` e estrada externa.
- Path `b=0`, `c/4` e protecao da entrada.
- Balanco `aW=6` com custo 30, footprint 3x3, sprite/camadas principais.
- Fila max 10 e ciclo simples de embarque/uso/desembarque.
- Dinheiro inicial 2000.

Nao mexer ainda:

- Campanha.
- Graficos.
- Todos os servicos.
- Todos os empregados.

Riscos:

- Profundidade de sprites altos.
- Offsets animados do Balanco.

Dependencias:

- Tabelas extraidas de `arr.dat`/`arrsi.dat`.

### v0.3

Objetivo: visitantes e economia mais proximos do original.

Implementar:

- Maquina `W` basica: `-1`, `7`, `9`, `11`, `13`, `18`.
- Dinheiro individual `L`.
- Necessidade/felicidade inicial, satisfacao por ride.
- Mais 3-5 atracoes pequenas.

Nao mexer ainda:

- Manutencao completa.
- Campanha.

Riscos:

- Path decision e conectores de footprints.

### v0.4

Objetivo: servicos e manutencao.

Implementar:

- Bar, sorvete, banheiro, primeiros socorros.
- Atributos de necessidades com baloes.
- Condicao `ah`, desgaste, bloqueio abaixo de 10.
- Empregado de manutencao.

Nao mexer ainda:

- Todos os graficos historicos.

Riscos:

- Mapear exatamente cada atributo `P/Q/R/S/T/U/V`.

### v0.5

Objetivo: campanha e UI de gerenciamento.

Implementar:

- Modo livre/campanha.
- Tamanhos de mapa por fase.
- Objetivos basicos.
- Painel de estatisticas inicial.
- Save/load Godot com campos equivalentes.

Nao mexer ainda:

- Compatibilidade binaria com RecordStore original.

Riscos:

- Desbloqueios e textos de ajuda.

### v1.0

Objetivo: paridade funcional ampla.

Implementar:

- Catalogo completo de atracoes/servicos/decoracoes.
- Empregados completos.
- Quebras, incidentes, seguranca/medico.
- UI final adaptada a PC/mobile.
- Audio e menus completos.
- Balanceamento revisado contra JAR.

Riscos:

- Muitos detalhes visuais por chunks.
- Estados raros de visitantes/staff.

---

## 32. Tabelas finais obrigatorias

### Tabela A - Campos importantes do JAR

| Campo | Tipo | Significado provavel | Certeza | Equivalente no Godot |
|---|---|---|---|---|
| `b` | `int` | modo/tela principal | alta | `GameState.mode`/controller state |
| `R` | `int` | subestado de painel/menu | alta | `ui_panel_state` |
| `O` | `int` | tamanho ativo do mapa | alta | `map_size` |
| `ab` | `int` | x da entrada | alta | `entry_x` |
| `b[][]` | `byte[30][30]` | tipo de tile/ocupacao | alta | tile type grid |
| `c[][]` | `byte[30][30]` | path meta/dono/lista | alta | tile metadata grid |
| `f[4][2]` | `int[][]` | limites visiveis | media | visible bounds |
| `aX` | `int` | categoria de construcao | alta | build category |
| `aW` | `int` | item selecionado | alta | selected catalog id |
| `B/C` | `int` | footprint preview | alta | footprint size |
| `at` | `int` | orientacao | alta | rotation/orientation |
| `k` | `int` | dinheiro do parque | alta | `Economy.cash` |
| `A[]` | `byte[]` | tipo/skin entidade | media | visitor/staff kind |
| `B[]/C[]` | `byte[]` | tile atual entidade | alta | entity tile |
| `D[]/E[]` | `byte[]` | tile alvo entidade | alta | entity target tile |
| `F[]` | `byte[]` | direcao | alta | direction |
| `G[]/H[]` | `byte[]` | offset visual | alta | local offset |
| `I[]` | `byte[]` | velocidade | media | speed |
| `J[]` | `byte[]` | frame animacao | media | animation frame |
| `W[]` | `byte[]` | estado visitante/staff | alta | state enum |
| `L[]` | `byte[]` | dinheiro visitante | alta | visitor.cash |
| `P..V[]` | `byte[]` | necessidades/satisfacao | media | visitor needs |
| `Z[]` | `byte[]` | tipo da atracao por slot | alta | building.catalog_id |
| `aa[]` | `byte[]` | orientacao da atracao | alta | building.rotation |
| `l[][]` | `byte[][]` | origem da atracao | alta | building.origin |
| `m[][]` | `byte[][]` | ponto de embarque/load | media | building.load_tile |
| `n[][]` | `byte[][]` | ponto de saida | media | building.exit_tile |
| `ah[]` | `byte[]` | condicao da atracao | alta | building.condition |
| `ai[]` | `byte[]` | estado manutencao | media | maintenance_state |
| `f[][]` | `byte/int[][]` | fila por ride, em contexto de ride | alta | ride.queue |
| `aI[]/h[]` | `byte/int[]` | tabelas globais de dados/texto | alta | decoded data tables |
| `o[][]/g[][]` | `byte[][]/int[][]` | chunks de atracao/offsets | alta | ride sprite/footprint data |
| `p[][]/h[][]` | `byte[][]/int[][]` | chunks de servico/offsets | alta | service sprite data |

### Tabela B - Metodos importantes

| Metodo | Funcao | Campos usados | Certeza | Equivalente Godot |
|---|---|---|---|---|
| `Park.startApp()` | inicia splash e timer | `Display`, `c`, `f` | alta | app bootstrap |
| `f.run()` | troca splash por jogo | `new e(Park)` | alta | load scene |
| `e.a()` | carrega recursos e inicia thread | gpack, arr, textos, saves | alta | initialization |
| `b()` | carrega gpack | `a/b/c/d` imagens | alta | asset loader |
| `u()` | carrega catalogo de atracoes | `am..aC`, `o/g` | alta | ride catalog loader |
| `v()` | carrega servicos | `aH/aF/aG`, `p/h` | alta | service catalog |
| `w()` | carrega `aI` global | `aI/h` | alta | data table loader |
| `run()` | loop principal | `aS,k,l,m,n,o,p` | alta | `_process`/tick |
| `p()` | UI final e flush | HUD/UI | alta | render UI |
| `h()/i()/g()` | setup de mapa e novo jogo | `O,ab,b,c` | alta | new game |
| `F()` | desenha path | `b[][], c[][], b[2]` | alta | draw path |
| `G()` | desenha grama | `b[][], c[0]` | alta | draw terrain |
| `H()` | desenha objetos negativos | `b[][], aI` | alta | draw services/decor |
| `I()/J()` | desenha externo/borda | coords virtuais | alta | draw border/entrance |
| `al()` | varredura isometrica | visible bounds | alta | draw order pass |
| `am()/ai()` | despacha desenho de atracao | `Z, c, chunks` | alta | building renderer |
| `aD()` | desenha linhas/cordas | chunk 20 | alta | ride ropes |
| `aE()` | desenha pecas estaticas | chunks 5-11 | alta | ride static layers |
| `aF()` | desenha pecas animadas | chunks 12-18 | alta | ride animation |
| `keyPressed()` | converte tecla em `n` | `n,q,aN` | alta | input mapper |
| `cp()/cq()/cr()/ct()` | prepara item de build | `aX,aW,B,C,at` | alta | build preview |
| `cc()` | confirma construcao | `aX` | alta | place selected |
| `cd()/ce()` | cria atracao/footprint | `Z,aa,l,m,n,b,c` | alta | place ride |
| `cf()/cg()` | cria servico/decor | `b,c,p` | media | place service |
| `ch()` | cria path | `b,c,aW` | alta | place path |
| `bX()/bZ()/ca()` | demolicao | mapa/buildings | alta | demolish |
| `cS()` | spawn visitante | arrays visitantes | alta | spawn visitor |
| `cU()` | update visitantes | `W[]`, needs | alta | update visitors |
| `cV()` | necessidades/timers | `P..V` | media | update needs |
| `dr()` | decisao de visitante | path/needs | media | AI decision |
| `dt()` | entrar na fila | `f[][], W` | alta | enqueue |
| `cQ()` | embarque/pagamento | `k,L,W` | alta | board ride |
| `cR()` | desembarque/satisfacao | `P,ah,n` | alta | finish ride |
| `dz()/dm()` | decisao e saida do parque | `W=18` | alta | leave park |
| `dT()`..`ef()` | save/load | RecordStore | alta | save system |

### Tabela C - Sprites importantes

| gpack | Arquivo | Recorte | Uso | Metodo | Certeza |
|---|---|---|---|---|---|
| gpack2 | `gpack2_000.png` | `(0,0,38,20)` | grama variante 1 | `G()` | alta |
| gpack2 | `gpack2_000.png` | `(0,20,38,20)` | grama variante 2 | `G()` | alta |
| gpack2 | `gpack2_000.png` | `(0,40,38,20)` | grama variante 3 | `G()` | alta |
| gpack1 | `gpack1_002.png` | `(0,104,38,20)` | path base variante 0 | `F()`/`b.O/P` | alta |
| gpack1 | `gpack1_002.png` | `(38,104,38,20)` | path base variante 1 | `F()`/`b.O/P` | alta |
| gpack1 | `gpack1_006.png` | `(0,112,15,12)` | entrada/pedras | `aw()` | alta |
| gpack1 | `gpack1_002.png` | `b.R/S/T/U` | placa WELCOME | `aw()` | alta |
| gpack1 | `gpack1_001.png` | `(66,0,8,25)` | Balanco estatico | `aE()` | alta |
| gpack1 | `gpack1_001.png` | `(67,19,7,25)` | Balanco estatico | `aE()` | alta |
| gpack1 | `gpack1_000.png` | `(3,37,22,13)` | Balanco estatico | `aE()` | alta |
| gpack1 | `gpack1_001.png` | `(4,0,16,12)` | assento animado do Balanco | `aF()` | alta |
| gpack0 | `gpack0_*.png` | varios | visitantes/empregados | render de entidades | media |
| gpack3 | `gpack3_*.png` | varios | UI/fonte/menus | metodos UI/texto | media |

### Tabela D - Estados de jogo

| Estado | Significado | Metodo | Adaptacao Godot |
|---:|---|---|---|
| `b=0` | gameplay/parque rodando | `run()` chama `l/m/n` | `PLAYING` |
| `b=1` | overlay/menu especial | `o()->S()` | `OVERLAY` |
| `b=2` | construcao/preview | `o()->ak()` | `BUILD_MODE` |
| `b=3` | painel/tela/dialogo | `o()->L()` | `PANEL` |
| `b=4` | minimapa/tela especial | `o()->T()` | `MINIMAP` |
| `b=5` | ajuda/tutorial | `o()->E/Q` | `HELP` |
| `R=16` | pausa | `e()/f()` | `PAUSE_MENU` |
| `R=26` | estatisticas | `L()` | `STATS_PANEL` |
| `R=13` | derrota financeira | `n()` | `GAME_OVER_MONEY` |
| `R=12` | vitoria/progresso | `n()` | `VICTORY/GOAL` |

### Tabela E - Estados de visitante

| `W` | Significado | Metodo | Adaptacao Godot |
|---:|---|---|---|
| `-1` | andando/livre | `dr()/l()` | `Walking` |
| `7` | entrando em construcao | `h()/de()` | `EnteringBuilding` |
| `9` | aproximando fila/load | `do()/df()` | `ApproachingQueue` |
| `10` | retornando ao path | `c()/dg()` | `ReturningToPath` |
| `11` | na fila | `dt()` | `Queued` |
| `12` | usando servico/objeto | `dp()/dj()` | `UsingService` |
| `13` | dentro da atracao | `cQ()/cR()` | `OnRide` |
| `14` | ride especial com percurso | `do()/di()` | `OnTrackRide` |
| `15` | incidente/conflito | `dk()` | `Incident` |
| `16` | incidente secundario/imobilizado | `dk()` | `IncidentSecondary` |
| `17` | empregado intervindo/reparando | `dl()` | `StaffAction` |
| `18` | saindo do parque | `dz()/dm()` | `LeavingPark` |

### Tabela F - Atracoes identificadas

| Nome | Indice `aW` | Custo | Footprint | Sprite | Duracao | Entrada/saida | Certeza |
|---|---:|---:|---|---|---:|---|---|
| balanc[o | 6 | 30 | 3x3 | chunks ride 6, `gpack1_000/001` | 61 | chunk 37 valores 5/6/7/8/10 | alta/media |
| roda gigante | 0 | 400 | 3x3 | chunks ride 0 | 97 | chunk 37 | alta/media |
| torre | 1 | 180 | 3x3 | chunks ride 1 | 61 | chunk 37 | alta/media |
| torre grande | 2 | 600 | 3x3 | chunks ride 2 | 96 | chunk 37 | alta/media |
| bungee jump grande | 3 | 450 | 3x4 | chunks ride 3 | 92 | chunk 37 | alta/media |
| bungee jump | 4 | 150 | 3x3 | chunks ride 4 | 81 | chunk 37 | alta/media |
| caverna do terror | 5 | 100 | 3x3 | chunks ride 5 | 61 | chunk 37 | alta/media |
| Salto de a\gua | 7 | 150 | 4x3 | chunks ride 7 | 66 | chunk 37 | alta/media |
| Salto tramp. | 8 | 120 | 5x3 | chunks ride 8 | 56 | chunk 37 | alta/media |
| Tobogan aqua\t. | 9 | 200 | 5x3 | chunks ride 9 | 70 | chunk 37 | alta/media |
| Tobogan | 10 | 120 | 5x3 | chunks ride 10 | 69 | chunk 37 | alta/media |
| trampolin | 11 | 40 | 3x3 | chunks ride 11 | 81 | chunk 37 | alta/media |
| gira-gira | 12 | 100 | 3x3 | chunks ride 12 | 85 | chunk 37 | alta/media |
| gira-gira grande | 13 | 300 | 3x3 | chunks ride 13 | 85 | chunk 37 | alta/media |
| Gangorra | 14 | 60 | 4x3 | chunks ride 14 | 65 | chunk 37 | alta/media |
| Salto Grande | 15 | 200 | 5x3 | chunks ride 15 | 62 | chunk 37 | alta/media |
| banho de a\gua | 16 | 150 | 5x4 | chunks ride 16 | 55 | chunk 37 | alta/media |
| Campo de tiro | 17 | 60 | 5x4 | chunks ride 17 | 59 | chunk 37 | alta/media |
| catapulta | 18 | 450 | 3x4 | chunks ride 18 | 84 | chunk 37 | alta/media |
| Ursa Maior | 19 | 900 | 5x8 | chunks ride 19 | 105 | chunk 37 | alta/media |
| mont. russa me\dia | 20 | 750 | 4x6 | chunks ride 20 | 55 | chunk 37 | alta/media |
| montanha russa | 21 | 600 | 4x5 | chunks ride 21 | 53 | chunk 37 | alta/media |
| Circuito de a\gua | 22 | 70 | 2x2 | chunks ride 22 | 0 | percurso especial | alta/media |
| cafeteria | 23 | 150 | 2x3 | chunks ride 23 | 11 | uso/servico especial | alta/media |

---

## 33. Regras de qualidade aplicadas

- Nao foram alterados arquivos do projeto Godot.
- O unico arquivo criado por esta tarefa e este documento: `docs/JAR_FULL_ANALYSIS.md`.
- Fatos confirmados foram ligados a metodo/campo/array/arquivo/indice/recorte.
- Hipoteses foram marcadas com certeza media ou baixa.
- Vineflower foi usado como fonte principal.
- CFR foi tratado apenas como comparacao auxiliar; nenhum conflito relevante foi identificado nas areas verificadas.
- Quando uma area segue ofuscada demais para nome seguro, o documento preserva o dado tecnico e evita inventar semantica.
