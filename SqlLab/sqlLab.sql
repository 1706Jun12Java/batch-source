/* QUESTION 2 */

-- 2.1
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO is NULL;


-- 2.2
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;


--2.3
--  insert for genre

INSERT INTO GENRE (GENREID, NAME) VALUES(100, 'GENRE100');
INSERT INTO GENRE (GENREID, NAME) VALUES(120, 'GENRE120');


-- insert for employee
INSERT INTO EMPLOYEE 
(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX,EMAIL) 
VALUES
(28, 'DC', 'MILK', 'CEO', 1, '01-APR-02', '01-MAY-02', '825 8 Ave SW', 'Calgary', 'NY','US','T2P 2T3','+1 (403) 262-3443','+1 (403) 262-3322', 'nancy@chinookcorp.com');

INSERT INTO EMPLOYEE 
(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX,EMAIL) 
VALUES
(30, 'CD', 'JAY', 'GARBAGE COLLECTOR', 1, '01-APR-03', '25-MAY-02', '825 8 Ave SW', 'Calgary', 'NY','US','T2P 2T3','+1 (403) 262-3443','+1 (403) 262-3322', 'nancymilk@chinookcorp.com');


-- insert for customer
    
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES
(100, 'JACKIE', 'CHEN', 'REVATURE', '1234 7AVE', 'NY', 'NY', 'US', '100031', '+1 (514) 721-4711', '','hholy@gmail.com','2');

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES
(101, 'BRUCE', 'LEE', 'REVATURE', '1234 7AVE', 'NY', 'NY', 'US', '100031', '+1 (514) 721-4711', '','hholy@gmail.com','2');


--2.4
UPDATE CUSTOMER SET FIRSTNAME='Robert',LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';


--2.5
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';


--2.6
SELECT * FROM INVOICE WHERE TOTAL>= 15 AND TOTAL<=50;
SELECT * FROM EMPLOYEE WHERE HIREDATE>='01-JUNE-03' AND HIREDATE<='01-MAR-04';


--2.7

DELETE FROM INVOICELINE WHERE INVOICEID=(SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter'));
DELETE FROM INVOICE WHERE CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter');
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';



-- 2.8






