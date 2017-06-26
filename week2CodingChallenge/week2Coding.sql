/*
 Created a trigger that check before insert of bear table if there is enough space
 in the cave.
 The reason I did it with trigger is cause it'll let you know right away if there is
 an integrity issue and maintain Data integrity.
 */
CREATE OR REPLACE TRIGGER TR_DOES_CAVE_HAVE_SPACE BEFORE INSERT ON Bear
  DECLARE
    b INTEGER;
    c INTEGER;
  BEGIN
    SELECT count(Bear.Cave_ID) INTO b FROM NEW, Bear WHERE Bear.Cave_ID = NEW.Cave_ID;
    SELECT sum(Max_bears) INTO c FROM Cave WHERE Cave_ID = Bear.Cave_ID;
    IF (c < b) THEN
      -- raise exception
    END IF;
  END;