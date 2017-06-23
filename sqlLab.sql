
/*
SQL Lab
2.0 SQL Queries
In this section you will be performing various queries against the Oracle Chinook database. */ 

/* 2.1 SELECT */ 
/*Task – Select all records from the Employee table. */ 
SELECT * 
FROM EMPLOYEE; 


/*Task – Select all records from the Employee table where last name is King. */ 
SELECT * 
FROM EMPLOYEE
WHERE LASTNAME = 'King';


/*Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. */ 
SELECT * 
FROM EMPLOYEE 
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL; 

/* 2.2 ORDER BY */ 
/*Task – Select all albums in Album table and sort result set in descending order by title. */
SELECT * 
FROM ALBUM 
ORDER BY TITLE DESC; 

/*Task – Select first name from Customer and sort result set in ascending order by city */ 
SELECT FIRSTNAME 
FROM CUSTOMER
ORDER BY CITY ASC;

/*2.3 INSERT INTO */
/* Task – Insert two new records into Genre table */ 
INSERT INTO GENRE VALUES (26, 'Punk Rock'); 
INSERT INTO GENRE VALUES (27, 'Soundtrack'); 

/* Task – Insert two new records into Employee table */
/*1st new record: */
INSERT INTO EMPLOYEE VALUES (
9,
'Zaman',
'Mridula',
'Software Engineer',
6,
TO_DATE('1995/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),
TO_DATE('2017/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),
'124 West 54th Street',
'Brooklyn',
'NY',
'USA',
'TIH 1Y8',
'+1 (788) 566-8909',
'+1 (788) 566-8979',
'mridula@chinookcorp.com'
);

/* 2nd new record: */ 
INSERT INTO EMPLOYEE VALUES (
10,
'Khan',
'Zaid',
'General Manager',
1,
TO_DATE('1988/06/18 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),
TO_DATE('2017/02/14 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),
'124 West 54th Street',
'Queens',
'NY',
'USA',
'TIH 1Y8',
'+1 (798) 546-8909',
'+1 (728) 526-8979',
'zaid@chinookcorp.com'
);

/* Task – Insert two new records into Customer */
/* 1st new record: */
INSERT INTO CUSTOMER VALUES (
60,
'Ron',
'Wang',
'Revature',
'119 West 31st Street',
'NY',
'NY',
'USA',
'789907',
'+1 (988)908-7856',
'+1 (984)918-2856',
'ron@gmail.com',
3
);
/* 2nd new record */
INSERT INTO CUSTOMER VALUES (
61,
'Dameon',
'Lucifer',
'Music4Life',
'768 Potter Street',
'Chicago',
'IL',
'USA',
'234907',
'+1 (288)908-7856',
'+1 (904)918-2856',
'dlucifer@gmail.com',
2
);

/* 2.4 UPDATE */ 
/* Task – Update Aaron Mitchell in Customer table to Robert Walter */ 
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', 
LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell'; 

/* Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to  */ 
UPDATE ARTIST
SET NAME = 'CCR' 
WHERE NAME = 'Creedence Clearwater Revival';  

/* 2.5 LIKE */
/* Task – Select all invoices with a billing address like “T%” */ 
SELECT * 
FROM INVOICE 
WHERE BILLINGADDRESS LIKE 'T%';

/* 2.6 BETWEEN */
/* Task – Select all invoices that have a total between 15 and 50 */ 
SELECT * 
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50; 

/* Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 */ 
SELECT * 
FROM EMPLOYEE
WHERE HIREDATE BETWEEN (TO_DATE('2003/06/01', 'yyyy/mm/dd')) AND (TO_DATE('2004/03/01', 'yyyy/mm/dd'));

/* 2.7 DELETE */
/* Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). */
 ALTER TABLE INVOICE
 DROP CONSTRAINT FK_INVOICECUSTOMERID; 

 DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
 
 /*SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
3.1 System Defined Functions */

/* Task – Create a function that returns the current time. */
SELECT TO_CHAR
    (SYSDATE, 'HH12:MI:SS') "CURRENT TIME"
     FROM DUAL;

/* BY USER-DEFINED FUNCTIONS: */
CREATE OR REPLACE FUNCTION GET_TIME
RETURN TIMESTAMP
IS 
T TIMESTAMP;
BEGIN
	T := CURRENT_TIMESTAMP;
RETURN T;
END;

/* Task – create a function that returns the length of a mediatype from the mediatype table */ 
SELECT LENGTH(NAME) FROM MEDIATYPE;

/* User defined function for it: */
CREATE OR REPLACE FUNCTION RETURN_MEDIALENGTH 
(NAME IN VARCHAR2) 
RETURN INTEGER
IS 
MEDIA_LENGTH INTEGER; 
BEGIN 
	MEDIA_LENGTH := LENGTH(NAME);
RETURN MEDIA_LENGTH;
END; 

/* An example of the function being called */ 
SELECT RETURN_MEDIALENGTH('AAC audio file')
FROM MEDIATYPE WHERE NAME = 'AAC audio file';

/* 3.2 System Defined Aggregate Functions */
/* Task – Create a function that returns the average total of all invoices */ 
SELECT AVG(TOTAL)
FROM INVOICE; 

-- CREATED FUNCTION:
CREATE OR REPLACE FUNCTION AVERAGE_INVOICE
RETURN NUMBER
AS
A_T NUMBER;
BEGIN
SELECT AVG(A_T) INTO A_T FROM INVOICE;
RETURN A_T;
END; 

DECLARE
A_T NUMBER; 
BEGIN 
A_T := AVERAGE_INVOICE;
DBMS_OUTPUT.PUT_LINE('THE AVERAGE INVOICE PRICE IS '|| A_T);
END; 

/* Task – Create a function that returns the most expensive track */ 
SELECT MAX(UNITPRICE)
FROM TRACK; 

-- CREATED FUNCTION: 
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER
AS 
MAXIMUM NUMBER;
BEGIN 
SELECT MAX(UNITPRICE) INTO MAXIMUM FROM TRACK;
RETURN MAXIMUM;
END; 

DECLARE 
MAXIMUM NUMBER; 
BEGIN 
MAXIMUM := MOST_EXPENSIVE_TRACK;
DBMS_OUTPUT.PUT_LINE('THE MAXIMUM IS: ' || MAXIMUM);
END; 

/* 3.3 User Defined Scalar Functions */ 
/* Task – Create a function that returns the average price of invoiceline items in the invoiceline table */
SELECT AVG(UNITPRICE)
FROM INVOICELINE; 

-- CREATED FUNCTION:
CREATE OR REPLACE FUNCTION AVERAGE_INVOICELINE
RETURN NUMBER
AS
A_T NUMBER;
BEGIN
SELECT AVG(UNITPRICE) INTO A_T FROM INVOICELINE;
RETURN A_T;
END; 

DECLARE
A_T NUMBER; 
BEGIN 
A_T := AVERAGE_INVOICELINE;
DBMS_OUTPUT.PUT_LINE('THE AVERAGE INVOICE PRICE IS '|| A_T);
END; 

/* 3.4 User Defined Table Valued Functions */
/* Task – Create a function that returns all employees who are born after 1968. */
SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= (TO_DATE('31-DEC-1968','DD-MON-YYYY'));

-- CREATED FUNCTION:
CREATE TYPE EMPLOYEE_TABLE IS OBJECT
(EMPLOYEEID INTEGER(30),
FIRSTNAME VARCHAR2(100),
LASTNAME VARCHAR2(100)); 

CREATE TYPE AGE_TABLE IS TABLE OF EMPLOYEE_TABLE;

CREATE OR REPLACE FUNCTION YOUNGER_EMPLOYEES
RETURN AGE_TABLE PIPELINED IS 
BEGIN
    FOR I IN (SELECT EMPLOYEEID, FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE BIRTHDATE >= '01-JAN-1968')
    LOOP
        PIPE ROW (EMPLOYEE_TABLE(I.EMPLOYEEID, I.FIRSTNAME, I.LASTNAME));
    END LOOP; 
    RETURN;
END;

SELECT * FROM TABLE(YOUNGER_EMPLOYEES);

/* 4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees. */ 
CREATE OR REPLACE PROCEDURE SELECT_NAMES(SR OUT SYS_REFCURSOR) 
IS
BEGIN 
    OPEN SR FOR 
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE; 
END; 

DECLARE 
SR SYS_REFCURSOR; 
F_N EMPLOYEE.FIRSTNAME%TYPE;
L_N EMPLOYEE.LASTNAME%TYPE; 
BEGIN 
SELECT_NAMES(SR);
LOOP
    FETCH SR INTO F_N, L_N;
    EXIT WHEN SR%NOTFOUND;
	DBMS_OUTPUT.PUT_LINE('FIRST NAME: ' || F_N || ' LAST NAME: ' || L_N);
END LOOP;
CLOSE SR;
END; 

 /*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee. */
/* This will update an item of personal information of the employee, more specifically the employee's title */ 
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_TITLE
(EMP_ID IN NUMBER, NEW_TITLE IN VARCHAR2) 
AS
BEGIN 
UPDATE EMPLOYEE
SET TITLE = NEW_TITLE 
WHERE EMPLOYEEID = EMP_ID; 
END; 

BEGIN 
UPDATE_EMPLOYEE_TITLE(1,'CEO'); 
END;

/* 4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer. */
CREATE OR REPLACE PROCEDURE CUSTOMER_NAME_COMPANY (SR OUT SYS_REFCURSOR)
IS 
BEGIN 
OPEN SR FOR 
    SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER;
END; 

DECLARE
SR SYS_REFCURSOR; 
F_N CUSTOMER.FIRSTNAME%TYPE;
L_N CUSTOMER.LASTNAME%TYPE;
C_N CUSTOMER.COMPANY%TYPE; 
BEGIN 
CUSTOMER_NAME_COMPANY(SR);
LOOP 
    FETCH SR INTO F_N,L_N,C_N;
    EXIT WHEN SR%NOTFOUND;
    IF C_N IS NULL THEN C_N := 'UNEMPLOYED';
    END IF;
    DBMS_OUTPUT.PUT_LINE('FIRST NAME: ' || F_N || 'LAST NAME: ' || L_N || ' COMPANY: ' || C_N);
END LOOP;
CLOSE SR;
END;

/* 5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure. */
/*Task – Create a transaction that given a invoiceId will delete that invoice 
(There may be constraints that rely on this, find out how to resolve them). */
CREATE OR REPLACE PROCEDURE DELETE_INVOICE (INV_ID IN INTEGER) 
IS
BEGIN
DELETE FROM INVOICE WHERE INV_ID = INVOICEID;
DELETE FROM INVOICELINE WHERE INV_ID = INVOICEID; 
END; 

BEGIN
DELETE_INVOICE(990);
END; 

/* Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table */ 
CREATE OR REPLACE PROCEDURE INSERT_NEW_CUSTOMER(
CUSTOMERID_ IN NUMBER,
FIRSTNAME_ IN VARCHAR2,
LASTNAME_ IN VARCHAR2,
COMPANY_ IN VARCHAR2,
ADDRESS_ IN VARCHAR2,
CITY_ IN VARCHAR2,
STATE_ IN VARCHAR2,
COUNTRY_ IN VARCHAR2,
POSTALCODE_ IN VARCHAR2,
PHONE_ IN VARCHAR2,
FAX_ IN VARCHAR2,
EMAIL_ IN VARCHAR2,
SUPPORTREPID_ IN NUMBER
)
IS
BEGIN 
INSERT INTO CUSTOMER VALUES
(CUSTOMERID_, 
FIRSTNAME_,
LASTNAME_,
COMPANY_,
ADDRESS_,
CITY_,
STATE_,
COUNTRY_,
POSTALCODE_,
PHONE_,
FAX_,
EMAIL_,
SUPPORTREPID_
);
END; 

BEGIN
INSERT_NEW_CUSTOMER(CUSTOMERID_=>62,FIRSTNAME_=>'Harry',LASTNAME_=>'Potter',COMPANY_=>'Hogwarts',ADDRESS_=>'Under the Cupboard',CITY_=>'Brooklyn',STATE_=>'NY',COUNTRY_=>'USA',POSTALCODE_=>'123456',PHONE_=>'+1 (789)987-0000',FAX_=>'+1 (789)987-0000',EMAIL_=>'harryPotter@hogwarts.com',SUPPORTREPID_=>2); 
END; 

/*6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
6.1 AFTER/FOR */
/* Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. */ 
CREATE OR REPLACE TRIGGER INSERT_EMP_TRIGGER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('A NEW EMPLOYEE WAS INSERTED');
END;

INSERT INTO EMPLOYEE VALUES(63,'Cage','Luke','Superhero',3,NULL,NULL,'1345 Harlem Hometown','Bronx','NY','USA','546775','+1 (783)567-0943','+1 (783)567-0943','lcage@awesome.com');


/* Task – Create an after update trigger on the album table that fires after a row is inserted in the table */ 
CREATE OR REPLACE TRIGGER AFTER_ALBUM_TRIGGER
AFTER UPDATE ON ALBUM 
FOR EACH ROW 
BEGIN 
DBMS_OUTPUT.PUT_LINE('AN ALBUM WAS UPDATED');
END;

/* Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. */ 
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER_TRIGGER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('CUSTOMER WAS DELETED');
END;

/* 7.0 JOINS
In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
7.1 INNER */
/*Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. */
SELECT CUSTOMER.FIRSTNAME || CUSTOMER.LASTNAME AS NAME, INVOICE.INVOICEID
FROM CUSTOMER 
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. */
 SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER 
FULL JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/* 7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title. */
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST 
RIGHT JOIN ALBUM 
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

/*7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order. */
SELECT * 
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

/* 7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column. */ 
/*
You use a self join when a table references data in itself.
E.g., an Employee table may have a SupervisorID column that points to the employee that is the boss of the current employee.
*/
SELECT E1.EMPLOYEEID, E1.FIRSTNAME, E1.LASTNAME, E1.REPORTSTO
FROM EMPLOYEE E1 
LEFT OUTER JOIN EMPLOYEE E2 ON E1.REPORTSTO = E2.EMPLOYEEID;

/* 9.0 Administration
In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
Task – Create a .bak file for the Chinook database.

*/ 