package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BearType;
import com.revature.domain.Beehive;
import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class BeehiveDaoImpl implements BeehiveDao {

	public BeehiveDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Beehive> getBeehives() {
		List<Beehive> bh = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BEEHIVE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("BEEHIVE_ID");
				int weight = rs.getInt("BEEHIVE_WEIGHT");
				Beehive newB = new Beehive(id,weight);
				bh.add(newB);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bh;
	}

	@Override
	public Beehive getBeehiveById(int id) {
		PreparedStatement pstmt = null;
		Beehive beehive = null;
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BEEHIVE WHERE BEEHIVE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int weight = rs.getInt("BEEHIVE_WEIGHT");
				beehive = new Beehive(id,weight);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beehive;
	}

	@Override
	public boolean updateBeehiveWeight(int id, int diff) {
		Connection con = null;
		try{
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false); //manual tx management
			String sql = "UPDATE BEEHIVE SET BEEHIVE_WEIGHT = BEEHIVE_WEIGHT + ? WHERE BEEHIVE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,diff);
			pstmt.setInt(2,id);
			if(pstmt.executeUpdate() == 1){
				con.commit();
				return true;
			} else {
				con.rollback();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}

}
