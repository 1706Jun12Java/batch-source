/* Question 2.0 SQL Queries

In this section you will be performing various queries against the Oracle Chinook database.

2.1 SELECT

Task – Select all records from the Employee table.

Task – Select all records from the Employee table where last name is King.

Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. */

select * from employee;

select * from employee
where lastname='King';

select * from employee
where firstname='Andrew' and reportsto is null;

/* 2.2 ORDER BY

Task – Select all albums in Album table and sort result set in descending order by title.

Task – Select first name from Customer and sort result set in ascending order by city

*/

select * from album
order by title desc;

select * from customer
order by city asc;

/* 2.3 INSERT INTO

Task – Insert two new records into Genre table

Task – Insert two new records into Employee table

Task – Insert two new records into Customer table

*/

insert into genre values (26, 'JPOP');
insert into genre values (27, 'BobMusic');
insert into employee values(999, 'Wilson','harvey','revature',null,'01-jan-2000','06-jun-2017','119 W 31 Street Unit 201', 'New York', 'NY','USA','11433','9999999999','1111111111','testing@revature.com');
insert into employee values(888, 'bob','gary','revature',null,'31-dec-1950','06-jun-2017','119 W 31 Street Unit 201', 'New York', 'NY','USA','11433','9999999999','1111111111','testing@revature.com');

insert into customer (customerid, firstname,lastname,address,city,state,country, postalcode,email) 
values (999,'diego','ramirez','5001 northern blvd','queens','ny','usa','11101','diegoramirez123@revature.com');
insert into customer (customerid, firstname,lastname,address,city,state,country, postalcode,email) 
values (888,'michael','amparo','5001 northern blvd','queens','ny','usa','11101','michaelamparo123@revature.com');


/* 2.4 UPDATE

Task – Update Aaron Mitchell in Customer table to Robert Walter

Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

*/

update customer 
set firstname = 'robert', lastname= 'walter'
where firstname ='Aaron' and lastname='Mitchell';

update artist
set name ='CCR'
where name='Creedence Clearwater Revival';

/* 2.5 LIKE
Task – Select all invoices with a billing address like “T%”

T% = STARTS WITH LETTER T

*/

SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%'; 


/*2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/

SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT * 
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';


/*2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/
-- temporarily take off constraints. alter table drop constraint
--change dependant entrants to null
alter table invoice
drop constraint FK_customerid;

alter table INVOICE
add constraint FK_CUSTOMERID
FOREIGN KEY (CustomerID) references CUSTOMER(customerID)
ON DELETE SET NULL;

delete from Customer
where firstname='Robert', lastname = 'Walter';


/*3.	SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
*/

/*3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table
*/


--3.1

CREATE OR REPLACE FUNCTION GET_TIME
RETURN TIMESTAMP
IS
T TIMESTAMP;
BEGIN
    T := CURRENT_TIMESTAMP;
RETURN T;
END;

DECLARE 
    X TIMESTAMP;
BEGIN
    X := GET_TIME();
    DBMS_OUTPUT.PUT_LINE('MAX: '||X);
END;


/*3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track
*/

select avg(total)
from invoice;

select max(unitprice)
from track;


/*3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/

CREATE OR REPLACE FUNCTION GETAVERAGEPRICE
RETURN number
IS average NUMBER;
BEGIN   
    select AVG(unitprice) into average from invoiceline;
    return average;
END;

select GETAVERAGEPRICE from DUAL;


/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/

create type my_tab_type is object
(x  number, firstname varchar(100), lastname varchar(100), birthday date);
/
create type my_tab_type_coll is table of my_tab_type;
/

create or replace function olderemployees
return my_tab_type_coll pipelined is
begin
    For i in (select employeeid, lastname, firstname, birthdate from employee where birthdate>='01-jan-1968') loop
        pipe row(my_tab_type(i.employeeid,i.lastname,i.firstname,i.birthdate));
    end loop;
    return;
end;
/

select * from table(olderemployees)

/*4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/
 /*Using a Function */
 
create or replace type nametable is object
(firstname varchar(100), lastname varchar(100));
/
create or replace type nametable_col is table of nametable;
/

create or replace function get_names
return nametable_col pipelined is
begin
    For i in (select lastname, firstname from employee) loop
        pipe row(nametable(i.lastname,i.firstname));
    end loop;
    return;
end;
/

select * from table(get_names)

/* Using Stored Procedure */

CREATE OR REPLACE PROCEDURE NAMEGET (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME  FROM EMPLOYEE;
END;

DECLARE 
S SYS_REFCURSOR;
FNAME EMPLOYEE.FIRSTNAME%type;
LNAME EMPLOYEE.LASTNAME%type;
BEGIN
NAMEGET(S);
  LOOP
    FETCH S INTO FNAME,LNAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('FIRST NAME: ' || FNAME||', LAST NAME: '||LNAME);
  END LOOP;
  CLOSE S;
END;


/*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
*/

CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEE 
(
LNAME       IN EMPLOYEE.LASTNAME%TYPE,
FNAME       IN EMPLOYEE.FIRSTNAME%TYPE,
NTITLE      IN EMPLOYEE.TITLE%TYPE, 
NREPORT     IN EMPLOYEE.REPORTSTO%TYPE, 
NBDAY       IN EMPLOYEE.BIRTHDATE%TYPE,
NADDRESS    IN EMPLOYEE.ADDRESS%TYPE,
NCITY       IN EMPLOYEE.CITY%TYPE, 
NSTATE      IN EMPLOYEE.STATE%TYPE,
NCOUNTRY    IN EMPLOYEE.COUNTRY%TYPE, 
NPOSTAL     IN EMPLOYEE.POSTALCODE%TYPE,
NPHONE      IN EMPLOYEE.PHONE%TYPE,
NFAX        IN EMPLOYEE.FAX%TYPE,
NEMAIL      IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE 
    SET LASTNAME = LNAME; FIRSTNAME = FNAME; TITLE = NTITLE; REPORTSTO = NREPORT; BIRTHDATE = NBDAY; ADDRESS = NADDRESS; CITY = NCITY; COUNTRY = NCOUNTRY; POSTAL = NPOSTAL; FAX = NFAX; EMAIL = NEMAIL;
END;

/*4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/







/*5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/

CREATE OR REPLACE PROCEDURE REMOVEINVOICE
(REMOVALINDEX IN NUMBER)
IS
BEGIN
DELETE FROM INVOICELINE WHERE REMOVALINDEX = INVOICEID;
DELETE FROM INVOICE WHERE REMOVALINDEX =INVOICEID;
END;

BEGIN
REMOVEINVOICE(3);
END;

CREATE OR REPLACE PROCEDURE INSERTNEWRECCORD
(
NID IN INTEGER,
NFNAME IN VARCHAR2,
NLNAME IN VARCHAR2
)
IS
BEGIN
INSERT INTO CUSTOMER VALUES (NID,NFNAME,NLNAME,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
END;

BEGIN
INSERTNEWRECCORD(30,'JIM','BRAHENY');
END;







/*6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

 6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/

CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('NEW EMPLOYEE WAS ADDED!');
END;
INSERT INTO EMPLOYEE VALUES (29,'dog','bog',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

create or replace trigger TR_UPDATE_ALBUM
AFTER UPDATE on ALBUM
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('ALBUM WAS UPDATED!');
END;

CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('CUSTOMER WAS DELETED');
END;

/*7.0 JOINS
In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

/*7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/

select firstname, lastname, i.invoiceid
from customer c
inner join invoice i 
on c.customerid = i.customerid

/*7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/

SELECT C.CUSTOMERID,C.FIRSTNAME,C.LASTNAME,I.INVOICEID, I.TOTAL
FROM CUSTOMER C
FULL OUTER JOIN INVOICE I
ON I.INVOICEID = C.CUSTOMERID;

/*7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/

SELECT NAME,TITLE
FROM ARTIST
RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

/*7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/


select * from album
cross join artist
order by artist.name




/*7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/

SELECT A.FIRSTNAME,A.LASTNAME,' ', B.FIRSTNAME,B.LASTNAME, A.REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.EMPLOYEEID <> B.EMPLOYEEID
AND A.REPORTSTO = B.REPORTSTO 
ORDER BY A.REPORTSTO;

/*

9.0 Administration
In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
Task – Create a .bak file for the Chinook database.

*/



    