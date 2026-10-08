# Progresso de port Java ME → Godot

> Ponto de partida baseado no README do repositório e na estrutura inspecionada em 2026-10-07. **Não é um certificado de testes**.

## Marcos relatados pelo README
| Marco | Estado documentado | Recursos citados | Validação recente |
| --- | --- | --- | --- |
| v0.1 — protótipo jogável | Declarado concluído | mapa isométrico, caminhos, atração, venda, economia, visitantes, save/load JSON, HUD, preview | Não executada nesta configuração |
| v0.2 — fidelidade visual | Declarado em andamento | projeção/entrada, grama, caminhos, sprites de visitantes, preview e área externa | Não executada nesta configuração |

## Sistemas do JAR para orientar o trabalho
Consulte a matriz completa em `docs/JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md`, que distingue estado do port e prioridades. Em especial:
- Mapa/entrada, câmera/profundidade, paths, visitantes, atrações/filas, sprites: comparar visual e lógica, preservar FPS.
- Serviços/necessidades, funcionários/manutenção, campanha e áudio: constam no inventário do original; verificar no código atual antes de marcar como ausentes ou prontos.
- Save/load, economia e UI: comparar regras, estados e dados serializados com o JAR, evitando regressões.

## Log de tarefas
| Data | Tarefa | Resultado | Evidência/teste | Próximo passo |
| --- | --- | --- | --- | --- |
| 2026-10-07 | Estruturar equipe de Codex e memória versionada | Configuração proposta em branch, sem alterar gameplay | Arquivos de configuração; testes de execução do Codex/Godot pendentes | Validar carregamento de agentes no cliente e selecionar primeiro sistema |

## Critério de conclusão para futuras tarefas
- [ ] Comportamento original localizado e evidência documentada, ou divergência deliberada aprovada.
- [ ] Arquivos afetados mapeados; conflitos de edição evitados.
- [ ] Implementação integrada sem substituir sistemas não relacionados.
- [ ] Validação de parser/cena ou execução real descrita com resultado, ou explicitamente pendente.
- [ ] Verificação de regressões relevantes documentada.
- [ ] Memória durável atualizada somente com evidência.

## Próxima tarefa sugerida
Analisar o delta entre `docs/JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md` e a implementação atual de `godot_project/`, escolher **um** sistema de alta prioridade e produzir checklist de equivalência JAR ↔ Godot. Não iniciar reescrita global.
