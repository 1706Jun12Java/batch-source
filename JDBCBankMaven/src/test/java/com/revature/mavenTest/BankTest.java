package com.revature.mavenTest;

import com.revature.domain.*;
import com.revature.dao.*;
import com.revature.util.*;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class BankTest {
	
	@Test
	public void testLogin(){
		System.out.println("Login");
		UserDaoImpl userDao = new UserDaoImpl();
		User user= userDao.userLogin("username", "password");
		assertEquals(user.getUsername(),"username");
	}
	
	@Test
	public void testRegister(){
		System.out.println("Registering");
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.registerUser();
		user.toString();
	}
	
	@Test
	public void testWithdraw(){
		System.out.println("Withdrawal");
		UserDaoImpl userDao = new UserDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		User user= userDao.userLogin("username", "password");
		bankDao.withdrawFromBank(user);
	}
	
	@Test
	public void testDeposit(){
		System.out.println("Deposit");
		UserDaoImpl userDao = new UserDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		User user= userDao.userLogin("username", "password");
		assertEquals(user.getUsername(),"username");
		bankDao.depositToBank(user);
	}
	
	@Test
	public void testViewUsers(){
		System.out.println("View Users");
		UserDaoImpl userDao = new UserDaoImpl();
		User user= userDao.userLogin("username", "password");
		userDao.viewUsers(user);
	}
	@Test
	public void testDelete(){
		System.out.println("delete user");
		UserDaoImpl userDao = new UserDaoImpl();
		User user= userDao.userLogin("username", "password");
		System.out.println();
		System.out.println("Before Delete");
		userDao.viewUsers(user);
		userDao.deleteUser(user);
		System.out.println();
		System.out.println("After Delete");
		userDao.viewUsers(user);
	}
	public void testCreate(){
		System.out.println("create user");
		UserDaoImpl userDao = new UserDaoImpl();
		User user= userDao.userLogin("username", "password");
		System.out.println();
		System.out.println("Before create");
		userDao.viewUsers(user);
		userDao.deleteUser(user);
		System.out.println();
		System.out.println("After create");
		userDao.viewUsers(user);
	}
}
