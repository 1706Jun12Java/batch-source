/*
2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE
WHERE LASTNAME='King';

SELECT * FROM EMPLOYEE
WHERE FIRSTNAME='Andrew'
AND REPORTSTO IS NULL;

/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
INSERT INTO GENRE VALUES (27,'Chillstep');
INSERT INTO GENRE VALUES (28,'Kpop');

INSERT INTO EMPLOYEE VALUES(9,'Doe','John','IT Staff',6,'27-MAY-1993','22-JUN-2017','4353 12St','Somewhere','AB','Canada','T1K 5D2','1 (231) 234-3432','1 (231) 234-1337','RAND@PLACE.COM');
INSERT INTO EMPLOYEE VALUES(10,'SUE','MARY','IT Staff',6,'27-MAY-1993','22-JUN-2017','432 1AVE','Somewhere','NY','USA','11000','1 (212) 234-3432','1 (212) 234-1337','BEST@PLACE.COM');

INSERT INTO CUSTOMER VALUES(60,'SAD','PERSON',NULL,'1234 1AVE','QUEENS','NY','USA','21341','1 123 456 7890', '1 123 123 1234', 'EMAIL@PLACE.COM',NULL);
INSERT INTO CUSTOMER VALUES(61,'HAPPY','PERSON',NULL,'4532 11AVE','BROOKLYN','NY','USA','24356','1 123 456 7430', '1 223 333 1214', 'WELCOME@PLACE.COM',NULL);

/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/
UPDATE CUSTOMER
SET FIRSTNAME='Robert',
LASTNAME='Walter'
WHERE FIRSTNAME='Aaron' 
AND LASTNAME='Mitchell';

UPDATE ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';

/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*/
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';

/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/
DELETE FROM INVOICELINE
WHERE INVOICEID IN(
    SELECT INVOICEID FROM INVOICE
    WHERE INVOICE.CUSTOMERID = (
        SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND
         LASTNAME='Walter'
    )
);

DELETE FROM INVOICE
WHERE CUSTOMERID = (
    SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND
LASTNAME='Walter'
);

DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

/*
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of name in MEDIATYPE table
*/
CREATE OR REPLACE FUNCTION GET_CURR_TIME
RETURN TIMESTAMP
IS
CURR_TIME TIMESTAMP;
   CURSOR C IS
    SELECT CURRENT_TIMESTAMP FROM DUAL;
BEGIN 
    OPEN C;
    FETCH C INTO CURR_TIME;
    CLOSE C;
  RETURN CURR_TIME;
END;

--3.1 SECOND ONE
CREATE OR REPLACE FUNCTION GET_STR_LEN
RETURN NUMBER
IS
NAME_LEN NUMBER;
CURSOR LEN_C IS
    SELECT MAX(VSIZE(NAME)) FROM MEDIATYPE;
BEGIN 
    OPEN LEN_C;
    FETCH LEN_C INTO NAME_LEN;
    CLOSE LEN_C;
  RETURN NAME_LEN;
END;

/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track
*/
CREATE OR REPLACE FUNCTION AVG_TOTAL_INVOICE
RETURN NUMBER
IS
AVG_VAL NUMBER;
CURSOR AVG_C IS
    SELECT AVG(TOTAL) FROM INVOICE;
BEGIN 
    OPEN AVG_C;
    FETCH AVG_C INTO AVG_VAL;
    CLOSE AVG_C;
  RETURN AVG_VAL;
END;

--FIND MOST EXPENSIVE TRACK
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER
IS
HIGHEST_VAL NUMBER;
CURSOR MAX_C IS
    SELECT MAX(UNITPRICE) FROM TRACK;
BEGIN 
    OPEN MAX_C;
    FETCH MAX_C INTO HIGHEST_VAL;
    CLOSE MAX_C;
  RETURN HIGHEST_VAL;
END;

/*
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/
CREATE OR REPLACE FUNCTION AVG_PRICE_INVOICELINE
RETURN NUMBER
IS
AVG_PRICE_ITEM NUMBER;
CURSOR AVGIV_C IS
    SELECT AVG(UNITPRICE) FROM INVOICELINE;
BEGIN 
    OPEN AVGIV_C;
    FETCH AVGIV_C INTO AVG_PRICE_ITEM;
    CLOSE AVGIV_C;
  RETURN AVG_PRICE_ITEM;
END;

/*
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/
CREATE OR REPLACE FUNCTION GET_EMP_POST1968
RETURN SYS_REFCURSOR
IS
EMPS SYS_REFCURSOR;
BEGIN
    OPEN EMPS FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE>'31-DEC-1968';
    RETURN EMPS;
END;

/*
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/
CREATE OR REPLACE PROCEDURE SP_GET_EMP_NAMES (S OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN S FOR 
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;

DECLARE 
S SYS_REFCURSOR;
FNAME EMPLOYEE.FIRSTNAME%TYPE;
LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
SP_GET_EMP_NAMES(S);
  LOOP
    FETCH S INTO FNAME,LNAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('FIRSTNAME: '||FNAME||' LASTNAME: '||LNAME);
  END LOOP;
  CLOSE S;
END;

--4.2
--UPDATE EMPLOYEE PERSONAL INFO
CREATE OR REPLACE PROCEDURE SP_UPDATE_PER_EMP(E_ID IN NUMBER, LNAME IN VARCHAR2,FNAME IN VARCHAR2,
    ADDRESSS IN VARCHAR2, CITYY IN VARCHAR2, STATEE IN VARCHAR2, COUNTRYY IN VARCHAR2, 
    POSTAL IN VARCHAR2, CELL IN VARCHAR2, FAXX IN VARCHAR2, E_MAIL IN VARCHAR2 )
IS
    E_ID_COUNT NUMBER;
BEGIN
    SAVEPOINT PERSONAL_INFO_UP;
  SELECT COUNT(EMPLOYEEID) INTO E_ID_COUNT FROM EMPLOYEE WHERE EMPLOYEEID=E_ID;
    IF (E_ID_COUNT  >0) THEN
        UPDATE EMPLOYEE 
        SET LASTNAME = LNAME,
            FIRSTNAME = FNAME,
            ADDRESS = ADDRESSS,
            CITY=CITYY,
            STATE=STATEE,
            COUNTRY=COUNTRYY,
            POSTALCODE=POSTAL,
            PHONE=CELL,
            FAX=FAXX,
            EMAIL=E_MAIL
        WHERE EMPLOYEEID = E_ID;
    ELSE
        DBMS_OUTPUT.PUT_LINE('EMPOYEE ID NOT FOUND');
    END IF;
    COMMIT;
    EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('FAILED TO UPDATE EMPLOYEE');
  ROLLBACK TO PERSONAL_INFO_UP;
END;
--Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE SP_GET_EMP_NAMES (E_ID IN NUMBER,MANAGERS OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN MANAGERS FOR 
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE 
  WHERE EMPLOYEEID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID=E_ID);
END;

--4.3
--Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE SP_CUST_DATA (C_ID IN NUMBER, CUST_INFO OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN CUST_INFO FOR 
  SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER 
  WHERE CUSTOMERID = C_ID;
END;

/*
5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/
CREATE OR REPLACE PROCEDURE SP_DEL_INVOICE (I_ID IN NUMBER)
IS
    I_COUNT NUMBER;
BEGIN
    SAVEPOINT DEL_INVOICE;
    SELECT COUNT(INVOICEID) INTO I_COUNT FROM INVOICE WHERE INVOICEID=I_ID;
    IF(I_COUNT>0) THEN
        DELETE FROM INVOICELINE
        WHERE INVOICEID = I_ID;
    
        DELETE FROM INVOICE
        WHERE INVOICEID=I_ID;
    ELSE
        DBMS_OUTPUT.PUT_LINE('INVOICE ID NOT FOUND');
    END IF;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('FAILED TO DELETE INVOICE');
  ROLLBACK TO DEL_INVOICE;
END;

--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
INSERT INTO EMPLOYEE VALUES(9,'Doe','John','IT Staff',6,'27-MAY-1993','22-JUN-2017','4353 12St','Somewhere','AB','Canada','T1K 5D2','1 (231) 234-3432','1 (231) 234-1337','RAND@ACE.COM');
 SELECT COUNT(EMPLOYEEID) FROM EMPLOYEE WHERE EMPLOYEEID=11;

CREATE OR REPLACE PROCEDURE SP_INSERT_EMP(E_ID IN NUMBER, LNAME IN VARCHAR2,FNAME IN VARCHAR2, TITLEE IN VARCHAR2, REPORTSTOO IN NUMBER,
    BDATE IN DATE, HDATE IN DATE, ADDRESSS IN VARCHAR2, CITYY IN VARCHAR2, STATEE IN VARCHAR2, COUNTRYY IN VARCHAR2, 
    POSTAL IN VARCHAR2, CELL IN VARCHAR2, FAXX IN VARCHAR2, E_MAIL IN VARCHAR2 )
IS
    E_ID_EXIST NUMBER;
BEGIN
    SAVEPOINT INSERT_EMP;
  SELECT COUNT(EMPLOYEEID) INTO E_ID_EXIST FROM EMPLOYEE WHERE EMPLOYEEID=E_ID;
    IF (E_ID_EXIST  = 0) THEN
    INSERT INTO EMPLOYEE VALUES (E_ID,LNAME,FNAME,TITLEE,REPORTSTOO,BDATE,HDATE,ADDRESSS,CITYY,STATEE,COUNTRYY,POSTAL,CELL,FAXX,E_MAIL);
    ELSE
      DBMS_OUTPUT.PUT_LINE('EMPOYEE ALREADY EXISTS');  
    END IF;
    COMMIT;
    EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('FAILED TO INSERT EMPLOYEE');
  ROLLBACK TO INSERT_EMP;
END;
/*
6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/
--6.1-1
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('INSERTED NEW EMPLOYEE');
END;
--6.1-2
CREATE OR REPLACE TRIGGER TR_UDATE_ALBUM
AFTER UPDATE ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('UPDATED AN ALBUM');
END;
--6.1-3
CREATE OR REPLACE TRIGGER TR_DELETE_CUST
AFTER DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('DELETED A CUSTOMER');
END;

/*
7.0 JOINS
In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
SELECT CUST.LASTNAME, CUST.FIRSTNAME, IV.INVOICEID
FROM CUSTOMER CUST
INNER JOIN INVOICE IV
ON CUST.CUSTOMERID = IV.INVOICEID;

/*
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/
SELECT CUST.CUSTOMERID, CUST.LASTNAME, CUST.FIRSTNAME, IV.INVOICEID, IV.TOTAL
FROM CUSTOMER CUST
FULL OUTER JOIN INVOICE IV
ON CUST.CUSTOMERID = IV.INVOICEID;

/*
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/
SELECT ART.NAME, AL.TITLE
FROM ARTIST ART
RIGHT JOIN ALBUM AL
ON ART.ARTISTID = AL.ARTISTID;

/*
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
SELECT *
FROM ARTIST ART
FULL OUTER JOIN ALBUM AL
ON ART.ARTISTID = AL.ARTISTID
ORDER BY ART.NAME ASC;


/*
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/
SELECT A.FIRSTNAME, A.LASTNAME, A.REPORTSTO, B.EMPLOYEEID, B.FIRSTNAME, B.LASTNAME
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;

/*
9.0 Administration
In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
Task – Create a .bak file for the Chinook database.
*/