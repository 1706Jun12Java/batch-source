package com.revature.main;

import java.util.List;
import java.util.Scanner;

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

public class Main {
	static int loginAttempt = 0;
	public static void  main(String[] args) {
		try{
			System.out.println("Welcome to the 'We Make It Rain' Bank");
			System.out.println("Enter 1 to sign in if you have an account, enter 2 to create a new account, otherwise enter q to exit:");
			Scanner sc = new Scanner(System.in);
			String uInput = sc.nextLine();
			while(!uInput.equalsIgnoreCase("q")){
			if(uInput.matches("[0-9]+")){
				int option = Integer.parseInt(uInput);
				switch(option){
				case 1: signIn(sc);
					break;
				case 2: createAccount(sc);
				break;
				case 55: superSignIn(sc);
				break;
				default: System.out.println("Invalid Command");
				break;
				}
			}else{
				System.out.println("Invalid Command");
			}
			System.out.println("Enter 1 to sign in if you have an account, enter 2 to create a new account, otherwise enter q to exit:");
			uInput = sc.nextLine();
			}
			System.out.println("Thanks for using 'We Make It Rain Bank' may you always be ballin' in the club");
			sc.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
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
	private static void signIn(Scanner sc){
		UserDao ud = new UserImpl();
		System.out.println("Enter User Name:");
		String userName = sc.nextLine();
		System.out.println("Enter Password");
		String password = sc.nextLine();
		try {
			User user =ud.logIn(userName, password);
			if(user != null){
				loggedIn(sc,user);
			}
		} catch (InvalidUsernameException e) {
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			loginAttempt++;
			e.printStackTrace();
		}
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
			case "view": showAccounts(user);
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
								 updateAccount(accountNum,user,uInput,amount);  
								} else{
									System.out.println("Invalid Input");
								} 
							}else{
								System.out.println("Invalid Input");
							}
							break;
			case "create": createAccount(sc,user);
						   break;
			case "delete":deleteBankAccount(sc,user);
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
			case "history": showHistory(user);
			break;
			default :System.out.println("Invalid Command");
			break;
			}
			System.out.println("Enter a command (Enter 'Menu' for all options):");
			uInput = sc.nextLine();
			uInput = uInput.replace(" ", "");
		}
	}
	private static void showHistory(User user){
		TransLogDao tld = new TransLogImpl();
		try {
			List<TransLog> logs = tld.getAllTransactions(user.getUserID());
			for(TransLog log: logs){
				System.out.println(log);
			}
		} catch (InvalidUsernameException | InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			case "show": viewAllUsers();
			break;
			case "create": createAccount(sc);
			break;
			case "delete": deleteUser(sc);
			break;
			case "update": updateUser(sc);
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
	private static void updateUser(Scanner sc) {
		UserDao ud = new UserImpl();
		System.out.println("Enter username of User you wish to update: ");
		String userName = sc.nextLine();
		System.out.println("Enter a username (32 character limit):");
		String newName = sc.nextLine();
		System.out.println("Enter a password (32 character limit and case sensitive):");
		String newPass = sc.nextLine();
		System.out.println("Set user to have super authority? Enter Y or N");
		String ans = sc.nextLine();
		if(ans.equalsIgnoreCase("y")){
			try {
				if(ud.updateUser(userName, newName, newPass, 1)){
					System.out.println("Update Success!");
				} else{
					System.out.println("Update failed.");
				}
			} catch (InvalidUsernameException | InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				if(ud.updateUser(userName, newName, newPass, 0)){	
					System.out.println("Update Success!");
				} else{
					System.out.println("Update failed.");
				}
			} catch (InvalidUsernameException | InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
	private static void deleteUser(Scanner sc) {
		UserDao ud = new UserImpl();
		System.out.println("Enter username of the account you wish to delete");
		String uInput = sc.nextLine();
		
		try {
			if(ud.deleteUser(uInput)){
				System.out.println("User Successfully deleted!");
			} else{
				System.out.println("Deletion failed");
			}
		} catch (InvalidUsernameException e) {
			e.printStackTrace();
		}
		
	}
	private static void viewAllUsers() {
		UserDao ud = new UserImpl();
		try {
			List<User> users =ud.getAllUsers();
			for(User user:users){
				System.out.println(user);
			}
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void deleteBankAccount(Scanner sc, User user){
		AccountDao ad = new AccountImpl();
		System.out.println("Enter Account ID you wish to delete, otherwise enter any non-numeric key to exit");
		String amt = sc.nextLine();
		if(amt.matches("[0-9]+")){
		 int amount = Integer.parseInt(amt);
		 try {
			if(ad.deleteAccount(amount, user)){
				 System.out.println("Bank account deleted!");
			 }else {
				 System.out.println("Bank account not deleted.");
			 }
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		System.out.println("Returning to menu");
	}
	}
	private static void updateAccount(int accountNum,User user,String action,double amount){
		AccountDao ad = new AccountImpl();
		switch(action){
		case "deposit": 
			try {
				ad.updateAccount(accountNum, amount, user);
				System.out.println("Deposit successful!");
			} catch (InvalidAccountException | OverDraftException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "withdraw":
			try {
				ad.updateAccount(accountNum, -amount, user);
				System.out.println("Withdraw successful!");
			} catch (InvalidAccountException | OverDraftException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	private static void showAccounts(User user){
		AccountDao ad = new AccountImpl();
		try {
			List<Account> accounts = ad.getAllAccountsByUser(user);
			for(Account account:accounts){
				System.out.println(account);
			}
		} catch (InvalidUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createAccount(Scanner sc){
		//USER ACCOUNT
		UserDao ud = new UserImpl();
		System.out.println("Enter a username (32 character limit):");
		String userName = sc.nextLine();
		System.out.println("Enter a password (32 character limit and case sensitive):");
		String password = sc.nextLine();
		try {
			if(ud.createUser(userName, password)){
				System.out.println("Account Created!");
			} else{
				System.out.println("Account not created.");
			}
		} catch (InvalidUsernameException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createAccount(Scanner sc,User user){
	 //BANK ACCOUNT
		AccountDao ad = new AccountImpl();
		System.out.println("Account Type: Enter 1 for CHECKING, Enter 2 for SAVINGS");
		String amt = sc.nextLine();
		if(amt.matches("[0-9]+")){
		 int amount = Integer.parseInt(amt);
		 if(ad.createAccount(amount, user)){
			 System.out.println("Bank account created!");
		 }else {
			 System.out.println("Bank account not created.");
		 }
		}
	}

}
