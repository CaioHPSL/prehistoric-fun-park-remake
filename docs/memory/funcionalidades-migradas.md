# Funcionalidades migradas

Atualizado em: 2026-10-07, America/Cuiaba.

Novas funcionalidades implementadas nesta sessão: **zero**. O inventário de funcionalidades já migradas no port existente ainda não foi auditado; não interpretar esse número como ausência de funcionalidades no repositório.

O port Godot está presente em `CaioHPSL/prehistoric-fun-park-remake`, commit `34662b0b2add5d7e90bd7a28b3527cabe18b9a96`. O README remoto declara protótipo v0.1 concluído e trabalho visual v0.2 em curso. Essas declarações ainda não foram confirmadas por execução ou comparação com o Java nesta sessão.

## Base existente identificada por leitura

| Evidência de implementação existente | Estado da validação |
| --- | --- |
| Cenas de mapa, parque, visitantes e interface presentes. | Existência confirmada na árvore; comportamento e completude ainda não executados. |
| Mapa 30×30, entrada `(15, 0)` e caminho inicial `(15, 1)` no `GameState`. | Constantes lidas; equivalência funcional pendente conforme M-002. |
| Dinheiro inicial de visitantes 40..79 e referência de tick 0,1 segundo no `visitor_system.gd`. | Constantes lidas; criação e atualização em execução não verificadas, conforme M-001 e M-003. |
| `Catalog.load_all` carregando os JSON de construções e balanceamento. | Carregamento identificado por leitura; equivalência dos dados pendente conforme M-004. |
| Economia inicial 2000 no port. | Valor lido; equivalência com a economia original ainda não estabelecida. |
| `SaveSystem` usando JSON em `user://prehistoric_fun_park_01.save`. | Mecanismo identificado por leitura; restauração e equivalência pendentes conforme M-005. |

Essa lista é um inventário inicial de evidências do port, não uma aprovação de migração concluída.

## Critério para registrar uma migração concluída

Uma funcionalidade somente é registrada como migrada após existir um mapeamento fundamentado, uma implementação integrada no destino autorizado e uma comparação aprovada com o comportamento original. Implementação parcial, proposta de cena ou teste não executado não são conclusão.

Cada registro deve conter identificador, nome observado no original, data, mapeamentos relacionados, arquivos Godot, critérios comparativos, evidências de verificação, aprovação da integração pelo mestre e limitações remanescentes. Divergências devem apontar para os registros correspondentes em `bugs.md`.

## Registros

Nenhum registro de equivalência concluído nesta memória. Etapas planejadas ou em andamento ficam em `progresso.md` e `proximas-tarefas.md` até a validação. O próximo inventário deve começar pelo port existente, com evidências e sem presumir a completude anunciada no README.
