package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;

public interface UsersDao {

	public List<Users> getUsers();

	public Users getUsersById(int id);

	public void createUsers(String un, String pw, String fn, String ln, String email);

	public void createManager(String un, String pw, String fn, String ln, String email);

	public void deleteUsersById(int id);

	public boolean login(String username, String pass);
}
