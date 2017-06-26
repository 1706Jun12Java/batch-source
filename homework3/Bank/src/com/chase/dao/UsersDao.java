package com.chase.dao;

import java.util.List;
import java.util.Scanner;

import com.chase.domain.*;

public interface UsersDao {
	
	public List<Users> getUser();
	public Users getUserById(int id);
	public void createUser(Scanner scan);
	public void deleteUser(Users user, int accountNum);
	public void withdraw(int userId,int bankAccountId,int amount);
	public void deposit(int userId,int bankAccountId,int amount);
	public void createBankAccount(double amount);
	

}
