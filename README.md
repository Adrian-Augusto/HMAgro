🔹 HMAGRO – Backend

Descrição:
Backend de sistema de gestão agroindustrial desenvolvido em Java com Spring Boot, com foco em produtos, estoque e usuários.

Tecnologias:

Spring Boot 4.x – Desenvolvimento de APIs REST.

Spring Data JPA – Persistência de dados.

Banco de dados: H2 (desenvolvimento), MariaDB/MySQL (produção).

Spring Security – Autenticação e autorização de usuários.

Swagger/OpenAPI – Documentação das APIs.

Lombok – Redução de boilerplate.

Funcionalidades:

Cadastro e gerenciamento de produtos.

Controle de estoque.

Gerenciamento de usuários com roles e permissões.

Endpoints REST consumíveis via Postman ou Frontend.

Boas práticas:

Validação de dados.

Segurança em endpoints sensíveis.

Estrutura escalável e modular para futuras integrações.

Como rodar o projeto:

Configurar application.properties com dados do banco.

Executar mvn spring-boot:run ou rodar via IDE.

Acessar endpoints via Swagger: /swagger-ui.html.
