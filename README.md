# Bazar-API

### O que é?

API para venda de produtos diversos.

### Cenário

<p>
Em um bazar de produtos é possível encontrar diversos tipos de produtos que podem serem fornecidos<br>
por diversos fornecedores e esses tendo diversas marcas, então será feita a divisão dos produtos em categorias.</br>
</p>

### Funcionalidades prontas

- [X] Mostra todos os produtos disponíveis.
- [X] Buscar um produto pelo id.
- [X] Busca produto pelo nome.
- [X] Adiciona produtos no carrinho de compras, mostra o total e a quantidade dos produtos.
- [X] Realiza a venda dos produtos adicionados no carrinho de compras.
- [X] Atualiza a quantidade do produto após a finalização da venda.

###Novas Funcionalidades
-[ ] Pagamento por cartão de crédito.

### Métodos HTTP utilizados na API

<p>Um quadro simples onde é mostrado os métodos HTTP utilizados, a URI para acessar os recursos disponíveis,<br>
as query strings ou parameters que são utilizadas para filtrar os dados entre outras funções.</p> 

| Método HTTP |          URI                |                O que faz?                                                                                          | Caso o recurso não seja encontrado
|-------------|-----------------------------|--------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
|   get       |          /products/         | <p>Busca todos os produtos paginados.</p>|
|   get       |    /product/{**id**}        | <p>Busca um produto pelo id.</p>
|   get       | /products/{**productName**} | <p>Busca produtos pelo nome.</p>
|   get       |         /finally_sale       | <p>Mostra os item já adicionados para a compra </p> |
|   post      |        /items_cart          | <p>Adiciona produtos no carrinho de compras mostra o total e a quantidade de produtos.</p>|

### Arquitetura
<p>
A arquitetura utilizada é a monolítica, tendo os dados centralizados em apenas uma base de dados
e os recursos aclopados e dependentes,</br>a escolha por essa arquitetura é porque o objetivo é manter
a simplicidade e focar no aprendizado. 
</p>

### Modelo Entidade e Relacionamento do Banco de Dados
<p>
A imagem a abaixo ilustra como o banco de dados está modelado e o 
 relacionamento entre as entidades que o compõem.
</p>

![diagrama de entidade e relacionamentos](bazar/database/image-bd-bazar-03.png "BANCO DE DADOS BAZAR-API")

##Tecnologias Utilizadas no Projeto

- Spring Boot
- PostgreSQL
- Swagger
- Flyway
- Docker

O docker é utilizado para rodar um container com o banco de dados PostgreSQL.