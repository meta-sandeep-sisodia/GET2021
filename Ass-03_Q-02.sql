# Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT p.id    AS 'ProductID',
       p.title AS 'Title',
       result.category_count
FROM   product p
       INNER JOIN (SELECT id,
                          Count(id) AS category_count
                   FROM   category
                   GROUP  BY id) AS result
               ON p.id = result.id
                  AND result.category_count > 1;

# Display Count of products as per below price range: (0 - 100, 101 - 500, Above 500)
SELECT `price range`,
       Count(id) AS 'Count'
FROM   (SELECT id,
               CASE
                 WHEN price BETWEEN 0 AND 5000 THEN '0 - 5000'
                 WHEN price BETWEEN 5001 AND 10000 THEN '5001 - 10000'
                 WHEN price > 10000 THEN '> 10000'
               end AS `Price Range`
        FROM   product) a
GROUP  BY `price range`;

# Display the Categories along with number of products under each category.
SELECT category.id,
       category.title    AS 'Category Title',
       Count(product.id) AS 'Number of Products'
FROM   category
       JOIN product
         ON product.categoryid = category.id
GROUP  BY category.id; 