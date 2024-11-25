# TaskFlow API

O **TaskFlow API** é um sistema de gerenciamento de tarefas baseado em uma arquitetura moderna utilizando **Spring Boot**, **PostgreSQL** e ferramentas de desenvolvimento como **Flyway** e **Lombok**. Esta API permite que os usuários gerenciem suas tarefas de forma eficiente e organizada.

## Tecnologias Utilizadas

- **Spring Boot 3.3.4**: Framework para criação da aplicação backend.
- **Java 21**: A versão mais recente do Java utilizada para o desenvolvimento.
- **PostgreSQL 17**: Banco de dados relacional para persistência de dados.
- **Flyway 9.22.0**: Ferramenta para migrações de banco de dados.
- **Lombok**: Biblioteca para redução de código boilerplate.
- **JUnit**: Framework para testes unitários.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- **JDK 21**
- **Docker** e **Docker Compose** para rodar o PostgreSQL no contêiner
- **Maven** para gerenciamento de dependências e execução do projeto.

## Instalação

### 1. Clonando o repositório

Clone o repositório para sua máquina local:

```bash
git clone <URL_DO_REPOSITORIO>
cd taskflow
```

### 2. Configuração do Banco de Dados

O projeto usa PostgreSQL. Para facilitar o desenvolvimento, você pode rodar o banco de dados utilizando Docker Compose.
O arquivo docker-compose.yml está configurado para inicializar o banco de dados com o nome taskflow_db, usuário taskflow_user e senha strongpassword.

Execute o comando abaixo para iniciar o PostgreSQL em um contêiner Docker:

```bash
docker-compose up -d
```
Isso criará o contêiner taskflow-postgres com o banco de dados configurado.

### 3. Rodando a Aplicação

Para rodar a aplicação localmente, execute o seguinte comando com Maven:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em http://localhost:8080.
