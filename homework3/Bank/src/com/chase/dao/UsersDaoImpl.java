package com.chase.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.chase.domain.*;
import com.chase.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao  {

	@Override
	public List<Users> getUser() {
		List<Users> user = new ArrayList<>();
		UserTypeDaoImpl uti = new UserTypeDaoImpl();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			
			String sql = "SELECT * FROM USERS";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
                int id = rs.getInt("USER_ID");
                int utid = rs.getInt("USER_TYPE_ID");
                UserType userType = uti.getUserTypeById(utid);
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String phoneNum = rs.getString("PHONE_NUM");
                String email = rs.getString("EMAIL");
                user.add(new Users(id, userType, firstName, lastName , phoneNum, email));
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Users getUserById(int id) {
		UserTypeDaoImpl uti = new UserTypeDaoImpl();
		PreparedStatement pstmt = null;
		Users user = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM USER WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
                UserType userType = uti.getUserTypeById(id);
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String phoneNum = rs.getString("PHONE_NUM");
                String email = rs.getString("EMAIL");
                user = new Users(id, userType, firstName, lastName , phoneNum, email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return user;
		
	}

	@Override
	public void createUser(Scanner scan) {
		int usersCreated = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "INSERT INTO USERS (USER_TYPE_ID,FIRSTNAME,LASTNAME,PHONE_NUM,EMAIL)"
					+" VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,scan.nextInt());
			pstmt.setString(2,scan.next());
			pstmt.setString(3,scan.next());
			pstmt.setString(4,scan.next());
			pstmt.setString(4,scan.next());
			usersCreated = pstmt.executeUpdate();
			if (usersCreated > 0){
				System.out.println("Registration complete");
			}
			else{
				System.out.println("Failed to register");
				}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(Users user,int accountNum) {
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
            PreparedStatement ps;

            String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ? AND CURRENT_BALANCE = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, accountNum);

            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getInt("currentBalance") == 0){
                String sql2 = "DELETE FROM ACCOUNT WHERE BANK_ACCOUNT_ID = ? ";

                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, user.getId());
                ps2.executeUpdate();
                System.out.println("Delete Successful!");
            }
		}
		catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void withdraw(int userId,int bankAccountId,int amount) {
		CallableStatement cs;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "{call WITHDRAWL(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, userId);
			cs.setInt(2, bankAccountId);
			cs.setInt(3, amount);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("You withdrew $"+amount);
	}

	@Override
	public void deposit(int userId,int bankAccountId,int amount) {
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "{call DEPOSIT(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, userId);
			cs.setInt(2, bankAccountId);
			cs.setInt(3, amount);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("You deposited $"+amount);
	}

	@Override
	public void createBankAccount(double amount) {
        try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
            String sql = "INSERT INTO BANK_ACCOUNT (CURRENT_BALANCE) VALUES(?)";

            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setDouble(1,amount);
            pStatement.executeUpdate();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
		System.out.println("New account created.");
	}



	
	
}
