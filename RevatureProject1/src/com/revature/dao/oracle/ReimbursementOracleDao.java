package com.revature.dao.oracle;

import com.revature.dao.ReimbursementDao;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * Created by John on 7/14/2017.
 */
public class ReimbursementOracleDao implements ReimbursementDao
{
    private Connection connection = ConnectionUtil.getConnection();

    public ReimbursementOracleDao() throws IOException, SQLException
    {
    }

    @Override
    public Boolean createReimbursement(int amount, String description, InputStream image, int author, int type)
    {
        int result = 0;
        int pendingStatus = 1;
        Date now = Calendar.getInstance().getTime();
        Timestamp timestamp = new Timestamp(now.getTime() );

        try
        {
            String sql = "INSERT INTO REIMBURSEMENT (AMOUNT, DESCRIPTION, RECEIPT, AUTHOR_ID, TYPE_ID, STATUS_ID, SUBMITTED) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, amount);
            ps.setString(2, description);
            ps.setBlob(3, image);
            ps.setInt(4, author);
            ps.setInt(5, type);
            ps.setInt(6, pendingStatus);
            ps.setTimestamp(7, timestamp);

            result = ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result != 0;
    }

    @Override
    public Reimbursement getReimbursementById(int id)
    {
        return null;
    }

    @Override
    public ArrayList<Reimbursement> getAllReimbursement()
    {
        String sql = "SELECT * FROM REIMBURSEMENT";
        ArrayList<Reimbursement> list = new ArrayList<>();

        try
        {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
                list.add(new Reimbursement(rs.getInt("id"), rs.getInt("amount"), rs.getString("description"), rs.getBlob("receipt"),
                        rs.getTimestamp("submitted"), rs.getTimestamp("resolved"),
                        rs.getInt("author_id"), rs.getInt("resolver_id"),
                        rs.getInt("type_id"), rs.getInt("status_id")) );

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return list;
    }


}
