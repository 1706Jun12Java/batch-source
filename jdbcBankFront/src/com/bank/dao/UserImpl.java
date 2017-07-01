package com.bank.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.io.IOException;

import com.bank.user.Account;
import com.bank.user.User;
import com.bank.util.ConnectionUtil;

public class UserImpl implements UserDao{
	
	@Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {

            String sql = "SELECT * FROM BANK_USER";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("userID");
                String name = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int superUser = rs.getInt("superUser");
//                List<Transaction> transactions = ;
                userList.add(new User(id, name, password, email, superUser));
            }
            rs.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User getUserById(int id) {
        PreparedStatement pStatement;
        User user= null;

        try (Connection con = ConnectionUtil.getConnection("connection.properties")){
            String sql = "SELECT * FROM bank_user WHERE userid = ?";
            pStatement = con.prepareStatement(sql);
            pStatement.setInt(1,id);
            ResultSet rs = pStatement.executeQuery();

            while(rs.next()){
                int userID = rs.getInt("userID");
                String username = rs.getString("username");
                String email = rs.getString("email");
                int superUser = rs.getInt("superuser");
                user = new User(userID, username, email, superUser);
            }


        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean deleteAllUser(User user){
        if (user.getSuperUser() > 0){
            try(Connection con = ConnectionUtil.getConnection("connection.properties")) {
                String sql = "DELETE FROM account";
                PreparedStatement pStatement = con.prepareStatement(sql);
                pStatement.executeUpdate();

                sql = "DELETE FROM bank_user";

                pStatement = con.prepareStatement(sql);
                pStatement.executeUpdate();

                System.out.println("All users deleted");
                return true;
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(int user, String username, String password, String email){
        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {
            String sql = "update bank_user set username = ?, password = ?, email = ? where userid = ?";


            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setString(1, username);
            pStatement.setString(2, password);
            pStatement.setString(3, email);
            pStatement.setInt(4, user);
            pStatement.executeUpdate();

            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean createUser(String username, String password, String email) {

        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {
            String sql = "INSERT INTO BANK_USER (username, password, email)"
                        + " VALUES(?,?,?)";

            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setString(1,username);
            pStatement.setString(2,password);
            pStatement.setString(3,email);
            if (pStatement.executeUpdate() > 0)
                return true;
            else
                return false;

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public void createAccount(User user) {

        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {
            String sql = "INSERT INTO ACCOUNT (balance, bank_user_id)"
                    + " VALUES(?,?)";

            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setInt(1, 0);
            pStatement.setInt(2, user.getUserID());
            pStatement.executeUpdate();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAccount(User user, int accountNumber){

        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {
            PreparedStatement pStatementGetBalance;

            String sqlBalance = "SELECT balance FROM account WHERE bank_user_id = ? AND accountid = ?";
            pStatementGetBalance = con.prepareStatement(sqlBalance);
            pStatementGetBalance.setInt(1, user.getUserID());
            pStatementGetBalance.setInt(2, accountNumber);

            ResultSet rs = pStatementGetBalance.executeQuery();

            if (rs.next() && rs.getInt("balance") == 0){
                String sql = "DELETE FROM ACCOUNT WHERE bank_user_id = ? AND accountid = ?";

                PreparedStatement pStatement = con.prepareStatement(sql);
                pStatement.setInt(1, user.getUserID());
                pStatement.setInt(2, accountNumber);
                pStatement.executeUpdate();
                System.out.println("Delete Successful!");
            } else {
                System.out.println("Balance is not empty or account doesn't belong to user");
            }

        } catch (IOException | SQLException e ) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Account> getAllBalances(User user) {
        List<Account> account = new ArrayList<>();
        PreparedStatement pStatement;

        try (Connection con = ConnectionUtil.getConnection("connection.properties")){
            String sql = "SELECT * FROM account WHERE bank_user_id = ?";
            pStatement = con.prepareStatement(sql);
            pStatement.setInt(1, user.getUserID());
            ResultSet rs = pStatement.executeQuery();

            while(rs.next()){
                int accountid = rs.getInt("accountid");
                int balance = rs.getInt("balance");
                int bank_user_id = rs.getInt("bank_user_id");
                account.add(new Account(accountid, balance, bank_user_id));
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public boolean withdraw(User user, int accountId, int withdraw){

        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {

            PreparedStatement pStatementWithdraw;

            String sqlBalance = "SELECT balance FROM account WHERE bank_user_id = ? AND accountid = ?";
            pStatementWithdraw = con.prepareStatement(sqlBalance);

            pStatementWithdraw.setInt(1, user.getUserID());
            pStatementWithdraw.setInt(2, accountId);
            ResultSet rs = pStatementWithdraw.executeQuery();

            while(rs.next()){

                if ( withdraw > 0 && rs.getInt("balance") >= withdraw) {

                    int difference = rs.getInt("balance") - withdraw;
                    String sql = "UPDATE account a1 set a1.balance = ? " +
                            "WHERE a1.bank_user_id = ? AND a1.accountid = ?";

                    PreparedStatement pStatement = con.prepareStatement(sql);
                    pStatement.setInt(1, difference);
                    pStatement.setInt(2, user.getUserID());
                    pStatement.setInt(3, accountId);
                    pStatement.executeUpdate();

//                    AccountDao displayAccount = new AccountImpl();
//                    System.out.println(displayAccount.getAccountID(accountId).toString());
                    return true;
                } else {
//                    System.out.println("Something went wrong withdrawing!");
                    return false;
                }
            }

            return false;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean deposit(User user, int accountId, int deposit){
        try(Connection con = ConnectionUtil.getConnection("connection.properties")) {

            PreparedStatement pStatementWithdraw;

            String sqlBalance = "SELECT balance FROM account WHERE bank_user_id = ? AND accountid = ?";
            pStatementWithdraw = con.prepareStatement(sqlBalance);

            pStatementWithdraw.setInt(1, user.getUserID());
            pStatementWithdraw.setInt(2, accountId);
            ResultSet rs = pStatementWithdraw.executeQuery();


            if (deposit > 0 && rs.next()){
                int newBalance = rs.getInt("balance") + deposit;
                String sql = "UPDATE account a1 set a1.balance = ? " +
                        "WHERE a1.bank_user_id = ? AND a1.accountid = ?";

                PreparedStatement pStatement = con.prepareStatement(sql);
                pStatement.setInt(1, newBalance);
                pStatement.setInt(2, user.getUserID());
                pStatement.setInt(3, accountId);
                pStatement.executeUpdate();

//                AccountDao displayAccount = new AccountImpl();
//                System.out.println(displayAccount.getAccountID(accountId).toString());
                return true;
            } else {
//                System.out.println("Something went wrong depositing money!");
                return false;
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}
