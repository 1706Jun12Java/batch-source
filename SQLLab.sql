/**
2.0 SQL QUERIES
**/
--2.1 Select 
select * from Employee;

select * from Employee where LASTNAME = 'King';

select * from Employee where FIRSTNAME = 'Andrew' and REPORTSTO is null;

--2.2 Order By 

select * from album order by title desc; 

select firstname from customer order by city asc; 

--2.3 Insert Into
insert into genre values (1,'Romance');
insert into genre values (2,'Action');

insert into Employee values (9,'John','Doe','IT Staff',6,'17-DEC-2015', '17-DEC-2015',null,'Charolette','NC','United States',null,null,null,'someEmail1');
insert into Employee values (9,'Mary','Sue','IT Staff',6,'17-DEC-2015', '17-DEC-2015',null,'Charolette','NC','United States',null,null,null,'someEmail2');

insert into customer values (9,'John','Doe','IT Staff',6,TO_DATE('2015-12-17','yyyy-mm-dd'), TO_DATE('2015-12-17','yyyy-mm-dd'),null,'Charolette','NC','United States',null,null,null,'someEmail1',null);
insert into customer values (9,'Mary','Sue','IT Staff',6,TO_DATE('2015-12-17','yyyy-mm-dd'), TO_DATE('2015-12-17','yyyy-mm-dd'),null,'Charolette','NC','United States',null,null,null,'someEmail2',null);

--2.4 Update 
update customer set firstname = 'Robert', lastname = 'Walker' where firstname = 'Aaron' and lastname = 'Mitchell'; 
update artist set "name" = 'Creedence Clearwater Revival' where "name" = 'CCR';

--2.5 Like 
select * from INVOICE where BILLINGADDRESS like 'T%';

--2.6 Between 
select * from INVOICE where total between 15 and 50;

select * from employee where  HIREDATE between to_Date('2003-06-01','yyyy-mm-dd') and to_Date('2004-03-01','yyyy-mm-dd');

--2.7 Delete 
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
delete from customer where firstname = 'Robert' and lastname = 'Walker';

/**
3. SQL Functions
**/

--3.1 System Defined Functions
CREATE OR REPLACE FUNCTION GET_TIME
RETURN TIMESTAMP
AS 
T TIMESTAMP;
BEGIN
    T := CURRENT_TIMESTAMP;
RETURN T;
END;

CREATE OR REPLACE FUNCTION GET_MEDIA_LENGTH (MEDIA_NAME IN VARCHAR2)
RETURN NUMBER
AS
LEN NUMBER;
TYPE_ID NUMBER;
BEGIN
    SELECT MEDIA.MEDIATYPEID INTO TYPE_ID FROM MEDIATYPE WHERE MEDIATYPE."NAME" = MEDIA_NAME;
    SELECT TRACK.MILLISECONDS INTO LEN FROM TRACK WHERE TYPE.MILLISECONDS = TYPE_ID;
RETURN LEN;
END;

--3.2 System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION INVOICE_AVG 
RETURN NUMBER
AS
AVG_ NUMBER;
BEGIN
    SELECT AVG(INVOICE.TOTAL) INTO AVG_ FROM INVOICE;
RETURN AVG_;
END;

CREATE OR REPLACE FUNCTION INVOICE_AVG 
RETURN NUMBER
AS
MAX_ NUMBER;
BEGIN
    SELECT MAX(TRACK.UNITPRICE) INTO MAX_ FROM TRACK;
RETURN MAX_;
END;

--3.3 USER DEFINED SCALAR FUNCTIONS
CREATE OR REPLACE FUNCTION INVOICE_AVG_PRICE
RETURN NUMBER
AS
AVG_ NUMBER;
SUM_ NUMBER;
COUNT_ NUMBER;
BEGIN
    SELECT SUM(INVOICELINE.UNITPRICE) INTO SUM_ FROM INVOICELINE;
    SELECT COUNT(INVOICELINE.UNITPRICE) INTO COUNT_ FROM INVOICELINE;
    AVG_ := SUM_ / COUNT_;
RETURN AVG_;
END;

--3.4 USER DEFINED TABLE VALUED FUNCTIONS
CREATE OR REPLACE FUNCTION EMPLOYEE_AFTER_1968(S OUT SYS_REFCURSOR)
RETURN SYS_REFCURSOR
IS
BEGIN
    OPEN S FOR SELECT * FROM EMPLOYEE WHERE EXTRACT(YEAR FROM BIRTHDATE) > 1968;
RETURN S;
END;


/**
4.0 Stored Procedure
**/

--4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE PRINT_NAMES
IS 
BEGIN
    SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
END;

--4.2 STORED PROCEDURE INPUT PARAMETERS
CREATE OR REPLACE PROCEDURE UPDATE_NAME("A" IN NUMBER, B IN VARCHAR2,"C" IN VARCHAR2, "D" IN VARCHAR2, "E" IN VARCHAR2, "F" IN DATE, "G" IN DATE, "H" IN VARCHAR2, "I" IN VARCHAR2, J IN VARCHAR2, "K" IN VARCHAR2, "L" IN VARCHAR2, "M" IN VARCHAR2,"N" IN VARCHAR2, O IN VARCHAR2, "P" IN NUMBER)
IS
BEGIN
UPDATE EMPLOYEE SET 
    EMPLOYEE.EMPLOYEEID = "A",
    EMPLOYEE.LASTNAME = B,
    EMPLOYEE.FIRSTNAME = "C",
    EMPLOYEE.TITLE = "D",
    EMPLOYEE.REPORTSTO = "E",
    EMPLOYEE.BIRTHDATE = "F",
    EMPLOYEE.HIREDATE = "G",
    EMPLOYEE.ADDRESS = "H",
    EMPLOYEE.CITY = "I",
    EMPLOYEE."STATE" = J,
    EMPLOYEE.COUNTRY = "K",
    EMPLOYEE.POSTALCODE = "L",
    EMPLOYEE.PHONE = "M",
    EMPLOYEE.FAX = "N",
    EMPLOYEE.EMAIL = O
    WHERE EMPLOYEE.EMPLOYEEID = "P";
END;


CREATE OR REPLACE PROCEDURE GET_MANAGER(E_ID IN NUMBER)
IS
MANGER VARCHAR2;
BEGIN
    SELECT EMPLOYEE.REPORTSTO INTO MANGER FROM EMPLOYEE WHERE E_ID = EMPLOYEE.EMPLOYEEID;
    RETURN MANGER;
END;

--4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE EMPLOYEE_AFTER_1968(C_ID IN NUMBER, S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR SELECT FIRSTNAME,LASTNAME,COMPANY FROM CUSTOMER WHERE CUSTOMERID = C_ID;
RETURN S;
END;

/**
5.0 Transactions
**/

ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM INVOICE WHERE INVOICEID = 1;
COMMIT;

CREATE OR REPLACE PROCEDURE ADD
IS
BEGIN
    INSERT INTO CUSTOMERS VALUES (20,'Bob','Marley',null,null,null,null,null,null,null,null,null,null);
    COMMIT;
END;

/**
6.0 TRIGGERS
**/
CREATE OR REPLACE TRIGGER TR_EMPLOY
AFTER INSERT ON EMPLOYEE
BEGIN
    SELECT * FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_ALBUM
AFTER UPDATE ON ALBUM
BEGIN
    SELECT * FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_CUST
AFTER DELETE ON CUSTOMER
BEGIN
    SELECT * FROM DUAL;
END;
/**
7.0 JOINS 
**/
--7.1 INNER 
SELECT CUSTOMER.FIRSTNAME AS FIRST_NAME, CUSTOMER.LASTNAME AS LAST_NAME, INVOICE.INVOICEID AS INVOICE_ID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 OUTER
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME AS FIRST_NAME, CUSTOMER.LASTNAME AS LAST_NAME, INVOICE.INVOICEID AS INVOICE_ID, INVOICE.TOTAL AS TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 LEFT
SELECT ARTIST."NAME" AS "NAME", ALBUM.TITLE AS TITLE
FROM ARTIST
RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--7.4 CROSS
SELECT ARTIST."NAME" AS "NAME", ALBUM.TITLE AS TITLE
FROM ARTIST
CROSS JOIN ALBUM
ORDER BY ARTIST."NAME" ASC;
