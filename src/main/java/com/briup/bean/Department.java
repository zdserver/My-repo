package com.briup.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 部门
 * */
@SequenceGenerator(sequenceName="dept_id_seq",name="dept_seq")
@Entity
@Table(name="department")
public class Department {
	@GeneratedValue(generator="dept_seq")
	@Id
	private Integer id;
	private String name;
	//部门描述
	private String description;
	//是否可以挂号
	private char status;
	
	public Department(){}

	public Department(Integer id, String name, String description, char status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description="
				+ description + ", status=" + status + "]";
	}
	
}
