package com.revature.domain;

public class User {
	
	private int uid;
	private String uusername;
	private String upassword;
	private String ufirstname;
	private String ulastname;
	private String uemail;
	private int urid;
	private String urole;
	
	public User(int uid, String uusername, String upassword, String ufirstname, String ulastname, String uemail,
			int urid, String urole) {
		super();
		this.uid = uid;
		this.uusername = uusername;
		this.upassword = upassword;
		this.ufirstname = ufirstname;
		this.ulastname = ulastname;
		this.uemail = uemail;
		this.urid = urid;
		this.urole = urole;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uusername=" + uusername + ", upassword=" + upassword + ", ufirstname="
				+ ufirstname + ", ulastname=" + ulastname + ", uemail=" + uemail + ", urid=" + urid + ", urole=" + urole + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUusername() {
		return uusername;
	}

	public void setUusername(String uusername) {
		this.uusername = uusername;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUfirstname() {
		return ufirstname;
	}

	public void setUfirstname(String ufirstname) {
		this.ufirstname = ufirstname;
	}

	public String getUlastname() {
		return ulastname;
	}

	public void setUlastname(String ulastname) {
		this.ulastname = ulastname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public int getUrid() {
		return urid;
	}

	public void setUrid(int urid) {
		this.urid = urid;
	}
	
	public String getUrole() {
		return urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}
}
