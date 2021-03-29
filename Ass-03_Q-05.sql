# Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
CREATE view information
AS
  SELECT product.id                       AS 'ProductID',
         product.title                    AS 'Title',
         product.price,
         Concat(firstname, ' ', lastname) AS 'Shopper\'s Name',
         user.email,
         Date(orders.ordertime)           AS 'Order Date',
         order_detail.status
  FROM   user
         JOIN orders
           ON orders.userid = user.id
         JOIN order_detail
           ON orders.id = order_detail.orderid
         JOIN product
           ON order_detail.productid = product.id
  WHERE  Datediff(Now(), orders.ordertime) <= 60
  ORDER  BY orders.ordertime DESC;

# Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT *
FROM   information
WHERE  status = 'SHIPPED';

# Use the above view to display the top 5 most selling products.
SELECT `productid`,
       title,
       Count(*) AS 'Sale Count'
FROM   information
GROUP  BY `productid`
ORDER  BY `sale count` DESC
LIMIT  5; 