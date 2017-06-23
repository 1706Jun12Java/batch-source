package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BearType;
import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class BearTypeDaoImpl implements BearTypeDao {

	public BearTypeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BearType> getBearTypes() {
		List<BearType> bt = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BEAR_TYPE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("BEAR_TYPE_ID");
				String name = rs.getString("BEAR_TYPE_NAME");
				BearType newBT = new BearType(id,name);
				bt.add(newBT);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bt;
	}

	@Override
	public BearType getBearTypeById(int id) {
		PreparedStatement pstmt = null;
		BearType bt = null;
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BEAR_TYPE WHERE BEAR_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("BEAR_TYPE_NAME");
				bt = new BearType(id,name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bt;
	}

}
