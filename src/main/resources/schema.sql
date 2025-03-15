CREATE TABLE IF NOT EXISTS items(
    items_id int(11) NOT NULL AUTO_INCREMENT,
    category varchar(255)) NOT NULL,
    item varchar(255) NOT NULL,
    registration_date timestamp,
    deleted_date timestamp,
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS stocks(
    )