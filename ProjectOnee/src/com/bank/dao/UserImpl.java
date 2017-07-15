package com.bank.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.bank.user.Reimbursements;
import com.bank.user.Users;
import com.bank.util.ConnectionUtil;

public class UserImpl implements UserDao {
	
	@Override
	public List<Users> getUsers() {
        List<Users> userList = new ArrayList<>();

        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {

            String sql = "SELECT * FROM USERS";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            PreparedStatement pStatement;

            
            while (rs.next()){
                int id = rs.getInt("U_ID");
                String username = rs.getString("USERNAME");
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String email = rs.getString("EMAIL");
                int r_ID = rs.getInt("R_ID");

                
                String sql1 = "SELECT USER_ROLE FROM USER_ROLES WHERE R_ID = ? ";
                
                pStatement = con.prepareStatement(sql1);

                pStatement.setInt(1, r_ID);
                
                ResultSet rs1 = pStatement.executeQuery();
                
                if (rs1.next()){
                	String role = rs1.getString("USER_ROLE");
                    userList.add(new Users(id, username, firstName, lastName, email, role));
                } else {
                    System.out.println("Wrong username or password!");
                }
                
                
            }
            rs.close();
            con.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return userList;
	}

	@Override
	public Users getUserById(int id) {
        PreparedStatement pStatement;
        Users user= null;

        try (Connection con = ConnectionUtil.getConnection("connection.properties")){
            String sql = "SELECT * FROM USERS WHERE U_ID = ?";
            pStatement = con.prepareStatement(sql);
            pStatement.setInt(1,id);
            ResultSet rs = pStatement.executeQuery();

            while(rs.next()){
            	int id1 = rs.getInt("U_ID");
                String username = rs.getString("USERNAME");
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String email = rs.getString("EMAIL");
                int r_ID = rs.getInt("R_ID");
                
                String sql1 = "SELECT USER_ROLE FROM USER_ROLES WHERE R_ID = ? ";
                
                pStatement = con.prepareStatement(sql1);

                pStatement.setInt(1, r_ID);
                
                ResultSet rs1 = pStatement.executeQuery();
                
                if (rs1.next()){
                	String role = rs1.getString("USER_ROLE");
                    user = new Users(id1, username, firstName, lastName, email, role);
                } else {
                    System.out.println("Wrong username or password!");
                }
                
            }

            rs.close();
            con.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return user;
	}

	@Override
	public boolean submitReimbursement(Users user, String amount, String category, String description, InputStream receipt) {
		
        try (Connection con = ConnectionUtil.getConnection("connection.properties")){

        	
        	String sql = "INSERT INTO REIMBURSEMENTS (AMOUNT, DESCRIPTION, RECEIPT, SUBMITTED, U_ID_AUTHOR, RT_TYPE_ID)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";

	        PreparedStatement pStatement = con.prepareStatement(sql);
	        pStatement.setString(1,amount);
	        pStatement.setString(2,description);
	        pStatement.setBlob(3,receipt);
	        pStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
	        pStatement.setInt(5, user.getU_ID());
	        pStatement.setInt(6, Integer.parseInt(category));
	        
	        
	        
	        if (pStatement.executeUpdate() > 0){
	        	con.close();
	        	return true;
	        }
	        else {
	            return false;
	        }
	    } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        
        
        return false;
	}

	
	public List<Reimbursements> getReimbursements(int u_ID, String role) {
		List<Reimbursements> list = new ArrayList<>();

		PreparedStatement pStatement;
		ResultSet rs = null;
		try(Connection con = ConnectionUtil.getConnection("connection.properties")) {
			 String sql = null;
			 if (role.equals("Manager")){
				 sql = "SELECT * FROM REIMBURSEMENTS";
				 pStatement = con.prepareStatement(sql);
	             rs = pStatement.executeQuery();
			 } else {
				 sql = "SELECT * FROM REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
	             pStatement = con.prepareStatement(sql);
	             pStatement.setInt(1, u_ID);
	             rs = pStatement.executeQuery();
			 }



             while(rs.next()){
             	 int reimburse_ID = rs.getInt("REIMBURSE_ID");
                 double amount = rs.getDouble("AMOUNT");
                 String description = rs.getString("DESCRIPTION");
                 byte[] receipt = rs.getBytes("RECEIPT");
                 Timestamp submitted = rs.getTimestamp("SUBMITTED");
                 Timestamp resolved = rs.getTimestamp("RESOLVED");
                 int u_Id_Author = rs.getInt("U_ID_AUTHOR");
                 int u_Id_Resolver = rs.getInt("U_ID_RESOLVER");
                 
                 int rt_Type_Id = rs.getInt("RT_TYPE_ID");
                 int rs_Status_Id = rs.getInt("RS_STATUS_ID");
                                  
                 String encodedImage = Base64.getEncoder().encodeToString((receipt));
                
                 String author = getFLName(con, u_Id_Author);
                 String resolver = getFLName(con, u_Id_Resolver);
                 String type = getType(con, rt_Type_Id);
                 String status = getStatus(con, rs_Status_Id);
                                        
                 list.add(new Reimbursements(reimburse_ID, amount, description, encodedImage,submitted, resolved, author, resolver, type, status));
             }
            
     		return list;

//             con.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }	
		return list;

	}
	
	public String getStatus(Connection con, int rs_Status_Id) throws SQLException{
		PreparedStatement pStatement;
		String status = null;
		
        String sql1 = "SELECT RS_STATUS FROM REIMBURSEMENT_STATUS WHERE RS_ID = ?";
        
        pStatement = con.prepareStatement(sql1);

        pStatement.setInt(1, rs_Status_Id);
        
        ResultSet rsName = pStatement.executeQuery();
        
        if (rsName.next()){
        	status = rsName.getString("RS_STATUS");
        }
        
		return status;
	}
	
	public String getType(Connection con, int rt_Type_Id) throws SQLException{
		PreparedStatement pStatement;
		String type = null;
		
        String sql1 = "SELECT RT_TYPE FROM REIMBURSEMENT_TYPE WHERE RT_ID = ?";
        
        pStatement = con.prepareStatement(sql1);

        pStatement.setInt(1, rt_Type_Id);
        
        ResultSet rsName = pStatement.executeQuery();
        
        if (rsName.next()){
        	type = rsName.getString("RT_TYPE");
        }
        
		return type;
	}

	
	public String getFLName(Connection con, int u_Id_Author) throws SQLException{
		PreparedStatement pStatement;
		String author = null;
		
        String sql1 = "SELECT FIRSTNAME, LASTNAME FROM USERS WHERE U_ID = ? ";
        
        pStatement = con.prepareStatement(sql1);

        pStatement.setInt(1, u_Id_Author);
        
        ResultSet rsName = pStatement.executeQuery();
        
        if (rsName.next()){
        	author = rsName.getString("FIRSTNAME") + rsName.getString("LASTNAME");
        }
        
		return author;
	}
	
	@Override
	public boolean updateUser(int u_ID, String firstname, String lastname, String email, String password) {
        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {
        	String sql;
        	
        	if (password.length() != 0){
	        	sql = "UPDATE USERS SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PASSWORD = ? where U_ID= ?";
	            PreparedStatement pStatement = con.prepareStatement(sql);
	            pStatement.setString(1, firstname);
	            pStatement.setString(2, lastname);
	            pStatement.setString(3, email);
	            pStatement.setString(4, password);
	            pStatement.setInt(5, u_ID);
	            pStatement.executeUpdate();
        	} else {
	        	sql = "UPDATE USERS SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ? where U_ID= ?";
	            PreparedStatement pStatement = con.prepareStatement(sql);
	            pStatement.setString(1, firstname);
	            pStatement.setString(2, lastname);
	            pStatement.setString(3, email);
	            pStatement.setInt(4, u_ID);
	            pStatement.executeUpdate();
        	}
            
            con.close();
            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return false;
	}

	public boolean updateReimbursements(int reimburseInfo, int reimburseId, int userID){
		try(Connection con = ConnectionUtil.getConnection("connection.properties")) {
			
		    PreparedStatement pStatement;
			String sql = "SELECT U_ID_AUTHOR FROM REIMBURSEMENTS WHERE REIMBURSE_ID = ?";
            pStatement = con.prepareStatement(sql);
            pStatement.setInt(1, reimburseId);
            ResultSet rs = pStatement.executeQuery();

            if (rs.next()){
            	int reimburseAuthorId = rs.getInt("U_ID_AUTHOR");
            	
            	if (reimburseAuthorId != userID){
            		sql = "UPDATE REIMBURSEMENTS SET RESOLVED = ?, RS_STATUS_ID = ?, U_ID_RESOLVER = ? where REIMBURSE_ID = ?";
		            PreparedStatement pStatement1 = con.prepareStatement(sql);
		            pStatement1.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
		  
		            pStatement1.setInt(2, reimburseInfo);
		            pStatement1.setInt(3, userID);
		            pStatement1.setInt(4, reimburseId);
		            pStatement1.executeUpdate();
		          	
		            System.out.println("UPDATE REIMBURSEMENT SUCCESSFUL");
		            con.close();
		            return true;
            	}
                System.out.println("MANAGER CANNOT UPDATE THEIR OWN REIMBURSEMENTS");
	            con.close();
	            return false;
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
		
		return false;
	}
	
}
