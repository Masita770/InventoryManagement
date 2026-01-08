--DROP TABLE IF EXISTS items;

CREATE TABLE IF NOT EXISTS items(
    items_id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category varchar(256) NOT NULL,
    item varchar(256) NOT NULL,
    registration_date timestamp,
    deleted_date boolean
    );

CREATE TABLE IF NOT EXISTS stocks(
    stocks_id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    items_id int(11) NOT NULL,
    quantity int(100) NOT NULL,
    update_date timestamp
    );

--DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS orders(
    orders_id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    items_id int(11) NOT NULL,
    order_date int(11) NOT NULL,
    delivery_date timestamp,
    deleted_date boolean
    );