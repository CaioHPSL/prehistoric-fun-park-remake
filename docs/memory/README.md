# Memória persistente do projeto

Data de referência: 2026-10-07, fuso America/Cuiaba.

Esta pasta contém a memória local, legível e revisável do remake de um jogo Java em Godot. O objetivo é preservar as mecânicas, os comportamentos e as funcionalidades essenciais do original. O usuário autorizou sua criação e manutenção contínua para registrar arquitetura, decisões, progresso, problemas resolvidos e próximas tarefas. Essa autorização se aplica aos arquivos desta pasta e deve respeitar instruções superiores da sessão.

O código Java é referência imutável. A migração deve ser gradual, sem acrescentar funcionalidades não autorizadas. O repositório já contém um port Godot; a equipe deve preservar essa base e comparar o comportamento com o original antes de ampliar a implementação. A sessão de configuração modifica somente instruções, perfis e documentação.

## Leitura no início de cada tarefa

1. Leia o `AGENTS.md` aplicável e este índice.
2. Leia [progresso.md](progresso.md) e [proximas-tarefas.md](proximas-tarefas.md).
3. Consulte os registros pertinentes à tarefa: [arquitetura.md](arquitetura.md), [decisoes.md](decisoes.md), [mapeamento-java-godot.md](mapeamento-java-godot.md), [funcionalidades-migradas.md](funcionalidades-migradas.md), [bugs.md](bugs.md) e [problemas-resolvidos.md](problemas-resolvidos.md).
4. Verifique novamente fatos sujeitos a mudança antes de usá-los como base para uma ação.

## Responsabilidade de escrita

Todos os agentes leem a memória pertinente e, ao terminar sua tarefa, entregam propostas de atualização com fatos, evidências, decisões, resultados e pendências. Após a criação inicial, somente o mestre escreve nestes arquivos, consolidando essas propostas para evitar conflitos. O mestre registra o resultado depois de avaliar as evidências e validar a integração. Trabalho em andamento deve continuar identificado como tal.

## Convenções dos registros

- Use datas no formato `AAAA-MM-DD`, com referência a America/Cuiaba.
- Distinga fatos verificados, propostas e hipóteses; registre a evidência e as pendências.
- Mantenha arquitetura e progresso como retratos do estado atual.
- Acrescente decisões e problemas resolvidos ao histórico. Para mudar uma decisão, acrescente um registro que indique qual decisão foi substituída e por quê.
- Mantenha próximas tarefas atualizadas, com dependência e condição de conclusão quando conhecidas.
- Registre resultados de verificações de forma resumida; não trate verificações planejadas como aprovadas.
- Não copie conversas inteiras nem saídas brutas de ferramentas.
- Separe comportamento observado no Java de proposta para Godot. Mapeamentos propostos e funcionalidades ainda sem comparação não podem ser marcados como confirmados ou migrados.
- Não registre segredos, senhas, tokens, chaves, credenciais, conteúdo de autenticação ou dados pessoais desnecessários. Se um dado proibido for encontrado, remova-o em vez de preservá-lo no histórico.

## Relação com a memória nativa do Codex

Estes arquivos são a memória do projeto e são mantidos pelas instruções de trabalho. A memória nativa do Codex é um recurso separado, gerenciado pelo próprio Codex, e não garante a atualização automática desta pasta. A inspeção inicial confirmou que a memória nativa já está habilitada nas configurações globais; essas configurações serão preservadas.

O diagnóstico e o plano estão em [docs/diagnostico-e-plano.md](../diagnostico-e-plano.md), com orientação de uso em [docs/ambiente-multiagentes.md](../ambiente-multiagentes.md). Esses documentos complementam a memória.

Estado atual: repositório `CaioHPSL/prehistoric-fun-park-remake` localizado e estrutura remota inspecionada. A pasta local estava vazia antes do bootstrap; o repositório remoto contém o original Java, recursos, análises e um port Godot existente. Configuração local e memória criadas; sintaxe TOML verificada; revisão integrada concluída. Entrega no [PR #3 em rascunho](https://github.com/CaioHPSL/prehistoric-fun-park-remake/pull/3), ainda sem incorporação à `main`. A descoberta e a execução dos perfis ainda não foram comprovadas por essa verificação. Nenhuma nova funcionalidade do jogo foi implementada nesta sessão.
