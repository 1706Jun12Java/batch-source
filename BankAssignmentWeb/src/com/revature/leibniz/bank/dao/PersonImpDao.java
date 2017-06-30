package com.revature.leibniz.bank.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.leibniz.bank.domain.Person;
import com.revature.leibniz.bank.util.ConnectionUtil;

public class PersonImpDao implements PersonDao{
	
	// DEFAULT CONSTRUCTOR
	public PersonImpDao() {}

	@Override
	public List<Person> getPersons() {
		ArrayList<Person> persons = new ArrayList<>();
		
		
		try {
						
			// Connect to database 
			Connection con = ConnectionUtil.getConnection();
			
			// Create statement
			Statement statement = con.createStatement();
			
			// Get person_table records
			ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSON_TABLE");
			
			while(resultSet.next()) {
				int personID = Integer.parseInt(resultSet.getString("PERSON_ID"));
				String firstname = resultSet.getString("FIRSTNAME");
				String lastname = resultSet.getString("LASTNAME");	
				Person person = new Person(personID, firstname, lastname);
				persons.add(person);
			}
			
			con.close();
		} catch (IOException | SQLException e) {
		
			e.printStackTrace();
		}
			

		return persons;
	}

	@Override
	public Person getPersonByID(int id) {
		Person person = null;
		
		
		try {
			// Connect to database 
			Connection con = ConnectionUtil.getConnection();
			
			// Search by personID
			String query = "SELECT * FROM PERSON_TABLE WHERE PERSON_ID = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int personID = Integer.parseInt(resultSet.getString("PERSON_ID"));
				String firstname = resultSet.getString("FIRSTNAME");
				String lastname = resultSet.getString("LASTNAME");
				
				person = new Person(personID, firstname, lastname);
			}
			
			con.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

	@Override
	public int createPerson(Person person) {
		// Connect to database
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			
			// Get person info:
			int personID = person.getPersonID();
			String firstname = person.getFirstname();
			String lastname = person.getLastname();
			
			//Query
			String query = "INSERT INTO PERSON_TABLE VALUES(?,?,?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, personID);
			statement.setString(2, firstname);
			statement.setString(3, lastname);
			
			// Update query
			statement.executeUpdate();
			
			con.close();
		
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	
		return 0;
	}

}
