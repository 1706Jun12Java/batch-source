-- NAME: Bishwo Gurung

-- We would like to enforce a MAX_BEARS policy on each cave. To assure that, we
-- need to make sure prior to inserting bears, check if adding it will
-- break the policy. 
-- so TABLE has BEAR table has CAVE_ID column. We shall count the number of
-- bears for each cave_id and use that total or count to check
-- CAVE_ID MAX_BEARS

CREATE OR REPLACE TRIGGER TR_INSERT_BEAR
BEFORE INSERT ON BEAR
BEGIN
    SELECT COUNT(CAVE_ID) FROM BEAR WHERE CAVE_ID = --inserted cave_id;
    -- get a count of each cave_id
    -- compare that to the max_bears column in cave table;
    -- if the cave_id that user inserted has a count(8) equal to max_bears for 
    -- that same cave_id, then cancel this insert.
    -- if we do a check, it should cancel it.
    -- in jdbc, we can use PreparedStatement to retrieve this 'CAVE_ID' that 
    -- was inserted since this interface is able to get the parameters.
END;