# Próximas tarefas

Atualizado em: 2026-10-07, America/Cuiaba.

## T-001 — Bootstrap configurado e revisado

- Estado: concluído para criação e revisão; teste real dos perfis pendente.
- Responsável: mestre, recebendo resultados dos especialistas.
- Escopo: conferir `AGENTS.md`, `.codex/config.toml`, os seis arquivos de especialistas, os nove arquivos desta memória, `docs/diagnostico-e-plano.md` e `docs/ambiente-multiagentes.md`.
- Condição de conclusão: arquivos coerentes, configuração local válida e configurações globais existentes preservadas; registrar as verificações realmente executadas.
- Resultado: sete TOMLs válidos, instruções carregadas e configuração global preservada. A camada local requer confiança no projeto para ficar ativa; descoberta/execução dos perfis será verificada em uma nova sessão na raiz confiável.

## T-002 — Base remota registrada e preservada

- Estado: concluído nesta entrega.
- Responsável: mestre.
- Escopo: trabalhar sobre a base localizada em `CaioHPSL/prehistoric-fun-park-remake`, registrar a referência usada e proteger JAR, fontes decompiladas, recursos extraídos, análises e port existente.
- Condição de conclusão: conjunto de mudanças da entrega inicial contém somente novos arquivos de configuração e documentação, sem alterações no jogo ou nas fontes protegidas.
- Resultado: base `34662b0b2add5d7e90bd7a28b3527cabe18b9a96` registrada; diff remoto com somente 19 adições, nenhum arquivo existente modificado ou removido.

## T-003 — Aprofundar o diagnóstico e selecionar o primeiro incremento

- Estado: diagnóstico estático inicial e plano apresentados; aprofundamento e comparação de execução pendentes.
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

## T-005 — Configuração publicada para revisão

- Estado: concluído; PR em rascunho aguardando revisão.
- Responsável: mestre.
- Escopo: preparar o PR dos novos arquivos de configuração, perfis, memória e orientação de uso sobre a base remota, preservando todos os arquivos existentes.
- Condição de conclusão: revisão do conjunto de mudanças confirma escopo documental e de configuração, com validações e limitações descritas.
- Resultado: [PR #3](https://github.com/CaioHPSL/prehistoric-fun-park-remake/pull/3), branch `codex/multiagentes-java-godot`; configuração ainda não incorporada à `main`.
