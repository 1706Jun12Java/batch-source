package com.revature.dao;

import java.util.List;

import com.revature.domain.ReType;

public interface ERTypeDao {

	public List<ReType> getReTypes();
	public ReType getReTypeById(int id);
	
}
