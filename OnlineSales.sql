CREATE TABLE Customers(
    customer_id=INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(50)
)

CREATE TABLE Products(
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10,2)
);

CREATE TABLE Orders(
    order_id PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

CREATE TABLE Order_Items(
    order_id INT,
    product_id INT,
    quantity  INT,
    PRIMARY KEY(order_id,product_id)
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

INSERT INTO Customers VALUES (1,'vinay','chennai'),(2,'abc','delhi'),(3,'Rahul','banglore'),(4,'sunny','hyderabad');
INSERT INTO Products VALUES (101,'laptop','electronics',50000),(102,'mouse','electronics',600),(103,'shoes','fashion',2500),(105,'book','education',3890);
INSERT INTO Orders VALUES (1001,1,'2026-01-15'),(1002,2,'2026-01-20'),(1003,1,'2026-02-10')(1004,3,'2026-02-20');
INSERT INTO Order_Items VALUES (1001,101,1),(1001,102,2),(1002,103,3),(1003,101,1),(1003,105,2),(1004,104,4);

"""all orders and customers"""
SELECT 
 o.order_id,
 c.name as customer_name,
 o.order_date
FROM Orders 0 
JOIN customers c ON c.customer_id=o.customer_id;

"""total revenue"""
SELECT SUM(p.price*oi.quantity) AS total_revenue
FROM Order_Items oi JOIN Products p ON p.product_id=oi.product_id;

"""top selling products"""
SELECT p.product_id,p.name,SUM(oi.quantity) AS total_quantity_sold
FROM Products p join Order_Items oi
on p.product_id=oi.product_id
group BY p.product_id,p.name ORDER BY total_quantity_sold DESC

"""MOST VALUABLE customers"""
SELECT c.customer_id,c.name,
SUM(p.price *oi.quantity) AS total_spent FROM
Customers c JOIN Orders o 
on c.customer_id=o.customer_id
join Order_Items oi ON o.order_id=oi.order_id
JOIN Products p ON oi.product_id =p.product_id
GROUP BY c.customer_id,c.name ORDER BY total_spent DESC

"""MONTHLY REVENUE"""
SELECT 
    YEAR(O.order_date) AS year,
    MONTH(o/order_date) AS month,
    SUM(p.price*oi.quantity) AS total_revenue
    FROM Orders O
    join Order_Items oi ON o.order_id=oi.order_id
    JOIN Products p ON oi.product_id =p.product_id
    GROUP BY YEAR(o.order_date),MONTH(o.order_date) ORDER BY year,month;

"""category sales"""
SELECT 
p.category,
SUM(oi.quantity) AS items_sold,
SUM(oi.quantity *p.price) AS total_revenue
FROM Products p JOIN Order_Items oi ON p.product_id=oi.product_id
GROUP BY p.Category ORDER BY SUM(oi.quantity*p.price) DESC;

"""CUSTOMER ORDER COUNT"""
SELECT 
c.customer_id,c.customer_name,COUNT(o.order_id) AS total_orders
FROM Customers c LEFT JOIN Orders o 
ON c.customer_id =o.customer_id
GROUP BY c.name;
