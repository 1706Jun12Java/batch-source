package com.revature.dao;

import java.util.List;

import com.revature.domain.Bat;

public interface BatDao {
	
	public List<Bat> getBats();
	public Bat getBatById(int id);
	public int saveBat(Bat b);
	

}
