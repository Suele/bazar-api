---------------------Cria a tabela para o relacionamento entre produto e venda----------------------
-----------------------relacionamento entre produto e venda surge outra tabela---------------------
----------------------------------por ser um relacionamento ManyToMany----------------------------
create TABLE IF NOT EXISTS items_sale(
    items_sale_id SERIAL PRIMARY KEY,
    product_id SERIAL REFERENCES product(product_id) ON delete CASCADE ON update CASCADE,
    sale_id SERIAL REFERENCES sale(sale_id) ON delete CASCADE ON update CASCADE
);