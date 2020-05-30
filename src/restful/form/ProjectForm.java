package restful.form;

import javax.ws.rs.FormParam;

public class ProjectForm {
	@FormParam("id")
	private int id;
	@FormParam("code")
	private String code;
	@FormParam("projectName")
	private String projectName;
	@FormParam("loginUserClass")
	private String loginUserClass;
	@FormParam("description")
	private String description;

	public ProjectForm() {
		super();
	}

	public ProjectForm(int id, String code, String projectName, String loginUserClass, String description) {
		super();
		this.id = id;
		this.code = code;
		this.projectName = projectName;
		this.loginUserClass = loginUserClass;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLoginUserClass() {
		return loginUserClass;
	}

	public void setLoginUserClass(String loginUserClass) {
		this.loginUserClass = loginUserClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
