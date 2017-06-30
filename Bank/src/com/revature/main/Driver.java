package com.revature.main;

import java.io.File;
import java.util.Scanner;

import com.revature.dao.*;
import com.revature.domain.*;

public class Driver {

	public static void main(String[] args) {
		
		
		String command;
		Scanner scan = new Scanner(System.in);
		UserDaoImpl userDao = new UserDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		
		User user= userDao.userLogin("username", "password");
		System.out.println(user);
		
		userDao.logout(user);
		System.out.println(user);
		File dir = new File(".");
		File[] filesList = dir.listFiles();
		for (File file : filesList) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		    }
		}
	}

}