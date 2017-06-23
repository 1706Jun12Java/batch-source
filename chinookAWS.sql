/*****************************************************************************
   Select all records from the Employee table.
******************************************************************************/
SELECT * FROM EMPLOYEE;

/*****************************************************************************
   Select all records from the Employee table where last name is King.
******************************************************************************/
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

/*****************************************************************************
Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
******************************************************************************/
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

/*****************************************************************************
   Select all albums in Album table and sort result set in descending order by title.
******************************************************************************/
SELECT TITLE FROM ALBUM 
ORDER BY TITLE DESC;

/*****************************************************************************
   Select first name from Customer and sort result set in ascending order by city
******************************************************************************/
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

/*****************************************************************************
   Insert two new records into Genre table
******************************************************************************/
INSERT INTO GENRE VALUES(26,'Hindi');
INSERT INTO GENRE VALUES(27,'Nepali');

/*****************************************************************************
   Insert two new records into Employee table
******************************************************************************/
INSERT INTO EMPLOYEE (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES(9,'Alba','Jessica','Software Developer',TO_DATE('12/01/1989', 'MM/DD/YYYY'),TO_DATE('12/01/2016', 'MM/DD/YYYY'),'5836 83 STREET','Middle Village','NY','USA','11379','347-282-3349','22-867-1234','JESSY@GMAIL.COM');

INSERT INTO EMPLOYEE (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES(10,'Broner','Adrien','Business Analyst',TO_DATE('12/01/1990', 'MM/DD/YYYY'),TO_DATE('12/01/2017', 'MM/DD/YYYY'),'5836 83 STREET','Middle Village','NY','USA','11379','347-282-3349','22-867-1234','JESSY@GMAIL.COM');
/*****************************************************************************
   Insert two new records into Customer table
******************************************************************************/
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
VALUES (60, 'Ram', 'Sharma', 'MoMo Bros', '2432 74 street ', 'Jackson Height', 'NY', 'USA', '11372', '347-290-8888', '222-333-2222', 'MOMO@HMAIL.COM', 5);

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
VALUES (61, 'Lee', 'Ola', 'Amdo', '274 62street ', 'Woodside', 'NY', 'USA', '11373', '347-990-8888', '222-333-5555', 'ola@gmail.COM',6);

/*****************************************************************************
   Update Aaron Mitchell in Customer table to Robert Walter
******************************************************************************/
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;
/*****************************************************************************
   Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
******************************************************************************/
UPDATE ARTIST
SET NAME = 'CCR'
WHERE ARTISTID = 18;
/*****************************************************************************
   Task – Select all invoices with a billing address like “T%”
******************************************************************************/
SELECT * FROM INVOICE 
WHERE BILLINGADDRESS LIKE 'T%';
/*****************************************************************************
   Task – Select all invoices that have a total between 15 and 50
******************************************************************************/
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 20;

/*****************************************************************************
 Select all employees hired between 1st of June 2003 and 1st of March 2004
******************************************************************************/
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';
/*****************************************************************************
   Delete a record in Customer table where the name is Robert Walter 
   (There may be constraints that rely on this, find out how to resolve them).
******************************************************************************/
DELETE  FROM CUSTOMER
WHERE CUSTOMERID = 32;

/*****************************************************************************
   Task – Create a function that returns the current time.
******************************************************************************/
create or replace function getCurrent_Time
return TIMESTAMP is

  l_CurrentTime TIMESTAMP;

begin

  select Current_Timestamp
    into l_CurrentTime
    from dual;

  return l_CurrentTime;

end;
select getCurrent_Time() from dual;
/*****************************************************************************
   create a function that returns the length of a mediatype from the mediatype table
******************************************************************************/
create or replace function getMediaLength(MEDIA_ID IN NUMBER)
return number is mediaLength number;
BEGIN
    SELECT LENGTH(MEDIATYPE.NAME) into mediaLength from MEDIATYPE
     WHERE MEDIATYPE.MEDIATYPEID = MEDIA_ID;
     return mediaLength;
END;

select getMediaLength(5) from dual;
/*****************************************************************************
   Create a function that returns the average total of all invoices
******************************************************************************/
CREATE OR REPLACE FUNCTION getAvgTotal 
RETURN NUMBER IS avgOfInvoice NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO avgOfInvoice FROM INVOICE;
    RETURN avgOfInvoice;
END;
SELECT getAvgTotal() from INVOICE;

SELECT AVG(TOTAL) FROM INVOICE;
/*****************************************************************************
 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
******************************************************************************/
SELECT FIRSTNAME, LASTNAME,INVOICEID FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
/*****************************************************************************
   Create an outer join that joins the customer and invoice table, specifying 
   the CustomerId, firstname, lastname, invoiceId, and total.
******************************************************************************/
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, INV.INVOICEID, 
INV.TOTAL FROM CUSTOMER C
FULL OUTER JOIN INVOICE INV 
ON C.CUSTOMERID = INV.CUSTOMERID;
/*****************************************************************************
   Create a right join that joins album and artist specifying artist name and title.
******************************************************************************/
SELECT A.NAME, AB.TITLE FROM ARTIST A
RIGHT JOIN ALBUM AB
ON A.ARTISTID = AB.ARTISTID;
/*****************************************************************************
   Create a cross join that joins album and artist and sorts by artist name in ascending order.
******************************************************************************/
SELECT * FROM ARTIST CROSS JOIN ALBUM ORDER BY ARTIST.NAME ASC;
/*****************************************************************************
 Perform a self-join on the employee table, joining on the reportsto column.
******************************************************************************/
SELECT E1.FIRSTNAME|| ' ' || E1.LASTNAME || ' reports to ' || E2.FIRSTNAME || ' '
|| E2.LASTNAME
FROM EMPLOYEE E1, EMPLOYEE E2
WHERE E1.REPORTSTO = E2.EMPLOYEEID;