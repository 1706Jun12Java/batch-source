-- CREATE A BANK_USER ACCOUNT
CREATE TABLE BANK_USER (
  USER_ID      NUMBER(10)    NOT NULL,
  F_NAME  VARCHAR2(100) NOT NULL,
  L_NAME VARCHAR2(100) NOT NULL,
  USERNAME VARCHAR2(100) NOT NULL,
  PASSWORD_ VARCHAR2(100) NOT NULL,
  IS_SUPERUSER NUMBER(1) NOT NULL -- 1 FOR TRUE 0 FOR FALSE
);

-- ADD PRIMARY KEY TO BANK_USER TABLE 
ALTER TABLE BANK_USER
  ADD (
    CONSTRAINT BANK_USER_PK PRIMARY KEY (USER_ID)
  );

-- CREATE BANK_USER_SEQUENCE
CREATE SEQUENCE BANK_USER_SEQUENCE;

-- TO INCREMENT USER_ID IN BANK_uSER 
CREATE OR REPLACE TRIGGER BANK_USER_ON_INSERT
  BEFORE INSERT ON BANK_USER
  FOR EACH ROW
BEGIN
  SELECT BANK_USER_SEQUENCE.NEXTVAL
  INTO :NEW.USER_ID
  FROM dual;
END;

-- CREATE A BANK_ACCOUNT 
CREATE TABLE BANK_ACCOUNT (
  BANK_ACCOUNT_ID      NUMBER(10)    NOT NULL,
  BALANCE FLOAT(126),
  ACCOUNT_USER_ID NUMBER(10) NOT NULL,
  CONSTRAINT BANK_ACCOUNT_PK PRIMARY KEY (BANK_ACCOUNT_ID),
  CONSTRAINT BANK_USER_FK FOREIGN KEY (ACCOUNT_USER_ID) REFERENCES BANK_USER(USER_ID)
);

-- CREATE BANK_ACCOUNT_SEQUENCE
CREATE SEQUENCE BANK_ACCOUNT_SEQUENCE;

-- TO INCREMENT BANK_ACCOUTN_ID IN BANK_ACCOUNT
CREATE OR REPLACE TRIGGER BANK_ACCOUNT_ON_INSERT
  BEFORE INSERT ON BANK_ACCOUNT
  FOR EACH ROW
BEGIN
  SELECT BANK_ACCOUNT_SEQUENCE.NEXTVAL
  INTO :NEW.BANK_ACCOUNT_ID
  FROM dual;
END;

-- THE STORED PROCEDURE THAT INCLUDES A CALLABLE STATEMENT
CREATE OR REPLACE PROCEDURE updateDBUSER(
	   p_userid IN BANK_USER.USER_ID%TYPE,
	   p_username IN BANK_USER.USERNAME%TYPE)
IS
BEGIN

UPDATE BANK_USER SET USERNAME = p_username where USER_ID = p_userid;

COMMIT;

END;



