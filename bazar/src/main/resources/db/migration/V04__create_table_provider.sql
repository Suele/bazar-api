----------------Cria a tabela de fornecedor--------------------------
CREATE TABLE IF NOT EXISTS provider(
	provider_id SERIAL PRIMARY KEY,
	provider_name VARCHAR(61) NOT NULL,
	cnpj VARCHAR(14) NOT NULL UNIQUE
);

--------------Insere dados na tabela de Produto----------------
insert into provider(provider_name, cnpj) values('logitech do Brasil comercio e acessorio de informatica LTDA', '08573862000115');
insert into provider(provider_name, cnpj) values('dell computadores do Brasil LTDA', '72381189000110');
insert into provider(provider_name, cnpj) values('jbl/Brasil LTDA', '03588982000172');
insert into provider(provider_name, cnpj) values('razor do Brasil LTDA', '19847182000169');

