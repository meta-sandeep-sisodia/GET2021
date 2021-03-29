# Insert sample data in StoreFront tables
INSERT INTO user(ID, FirstName, LastName, email, Role)
VALUES  ('0', 'Sandeep', 'Sisodia','sandeep.sisodia@metacube.com', 'ADMIN'),
        ('1', 'User', 'One', 'one@user.com', 'SHOPPER'),
        ('2', 'User', 'Two', 'two@user.com' ,'SHOPPER'),
        ('3', 'User', 'Three', 'three@user.com', 'SHOPPER'),
        ('4', 'User', 'Four','four@user.com', 'SHOPPER'),
        ('5', 'User', 'Five', 'five@user.com', 'SHOPPER');

INSERT INTO address(ID, Street, Area, District, State, Pincode, Country, UserID)
VALUES  ('1', 'Red Fox Lane', 'Phase 3', 'Mayur Vihar', 'Delhi', '110096', 'India', '1'),
        ('2', 'Ring Road', 'Prem Nagar', 'Bijnor', 'Uttar Pradesh', '246701', 'India', '2'),
        ('3', 'Nai Basti', 'B-14', 'Bijnor', 'Uttar Pradesh', '246701', 'India', '3'),
        ('4', 'Hindon Enclaves', 'Siddharth Vihar', 'Ghaziabad', 'Uttar Pradesh', '201009', 'India', '4'),
        ('5', 'Humdard Lane', 'Tuglakabad', 'South Delhi', 'Delhi', '110019', 'India', '5');

INSERT INTO category(ID, Title, ParentID)
VALUES  ('1', 'Electronics', '1'),
        ('2', 'Home Appliances', '1'),
        ('3', 'Mobile Phones', '1'),
        ('4', 'Smart Phones', '3'),
        ('5', 'Feature Phones', '3'),
        ('6', 'Washing Machines', '2'),
        ('7', 'Air Conditioner', '2');

INSERT INTO product(ID, Title, Description, Status, Price, Stock, CategoryID)
VALUES  ('1', 'Apple Iphone 9', 'The most powerfull phone', 'ACTIVE', 20000, 20, '4'),
        ('2', 'Samsung Washing Machine', 'Fully automatic', 'ACTIVE', 20000, 70, '6'),
        ('3','Motorola A', 'The best keypad phone', 'ACTIVE', 1250, 100, 5),
        ('4', 'Samsung guru music', 'Feature phone from samsung', 'INACTIVE', 1500, 10, '5'),
        ('5', 'Voltas e1.5', '1.5 tonne AC for home', 'ACTIVE', 25000, 20, '7'),
        ('6', 'Havells Fan', '120mm blade with BLDC motor', 'ACTIVE', 2600, 1000, '3'),
        ('7', 'Daikin', 'Wait for no more than a minute to cool your room!', 'ACTIVE', 32000, 10, '7'),
        ('8', 'Bajaj Deep Fryer', 'An 1800-watt immersion-style fryer', 'ACTIVE', 8000, 50, '2');

INSERT INTO image(ID, Title, ProductID)
VALUES  ('1', 'Apple Iphone 9', '1'),
        ('2', 'Havells Fan', '6'),
        ('3', 'Motorola A', '3'),
        ('4', 'Samsung guru music', '4'),
        ('5', 'Daikin', '7'),
        ('6', 'Bajaj Deep Fryer', '8'),
        ('7', 'Voltas e1.5', '5');
        

INSERT INTO orders(ID, UserID)
VALUES  ('1', '1'),
        ('2', '3'),
        ('3', '4'),
        ('4', '4');

INSERT INTO order_detail(ID, OrderID, ProductID, ProductQuantity, ProductPrice, Status)
VALUES  ('1', '1', '4', 2, 3000, 'SHIPPED'),
        ('2', '1', '1', 1, 20000, 'RETURNED'),
        ('3', '2', '2', 1, 20000, 'CANCELLED'),
        ('4', '3', '2', 1, 20000, 'SHIPPED'),
        ('5', '4', '7', 1, 25000, 'SHIPPED');

# Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top
SELECT product.id,
       product.title,
       category.title AS 'Category Title',
       price
FROM   product
       JOIN category
         ON product.categoryid = category.id
WHERE  status = 'ACTIVE'
ORDER  BY timeadded DESC;

# Display the list of products which don't have any images.
SELECT id,
       title,
       description
FROM   product
WHERE  id NOT IN (SELECT productid
                  FROM   image);

# Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)
SELECT c1.id,
       c1.title AS 'Category Title',
       CASE
         WHEN c1.id = c2.parentid THEN 'Top Category'
         ELSE c2.title
       end      AS 'Parent Category Title'
FROM   category c1
       JOIN category c2
         ON c1.parentid = c2.id
ORDER  BY `parent category title`,
          `category title`;

# Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
SELECT c1.id,
       c1.title,
       c2.title AS 'Parent Category Title'
FROM   category c1
       JOIN category c2
         ON c1.parentid = c2.id
WHERE  c1.id NOT IN (SELECT parentid
                     FROM   category);

# Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT product.title AS 'Product Title',
       price,
       description
FROM   product
       JOIN category
         ON product.categoryid = category.id
WHERE  category.title = 'Smart Phones'
        OR category.title = 'Feature Phones';

# Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT id,
       title,
       description
FROM   product
WHERE  stock < 50; 