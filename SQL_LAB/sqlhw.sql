-- Name: Bishwo Gurung

-- 2.1 SELECT
-- Task - Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city.
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table.
INSERT INTO GENRE VALUES(26, 'POP');

--Task – Insert two new records into Employee table.
INSERT INTO EMPLOYEE VALUES(9, 'PETER', 'PARKER', 'SUPERHERO', NULL, '01-JUN-92', 
    '01-JUN-99','119 NEW YORK STREET', 'NEW YORK', 'NY', 'UNITED STATES', '11109', 
    '+1 (646) 235-2662', '+1 (347) 684 8467', 'SPIDERMAN@GMAIL.COM');

INSERT INTO EMPLOYEE VALUES(10, 'WAYNE', 'BRUCE', 'SUPERHERO', NULL, '01-JUN-89', 
    '02-JUN-89','120 GOTHAM STREET', 'GOTHAM', 'GT', 'UNITED STATES', '11580', 
    '+1 (646) 278-7657', '+1 (347) 782-8467', 'BATMAN@GMAIL.COM');
    COMMIT;
    
--Task – Insert two new records into Customer table.
INSERT INTO CUSTOMER VALUES(60, 'SMITH', 'MATT', 'REVATURE', '542 BLEECKER ST', 
'GREENWICH', 'NY', 'CANADA', '11756', '+1 (573) 234-5738', '+1 (261) 867-4864', 'DOCTORWHO@GMAIL.COM', '6');
INSERT INTO CUSTOMER VALUES(61, 'TENNANT', 'DAVID', 'REVATURE', '657 BLEECKER ST', 
'GREENWICH', 'NY', 'CANADA', '11759', '+1 (573) 234-7937', '+1 (261) 867-7846', 'DOCTORWHO2@GMAIL.COM', '6');
COMMIT;

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter.
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert',
    LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
COMMIT;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”.
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
COMMIT;

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('01-JUN-2003', 
'DD-MM-YYYY') AND TO_DATE('01-MAR-2004', 'DD-MM-YYYY');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).

UPDATE INVOICE
SET CUSTOMERID = NULL
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walker';
COMMIT;

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION TIME_TODAY
RETURN TIMESTAMP 
IS
BEGIN
    RETURN CURRENT_TIMESTAMP;
END;

DECLARE
    x TIMESTAMP;
BEGIN
    x:= TIME_TODAY();
    DBMS_OUTPUT.PUT_LINE(x);
END;

--Task – create a function that returns the length of a mediatype from the
--mediatype table 
CREATE OR REPLACE FUNCTION COUNT_MEDIATYPE_LENGTH(M_ID IN INTEGER)
RETURN NUMBER
IS
M_LENGTH NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO M_LENGTH FROM MEDIATYPE WHERE M_ID = MEDIATYPEID;
    RETURN M_LENGTH;
END;

DECLARE
COUNT_RESULT NUMBER;
BEGIN
    COUNT_RESULT:= COUNT_MEDIATYPE_LENGTH(1);
    DBMS_OUTPUT.PUT_LINE(COUNT_RESULT);
END;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION AVG_INVOICE
RETURN NUMBER
IS
X NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO X FROM INVOICE;
    RETURN X;
END;

DECLARE
AVG_TOTAL_INVOICE NUMBER;
BEGIN
    AVG_TOTAL_INVOICE:= AVG_INVOICE();
    DBMS_OUTPUT.PUT_LINE(AVG_TOTAL_INVOICE);
END;

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN VARCHAR2
IS
EXP_TRACK VARCHAR2(200);
BEGIN
    SELECT NAME INTO EXP_TRACK FROM (
    
    SELECT * FROM (
    
    SELECT * FROM TRACK 
    
    WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK)) WHERE ROWNUM =1 );
    RETURN EXP_TRACK;
END;

DECLARE
MET VARCHAR2(200);
BEGIN
    MET:= MOST_EXPENSIVE_TRACK();
    DBMS_OUTPUT.PUT_LINE(MET);
END;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICELINE_ITEM_PRICE
RETURN NUMBER
IS
    AVG_RESULT NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVG_RESULT FROM INVOICELINE;
    RETURN AVG_RESULT;
END;

DECLARE
Z NUMBER;
BEGIN
    Z:= AVG_INVOICELINE_ITEM_PRICE();
    DBMS_OUTPUT.PUT_LINE(Z);
END;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION LIST_EMPLOYEES
RETURN VARCHAR2
IS FIRST_NAME DBMS_SQL.VARCHAR2_TABLE;
BEGIN
    SELECT FIRSTNAME INTO FIRST_NAME FROM EMPLOYEE WHERE BIRTHDATE > TO_DATE('1986', 'YYYY');
END;

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE RETURN_EMPLOYEE_NAMES (NAMES OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN NAMES FOR
     SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;

DECLARE
NAMES SYS_REFCURSOR;
F_NAME EMPLOYEE.FIRSTNAME%TYPE;
L_NAME EMPLOYEE.LASTNAME%TYPE;

BEGIN
    RETURN_EMPLOYEE_NAMES(NAMES);
    
    LOOP
        FETCH NAMES INTO F_NAME, L_NAME;
        EXIT WHEN NAMES%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(F_NAME || L_NAME);
    END LOOP;
    CLOSE NAMES;
END;

--4.2 Stored Procedure Input Parameters	
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE (
THIS_EMPLOYEEID IN NUMBER,
U_LASTNAME IN VARCHAR2 DEFAULT NULL,
U_FIRSTNAME IN VARCHAR2 DEFAULT NULL,
U_BIRTHDATE IN DATE DEFAULT NULL,
U_ADDRESS IN VARCHAR2 DEFAULT NULL,
U_CITY IN VARCHAR2 DEFAULT NULL,
U_STATE IN VARCHAR2 DEFAULT NULL,
U_COUNTRY IN VARCHAR2 DEFAULT NULL,
U_POSTALCODE IN VARCHAR2 DEFAULT NULL,
U_PHONE IN VARCHAR2 DEFAULT NULL
)
IS
BEGIN
    SAVEPOINT A;
    IF
        THIS_EMPLOYEEID IS NOT NULL
        THEN
            UPDATE EMPLOYEE
            SET
                EMPLOYEEID = U_EMPLOYEEID,
                LASTNAME = U_LASTNAME,
                FIRSTNAME = U_FIRSTNAME,
                BIRTHDATE = U_BIRTHDATE,
                ADDRESS = U_ADDRESS,
                CITY = U_CITY,
                STATE = U_STATE,
                COUNTRY = U_COUNTRY,
                POSTALCODE = U_POSTALCODE,
                PHONE = U_PHONE;
            COMMIT;
        ELSE
            DBMS_OUTPUT.PUT_LINE('THIS EMPLOYEE ID DOES NOT EXIST ON OUR DATABASE.');
        END IF;
        EXCEPTION
        WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR!!');
        ROLLBACK TO A;
    END;

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE RETURN_EMP_MANAGERS (
THIS_EMPLOYEEID IN NUMBER, ANSWER OUT SYS_REFCURSOR
)
IS
ANS INTEGER;
BEGIN
SELECT COUNT(EMPLOYEEID) INTO ANS FROM EMPLOYEE
WHERE EMPLOYEEID = THIS_EMPLOYEEID;
IF ANS = 0 THEN
    OPEN ANSWER
    FOR
        SELECT THIS_EMPLOYEEID, REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID=THIS_EMPLOYEEID;
END IF;
END;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE RETURN_CUSTOMERINFO (C_NAME_COM OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN C_NAME_COM FOR
        SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER;
END;

DECLARE
C_NAME_COM SYS_REFCURSOR;
C_LASTNAME CUSTOMER.LASTNAME%TYPE;
C_FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
C_COMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
RETURN_CUSTOMERINFO(C_NAME_COM);
    LOOP
    FETCH C_NAME_COM INTO C_LASTNAME, C_FIRSTNAME, C_COMPANY;
    EXIT WHEN C_NAME_COM%NOTFOUND;
    IF C_COMPANY IS NULL 
    THEN C_COMPANY := 'NULL';
    END IF;
    DBMS_OUTPUT.PUT_LINE(C_FIRSTNAME || ' ' || C_LASTNAME || ' AT ' || C_COMPANY);
    END LOOP;
    CLOSE C_NAME_COM;
END;

--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE ERASE_INVOICE (
THIS_INVOICEID IN NUMBER)
IS
BEGIN
    DELETE FROM INVOICELINE
    WHERE INVOICELINE.INVOICELINEID = THIS_INVOICEID;
    DELETE FROM INVOICE
    WHERE INVOICE.INVOICEID = THIS_INVOICEID;
END;

--Task – Create a transaction nested within a stored procedure that inserts 
--a new record in the Customer table /// 
CREATE OR REPLACE PROCEDURE ADD_CUSTOMER (
    A_CUSTOMERID IN NUMBER,
    A_FIRSTNAME IN VARCHAR2,
    A_LASTNAME IN VARCHAR2,
    A_COMPANY IN VARCHAR2,
    A_ADDRESS IN VARCHAR2,
    A_CITY IN VARCHAR2,
    A_STATE IN VARCHAR2,
    A_COUNTRY IN VARCHAR2,
    A_POSTALCODE IN VARCHAR2,
    A_PHONE IN VARCHAR2,
    A_FAX IN VARCHAR2,
    A_EMAIL IN VARCHAR2,
    A_SUPPORTREPID NUMBER
)
 
IS
    CUSTOMER_ID NUMBER;
BEGIN
    SAVEPOINT C;
    SELECT COUNT(CUSTOMERID) INTO CUSTOMER_ID FROM CUSTOMER WHERE CUSTOMERID=CUSTOMER_ID;
    IF (CUSTOMER_ID = 0) THEN
    INSERT INTO CUSTOMER VALUES(
        A_CUSTOMER_ID, A_FIRSTNAME, A_LASTNAME, A_COMPANY, A_ADDRESS, A_CITY, 
        A_STATE, A_COUNTRY, A_POSTALCODE, A_PHONE, A_FAX, A_EMAIL, A_SUPPORTPREID);
    ELSE
        DBMS_OUTPUT.PUT_LINE('ERROR. THIS CUSTOMER ALREADY EXISTS!');
    END IF;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('FAILED TO ADD CUSTOMER');
    ROLLBACK TO C;
END;

--6.0 Triggers
--6.1 AFTER/FOR	
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
BEGIN
    CASE
        WHEN INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('Inserting');
    END CASE;
END;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
BEGIN
    CASE
        WHEN UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('Updating');
    END CASE;
END;
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
BEGIN
    CASE
    WHEN DELETING THEN
    DBMS_OUTPUT.PUT_LINE('Deleting');
    END CASE;
END;

--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the 
--name of the customer and the invoiceId.
SELECT FIRSTNAME, LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 OUTER 
--Task – Create an outer join that joins the customer and invoice table, 
--specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMERID, FIRSTNAME, LASTNAME, INVOICE.INVOICEID, TOTAL
FROM CUSTOMER
FULL [OUTER] JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist 
--name and title.
SELECT ALBUM.TITLE AS ALBUM_TITLE, ARTIST.NAME AS ARTIST_NAME
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist 
--name in ascending order.
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;
--9.0 Administration
--In this section you will be creating backup files of your database. After you 
--create the backup file you will also restore the database.
--Task – Create a .bak file for the Chinook database.
