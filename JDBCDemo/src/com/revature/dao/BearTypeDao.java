package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface BearTypeDao {
	
	public List<BearType> getBearTypes();
	public BearType getBearTypeById(int id);

}
