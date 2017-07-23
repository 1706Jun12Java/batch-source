package com.hers.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import com.hers.util.HibernateUtil;

public class UserRoleDaoLogic implements UserRoleDao {

	@Override
	public int getIdOfRole(String role) {
//		int roleId = 0;
//		String sql = "SELECT UR_ID FROM ERS_USER_ROLES WHERE UR_ROLE = ?";
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("select id from UserRoleModel urm where urm.role=:role");
		query.setString("role", role);
		int roleId = (int) query.uniqueResult();
		return roleId;
		

//		try(Connection con = HibernateUtil.getConnectionFromFile("connection.properties");
//				PreparedStatement pstmt = con.prepareStatement(sql)){
//			pstmt.setString(1, role);
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next()) {
//				roleId = rs.getInt("UR_ID");
//			} else {
//				System.out.println("Something went wrong. Please try again.");
//			}
//		} catch (SQLException e){
//			e.printStackTrace();
//		} catch (IOException e){
//			e.printStackTrace();
//		}
//		return roleId;
	}

}
