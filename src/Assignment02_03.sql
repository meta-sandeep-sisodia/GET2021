INSERT INTO ordertable(orderDate,shopper_id, address_id)
            VALUES("2021-03-05", 01, 1),
            ("2021-03-10",01, 1),
            ("2021-03-15", 02, 2),
            ("2021-03-25", 02, 2),
            ("2021-03-30", 03, 3),
            ("2021-03-05", 04, 4),
            ("2021-03-05", 04, 4);


SELECT * FROM ordertable;

INSERT INTO ordersItem(status, orderid, product_id,  quantity)
                VALUES("DELIVERED", 1, 101, 1),
                ("DELIVERED", 2, 101, 1 ),
                ("DELIVERED", 2, 102, 2),
                ("CANCELLED", 3, 105, 2),
                ("DELIVERED", 4, 106, 1);
                
INSERT INTO ordersItem(status, orderid, product_id,  quantity)
                VALUES( "SHIPPED", 01, 106, 1 ),
                ("SHIPPED", 01, 101, 1),
                ( "IN PROCESS", 02, 101, 1 ),
                ("DELIVERED", 02, 102, 1),
                ( "DELIVERED", 03, 101, 1 ),
                ("SHIPPED", 03, 102, 2),
                ( "IN PROCESS", 04, 103, 1 ),
                ("IN PROCESS", 04, 104, 2);

SET SQL_SAFE_UPDATES = 0; 

SELECT * FROM ordertable;

SELECT orderid, orderDate, orderTotal
FROM ordertable 
ORDER BY orderTotal DESC
LIMIT 5;


SELECT DISTINCT A.orderid,  B.status,A.orderDate
FROM ordertable A
INNER JOIN ordersItem B
ON A.orderid = B.orderid 
WHERE  A.orderDate < DATE_SUB(CURDATE(),INTERVAL 10 DAY) && B.status = "IN PROCESS" ;


SELECT S.shopper_id
FROM shopper S
WHERE NOT EXISTS (
    SELECT O.shopper_id
    FROM ordertable O
    WHERE S.shopper_id = O.shopper_id && O.orderDate >=DATE_SUB(CURDATE(),INTERVAL 1 MONTH) ) ;


SELECT DISTINCT A.shopper_id, B.orderid, C.product_id, C.name, C.price, A.orderDate
FROM ordertable A
INNER JOIN ordersItem B
ON A.orderid = B.orderid
INNER JOIN product C
ON B.product_id = C.product_id
WHERE A.orderDate >= DATE_SUB(CURDATE(), INTERVAL 15 DAY);


SELECT B.orderid, A.product_id, A.name, B.status
FROM product A
INNER JOIN ordersItem B
ON A.product_id = B.product_id
WHERE B.status = "SHIPPED"  && B.orderid=16 
ORDER BY B.orderid;


SELECT A.product_id, B.name , C.orderDate,A.status, A.product_price
FROM ordersItem A
INNER JOIN product B
ON A.product_id = B.product_id
INNER JOIN ordertable C
ON C.orderid = A.orderid
WHERE A.product_price BETWEEN 20 AND 50
ORDER BY A.product_price;