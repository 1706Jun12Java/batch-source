/*
MAXIMUM BEAR ENFORCEMENT

By now, you all know and love the Bears database. Its creation code is on my branch (HigginsE), if you've not already built it. 
There is one major flaw, however... 
We are setting a MAX_BEARS value for each cave and not enforcing this limit. 
Your task this week is to devise a method for ensuring that all of the caves have no more bears than allowed. 

There are several methods by which this can be accomplished.
Upload as a solution the code to create whatever structures you decide to use, plus the creation statements for your tables. 

Use what you know about functions, triggers, error handling, stored procedures, etc. 
Include a description of why you chose the tools you did, and how your solutions works. Defend your choice! 
*/

/* ============= THINKING =================*/
/* 
1. First we need to keep count of how many bears are entering the cave. Therefore we should add a column to cave for bear */
ALTER TABLE CAVE
ADD BEAR_ID INT;

ALTER TABLE CAVE
ADD CONSTRAINT BEAR_BEAR_ID_FK
    FOREIGN KEY (BEAR_ID)
    REFERENCES BEAR (BEAR_ID);


/* 2. We can alter cave table to add a contraint to make sure the number of bears are less than or Equal to MAX_BEARS */
ALTER TABLE CAVE
ADD CONSTRAINT CHECK_BEAR_ID
CHECK (COUNT(BEAR_ID) < MAX_BEARS);

/*3. Now, for users who tries to insert on a full cave, a trigger should be written to respond to such thing. */
CREATE OR REPLACE TRIGGER NO_MORE_BEARS_TRIGGER
BEFORE INSERT ON CAVE
BEGIN
    /* time over */
END;

/* 4. I haven't tested this code, but these were my ideas as I was thinking about it.





