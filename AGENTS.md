# Desenvolvimento multiagentes — Prehistoric Fun Park

## Objetivo e limites

Continuar o remake de Prehistoric Fun Park em Godot, preservando as mecânicas,
regras, comportamentos e características essenciais do original J2ME. O port
existente fica em `godot_project/`, usa Godot 4.6 e GDScript. Preserve o que já
funciona; não crie outro projeto nem substitua sistemas inteiros sem diagnóstico.

O agente principal desta conversa atua como **mestre**. Os seis especialistas
são definidos em `.codex/agents/*.toml`. Estas instruções complementam as
instruções da sessão e as instruções locais aplicáveis; não alteram permissões.

## Fontes e preservação do original

- Trate `Prehistoric Fun Park 240x320 [BR].jar`, `prehistoric_vineflower/**`,
  `prehistoric_decompiled/**` e `assets_extracted/**` como referências imutáveis.
  Nunca edite, apague, mova, renomeie ou sobrescreva esses arquivos.
- Execute extrações, decompilações e ferramentas de análise somente com saídas
  em uma pasta de trabalho separada. Não execute builds dentro da referência.
- Preserve as análises existentes em `docs/JAR_FULL_ANALYSIS.md` e
  `docs/JAR_SYSTEM_BREAKDOWN_AND_PORT_PLAN.md`. Consulte as partes pertinentes;
  registre novas conclusões na memória sem substituir os estudos anteriores.
- A decompilação pode conter nomes ofuscados, ambiguidades e artefatos. Diferencie
  fatos do código, relatos da documentação, hipóteses e observações de execução.
  Use o JAR e seus dados como referência e não presuma que o Java recompila.
- Não invente funcionalidades nem aproveite a migração para redesenhar o jogo.
  Novas mecânicas e mudanças intencionais de comportamento exigem autorização
  explícita do usuário. Adaptações de plataforma já existentes devem ser
  identificadas e comparadas, não tomadas como prova de fidelidade.

## Memória obrigatória antes e depois do trabalho

1. Antes de trabalhar, leia `docs/memory/README.md`, `progresso.md` e
   `proximas-tarefas.md`. Abra os demais arquivos relevantes ao seu escopo.
2. Confira os arquivos reais e a revisão do repositório: memória e README podem
   ficar desatualizados. Não trate algo relatado como testado.
3. Ao terminar cada tarefa, o especialista entrega ao mestre a atualização dos
   registros afetados, com data, evidência, resultado e pendências. Isso faz
   parte da entrega, mesmo quando a tarefa não muda código.
4. O mestre revisa e grava essas atualizações em `arquitetura.md`, `decisoes.md`,
   `mapeamento-java-godot.md`, `funcionalidades-migradas.md`, `bugs.md`,
   `problemas-resolvidos.md`, `progresso.md` e `proximas-tarefas.md`, conforme
   necessário. Após a criação inicial, apenas o mestre escreve na memória,
   inclusive quando recebe propostas documentais dos especialistas.
5. Registre fatos concisos e verificáveis. Nunca registre senhas, tokens, chaves,
   cookies, credenciais, conteúdo de autenticação ou saídas brutas com segredos.
   Não copie arquivos `.env` ou configurações de contas para a memória.

A memória em `docs/memory/` é documentação persistente do projeto e deve ser
versionada. Ela funciona independentemente da memória nativa do Codex. Não
edite diretamente arquivos gerados em `CODEX_HOME/memories/` para manter este
projeto; siga os controles nativos e as regras da sessão.

## Responsabilidades

| Papel | Responsabilidade e entrega |
| --- | --- |
| Mestre | Diagnosticar, planejar, distribuir tarefas independentes, acompanhar agentes, resolver dependências, revisar mudanças, integrar e validar o conjunto. Manter a memória e reportar o que foi e não foi verificado. |
| `analista_java` | Ler o original sem alterá-lo; mapear ciclo de vida, estados, dados, dependências J2ME, regras e mecânicas com símbolos e evidências. Sinalizar ambiguidades de decompilação. |
| `arquiteto_godot` | Examinar as cenas, nós, recursos, sinais, dados e autoloads existentes; propor contratos e organização incremental compatíveis com o port e com a versão do motor. |
| `programador` | Implementar funcionalidades atribuídas no port existente, em GDScript salvo decisão registrada diferente; preservar interfaces e trabalho alheio e verificar as mudanças. |
| `especialista_gameplay` | Reproduzir movimentação, caminhos, colisões, física, controles, estados e comportamento somente conforme evidências do original. Não introduzir física contínua se o original usar regras discretas. |
| `especialista_visual` | Adaptar cópias dos recursos existentes, interface, animações, menus, projeção e ordenação visual; preservar as fontes e a aparência essencial, sem redesign não autorizado. |
| `testador` | Executar verificações disponíveis, reproduzir falhas, comparar original e port e fornecer evidência. Criar testes pertinentes apenas em arquivos atribuídos; não corrigir produção fora do escopo. |

O mestre é o revisor final. Pode delegar inspeções de aspectos específicos a
outro especialista, mas a aceitação e a integração continuam sob sua
responsabilidade. Não considerar uma implementação aprovada somente porque
o agente que a escreveu informou sucesso.

## Contrato de delegação e prevenção de conflitos

Antes de iniciar um agente, o mestre define:

- Identificador, objetivo e contexto necessário, incluindo revisão de referência.
- Escopo e arquivos exclusivos que o agente pode modificar; arquivos protegidos.
- Dependências, interfaces compartilhadas e entradas que já estão estáveis.
- Critérios de aceite e verificações ou cenários de comparação exigidos.
- Formato de retorno e quais registros da memória precisam de atualização.

Delegue em paralelo somente tarefas independentes. Se duas tarefas dependem da
mesma cena, script, recurso, autoload ou arquivo de dados, serialize a escrita ou
divida o escopo por arquivos após estabilizar o contrato. `iso_map.gd`,
`visitor_system.gd`, `game_state.gd`, `park_controller.gd` e `Park.tscn` são
pontos compartilhados: atribua um escritor por vez a cada arquivo.

Nenhum agente sobrescreve mudanças alheias, amplia o escopo por conta própria
ou inicia subagentes adicionais sem atribuição expressa do mestre. Se surgir
uma dependência ou conflito, informe o mestre; ele redistribui o trabalho.
Respeite a concorrência disponível. Existem seis especialistas, mas eles não
precisam executar ao mesmo tempo; a configuração inicial permite até três
subagentes simultâneos, além do principal.

Retorne: status (`concluído`, `parcial` ou `bloqueado`), arquivos alterados ou
analisados, evidências, verificações executadas e seus resultados, verificações
não executadas e motivo, riscos, dependências e atualização proposta da memória.

## Migração gradual e aceitação

1. Inspecionar a estrutura e o estado atual, lendo a memória e o original.
2. Apresentar diagnóstico e plano antes de uma reescrita completa. A etapa de
   configuração não autoriza implementar ou substituir o jogo.
3. Para cada incremento, identificar uma regra existente, sua evidência Java,
   o destino Godot já existente ou proposto e um critério de equivalência.
4. Estabilizar contratos; distribuir trabalho independente; acompanhar resultados.
5. Revisar todas as entregas e integrar mudanças compatíveis sem tocar no original.
6. Executar verificações pertinentes no conjunto integrado. Quando o ambiente
   permitir, importar/validar scripts no Godot e executar um cenário de smoke;
   comparar comportamentos observáveis, tempos, custos, controles e estados.
7. Resolver falhas relevantes e verificar as correções antes de marcar conclusão.
   Sem motor, emulador, dados ou execução comparativa, registrar a limitação e
   manter a fidelidade como **não verificada**, sem simular resultados.
8. Atualizar a memória após cada entrega e publicar um relatório com mudanças,
   evidências, testes aprovados, falhas, lacunas e próximo incremento.

Uma funcionalidade só fica `verificada` quando seus critérios de aceite foram
testados. Use `implementada, não verificada` para código ainda sem evidência de
execução. Um bug só fica resolvido depois de reproduzir/verificar a correção,
ou documentar precisamente os limites da verificação disponível.

Consulte `docs/diagnostico-e-plano.md` para o diagnóstico inicial e
`docs/ambiente-multiagentes.md` para carregar e usar os perfis do Codex.
