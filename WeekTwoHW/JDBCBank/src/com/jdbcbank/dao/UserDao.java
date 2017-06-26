package com.jdbcbank.dao;
 
import java.util.List;
import com.jdbcbank.domain.*;

public interface UserDao {
	public List<User> getUsers();
	public void createUser(User u);
	public void updateUser(User u);
	public void deleteUser(User u);
	public boolean loginUser(User u); 
}

