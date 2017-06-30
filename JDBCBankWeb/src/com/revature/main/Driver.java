package com.revature.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.BankUser;
import com.revature.util.ConnectionUtil;

public class Driver {
	public static void main(String[] args){
		boolean programOn = true;

		Scanner scanner = new Scanner(System.in);
		while (programOn) {
			System.out.println("Welcome to Bank of BG");
			System.out.println("What would you like to do today?");
			System.out.println("Please enter the number for the desired operation");
			
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			String sc = scanner.next();

			if (sc.equals("1")){
				BankAccountDao baid = new BankAccountDaoImpl();
//				int userId = blid.login(inputUsername, inputPassword);


				
				System.out.println("Hi, welcome to the login page.");
				System.out.println("Please enter your username: ");
				scanner.nextLine();
				String inputUsername = scanner.nextLine();
				System.out.println("Enter your password");
				String inputPassword = scanner.nextLine();
				
				BankUserDao blid = new BankUserDaoImpl();
				blid.login(inputUsername, inputPassword); //login should kick you out of whileloop if login user/pass is invalid
				System.out.println(blid.login(inputUsername, inputPassword));
				
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
					for(BankAccount bai: baid.getBankAccountList(userId)){
						System.out.println(bai);
					}
					
//					System.out.println("Would you like to work on one of your accounts?");
//					String confirm = scanner.next();
//					if (confirm=="yes"){
						System.out.print("Enter the id of the bank account you'd like to work on.");
						
						String accountId = scanner.next();
						
//						System.out.println("Details for you account id " + accountId);
						
//						do {
							
						
						System.out.println("Account ID: " + accountId);
						System.out.println("What would you like to do today?");
						System.out.println("1. Check your balance");
						System.out.println("2. Withdraw");
						System.out.println("3. Deposit");
						System.out.println("4. Exit");
						
						System.out.print("Enter the number for your desired operation: ");
						
						String option = scanner.next();
						
						switch(option) {
						
						case "1":{
							System.out.println("Your account balance: $");
							break;
						}
						
						case "2":{
							System.out.print("Enter amount to withdraw:");
							String amt = scanner.next();
							BigDecimal amount = new BigDecimal(amt);
							int acctId = Integer.parseInt(accountId);
							baid.withdraw(userId,acctId, amount);
							break;}
							
						case "3":{
							System.out.print("Enter amount to deposit:");
							String amt = scanner.next();
							BigDecimal amount = new BigDecimal(amt);
							int acctId = Integer.parseInt(accountId);
							baid.deposit(userId,acctId, amount);
							break;}
						
						case "4":{
							break;}
							
//						}
						
//						while(option!="4");

					} //end of confirm yes

//				}
								
				
			} // END OF CHECK COUNT. NEXT SHOULD BE DELETE ACCOUNT
				
				if (sc2.equals("3")){
					for(BankAccount bai: baid.getBankAccountList(userId)){
						System.out.println(bai);
					}
					String confirm = scanner.next();
					System.out.print("Enter the id of the bank account you'd like to delete.");
					
					String accountId = scanner.next();
					int acctId = Integer.parseInt(accountId);
					baid.deleteBankAccount(userId, acctId);
					
				}
				
				if (sc2.equals("4")){
					System.out.println("Logging Out.......");
				}
			} //END OF LOGGING IN
			
			else if (sc.equals("2")){
//				
//				for(BankAccount bai: baid.getBankAccountList(userId)){
//					System.out.println(bai);
//				}
//				
//				System.out.print("Enter the id of the bank account you'd like to work on.");
//				
//				String accountId = scanner.next();					
//				
//				System.out.println("Account ID: " + accountId);
//				
//				
				System.out.println("Glad to have you join our bank.");
				System.out.println("Please create an alphanumeric username: ");
				scanner.nextLine();
				String inputUsername = scanner.nextLine();
				//check if this username exists in the database already
				System.out.println("Create a password");
				String inputPassword = scanner.nextLine();
				
				BankUserDao blid = new BankUserDaoImpl();
				blid.registerNewBankUser(inputUsername, inputPassword);
				
//				return;
			}
			else if(sc.equals("3")){
				System.out.println("Goodbye!");
				scanner.close();
				return;
			}

		}
		
		
			
			
		}

		
		

	}

		
		
		
	