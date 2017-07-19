package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface BatTypeDao {
	public List<BatType> getBatTypes();
	public BatType getBatTypeById(int id);
	public int saveBatType(BatType b);
	
}
