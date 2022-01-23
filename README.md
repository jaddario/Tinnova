# Tinnova

Prova prática de desenvolvimento para o cargo de Engenheiro de Software Sênior da Tinnova. 

## Cadastro de veículos API
Api RESTFul para consulta e manutenção de uma listagem de veículos.

## Configurações
Como banco de dados, utilizei a solução H2. As configurações de URL, usuário e senha do banco estão armazenadas no arquivo application.properties e estão exibidas abaixo:
```
spring.h2.console.enabled=true
spring.h2.console.path=/h2
spring.datasource.url=jdbc:h2:mem:veiculosbd
spring.datasource.username=root
spring.datasource.password=
```

## Execução do projeto
A aplicação já cria por sí só o banco de dados. Por isso, nenhuma instalação externa é necessária. Para executá-la, basta clonar o repositório, navegar até o diretório da aplicação e executar o comando abaixo:
```
mvn spring-boot:run
```
## Endpoints
Para a lista de Endpoints possíves, parâmetros, códigos de resposta HTTP, e tipo de retorno, rode a aplicação e acesse o console do Swagger aqui: http://localhost:8080/swagger-ui.html.  
