package com.revature.dao.oracle;

import com.revature.dao.UserDao;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserOracleDao implements UserDao
{
    private Connection connection = ConnectionUtil.getConnection();

    public UserOracleDao() throws IOException, SQLException
    {

    }

    /**
     * Creates a new Employee user in the database.
     *
     * @param username  unique username
     * @param password  case-sensitive password (will be hashed)
     * @param email     A email to be contacted by (optional)
     * @param firstName a string containing a name
     * @param lastName  a string containing a last name
     * @param role The role that they will be assign too
     * @return a user object
     */
    @Override
    public User createUser(String username, String password, String email, String firstName, String lastName, int role) throws SQLException
    {
        int result = 0;
        try
        {
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, USER_ROLE_ID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username.toLowerCase());
            ps.setString(2, UserDao.hashPassword(password));
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, email);
            ps.setInt(6, role);

            result = ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        if (result == 0)
            return null;

        return getUserByUsername(username);
    }

    /**
     * Helper method to return a user that is new to the database with all of its values
     *
     * @param username a unique username
     * @return the user object
     */
    @Override
    public User getUserByUsername(String username) throws SQLException
    {
        try
        {
            String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username.toLowerCase());
            ResultSet rs = ps.executeQuery();

            if (!rs.next())
            {
                connection.close();
                return null;
            }

            return new User(rs.getInt("ID"), rs.getString("username"),
                    rs.getString("password"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"), rs.getInt("user_role_id"));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            connection.close();
        }

        return null;
    }

    /**
     * Get all users from the database
     *
     * @return a list of users
     */
    @Override
    public ArrayList<User> getUsers()
    {
        ArrayList<User> userList = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM USERS";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next())
                userList.add(new User(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getString("email"),
                        resultSet.getInt("user_role_id")));

            connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * Get a user from the database with that id.
     *
     * @param id the id of the user
     * @return If found, a user. Otherwise, null
     */
    @Override
    public User getUserById(int id) throws SQLException
    {
        try
        {
            String sql = "SELECT * FROM USERS WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next())
            {
                connection.close();
                return null;
            }

            return new User(rs.getInt("ID"), rs.getString("username"),
                    rs.getString("password"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"), rs.getInt("user_role_id"));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            connection.close();
        }

        return null;
    }

    /**
     * Delete a user with that id.
     *
     * @param id The id of a user
     * @return True if successful. Otherwise, false.
     */
    @Override
    public boolean deleteUser(int id)
    {
        int result;
        try
        {
            String sql = "DELETE FROM USERS WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);
            result = ps.executeUpdate();
            connection.close();

            if (result != 0)
                return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Authorize a user by checking their credentials.
     *
     * @param username a string
     * @param password a string
     * @return Return a User if match. Otherwise, null.
     */
    @Override
    public User auth(String username, String password) throws SQLException
    {
        try
        {
            String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username.toLowerCase());

            ResultSet rs = ps.executeQuery();

            if (!rs.next())
            {
                connection.close();
                return null;
            }

            if (!UserDao.checkPassword(password, rs.getString("password")) )
            {
                connection.close();
                return null;
            }

            return new User(rs.getInt("ID"), rs.getString("username"),
                    rs.getString("password"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"), rs.getInt("user_role_id"));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            connection.close();
        }

        return null;
    }
}
