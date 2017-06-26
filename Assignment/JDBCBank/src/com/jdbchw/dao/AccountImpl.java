package com.jdbchw.dao;

import com.jdbchw.domain.Account;
import com.jdbchw.domain.User;
import com.jdbchw.util.ConnectionUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements AccountDao{

    @Override
    public List<Account> getAccount() {
        List<Account> accounts = new ArrayList<>();

        try (Connection con = ConnectionUtil.getConnection("connections.properties")) {
            String sql = "SELECT * FROM ACCOUNT";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("accountID");
                double balance = rs.getDouble("balance");
                int bank_user_id = rs.getInt("bank_user_id");
                Account newAccount = new Account(id, balance, bank_user_id);
                accounts.add(newAccount);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public Account getAccountID(int id) {
        PreparedStatement pstmt;
        Account account = null;

        try (Connection con = ConnectionUtil.getConnection("connection.properties")){
            String sql = "SELECT * FROM Account WHERE accountID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Double balance = rs.getDouble("balance");
                int bank_user_id = rs.getInt("bank_user_id");
                account = new Account(id, balance, bank_user_id);
            }


        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
