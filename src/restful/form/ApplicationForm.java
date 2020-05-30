package restful.form;

import javax.ws.rs.FormParam;

public class ApplicationForm {
	@FormParam("id")
	private int id;

	@FormParam("projectId")
	private int projectId;

	@FormParam("appId")
	private String appId;
	@FormParam("secretKey")
	private String secretKey;
	@FormParam("description")
	private String description;

	public ApplicationForm() {
		super();
	}

	public ApplicationForm(int id, int projectId, String appId, String secretKey, String description) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.appId = appId;
		this.secretKey = secretKey;
		this.description = description;
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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
