package com.revature.leibniz.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.leibniz.ers.domain.Employee;
import com.revature.leibniz.ers.util.ConnectionUtil;
import com.revature.leibniz.ers.util.Debug;

public class EmployeeImpDao implements EmployeeDao {
	
	// DEFAULT CONSTRUCTOR
	public EmployeeImpDao() {}

	@Override
	public List<Employee> getEmployees() {
		Debug.printMessage(this.getClass(), "getEmployees()", "INVOKING");
		ArrayList<Employee> employees = new ArrayList<>();
		
		try {
			
			Debug.printMessage(this.getClass(), "getEmployees()", "Calling ConnectionUtil.getConnection()");
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			// Query
			String query = "SELECT * FROM EMPLOYEE_TABLE";
			Statement statement = con.createStatement();
			
			
			// Get data set
			ResultSet resultSet = statement.executeQuery(query);
			
			// Iterate through set
			while(resultSet.next()) {
				int employeeID = resultSet.getInt("EMPLOYEE_ID");
				String firstname = resultSet.getString("EMPLOYEE_FIRSTNAME");
				String lastname = resultSet.getString("EMPLOYEE_LASTNAME");
				String username = resultSet.getString("EMPLOYEE_USERNAME");
				String password = resultSet.getString("EMPLOYEE_PASSWORD");
				String email = resultSet.getString("EMPLOYEE_EMAIL");
				String role = resultSet.getString("EMPLOYEE_ROLE");
				
				Employee employee = new Employee()
						.setID(employeeID)
						.setFirstname(firstname)
						.setLastname(lastname)
						.setUsername(username)
						.setPassword(password)
						.setEmail(email)
						.setRole(role);
				
				employees.add(employee);
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Debug.printMessage(this.getClass(), "getEmployees()", "ENDED");
		return employees;
	}

	@Override
	public Employee findEmployeeByID(int id) {
		Debug.printMessage(this.getClass(), "findEmployeeByID()", "INVOKING");
		
		Employee employee = null;
		
		try {
			
			Debug.printMessage(this.getClass(), "findEmployeeByID()", "Calling ConnectionUtil.getConnection()");
			// CONNECT TO DATABASE
			Connection con = ConnectionUtil.getConnection();
			
			// Query
			String query = "SELECT * FROM EMPLOYEE_TABLE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			Debug.printMessage(this.getClass(), "findEmployeeByID()", "Finding Employee...");
			
			// Get data
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				Debug.printMessage(this.getClass(), "findEmployeeByID", "EMPLOYEE FOUND");
				int employeeID = resultSet.getInt("EMPLOYEE_ID");
				String firstname = resultSet.getString("EMPLOYEE_FIRSTNAME");
				String lastname = resultSet.getString("EMPLOYEE_LASTNAME");
				String username = resultSet.getString("EMPLOYEE_USERNAME");
				String password = resultSet.getString("EMPLOYEE_PASSWORD");
				String email = resultSet.getString("EMPLOYEE_EMAIL");
				String role = resultSet.getString("EMPLOYEE_ROLE");
				
				employee = new Employee()
						.setID(employeeID)
						.setFirstname(firstname)
						.setLastname(lastname)
						.setUsername(username)
						.setPassword(password)
						.setEmail(email)
						.setRole(role);
			}
			else {
				Debug.printMessage(this.getClass(), "findEmployeeByID", "Not Found");
			}
			
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
		
		Debug.printMessage(this.getClass(), "findEmployeeByID()", "ENDED");
		return employee;
	}

	@Override
	public int createEmployee(Employee employee) {
		Debug.printMessage(this.getClass(), "createEmployee()", "INVOKING");
		try {
			Debug.printMessage(this.getClass(), "createEmployee()", "Calling ConnectionUtil.getConnection()");
			// Connect to database.
			Connection con = ConnectionUtil.getConnection();
			
			// Get employee info
			int employeeID = employee.getID();
			String firstname = employee.getFirstname();
			String lastname = employee.getLastname();
			String username = employee.getUsername();
			String password = employee.getPassword();
			String email = employee.getEmail();
			String role = employee.getRole();
	
			// Query
			String query = "INSERT INTO EMPLOYEE_TABLE VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, employeeID);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setString(6, email);
			ps.setString(7, role);
			
			Debug.printMessage(this.getClass(), "createEmployee()", "Creating Employee...");
			// update query
			ps.executeUpdate();
			Debug.printMessage(this.getClass(), "createEmployee()", "Employee Created.");
			
			// Close connection, since we finished creating employee
			con.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			Debug.printMessage(this.getClass(), "createEmployee()", "ENDED WITH EXCEPTIONS");
			return -1;
		}
		Debug.printMessage(this.getClass(), "createEmployee()", "ENDED");
		return 0;
	}

}
