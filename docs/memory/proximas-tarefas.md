# Próximas tarefas

Atualizado em: 2026-10-07, America/Cuiaba.

## T-001 — Concluir e validar o bootstrap

- Estado: em andamento.
- Responsável: mestre, recebendo resultados dos especialistas.
- Escopo: conferir `AGENTS.md`, `.codex/config.toml`, os seis arquivos de especialistas, os nove arquivos desta memória, `docs/diagnostico-e-plano.md` e `docs/ambiente-multiagentes.md`.
- Condição de conclusão: arquivos coerentes, configuração local válida e configurações globais existentes preservadas; registrar as verificações realmente executadas.
- Dependência: terminar a criação dos arquivos.

## T-002 — Preservar e registrar a base remota existente

- Estado: pendente.
- Responsável: mestre.
- Escopo: trabalhar sobre a base localizada em `CaioHPSL/prehistoric-fun-park-remake`, registrar a referência usada e proteger JAR, fontes decompiladas, recursos extraídos, análises e port existente.
- Condição de conclusão: conjunto de mudanças da entrega inicial contém somente novos arquivos de configuração e documentação, sem alterações no jogo ou nas fontes protegidas.
- Dependência: repositório já localizado; conferir a base e o conjunto final antes do PR.

## T-003 — Diagnosticar o original e planejar a primeira migração

- Estado: pendente.
- Responsável: mestre, analista Java e arquiteto Godot, com apoio dos especialistas e do testador conforme necessário.
- Escopo: ler o Java e as análises existentes, levantar regras com evidências, auditar o port Godot e definir verificações de equivalência. Confirmar ambiente Godot 4.6 e observar a base quando possível.
- Condição de conclusão: diagnóstico verificável, mapeamento Java→Godot fundamentado e plano gradual para o port existente, distinguindo declarações do README de comportamento validado.
- Dependência: T-001 e T-002.

## T-006 — Investigar os achados iniciais e validar o ambiente de comparação

- Estado: pendente.
- Responsável: mestre, analista Java, especialista em gameplay e testador, com apoio do arquiteto Godot.
- Escopo: localizar ou disponibilizar o motor Godot compatível e meios de observar o JAR; investigar B-HIP-001 e B-DOC-001 com a fonte e cenários comparativos.
- Condição de conclusão: ambiente identificado, evidências classificadas e regra original confirmada antes de qualquer proposta de correção. A ausência de Godot no `PATH` não deve ser tratada como prova de que o motor não está instalado.
- Dependência: fontes já localizadas; execução e análise mais profunda ainda necessárias. Não alterar código ou README na entrega de configuração.

## T-004 — Validar o primeiro fluxo real de migração e memória

- Estado: pendente.
- Responsável: mestre.
- Escopo: quando houver uma etapa concreta autorizada, delegar trabalho independente com arquivos exclusivos no port existente, comparar Java e Godot, revisar a integração e consolidar as propostas de atualização da memória.
- Condição de conclusão: critérios comparativos atendidos, resultado integrado, mapeamento e funcionalidades atualizados com evidências, contexto recuperável e ausência de dados proibidos.
- Dependência: T-003 e autorização aplicável à etapa concreta. Nenhuma implementação deve ser iniciada nesta configuração inicial.

## T-005 — Levar a configuração a um PR

- Estado: pendente.
- Responsável: mestre.
- Escopo: preparar o PR dos novos arquivos de configuração, perfis, memória e orientação de uso sobre a base remota, preservando todos os arquivos existentes.
- Condição de conclusão: revisão do conjunto de mudanças confirma escopo documental e de configuração, com validações e limitações descritas.
- Dependência: T-001 e T-002.
