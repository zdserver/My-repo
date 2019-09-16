package com.briup.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 检查项目
 * */
@Entity
public class PhysicalExam {
	@Id
	private Integer id;
	private String name;
	private double price;
	public PhysicalExam(){}
	public PhysicalExam(Integer id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "PhysicalExam [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}
	
}
