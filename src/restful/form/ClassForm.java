package restful.form;

import javax.ws.rs.FormParam;

public class ClassForm {
	@FormParam("id")
	private int id;
	@FormParam("projectId")
	private int projectId;
	@FormParam("className")
	private String className;
	@FormParam("description")
	private String description;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ClassForm() {
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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
