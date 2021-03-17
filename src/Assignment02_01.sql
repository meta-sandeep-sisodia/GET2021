DROP DATABASE store_front;
CREATE DATABASE store_front;
USE store_front;

CREATE TABLE user (
    userId INT NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL
);


CREATE TABLE admin (
    adminId INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (adminId)
        REFERENCES user (userId)
);

CREATE TABLE shopper (
    shopper_id INT,
    phone_no long NOT NULL,
    sex VARCHAR(6) NOT NULL,
    FOREIGN KEY (shopper_id)
        REFERENCES user (userId)
);

CREATE TABLE address (
    address_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(15),
    district VARCHAR(25),
    state VARCHAR(25),
    pincode INT(6) NOT NULL,
    shopper_id INT,
    FOREIGN KEY (shopper_id)
        REFERENCES shopper (shopper_id)
);


CREATE TABLE category (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    parent_id INT,
    FOREIGN KEY (parent_id)
        REFERENCES category (id)
);


CREATE TABLE product (
    product_id INT PRIMARY KEY,
    price FLOAT(20) NOT NULL,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(100) NOT NULL,
    category_id INT,
    date DATE,
    status VARCHAR(10),
    FOREIGN KEY (category_id)
        REFERENCES category (id)
);

CREATE TABLE image (
    product_id INT,
    img VARCHAR(150),
    FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);



CREATE TABLE stock (
    product_id INT,
    quantity INT DEFAULT 0,
    date_added DATE,
    FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);

CREATE TABLE cart (
    product_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (product_id)
        REFERENCES stock (product_id)
);

CREATE TABLE ordertable (
    orderid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    orderDate DATE,
    shopper_id INT,
    address_id INT,
    FOREIGN KEY (shopper_id)
        REFERENCES shopper (shopper_id),
    FOREIGN KEY (address_id)
        REFERENCES address (address_id)
);

CREATE TABLE ordersItem (
    status VARCHAR(30) NOT NULL DEFAULT 'IN PROCESS',
    orderid INT,
    product_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (orderid)
        REFERENCES ordertable (orderid),
    FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);

show tables;
set FOREIGN_KEY_CHECKS = 0;
Drop table product;
set FOREIGN_KEY_CHECKS = 1;


CREATE TABLE product (
    product_id INT PRIMARY KEY,
    price FLOAT(20) NOT NULL,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(100) NOT NULL,
    category_id INT,
    date DATE,
    status VARCHAR(10),
    FOREIGN KEY (category_id)
        REFERENCES category (id)
);
