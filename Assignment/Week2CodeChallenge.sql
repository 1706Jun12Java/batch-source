select count(cave_id) from bear b1 where b1.cave_id in (select b2.cave_id from bear b2);

Create a trigger before insert to check if count of cave_id of certain cave is from less than equal to
cave id from max bear