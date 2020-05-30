package me.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_Class")
public class Class extends IDEntity {
	private static final long serialVersionUID = -8963780686126482762L;

	private int projectId;
	private String className;
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	private String description;

	public Class() {
		super();
	}

	public Class(int projectId, String className, String description) {
		super();
		this.projectId = projectId;
		this.className = className;
		this.description = description;
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
