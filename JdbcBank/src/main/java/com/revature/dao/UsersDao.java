package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;

public interface UsersDao {

	public List<Users> getUsers();

	public Users getUsersById(int id);

	public void createUsers(String fn,String ln, String password, String email);
}
