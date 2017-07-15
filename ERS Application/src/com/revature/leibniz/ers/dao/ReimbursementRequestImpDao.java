package com.revature.leibniz.ers.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.leibniz.ers.domain.ReimbursementRequest;
import com.revature.leibniz.ers.util.ConnectionUtil;
import com.revature.leibniz.ers.util.Debug;

public class ReimbursementRequestImpDao implements ReimbursementRequestDao{

	// DEFAULT CONSTRUCTOR
	public ReimbursementRequestImpDao() {}

	@Override
	public List<ReimbursementRequest> getReimbursementRequests() {
		ArrayList<ReimbursementRequest> reimbursementRequests = new ArrayList<>();
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			//Query string
			String query = "SELECT * FROM R_REQUEST_TABLE";
			
			// Create statement
			Statement statement = con.createStatement();
			
			// execute query and get data
			ResultSet resultSet = statement.executeQuery(query);
			
			// Iterate through resultSet
			while(resultSet.next()) {
				int id = resultSet.getInt("R_REQUEST_ID");
				double quantity = resultSet.getDouble("R_REQUEST_QUANTITY");
				String status = resultSet.getString("R_REQUEST_STATUS");
				Blob image = resultSet.getBlob("R_REQUEST_IMAGE");
				int employeeID = resultSet.getInt("EMPLOYEE_ID");
				
				// Add data into an object
				ReimbursementRequest rr = new ReimbursementRequest()
						.setId(id)
						.setQuantity(quantity)
						.setStatus(status)
						.setImage(image)
						.setEmployeeID(employeeID);
				
				// Add object to list
				reimbursementRequests.add(rr);
				
			} // End of loop
			
			// Since we are done, close connection
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Return list
		return reimbursementRequests;
	}

	public List<ReimbursementRequest> getReimbursementRequests(int xid) {
		ArrayList<ReimbursementRequest> reimbursementRequests = new ArrayList<>();
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			//Query string
			String query = "SELECT * FROM R_REQUEST_TABLE WHERE EMPLOYEE_ID = " + xid;
			
			// Create statement
			Statement statement = con.createStatement();
			
			// execute query and get data
			ResultSet resultSet = statement.executeQuery(query);
			
			// Iterate through resultSet
			while(resultSet.next()) {
				int id = resultSet.getInt("R_REQUEST_ID");
				double quantity = resultSet.getDouble("R_REQUEST_QUANTITY");
				String status = resultSet.getString("R_REQUEST_STATUS");
				Blob image = resultSet.getBlob("R_REQUEST_IMAGE");
				int employeeID = resultSet.getInt("EMPLOYEE_ID");
				
				// Add data into an object
				ReimbursementRequest rr = new ReimbursementRequest()
						.setId(id)
						.setQuantity(quantity)
						.setStatus(status)
						.setImage(image)
						.setEmployeeID(employeeID);
				
				// Add object to list
				reimbursementRequests.add(rr);
				
			} // End of loop
			
			// Since we are done, close connection
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Return list
		return reimbursementRequests;
	}

	
	
	@Override
	public ReimbursementRequest findReimbursementRequestByID(int id) {
		try {
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			// query
			String query = "SELECT * FROM R_REQUEST_TABLE WHERE R_REQUEST_ID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			// Get data
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				
				// Reimbursement Request info
				int rID = resultSet.getInt("R_REQUEST_ID");
				double quantity = resultSet.getDouble("R_REQUEST_QUANTITY");
				String status = resultSet.getString("R_REQUEST_STATUS");
				Blob image = resultSet.getBlob("R_REQUEST_IMAGE");
				int employeeID = resultSet.getInt("EMPLOYEE_ID");
				
				
				// put data in object
				ReimbursementRequest rr = new ReimbursementRequest()
						.setId(rID)
						.setQuantity(quantity)
						.setStatus(status)
						.setImage(image)
						.setEmployeeID(employeeID);
				
				// return object
				return rr;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return null; // returns null if nothing found
	}

	@Override
	public int createReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		Debug.printMessage(this.getClass(), "createReimbursementRequest()", "invoking...");
		
		// Check whether reimbursementRequest is null
		if(reimbursementRequest != null) {
			// get info
			int id = reimbursementRequest.getId();
			double quantity = reimbursementRequest.getQuantity();
			String status = reimbursementRequest.getStatus();
			Blob image = reimbursementRequest.getImage();
			int employeeID = reimbursementRequest.getEmployeeID();
			
			try {				
				// Connecting to database
				Connection con = ConnectionUtil.getConnection();
				
				// Query
				String query = "INSERT INTO R_REQUEST_TABLE VALUES(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, id);
				ps.setDouble(2, quantity);
				ps.setString(3, status);
				ps.setBlob(4, image);
				ps.setInt(5, employeeID);
				
				Debug.printMessage(this.getClass(), "createReimbursementRequest", "creating Reimbursement Request...");
				ps.executeUpdate();
				Debug.printMessage(this.getClass(), "createReimbursementRequest", "Reimbursement Request created");
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			// Print message that argument is null
			Debug.printMessage(this.getClass(), "CreateReimbursementRequest", "ERROR, argument is null");
			return -1;
		}
		
		
		return 0; // return 0 if everything went well
	}

	
}
