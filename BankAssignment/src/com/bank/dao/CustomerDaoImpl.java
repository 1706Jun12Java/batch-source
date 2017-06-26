package com.bank.dao;

import com.bank.domain.Account;
import com.bank.domain.Customer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.domain.Customer;
import com.bank.util.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public List<Customer> getCustomers() {
	
		List<Customer> cl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM CUSTOMER";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("CUSTOMER_ID");
				String fName = rs.getString("custFirstName");
				String lName = rs.getString("custLastName");
				String usern = rs.getString("username");
				String passw = rs.getString("password");
				Customer newCust = new Customer(id,fName,lName,usern,passw);
				cl.add(newCust);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return cl;
	}

	@Override
	public Customer createCustomer(int id, String firstname, String lastname, String username, String password) {
		
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "{call SP_FEED_BEAR(?,?,?,?,?)}"; // calling stored procedure to insert new record
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Customer.getCustId());
			pstmt.setString(2,Customer.getCustFirstName());
			pstmt.setString(3,Customer.getCustLastName());
			pstmt.setString(4,Customer.getUsername());
			pstmt.setString(5,Customer.getPassword());	
			accountsCreated = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return null;
	}
	
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
