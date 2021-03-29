# Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT user.id          AS 'UserID',
       firstname,
       lastname,
       Count(orders.id) AS 'Number of Orders'
FROM   user
       JOIN orders
         ON orders.userid = user.id
WHERE  Datediff(Now(), orders.ordertime) <= 30
GROUP  BY user.id;

# Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT user.id                             AS 'UserID',
       firstname,
       lastname,
       Sum(productquantity * productprice) AS 'Revenue'
FROM   user
       JOIN orders
         ON user.id = orders.userid
       JOIN order_detail
         ON order_detail.orderid = orders.id
WHERE  Datediff(Now(), orders.ordertime) <= 30
       AND order_detail.status = 'SHIPPED'
GROUP  BY user.id
ORDER  BY revenue DESC
LIMIT  10;

# Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT product.id           AS 'ProductID',
       title,
       Sum(productquantity) AS 'Number of Orders'
FROM   orders
       JOIN order_detail
         ON order_detail.orderid = orders.id
       JOIN product
         ON order_detail.productid = product.id
WHERE  Datediff(Now(), orders.ordertime) <= 60
GROUP  BY product.id
ORDER  BY `number of orders` DESC
LIMIT  20;

# Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT Monthname(orders.ordertime)         AS 'Month',
       Sum(productquantity * productprice) AS 'Monthly Sales Revenue'
FROM   orders
       JOIN order_detail
         ON order_detail.orderid = orders.id
WHERE  orders.ordertime >= Curdate() - INTERVAL 6 month
       AND order_detail.status = 'SHIPPED'
GROUP  BY Month(orders.ordertime);

# Mark the products as Inactive which are not ordered in last 90 days.
SET sql_safe_updates=0;

UPDATE product
SET    product.status = 'INACTIVE'
WHERE  product.id NOT IN (SELECT product.id
                          FROM  (SELECT product.id
                                 FROM   product
                                        JOIN order_detail
                                          ON order_detail.productid = product.id
                                        JOIN orders
                                          ON order_detail.orderid = orders.id
                                 WHERE  Datediff(Now(), ordertime) <= 90) AS C);

SET sql_safe_updates=1;

# Given a category search keyword, display all the Products present in this category/categories. 
# (recursion needed here)
SELECT product.id AS 'ProductID',
       product.title
FROM   product
WHERE  product.categoryid IN (SELECT category.id
                              FROM   category
                              WHERE  category.parentid = (SELECT category.id
                                                          FROM   category
                                                          WHERE
                                     category.title = 'Mobile Phones'));

# Display top 10 Items which were cancelled most.
SELECT product.id,
       title,
       Sum(productquantity) AS 'Cancellation Count'
FROM   order_detail
       JOIN product
         ON order_detail.productid = product.id
WHERE  order_detail.status = 'CANCELLED'
GROUP  BY product.id
ORDER  BY `cancellation count` DESC
LIMIT  10; 