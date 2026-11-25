# Streaming API

Backend de uma plataforma de streaming desenvolvido em **Java 17 e Spring Boot**, com o objetivo de gerenciar contas, usuários, planos de assinatura, perfis de acesso e histórico de filmes assistidos.

O projeto foi desenvolvido como exercício prático de desenvolvimento Backend, aplicando conceitos de orientação a objetos, arquitetura REST, persistência de dados, regras de negócio e testes automatizados.

## Tecnologias utilizadas

- **Java 17** – Linguagem de programação.
- **Spring Boot** – Framework para desenvolvimento da API.
- **Spring Web** – Construção de endpoints REST.
- **Spring Data JPA** – Persistência e gerenciamento de entidades.
- **Hibernate** – Mapeamento objeto-relacional (ORM).
- **MySQL** – Banco de dados relacional.
- **Maven** – Gerenciamento de dependências.
- **JUnit 5** – Testes automatizados.
- **H2 Database** – Banco de dados em memória para testes.
- **BCrypt** – Criptografia de senhas.

## Funcionalidades

### 1. Gerenciamento de usuários
- Cadastro de usuários assinantes.
- Cadastro de usuários não assinantes.
- Associação de usuários a uma conta.
- Diferenciação entre assinantes e usuários compartilhados.

### 2. Controle de acesso
- Apenas o assinante responsável pode adicionar usuários à conta.
- Apenas o assinante responsável pode remover usuários compartilhados.
- Validação de permissões antes da execução das operações.

### 3. Gerenciamento de planos

O sistema trabalha com três modalidades:

| Plano | Usuários compartilhados | Nível de conteúdo |
|---|---:|---:|
| Básico | 1 | 1 |
| Padrão | 3 | 2 |
| Premium | 5 | 3 |

- Migração entre planos.
- Atualização do plano da conta.
- Validação da capacidade de compartilhamento.

### 4. Perfis de usuário

Cada usuário possui um perfil que determina os conteúdos disponíveis:

- Infantil: acesso a conteúdos infantis.
- Adolescente: acesso a conteúdos infantis e adolescentes.
- Adulto: acesso a todas as classificações.

### 5. Catálogo de filmes
- Listagem de filmes disponíveis.
- Restrição de conteúdo conforme o plano contratado.
- Restrição de conteúdo conforme o perfil do usuário.

### 6. Reprodução de filmes
- Validação das permissões antes da reprodução.
- Bloqueio de conteúdos incompatíveis com o perfil.
- Registro automático dos filmes assistidos.

### 7. Histórico de consumo
- Consulta do histórico individual.
- Ordenação cronológica das reproduções.
- Registro de múltiplas reproduções do mesmo filme.

## Estrutura do projeto

```text
streaming-api/
│
├── src/
│   ├── main/
│   │   ├── java/br/com/streaming/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── enums/
│   │   │   ├── exception/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── StreamingApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/br/com/streaming/
│
├── pom.xml
└── README.md
```

## Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

- Java JDK 17 ou superior.
- IntelliJ IDEA.
- Maven.
- MySQL 8 ou superior.

## Configuração do banco de dados

Configure as credenciais do MySQL no arquivo:

`src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/streaming_db?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

Altere o usuário e a senha conforme sua instalação do MySQL.

## Como executar o projeto

1. Clone ou baixe o projeto.
2. Abra a pasta `streaming-api` no IntelliJ IDEA.
3. Aguarde o Maven carregar as dependências.
4. Configure o banco de dados MySQL.
5. Localize a classe `StreamingApplication.java`.
6. Execute o método `main`.

A aplicação estará disponível em:

`http://localhost:8080`

## Testes automatizados

O projeto utiliza JUnit 5 para validar as regras de negócio.

Para executar os testes pelo terminal:

```bash
mvn test
```

## Endpoints da API

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/api/subscribers` | Criar assinante e conta |
| POST | `/api/accounts/{accountId}/users` | Adicionar usuário |
| DELETE | `/api/accounts/{accountId}/users/{userId}` | Remover usuário |
| PUT | `/api/accounts/{accountId}/plan` | Migrar plano |
| GET | `/api/users/{userId}/movies` | Listar filmes disponíveis |
| POST | `/api/users/{userId}/movies/{movieId}/watch` | Assistir a um filme |
| GET | `/api/users/{userId}/history` | Consultar histórico |

## Objetivo do projeto

Este projeto tem como objetivo consolidar conhecimentos em desenvolvimento Backend com Java, especialmente na construção de APIs REST, modelagem de entidades, relacionamentos entre tabelas, regras de negócio, controle de acesso e persistência de dados.

Também busca aplicar conceitos de desenvolvimento orientado a testes (TDD), organização de código e boas práticas de programação.

---

**Desenvolvido como projeto de estudo em Java e Spring Boot.**