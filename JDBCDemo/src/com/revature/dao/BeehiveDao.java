package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface BeehiveDao {
	
	public List<Beehive> getBeehives();
	public Beehive getBeehiveById(int id);
	boolean updateBeehiveWeight(int id, int diff);

}
