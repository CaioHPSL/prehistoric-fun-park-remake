# Bugs e divergências de comportamento

Atualizado em: 2026-10-07, America/Cuiaba.

Total confirmado nesta sessão: **zero bugs de aplicação**. A árvore remota e a estrutura do port foram inspecionadas, mas execução e equivalência funcional ainda não foram verificadas. Esse resultado não garante ausência de bugs no jogo existente.

## Campos de cada registro

- Identificador, título, data e estado: suspeito, confirmado, em correção ou resolvido.
- Ambiente e versão efetivamente verificados.
- Passos de reprodução, condições iniciais e entradas.
- Comportamento esperado, com evidência do Java original.
- Comportamento observado em Godot e evidência da divergência.
- Impacto, prioridade e mapeamentos ou funcionalidades relacionados.
- Causa confirmada ou hipótese explicitamente identificada.
- Correção e verificação comparativa, quando realizadas.
- Pendências, responsável e ligação ao registro em `problemas-resolvidos.md` após resolução verificada.

Uma diferença somente deve ser considerada bug confirmado quando as evidências sustentarem a divergência. Não transformar comportamentos do original em melhorias ou novas funcionalidades sem autorização. Não registrar segredos nem saídas brutas de ferramentas.

## B-HIP-001 — Exigência de atração acessível na criação de visitantes

- Data: 2026-10-07, America/Cuiaba.
- Estado: hipótese a investigar; não é bug confirmado.
- Evidência Godot: `godot_project/scripts/visitor_system.gd`, linhas 129–140, contém `require_accessible_attraction_for_spawn = true`.
- Evidência Java: a leitura inicial de `k`/`cS` em `prehistoric_vineflower/e.java`, incluindo `cS` nas linhas 8176–8228, não identificou explicitamente a mesma exigência. Isso não exclui uma condição indireta em outro trecho.
- Contexto: a análise e o plano anteriores recomendam esse requisito na linha 837; uma recomendação de port não comprova que o original tinha a mesma regra.
- Comparação pendente: observar condições equivalentes com e sem atração acessível no Java e em Godot e completar a análise das condições de spawn.
- Correção: nenhuma; preservar o comportamento atual até confirmar a regra original e obter o escopo aplicável.

## B-DOC-001 — Tamanho de atração diverge entre README e constante do port

- Data: 2026-10-07, America/Cuiaba.
- Estado: divergência documental confirmada por leitura; não é defeito de gameplay confirmado.
- Evidência: `README.md` descreve tamanho 2×2, enquanto `godot_project/autoload/game_state.gd` define `BASIC_ATTRACTION_SIZE` como `(3, 3)`.
- Impacto observado: documentação e constante de implementação fornecem referências diferentes. O tamanho correto no original e a consequência em execução ainda não foram verificados.
- Verificação pendente: conferir a regra original, o uso da constante e o comportamento observado antes de decidir entre ajuste documental e correção de migração.
- Correção: nenhuma nesta sessão; o README existente e o código do jogo ficam preservados.
