package com.revature.bank.BankAssignment;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.dao.Bank_AccountDaoImpl;
import com.revature.dao.Bank_UserDao;
import com.revature.dao.Bank_UserDaoImpl;
import com.revature.dao.OverdraftException;
import com.revature.domain.Bank_User;



@SuppressWarnings("unused")
public class App 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, SQLException, OverdraftException {
		try{
			
			System.out.println("============ WELCOME TO OUR BANK LOG IN SYSTEM! =========");
			System.out.println("==== Select one: ==== ");
			System.out.println("1 - Existing User");
			System.out.println("2 - New User");
			System.out.println("3 - Exit System");
			
			Scanner sc = new Scanner (System.in);
			int response = sc.nextInt(); 
			sc.nextLine();
	        
		
			switch(response){
			
			case 1: 
			{
				System.out.println("Username: ");
				String un = sc.nextLine(); 
				
				System.out.println("Password: ");
				String pw = sc.nextLine(); 
				
				App.getConnectionFromFile("connection.properties");
				Bank_UserDao u1 = new Bank_UserDaoImpl();
				System.out.println((u1.getBank_UserByID(un,pw)).toString());
				int userID = u1.getBank_UserByID(un,pw).userIDInt();
				viewUserMenu(userID);
				
				break;	
			}
			case 2: 
				Bank_UserDaoImpl.createAccount(); 
				break;
			case 3:
				break;
			default: 
				System.out.println("That input is invalid");
				break;
			}	
		}catch(RuntimeException r){
			r.printStackTrace();
		} 
	}
	
	
	
	public static void viewUserMenu(int uid) throws OverdraftException{
		System.out.println("============ WELCOME TO MAIN MENU! =========");
		System.out.println("==== Select one: ==== ");
		System.out.println("1 - View Account Balance");
		System.out.println("2 - Delete Empty Account");
		System.out.println("3 - Deposit Money"); 
		System.out.println("4 - Withdraw Money");
		System.out.println("5 - Check Super Status"); 
		System.out.println("6 - Logout"); 
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt(); 
		
		switch(choice){
		case 1: 
			Bank_AccountDaoImpl.viewAccountBalance(uid); 
			break; 
		case 2:
			Bank_AccountDaoImpl.deleteEmptyAccount(uid);
			break;
		case 3:
			Bank_AccountDaoImpl.depositMoney(uid);
			break;
		case 4: 
			Bank_AccountDaoImpl.withdrawMoney(uid);
			break;
		case 5:
			checkSuperStatus(uid);
			break;
		case 6:
			System.out.println("Goodbye! :)");
			break;
		default:
			break;
		
		}
		
	}
	
	public static void checkSuperStatus(int uid){
		System.out.println("Checking if you are a super user...");
		
		int isAllowed =0; 
		
		try(Connection con = App.getConnectionFromFile("connection.properties")){
			String sql = "SELECT IS_SUPERUSER FROM BANK_USER WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				int superUser = rs.getInt("IS_SUPERUSER");
				isAllowed = superUser;
				}
				
				if(isAllowed == 1){
					System.out.println("Congratulations! You are a superuser :)");
					System.out.println("Directing to superuser menu...");
					viewSuperUserMenu(uid);
				}else
					System.out.println("Sorry, you are not a superuser :(");
				
				
			
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	public static void viewSuperUserMenu(int uid){
		//A superuser can view, create, update, and delete all users.
		System.out.println("============ WELCOME TO THE SUPER USER MENU! =========");
		System.out.println("==== Select one: ==== ");
		System.out.println("1 - View All Users");
		System.out.println("2 - Create User");
		System.out.println("3 - Update User"); 
		System.out.println("4 - Delete All Users");
		System.out.println("5 - Logout");
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt(); 
		
		switch(choice){
		case 1: 
			Bank_UserDaoImpl.viewAllUsers();
			break;
		case 2: 
			Bank_UserDaoImpl.createAccount();
			break;
		case 3: 
			viewUpdateUserMenu(uid);
			break;
		case 4: 
			Bank_UserDaoImpl.deleteAllUsers();
			break;
		case 5: 
			System.out.println("Goodbye! :)");
			break;
		default:
			break; 
		}
		
	}
	
	public static void viewUpdateUserMenu(int uid){
		System.out.println("============ UPDATE USER MENU! =========");
		System.out.println("==== What would you like to update of a user: ==== ");
		System.out.println("1 - First Name");
		System.out.println("2 - Last Name");
		System.out.println("3 - Username"); 
		System.out.println("4 - Password");
		System.out.println("5 - Super Status");
		System.out.println("6 - Logout");
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt(); 
		
		switch(choice){
		case 1: 
			Bank_UserDaoImpl.updateFirstName();
			break;
		case 2: 
			Bank_UserDaoImpl.updateLastName();
			break; 
		case 3: 
			Bank_UserDaoImpl.updateUsername();
			break;
		case 4: 
			Bank_UserDaoImpl.updatePassword();
			break;
		case 5: 
			Bank_UserDaoImpl.updateSuperStatus();
			break;
		case 6:
			System.out.println("Goodbye! :)");
			break;
		default:
			break;
		}
		
	
	}
	
	
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException{
		Properties prop = new Properties(); 
		InputStream in = new FileInputStream(filename);
		prop.load(in); // loading all key input values in that file
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
	
}
