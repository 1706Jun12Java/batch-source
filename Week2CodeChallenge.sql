CREATE OR REPLACE TRIGGER TR_INSERT_BEAR_CAVEMAX
BEFORE INSERT ON BEAR
FOR EACH ROW
DECLARE
    CURR_ID INTEGER;
    CURR_BEARS INTEGER;
    V_MAX_BEARS INTEGER;
BEGIN
   CURR_ID:=:NEW.BEAR_ID;
    SELECT COUNT(CAVE_ID) INTO CURR_BEARS FROM BEAR WHERE BEAR.CAVE_ID=:NEW.CAVE_ID;
    SELECT MAX_BEARS INTO V_MAX_BEARS FROM CAVE WHERE CAVE.CAVE_ID=:NEW.CAVE_ID;
    IF(CURR_BEARS = V_MAX_BEARS) THEN
        :NEW.CAVE_ID := NULL;
    END IF;
END;
/*
whEN CREATING A BEAR BEFORE INSERT CHECK IF THERE IS ROOM
IF THERE IS THEN ITS FINE BUT IF THERE ISNT
I SET THE CAVE_ID OF THAT BAR INTO NULL
    i did it this way cause if a bear can't fit then it can't fit
    meaning that since it chose to go into that cave at existence time ad there no room
    it won't exist within that cave
    after it comes into existence it can just change to another location
    
*/
CREATE OR REPLACE TRIGGER TR_UPDATE_BEAR_CAVEMAX
BEFORE UPDATE ON BEAR
FOR EACH ROW
DECLARE
    CURR_ID INTEGER;
    CURR_BEARS INTEGER;
    V_MAX_BEARS INTEGER;
BEGIN
   CURR_ID:=:NEW.BEAR_ID;
    SELECT COUNT(CAVE_ID) INTO CURR_BEARS FROM BEAR WHERE BEAR.CAVE_ID=:NEW.CAVE_ID;
    SELECT MAX_BEARS INTO V_MAX_BEARS FROM CAVE WHERE CAVE.CAVE_ID=:NEW.CAVE_ID;
    IF(CURR_BEARS = V_MAX_BEARS) THEN
        :NEW.CAVE_ID := NULL;
    END IF;
END;
/*
Also made an on before update trigger since if a bear wants to go into a max cave
it can't and it shall be kicked out therefore it won't be in any cave
*/