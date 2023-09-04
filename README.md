API Loja
Projeto responsável pelo registro de uma loja, com criação de produtos e pedidos, consultando dados de do cliente da API CLIENTE. 

Features Categorias
Cadastro de categoria
Recebe uma solicitação de criação de uma nova categoria (Solicitação via HTTP POST). Verifica se a categoria já existe. 
Se não existir: Crie uma nova categoria no banco de dados. 
Retorna uma resposta de sucesso. 
Se existir: Retorna uma reposta informando que já existe.

Listar categorias
Recebe uma solicitação para ler informações de uma página de categorias (Solicitação HTTP GET com um Pageable). Consulta o banco de dados para obter os detalhes da categoria. Se existir: Retorne a quantidade de registro informado na paginação com as categorias cadastradas. Se não existir registro: Retorne uma resposta indicando que não foi encontrado.

Deletar
Receba uma solicitação para excluir uma categoria (Solicitação HTTP DELETE com um ID da categoria). Verifique se a categoria existe no banco de dados. Se existir: Deleta no banco de dados. Retorna uma resposta de sucesso. Se não existir: Retorne uma resposta indicando que a categoria não foi encontrada.

Atualizar
Recebe uma solicitação de atualização de uma categoria (Solicitação HTTP PUT com um ID da categoria). Valida o nome atualizado da categoria. Se for válido: Atualiza o nome da categoria no banco de dados. Retorna uma resposta de sucesso. Se for invalido: Retorna uma reposta informando que os dados precisam ser válidos.

🛠 Tecnologias
As seguintes ferramentas foram usadas na construção do projeto:

Java 17 - Spring Boot - API Docs - H2 Database - Gateway - Eureka

Pré-requisitos e Testes
Para facilitar os testes, utilizei o banco de dados H2 e as configurações estão no application.properties do projeto. Para verificar as alterações no banco de dados, é necessário acessar o console do H2 -> http://localhost:8080/h2-console. Utilizei a API Docs para documentação e testes -> http://localhost:8080/swagger-ui/index.html#/
