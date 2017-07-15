package com.ers.dao;

import java.util.List;

import com.ers.domain.UserModel;

public interface UserDao {
	public UserModel getUser(int userId); //get details of a specific user
	public int login(String username, String password);
//	public void logout();
	public List<UserModel> getEmployeeList(int employeeId); //manager can view all employees
	public int updateEmail(int userId, String email); //a user can update their email
	public int updatePassword(int userId, String password); //a user can update their password
	
	//optional function:
//	public int registerEmployee(int uId, String username, String password) // a manager can register new employees
	//note: for password, add some security, try even not string but a different datatype
	//note: for this func, the pass is temporary, figure this out
	

}
