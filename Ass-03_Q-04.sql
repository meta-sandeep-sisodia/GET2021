# Consider a form where providing a Zip Code populates associated City and State.
# Create appropriate tables and relationships for the same.
CREATE TABLE city
  (
     zipcode VARCHAR(10) PRIMARY KEY,
     name    VARCHAR(50)
  );

CREATE TABLE state
  (
     name        VARCHAR(50),
     cityzipcode VARCHAR(50),
     FOREIGN KEY (cityzipcode) REFERENCES city (zipcode)
  );

INSERT INTO city
            (zipcode,
             name)
VALUES      ('110096',
             'Mayur Vihar'),
            ('246701',
             'Bijnor'),
            ('201009',
             'Ghaziabad'),
            ('110019',
             'South Delhi');

INSERT INTO state
            (name,
             cityzipcode)
VALUES      ('Delhi',
             '110096'),
            ('Uttar Pradesh',
             '246701'),
            ('Uttar Pradesh',
             '201009'),
            ('Delhi',
             '110019');

# Write a SQL query for that returns a Resultset containing Zip Code, City Names and States ordered by State Name and City Name.
SELECT zipcode,
       city.name  AS 'City Name',
       state.name AS 'State Name'
FROM   city
       JOIN state
         ON city.zipcode = state.cityzipcode
ORDER  BY `state name`,
          `city name`; 