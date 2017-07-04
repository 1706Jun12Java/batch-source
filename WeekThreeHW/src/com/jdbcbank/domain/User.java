package com.jdbcbank.domain;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jdbcbank.dao.*;

public class User {

	public List<Account> getUserAccount() throws SQLException, IOException{
		AccountDao ad = new AccountDaoImpl();
		return ad.getUserAccount(this);
	}
	
	public boolean userNameExist() throws SQLException, IOException{
		UserDao ud = new UserDaoImpl(); 
		return ud.userNameExist(this);
	}
	
	
	public void addAccount() throws SQLException, IOException{
		AccountDao ad = new AccountDaoImpl();
		ad.createAccount(new Account(0, this.user_id, 0, 1));
	}
	
	
	
	public void createUserToDB() throws SQLException, IOException{
		UserDao ud = new UserDaoImpl(); 
		ud.createUser(this);
		this.user_id = ud.updateUserID(this);
	}
	
	public void deleteUserFromDB() throws SQLException, IOException{
		UserDao ud = new UserDaoImpl(); 
		ud.deleteUser(this);
	}
	
	public void updateUserToDB() throws SQLException, IOException{
		UserDao ud = new UserDaoImpl(); 
		ud.updateUser(this);
	}
	
	public boolean userLogin() throws SQLException, IOException{
		UserDao ud = new UserDaoImpl();
		int res = ud.loginUser(this);
		if (res == 0){
			return false;
		}
		this.user_id = res;
		return true;
	}
	
	public User(int user_id, String user_username, String user_password, String user_email, int user_active) {
		super();
		this.user_id = user_id;
		this.user_email = user_email;
		this.user_username = user_username;
		this.user_password = user_password;
		this.user_active = user_active;
	}
	
	public User(String user_username, String user_password, String user_email) {
		this(0, user_username, user_password, user_email, 1);
	}

	public User(String user_username, String user_password) {
		this(user_username, user_password, "");
	}
	
	public User(int user_id){
		this(user_id, "", "", "", 1);
	}

	private int user_id;
	private String user_email;
	private String user_username;
	private String user_password; 
	private int user_active;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_email=" + user_email + ", user_username=" + user_username
				+ ", user_password=" + user_password + ", user_active=" + user_active + "]";
	}

	public int getUser_active() {
		return user_active;
	}

	public void setUser_active(int user_active) {
		this.user_active = user_active;
	}
	 
}