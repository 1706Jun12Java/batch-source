package com.revature.leibniz.ers.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.leibniz.ers.domain.Employee;
import com.revature.leibniz.ers.domain.ReimbursementRequest;

/**
 * 
 * @author Leibniz Berihuete
 *
 */
public class DataUtil {

	public static void printMessagePage(PrintWriter pw, String message, String backlink, String backLinkMessage) {
		pw.write("<link href =\"css/mystyle.css\" rel=\"stylesheet\">");
		pw.write("<h1 class =\"title \" style =\"color:white;\">" + message + "</h1>");
		pw.write("<a style =\"font-size: 25px; text-decoration:none; color: white;"
				+ "display: block; padding:10px; border: solid 2px; border-radius:10px;"
				+ "background-color: #616161; width: 85px; margin: 0 auto; \"" + " href=\"" + backlink
				+ "\" class= \"linkText\">" + backLinkMessage + "</a>");
	}
	
	public static void printMessagePage(PrintWriter pw, String message, String backlink, String backLinkMessage, int width) {
		pw.write("<link href =\"css/mystyle.css\" rel=\"stylesheet\">");
		pw.write("<h1 class =\"title \" style =\"color:white;\">" + message + "</h1>");
		pw.write("<a style =\"font-size: 25px; text-decoration:none; color: white;"
				+ "display: block; padding:10px; border: solid 2px; border-radius:10px;"
				+ "background-color: #616161; width: "+width+"px; margin: 0 auto; \"" + " href=\"" + backlink
				+ "\" class= \"linkText\">" + backLinkMessage + "</a>");
	}

	public static int getMaxInt(String tableName, String columnName) {
		Debug.printMessage(DataUtil.class, "getMaxInt()", "Invoking...");
		int max = 0;
		try {

			Debug.printMessage(DataUtil.class, "getMaxInt()", "Calling ConnectionUtil.getConnection()");
			// Connecting to database...
			Connection con = ConnectionUtil.getConnection();

			String query = "SELECT MAX(" + columnName + ") FROM " + tableName;
			Statement ps = con.createStatement();
			Debug.printMessage(DataUtil.class, "getMaxInt()", "Finding MAX ID...");

			ResultSet resultSet = ps.executeQuery(query);

			resultSet.next();
			max = resultSet.getInt(1);
			Debug.printMessage(DataUtil.class, "getMaxInt()", "MAX FOUND: " + max);

			con.close();

		} catch (SQLException | IOException e) {
			max = 0;
			e.printStackTrace();
			Debug.printMessage(DataUtil.class, "getMaxInt()", "MAX NOT FOUND, therefore MAX: " + 0);
		}
		Debug.printMessage(DataUtil.class, "getMaxInt()", "ENDED");
		return max;
	}

	public static boolean isAuthenticationGood(String username, String password) {
		Debug.printMessage(DataUtil.class, "isAuthenticationGood()", "INVOKING");
		boolean goodAuthentication = false;

		Debug.printMessage(DataUtil.class, "isAuthenticationGood()", "Calling ConnectionUtil.getConnection()");
		try {
			// Connecting to database
			Connection con = ConnectionUtil.getConnection();
			// Query
			String query = "SELECT * FROM EMPLOYEE_TABLE WHERE EMPLOYEE_USERNAME = ? AND EMPLOYEE_PASSWORD = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			Debug.printMessage(DataUtil.class, "isAuthenticationGood()", "Checking credentials...");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				goodAuthentication = true;
				Debug.printMessage(DataUtil.class, "isAuthenticationGood()", "Credentials valid!");
			} else {
				Debug.printMessage(DataUtil.class, "isAuthenticationGood()", "Credentials invalid!");
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			Debug.printMessage(DataUtil.class, "isAuthenticationGood()", "ENDED WITH SQL EXCEPTION");
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			Debug.printMessage(DataUtil.class, "isAuthenticationGood()", "ENDED WITH IO EXCEPTION");
			return false;
		}

		Debug.printMessage(DataUtil.class, "isAuthenticationGood()", "ENDED");
		return goodAuthentication;
	}

	public static boolean doesUserExist(String username) {
		Debug.printMessage(DataUtil.class, "doesUserExist()", "INVOKING");
		boolean userExist = false;

		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();

			// query
			String query = "SELECT * FROM EMPLOYEE_TABLE WHERE EMPLOYEE_USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);

			// Get result set
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				userExist = true;
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		Debug.printMessage(DataUtil.class, "doesUserExist()", "ENDED, returning: " + userExist);
		return userExist;
	}

	public static Employee getUser(String username) {
		Debug.printMessage(DataUtil.class, "getUser()", "INVOKING");

		Employee employee = null;

		try {

			Debug.printMessage(DataUtil.class, "getUser()", "Calling ConnectionUtil.getConnection()");
			// CONNECT TO DATABASE
			Connection con = ConnectionUtil.getConnection();

			// Query
			String query = "SELECT * FROM EMPLOYEE_TABLE WHERE EMPLOYEE_USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);

			Debug.printMessage(DataUtil.class, "getUser()", "Finding user...");

			// Get data
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				Debug.printMessage(DataUtil.class, "getUser()", "EMPLOYEE FOUND");
				int employeeID = resultSet.getInt("EMPLOYEE_ID");
				String firstname = resultSet.getString("EMPLOYEE_FIRSTNAME");
				String lastname = resultSet.getString("EMPLOYEE_LASTNAME");
				String usernamex = resultSet.getString("EMPLOYEE_USERNAME");
				String password = resultSet.getString("EMPLOYEE_PASSWORD");
				String email = resultSet.getString("EMPLOYEE_EMAIL");
				String role = resultSet.getString("EMPLOYEE_ROLE");

				employee = new Employee().setID(employeeID).setFirstname(firstname).setLastname(lastname)
						.setUsername(username).setPassword(password).setEmail(email).setRole(role);
			} else {
				Debug.printMessage(DataUtil.class, "getUser()", "Not Found");
			}

		} catch (SQLException | IOException e) {

			e.printStackTrace();
		}

		Debug.printMessage(DataUtil.class, "getUser()", "ENDED");
		return employee;
	}
	
	public static ArrayList<ReimbursementRequest> getRRByEmployeeID(int id) {
		ArrayList<ReimbursementRequest> rrList = new ArrayList<>();
		// Connect to database
		try {
			Connection con = ConnectionUtil.getConnection();
			// QUERY
			String query = "SELECT * FROM R_REQUEST_TABLE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ReimbursementRequest rr = new ReimbursementRequest()
						.setId(rs.getInt("R_REQUEST_ID"))
						.setQuantity(rs.getDouble("R_REQUEST_QUANTITY"))
						.setStatus(rs.getString("R_REQUEST_STATUS"))
						.setImage(rs.getBlob("R_REQUEST_IMAGE"))
						.setEmployeeID(rs.getInt("EMPLOYEE_ID"));
				
				rrList.add(rr);
			}
			
			con.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return rrList;
	}
	
	public static void updateEmployeeFirstname(int id, String firstname) {
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			String query = "UPDATE EMPLOYEE_TABLE SET EMPLOYEE_FIRSTNAME = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, firstname);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			con.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmployeeLastname(int id, String lastname) {
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			String query = "UPDATE EMPLOYEE_TABLE SET EMPLOYEE_LASTNAME = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, lastname);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			con.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
