package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

	public interface UserDao {
		public List<User> getUsers();
		public User getUserById(int id);
		public User userLogin(String username, String pass);
		public List<User> getAllEmployees();
		public boolean updateUser(User user,String fname, String lname, String email);
		public void logout(User user);
		public boolean isManager(User manager);
		public boolean registerEmp(User newuser);
		public String getUserRole(User user);
}
