package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.domain.User;
import com.bank.domain.UserRole;
import com.bank.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public static boolean validateEmployee(String name, String pass) {
		boolean status = false;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();

			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM ERS_USERS WHERE U_USERNAME = ? AND U_PASSWORD = ?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status) {
				int role = rs.getInt("UR_ID");
				if (role == 2) {
					status = true;
				} else {
					status = false;
				}
				rs.close();
				 ps.close();
				 con.close();
			}

		} catch (Exception e) {
			System.out.println(e);
		} 
		return status;
	}

	public static boolean validateManager(String name, String pass) {
		boolean status = false;
		Connection con = null;

		try {
			con = ConnectionUtil.getConnectionFromFile();

			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM ERS_USERS WHERE U_USERNAME = ? AND U_PASSWORD = ?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status) {
				int role = rs.getInt("UR_ID");
				if (role == 1) {
					status = true;
				} else {
					status = false;
				}
			}
			rs.close();
			 ps.close();
			 con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<User> getAllEmployees() {

		Connection con = null;
		ArrayList<User> employees = new ArrayList<User>();

		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_USERS WHERE UR_ID = 2";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String firstName = rs.getString("U_FIRSTNAME");
				String lastName = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				User employee = new User(id, username, firstName, lastName, email);
				employees.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return employees;

	}

	public static int getUserByUsername(String username) {

		Connection con = null;
		int userId = 0;

		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT U_ID FROM ERS_USERS WHERE U_USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userId = rs.getInt("U_ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return userId;

	}

	public static User getUserById(int id) {
		Connection con = null;
		User user = new User();

		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_USERS WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int u_id = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String password = rs.getString("U_PASSWORD");
				String firstname = rs.getString("U_FIRSTNAME");
				String lastname = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int ur_id = rs.getInt("UR_ID");
				UserRole role = UserRoleDaoImpl.geUserRoleById(ur_id);
				User user2 = new User(u_id, username, password, firstname, lastname, email, role);
				user = user2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return user;
	}

	public static User viewEmployeeInfo(int id) {

		Connection con = null;
		User employee = new User();
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_USERS WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String username = rs.getString("U_USERNAME");
				String password = rs.getString("U_PASSWORD");
				String firstName = rs.getString("U_FIRSTNAME");
				String lastName = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				User user = new User(username, password, firstName, lastName, email);
				employee = user;
			}
			rs.close();
			 ps.close();
			 con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;

	}

	public static void updateEmployeeUsername(String username, int id) {

		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "UPDATE ERS_USERS SET U_USERNAME = ? WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateEmployeePassword(String password, int id) {

		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "UPDATE ERS_USERS SET U_PASSWORD = ? WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateEmployeeFirstName(String firstname, int id) {

		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "UPDATE ERS_USERS SET U_FIRSTNAME = ? WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateEmployeeLastName(String lastname, int id) {

		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "UPDATE ERS_USERS SET U_LASTNAME = ? WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, lastname);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateEmployeeEmail(String email, int id) {

		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "UPDATE ERS_USERS SET U_EMAIL = ? WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
