/*

LEIBNIZ H. BERIHUETE
SQL LAB


2.1 SELECT

Task – Select all records from the Employee table.

Task – Select all records from the Employee table where last name is King.

Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

*/

SELECT * FROM employee;

SELECT * FROM employee WHERE lastname = 'King';

SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;


/*
2.2 ORDER BY

Task – Select all albums in Album table and sort result set in descending order by title.

Task – Select first name from Customer and sort result set in ascending order by city
*/

SELECT * FROM album ORDER BY title DESC;

SELECT * FROM album ORDER BY title ASC; /* ASC doesn't have to be written though, since by the default is ascending order */

/*
2.3 INSERT INTO

Task – Insert two new records into Genre table

Task – Insert two new records into Employee table

Task – Insert two new records into Customer table
*/

INSERT INTO genre VALUES (26, 'Saosin: On My Own');
INSERT INTO genre VALUES (27, 'The Used: I caught on fire');

INSERT INTO employee VALUES (9, 'Witson', 'John', 'Java Developer', null, '12-NOV-1990', '13-NOV-1990', '123 Timesquare', 'New York', 'NY', 'USA', '10042', '123-456-7890', '098-765-4321', 'john@email.com');
INSERT INTO employee VALUES (10, 'Katrina', 'Lala', 'Web Developer', null, '14-NOV-1990', '15-NOV-1990', '321 union square', 'New York', 'NY', 'USA', '10024', '456-123-0987', '098-456-1122', 'lala@email.com');

INSERT INTO customer VALUES (60, 'Awesome', 'Dude', 'Revature', '123 Timesquare', 'New York', 'NY', 'USA', '10042', '123-456-7890', '098-765-4321', 'awesomeDude@email.com', null);
INSERT INTO customer VALUES (61, 'Greener', 'Geez', 'GoGreen Corp', '900 Central Park', 'New York', 'NY', 'USA', '10019', '555-456-7550', '098-111-4311', 'GrennerGeez@goGreen.com', null);

/*
2.4 UPDATE

Task – Update Aaron Mitchell in Customer table to Robert Walter

Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/

/* update firstName */
UPDATE customer
SET firstname = 'Robert' 
WHERE firstname = 'Aaron' AND lastName = 'Mitchell';

/* update lastName */
UPDATE customer
SET lastname = 'Walter' 
WHERE firstname = 'Robert' AND lastName = 'Mitchell';

/* update album */
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';


/*
2.5 LIKE

Task – Select all invoices with a billing address like “T%”
*/

SELECT * FROM invoice WHERE billingaddress LIKE 'T%';


/*
2.6 BETWEEN

Task – Select all invoices that have a total between 15 and 50

Task – Select all employees hired between 1 st of June 2003 and 1 st of March 2004
*/

SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee WHERE hiredate BETWEEN '1-JUN-2003' AND '1-MAR-2004';
/*
2.7 DELETE

Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints

that rely on this, find out how to resolve them).
*/

DELETE FROM Customer WHERE firstname = 'Robert' AND lastname = 'Walter';

/*
3. SQL Functions

In this section you will be using the Oracle system functions, as well as your own functions, to perform

various actions against the database



/*
3.1 System Defined Functions

Task – Create a function that returns the current time.

Task – create a function that returns the length of a mediatype from the mediatype table
*/

CREATE OR REPLACE FUNCTION getCurrentTime
 RETURN TIMESTAMP AS
 BEGIN
  RETURN CURRENT_TIMESTAMP;
 END;
 
CREATE OR REPLACE FUNCTION getLengthOfMediaType
RETURN INTEGER AS
len INTEGER;
BEGIN
    SELECT COUNT(*) INTO len FROM mediaType;
    RETURN len;
END;

/*
3.2 System Defined Aggregate Functions

Task – Create a function that returns the average total of all invoices

Task – Create a function that returns the most expensive track
*/

CREATE OR REPLACE FUNCTION getAverageOfAllInvoicesTotal
RETURN INTEGER AS
average INTEGER;
BEGIN
 SELECT AVG(total) INTO average FROM invoice;
 RETURN average;
END;

/*
3.3 User Defined Scalar Functions

Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/

CREATE OR REPLACE FUNCTION getAverageOfInvoiceLinePrice(id INT)
RETURN INTEGER AS
average INTEGER;
BEGIN
 SELECT AVG(unitprice) INTO average FROM invoiceline WHERE invoicelineId = id;
 RETURN average;
END;


/*
3.4 User Defined Table Valued Functions

Task – Create a function that returns all employees who are born after 1968.
*/
CREATE OR REPLACE FUNCTION getEmployeeAfter1968(r OUT SYS_REFCURSOR)
RETURN SYS_REFCURSOR
AS
BEGIN
    OPEN r FOR SELECT * FROM employee WHERE EXTRACT(YEAR FROM birthdate) > 1968; 
    RETURN r;
END;


/*
4.1 Basic Stored Procedure

Task – Create a stored procedure that selects the first and last names of all the employees.
*/
CREATE OR REPLACE PROCEDURE firstAndLast
AS
 xfirstname VARCHAR(100);
 xlastname VARCHAR(200);
BEGIN
    SELECT firstname, lastname INTO xfirstname, xlastname FROM employee;
END;

/*
4.2 Stored Procedure Input Parameters

Task – Create a stored procedure that updates the personal information of an employee.

Task – Create a stored procedure that returns the managers of an employee.
*/

CREATE OR REPLACE PROCEDURE updateEmployee(idnum IN INT, xlast IN VARCHAR, xfirst IN VARCHAR)
AS
BEGIN
    UPDATE employee
    SET firstname = xfirst,
    lastname = xlast
    WHERE employeeid = idnum;
   
END;

CREATE OR REPLACE PROCEDURE returnManager(idnum IN INT, xmanager OUT VARCHAR)
AS
managerid INT;
BEGIN
    SELECT reportsto INTO managerid FROM employee WHERE employeeid = idnum;
    SELECT firstname INTO xmanager FROM employee WHERE employeeid = managerid;
END;






/*
4.3 Stored Procedure Output Parameters

Task – Create a stored procedure that returns the name and company of a customer.
*/
CREATE OR REPLACE PROCEDURE returnNameCompanyCustomer(xcustomerID IN INT, xname OUT VARCHAR, xcompany OUT VARCHAR)
AS
BEGIN
    SELECT firstname INTO xname FROM customer WHERE customerid = xcustomerID;
    SELECT company INTO xcompany FROM customer WHERE customerid = xcustomerID;
END;




/*
5.0 Transactions

In this section you will be working with transactions. Transactions are usually nested within a stored

procedure.

Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that

rely on this, find out how to resolve them).

Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer

table
*/
CREATE OR REPLACE PROCEDURE deleteRecord(xinvoiceid IN INT)
AS
BEGIN
    DELETE FROM invoice WHERE invoiceid = xinvoiceid;
    COMMIT;
END;

CREATE OR REPLACE PROCEDURE deleteRecord(xcustomerid IN INT, xfirstname IN VARCHAR, xlastname IN VARCHAR)
AS
BEGIN
    INSERT INTO customer (customerid, firstname, lastname)
    VALUES(xcustomerid, xfirstname, xlastname);
    COMMIT;
END;







/*

6.1 AFTER/FOR

Task - Create an after insert trigger on the employee table fired after a new record is inserted into the

table.

Task – Create an after update trigger on the album table that fires after a row is inserted in the table

Task – Create an after delete trigger on the customer table that fires after a row is deleted from the

table.
*/

CREATE OR REPLACE TRIGGER afterInsertEmployeeTrigger 
AFTER INSERT ON employee
FOR EACH ROW 
WHEN (NEW.ID > 0) 
DECLARE 
   sal_diff number; 
BEGIN 
   sal_diff := :NEW.employeeid  - :OLD.employeeid; 
    
END; 



/*
7.1 INNER

Task – Create an inner join that joins customers and orders and specifies the name of the customer and

the invoiceId.
*/

SELECT Customer.firstname, Customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN INVOICE ON customer.customerid = invoice.invoiceid;


/*
7.2 OUTER

Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,

firstname, lastname, invoiceId, and total.
*/

SELECT Customer.customerid, Customer.firstname, Customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN INVOICE ON customer.customerid = invoice.invoiceid;

/*
7.3 RIGHT

Task – Create a right join that joins album and artist specifying artist name and title.
*/


SELECT Album.title, artist.NAME
FROM album
RIGHT JOIN artist ON Artist.artistid = Album.artistid;


/*
7.4 CROSS

Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/

SELECT Album.title, artist.NAME
FROM album
CROSS JOIN artist
ORDER BY artist.NAME;


/*
7.5 SELF

Task – Perform a self-join on the employee table, joining on the reportsto column.
*/

SELECT A.employeeid, A.firstname, A.lastname, B.employeeid, B.firstname, B.lastname 
FROM Employee A
JOIN Employee B ON A.employeeid = B.employeeID;

/*
9.0 Administration

In this section you will be creating backup files of your database. After you create the backup file you

will also restore the database.

Task – Create a .bak file for the Chinook database.
