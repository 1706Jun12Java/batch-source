package com.revature.model;

import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User model
 * <p>
 * Created by John on 6/24/2017.
 */
public class User
{
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User(int id, String firstName, String lastName, String username, String password)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static boolean authUser(String username, String password)
    {
        try(Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username.toLowerCase() );
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (!rs.next())
                return false;

        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }

        return true;
    }

    public static boolean isUsernameAvailable(String username)
    {
        try(Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username.toLowerCase() );

            ResultSet rs = ps.executeQuery();

            if (!rs.next())
            {
                connection.close();
                return true;
            }
        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
