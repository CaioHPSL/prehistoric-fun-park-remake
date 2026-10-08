# Histórico de decisões

Registros novos são acrescentados ao histórico. Mudanças de decisão devem apontar o registro substituído; correções de dados proibidos não devem preservá-los.

## D-0001 — Coordenação pelo agente principal

- Data: 2026-10-07, America/Cuiaba.
- Estado: aprovada; configuração local criada, com revisão integrada concluída.
- Decisão: o agente principal atua como mestre conforme `AGENTS.md`, coordenando analista Java, arquiteto Godot, programador, especialista em gameplay, especialista visual e testador em `.codex/agents/`.
- Motivo: concentrar distribuição, acompanhamento e aprovação da integração em um responsável, mantendo responsabilidades especializadas claras.
- Evidência: pedido do usuário e estrutura aprovada durante a configuração.
- Pendência: validar a descoberta dos especialistas e o primeiro fluxo de trabalho.

## D-0002 — Memória local mantida pelo mestre

- Data: 2026-10-07, America/Cuiaba.
- Estado: aprovada; memória local criada, com revisão integrada concluída.
- Decisão: usar `docs/memory/` para arquitetura, decisões, progresso, problemas resolvidos, próximas tarefas, mapeamento Java→Godot, funcionalidades migradas e bugs. Todos os especialistas entregam propostas de atualização após suas tarefas; depois da criação inicial, o mestre é o único escritor.
- Motivo: manter contexto persistente e revisável, evitando edições concorrentes e distinguindo a memória do projeto da memória nativa do Codex.
- Evidência: autorização explícita do usuário para a memória persistente do projeto.
- Restrição: não registrar segredos, senhas ou dados de autenticação; respeitar instruções superiores da sessão.
- Pendência: conferir a leitura e atualização da memória no primeiro fluxo real.

## D-0003 — Preservar configuração global existente

- Data: 2026-10-07, America/Cuiaba.
- Estado: aprovada.
- Decisão: preservar a configuração global, cuja memória nativa já estava habilitada, e adicionar somente a configuração local necessária à equipe.
- Motivo: atender ao pedido de preservar o que já funciona e limitar as mudanças ao projeto.
- Evidência: inspeção inicial das configurações confirmou `features.memories = true`, `memories.generate_memories = true` e `memories.use_memories = true`.
- Verificação: SHA-256 da configuração global permaneceu inalterado após criar a configuração local. Nenhum parâmetro de memória nativa foi alterado pelo bootstrap.

## D-0004 — Migração gradual com fidelidade ao original

- Data: 2026-10-07, America/Cuiaba.
- Estado: aprovada; análise e implementação pendentes.
- Decisão: tratar o Java como referência imutável e migrar gradualmente para Godot, preservando mecânicas, comportamentos e funcionalidades essenciais. Não acrescentar funcionalidades não autorizadas.
- Motivo: tornar cada etapa comparável ao original e limitar divergências de comportamento.
- Evidência: direcionamento do usuário para o remake Java→Godot.
- Pendência: analisar as fontes localizadas, levantar comportamentos com evidências e definir critérios comparativos para o port existente.

## D-0005 — Preservar o port Godot e sua linguagem

- Data: 2026-10-07, America/Cuiaba.
- Estado: aprovada para o processo; execução e equivalência ainda não verificadas.
- Decisão: partir do port existente em `godot_project/`, usando GDScript já presente; não iniciar um novo jogo ou substituir sua arquitetura durante a configuração.
- Motivo: preservar o trabalho existente e concentrar próximas etapas na equivalência com o Java.
- Evidência: projeto Godot, cenas, autoloads, scripts e dados confirmados no commit `34662b0b2add5d7e90bd7a28b3527cabe18b9a96` da branch `main`.
- Pendência: verificar o ambiente Godot 4.6 informado pelo projeto, executar a base e estabelecer verificações comparativas.

## D-0006 — Limitar a entrega inicial a configuração e documentação

- Data: 2026-10-07, America/Cuiaba.
- Estado: aplicada na branch de revisão; incorporação à `main` pendente.
- Decisão: preparar um PR somente com novos arquivos de configuração, perfis e documentação; não alterar código Java, código Godot, recursos nem análises existentes.
- Motivo: tornar a estrutura de coordenação revisável e preservar a base de jogo já existente.
- Evidência: escopo definido para esta configuração após localizar o repositório remoto.
- Resultado: arquivos validados e diff remoto conferido, somente 19 adições. Publicado como [PR #3 em rascunho](https://github.com/CaioHPSL/prehistoric-fun-park-remake/pull/3).
- Pendência: revisar o PR e carregar a equipe em uma nova sessão com o projeto confiável, verificando a execução real dos perfis.
