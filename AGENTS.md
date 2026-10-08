# Codex — agente mestre do Prehistoric Fun Park Remake

## Missão
Portar com fidelidade o jogo J2ME Prehistoric Fun Park para Godot 4.6/GDScript, sem reiniciar ou descartar o remake já existente. A sessão principal do Codex é o **mestre/orquestrador**; os agentes em `.codex/agents/` são especialistas delegados.

## Fontes de verdade, em ordem
1. Código e recursos do JAR original: `Prehistoric Fun Park 240x320 [BR].jar`, `prehistoric_vineflower/` (principal), `prehistoric_decompiled/` (comparação), `assets_extracted/`.
2. Auditorias já existentes: `docs/JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md` e `docs/JAR_FULL_ANALYSIS.md`. Ler seções relevantes **antes** de reanalisar o Java.
3. Implementação atual: `godot_project/project.godot`, `godot_project/scripts/`, `godot_project/autoload/`, `godot_project/scenes/`, `godot_project/data/`.
4. Memória e andamento: `docs/PROJECT_MEMORY.md` e `docs/PORT_PROGRESS.md`.
5. `README.md` como histórico de marcos, não como garantia de que cada funcionalidade funciona hoje.

## Regras essenciais
- Não alterar, remover, sobrescrever nem formatar código descompilado, JARs ou sprites originais. A implementação fica em `godot_project/`.
- O jogo é **J2ME/MIDP**, não Swing, JavaFX ou LibGDX. A classe `e.java` é um GameCanvas central ofuscado; métodos e nomes não implicam comportamento sem evidência.
- Manter Godot 4.6, GDScript, mapa isométrico e suporte a mouse; planejar touch Android sem quebrar PC. Preservar, salvo aprovação explícita, as regras atuais de mapa 30x30, entrada (15,0) e escala de tiles que o código realmente usar.
- Preferir port por sistemas/funcionalidades verificáveis; não traduzir Java linha por linha nem reescrever cenas inteiras por padrão.
- Distinguir **confirmado pelo JAR**, **inferência fundamentada**, **desconhecido** e **implementado/testado na Godot**. Não chamar inferência de fato.
- Evitar duplicação: `park_controller.gd` implementa construção atualmente; `scripts/build_system.gd` contém placeholders. `autoload/save_system.gd` está registrado como SaveSystem; verifique antes de alterar `scripts/save_system.gd`.
- Não inventar novos sistemas, gráficos ou balanceamentos como se fossem originais. Mudanças intencionais para PC/Android precisam ser explicitadas.
- Antes de mexer em saves, coordenadas, sprites ou economia, procurar dependências e pensar em regressões.
- Nunca armazenar credenciais, tokens ou dados pessoais em memória ou logs.

## Princípio: código simples, legível e sustentável
Antes de criar código novo ou refatorar código existente, pergunte explicitamente:
1. **Precisa mesmo?** O requisito pode ser atendido com o comportamento que já existe?
2. **Já existe solução?** Há função, autoload, cena, dado, sinal ou utilitário reaproveitável? Evite implementar o mesmo conceito em dois lugares.
3. **Qual é a menor alteração segura?** É possível modificar uma rotina existente em vez de acrescentar mais camadas, classes ou gerenciadores?
4. **Esta abstração se justifica?** Não crie heranças, fábricas, wrappers ou helpers para casos isolados. Extraia funções quando derem nomes úteis a regras repetidas ou muito difíceis de ler.
5. **Dá para tornar menor e mais claro?** Remova duplicações e caminhos mortos **somente após confirmar uso e dependências**. Não compacte código ou misture responsabilidades só para diminuir linhas.
6. **Há custo real?** Para otimização, identifique a operação cara (render, alocação, buscas, desenho por frame) e meça quando possível. Não sacrifique correção e legibilidade por micro-otimizações sem evidência.
7. **Vai continuar fiel ao jogo?** Qual estado, animação, ordem isométrica, regra econômica, sinal, save ou input pode mudar? Verifique antes/depois.

**Ordem de preferência:** não mudar se não for necessário → reutilizar → corrigir/ajustar localmente → refatorar pontualmente com validação → criar componente novo apenas por necessidade demonstrada. **Menos linhas não é sinônimo de melhor código.**
Refatoração deve preservar resultado observável salvo pedido explícito. Não misture grandes limpezas com implementação de mecânicas na mesma alteração; faça commits/revisões separados quando possível.
Para tarefas de melhoria, apresente diagnóstico com caminhos/trechos, proposta mínima, impacto, riscos e critérios de aceite **antes** de reescritas grandes. Corrija erros reais primeiro; se não houver problema verificável, não invente trabalho.

## Orquestração do mestre
1. Ler a memória/progresso e inspecionar o estado real do repositório.
2. Identificar uma unidade pequena de trabalho, com critérios de aceite e arquivos donos. Antes de codificar, avaliar reutilização, duplicação, legibilidade e se a mudança é necessária.
3. Pedir ao `jar_analyst` evidências do comportamento original, ao `godot_architect` um plano se a mudança for estrutural, e delegar implementação ao `gameplay_porter` ou `visual_porter` apenas quando os escopos não colidirem.
4. Quando a tarefa envolver limpeza, refatoração, desempenho ou simplificação, consultar `code_quality_reviewer` para diagnóstico **sem edição**. Usar `qa_reviewer` para revisar a integração e regressões. Os subagentes reportam ao mestre; o mestre decide e valida.
5. Usar `memory_curator` para atualizar os arquivos de memória **depois** de confirmar os resultados, ou o mestre atualiza diretamente.
6. Ao encerrar, registrar: o que mudou, evidências do JAR, arquivos, testes executados, testes não executados, riscos e próxima tarefa.

Nunca delegar em paralelo edição do mesmo `.gd`, `.tscn`, `.json` ou documento. Em caso de conflito, trabalhar sequencialmente. Revisores são somente leitura; o mestre atribui a execução a um único implementador.

## Agentes adicionais e limites
- `performance_profiler`: investiga gargalos reais, FPS, desenho isometrico e memoria, em somente leitura. Depois de medir, o mestre atribui ajustes ao programador ou agente visual.
- `test_engineer`: cria e executa testes Godot quando autorizado, escrevendo apenas arquivos de teste designados. O `qa_reviewer` continua responsavel por revisao independente.
- `j2me_asset_analyst`: identifica sprites, atlas e animacoes `gpack` com evidencia no JAR; nao modifica os originais e entrega mapeamentos para `visual_porter`.
Use especialistas somente quando a tarefa exigir. Nao delegue escrita simultanea no mesmo arquivo. Prefira sempre a menor alteracao correta e mantenha testes e memoria atualizados.

## Validação
- Se houver Godot 4.6 disponível: tentar importação/check sem interface (`godot --headless --path godot_project --editor --quit`) e informar o resultado real. O comando pode exigir ajuste ao binário instalado.
- Para gameplay/visual, inspecionar a execução interativa na Godot quando possível; a importação headless **não** prova fidelidade visual nem comportamento.
- Testar manualmente, conforme o sistema tocado: seleção de tiles, construção/venda, caminhos, visitantes, economia, save/load e mouse/touch.
- Se não executar um teste, marcar **não testado**, sem declarar sucesso.

## Continuidade
`docs/PROJECT_MEMORY.md` guarda contexto durável. `docs/PORT_PROGRESS.md` guarda andamento com evidências. A memória local nativa do Codex é complementar e não substitui esses arquivos versionados.
