package com.hers.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hers.domain.UserRoleModel;
import com.hers.util.HibernateUtil;

public class UserRoleDaoLogic implements UserRoleDao {

	@Override
	public UserRoleModel getRole(String role) {
//		int roleId = 0;
//		String sql = "SELECT UR_ID FROM ERS_USER_ROLES WHERE UR_ROLE = ?";
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("select * from UserRoleModel urm where urm.role=:role");
		query.setString("role", role);
		UserRoleModel userRole = (UserRoleModel) query.uniqueResult();
		return userRole;
		

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
