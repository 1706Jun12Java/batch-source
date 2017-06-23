/* 2.1 SELECT
Task – Select all records from the Employee table*/
SELECT * FROM EMPLOYEE;

/*Select all records from the Employee table where last name is King*/
SELECT * FROM EMPLOYEE WHERE lastname = 'King';

/*Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL*/
SELECT * FROM EMPLOYEE WHERE firstname = 'Andrew' AND reportsto IS NULL;

/*2.2 ORDER BY
Select all albums in Album table and sort result set in descending order by title*/
SELECT * FROM ALBUM ORDER BY TITLE;

/*Select first name from Customer and sort result set in ascending order by city*/
SELECT FIRSTNAME, CITY FROM customer ORDER BY CITY ASC;

/*2.3 INSERT INTO
Task – Insert two new records into Genre table*/
INSERT INTO GENRE VALUES (27, 'House');
INSERT INTO GENRE (GENREID, NAME) VALUES (28, 'Techno');

/*Insert two new records into Employee table*/
select * from employee;
INSERT INTO EMPLOYEE VALUES (9,'Love','Mark','Project Manager',1,'18-FEB-88','24-AUG-02',
'42513 66 st','Brooklyn','NY','USA','11206','+1 (917) 333-4444','+1 (917) 333-4444','mailme@email.com');
INSERT INTO EMPLOYEE VALUES (10,'Love','Kelly','Project Manager',1,'03-NOV-93','11-APR-02',
'42513 66 st','Brooklyn','NY','USA','11206','+1 (917) 333-4445','+1 (917) 333-4445','mailmetoo@email.com');

/*2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”*/
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

/*2.5 LIKE
Task – Select all invoices with a billing address like “T%” */
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004*/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

/*2.7 DELETE
Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).*/
DELETE FROM INVOICE WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME ='Robert'
  AND LASTNAME = 'Walter');
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME ='Kara'
  AND LASTNAME = 'Nielsen';

/*3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table*/
CREATE OR REPLACE FUNCTION getDateTime
RETURN timestamp IS 
  curDateTime timestamp;
BEGIN
  SELECT LOCALTIMESTAMP
    INTO curDateTime
    FROM DUAL;
  RETURN curDateTime;
END;
SELECT getDateTime() from dual;
--
CREATE OR REPLACE FUNCTION MEDIA_LENGTH (X IN NUMBER)
RETURN NUMBER IS Z NUMBER;
BEGIN
  SELECT LENGTH(NAME) INTO Z
  FROM MEDIATYPE
  WHERE X = MEDIATYPEID;
  RETURN Z;
END;
SELECT MEDIA_LENGTH(3) FROM DUAL;

SELECT LENGTH(NAME) FROM MEDIATYPE WHERE MEDIATYPEID =3;

/*3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track*/
CREATE OR REPLACE FUNCTION AVERAGE_TOTAL
RETURN NUMBER IS Z NUMBER;
BEGIN
  SELECT AVG(AVG(TOTAL)) INTO Z
  FROM INVOICE
  GROUP BY TOTAL;
  RETURN Z;
END;
SELECT TO_CHAR(AVERAGE_TOTAL(),'FM99999.00')AS TOTAL_AVG FROM DUAL;
--
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER IS Z NUMBER;
BEGIN
  SELECT MAX(MAX(UNITPRICE))INTO Z
  FROM TRACK
  GROUP BY UNITPRICE;
  RETURN Z;
END;
SELECT MOST_EXPENSIVE_TRACK() FROM DUAL;

/*3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table*/
SELECT INVOICEID, AVG(UNITPRICE)
FROM INVOICELINE
GROUP BY INVOICEID;

CREATE OR REPLACE FUNCTION INVOICE_AVG_PRICE
RETURN sys_refcursor
AS i_ap sys_refcursor;
BEGIN
OPEN i_ap
  FOR SELECT INVOICEID, AVG(UNITPRICE)
  FROM INVOICELINE
  GROUP BY INVOICEID;
  RETURN i_ap;
END INVOICE_AVG_PRICE;
SELECT INVOICE_AVG_PRICE() FROM DUAL;

/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.*/
CREATE OR REPLACE FUNCTION EMP_AFTER_1968
RETURN sys_refcursor
AS E_A1968 sys_refcursor;
BEGIN
OPEN E_A1968
  FOR SELECT * FROM EMPLOYEE
  WHERE EXTRACT(YEAR FROM BIRTHDATE) > 1968;
  RETURN E_A1968;
END;
SELECT EMP_AFTER_1968() FROM DUAL;

/*4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.*/
CREATE OR REPLACE PROCEDURE EMP_NAMES (PRC OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN PRC FOR SELECT FIRSTNAME, LASTNAME from EMPLOYEE;
END;
/
VAR RC REFCURSOR;
EXECUTE EMP_NAMES(:RC)
PRINT RC;

/*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.*/
CREATE OR REPLACE PROCEDURE update_emp (employeeid NUMBER, emp_title VARCHAR)
IS
   BEGIN
      UPDATE employee
      SET title = update_emp.emp_title
      WHERE employee.employeeid = update_emp.employeeid;
   END;
/
EXECUTE update_emp (3,'Project Manager');
-- CHECK THE UPDATE
SELECT FIRSTNAME, TITLE
FROM EMPLOYEE WHERE EMPLOYEEID = 3;
-- 
CREATE OR REPLACE PROCEDURE emp_manager(
	   p_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
	   o_firstname OUT EMPLOYEE.FIRSTNAME%TYPE,
	   o_lastname OUT  EMPLOYEE.LASTNAME%TYPE,
	   o_manager OUT EMPLOYEE.FIRSTNAME%TYPE)
IS
BEGIN
  SELECT E1.FIRSTNAME, E1.LASTNAME, E2.FIRSTNAME
  INTO o_firstname, o_lastname,  o_manager
  FROM EMPLOYEE E1 
    LEFT JOIN EMPLOYEE E2 ON E1.REPORTSTO = E2.EMPLOYEEID
    WHERE E1.EMPLOYEEID = p_EMPLOYEEID;
END;
/
DECLARE
  o_firstname OUT EMPLOYEE.FIRSTNAME%TYPE,
  o_lastname OUT  EMPLOYEE.LASTNAME%TYPE,
  o_manager OUT EMPLOYEE.FIRSTNAME%TYPE;
BEGIN
   emp_manager(3,o_firstname,o_lastname,o_manager);
   DBMS_OUTPUT.PUT_LINE('Employee first name:  ' || o_firstname);
   DBMS_OUTPUT.PUT_LINE('Employee last name:  ' || o_lastname);
   DBMS_OUTPUT.PUT_LINE('Manager first name:  ' || o_manager);
END;
/

/*4.3 Stored Procedure Output Parameters	
Create a stored procedure that returns the name and company of a customer.
*/
set serveroutput on;
CREATE OR REPLACE PROCEDURE customer_company(customer_id IN NUMBER, customer_fname OUT VARCHAR2, 
  customer_lname OUT VARCHAR2, customer_company OUT VARCHAR2)
AS BEGIN
  SELECT firstname, lastname, company INTO customer_fname, customer_lname, customer_company 
  FROM customer
  WHERE customerid = customer_id;
END;
/
SET SERVEROUTPUT ON;
DECLARE
cust_fname VARCHAR2(100);
cust_lname VARCHAR2(100);
cust_company VARCHAR(100);
BEGIN
customer_company(10, cust_fname, cust_lname, cust_company);
dbms_output.put_line('Customer name: '||cust_fname ||' '|| cust_lname ||'. Company: '|| cust_company);
END;
/

/*5.0 Transactions
Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/
CREATE OR REPLACE PROCEDURE delete_invoice(p_invoiceid IN NUMBER)
IS
BEGIN
SAVEPOINT S2;
  DELETE FROM INVOICELINE WHERE INVOICEID = p_invoiceid; --to remove the child record constraint
  DELETE FROM INVOICE WHERE INVOICEID = p_invoiceid;
  DBMS_OUTPUT.PUT_LINE('Invoice number: '||p_invoiceid||' was deleted.');
  COMMIT;
  EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('Failed to remove invoice.');
    ROLLBACK TO S2;
END;
/
SET SERVEROUTPUT ON;
BEGIN
  delete_invoice(1);
END;
--
CREATE OR REPLACE PROCEDURE insert_customer(
	   p_customerid IN CUSTOMER.CUSTOMERID%TYPE,
	   p_firstname IN CUSTOMER.FIRSTNAME%TYPE,
	   p_lastname IN CUSTOMER.LASTNAME%TYPE,
	   p_email IN CUSTOMER.EMAIL%TYPE)
IS
BEGIN
SAVEPOINT S;
  INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
  VALUES (p_customerid, p_firstname, p_lastname,p_email);
  COMMIT;
  EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('Failed to add customer.');
    ROLLBACK TO S;
END;
/
SET SERVEROUTPUT ON;
BEGIN
   insert_customer(65,'Jack','Azz', 'jackazz@gmail.com');
END;
-- CHECK IF INSERT HAPPENED
SELECT * FROM CUSTOMER WHERE CUSTOMERID = 65;

/* 6 Trigger
Create an after update trigger on the album table that fires after a row is inserted in the table
Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/
CREATE OR REPLACE TRIGGER tr_album_after_insert
AFTER INSERT
   ON ALBUM
   FOR EACH ROW
BEGIN
   INSERT INTO ALBUM (ALBUMID, TITLE, ARTISTID)
   VALUES ( :new.albumid, :new.title, :new.artistid);
END;
--
CREATE OR REPLACE TRIGGER tr_customer_after_delete
AFTER DELETE
   ON CUSTOMER
   FOR EACH ROW
DECLARE
  v_username varchar2(10);
BEGIN
-- Find username performing the DELETE on the table
SELECT user INTO v_username FROM dual;
   -- Insert record into audit table
  INSERT INTO customer_audit (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,
          ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
  VALUES (:OLD.CUSTOMERID,:OLD.FIRSTNAME,:OLD.LASTNAME,:OLD.COMPANY,
          :OLD.ADDRESS,:OLD.CITY,:OLD.STATE,:OLD.COUNTRY,:OLD.POSTALCODE,
          :OLD.PHONE,:OLD.FAX,:OLD.EMAIL,:OLD.SUPPORTREPID,sysdate, v_username);
END;

/*7.1 INNER
Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.*/
SELECT C.FIRSTNAME, C.LASTNAME, O.INVOICEID
FROM CUSTOMER C INNER JOIN INVOICE O
  ON C.CUSTOMERID = O.CUSTOMERID;
  
/*7.2 OUTER
Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, 
invoiceId, and total.*/
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, O.INVOICEID, SUM(O.TOTAL)
FROM CUSTOMER C LEFT JOIN INVOICE O
  ON C.CUSTOMERID = O.CUSTOMERID
GROUP BY C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, O.INVOICEID;

/*7.3 RIGHT
Create a right join that joins album and artist specifying artist name and title.*/
SELECT AR.NAME, AL.TITLE
FROM ARTIST AR RIGHT JOIN ALBUM AL
  ON AR.ARTISTID=AL.ARTISTID;
  
/*7.4 CROSS
Create a cross join that joins album and artist and sorts by artist name in ascending order.*/
SELECT *
FROM ALBUM CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;

/*7.5 SELF
Perform a self-join on the employee table, joining on the reportsto column.*/
SELECT E1.FIRSTNAME, E1.LASTNAME, E2.FIRSTNAME AS MGR_FNAME, E2.LASTNAME AS MGR_LNAME
FROM EMPLOYEE E1, EMPLOYEE E2 
WHERE E1.REPORTSTO = E2.EMPLOYEEID;
