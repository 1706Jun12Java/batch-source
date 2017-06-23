package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Bear;
import com.revature.domain.BearType;
import com.revature.domain.Beehive;
import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class BearDaoImpl implements BearDao {

	public BearDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<>();
		CaveDaoImpl cdi = new CaveDaoImpl();
		BearTypeDaoImpl btdi = new BearTypeDaoImpl();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BEAR";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("BEAR_ID");
				String name = rs.getString("BEAR_NAME");
				int weight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Cave cave = cdi.getCaveById(caveId);
				int typeId = rs.getInt("BEAR_TYPE_ID");
				BearType bt = btdi.getBearTypeById(typeId);
				Date birthdate = rs.getDate("BEAR_BIRTHDATE");
				bl.add(new Bear(id,name,cave,bt,weight,birthdate));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public Bear getBearById(int id) {
		PreparedStatement pstmt = null;
		CaveDaoImpl cdi = new CaveDaoImpl();
		BearTypeDaoImpl btdi = new BearTypeDaoImpl();
		Bear bear = null;
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("BEAR_NAME");
				int weight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Cave cave = cdi.getCaveById(caveId);
				int typeId = rs.getInt("BEAR_TYPE_ID");
				BearType bt = btdi.getBearTypeById(typeId);
				Date birthdate = rs.getDate("BEAR_BIRTHDATE");
				bear = new Bear(id,name,cave,bt,weight,birthdate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bear;
	}

	@Override
	public int createBear(Bear bear) {
		int bearsCreated = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false); //manual tx management
			String sql = "INSERT INTO BEAR (BEAR_TYPE_ID,BEAR_NAME,BEAR_BIRTHDATE,BEAR_WEIGHT,CAVE_ID)"
					+" VALUES(?,?,?,DEFAULT,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bear.getBearType().getId());
			pstmt.setString(2,bear.getName());
			pstmt.setDate(3,bear.getBirthdate());
			pstmt.setInt(4,bear.getCave().getId());
			bearsCreated = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return bearsCreated;
	}

	@Override
	public int feedBear(int bearId, int hiveId, int amt) {
		int amtFed = 0;
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "{call SP_FEED_BEAR(?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, bearId);
			cs.setInt(2, hiveId);
			cs.setInt(3, amt);
			cs.registerOutParameter(4, java.sql.Types.INTEGER);
			cs.execute();
			amtFed = cs.getInt(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return amtFed;
	}

}
