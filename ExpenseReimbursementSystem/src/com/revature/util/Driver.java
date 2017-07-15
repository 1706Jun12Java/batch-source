package com.revature.util;

import java.sql.Connection;

import com.revature.dao.ReimbursementsDaoImpl;
import com.revature.dao.UsersDaoImpl;

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
		//System.out.println(a.getUsers());
		//a.createUsers("LLING@GMAIL.COM", "CHING", "LING", "LING","LLING@GMAIL.COM");
		//System.out.println(a.getUsersById(3));
		//a.deleteUsersById(21);
		System.out.println(a.login("Admin", "Pass"));
		//ReimbursementsDaoImpl b = new ReimbursementsDaoImpl();
		//System.out.println(b.getReimbursements());
		//b.createReimbursement(250, "medical", 2,1);
		//b.createReimbursement(145450, "medical", 2,1);
		//b.denyReimbursement(5);
		//System.out.println(b.getReimbursementsById(5));
		//b.approveReimbursement(3);
		//System.out.println(b.getReimbursementsById(3));
	}
}