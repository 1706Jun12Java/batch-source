package com.revature.bank.main;

import java.util.List;
import java.util.Scanner;

import com.revature.bank.dao.AccountDao;
import com.revature.bank.dao.AccountDaoImpl;
import com.revature.bank.dao.TransactionDao;
import com.revature.bank.dao.TransactionDaoImpl;
import com.revature.bank.dao.UserDao;
import com.revature.bank.dao.UserDaoImpl;
import com.revature.bank.domain.Transaction;
import com.revature.bank.domain.User;

public class Driver {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("1 to create user, 2 to login");
		String input = s.nextLine();
		
		if(input.equals("1")){
			userRegister();
		} else { 
			userLogin();
		}
		s.close();
	}
	
	public static void userActionList(){
		System.out.println("1: create account");
		System.out.println("2: deposite");
		System.out.println("3: withdraw");
		System.out.println("4: delete account");
		System.out.println("5: see transactions");
		System.out.println("q: to quit");
	}
	
	public static void superUserActionList(){
		System.out.println("1: View users");
		System.out.println("2: Create a user");
		System.out.println("3: Update a user");
		System.out.println("4: Update user bank account");
		System.out.println("5: Delete a user");
		System.out.println("q: to quit");
	}
	
	public static void userRegister(){
		
		UserDao UD = new UserDaoImpl();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter username: ");
		String newUsername = s.nextLine();
		System.out.println("Enter password");
		String newPW = s.nextLine();
		User newUser = new User(newUsername, newPW);
		try{
			UD.createUser(newUser);
			userLogin();
		}catch (Exception e){
			System.out.println(e);
		}
		s.close();
		
	}
	
	public static void userLogin(){
		UserDao UD = new UserDaoImpl();
		Scanner s = new Scanner(System.in);
		System.out.println("username: ");
		String username = s.nextLine();
		System.out.println("password: ");
		String password = s.nextLine();
		
		try{
			User user = UD.getUserByCredential(username, password);
			
			//TODO implement actions
			directUserToInterface(user, s);
		} catch(NullPointerException e){
			System.out.println("check credentials");
		} catch(Exception e){
			System.out.println(e);
		}
		s.close();
	}
	
	public static void directUserToInterface(User user, Scanner s){
		if(user.getUserType()==0){
			System.out.println("Welcome user "+user.getUserID());
			userCase(user, s);
		} else if (user.getUserType()==1){
			System.out.println("Welcome super user "+user.getUserID());
			superUserCase(user, s);
		}
	}
	
	public static void userCase(User user, Scanner s){
		String input;
		int result;
		double amt;
		int acNum;
		int res;
		AccountDao AD = new AccountDaoImpl();
		userActionList();
		while(!(input = s.nextLine()).equals("q") ){
			switch(input){
			case "1":
				try{
					AD.createAccount(user.getUserID());
					System.out.println("Bank account created");
					System.out.println();
					break;
				} catch (Exception e){
					System.out.println("unable to create account");
				}
				break;
				
			case "2":		
				System.out.println(AD.getAccountByUserId(user.getUserID()).toString());
				System.out.println("Pick an account id to deposit");
				acNum = Integer.parseInt(s.nextLine());
				System.out.println("amount? ");
				amt = Double.parseDouble(s.nextLine());
				if(amt<0.0){
					System.out.println("unsupported amount");
					break;
				}
				res = AD.deposite(acNum, amt);
				if(res==1){
					System.out.println("Done");
				}else{
					System.out.println("unable to deposite");
				}
				System.out.println();
				break;
				
			case "3":
				System.out.println(AD.getAccountByUserId(user.getUserID()).toString());
				System.out.println("Pick an account id to withdraw from");
				acNum = Integer.parseInt(s.nextLine());
				System.out.println("amount? ");
				amt = Double.parseDouble(s.nextLine());
				if(amt<0.0){
					System.out.println("unsupported amount");
					break;
				}
				res = AD.withdraw(acNum, amt);
				if(res==1){
					System.out.println("get your money!");
				} else{
					System.out.println("not enough money");
				}
				
				System.out.println();
				break;
				
			case "4":
				System.out.println(AD.getAccountByUserId(user.getUserID()).toString());
				System.out.println("Pick an account id to delete");
				acNum = Integer.parseInt(s.nextLine());
				result = AD.deleteAccount(user.getUserID(), acNum);
				if(result==1){
					System.out.println("Done!!!");
				}else{
					System.out.println("you still have money in account "+ acNum);
				}
				System.out.println();
				break;
				
			case "5":
				System.out.println(AD.getAccountByUserId(user.getUserID()).toString());
				System.out.println("Pick an account id to see transactions");
				acNum = Integer.parseInt(s.nextLine());
				TransactionDao TD = new TransactionDaoImpl(); 
				List<Transaction> trList = TD.getTransactions(acNum);
				System.out.println(trList.toString());
				System.out.println();
				break;
			default:
				System.out.println("unknown input");
			}
			userActionList();
		}
		System.out.println("Thanks for Using XYZZZZ Bank");
	}
	
	public static void superUserCase(User user, Scanner s){
		String input;
		superUserActionList();
		while(!(input = s.nextLine()).equals("q") ){
			switch(input){
			case "1":
				break;
				
			case "2":
				break;
				
			case "3":
				break;
				
			case "4":
				break;
			case "5":
				
				break;
			default:
				System.out.println("unknown input");
			}
			superUserActionList();
		}
		System.out.println("Done");
	}
}
