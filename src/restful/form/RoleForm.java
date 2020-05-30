package restful.form;

import javax.ws.rs.FormParam;

public class RoleForm {
	@FormParam("id")
	private int id;
	@FormParam("projectId")
	private int projectId;
	@FormParam("role")
	private String role;
	@FormParam("description")
	private String description;

	public RoleForm() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
