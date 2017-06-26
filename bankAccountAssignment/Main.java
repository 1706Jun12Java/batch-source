package com.revature.leibniz.bankAccountAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 
 * @author Leibniz Berihuete
 * THIS IS THE MAIN CLASS
 * IT IS RESPONSIBLE FOR DISPLAYING MENUS, 
 * AND MAINTAINING CONNECTION WITH DATABASE
 * 
 */
public class Main {	
	private static UserImpDao userList;
	private static AccountImpDao accountList;
	
	
	// FINAL VALUES FOR LOGIN MENU
	private static final int LOGIN_SIGNIN = 1;
	private static final int LOGIN_CREATE_ACCOUNT = 2;
	private static final int LOGIN_EXIT = 3;
	
	// FINAl VALUES FOR LOGGED IN MENU
	private static final int LOGGED_VIEW_BALANCE = 1;
	private static final int LOGGED_DEPOSIT = 2;
	private static final int LOGGED_WITHDRAWL = 3;
	private static final int LOGGED_LOG_OUT = 4;
	
	
// ============================= MENUS====================================//	
	//LOGIN MENU
	private static void displayLoginMenu() {
		System.out.println("+--------------- MENU ---------------+");
		System.out.println("|1. Sign In                          |");
		System.out.println("|2. Create Account                   |");
		System.out.println("|3. Exit                             |");
		System.out.println("+------------------------------------+");
		
	}
	
	// LOGGED IN MENU
	private static void displayLoggedInMenu(String username) {
		System.out.println("+------------- ACCOUNT --------------+");
		System.out.println("WELCOME " + username);
		System.out.println("+------------------------------------+");
		System.out.println("|1. VIEW BALANCE                     |");
		System.out.println("|2. DEPOSIT                          |");
		System.out.println("|3. WITHDRAWL                        |");
		System.out.println("|4. LOG OUT                          |+");
		System.out.println("+------------------------------------+");
	}
//-------------------------------------------------------------------------//
	
	
	
	
	
	/* ************************
	 * 		    MAIN
	 * ************************/
	public static void main(String [] args) {
		// Inititalize userList;
		userList = new UserImpDao();
		accountList = new AccountImpDao();
		
		
		/* **** STEP 1: Get max user_id *******/
	
		
		// In order to make a connection between the application and the database.
		Connection con;
		
		// To get unique userID when creating a new user.
		int userIDCounter = 0;
		try {
			// CONNECT TO DATABASE
			con = ConnectToday.getConnection(Main.class.getResourceAsStream("info.properties"));
			
			// GET MAX USER_ID
			String strStament = "SELECT MAX(USER_ID) FROM USER_TABLE";
			Statement stmt = con.createStatement();
			ResultSet rSet = stmt.executeQuery(strStament);
			rSet.next();
			
			// ASSIGN THE MAX USER_ID TO userIDCounter
			userIDCounter = Integer.parseInt(rSet.getString(1));
			
			/* ****************************************************
			 * NOTE: Since we know the largest user_id, we can now 
			 * assign the user_id's to new users.
			 * ****************************************************/
		} catch (Exception e1) {
			userIDCounter = 0;
		}
		
		
		
		
		// To get unique accountID when creating a new user.
		int accountIDCounter = 0;
		try {
			// CONNECT TO DATABASE
			con = ConnectToday.getConnection(Main.class.getResourceAsStream("info.properties"));
			
			// GET MAX ACCOUNT_ID
			String strStament2 = "SELECT MAX(ACCOUNT_ID) FROM ACCOUNT_TABLE";
			Statement stmt2 = con.createStatement();
			ResultSet rSet2 = stmt2.executeQuery(strStament2);
			rSet2.next();
			
			// ASSIGN THE MAX ACCOUNT_ID TO accountIDCounter
			accountIDCounter = Integer.parseInt(rSet2.getString(1));
			
			/* ****************************************************
			 * NOTE: Since we know the largest account_id, we can now 
			 * assign the account_id's to new accounts.
			 * ****************************************************/
			
			
			
			
		} catch (Exception e1) {
			accountIDCounter = 0;
		}
		
		/* ******* STEP 2: DISPLAY MENU AND GET USER INPUT *********/
		
		
		// Create scanner for input
		Scanner keyboard = new Scanner(System.in);
		
		// Display menu
		displayLoginMenu();
		
		// Prompt user for option
		System.out.print("OPTION: ");
		
		// Store option chosen in memory
		int option = Integer.parseInt(keyboard.nextLine());
		
		switch(option) {
		case LOGIN_SIGNIN:
			// PROMPT USER FOR USER NAME,
			System.out.print("ENTER USERNAME: ");
			String username = keyboard.nextLine();
			
			// PROMPT USER FOR PASSWORD,
			System.out.print("ENTER PASSWORD: ");
			String password = keyboard.nextLine();
			
			try {
				// CONNECT TO DATABASE TO CHECK AUTHENTICATION
				con = ConnectToday.getConnection(Main.class.getResourceAsStream("info.properties"));
				String stmt = "SELECT * FROM USER_TABLE";
				Statement xstmt = con.createStatement();
				ResultSet xSet = xstmt.executeQuery(stmt);
				
				boolean authenticationValid = false;
				int userID = 0;
				
				while(xSet.next()) {
					// IF USERNAME AND PASSWORD ARE VALID
					if(username.toLowerCase().equals(xSet.getString("username").toLowerCase()) && 
					   password.equals(xSet.getString("password"))) {
						authenticationValid = true;
						userID = Integer.parseInt(xSet.getString("USER_ID"));
						break;
					}
				}
				
				// IF AUTHENTICATION IS VALID
				if(authenticationValid) {
					
					
					// DISPLAY THE LOGGEDIN MENU
					displayLoggedInMenu(username);
					
					System.out.print("ENTER OPTION: ");
					int optionChosen = Integer.parseInt(keyboard.nextLine());
					
					switch (optionChosen) {
					case LOGGED_VIEW_BALANCE:	
						con = ConnectToday.getConnection(Main.class.getResourceAsStream("info.properties"));
						String queryForAcc = "SELECT * FROM ACCOUNT_TABLE";
						Statement accStmt = con.createStatement();
						ResultSet resultSet = accStmt.executeQuery(queryForAcc);
						double balance = 0.0;
						
						while(resultSet.next()) {
							if(userID == Integer.parseInt(resultSet.getString("USER_ID"))) {
								balance = Double.parseDouble(resultSet.getString("balance"));
								break;
							}
						}
						
						System.out.println("YOUR BALANCE IS: " + balance);
						break;
						
					case LOGGED_DEPOSIT:
						System.out.print("How much would like to deposit: ");
						String inputDeposit = keyboard.next();
						double dept = Double.parseDouble(inputDeposit);
						
						
						
						// GET CURRENT BALANCE
						con = ConnectToday.getConnection(Main.class.getResourceAsStream("info.properties"));
						String queryCurrentBalance = "SELECT * FROM ACCOUNT_TABLE";
						Statement currentBalanceStmt = con.createStatement();
						ResultSet currentBalanceSet = currentBalanceStmt.executeQuery(queryCurrentBalance);
						double currentBalance = 0.0;
						
						while(currentBalanceSet.next()) {
							if(userID == Integer.parseInt(currentBalanceSet.getString("USER_ID"))) {
								currentBalance = Double.parseDouble(currentBalanceSet.getString("balance"));
								break;
							}
						}
						
						// DEPOSIT
						con = ConnectToday.getConnection(Main.class.getResourceAsStream("info.properties"));
						String depositQuery = "UPDATE ACCOUNT_TABLE SET balance = " + (currentBalance + dept) + 
								" WHERE USER_ID = " + userID;
						Statement depositStmt = con.createStatement();
						depositStmt.executeQuery(depositQuery);
						
						System.out.println("YOU HAVE DEPOSITED " + (currentBalance + dept));
						
						
						break;
						
					case LOGGED_WITHDRAWL:
						break;
						
					case LOGGED_LOG_OUT:
						con.close();
						System.exit(0);
						break;

					default:
						break;
					}

				}
				else {
					System.out.println("ERROR\nUSER MAY NOT EXIST, OR USER/PASSWORD IS INCORRECT!");
				}
				
				
			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			break;
			
		case LOGIN_CREATE_ACCOUNT:
			// PROMPT USER FOR USER NAME,
			System.out.print("ENTER DESIRED USERNAME: ");
			String dusername = keyboard.nextLine();
			
			// PROMPT USER FOR PASSWORD,
			System.out.print("ENTER DESIRED PASSWORD: ");
			String dpassword = keyboard.nextLine();
			
			User user = new User(++userIDCounter, dusername, dpassword);
			Account account = new Account(++accountIDCounter, user.getUserID(), 0.0);
			// CONNECT TO DATABASE
			try {
				con = ConnectToday.getConnection(Main.class.getResourceAsStream("info.properties"));
				String stmt = "INSERT INTO USER_TABLE VALUES("+(user.getUserID())+",'" + user.getUsername() +"', '" + user.getPassword() +"')";
				Statement xstmt = con.createStatement();
				xstmt.executeQuery(stmt);			
				
				con = ConnectToday.getConnection(Main.class.getResourceAsStream("info.properties"));
				stmt = "INSERT INTO ACCOUNT_TABLE VALUES("+account.getAccountID() +", " + account.getUserID() + ", " + account.getBalance() +")";
				xstmt = con.createStatement();
				xstmt.executeQuery(stmt);
				userList.getAllUsers().add(user);
				accountList.getAllAccounts().add(account);
				
				System.out.println("CONGRATUALATIONS!\n YOU CREATED AN ACCOUNT WITH US!\n NOTE OUR BANK PROVIDES NO PROTECTION AT ALL.");
			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
			
			
			
		case LOGIN_EXIT:
			System.exit(0);
		}
		
		
	}

}
