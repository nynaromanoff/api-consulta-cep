# API de Consulta de Endereço por Cep

API REST em Spring Boot 3.5.0 para consultas de endeço por CEP em uma APi Externa, com persistencia de histórico, seguindo boas praticas de arquitetura, sendo elas: Solid e Clean Code.

## Tecnologias utilizadas

-  Java 17
-   Spring Boot 3.5.0
-   Spring Web
-   Spring Data JPA
-   Feign Client
-   PostgreSQL
-   Mockito

## Arquitetura e Boas Práticas

* SOLID
* Padrões usados: DTOs, Mappers, Global Exception Handling

## Diagrama

 
![cep](https://github.com/user-attachments/assets/07f4c0f8-7c3c-41da-aedf-0e657ca9ff3d)


## Execução

* A aplicação roda atráves do comando:
  * ` mvn spring-boot:run`
* O banco de dados da aplicação roda através de containers Docker, subindo todas dependências com o comando:
    * `docker-compose up`


## Endpoints

* `GET /address/{cep}` - Consulta pelo CEP informado.
* `GET /address/logs` - Retorna o histórico de consultas

## Testes

* Cobertura completa do código da aplicação, pode ser executado com Maven
    * `mvn -Dtest=ApiCepApplicationTests test`
