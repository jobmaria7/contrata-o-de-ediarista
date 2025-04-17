# Projecto contrata-o-de-ediarista por Job Maria.

Projecto desenvolvido durante a imerção Multi-Stack da [TreinaWeb](https://treinaweb.com.br) utilizando Java e Spring-Boot.

## Dependências do projeto:

- Spring Boot
- Spring Web MVC
- Thymeleaf
- Spring Data JPA
- Bean Validation

## Dependências de desenvolvimento:

- Spring Boot Devtools
- Lombok

## Requisitos:

- Java 17
- Maven 3.9.9

## Como testar esse projeto na minha máquina:

Clone o repositório e entre na pasta do projeto.

````sh
git clone https://github.com/jobmaria7/contrata-o-de-ediarista.git
cd contrata-o-de-ediarista
````

Atualize as configurações de acesso ao banco de dados no arquivo [application.properties](src/main/resources/application.properties)
```properties
# Datasource configurations
spring.datasource.url=jdbc:mysql://rost:porta/nome_do_banco_de_dados?useTimezone=true
spring.datasource.username=username_do_seu_mysql
spring.datasource.password=senha_do_mysql
```

Execute o projeto através do Maven.

```sh
mvn spring-boot:run
```

Acesse a aplicação: [https://localhost:8080/admin/servicos](https://localhost:8080/admin/servicos)
