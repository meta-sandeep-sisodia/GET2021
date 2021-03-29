# Deleting database
DROP DATABASE StoreFront;

# Creating database
CREATE DATABASE StoreFront;

# Selecting database
USE StoreFront;

# Writing all CREATE commands for tables described in Assignment 01 ERD
CREATE TABLE user
  (
     id        VARCHAR(10) PRIMARY KEY,
     firstname VARCHAR(20),
     lastname  VARCHAR(20),
     email     VARCHAR(40),
     role      ENUM('SHOPPER', 'ADMIN')
  );

CREATE TABLE address
  (
     id       VARCHAR(10) PRIMARY KEY,
     street   VARCHAR(50),
     area     VARCHAR(50),
     district VARCHAR(50),
     state    VARCHAR(50),
     pincode  VARCHAR(10),
     country  VARCHAR(50),
     userid   VARCHAR(10),
     FOREIGN KEY (userid) REFERENCES user (id) ON DELETE CASCADE
  );

CREATE TABLE category
  (
     id       VARCHAR(10) PRIMARY KEY,
     title    VARCHAR(20),
     parentid VARCHAR(20),
     FOREIGN KEY (parentid) REFERENCES category (id) ON DELETE CASCADE
  );

CREATE TABLE product
  (
     id          VARCHAR(10) PRIMARY KEY,
     title       VARCHAR(50),
     description VARCHAR(100),
     status      ENUM('ACTIVE', 'INACTIVE'),
     price       DOUBLE,
     stock       INT,
     timeadded   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
     categoryid  VARCHAR(10),
     FOREIGN KEY (categoryid) REFERENCES category (id) ON DELETE CASCADE
  );

CREATE TABLE image
  (
     id        VARCHAR(10) PRIMARY KEY,
     title     VARCHAR(50),
     productid VARCHAR(10),
     FOREIGN KEY (productid) REFERENCES product (id) ON DELETE CASCADE
  );

CREATE TABLE orders
  (
     id        VARCHAR(10) PRIMARY KEY,
     ordertime TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
     userid    VARCHAR(10),
     FOREIGN KEY (userid) REFERENCES user (id) ON DELETE CASCADE
  );

CREATE TABLE order_detail
  (
     id              VARCHAR(10) PRIMARY KEY,
     orderid         VARCHAR(10),
     productid       VARCHAR(10),
     productprice    DOUBLE,
     productquantity INT,
     status          ENUM('PLACED', 'SHIPPED', 'CANCELLED', 'RETURNED'),
     FOREIGN KEY (orderid) REFERENCES orders (id) ON DELETE CASCADE,
     FOREIGN KEY (productid) REFERENCES product (id) ON DELETE CASCADE
  );

# Command to display all the table names present in StoreFront
SHOW tables;

# Command to remove Product table of the StoreFront database
SET foreign_key_checks=0;

DROP TABLE product;

SET foreign_key_checks=1;

# Create the Product table again
CREATE TABLE product
  (
     id          VARCHAR(10) PRIMARY KEY,
     title       VARCHAR(50),
     description VARCHAR(100),
     status      ENUM('ACTIVE', 'INACTIVE'),
     price       DOUBLE,
     stock       INT,
     timeadded   TIMESTAMP DEFAULT now(),
     categoryid  VARCHAR(10),
     FOREIGN KEY (categoryid) REFERENCES category (id) ON DELETE CASCADE
  ); 