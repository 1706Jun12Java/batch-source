--CREATE TABLES
CREATE TABLE BEAR (
  BEAR_ID INTEGER PRIMARY KEY,
  BEAR_TYPE_ID INTEGER,
  BEAR_NAME VARCHAR2(100),
  BEAR_BIRTHDATE DATE,
  BEAR_WEIGHT INTEGER DEFAULT 200,
  CAVE_ID INTEGER
);

CREATE TABLE BEAR_TYPE (
  BEAR_TYPE_ID INTEGER PRIMARY KEY,
  BEAR_TYPE_NAME VARCHAR2(100)
);

CREATE TABLE CAVE (
  CAVE_ID INTEGER PRIMARY KEY,
  CAVE_NAME VARCHAR2(100),
  MAX_BEARS INTEGER DEFAULT 4
);

CREATE TABLE BEEHIVE (
  BEEHIVE_ID INTEGER PRIMARY KEY,
  BEEHIVE_WEIGHT INTEGER DEFAULT 50
);

CREATE TABLE BEAR_BEEHIVE (
  BEAR_ID INTEGER,
  BEEHIVE_ID INTEGER,
  PRIMARY KEY (BEAR_ID, BEEHIVE_ID)
);

--ADD FOREIGN KEY CONSTRAINTS
ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_BEAR_TYPE
FOREIGN KEY (BEAR_TYPE_ID) REFERENCES BEAR_TYPE(BEAR_TYPE_ID);

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_CAVE
FOREIGN KEY (CAVE_ID) REFERENCES CAVE(CAVE_ID);

ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEEHIVE_BEAR
FOREIGN KEY (BEAR_ID) REFERENCES BEAR(BEAR_ID);

ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEEHIVE_BEEHIVE
FOREIGN KEY (BEEHIVE_ID) REFERENCES BEEHIVE(BEEHIVE_ID);

--ADD A CHECK CONSTRAINT TO KEEP WEIGHTS >0
ALTER TABLE BEAR
ADD CONSTRAINT CK_BEAR_WEIGHT_POSITIVE CHECK (BEAR_WEIGHT > 0);

ALTER TABLE BEEHIVE
ADD CONSTRAINT CK_HIVE_WEIGHT_POSITIVE CHECK (BEEHIVE_WEIGHT > 0);

ALTER TABLE BEAR_TYPE
ADD CONSTRAINT UQ_TYPE_NAME UNIQUE (BEAR_TYPE_NAME);

--SOME DATA
INSERT INTO BEAR_TYPE VALUES (1,'GRIZZLY');
INSERT INTO BEAR_TYPE VALUES (2,'POLAR');
INSERT INTO BEAR_TYPE VALUES (3,'PANDA');

INSERT INTO BEAR VALUES(1,2,'PADDINGTON','27-NOV-1997',DEFAULT,NULL);

--NOTE: WE DROPPED AND RE-ADDED THIS!
ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_BEAR_TYPE
FOREIGN KEY (BEAR_TYPE_ID) REFERENCES BEAR_TYPE(BEAR_TYPE_ID)
ON DELETE SET NULL;


INSERT INTO BEAR VALUES(2,3,'PANDA1','27-NOV-1997',DEFAULT,NULL);

--SEQUENCES
CREATE SEQUENCE SQ_BEAR_PK
START WITH 1
INCREMENT BY 2;

CREATE SEQUENCE SQ_BEAR_TYPE_PK
START WITH 1
INCREMENT BY 2;

CREATE SEQUENCE SQ_CAVE_PK
START WITH 1
INCREMENT BY 2;

CREATE SEQUENCE SQ_BEEHIVE_PK
START WITH 1
INCREMENT BY 2;

--CREATE BEFORE INSERT TRIGGERS
CREATE OR REPLACE TRIGGER TR_INSERT_BEAR
BEFORE INSERT ON BEAR
FOR EACH ROW
BEGIN
  SELECT SQ_BEAR_PK.NEXTVAL INTO :NEW.BEAR_ID FROM DUAL;
  --DUAL IS A DUMMY TABLE. USE IT WHEN YOU DON'T REQUIRE A TABLE
  --BUT NEED TABLE-LIKE SYNTAX
END;

SELECT * FROM DUAL;

CREATE OR REPLACE TRIGGER TR_INSERT_BEAR_TYPE
BEFORE INSERT ON BEAR_TYPE
FOR EACH ROW
BEGIN
  SELECT SQ_BEAR_TYPE_PK.NEXTVAL INTO :NEW.BEAR_TYPE_ID FROM DUAL;
  --DUAL IS A DUMMY TABLE. USE IT WHEN YOU DON'T REQUIRE A TABLE
  --BUT NEED TABLE-LIKE SYNTAX
END;

CREATE OR REPLACE TRIGGER TR_INSERT_CAVE
BEFORE INSERT ON CAVE
FOR EACH ROW
BEGIN
  SELECT SQ_CAVE_PK.NEXTVAL INTO :NEW.CAVE_ID FROM DUAL;
  --DUAL IS A DUMMY TABLE. USE IT WHEN YOU DON'T REQUIRE A TABLE
  --BUT NEED TABLE-LIKE SYNTAX
END;

CREATE OR REPLACE TRIGGER TR_INSERT_BEEHIVE
BEFORE INSERT ON BEEHIVE
FOR EACH ROW
BEGIN
  SELECT SQ_BEEHIVE_PK.NEXTVAL INTO :NEW.BEEHIVE_ID FROM DUAL;
  --DUAL IS A DUMMY TABLE. USE IT WHEN YOU DON'T REQUIRE A TABLE
  --BUT NEED TABLE-LIKE SYNTAX
END;



-- the code above are all from HigginsE branch without any changes.
-- ADD CONSTRAINT TO LIMIT CAVE SIZE LESS THAN 5
ALTER TABLE CAVE ADD CONSTRAINT CK_CAVE_SIZE CHECK (MAX_BEARS < 5);


-- IF INSERTING BEAR WHEN CAVE SIZE IS 4 THEN ROLLBACK.
CREATE TRIGGER TR_INSERT_BEAR_CHECK BEFORE INSERT ON BEAR
FOR EACH ROW
DECLARE
CAVE_SIZE NUMBER;
BEGIN
  SELECT COUNT(*) INTO CAVE_SIZE FROM BEARS WHERE CAVE_ID = :new.CAVE_ID;
  IF CAVE_SIZE = 4 THEN
  DBMS_OUTPUT.PUT_LINE("CAVE IS FULL");
  ROLLBACK;
END;
