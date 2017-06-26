package com.bank.main;

import java.util.Scanner;

import com.bank.domain.Account;

public class BankMain {

	public static void main(String[] args) {
		
		Account obj1 = new Account();
		Scanner input = new Scanner(System.in);
			
		System.out.println("Welcome");
		System.out.println("1. Create account");
		System.out.println("2. Log in");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Delete Account");
		System.out.println("6. Exit");
		
		System.out.println("Enter an option: ");
		int menu;
		boolean quit = false;
	    do {
	      System.out.print("Please enter your choice: ");
	      menu = input.nextInt();
	      switch (menu) {
	      case 1:
	    	  int i = 1;
	    	  System.out.print("Please enter your first name: ");
	    	  String fn = input.next();
	    	  System.out.print("Please enter your last name: ");
	    	  String ln = input.next();
	    	  System.out.print("Please enter username: ");
	    	  String un = input.next();
	    	  System.out.print("Please enter password for your account: ");
	    	  String pw = input.next();
	    	  obj1.createAccount(i,fn,ln,un,pw);
	    	  break;

	      case 2:
	    	  
	          obj1.logIn();
	          break;

	      case 3:
	          obj1.deposit();
	          break;

	      case 4:
	    	  obj1.withdraw();
	          quit = true;
	          break;
	        
	      case 4:
	    	  obj1.deleteAccount();
	          quit = true;
	          break;
	        
	      default:
	    	  System.out.println("This option is not available. Try again.");
	      }
	    } while (!quit);		System.out.println("Thank you for choosing our services!");
	}
}
