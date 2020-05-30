package restful.form;

import javax.ws.rs.FormParam;

public class UserForm {
	@FormParam("id")
	private int id;
	@FormParam("username")
	private String username;
	@FormParam("password")
	private String password;
	@FormParam("realname")
	private String realname;
	@FormParam("isAdmin")
	private boolean isAdmin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
