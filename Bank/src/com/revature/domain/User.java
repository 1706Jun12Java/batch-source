package com.revature.domain;


public class User {
		private int userId;
		private String username;
		private String password;
		private String fname;
		private String lname;
		private String isSuperUser;
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User( String username, String password, String fname, String lname, String isSuperUser) {
			super();
			this.username = username;
			this.password = password;
			this.fname = fname;
			this.lname = lname;
			this.isSuperUser = isSuperUser;
		}
		
		public User(int userId, String username, String password, String fname, String lname, String isSuperUser) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
			this.fname = fname;
			this.lname = lname;
			this.isSuperUser = isSuperUser;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getIsSuperUser() {
			return isSuperUser;
		}
		public void setIsSuperUser(String isSuperUser) {
			this.isSuperUser = isSuperUser;
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", fname=" + fname
					+ ", lname=" + lname + ", isSuperUser=" + isSuperUser + "]";
		}
		
}
