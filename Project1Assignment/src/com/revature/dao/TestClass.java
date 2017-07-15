package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.E_User;

public class TestClass {

	public static void main(String[] args){
		ReimburstmentImpl r = new ReimburstmentImpl();
		E_UserImpl eui = new E_UserImpl();
		try {
			E_User user = eui.getUser(23);
			E_User user2 = eui.getUserByName("DARSQK");
			System.out.println(user);
			System.out.println(user2);
			eui.updateUser("dark", "meep", "flipper", "target");
			eui.updateUserPass("DARSQK", "mane", "dkarers");
			//r.getReimburstmentByUser(0);
			System.out.println("its lit");
		}catch (InvalidUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
