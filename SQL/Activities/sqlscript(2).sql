REM   Script: Activity9,10
REM   SQL

CREATE TABLE Customers ( 
    CustomerID int, 
    CustomerName varchar2(52), 
    ContactName varchar2(32), 
    Address varchar2(255), 
    City varchar2(50), 
    PostalCode varchar2(20), 
    Country varchar2(20) 
);

CREATE TABLE Salesman ( 
    CustomerID int, 
    CustomerName varchar2(52), 
    ContactName varchar2(32), 
    Address varchar2(255), 
    City varchar2(50), 
    PostalCode varchar2(20), 
    Country varchar2(20) 
);

Desc salesman


INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

INSERT ALL  
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

INSERT ALL  
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Pit Alex', 'Alfred''Building''Bombay', 10001, 'India') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5006, 'Alex', 'Simon Alfred''Building''Amsterdam', 10002, 'Australia') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5007, 'Alex', 'Marsh''Building''London', 10003, 'UK') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Mathew', 'Crook''Building''Bostaon', 10004, 'USA') 
SELECT 1 FROM DUAL;

INSERT ALL  
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Pit Alex', 'Alfred','Building''Bombay', 10001, 'India') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5006, 'Alex', 'Simon Alfred','Building''Amsterdam', 10002, 'Australia') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5007, 'Alex', 'Marsh''Building','London', 10003, 'UK') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Mathew', 'Crook''Building','Bostaon', 10004, 'USA') 
SELECT 1 FROM DUAL;

INSERT ALL  
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Pit Alex', 'Alfred','Building','Bombay', 10001, 'India') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5006, 'Alex', 'Simon Alfred','Building','Amsterdam', 10002, 'Australia') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5007, 'Alex', 'Marsh','Building','London', 10003, 'UK') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Mathew', 'Crook','Building','Bostaon', 10004, 'USA') 
SELECT 1 FROM DUAL;

INSERT ALL  
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Pit Alex', 'Alfred','Building','Bombay', 10001, 'India') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5006, 'Alex', 'Simon Alfred','Building','Amsterdam', 10002, 'Australia') 
    SELECT 1 FROM DUAL;

INSERT ALL  
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5006, 'Alex', 'Simon Alfred','Building','Amsterdam', 10002, 'Australia') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5007, 'Alex', 'Marsh','Building','London', 10003, 'UK') 
    INTO salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Mathew', 'Crook','Building','Bostaon', 10004, 'USA') 
    SELECT 1 FROM DUAL;

INSERT ALL  
    INTO Salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5006, 'Alex', 'Simon Alfred','Building','Amsterdam', 10002, 'Australia') 
    INTO Salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5007, 'Alex', 'Marsh','Building','London', 10003, 'UK') 
    INTO Salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Mathew', 'Crook','Building','Bostaon', 10004, 'USA') 
    INTO Salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country VALUES (5005, 'Pit Alex', 'Alfred','Building','Bombay', 10001, 'India') 
    SELECT 1 FROM DUAL;

INSERT ALL  
    INTO Salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country) VALUES (5006, 'Alex', 'Simon Alfred','Building','Amsterdam', 10002, 'Australia') 
    INTO Salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country) VALUES (5007, 'Alex', 'Marsh','Building','London', 10003, 'UK') 
    INTO Salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country) VALUES (5005, 'Mathew', 'Crook','Building','Bostaon', 10004, 'USA') 
    INTO Salesman (CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country) VALUES (5005, 'Pit Alex', 'Alfred','Building','Bombay', 10001, 'India') 
    SELECT 1 FROM DUAL;

Desc salesman


Select * from Salesaman;

Select * from Salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT CustomerID, City FROM Salesman;

SELECT * FROM Salesman WHERE City='Amsterdam';

SELECT CustomerID, CustomerName FROM Salesman WHERE CustomerName='Simon Alfred';

SELECT CustomerID, CustomerName FROM Salesman WHERE CustomerName='Alex';

ALTER TABLE Salesman add (grade int);

Select * from Salesman;

UPDATE Salesman SET grade = 100;

Select * from Salesman;

INSERT ALL  
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)   
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)  
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)  
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)  
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)  
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)  
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)  
SELECT 1 FROM DUAL;

select distinct salesman_id from order;

select distinct salesman_id from orders;

select order_no from orders order by order_date asc;

select order_no, order_date from orders order by order_date asc;

select order_no from orders order by purchase_amount desc;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount between 1000 and 2000;

select sum(purchase_amount) from orders;

select max(purchase_amount) from orders;

select min(purchase_amount) from orders;

select count(*) from orders;

select avg(purchase_amount) from orders;

select max(purchanse_amount), customer_id  
group by customer_id;

select max(purchanse_amount), customer_id from orders  
group by customer_id;

select max(purchase_amount), customer_id from orders  
group by customer_id;

select max(purchase_amount), salesman_id from orders where order_date like '2012/08/17';

select max(purchase_amount), salesman_id from orders where order_date like '%2012/08/17%';

select max(purchase_amount), salesman_id from orders where order_date like '%2012/08/17%' group by salesman_id;

select max(purchase_amount), salesman_id from orders where order_date like '2012/08/17' group by salesman_id;

select max(purchase_amount), salesman_id from orders where order_date = to_date ('2012/08/17', 'yyyy/dd/mm') group by salesman_id;

select max(purchase_amount), salesman_id from orders where order_date = to_date ('2012/08/17', 'yyyy/mm/dd') group by salesman_id;

select max(purchase_amount), customer_id, order_date from orders group by customer_id, order_date having max(purchase_amount)  
in (2030, 3450, 5760, 6000);

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int) 
 
INSERT ALL  
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)   
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)  
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)  
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)  
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)  
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)  
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)  
SELECT 1 FROM DUAL;

select distinct salesman_id from order;

select distinct salesman_id from orders;

select order_no from orders order by order_date asc;

select order_no, order_date from orders order by order_date asc;

select order_no from orders order by purchase_amount desc;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount between 1000 and 2000;

select sum(purchase_amount) from orders;

select max(purchase_amount) from orders;

select min(purchase_amount) from orders;

select count(*) from orders;

select avg(purchase_amount) from orders;

select max(purchanse_amount), customer_id  
group by customer_id;

select max(purchanse_amount), customer_id from orders  
group by customer_id;

select max(purchase_amount), customer_id from orders  
group by customer_id;

select max(purchase_amount), salesman_id from orders where order_date like '2012/08/17';

select max(purchase_amount), salesman_id from orders where order_date like '%2012/08/17%';

select max(purchase_amount), salesman_id from orders where order_date like '%2012/08/17%' group by salesman_id;

select max(purchase_amount), salesman_id from orders where order_date like '2012/08/17' group by salesman_id;

select max(purchase_amount), salesman_id from orders where order_date = to_date ('2012/08/17', 'yyyy/dd/mm') group by salesman_id;

select max(purchase_amount), salesman_id from orders where order_date = to_date ('2012/08/17', 'yyyy/mm/dd') group by salesman_id;

select max(purchase_amount), customer_id, order_date from orders group by customer_id, order_date having max(purchase_amount)  
in (2030, 3450, 5760, 6000);

INSERT ALL  
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)   
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)  
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)  
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)  
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)  
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)  
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)  
SELECT 1 FROM DUAL;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

Select * from orders;

