package com.revature.dao.oracle;

import com.revature.dao.ReimbursementTypeDao;
import com.revature.models.ReimbursementType;
import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by John on 7/12/2017.
 */
public class ReimbursementTypeOracleDao implements ReimbursementTypeDao
{
    private Connection connection = ConnectionUtil.getConnection();

    public ReimbursementTypeOracleDao() throws IOException, SQLException
    {
    }

    @Override
    public boolean addReimbursementType(String type)
    {
        int result;

        try
        {
            String sql = "INSERT INTO REIMBURSEMENT_TYPE (TYPE) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, type);

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

    @Override
    public ReimbursementType getReimbursementTypeById(int id)
    {
        // TODO
        return null;
    }
}
