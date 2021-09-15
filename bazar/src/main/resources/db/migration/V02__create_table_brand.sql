----------Marca de Produto------------
create TABLE IF NOT EXISTS brand(
	brand_id SERIAL PRIMARY KEY,
	brand_name VARCHAR(18) NOT NULL UNIQUE
);

-----------Insere marcas dos produtos--------------
insert into brand(brand_name) values('logitech');
insert into brand(brand_name) values('jbl');
insert into brand(brand_name) values('dell');
insert into brand(brand_name) values('razer basilisk');

-----------Insere mais categorias----------------
insert into category(category_name) values('som');
insert into category(category_name) values('para casa');
insert into category(category_name) values('cozinha');
