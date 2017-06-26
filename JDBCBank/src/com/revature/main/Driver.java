package com.revature.main;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.BankAccountInfoDao;
import com.revature.dao.BankAccountInfoDaoImpl;
import com.revature.dao.BankLoginInfoDao;
import com.revature.dao.BankLoginInfoDaoImpl;
import com.revature.domain.BankAccountInfo;
import com.revature.domain.BankLoginInfo;
import com.revature.util.ConnectionUtil;

public class Driver {
	public static void main(String[] args){
		boolean programOn = true;

		Scanner scanner = new Scanner(System.in);
		while (programOn) {
			System.out.println("Welcome to Bishwo Bank!");
			System.out.println("What would you like to do today?");
			System.out.println("Please enter the number for the desired operation");
			
			System.out.println("1. Login");
			System.out.println("2. Create an account");
			System.out.println("3. Exit");
			String sc = scanner.next();

			if (sc.equals("1")){
				BankAccountInfoDao baid = new BankAccountInfoDaoImpl();
//				int userId = blid.login(inputUsername, inputPassword);


				
				System.out.println("Hi, welcome to the login page.");
				System.out.println("Please enter your username: ");
				scanner.nextLine();
				String inputUsername = scanner.nextLine();
				System.out.println("Enter your password");
				String inputPassword = scanner.nextLine();
				
				BankLoginInfoDao blid = new BankLoginInfoDaoImpl();
				blid.login(inputUsername, inputPassword);
				int userId = blid.login(inputUsername, inputPassword);

				
				
				System.out.println("Welcome, what are we doing today?");
				System.out.println("1. Create A New Account");
				System.out.println("2. Check My Bank Account");
				System.out.println("3. Delete My Bank Account");
				System.out.println("4. Logout");
				
				String sc2 = scanner.next();

				
				if (sc2.equals("1")){
//					BankAccountInfoDao baid = new BankAccountInfoDaoImpl();
//					int userId = blid.login(inputUsername, inputPassword);
					baid.createBankAccount(userId);
				
				}
				if (sc2.equals("2")){
//					BankAccountInfoDao baid = new BankAccountInfoDaoImpl();
//					public List<BankAccountInfo> getBankAccountList(int userId); //get the user's list of bank accounts
					for(BankAccountInfo bai: baid.getBankAccountList(userId)){
						System.out.println(bai);
					}

				}
								
				
			}
			
			if (sc.equals("2")){
				System.out.println("Glad to have you join our bank.");
				System.out.println("Please create an alphanumeric username: ");
				scanner.nextLine();
				String inputUsername = scanner.nextLine();
				//check if this username exists in the database already
				System.out.println("Create a password");
				String inputPassword = scanner.nextLine();
				
				BankLoginInfoDao blid = new BankLoginInfoDaoImpl();
				blid.registerNewBankUser(inputUsername, inputPassword);
				return;
			}
			else if(sc.equals("3")){
				System.out.println("Goodbye!");
				return;
			}

		}
		
		
			
			
		}

		
		

	}
		
		
		
	