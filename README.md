# Desafio TG - Frontend e Backend

Este é um projeto desenvolvido para o Desafio TG, contendo tanto a parte de frontend quanto a parte de backend. O projeto envolve um sistema de cadastro de usuários com diferentes informações e validações. Utiliza as seguintes tecnologias e ferramentas:

## Tecnologias Utilizadas

### Backend:
- Linguagem de Programação: Java
- Framework: Spring Boot
- Banco de Dados: SQL Server 2016 ou Postgres
- Hibernate para mapeamento ORM

### Frontend:
- PrimeFaces
- JavaScript
- HTML

## Como Testar

1. Certifique-se de ter o Java (versão 17 ou superior), Git e um servidor web ou de aplicação configurado em sua máquina.

2. Clone este repositório para a sua máquina local: git clone https://github.com/seu-usuario/seu-repositorio.git

3. Configure o banco de dados (SQL Server 2016 ou Postgres) de acordo com as informações no arquivo `application.properties` (ou `application.yml`) dentro da pasta `resources`.

4. Compile e execute o backend usando a IDE de sua preferência ou o seguinte comando no terminal: ./mvnw spring-boot:run

5. Copie os arquivos do frontend (HTML, JavaScript) para o diretório de implantação do servidor web.

6. Acesse a página do frontend através do navegador utilizando a URL apropriada (por exemplo, `http://localhost:8080/meu-frontend`).

## Observações

- Certifique-se de ajustar as versões das dependências no arquivo `pom.xml` para que estejam alinhadas com as versões corretas do Spring Boot, Hibernate e PrimeFaces compatíveis com o projeto.

- As configurações de segurança, como tokens de autenticação, não estão implementadas neste projeto básico e devem ser adicionadas para um ambiente de produção.
