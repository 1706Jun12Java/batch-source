package DAO;

import java.sql.*;
import java.util.*;

import org.junit.Test;

import Conutil.ConnectionUtil;
import UserDefinedExceptions.*;

public class BankUsersDAOImpl implements BankUsersDAO {

	@Test
	public void testNewUser() {
		addUser("User004", "password");
	}

	public void addUser(String username, String password) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = new String("SELECT * FROM BANK_USERS WHERE USER_NAME = ? ");
			PreparedStatement ptsmt = con.prepareStatement(sql);
			ptsmt.setString(1, username);
			ResultSet rs = ptsmt.executeQuery();

			// check if the user name was2 found
			if (rs.next())
				throw new UserNameTakenException();
			else {
				sql = new String("INSERT INTO BANK_USERS (USER_NAME,USER_PASSWORD) VALUES (?,?)");
				ptsmt = con.prepareStatement(sql);
				ptsmt.setString(1, username);
				ptsmt.setString(2, password);
				ptsmt.execute();
				System.out.println("User created successfully.\nWelcome Aboard");
			}
		} catch (UserNameTakenException e) {
			System.out.println("User name was taken. Please try another name");
			Scanner scan = new Scanner(System.in);
			System.out.println("Insert Username");
			String newUser = scan.nextLine();
			System.out.println("Insert Password");
			String newPass = scan.nextLine();
			this.addUser(newUser, newPass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("You shouldn't see this message");
			return;
		}
	}

}
