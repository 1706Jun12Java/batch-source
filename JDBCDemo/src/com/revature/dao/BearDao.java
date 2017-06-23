package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	
	public int createBear(Bear bear);
	
	public int feedBear(int bearId, int hiveId, int amt);

}
