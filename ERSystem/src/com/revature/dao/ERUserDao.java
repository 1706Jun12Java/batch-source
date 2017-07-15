package com.revature.dao;

import java.util.List;
import com.revature.domain.User;
import com.revature.exceptions.WrongCredentialsException;

public interface ERUserDao {

	public List<User> getEmployees();
	public User loginUser(String username, String password) throws WrongCredentialsException;
	public User getUserById(int id) throws WrongCredentialsException;
	public int upDateUserInfo(String password, String firstName,String lastName, int userID);
	public int registerEmployee(User user);
	public int sendApproveEmail(int reimID, String fromEmail, String email);
	public int sendAccountEmail(String fromEmail, User u);
}
