package me.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_Application")
public class Application extends IDEntity {
	private static final long serialVersionUID = 351352633722138772L;

	private int projectId;

	private String appId;
	private String secretKey;
	private String description;

	public Application() {
		super();
	}

	public Application(int projectId, String appId, String secretKey, String description) {
		super();
		this.projectId = projectId;
		this.appId = appId;
		this.secretKey = secretKey;
		this.description = description;
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
