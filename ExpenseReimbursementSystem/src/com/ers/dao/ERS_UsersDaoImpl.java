package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.domain.ERS_Users;
import com.ers.util.ConnectionUtil;

public class ERS_UsersDaoImpl implements ERS_UsersDao {

	public ERS_UsersDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ERS_Users getUserByID(String un, String pw) {
		ERS_Users eu = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS  WHERE U_USERNAME=? AND U_PASSWORD=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	

				int u_id = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String password = rs.getString("U_PASSWORD");
				String firstname = rs.getString("U_FIRSTNAME");
				String lastname = rs.getString("U_LASTNAME");
				String email = rs.getString("U_EMAIL");
				int ur_id = rs.getInt("UR_ID");
				
				eu = new ERS_Users(u_id,username,password,firstname,lastname,email,ur_id);
				}
				con.close();
			
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return eu;
	}

	public int getUR_ID(String un, String pw){
		int ur_id = 0; 
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS  WHERE U_USERNAME=? AND U_PASSWORD=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				ur_id = rs.getInt("UR_ID");
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return ur_id;
	}

	public int getUserID(String un, String pw){
		
		int uid = 0; 
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS  WHERE U_USERNAME=? AND U_PASSWORD=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				uid = rs.getInt("U_ID");
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return uid;
		
	}

	public String getFirstName(String un, String pw){
		
		String firstname = " "; 
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS  WHERE U_USERNAME=? AND U_PASSWORD=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				firstname = rs.getString("U_FIRSTNAME");
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return firstname;
		
	}
	
public String getLastName(String un, String pw){
		
		String lastname = " "; 
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS  WHERE U_USERNAME=? AND U_PASSWORD=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				lastname = rs.getString("U_LASTNAME");
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return lastname;
		
	}

@Override
public String getEmail(String un, String pw) {
	String email = " "; 
	try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
		String sql = "SELECT * FROM ERS_USERS  WHERE U_USERNAME=? AND U_PASSWORD=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, un);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
			while(rs.next()){	
			email = rs.getString("U_EMAIL");
			}
	}catch (SQLException e){
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	return email;
}

}
