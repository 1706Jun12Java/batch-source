package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;

public interface UsersDao {

	public List<Users> getUsers();

	public Users getUsersById(int id);

	public void createUsers(int id,String un,String pw,String fn, String ln, String email,int ur_id);

	public void deleteUsersById(int id);

	public boolean login(String username, String pass);
}
