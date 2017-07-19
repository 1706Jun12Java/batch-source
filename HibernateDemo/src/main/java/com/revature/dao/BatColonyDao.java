package com.revature.dao;

import java.util.List;

import com.revature.domain.BatColony;

public interface BatColonyDao {
	public List<BatColony> getBatColonies();
	public BatColony getBatColonyById(int id);
	public int saveBatColony(BatColony b);
	
}
