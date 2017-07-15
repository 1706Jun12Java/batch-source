package com.ers.dao;

import com.ers.domain.ERS_Users;

public interface ERS_UsersDao {
	
	public int getUR_ID(String un, String pw);
		
	public ERS_Users getUserByID(String un, String pw);
	
	public int getUserID(String username, String password);

	public String getFirstName(String username, String password);

	public String getLastName(String username, String password);
	
	public String getEmail(String username, String password);
}
