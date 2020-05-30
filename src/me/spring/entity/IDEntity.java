package me.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class IDEntity implements Serializable {
	private static final long serialVersionUID = 445765926623315674L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int id;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
