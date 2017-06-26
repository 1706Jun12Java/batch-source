package Assignment2.DAO;

import Assignment2.model.User;
import Assignment2.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by John on 6/24/2017.
 */
public class UserController implements UserDAO
{


    @Override
    public User createUser(String fName, String lName, String username, String password)
    {
        int result = 0;
        try(Connection con = ConnectionUtil.getConnection() )
        {
            String sql = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, username.toLowerCase());
            ps.setString(4, password);

            result = ps.executeUpdate();

        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }

        if (result == 0)
            return null;

        return getUserByUsername(username);
    }

    @Override
    public User getUserByUsername(String username)
    {
        try(Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username.toLowerCase() );
            ResultSet rs = ps.executeQuery();

            if (!rs.next() )
                return null;

            return new User(rs.getInt("ID"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("username"),
                    rs.getString("password") );

        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUserById(int userId)
    {
        try(Connection connection = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM USERS WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (!rs.next() )
                return null;

            return new User(rs.getInt("ID"), rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"), rs.getString("USERNAME"),
                    rs.getString("PASSWORD") );

        } catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
