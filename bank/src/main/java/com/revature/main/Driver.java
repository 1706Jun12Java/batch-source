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

		Scanner keyboard = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to Login, 2 to register,");
			int i = keyboard.nextInt();
			switch (i) {
			case 1:
				// log in
				break;
			case 2:
				//create user
				break;
			default:
				break;
			}
		}
	}
}