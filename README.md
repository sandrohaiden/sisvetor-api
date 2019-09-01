sisvetor-api

## Instruções

Tendo o Java, o Eclipse IDE 2019‑06, o Maven e o PostgreSQL devidamente instalados, importe este projeto como um projeto maven, baixe as dependências (caso os downloads não iniciem automaticamente, o comando mvn install deverá ser executado atráves de terminal/prompt).
Crie o banco de dados sisvetor no Postegre e no arquivo src/main/resources/application.properties informe corretamente o usuário, senha endereço e porta do servidor do banco de dados (Atualmente o usuário e senha são respectivamente postegres e root). Execute o projeto a partir da própria IDE Eclipse.

## Rotas Configuradas na API
```js
/api/itens
/api/itens/:id
/api/subitens
/api/subitens:id
```
