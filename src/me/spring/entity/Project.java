package me.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_Project")
public class Project extends IDEntity {
	private static final long serialVersionUID = -5630710286287692113L;

	private String code;
	private String projectName;
	private String loginUserClass;
	private String description;

	public Project() {
		super();
	}

	public Project(String code, String projectName, String loginUserClass, String description) {
		super();
		this.code = code;
		this.projectName = projectName;
		this.loginUserClass = loginUserClass;
		this.description = description;
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
