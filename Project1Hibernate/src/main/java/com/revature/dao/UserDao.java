package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface UserDao {
	public List<User> getUsers();
	public User getUserById(int id);
	public int saveUser(User b);
}
