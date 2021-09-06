---marca---
CREATE TABLE IF NOT EXISTS brand(
	id SERIAL PRIMARY KEY,
	name VARCHAR(15) NOT NULL
);

---categoria----
CREATE TABLE IF NOT EXISTS category(
	id SERIAL PRIMARY KEY,
	name VARCHAR(18) NOT NULL UNIQUE
);

---cliente---
CREATE TABLE IF NOT EXISTS client(
	id SERIAL PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	birthaday date NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	phone_id SERIAL REFERENCES phone(id) ON DELETE CASCADE ON UPDATE CASCADE,
	address_id SERIAL REFERENCES address(id) ON DELETE CASCADE ON UPDATE CASCADE
);

---telefone---
CREATE TABLE IF NOT EXISTS phone(
	id SERIAL PRIMARY KEY,
	area_code smallint NOT NULL,
	phone_number VARCHAR(11) NOT NULL UNIQUE
);

---endereco---
CREATE TABLE IF NOT EXISTS address(
	id SERIAL PRIMARY KEY,
	street VARCHAR(20) NOT NULL,
	number_street smallint NOT NULL,
	zipcode VARCHAR(9) NOT NULL,
	city VARCHAR(18) NOT NULL,
	state VARCHAR(21) NOT NULL
);

---fornecedor----
CREATE TABLE IF NOT EXISTS provider(
	id SERIAL PRIMARY KEY,
	name VARCHAR(25) NOT NULL,
	cnpj VARCHAR(14) NOT NULL
);

---produto----
CREATE TABLE IF NOT EXISTS product(
	product_id SERIAL PRIMARY KEY,
	name_product VARCHAR(20) NOT NULL,
	quantity smallint NOT NULL,
	description VARCHAR(30) NOT NULL,
	value_for_sale NUMERIC(7,2) NOT NULL,
	category_id SERIAL REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE
);

--------Itens da venda---
-------relacionamento entre produto e venda surge outra tabela-----
------um produto pode estar em uma venda ou muitos------
------uma venda pode ter um produto ou muitos produtos-----
CREATE TABLE IF NOT EXISTS items_sale(
items_sale_id SERIAL PRIMARY KEY,
product_id REFERENCES product(product_id) ON DELETE CASCADE ON UPDATE CASCADE,
sale_id REFERENCES sale(sale_id) ON DELETE CASCADE ON UPDATE CASCADE
);

---venda----
CREATE TABLE IF NOT EXISTS sale(
	sale_id SERIAL PRIMARY KEY,
	sale_date date DEFAULT Now() NOT NULL,
	total NUMERIC(7,2) NOT NULL
);

---relacionamento entre product e provider surge outra tabela---
---por ser um relacionamento ManyToMany----
CREATE TABLE product_provider(
	id SERIAL PRIMARY KEY,
	product_id SERIAL REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE,
	provider_id SERIAL REFERENCES provider(id) ON DELETE CASCADE ON UPDATE CASCADE
);

---relacionamento entre product e brand surge outra tabela---
---por ser um relacionamento ManyToMany----
CREATE TABLE product_brand(
	id SERIAL PRIMARY KEY,
	product_id SERIAL REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE,
	brand_id SERIAL REFERENCES brand(id) ON DELETE CASCADE ON UPDATE CASCADE
);