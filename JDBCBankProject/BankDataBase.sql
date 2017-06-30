--TABLE FOR USERS
CREATE TABLE BANK_USERS (
    USER_NAME VARCHAR2(100) PRIMARY KEY,
    USER_PASSWORD VARCHAR2(100)
);

--TABLE FOR ADMINS
CREATE TABLE ADMINS (
    USER_NAME VARCHAR2(100) PRIMARY KEY,
    USER_PASSWORD VARCHAR2(100)
);

--TABLES FOR ACCOUNTS
CREATE TABLE ACCOUNTS(
    ACCOUNT_ID INTEGER PRIMARY KEY,
    USER_ID INTEGER,
    AMOUNT NUMBER DEFAULT 0
);

CREATE SEQUENCE SQ_ACCOUNTS_PK
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_ACCOUNT_ID
    BEFORE INSERT ON ACCOUNTS
    FOR EACH ROW
    BEGIN
        :NEW.ACCOUNT_ID := SQ_ACCOUNTS_PK.NEXTVAL;
    END;

--DEPOSIT AND WITHDRAW PROCEDURES
CREATE OR REPLACE PROCEDURE WITHDRAW_FROM_ACCOUNTS(A_ID IN INTEGER,AMT IN NUMBER)
    IS
    BEGIN
        UPDATE ACCOUNTS SET AMOUNT = AMOUNT - AMT WHERE ACCOUNT_ID = A_ID;
    END;
    
CREATE OR REPLACE PROCEDURE DEPOSIT_TO_ACCOUNTS(A_ID IN INTEGER,AMT IN NUMBER)
    IS
    BEGIN
        UPDATE ACCOUNTS SET AMOUNT = AMOUNT + AMT WHERE ACCOUNT_ID = A_ID;
    END;
    
COMMIT;