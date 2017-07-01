package com.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.user.User;
import com.bank.util.ConnectionUtil;

public class UserSessionImpl {
	
	private boolean online = false;
    private User user = null;

    public void login(String username, String password) {
        PreparedStatement pStatement;

        try (Connection con = ConnectionUtil.getConnection("connection.properties")){

            String sql = "SELECT * FROM bank_user WHERE username = ? AND password = ?";
            pStatement = con.prepareStatement(sql);

            pStatement.setString(1,username);
            pStatement.setString(2,password);

            ResultSet rs = pStatement.executeQuery();
            if (rs.next()){

                int userID = rs.getInt("userID");
                String un = rs.getString("username");
                String email = rs.getString("email");
                int superUser = rs.getInt("superuser");
                this.user = new User(userID, un, email, superUser);
                this.online = true;

            } else {
                System.out.println("Wrong username or password!");
            }


        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void logout(){
        this.user = null;
        this.online = false;
        System.out.println("Logging out!");
    }



    public boolean isOnline() {
        return online;
    }

    public User getUser() {
        return user;
    }

}
