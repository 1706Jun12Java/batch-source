package com.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.user.Users;
import com.bank.util.ConnectionUtil;

public class UserSessionImpl {
	private boolean online = false;
    private Users users = null;

    public void login(String username, String password) {
        PreparedStatement pStatement;

        try (Connection con = ConnectionUtil.getConnection("connection.properties")){

            String sql = "SELECT * FROM USERS WHERE username = ? AND password = ?";
            pStatement = con.prepareStatement(sql);

            pStatement.setString(1,username);
            pStatement.setString(2,password);

            ResultSet rs = pStatement.executeQuery();
            if (rs.next()){

                int id = rs.getInt("U_ID");
                String username1 = rs.getString("USERNAME");
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
                    this.users = new Users(id, username1, firstName, lastName, email, role);
                    this.online = true;
                } else {
                    System.out.println("Wrong username or password!");
                }
                rs.close();
                con.close();
            } else {
                System.out.println("Wrong username or password!");
            }


        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void logout(){
        this.users = null;
        this.online = false;
        System.out.println("Logging out!");
    }

    public boolean isOnline() {
        return online;
    }

    public Users getUser() {
        return users;
    }
}
