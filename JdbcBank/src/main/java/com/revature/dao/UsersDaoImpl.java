package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Account;
import com.revature.domain.Users;
import com.revature.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao {

	public UsersDaoImpl() {
		
	}

	@Override
	public List<Users> getUsers() {
		List<Users> ul = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM USERS";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int userID = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String email = rs.getString("U_EMAIL");
				String pw = rs.getString("U_PASSWORD");
				ul.add(new Users(userID, username, pw, email));
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return ul;
	}

	@Override
	public Users getUsersById(int usersid) {
		PreparedStatement pStatement;
		Users user = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM USERS WHERE U_ID = ?";
			pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, usersid);
			ResultSet rs = pStatement.executeQuery();

			while (rs.next()) {
				int userID = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String email = rs.getString("U_EMAIL");
				String pw = rs.getString("U_PASSWORD");
				user = new Users(userID, username, pw, email);
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void createUsers(int id, String un, String pw, String fn, String ln, String email, int ur_id) {

		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "INSERT INTO USERS (U_ID,U_USERNAME,U_PASSWORD,U_FIRSTNAME,U_LASTNAME,U_EMAIL,UR_ID)"
					+ " VALUES(seq_auto.nextval,?,?,?,?,?,seq_auto.nextval)";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, id);
			pStatement.setString(2, email);
			pStatement.setString(3, pw);
			pStatement.setString(4, fn);
			pStatement.setString(5, ln);
			pStatement.setString(6, email);
			pStatement.setInt(7, ur_id);
			if (pStatement.executeUpdate() > 0)
				System.out.println("Registration Complete");
			else
				System.out.println("Failed to register.");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUsersById(int id) {

		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "SELECT * FROM USERS WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			int uid = id;
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sql = "DELETE FROM USERS WHERE U_ID = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, uid);
				int i = ps.executeUpdate();
				if (i > 0) {
					System.out.println("The user has been deleted.");
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean login(String username, String password) {

		boolean status = false;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE U_USERNAME = ? AND U_PASSWORD = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}