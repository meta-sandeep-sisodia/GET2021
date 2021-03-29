# Inserting data into table to simulate sql commands

# For order placed more than 10 days but still in PLACED state
INSERT INTO orders
            (id,
             ordertime,
             userid)
VALUES      ('5', '2021-03-14 01:01:01', '3');

INSERT INTO order_detail
            (id, orderid, productid, productquantity, productprice, status)
VALUES      ('6', '5', '1', 2, 9000, 'PLACED');

# For inactive user
INSERT INTO user
			(ID, FirstName, LastName, email, Role)
VALUES      ('6', 'User', 'Six', 'six@user.com', 'SHOPPER');

INSERT INTO address
            (id, street, area, district, state, pincode, country, userid)
VALUES      ('6', 'Bairaj Road', 'LIC Colony', 'Awas Vikas', 'Bijnor', '246701', 'India', '6');

INSERT INTO orders
            (id, ordertime, userid)
VALUES      ('6', '2021-01-01 01:01:01', '6');

INSERT INTO order_detail
            (id, orderid, productid, productquantity, productprice, status)
VALUES      ('7', '6', '1', 1, 20000, 'SHIPPED');


# Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT orders.id                           AS 'OrderID',
       Date(ordertime)                     AS 'Order Date',
       Sum(productprice * productquantity) AS 'Total'
FROM   orders
       JOIN order_detail
         ON orders.id = order_detail.orderid
GROUP  BY orders.id
ORDER  BY `order date` DESC
LIMIT  50;

# Display 10 most expensive Orders.
SELECT orders.id                           AS 'OrderID',
       Sum(productprice * productquantity) AS Total,
       userid
FROM   orders
       JOIN order_detail
         ON orders.id = order_detail.orderid
GROUP  BY orders.id
ORDER  BY total DESC
LIMIT  10;

# Display all the Orders which are placed more than 10 days ago, and one or more items from those orders are still not shipped.
SELECT orders.id       AS 'OrderID',
       Date(ordertime) AS 'Order Date',
       userid
FROM   orders
WHERE  Datediff(Now(), ordertime) > 10
       AND id IN (SELECT DISTINCT orderid
                  FROM   order_detail
                  WHERE  status = 'PLACED');

# Display list of shoppers which haven't ordered anything since last month.
SELECT userid,
       firstname,
       lastname,
       Datediff(Now(), ordertime) AS 'Days Since Inactive'
FROM   orders
       JOIN user
         ON orders.userid = user.id
WHERE  Datediff(Now(), ordertime) >= 30
       AND user.role = 'SHOPPER';

# Display list of shopper along with orders placed by them in last 15 days.
SELECT userid,
       firstname,
       lastname,
       orders.id       AS 'OrderID',
       productid,
       title,
       productprice,
       Date(ordertime) AS 'Order Date'
FROM   user
       JOIN orders
         ON user.id = orders.userid
       JOIN order_detail
         ON order_detail.orderid = orders.id
       JOIN product
         ON order_detail.productid = product.id
WHERE  Datediff(Now(), ordertime) <= 15;

# Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1))
SELECT orderid,
       productid,
       title,
       order_detail.status
FROM   order_detail
       JOIN product
         ON order_detail.productid = product.id
WHERE  order_detail.status = 'SHIPPED'
       AND orderid = '1';

# Display list of order items along with order placed date which fall between Rs. 1000 to Rs. 10000 price.
SELECT productid,
       title,
       productprice,
       Date(ordertime) AS 'Order Date'
FROM   product
       JOIN order_detail
         ON order_detail.productid = product.id
       JOIN orders
         ON orders.id = order_detail.orderid
WHERE  productprice BETWEEN 1000 AND 10000; 