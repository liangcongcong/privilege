package restful.form;

import javax.ws.rs.FormParam;

public class ClassFieldForm {
	@FormParam("id")
	private int id;
	@FormParam("classId")
	private int classId;
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
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
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
