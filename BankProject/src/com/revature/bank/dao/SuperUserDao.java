package com.revature.bank.dao;

import java.util.List;

import com.revature.bank.domain.User;

public interface SuperUserDao extends UserDao{

	public List<User> getUsers();
	public User getUserById(int id);
	public int deleteUser(int id);
	public int updateUser(User user);
}
