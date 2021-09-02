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
- [X] Adicionar produtos no carrinho de compras.
- [ ] Remove um produto do carrinho.
- [ ] Realizar uma venda no local.
- [ ] Realizar uma venda para um cliente online.(aqui entra outras funcionalidades como login, 
</br>adicionar e remover itens do carrinho de compras, ...).
  </br>**.... pensando em mais recursos.**

### Métodos HTTP utilizados na API
<p>Um quadro simples onde é mostrado os métodos HTTP utilizados, a URI para acessar os recursos disponíveis,<br>
as query strings ou parametros que são utilizadas para filtrar os dados entre outras funções.</p> 

| Método HTTP |          URI                |                O que faz?                                                                                          | Caso o recurso não seja encontrado
|-------------|-----------------------------|--------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
|   get       | /products/?page=0&size=10   | <p>Mostra todos os produtos cadastrados,</br>page é número atual da página que se está,</br>size é a quantidade de item por página que será exibido.</p>|
|   get       | /product/{**id**}           | <p>Retorna o produto que corresponde ao **id** </br>e o **status code 200**.</p>|<p>Retorna **status code 404** </br> **mensagem** e o **path** da URI.</p>
|   get       | /products/{**productName**} | <p>O parametro **productName** é o nome do produto</br> que se deseja pesquisar.</p>| <p>Retorna **status code 404**</br> **mensagem: Produto não encontrado.**</p>
|   get       | /cart/{**productName**}     | <p>Adiciona um produto pelo nome no carrinho de compras</br>retorna **status code 200**, a quantidade de itens e o total de produtos.</p> |

###Arquitetura
<p>
A arquitetura utilizada é a monolítica, tendo os dados centralizados em apenas uma base de dados
e os recursos aclopados e dependentes,</br>a escolha por essa arquitetura é porque o objetivo é manter a simplicidade e focar no aprendizado. 
</p>