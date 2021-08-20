# Bazar-API

###O que é?
API para venda de produtos.

###Cenário
Em um bazar é possível encontrar diversos tipos de produtos para venda, então será feita a
divisão dos produtos em categorias.

###Recursos da API 
- [X] Mostrar todos os produtos disponíveis paginados.
- [ ] Buscar um produto pelo id.
- [ ] Buscar um produto pelo nome.
</br>**.... pensando em mais recursos.**

###URI Disponível para acesso
|Verbo HTTP|          URI             | O que faz?
|----------|--------------------------|------------------------------------|
|get|/products?page=0&size=10|<p>Mostra todos os produtos cadastrados,</br>page é número atual da página que se está,</br>size é a quantidade de item por página que será exibido.</br>Pode ser inserido mais informações.</p>|