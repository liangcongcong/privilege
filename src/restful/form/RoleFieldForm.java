package restful.form;

import javax.ws.rs.FormParam;

public class RoleFieldForm {
	@FormParam("id")
	private int id;
	@FormParam("projectId")
	private int projectId;
	@FormParam("fieldName")
	private String fieldName;
	@FormParam("fieldType")
	private String fieldType;
	@FormParam("description")
	private String description;

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

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
