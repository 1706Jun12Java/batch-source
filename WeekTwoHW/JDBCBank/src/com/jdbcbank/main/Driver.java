package com.jdbcbank.main;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import com.jdbcbank.dao.*;
import com.jdbcbank.domain.*;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("JDBC Bank");
		System.out.println("enter 1: superuser");
		System.out.println("enter 2: login");
		System.out.println("enter 3: register");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice){
		case 1:
			superuser();
			break;
		case 2:
			login();
			break;
		case 3:
			register();
			break;
		}
	}

	private static void register() {
		Scanner sc = new Scanner(System.in);
		UserDao ud = new UserDaoImpl();
		System.out.println("enter username: ");
		String username = sc.nextLine();
		System.out.println("enter password: ");
		String password = sc.nextLine();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			password = md.digest().toString();
		} catch (NoSuchAlgorithmException e) { 
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
		}
		 
		User u = new User(1, "NORMAL_USER", username, password);
		ud.createUser(u);
	}

	private static void login() { 
		System.out.println("You are login in as normal user");
		System.out.println("enter 1: create account");
		System.out.println("enter 2: delete account");
		System.out.println("enter 3: deposite money");
		System.out.println("enter 4: withdraw");
		
		//
		
	}

	private static void superuser() {
		
		System.out.println("You are login in as superuser");
		System.out.println("enter 1: view all users");
		System.out.println("enter 2: create new user");
		System.out.println("enter 3: update user");
		System.out.println("enter 4: delete all users");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt(); 
		UserDao ud = new UserDaoImpl();
		
		switch (choice){
		case 1:
			System.out.println(ud.getUsers());
			break;
		case 2:
			register();
			break;
		case 3:
			register(); 
			break;
		case 4:
			System.out.println("enter username: ");
			String username = sc.nextLine();
			User u = new User(1, null, username, null );
			ud.deleteUser(u);
			break;	
		}
	} 
}
