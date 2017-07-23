package com.hers.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hers.util.HibernateUtil;

public class RStatusDaoLogic implements RStatusDao {

	@Override
	public int getIdOfStatus(String status) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("select id from ReimbursementStatusModel rsm where rsm.status=:status");
		query.setString("status", status);
		int statusId = (int) query.uniqueResult();
		return statusId;
	}
	

//	@Override
//	public int getIdOfStatus(String status) {
//		int statusId = 0;
//		String sql = "SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS = ?";
//
//		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
//				PreparedStatement pstmt = con.prepareStatement(sql)){
//			pstmt.setString(1, status);
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next()) {
//				statusId = rs.getInt("RS_ID");
//			} else {
//				System.out.println("Something went wrong. Please try again.");
//			}
//		} catch (SQLException e){
//			e.printStackTrace();
//		} catch (IOException e){
//			e.printStackTrace();
//		}
//		return statusId;
//	}
}
