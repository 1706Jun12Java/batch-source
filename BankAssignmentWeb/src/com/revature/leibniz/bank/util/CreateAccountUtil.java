package com.revature.leibniz.bank.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.leibniz.bank.dao.AccountImpDao;
import com.revature.leibniz.bank.dao.PersonImpDao;
import com.revature.leibniz.bank.dao.SuperUserImpDao;
import com.revature.leibniz.bank.dao.UserImpDao;
import com.revature.leibniz.bank.domain.Account;
import com.revature.leibniz.bank.domain.Person;
import com.revature.leibniz.bank.domain.SuperUser;
import com.revature.leibniz.bank.domain.User;

public class CreateAccountUtil {

	public static void createAccount(String firstname, String lastname, String username, String password, boolean isSuperUser) {
		int maxID = 0;
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MAX(PERSON_ID) FROM PERSON_TABLE");
			rs.next();
			maxID = rs.getInt(1);
			con.close();
		} catch (IOException | SQLException e) {
			maxID = 0;
			e.printStackTrace();
		}
		
		
		if(!isSuperUser) {
			System.out.println("Creating person...");
			Person person = new Person(++maxID, firstname, lastname);				
			new PersonImpDao().createPerson(person);
			System.out.println("person created.");
			
			System.out.println("Creating user...");
			User user = new User(person.getPersonID(), username, password, person.getPersonID());				
			new UserImpDao().createUser(user);
			System.out.println("user created.");
			
			System.out.println("Creating account...");
			Account account = new Account(person.getPersonID(), 0.0,  person.getPersonID());				
			new AccountImpDao().createAccount(account);
			System.out.println("account created.");		
			
		}
		else {
			System.out.println("Creating person...");
			Person person = new Person(++maxID, firstname, lastname);				
			new PersonImpDao().createPerson(person);
			System.out.println("person created.");
			
			System.out.println("Creating user...");
			SuperUser superUser = new SuperUser(person.getPersonID(), username, password, person.getPersonID());				
			new SuperUserImpDao().createSuperUser(superUser);
			System.out.println("user created.");
			
			System.out.println("Creating account...");
			Account account = new Account(person.getPersonID(), 0.0,  person.getPersonID());				
			new AccountImpDao().createAccount(account);
			System.out.println("account created.");		
		}
	}

}
