--------------------Cria a tabela para o relacionamento entre produto e marca---------------
---------------------relacionamento entre product e brand surge outra tabela----------------
--------------------------por ser um relacionamento ManyToMany-------------------------
create TABLE IF NOT EXISTS product_brand(
	id SERIAL PRIMARY KEY,
	product_id SERIAL REFERENCES product(product_id) ON delete CASCADE ON update CASCADE,
	brand_id SERIAL REFERENCES brand(brand_id) ON delete CASCADE ON update CASCADE
);

--------------Insere dados na tabela----------------
insert into product_brand(product_id, brand_id) values(1, 3);
insert into product_brand(product_id, brand_id) values(2, 1);
insert into product_brand(product_id, brand_id) values(3, 2);

