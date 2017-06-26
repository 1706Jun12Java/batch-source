package com.revature.main;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		String command;
		Scanner scan = new Scanner(System.in);
		UserDaoImpl userDao = new UserDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		
		User user=null;
		while(user==null){
			System.out.println("Enter 'login' or 'register'");
			command = scan.nextLine();
			switch(command.toLowerCase()){
			case "login":
				System.out.println("Username: ");
				String username,pass;
				username=scan.nextLine();
				System.out.println("Password: ");
				pass=scan.nextLine();
				user=userDao.userLogin(username, pass);
				break;
			case "register":
				user = userDao.registerUser();
				break;
			default:
				System.out.println("entered an invalid option");
				break;
			}
			System.out.println();
		}
		//once logged in
		while(user!=null){
			System.out.println("Enter 'withdraw' or 'deposit'");
			System.out.println("For super users you can: ");
			System.out.println("'viewUsers' or 'updateUser' or 'deleteUser'");
			System.out.println("'logout' to exit");
			command = scan.nextLine();
			switch(command.toLowerCase()){
			case "withdraw":
				bankDao.withdrawFromBank(user);
				break;
			case "deposit":
				bankDao.depositToBank(user);
				break;
			case "logout":
				userDao.logout(user);
				break;
			case "viewusers":
				userDao.viewUsers(user);
				break;
			case "updateuser":
				userDao.updateUser(user);
				break;
			case "deleteuser":
				userDao.deleteUser(user);
				break;
			default:
				System.out.println("invalid input");
				break;
			}
			System.out.println();
		}
	}

}