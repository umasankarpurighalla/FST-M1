REM   Script: Activity1,2,3,4,5
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

