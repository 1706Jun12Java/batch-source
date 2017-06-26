CREATE OR REPLACE TRIGGER TR_INSERT_BEAR
BEFORE INSERT OR UPDATE OF CAVE_ID
ON BEAR
FOR EACH ROW
declare
currentb numbers;
BEGIN
    select count(cave_id) into currentb
    from bear
    where cave_id =  new.cave_id;
    
    IF currentb > cave.max_bears then
    raise_application_error(-20100, 'This Cave is full!');
    end if;
        SELECT SQ_BEAR_PK.NEXTVAL INTO :NEW.BEAR_ID FROM DUAL
END;