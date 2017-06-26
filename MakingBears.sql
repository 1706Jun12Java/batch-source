--Added a new column to cave called CURRENT_BEARS which tells us how many bears are currently in
--that cave. Additionally bears CAVEID cannot be null, meaning once a bear is 
--created it must be given a value for CAVEID. A trigger is thrown if when adding a bear the  CURRENT_BEARS
--is equal to MAXBEARS, meaning the cave is full.
CREATE OR REPLACE PROCEDURE SP_MAX_BEAR(BID IN NUMBER, BBDATE IN DATE,
BEARNAME IN VARCHAR,BEARTYPE IN NUMBER,BEARWEIGHT IN NUMBER,CAVEID IN NUMBER )
IS
BEGIN
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
  --if the current bears caveid that has currentbears number equals the max number of that
  --cave id then insert bear with cave id and increase currentbear, otherwise dont add bear.
  IF CAVEID.CURRENT_BEARS != CAVEID.MAX_BEARS THEN
  INSERT INTO BEAR VALUES(BBDATE,BID,BEARNAME,BEARTYPE,BEARWEIGHT,CAVEID);
  --CAVEID.CURRENT_BEARS += 1;
  DBMS_OUTPUT.PUT_LINE('BEAR ADDED TO CAVE');
  ELSE 
  DBMS_OUTPUT.PUT_LINE('FAILED TO ADD BEAR, THIS CAVE IS FULL PLEASE USE ANOTHER.');
  END IF;
  COMMIT;
  EXCEPTION
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('FAILED TO FEED BEAR'); 
  ROLLBACK;
END;

--CAVES TABLE MADE WITH EXTRA COULMN

  CREATE TABLE "ADMIN"."CAVE" 
   (	"CAVE_ID" NUMBER(*,0), 
	"CAVE_NAME" VARCHAR2(100 BYTE), 
	"MAX_BEARS" NUMBER(*,0) DEFAULT 4, 
	"CURRENT_BEARS" NUMBER DEFAULT 0 NOT NULL ENABLE, 
	 PRIMARY KEY ("CAVE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "UQ_CAVE_NAME" UNIQUE ("CAVE_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

  CREATE OR REPLACE EDITIONABLE TRIGGER "ADMIN"."TR_INSERT_CAVE" 
BEFORE INSERT ON CAVE
FOR EACH ROW
BEGIN
  SELECT SQ_CAVE_PK.NEXTVAL INTO :NEW.CAVE_ID FROM DUAL;
  --DUAL IS A DUMMY TABLE. USE IT WHEN YOU DON'T REQUIRE A TABLE
  --BUT NEED TABLE-LIKE SYNTAX
END;
/
ALTER TRIGGER "ADMIN"."TR_INSERT_CAVE" ENABLE;
