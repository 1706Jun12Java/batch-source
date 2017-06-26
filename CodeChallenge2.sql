/* MAXIMUM BEAR ENFORCEMENT

By now, you all know and love the Bears database. Its creation code is on my branch (HigginsE), if you've not already built it. 
There is one major flaw, however... 
We are setting a MAX_BEARS value for each cave and not enforcing this limit. 
Your task this week is to devise a method for ensuring that all of the caves have no more bears than allowed. 

There are several methods by which this can be accomplished.
Upload as a solution the code to create whatever structures you decide to use, plus the creation statements for your tables. 

Use what you know about functions, triggers, error handling, stored procedures, etc. 
Include a description of why you chose the tools you did, and how your solutions works. Defend your choice! */

-- One way to enforce the MAX_BEARS function would be to create a trigger that would enforce the constraint 
-- BEFORE the user can insert a new bear into the cave. This method would prevent the user from being able to 
-- add a bear when the maximum bear number for a cave is reached. 
CREATE OR REPLACE TRIGGER CHECK_FOR_ROOM 
    BEFORE INSERT OR UPDATE ON CAVE 
    FOR EACH ROW 
    
    DECLARE
    MaximumBearsInCave Int;
    
BEGIN 
    MaximumBearsInCave := 10; -- setting the maximum number of bears in a cave to 10
    IF (:NEW.MAXIMUM_BEARS > 10) THEN
        raise_application_error( -20001, 'INSERTION NOT ALLOWED');
    END IF; 
END;

-- I used your code for creating the table for Cave and the rest of the Bear Database