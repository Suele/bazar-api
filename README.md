#Bazar-API

###O que é?
API para venda de diversos produtos.

###Cenário
Em um bazar é possível encontrar diversos tipos de produtos para venda, então será feita a
divisão dos produtos em categorias.

###Recursos da API 
- [X] Mostrar todos os produtos disponíveis paginados.
- [ ] Buscar um produto pelo id.
- [ ] Buscar um produto pelo nome.
</br>**.... pensando em mais recursos.**

###Quadro de verbos HTTP utilizados na construção da API
<p>Um quadro simples onde é mostrado o metodo HTTP utilizado, o identificador unico de recursos URI <br>
e suas query strings que são utilizadas para filtrar dados entre outras funções.</p> 

|Verbo HTTP|          URI             |                O que faz?           
|----------|--------------------------|------------------------------------|
|get|/products?page=0&size=10|<p>Mostra todos os produtos cadastrados,</br>page é número atual da página que se está,</br>size é a quantidade de item por página que será exibido.</br>Pode ser inserido mais informações.</p>|