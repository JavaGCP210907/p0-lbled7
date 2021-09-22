 --creating two banking tables related to each other:  cards and customers
 
 
 --card table first
 CREATE TABLE credit_cards(
 	card_id serial PRIMARY key,
 	card_name TEXT,
 	card_limit int);
 
 CREATE TABLE customers(
 	customer_id serial PRIMARY key,
 	f_name TEXT,
 	l_name TEXT,
 	debit_balance decimal(10,2),
 	card_id int REFERENCES credit_cards (card_id));
 
 INSERT INTO credit_cards (card_name,card_limit)
 VALUES ('Basic',800),
 		('Premier',2000),
 		('Travel',5000),
 		('Platinum',10000);
 	SELECT * FROM credit_cards;
 
 INSERT INTO customers (f_name,l_name,debit_balance,card_id)
 VALUES ('Lucas','Bledsoe',10000.50,3),
 		('Joe','Smith',5000.50,2),
 		('Steve','Smith',74000,4),
 		('Rachel','Walsh',56000,4);
 SELECT * FROM customers;
 
SELECT * FROM customers INNER JOIN credit_cards ON customers.card_id = credit_cards.card_id WHERE card_name = 'Travel';

TRUNCATE TABLE customers;
SELECT * FROM customers;
DELETE FROM customers WHERE customer_id=5;

