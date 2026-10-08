# Uso do ambiente multiagentes

Configurado em 2026-10-07 para o port existente de Prehistoric Fun Park.

## Carregar a equipe

Abra a raiz do repositório como projeto no Codex e inicie uma nova conversa nessa
raiz. Se o cliente solicitar confiança no projeto, revise e confie na pasta para
que ele carregue `.codex/config.toml`. Conversas já abertas podem precisar ser
reiniciadas para incorporar os novos arquivos. Na pasta local desta conversa,
o parser nativo reconheceu os valores da configuração, mas informou que a
camada está desabilitada até que o projeto seja confiável. A configuração
global foi preservada; não se habilitou confiança automaticamente.

O mestre é o agente principal, instruído por `AGENTS.md`. Os seis perfis
standalone em `.codex/agents/` contêm `name`, `description` e
`developer_instructions`. O Codex atual descobre esses arquivos. Não é necessário
criar seis chats separados nem iniciar um segundo mestre. Modelo e esforço
herdam as escolhas existentes; a configuração local não os fixa.

Exemplo de pedido para uma etapa futura:

> Atue como mestre. Leia a memória, peça ao analista_java o contrato da mecânica
> selecionada e ao arquiteto_godot a análise do destino existente, em paralelo
> somente se forem independentes. Apresente o incremento proposto. Após a
> autorização correspondente, atribua arquivos exclusivos ao programador e aos
> especialistas necessários, peça ao testador a comparação e revise a integração.
> Atualize os registros e informe o que foi e não foi verificado.

Há até três subagentes concorrentes, além do mestre. A quantidade de papéis não
impõe simultaneidade. Analista Java e Arquiteto Godot têm padrão de sandbox
somente leitura; instruções e controles da sessão continuam aplicáveis.

No terminal, dentro da raiz, `codex features list` mostra as flags disponíveis.
Em uma sessão interativa, `/agent` permite inspecionar os agentes. Se os perfis
não aparecerem, confira a raiz aberta, a confiança no projeto e o carregamento
das configurações; reinicie a sessão. Não substitua a configuração global.

Referências oficiais: [Subagents](https://learn.chatgpt.com/docs/agent-configuration/subagents),
[AGENTS.md](https://learn.chatgpt.com/docs/agent-configuration/agents-md) e
[Config Reference](https://learn.chatgpt.com/docs/config-file/config-reference).

## Memória persistente do projeto

`docs/memory/README.md` explica cada registro. Todos os agentes consultam a
memória antes de agir e entregam as atualizações relevantes após cada tarefa.
O mestre consolida a escrita para impedir conflitos. Versione esses arquivos
com as configurações; não inclua arquivos temporários de trabalho.

## Memória nativa do Codex

A inspeção desta máquina confirmou que a configuração global já contém:

```toml
[features]
memories = true

[memories]
generate_memories = true
use_memories = true
```

Essas opções foram preservadas. Para habilitar em outra máquina, use
**Settings → Personalization → Enable Codex memories**, na máquina selecionada,
ou incorpore as opções acima ao `config.toml` do seu `CODEX_HOME` (padrão
`~/.codex/config.toml`), preservando as tabelas existentes. Evite duplicar
`[features]` e `[memories]`. Pelo CLI, `codex features enable memories` habilita
a flag; confira também as opções de geração e uso caso tenham sido desativadas.

`/memories` controla o uso e a geração no chat atual. Perfis e políticas podem
afetar a configuração efetiva. A geração ocorre em segundo plano e não é
garantida imediatamente ao terminar uma tarefa. Os arquivos nativos em
`CODEX_HOME/memories/` são estado gerado; mantenha regras obrigatórias e decisões
do jogo nos arquivos versionados deste projeto. Nunca registre segredos.

Fonte: [Memories — documentação oficial](https://learn.chatgpt.com/docs/customization/memories).
