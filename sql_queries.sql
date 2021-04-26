
#Inserts
#Adding Addresses
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (1, "Kanada 1223", 2554, 1);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (2, "Brasil 253", 2554, 1);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (10, "Brasil 3", 2554, 1);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (3, "San Lorenzo 6223", 2554, 1);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (4, "Argentina 2131", 1500, 2);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (5, "Av. Alberdi 23", 1500, 2);
INSERT INTO Addresses (id, address, zip_code,Cities_id) 
VALUES (6, "25 may", 1500, 2);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (7, "av.America", 3500, 3);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (8, "Paraguay", 3500, 3);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (11, "Paraguay 123", 3500, 2);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (12, "2 de abril 2323", 3500, 3);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (13, "2 de abril 773", 2554, 1);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (14, "Liniers 123", 2554, 1);
INSERT INTO Addresses (id, address, zip_code, Cities_id) 
VALUES (15, "25 de mayo 155", 2554, 1);

#Adding cities
INSERT INTO Cities (id, `name`)
VALUES (1, "Buenos Aires"); 
INSERT INTO Cities (id, `name`)
VALUES (2, "Cordoba");
INSERT INTO Cities (id, `name`)
VALUES (3, "Chaco"); 

#adding Customers
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (1, "Juan Manuel Rovira", "jm@gmail.com", "p4s$w0rd", "1");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (2, "Pedro Sanchez", "psancez@gmail.com", "p4s$w0rd", "2");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (3, "Eduard Martinez", "eduMart@hotmail.com", "p13213", "3");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (4, "Santiago Smith", "smiths@deescorp.com", "p4wd", "4");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (5, "Pablo Perez", "pperez@gmail.com", "p4s$w0rd", "5");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (6, "Jorge Fernandez", "jf@gmail.com", "p$w0rd", "6");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (7, "Carl Paez", "cpaez@gmail.com", "p1234", "7");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (8, "Maria Martins", "mm@sandmail.com", "p42223", "8");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (9, "Apolo Mc Mortins", "apsood@gmail.com", "pk12n39", "9");
INSERT Customers (id, `name`, email, `password`, Addresses_id)
VALUES (10, "lian young", "lianyong12@gmail.com", "p4fw0rd", "1");

#Adding restaurants
INSERT Restaurants (id, `name`, `description`, Addresses_id)
VALUES (1, "burguers house", "American traditional burgers", 1);
INSERT Restaurants (id, `name`, `description`,Addresses_id)
VALUES (2, "Mc Donald's", "burgers and fries", 1);
INSERT Restaurants (id, `name`, `description`,Addresses_id)
VALUES (3, "Burguer king", "Real burgers and fries", 1);
INSERT Restaurants (id, `name`, `description`, Addresses_id)
VALUES (4, "Pizza-One", "best Pizza", 13);

#Order status
INSERT TransactionStatus (id, `name`)
VALUES (1, "PROCESING ORDER");
INSERT TransactionStatus (id, `name`)
VALUES (2, "ACCEPTED");
INSERT TransactionStatus (id, `name`)
VALUES (3, "REJECTED");
INSERT TransactionStatus (id, `name`)
VALUES (5, "READY AND SHIPED");
INSERT TransactionStatus (id, `name`)
VALUES (6, "COMPLETED");
INSERT TransactionStatus (id, `name`)
VALUES (7, "IN PROGRESS");

INSERT PaymentTypes(id, `name`, `description`)
VALUES (1, "CREDIT CARD", "Credit card payment");
INSERT PaymentTypes(id, `name`, `description`)
VALUES (2, "CASH", "cash payment");

# Adding Menus
INSERT Menus (id, `name`, restaurant_id) 
VALUES (1, "cheese burger", 1);
INSERT Menus (id, `name`, restaurant_id)
VALUES (2, "double cheese burger ", 1);
INSERT Menus (id, `name`, restaurant_id)
VALUES (3, "", 3);
INSERT Menus (id, `name`, restaurant_id)
VALUES (4, "Pizza-One Menu", 4);

#ingredients
INSERT Ingredients (id, `name`, `description`, price)
VALUES (1, "Meat Burger","burger begins with a 100% pure beef", 1.20);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (4, "fries","chips", 1.0);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (2, "cheese","cheese", 0.35);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (3, "tomato","tomato", 0.2);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (5, "pickle","pickle", 0.15);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (6, "egg","egg", 0.05);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (7, "bread","bread", 0.1);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (8, "Mayonnaise","Mayonnaise", 0.02);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (10, "ketchup","ketchup", 0.02);
INSERT Ingredients (id, `name`, `description`, price)
VALUES (9, "ketchup","Our simple, classic cheeseburger begins with a 100% pure beef", 0.02);

#cheese burger
INSERT Menu_has_Ingredients (Menu_id, Ingredients_id, quantity)
VALUES (1, 1, 1);
INSERT Menu_has_Ingredients (Menu_id, Ingredients_id, quantity)
VALUES (1, 2, 1);
INSERT Menu_has_Ingredients (Menu_id, Ingredients_id, quantity)
VALUES (1, 7, 1);
INSERT Menu_has_Ingredients (Menu_id, Ingredients_id, quantity)
VALUES (1, 8, 1);


#double burger
INSERT Menu_has_Ingredients (Menu_id, Ingredients_id, quantity)
VALUES (2, 1, 2);
INSERT Menu_has_Ingredients (Menu_id, Ingredients_id, quantity)
VALUES (2, 2, 1);
INSERT Menu_has_Ingredients (Menu_id, Ingredients_id, quantity)
VALUES (2, 7, 1);
INSERT Menu_has_Ingredients (Menu_id, Ingredients_id, quantity)
VALUES (2, 8, 1);

#order
INSERT Orders (id, customer_id, restaurant_id, TransactionStatus_id, Menu_id)
VALUES (1, 1, 1, 1, 1);
INSERT Orders (id, customer_id, restaurant_id, TransactionStatus_id, Menu_id)
VALUES (2, 1, 1, 1, 2);
INSERT Orders (id, customer_id, restaurant_id, TransactionStatus_id, Menu_id)
VALUES (3, 2, 1, 1, 2);
INSERT Orders (id, customer_id, restaurant_id, TransactionStatus_id, Menu_id)
VALUES (4, 3, 3, 2, 2);


UPDATE Restaurants SET Addresses_id = 10 WHERE id = 1;
UPDATE Restaurants SET Addresses_id = 11 WHERE id = 2;
UPDATE RestaurantsCities SET Addresses_id = 12 WHERE id = 3;
UPDATE Restaurants SET `name` = 'Burger king' WHERE id = 3;
UPDATE Restaurants SET `name` = 'burgers house' WHERE id = 1;
UPDATE Restaurants SET Addresses_id = 2 WHERE id = 2;
UPDATE Restaurants SET Addresses_id = 3 WHERE id = 3;

ALTER TABLE Orders DROP COLUMN amount;
ALTER TABLE Addresses MODIFY zip_code int;
ALTER TABLE Customers DROP COLUMN address;
ALTER TABLE Restaurants DROP COLUMN address;
ALTER TABLE Menus DROP COLUMN Orders_id1;
ALTER TABLE Restaurants CHANGE Addresses_id address_id int;
ALTER TABLE Menu RENAME TO  Menus;
ALTER TABLE MenuItem DROP FOREIGN KEY fk_MenuItem_Menu1;
ALTER TABLE Menus ADD column menuItem_id int NOT NULL;
ALTER TABLE Menus ADD CONSTRAINT fk_menuItem FOREIGN KEY (menuItem_id) REFERENCES MenuItem(id);
ALTER TABLE Restaurants DROP COLUMN address;
ALTER TABLE  MenuItem DROP column Menu_id;

# Base Select
SELECT * FROM Restaurants;
SELECT * FROM Customers;
SELECT * FROM Cities;
SELECT * FROM Addresses;
SELECT * FROM TransactionStatus;
SELECT * FROM Menus;
SELECT * FROM Orders;
SELECT * FROM Ingredients;
SELECT * FROM Menu_has_Ingredients;

# select customers by city name
SELECT c.`name` as customer_name, c.email as customer_email, cy.`name` as city_name, a.address as customer_address, a.zip_code as customer_zip_code
FROM Customers as c INNER JOIN Addresses as a INNER JOIN Cities as cy 
ON c.Addresses_id = a.id and a.Cities_id = cy.id
WHERE cy.`name` = "Buenos Aires";

# select all menus with their correspondent ingredients
SELECT m.`name` as menu_name, i.id as ingredient_id, i.`name` as ingredient_name, i.`description` as ingredient_desc, i.price as ingredient_price, mhi.quantity as ingredient_qty
FROM Menus as m INNER JOIN Menu_has_Ingredients as mhi INNER JOIN Ingredients as i 
ON mhi.Ingredients_id = i.id and mhi.Menu_id = m.id;

# get price by menu id
SELECT mhi.Menu_id as menu_id, SUM(mhi.quantity * i.price)  as price 
FROM Menu_has_Ingredients as mhi INNER JOIN Ingredients as i ON mhi.Menu_id = 2 AND mhi.Ingredients_id = i.id;

# get all menus with price
SELECT DISTINCT m.id as menu_id, m.`name` as menu_name, SUM(mhi.quantity * i.price) as price
FROM Menus as m INNER JOIN Menu_has_Ingredients as mhi INNER JOIN Ingredients as i
ON mhi.Ingredients_id = i.id and m.id = mhi.Menu_id
WHERE m.id = mhi.Menu_id
GROUP BY menu_id, menu_name, price;

# Get restaurant list with menus and prices
SELECT r.id as restaurant_id, r.`name` as resutaurant_name, m.id as menu_id, m.`name` as menu_name, result.menu_price
FROM Menus as m INNER JOIN (
							SELECT mhi.Menu_id as menu_id, SUM(mhi.quantity * i.price) as menu_price
							FROM Menu_has_Ingredients as mhi INNER JOIN Ingredients i 
							ON mhi.Ingredients_id = i.id
                            GROUP BY menu_id
                            ) as result
INNER JOIN Restaurants as r
ON result.menu_id = m.id and r.id = m.restaurant_id;

# Ingredients for a menu id 
SELECT mhi.Ingredients_id as ingredient_id, i.`name` as ingredient_name, i.`description` as ingredient_desc, i.price as ingredient_price
FROM Menu_has_Ingredients as mhi INNER JOIN Ingredients as i 
ON mhi.Ingredients_id = i.id and mhi.Menu_id = 1; 

# get information about an order 
SELECT o.id as order_id, o.restaurant_id as restaurant_id, mhi.Menu_id as menu_id, o.customer_id as customer_id, SUM(mhi.quantity * i.price) as menu_price
FROM Menu_has_Ingredients as mhi INNER JOIN Ingredients as i INNER JOIN Orders as o
ON mhi.Ingredients_id = i.id AND o.Menu_id = mhi.Menu_id
GROUP BY order_id, restaurant_id, menu_id, customer_id;

# get transaction status given order id
SELECT o.id as order_id, ts.`name` as transaction_name
FROM Orders as o INNER JOIN TransactionStatus as ts 
ON o.TransactionStatus_id = ts.id;

# get info about an order with status
SELECT o.id as order_id, o.restaurant_id as restaurant_id, mhi.Menu_id as menu_id, o.customer_id as customer_id, SUM(mhi.quantity * i.price) as menu_price, ts.`name` as transaction_status
FROM Menu_has_Ingredients as mhi INNER JOIN Ingredients as i INNER JOIN Orders as o INNER JOIN TransactionStatus as ts
ON mhi.Ingredients_id = i.id AND o.Menu_id = mhi.Menu_id AND o.TransactionStatus_id = ts.id
GROUP BY order_id, restaurant_id, menu_id, customer_id, transaction_status;

# get readable info about an order
SELECT result.order_id as order_id, r.`name` as restaurant_name, m.`name` as menu_name, c.`name` as customer_name, result.menu_price as menu_price, result.transaction_status as transaction_status
FROM Customers as c INNER JOIN Menus as m INNER JOIN Restaurants as r
INNER JOIN (
			SELECT o.id as order_id, o.restaurant_id as restaurant_id, mhi.Menu_id as menu_id, o.customer_id as customer_id, SUM(mhi.quantity * i.price) as menu_price, ts.`name` as transaction_status
			FROM Menu_has_Ingredients as mhi INNER JOIN Ingredients as i INNER JOIN Orders as o INNER JOIN TransactionStatus as ts
			ON mhi.Ingredients_id = i.id AND o.Menu_id = mhi.Menu_id AND o.TransactionStatus_id = ts.id
			GROUP BY order_id, restaurant_id, menu_id, customer_id, transaction_status
            ) as result
ON c.id = result.customer_id AND r.id = result.restaurant_id AND m.id = result.menu_id 
GROUP BY order_id, restaurant_name, menu_name, customer_name, menu_price, transaction_status;

# get sum of all order prices
SELECT SUM(mhi.quantity * i.price) as orders_total_price 
FROM Menu_has_Ingredients as mhi INNER JOIN Ingredients as i INNER JOIN Orders as o
ON mhi.Ingredients_id = i.id AND o.Menu_id = mhi.Menu_id