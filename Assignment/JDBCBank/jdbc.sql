--------------------------------------------------------
--  File created - Monday-June-26-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ACCOUNT
--------------------------------------------------------

  CREATE TABLE "JDBC1234"."ACCOUNT" 
   (	"ACCOUNTID" NUMBER(*,0), 
	"BALANCE" NUMBER(*,0) DEFAULT 0, 
	"BANK_USER_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BANK_USER
--------------------------------------------------------

  CREATE TABLE "JDBC1234"."BANK_USER" 
   (	"USERID" NUMBER(*,0), 
	"USERNAME" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"SUPERUSER" NUMBER(*,0) DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence ACCOUNT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "JDBC1234"."ACCOUNT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE   ;
--------------------------------------------------------
--  DDL for Sequence BANK_USER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "JDBC1234"."BANK_USER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE   ;
REM INSERTING into JDBC1234.ACCOUNT
SET DEFINE OFF;
Insert into JDBC1234.ACCOUNT (ACCOUNTID,BALANCE,BANK_USER_ID) values (42,50,21);
Insert into JDBC1234.ACCOUNT (ACCOUNTID,BALANCE,BANK_USER_ID) values (41,0,23);
REM INSERTING into JDBC1234.BANK_USER
SET DEFINE OFF;
Insert into JDBC1234.BANK_USER (USERID,USERNAME,PASSWORD,EMAIL,SUPERUSER) values (23,'new2','new2','new2@gmail.com',0);
Insert into JDBC1234.BANK_USER (USERID,USERNAME,PASSWORD,EMAIL,SUPERUSER) values (22,'test','test','super@gmail.com',0);
Insert into JDBC1234.BANK_USER (USERID,USERNAME,PASSWORD,EMAIL,SUPERUSER) values (21,'super','super','super@gmail.com',1);
--------------------------------------------------------
--  DDL for Trigger TRIG_ACCOUNT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "JDBC1234"."TRIG_ACCOUNT" 
  BEFORE INSERT ON account
  FOR EACH ROW
BEGIN
  IF( :new.accountid IS NULL )
  THEN
    :new.accountid := Account_Seq.nextval;
  END IF;
END;


/
ALTER TRIGGER "JDBC1234"."TRIG_ACCOUNT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIG_BANK_USER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "JDBC1234"."TRIG_BANK_USER" 
  BEFORE INSERT ON bank_user
  FOR EACH ROW
BEGIN
  IF( :new.userID IS NULL )
  THEN
    :new.userid := Bank_User_Seq.nextval;
  END IF;
END;


/
ALTER TRIGGER "JDBC1234"."TRIG_BANK_USER" ENABLE;
--------------------------------------------------------
--  DDL for Function FIND_MAX_NUMBER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "JDBC1234"."FIND_MAX_NUMBER" (X IN NUMBER, Y IN NUMBER)
RETURN NUMBER
IS
Z NUMBER;
BEGIN
    IF X>Y THEN
        Z := X;
    ELSE
        Z:=Y;
    END IF;
    RETURN Z
END;


/
--------------------------------------------------------
--  Constraints for Table BANK_USER
--------------------------------------------------------

  ALTER TABLE "JDBC1234"."BANK_USER" ADD PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ACCOUNT
--------------------------------------------------------

  ALTER TABLE "JDBC1234"."ACCOUNT" ADD PRIMARY KEY ("ACCOUNTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ACCOUNT
--------------------------------------------------------

  ALTER TABLE "JDBC1234"."ACCOUNT" ADD FOREIGN KEY ("BANK_USER_ID")
	  REFERENCES "JDBC1234"."BANK_USER" ("USERID") ENABLE;
