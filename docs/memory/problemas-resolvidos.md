# Problemas resolvidos

Atualizado em: 2026-10-07, America/Cuiaba.

Nenhum bug de aplicação resolvido foi registrado nesta sessão. A pasta local inicialmente vazia não representa ausência de implementação no repositório remoto, que contém o original Java e um port Godot existente.

## P-0001 — Fonte do projeto localizada

- Data: 2026-10-07, America/Cuiaba.
- Tipo: impedimento de diagnóstico resolvido; não é bug do jogo.
- Sintoma: a pasta local não continha fontes Java ou Godot e o repositório ainda não havia sido identificado.
- Solução: localizar `CaioHPSL/prehistoric-fun-park-remake` pelo GitHub conectado e inspecionar a árvore completa da branch `main` no commit `34662b0b2add5d7e90bd7a28b3527cabe18b9a96`.
- Evidência: árvore com `truncated = false` em [árvore da revisão de referência](https://github.com/CaioHPSL/prehistoric-fun-park-remake/tree/34662b0b2add5d7e90bd7a28b3527cabe18b9a96), contendo JAR, fontes decompiladas, recursos, análises e `godot_project/`.
- Limite: localizar os arquivos não valida a execução nem a equivalência entre Java e Godot; essas verificações permanecem pendentes.

## Formato para novos registros

Acrescente um registro somente quando a solução tiver evidência de verificação:

- Identificador e título.
- Data e contexto.
- Sintoma observado e impacto.
- Causa confirmada; hipóteses devem permanecer identificadas como hipóteses.
- Correção aplicada e arquivos relevantes.
- Verificação realizada e resultado.
- Limitações remanescentes e medidas para evitar recorrência, quando cabíveis.

Problemas ainda abertos devem constar em `progresso.md` e `proximas-tarefas.md`; bugs de aplicação ficam em `bugs.md`. Uma correção de migração deve incluir comparação com o comportamento original antes de ser marcada como resolvida. Não registre segredos nem saídas brutas de autenticação.
