---------------Este arquivo contem todas os scripts SQL para criar as tabelas utilizadas no projeto Bazar-------------

---------------Cria a tabela Marca de Produto---------------
CREATE TABLE IF NOT EXISTS brand(
	brand_id SERIAL PRIMARY KEY,
	brand_name VARCHAR(18) NOT NULL UNIQUE
);

----------------Cria a tabela de categoria-------------------
CREATE TABLE category(
	category_id SERIAL PRIMARY KEY,
	category_name VARCHAR(19) NOT NULL UNIQUE
);

----------------Cria a tabela de Produto----------------------
CREATE TABLE IF NOT EXISTS product(
	product_id SERIAL PRIMARY KEY,
	product_name VARCHAR(23) NOT NULL,
	quantity smallint NOT NULL,
	description VARCHAR(35) NOT NULL,
	value_for_sale NUMERIC(7,2) NOT NULL,
	category_id SERIAL REFERENCES category(category_id) ON delete CASCADE ON update CASCADE
);

----------------Cria a tabela de fornecedor--------------------------
CREATE TABLE IF NOT EXISTS provider(
	provider_id SERIAL PRIMARY KEY,
	provider_name VARCHAR(61) NOT NULL,
	cnpj VARCHAR(14) NOT NULL UNIQUE
);

----------------Cria a tabela para o relacionamento entre fornecedor e produto---------------
----------------relacionamento entre product e provider surge outra tabela-------------------
-------------------por ser um relacionamento ManyToMany----------------------------
CREATE TABLE product_provider(
	id SERIAL PRIMARY KEY,
	product_id SERIAL REFERENCES product(product_id) ON delete CASCADE ON update CASCADE,
	provider_id SERIAL REFERENCES provider(provider_id) ON delete CASCADE ON update CASCADE
);

--------------------Cria a tabela para o relacionamento entre produto e marca---------------
---------------------relacionamento entre product e brand surge outra tabela----------------
--------------------------por ser um relacionamento ManyToMany-------------------------
CREATE TABLE IF NOT EXISTS product_brand(
	id SERIAL PRIMARY KEY,
	product_id SERIAL REFERENCES product(product_id) ON delete CASCADE ON update CASCADE,
	brand_id SERIAL REFERENCES brand(brand_id) ON delete CASCADE ON update CASCADE
);

----------------------Cria a tabela de venda-----------------
CREATE TABLE IF NOT EXISTS sale(
	sale_id SERIAL PRIMARY KEY,
	sale_date date DEFAULT Now() NOT NULL,
	total NUMERIC(7,2) NOT NULL
);

---------------------Cria a tabela para o relacionamento entre produto e venda----------------------
-----------------------relacionamento entre produto e venda surge outra tabela---------------------
----------------------------------por ser um relacionamento ManyToMany----------------------------
CREATE TABLE IF NOT EXISTS items_sale(
    items_sale_id SERIAL PRIMARY KEY,
    product_id SERIAL REFERENCES product(product_id) ON delete CASCADE ON update CASCADE,
    sale_id SERIAL REFERENCES sale(sale_id) ON delete CASCADE ON update CASCADE
);

--------------------------------------------------------------------------------------------------------------------
---cliente---
create TABLE IF NOT EXISTS client(
	id SERIAL PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	birthaday date NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	phone_id SERIAL REFERENCES phone(id) ON delete CASCADE ON update CASCADE,
	address_id SERIAL REFERENCES address(id) ON delete CASCADE ON update CASCADE
);

---telefone---
create TABLE IF NOT EXISTS phone(
	id SERIAL PRIMARY KEY,
	area_code smallint NOT NULL,
	phone_number VARCHAR(11) NOT NULL UNIQUE
);

---endereco---
create TABLE IF NOT EXISTS address(
	id SERIAL PRIMARY KEY,
	street VARCHAR(20) NOT NULL,
	number_street smallint NOT NULL,
	zipcode VARCHAR(9) NOT NULL,
	city VARCHAR(18) NOT NULL,
	state VARCHAR(21) NOT NULL
);