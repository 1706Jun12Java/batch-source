package com.revature.dao;

import java.util.List;

import com.revature.domain.Type;

public interface TypeDao {
	public List<Type> getTypes();
	public Type getTypeById(int id);
	public int saveType(Type b);
}
