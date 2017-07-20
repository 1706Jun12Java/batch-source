package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface BatTypeDao {
	public List<BatType> getBatTypes();
	public BatType getBatTypeById(int id);
	public int saveBatType(BatType b);
	public void persistBatType(BatType b);
	public BatType updateBatType(BatType b, String newName);
	public BatType mergeBatType(BatType b,String newName);
}
