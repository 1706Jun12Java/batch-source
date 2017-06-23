package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDaoImpl implements CaveDao {

	public CaveDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cave> getCaves() {
		List<Cave> caves = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM CAVE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				Cave c = new Cave(id,name,maxBears);
				caves.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caves;
	}

	@Override
	public Cave getCaveById(int id) {
		PreparedStatement pstmt = null;
		Cave cave = null;
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM CAVE WHERE CAVE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("CAVE_NAME");
				int maxB = rs.getInt("MAX_BEARS");
				cave = new Cave(id,name,maxB);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cave;
	}

}
