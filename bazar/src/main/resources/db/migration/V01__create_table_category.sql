CREATE TABLE category(
	category_id SERIAL PRIMARY KEY,
	category_name VARCHAR(19) NOT NULL UNIQUE
);

insert into category(category_name) values('escritório');
insert into category(category_name) values('periférico');
