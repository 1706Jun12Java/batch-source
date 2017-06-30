package com.revature.main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.Exceptions.NotSuperUserException;
import com.revature.Exceptions.OverDraftException;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountImpl;
import com.revature.dao.TransLogDao;
import com.revature.dao.TransLogImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserImpl;
import com.revature.domain.Account;
import com.revature.domain.TransLog;
import com.revature.domain.User;

public class ActionCaller {
	static int loginAttempt = 0;
	
	private static void superSignIn(Scanner sc){
		UserDao ud = new UserImpl();
		try {
			User user = ud.superlogIn();
			loggedIn(sc,user);
		} catch (InvalidUsernameException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static User signIn(String username, String password,HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserDao ud = new UserImpl();
		User user = null;	
		try {
			user =ud.logIn(username, password);
		} catch (InvalidUsernameException e) {
			resp.sendRedirect("InvalidLogin.html");
		} catch (InvalidPasswordException e) {
			resp.sendRedirect("InvalidLogin.html");
		}
		return user;
	}
	private static void loggedIn(Scanner sc, User user){
		System.out.println("Log In Successful! Hello, " + user.getUserName());
		System.out.println("Enter 'View' to view all current accounts");
		System.out.println("Enter 'Deposit' to deposit to an account");
		System.out.println("Enter 'Withdraw' to withdraw from an account");
		System.out.println("Enter 'Create' to create a new bank account");
		System.out.println("Enter 'Delete' to close an existing bank account");
		System.out.println("Enter 'Log out' to log out.");
		System.out.println("Enter 'Super' to view the super menu");
		System.out.println("Enter 'History' to view all transactions");
		System.out.println("Enter 'Menu' to view all options again");
		String uInput = sc.nextLine();
		uInput = uInput.replace(" ", "");
		while(!uInput.equalsIgnoreCase("logout")){
			uInput = uInput.toLowerCase();
			switch(uInput){
			case "view":
			break;
			case "deposit":
			case "withdraw": System.out.println("Enter account id of the account: ");
							 String account = sc.nextLine();
							if(account.matches("[0-9]+")){
								int accountNum = Integer.parseInt(account);
								System.out.println("Enter " + uInput +" amount: " );
								 String amt = sc.nextLine();
								if(amt.matches("[0-9\\.]+")){
								 double amount = Double.parseDouble(amt);
								 
								} else{
									System.out.println("Invalid Input");
								} 
							}else{
								System.out.println("Invalid Input");
							}
							break;
			case "create": 
						   break;
			case "delete":
							break;
			case "super": try {
					superMenu(sc,user);
				} catch (NotSuperUserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						  break;
			case "menu": System.out.println("Log In Successful! Hello, " + user.getUserName());
			System.out.println("Enter 'View' to view all current accounts");
			System.out.println("Enter 'Deposit' to deposit to an account");
			System.out.println("Enter 'Withdraw' to withdraw from an account");
			System.out.println("Enter 'Create' to create a new bank account");
			System.out.println("Enter 'Delete' to close an existing bank account");
			System.out.println("Enter 'Log out' to log out.");
			System.out.println("Enter 'Super' to view the super menu");
			System.out.println("Enter 'Menu' to view all options again");
			break;
			case "history":
			break;
			default :System.out.println("Invalid Command");
			break;
			}
			System.out.println("Enter a command (Enter 'Menu' for all options):");
			uInput = sc.nextLine();
			uInput = uInput.replace(" ", "");
		}
	}
	public static List<TransLog> showHistory(User user) throws InvalidUsernameException, InvalidAccountException{
		TransLogDao tld = new TransLogImpl();
		
			List<TransLog> logs = tld.getAllTransactions(user.getUserID());
			return logs;

	}
	
	private static void superMenu(Scanner sc,User user) throws NotSuperUserException{
		if(user.isSuper()){
			System.out.println("Enter 'Show' to view all registered Users");
			System.out.println("Enter 'Create' to create a user");
			System.out.println("Enter 'Delete' to delete a user");
			System.out.println("Enter 'Update' to update a user");
			System.out.println("Enter 'q' to return to main menu");
			System.out.println("Enter 'Menu' to repeat commands");
			String uInput = sc.nextLine();
			uInput = uInput.trim();
			uInput = uInput.replace(" ", "");
			while(!uInput.equalsIgnoreCase("q")){
			uInput = uInput.toLowerCase();
			switch(uInput){
			case "show":
			break;
			case "create": 
			break;
			case "delete":
			break;
			case "update":
			break;
			case "menu": System.out.println("Enter 'Show' to view all registered Users");
			System.out.println("Enter 'Create' to create a user");
			System.out.println("Enter 'Delete' to delete a user");
			System.out.println("Enter 'Update' to update a user");
			System.out.println("Enter 'q' to return to main menu");
			System.out.println("Enter 'Menu' to repeat commands");
			break;
			default: System.out.println("Invalid command");
			break;
			}
			System.out.println("Enter a command (Enter 'Menu' for all options):");
			uInput = sc.nextLine();
			uInput = uInput.trim();
			uInput = uInput.replace(" ", "");
			}
		} else{
			throw new NotSuperUserException("User is not a super user");
		}
		System.out.println("Returning to main menu.");
	}
	public static void updateUser(String userName,String newName, String newPass, int meep) throws InvalidUsernameException, InvalidPasswordException {
		UserDao ud = new UserImpl();
		ud.updateUser(userName, newName, newPass, meep);
				
	}
	public static void deleteUser(String username) throws InvalidUsernameException {
		UserDao ud = new UserImpl();
		
		
		ud.deleteUser(username);

		
	}
	public static List<User> viewAllUsers() throws InvalidAccountException {
		UserDao ud = new UserImpl();
			List<User> users = ud.getAllUsers();
			return users;
		
	}
	public static void deleteBankAccount(User user,int id) throws InvalidAccountException{
		AccountDao ad = new AccountImpl();
		ad.deleteAccount(id, user);
	}
	public static void updateAccount(User user,String account,String amountString,String action) throws InvalidAccountException, OverDraftException{
		AccountDao ad = new AccountImpl();
		if(account.matches("[0-9]+")){
			int accountNum = Integer.parseInt(account);
			if(amountString.matches("[0-9\\.]+")){
			 double amount = Double.parseDouble(amountString);
			 switch(action){
				case "deposit": 
						ad.updateAccount(accountNum, amount, user);
						System.out.println("Deposit successful!");
					break;
				case "withdraw":
						ad.updateAccount(accountNum, -amount, user);
						System.out.println("Withdraw successful!");
					break;
				}
			} else{
				throw new InvalidAccountException("Invalid Amount");
			} 
		}else {
			throw new InvalidAccountException("Account ID incorrect");
		}
		
	}
	public static List<Account> showAccounts(User user) throws InvalidUsernameException, InvalidAccountException{
		AccountDao ad = new AccountImpl();
			return ad.getAllAccountsByUser(user);
			
	}
	
	public static void createAccount(String userName,String password) throws InvalidUsernameException, InvalidPasswordException{
		//USER ACCOUNT
		UserDao ud = new UserImpl();
		ud.createUser(userName, password);
	

	}
	
	public static void createAccount(User user,int amount){
	 //BANK ACCOUNT
		AccountDao ad = new AccountImpl();
		 ad.createAccount(amount, user);
		}
	}


