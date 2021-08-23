# Bazar-API

### O que é?
API para venda de produtos diversos.

### Cenário
<p>Em um bazar de produtos é possível encontrar diversos tipos de produtos que podem serem fornecidos<br>
por diversos fornecedores e esses tendo diversas marcas, então será feita a divisão dos produtos em categorias.</p>

### Recursos da API
- [X] Mostrar todos os produtos disponíveis paginados.
- [X] Buscar um produto pelo id.
- [X] Buscar um produto pelo nome.
- [ ] Buscar um produto pelo fornecedor.
- [ ] Buscar um produto pela categoria.
- [ ] Realizar uma venda no local.
- [ ] Realizar uma venda para um cliente online.(aqui entra outros recursos como login, carrinho de compras, ...).
  </br>**.... pensando em mais recursos.**

### Quadro de verbos HTTP utilizados na construção da API
<p>Um quadro simples onde é mostrado o metodo HTTP utilizado, o identificador unico de recursos URI <br>
e suas query strings que são utilizadas para filtrar dados entre outras funções.</p> 

|Verbo HTTP|          URI             |                O que faz?          | 
|----------|--------------------------|------------------------------------|
|   get   | /products?page=0&size=10  | <p>Mostra todos os produtos cadastrados,</br>page é número atual da página que se está,</br>size é a quantidade de item por página que será exibido.</br>Pode ser inserido mais informações.</p>|
|   get   | /product/{id}             |<p>Busca um produto pelo id</p>      |
|   get   |/products/{productName}    |<p>O parametro **productName** é o nome do produto que se deseja pesquisar.</p>|

###Arquitetura
<p>
A arquitetura utilizada é a monolítica, tendo os dados centralizados em apenas uma base de dados<br>
e os recursos aclopados e dependentes um do outro. 
</p>