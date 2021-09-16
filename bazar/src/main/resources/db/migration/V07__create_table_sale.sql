----------------------Cria a tabela de venda-----------------
CREATE TABLE IF NOT EXISTS sale(
	sale_id SERIAL PRIMARY KEY,
	sale_date date DEFAULT Now() NOT NULL,
	total NUMERIC(7,2) NOT NULL
);