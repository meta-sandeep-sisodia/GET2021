INSERT INTO user(userId, name, password, email) 
              VALUES(01,"Sandeep Sisodia","pass1234","sandeep.sisodia@metacube.com"),
                    (02,"Govardhan Kumar","P@ss1234","govardhan.kumar@metacube.com"),
                    (03,"Girl user","Pass000","girluser@metacube.com"),
                    (04,"Super user", "Pass007","superuser@metacube.com");
                    

INSERT INTO shopper(shopper_id, phone_no, sex) 
                    VALUES(01,9876543210,"male"),
                    (02,9898989898,"male"),
                    (03,7894561230,"female"),
                    (04,7410852963,"male");


INSERT INTO address(street, district, state, pincode, shopper_id)
            VALUES
            ("Bijnor","Bijnor", "Uttar Pradesh", 246701, 01),
            ("street","District", "Bihar", 123456, 02),
            ("Red fox lane","Mayur Vihar", "Delhi",110096, 03),
            ("SITAPURA","Jaipur", "Rajasthan", 654321,04);


INSERT INTO category(id,name, parent_id) 
                        VALUES(1,"Electronics",NULL),
                        (2,"Clothing",NULL),
                        (3,"Mobile",1),
                        (4,"Laptop",1),
                        (5,"Shirt",2),
                        (6,"Trouser",2);
					

INSERT INTO product(product_id, price, name, description, category_id,date,status) 
                        Values(101, 1000 ,"Nokia 1001","Feature phone from Nokia", 3 , "2021-03-16", 'Active'),
                        (102, 2000 ,"Samsung","Feature phone from Samsung", 3, "2021-03-10",'Active'),
                        (103, 45000 ,"Blackberry x","Best qwerty phone", 3 , "2021-02-10",'Active'),
                        (104, 22000 ,"Dell D1","4Gb 1TB I5", 4 , "2021-02-02",'Active'),   
                        (105, 30000 ,"Dell DX","8GB 128GB Ryzen 5", 4 , "2021-02-15",'Active'),
                        (106, 200 ,"White shirt","White shirt from blackberry", 5 , "2021-01-10",'Active'),    
                        (107, 300 ,"Red Shirt","Red shirt from metacube", 5 , "2021-01-10",'Active'),    
                        (108, 300 ,"HRX trouser ","Active trouser from HRX", 6 , "2021-01-10", 'Active'),
                        (109, 400 ,"Nike truser","Sports trouser", 6 , "2021-01-16", 'Inactive');
                        

INSERT INTO image(product_id,img)
        Values(101,"1.jpg"),
              (101,"2.jpg"),
              (102,"3.jpg"),
              (104,"4.jpg"),
              (105,"5.jpg"),
              (107,"6.jpg"),
              (109,"7.jpg");
      

INSERT INTO stock(product_id, quantity, date_added)
                    Values(101,10,"2021-03-15"),
                    (102,10,"2021-03-12"),
                    (103,12,"2021-03-11"),
                    (104,4,"2021-03-10"),
                    (105,5,"2021-03-16"),
                    (106,10,"2021-03-12"),
                    (107,15,"2021-03-01"),
                    (108,15,"2021-03-03"),
                    (109,12,"2021-03-08");





SELECT 
    A.product_id AS Id,
    A.name AS Title,
    B.name AS Category,
    A.price AS Price
FROM
    product A
        LEFT JOIN
    category B ON A.category_id = B.id
WHERE
    A.status = 'Active'
ORDER BY A.date DESC;




SELECT 
    name
FROM
    product
WHERE
    product.product_id NOT IN (SELECT 
            image.product_id
        FROM
            image);



SELECT 
    c1.id, c1.name, IFNULL(c2.name, 'Top category') AS parent
FROM
    category c1
        LEFT JOIN
    category c2 ON c1.parent_id = c2.id
ORDER BY c2.name , c1.name;



SELECT 
    c1.id, c1.name, c1.parent_id
FROM
    category c1
WHERE
    c1.id NOT IN (SELECT 
            c2.parent_id
        FROM
            category c2
        WHERE
            c2.parent_id IS NOT NULL);


                    
SELECT 
    product.name, product.price, product.description, A.name
FROM
    product
        LEFT JOIN
    category A ON product.category_id = A.id
WHERE
    A.name = 'Laptop';




SELECT 
    A.product_id, A.name, IFNULL(B.quantity, 0)
FROM
    product A
        LEFT JOIN
    stock B ON A.product_id = B.product_id
WHERE
    B.quantity < 50;
