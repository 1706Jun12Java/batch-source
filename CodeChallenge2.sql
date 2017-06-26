
-- This Trigger will act on INSERT into Bear
-- If the inserted value will exceed the MAX_SIZE of that cave then an Exception is thrown
--I Chose this solution because this forces the USER to either add a bear to a valid cave or not specify a cave for the bear at all
-- This will act on your TABLE structure in your branch
CREATE OR REPLACE TRIGGER TR_BEAR_CAVE
BEFORE INSERT ON BEAR 
FOR EACH ROW
DECLARE
CAVE_IS_FULL EXCEPTION;
CAVE_SIZE NUMBER;
BEGIN
SELECT MAX_BEARS INTO CAVE_SIZE FROM CAVE WHERE CAVE_ID = :NEW.CAVE_ID;
IF CAVE_SIZE +1 > CAVE_SIZE
THEN RAISE CAVE_IS_FULL;
END IF;
END;