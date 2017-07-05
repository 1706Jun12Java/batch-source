package com.revature.DAO;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access for Accounts
 * <p>
 * Created by John on 6/24/2017.
 */
public class AccountController implements AccountDAO
{
    /**
     * Creates a new account for a specific client. A client can only have of each accountType and will return null if
     * there's already an account of that type.
     *
     * @param userID      the id of the user
     * @param accountType the type of account the user would like to create
     * @return the newly created account
     */
    @Override
    public Account createAccount(int userID, int accountType)
    {
        int result = 0;

        try (Connection con = ConnectionUtil.getConnection())
        {
            if (isTypeAvailable(userID, accountType))
            {

                String sql = "INSERT INTO ACCOUNT (BALANCE, USER_ID, ACCOUNT_TYPE_ID) VALUES (DEFAULT , ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, userID);
                ps.setInt(2, accountType);

                result = ps.executeUpdate();
            } else
                return null;
        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }

        if (result == 0)
            return null;

        return getAccountById(userID, accountType);
    }


    @Override
    public Account getAccountById(int userID, int accountType)
    {
        try (Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM ACCOUNT WHERE USER_ID = ? AND ACCOUNT_TYPE_ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, accountType);

            ResultSet rs = ps.executeQuery();

            if (!rs.next())
                return null;

            User user = new UserController().getUserById(userID);

            return new Account(rs.getInt("ID"), accountType, user, rs.getInt("BALANCE"));
        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> getAccounts(int userId)
    {
        try (Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM ACCOUNT WHERE USER_ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            ArrayList<Account> accounts = new ArrayList<>();

            User user = new UserController().getUserById(userId);

            while (rs.next())
                accounts.add(new Account(rs.getInt("ID"), rs.getInt("ACCOUNT_TYPE_ID"), user, rs.getInt("BALANCE")));

            return accounts;
        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isTypeAvailable(int userId, int accountType)
    {
        int rows;
        try (Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "SELECT COUNT(ACCOUNT_TYPE_ID) AS available FROM ACCOUNT WHERE USER_ID = ? AND ACCOUNT_TYPE_ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, accountType);

            ResultSet rs = ps.executeQuery();
            rs.next();

            rows = rs.getInt("available");

            if (rows == 0)
                return true;

        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deposit(int amount, int userId, int accountType)
    {
        int result = 0;
        try (Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE USER_ID = ? AND ACCOUNT_TYPE_ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, userId);
            ps.setInt(3, accountType);

            result = ps.executeUpdate();

        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }

        return result != 0;
    }

    @Override
    public int withdraw(int amount, int userId, int accountType)
    {
        int result = 0;

        try (Connection connection = ConnectionUtil.getConnection())
        {

            String sql = "SELECT BALANCE FROM ACCOUNT WHERE USER_ID = ? AND ACCOUNT_TYPE_ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, accountType);

            ResultSet rs = ps.executeQuery();

            rs.next();
            if (rs.getInt("balance") - amount < 0)
                return -1;

            String updateSql = "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE USER_ID = ? AND ACCOUNT_TYPE_ID = ?";
            ps = connection.prepareStatement(updateSql);
            ps.setInt(1, amount);
            ps.setInt(2, userId);
            ps.setInt(3, accountType);

            result = ps.executeUpdate();

        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }

        if (result == 0)
            return -1;

        return amount;
    }

    @Override
    public boolean deleteAccount(int userId, int accountType)
    {
        int result;

        try (Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "SELECT BALANCE FROM ACCOUNT WHERE USER_ID = ? AND ACCOUNT_TYPE_ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, accountType);

            ResultSet rs = ps.executeQuery();
            rs.next();

            if (rs.getInt("balance") == 0)
            {
                String deleteSQL = "DELETE FROM ACCOUNT WHERE USER_ID = ? AND ACCOUNT_TYPE_ID = ?";
                ps = connection.prepareStatement(deleteSQL);

                ps.setInt(1, userId);
                ps.setInt(2, accountType);

                result = ps.executeUpdate();

                if (result != 0)
                    return true;
            }

        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
