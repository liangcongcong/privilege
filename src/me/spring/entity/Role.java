package me.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_Role")
public class Role extends IDEntity {
	private static final long serialVersionUID = -8963780686126482762L;

	private int projectId;
	private String role;
	private String description;

	public Role() {
		super();
	}

	public Role(int projectId, String role, String description) {
		super();
		this.projectId = projectId;
		this.role = role;
		this.description = description;
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
