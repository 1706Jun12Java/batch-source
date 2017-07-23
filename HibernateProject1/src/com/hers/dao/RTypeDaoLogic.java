package com.hers.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hers.util.HibernateUtil;

public class RTypeDaoLogic implements RTypeDao {

	@Override
	public int getIdOfType(String type) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("select id from ReimbursementTypeModel rtm where rtm.type=:type");
		query.setString("type", type);
		int typeId = (int) query.uniqueResult();
		return typeId;
		
//		int typeId = 0; 
//		String sql = "SELECT RT_ID FROM ERS_REIMBURSEMENT_TYPE WHERE RT_TYPE = ?";
//
//		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
//				PreparedStatement pstmt = con.prepareStatement(sql)){
//			pstmt.setString(1, type);
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next()) {
//				typeId = rs.getInt("RT_ID");
//			} else {
//				System.out.println("Something went wrong. Please try again.");
//			}
//		} catch (SQLException e){
//			e.printStackTrace();
//		} catch (IOException e){
//			e.printStackTrace();
//		}
//		return typeId;
	}

}
