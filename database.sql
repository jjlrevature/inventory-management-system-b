-- DROP SCHEMA inventory;

CREATE SCHEMA inventory AUTHORIZATION postgres;


-- inventory.product_id_seq definition

-- DROP SEQUENCE inventory.product_id_seq;

CREATE SEQUENCE inventory.product_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- inventory.product_stock_id_seq definition

-- DROP SEQUENCE inventory.product_stock_id_seq;

CREATE SEQUENCE inventory.product_stock_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;



-- inventory.product definition

-- Drop table

-- DROP TABLE inventory.product;

CREATE TABLE inventory.product (
	id serial NOT NULL,
	title varchar(40) NOT NULL,
	manufacturer varchar(40) NOT NULL,
	category varchar(20) NULL,
	minimum_limit int4 NULL,
	CONSTRAINT product_pk PRIMARY KEY (id),
	CONSTRAINT product_un UNIQUE (title)
);

-- inventory.product_stock definition

-- Drop table

-- DROP TABLE inventory.product_stock;

CREATE TABLE inventory.product_stock (
	id serial NOT NULL,
	product_id int4 NOT NULL,
	transaction_date date NOT NULL,
	vendor varchar(40) NOT NULL,
	batch_code varchar(10) NULL,
	invoice_number varchar(10) NULL,
	quantity int4 NOT NULL,
	transaction_type varchar(3) NOT NULL,
	CONSTRAINT product_stock_pk PRIMARY KEY (id)
);


-- inventory.product_stock foreign keys

ALTER TABLE inventory.product_stock ADD CONSTRAINT product_stock_fk FOREIGN KEY (product_id) REFERENCES inventory.product(id);