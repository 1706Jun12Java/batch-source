package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.jdbcbank.domain.*;

public interface UserDao {
	public List<User> getUsers() throws SQLException, IOException;
	public boolean userNameExist(User u) throws SQLException, IOException;
	public void createUser(User u) throws SQLException, IOException;
	public void updateUser(User u) throws SQLException, IOException;
	public void deleteUser(User u) throws SQLException, IOException; 
	public int updateUserID(User u) throws SQLException, IOException;  
	
	//return user_id if the user is found, otherwise return 0
	public int loginUser(User u) throws SQLException, IOException;
}
