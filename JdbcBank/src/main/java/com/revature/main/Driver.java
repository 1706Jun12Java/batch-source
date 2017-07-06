package com.revature.main;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {

		Connection con;
		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		UsersDaoImpl a = new UsersDaoImpl();
		AccountDaoImpl b = new AccountDaoImpl();
		//System.out.println(a.getUsers());
		//a.createUsers(3,"LLING@GMAIL.COM", "CHING", "LING", "LING","LLING@GMAIL.COM",2);
		//System.out.println(a.getUsersById(3));
		//a.deleteUsersById(3);
		//System.out.println(b.getAccount());
		//System.out.println(b.getAccountById(2));
		//b.deleteAccount(3);
		//b.withdraw(2, 20);
		//b.deposit(2, 20);
		System.out.println(a.login("ADMIN", "PASS"));
	}
}