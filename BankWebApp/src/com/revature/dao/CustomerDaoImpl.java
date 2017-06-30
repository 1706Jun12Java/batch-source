package com.revature.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.revature.domain.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerDaoImpl extends HttpServlet implements CustomerDao {

	public CustomerDaoImpl() {
	}
	
	@Override
	public void insertCustomer() {
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			//PrintWriter pw = resp.getWriter();
			//int c_id = req.getParameter("C_ID");
			//String c_firstname = req.getParameter("C_FIRSTNAME");
			//String c_lastname = req.getParameter("C_LASTNAME");
			//String c_username = req.getParameter("C_USERNAME");
			//String c_password = req.getParameter("C_PASSWORD");
			
			
			String sql = "INSERT INTO CUSTOMER "
					+ "(C_ID,C_FIRSTNAME,C_LASTNAME,C_USERNAME,C_PASSWORD) "
					+ "VALUES (c_id,c_firstname,c_lastname,c_username,c_password)";
			Statement statement = con.createStatement();			
			System.out.println(sql);			
			statement.executeUpdate(sql);
			System.out.println("Record is inserted into CUSTOMER table!");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> cl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM CUSTOMER";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("C_ID");
				String fname = rs.getString("C_FIRSTNAME");
				String lname = rs.getString("C_LASTNAME");
				String uname = rs.getString("C_USERNAME");
				String password = rs.getString("C_PASSWORD");				
				cl.add(new Customer(id,fname,lname,uname,password));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return cl;
	}
}
