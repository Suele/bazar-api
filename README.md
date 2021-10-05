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
- [X] Adiciona produtos no carrinho de compras e mostra o total e a quantidade.
- [X] Realiza a venda dos produtos adicionados no carrinho de compras.
- [X] Atualiza a quantidade do produto após a finalização da venda.

<p>
<b>Observação</b>: Os produtos adicionados no carrinho de compras só existem em memoria ou seja durante a execução</br>
do programa. Os produtos que estiverem no carrinho de compras são adicionados para a compra</br> 
e em seguida é atualizada a quantidade do produtos que foi comprado.
</p>

###Novas Funcionalidades
- [ ] Forma de pagamento.

### Métodos HTTP utilizados na API

<p>Um quadro simples onde é mostrado os métodos HTTP utilizados, a URI para acessar os recursos disponíveis,<br>
as query strings ou parameters que são utilizadas para filtrar os dados entre outras funções.</p> 

| Método HTTP |                        URI                |                O que faz?                                                                                                                             |                 Caso o recurso não seja encontrado
|---------------------|--------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
|   get              |          /products/                     | <p>Busca todos os produtos paginados.</p>|
|   get              |    /product/{**id**}                 | <p>Busca um produto pelo id.</p>
|   get              | /products/{**productName**}   | <p>Busca produtos pelo nome.</p>
|   get              |         /finally_sale                    | <p>Faz a compra, ou seja, pega os produtos que estão no carrinho de compras </br>e atualiza a sua quantidade.</p> |
|   post             |        /add_items_cart               | <p>Adiciona produtos no carrinho de compras.</p>|
|   get              |      /product_cart                     |<p>Mostra os produtos que estão no carrinho de compras.</p>

### Arquitetura
<p>
A arquitetura utilizada é a monolítica, tendo os dados centralizados em apenas uma base de dados
e os recursos aclopados e dependentes,</br>a escolha por essa arquitetura é porque o objetivo é manter
a simplicidade e focar no aprendizado. 
</p>

### Modelo Entidade e Relacionamento do Banco de Dados
<p>
A imagem a abaixo ilustra como o banco de dados está modelado e o 
tipo de relacionamento entre as entidades.
</p>

![diagrama de entidade e relacionamentos](bazar/database/image-bd-bazar-03.png "BANCO DE DADOS BAZAR-API")

##Tecnologias Utilizadas no Projeto
- Spring Boot
- PostgreSQL
- Swagger
- Flyway
- Docker

O banco de dados postgresql é executado em um container docker.