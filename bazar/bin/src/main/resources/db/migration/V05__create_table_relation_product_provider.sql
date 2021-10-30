----------------Cria a tabela para o relacionamento entre fornecedor e produto---------------
----------------relacionamento entre product e provider surge outra tabela-------------------
-------------------por ser um relacionamento ManyToMany----------------------------
create TABLE product_provider(
	id SERIAL PRIMARY KEY,
	product_id SERIAL REFERENCES product(product_id) ON delete CASCADE ON update CASCADE,
	provider_id SERIAL REFERENCES provider(provider_id) ON delete CASCADE ON update CASCADE
);

--------------Insere dados na tabela----------------
insert into product_provider(product_id, provider_id) values(1, 2);
insert into product_provider(product_id, provider_id) values(2, 1);
insert into product_provider(product_id, provider_id) values(3, 3);
