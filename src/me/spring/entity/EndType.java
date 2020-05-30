package me.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_EndType")
public class EndType extends IDEntity {
	private static final long serialVersionUID = 3825416000721976454L;

	private String caption;
	private String description;

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
