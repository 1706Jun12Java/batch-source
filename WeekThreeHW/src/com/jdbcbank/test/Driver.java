package com.jdbcbank.test;

import java.io.IOException;
import java.sql.SQLException;

import com.jdbcbank.dao.*;
import com.jdbcbank.domain.*;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException, IOException {
		 
		UserDao ud = new UserDaoImpl();
		AccountDao ad = new AccountDaoImpl();
		TransactionDao td = new TransactionDaoImpl();
		//System.out.println(ud.getUsers());
		//System.out.println(ad.getUserAccount(new User(1,"","","",1)));
		//System.out.println(td.getTransaction(new Account(1,1,1)));
		//Transaction a = new	Transaction(1,1, "",1, new java.util.Date());
		
		User u = new User(1, "ronnnwu1", "1234", "123@123.com", 1);
		//u.createUserToDB();
		Account a = new Account(2);
		a.addAccountToDB();
		
		System.out.println("done");
	}

}
