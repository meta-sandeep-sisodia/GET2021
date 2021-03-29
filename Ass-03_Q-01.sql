# With respect to StoreFront application identify, apply and list the constraints you would apply on the columns for the tables created.

# Altering address table
ALTER TABLE Address
MODIFY Street VARCHAR(50) NOT NULL,
MODIFY Area VARCHAR(50) NOT NULL,
MODIFY District VARCHAR(50) NOT NULL,
MODIFY State VARCHAR(50) NOT NULL,
MODIFY Pincode VARCHAR(10) NOT NULL,
MODIFY Country VARCHAR(50) NOT NULL;

# Altering category table
ALTER TABLE category 
MODIFY Title VARCHAR(20) NOT NULL,
ADD UNIQUE (Title);

# Altering user table
ALTER TABLE user 
MODIFY FirstName VARCHAR(20) NOT NULL,
MODIFY LastName VARCHAR(20) NOT NULL,
MODIFY Email VARCHAR(50) NOT NULL,
ADD UNIQUE (Email);

# Altering order_detail table
ALTER TABLE order_detail 
MODIFY ProductQuantity INT NOT NULL,
MODIFY ProductPrice DOUBLE NOT NULL,
ADD CONSTRAINT VALCHECK CHECK ( ProductQuantity > 0 AND ProductPrice > 0);

# Altering product table
ALTER TABLE product 
MODIFY Title VARCHAR(50) NOT NULL,
MODIFY Price DOUBLE NOT NULL,
MODIFY Stock INT NOT NULL,
ADD CHECK ( Price > 0 AND Stock >= 0);