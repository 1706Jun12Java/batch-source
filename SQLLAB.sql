--2.1 SELECT
--Task – Select all records from the Employee table.
--Task – Select all records from the Employee table where last name is King.
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew';

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
--Task – Select first name from Customer and sort result set in ascending order by city

SELECT * FROM ALBUM ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
--Task – Insert two new records into Employee table
--Task – Insert two new records into Customer table

INSERT INTO GENRE VALUES (26,'Techno');
INSERT INTO GENRE VALUES (27,'Reggaeton');

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Bardo', 'Mary', 'Intern', TO_DATE('1969-6-04 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2005-12-03 00:00:00','yyyy-mm-dd hh24:mi:ss'), '666 Broadway Ave', 'Miami', 'FL', 'USA', '10043', '+1 (646) 429-0882', '+1 (780) 928-7437', 'mary@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Tenchi', 'Philp', 'Intern', TO_DATE('1990-3-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2008-7-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '123 Fermen Street', 'Paterson', 'NJ', 'USA', '10234', '+1 (478) 146-9482', '+1 (780) 012-3407', 'philp@chinookcorp.com');

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'Dino', 'Trever', 'Coca-Cola', 'Faria Lima, 2321', 'Capital', 'Cuba', '12234', '+20 (23) 3495-1023', '+23 (23) 2049-0066', 'treverD@gmail.com.cu', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Romen', 'Ted', '102 li chu blv', 'Hano', 'Japan', '01293', '+20 0711 10293', 'tedR@yahoo.ju', 5);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”

SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM INVOICE  WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('2003-06-01 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-03-01 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

--DROP CONSTRAINT FIRST
ALTER TABLE INVOICE
DROP CONSTRAINT FK_InvoiceCustomerId;

--DELETE RECORD
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--RE-ADD CONSTRAINT
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)  ;

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of a Gatype table

CREATE OR REPLACE FUNCTION CURRENT_TIME
RETURN TIMESTAMP IS TIME TIMESTAMP;
BEGIN
    TIME := CURRENT_TIMESTAMP;
    RETURN TIME;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE(CURRENT_TIME);
END;

CREATE OR REPLACE FUNCTION LENGTH_MTYPE(MTYPE_ID IN VARCHAR2)
RETURN NUMBER IS LENGTH_MEDIA NUMBER;
BEGIN
    SELECT LENGTH(MEDIATYPE.NAME) INTO LENGTH_MEDIA FROM MEDIATYPE
    WHERE MEDIATYPE.MEDIATYPEID = MTYPE_ID;
    RETURN LENGTH_MEDIA;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE('GATYPE length is: ' || LENGTH_MTYPE(3));
END;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
--Task – Create a function that returns the most expensive track

CREATE OR REPLACE FUNCTION AVG_INVOICE_TOTAL 
RETURN NUMBER IS AVGINVOICE NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO AVGINVOICE FROM INVOICE;
    RETURN AVGINVOICE;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE(AVG_INVOICE_TOTAL);
END;

CREATE OR REPLACE FUNCTION EXPENSIVE_TRACK 
RETURN NUMBER IS EXPTRACK NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO EXPTRACK FROM TRACK;
    RETURN EXPTRACK;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE('The most expensive track is: $'||EXPENSIVE_TRACK);
END;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION AVG_INVOICELINE 
RETURN NUMBER IS AVGUNITPRICE NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVGUNITPRICE FROM INVOICELINE;
    RETURN AVGUNITPRICE;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE('The average track price is: $'||AVG_INVOICELINE);
END;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
 
CREATE OR REPLACE FUNCTION EMPLOYEES_BORN_AFTER68
RETURN SYS_REFCURSOR 
IS THIS_CURSOR SYS_REFCURSOR;
BEGIN
  OPEN THIS_CURSOR FOR 
   SELECT * FROM EMPLOYEE 
   WHERE EMPLOYEE.BIRTHDATE > TO_DATE('1968','yyyy');
   RETURN THIS_CURSOR;
END;

DECLARE 
S SYS_REFCURSOR;
EMP_INFO EMPLOYEE%ROWTYPE;
BEGIN
S := EMPLOYEES_BORN_AFTER68;
  LOOP
    FETCH S INTO EMP_INFO;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(EMP_INFO.FIRSTNAME || ' ' ||
                        EMP_INFO.LASTNAME || ' is born after 1968.');
  END LOOP;
CLOSE S;
END;
  
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE FIRST_LAST_NAME_PROCEDURE (S OUT SYS_REFCURSOR) 
IS 
BEGIN
  OPEN S FOR 
   SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;

DECLARE 
S SYS_REFCURSOR;
FN EMPLOYEE.FIRSTNAME%TYPE;
LN EMPLOYEE.LASTNAME%TYPE;
BEGIN
FIRST_LAST_NAME_PROCEDURE(S);
  LOOP
    FETCH S INTO FN,LN;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FN ||' ' || LN);
  END LOOP;
  CLOSE S;
END;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.

CREATE OR REPLACE PROCEDURE GET_MANAGERS(EMPID NUMBER, S OUT SYS_REFCURSOR) 
IS 
BEGIN
  OPEN S FOR 
  SELECT EMPOLYEE1.* FROM EMPLOYEE EMPOLYEE1 WHERE EMPOLYEE1.EMPLOYEEID = 
( SELECT EMPOLYEE2.REPORTSTO FROM EMPLOYEE EMPOLYEE2 WHERE EMPOLYEE2.EMPLOYEEID = EMPID);
END;

DECLARE 
S SYS_REFCURSOR;
MANAGERS_INFO EMPLOYEE%ROWTYPE;
BEGIN
GET_MANAGERS(6,S);
  LOOP
    FETCH S INTO MANAGERS_INFO;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(MANAGERS_INFO.FIRSTNAME ||' '|| MANAGERS_INFO.LASTNAME);
  END LOOP;
  CLOSE S;
END;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE GET_MANAGERS(EMPID NUMBER, S OUT SYS_REFCURSOR) 
IS 
BEGIN
  OPEN S FOR 
  SELECT EMPOLYEE1.* FROM EMPLOYEE EMPOLYEE1 WHERE EMPOLYEE1.EMPLOYEEID = 
( SELECT EMPOLYEE2.REPORTSTO FROM EMPLOYEE EMPOLYEE2 WHERE EMPOLYEE2.EMPLOYEEID = EMPID);
END;

DECLARE 
S SYS_REFCURSOR;
MANAGERS_INFO EMPLOYEE%ROWTYPE;
BEGIN
GET_MANAGERS(6,S);
  LOOP
    FETCH S INTO MANAGERS_INFO;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(MANAGERS_INFO.FIRSTNAME ||' '|| MANAGERS_INFO.LASTNAME);
  END LOOP;
  CLOSE S;
END;

--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE SP_DELETE_INVOICE (INVOICE_ID IN NUMBER)
IS
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    DELETE INVOICE WHERE INVOICE.INVOICEID = INVOICE_ID;
    DELETE INVOICELINE WHERE INVOICELINE.INVOICEID = INVOICE_ID;
END;

CREATE OR REPLACE PROCEDURE SP_INSERT_NEW_CUSTOMER (NEWCUSTOMERID IN NUMBER,
NEWFIRSTNAME IN VARCHAR2,
NEWLASTNAME IN VARCHAR2,
NEWCOMPANY IN VARCHAR2,
NEWADDRESS IN VARCHAR,
NEWCITY IN VARCHAR2,
NEWSTATE IN VARCHAR2,
NEWCOUNTRY IN VARCHAR2,
NEWPOSTALCODE IN VARCHAR2,
NEWPHONE IN VARCHAR2,
NEWFAX IN VARCHAR2,
NEWEMAIL IN VARCHAR2,
NEWSUPPORTREPID IN NUMBER)
IS
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    INSERT INTO CUSTOMER VALUES (NEWCUSTOMERID, NEWFIRSTNAME, NEWLASTNAME,
                               NEWCOMPANY, NEWADDRESS, NEWCITY, NEWSTATE,
                                NEWCOUNTRY, NEWPOSTALCODE, NEWPHONE, NEWFAX,
                                NEWEMAIL, NEWSUPPORTREPID);
END;

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.


CREATE OR REPLACE TRIGGER TR_EMPLOYEE_INSERT
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('DO SOMETHING TO HANDLE THIS TRIGGER');
END;

CREATE OR REPLACE TRIGGER TR_ALBUM_UPDATE
AFTER UPDATE ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('DO SOMETHING TO HANDLE THIS TRIGGER');
END;

CREATE OR REPLACE TRIGGER TR_CUSTOMER_DELETE
AFTER DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('DO SOMETHING TO HANDLE THIS TRIGGER');
END;

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT FIRSTNAME, LASTNAME,INVOICEID 
FROM CUSTOMER
INNER JOIN INVOICE 
ON (INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID);

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT C1.CUSTOMERID, C1.FIRSTNAME, C1.LASTNAME, CUSTOMERINVOICE.INVOICEID,CUSTOMERINVOICE.TOTAL
FROM CUSTOMER C1 
FULL OUTER JOIN INVOICE CUSTOMERINVOICE 
ON C1.CUSTOMERID = CUSTOMERINVOICE.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

SELECT ARTIST_N.NAME, ALBUM_T.TITLE
FROM ARTIST ARTIST_N 
RIGHT JOIN ALBUM ALBUM_T
ON ARTIST_N.ARTISTID = ALBUM_T.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT * 
FROM ALBUM 
CROSS JOIN ARTIST 
ORDER BY ARTIST.NAME ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT EMP1.FIRSTNAME, EMP1.LASTNAME, EMP2.FIRSTNAME ,EMP2.LASTNAME
FROM EMPLOYEE EMP1, EMPLOYEE EMP2
WHERE EMP1.REPORTSTO = EMP2.EMPLOYEEID;

--9.0 Administration
--Task – Create a .bak file for the Chinook database.