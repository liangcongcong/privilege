package me.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_User")
public class User extends IDEntity {
	private static final long serialVersionUID = -1787546661296683699L;

	private String username;
	private String password;
	private String realname;
	private boolean isAdmin;

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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	

}
