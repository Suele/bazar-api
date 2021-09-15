---------------------Cria a tabela de Produto----------------------
create TABLE IF NOT EXISTS product(
	product_id SERIAL PRIMARY KEY,
	product_name VARCHAR(23) NOT NULL,
	quantity smallint NOT NULL,
	description VARCHAR(35) NOT NULL,
	value_for_sale NUMERIC(7,2) NOT NULL,
	category_id SERIAL REFERENCES category(category_id) ON delete CASCADE ON update CASCADE
);

--------------Insere dados na tabela de Produto----------------
insert into product(product_name, quantity, description, value_for_sale, category_id) values('mouse', 6, 'sem fio', 219.90, 2);
insert into product(product_name, quantity, description, value_for_sale, category_id) values('teclado', 4, 'sem fio', 320.99, 2);
insert into product(product_name, quantity, description, value_for_sale, category_id) values('fone de ouvido', 2, 'com microfone e controle de volume', 200.99, 3);
insert into product(product_name, quantity, description, value_for_sale, category_id) values('mousepad', 3, 'fino', 90.99, 2);