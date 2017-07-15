package com.revature.dao;

import java.util.List;

import com.revature.domain.UserType;

public interface ERUserTypeDao {
	
	public List<UserType> getUserTypes();
	public UserType getUserTypeById(int id);
}
