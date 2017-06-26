package com.chase.main;

import java.util.Scanner;

import com.chase.dao.*;
import com.chase.domain.*;
import com.chase.util.*;

public class Driver {
	static UsersDao ud = new UsersDaoImpl();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("Welcome to Chase Bank\nPress 1 to register\nPress 2 to login\nPress 3 to exit");
		int option = sc.nextInt();
		switch(option){
		case 1:
			ud.createBankAccount(85000);
			break;
		case 2:
			ud.createUser();
			break;
		case 3:
			break;
		}
	}
}
}

