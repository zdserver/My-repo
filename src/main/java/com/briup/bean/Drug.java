package com.briup.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 药品
 * */
@Entity
public class Drug {
	@Id
	@GeneratedValue
	private Integer id;
	//二维码
	private String barcode;
	private String name;
	//药品功能描述
	private String description;
	//制剂，如片剂，胶囊剂，浸出剂
	private String dosageform;
	//药品的规格
	private String	specifications;
	//药品单位
	private String unit;
	//药品进货价
	private double prime_cost;
	//药品销售价
	private double  price;
	//库存量
	private int inventory;
	//当库存量小于这个值时，提醒药房需要采购
	private int minimum;
	@JoinColumn(name="category_id")
	@ManyToOne
	private Category category;
	
	public Drug(){}

	public Drug(Integer id, String barcode, String name, String description,
			String dosageform, String specifications, String unit,
			double prime_cost, double price, int inventory, int minimum) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.dosageform = dosageform;
		this.specifications = specifications;
		this.unit = unit;
		this.prime_cost = prime_cost;
		this.price = price;
		this.inventory = inventory;
		this.minimum = minimum;
	}

	public Drug(Integer id, String barcode, String name, String description,
			String dosageform, String specifications, String unit,
			double prime_cost, double price, int inventory, int minimum,
			Category category) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.dosageform = dosageform;
		this.specifications = specifications;
		this.unit = unit;
		this.prime_cost = prime_cost;
		this.price = price;
		this.inventory = inventory;
		this.minimum = minimum;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
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

	public String getDosageform() {
		return dosageform;
	}

	public void setDosageform(String dosageform) {
		this.dosageform = dosageform;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrime_cost() {
		return prime_cost;
	}

	public void setPrime_cost(double prime_cost) {
		this.prime_cost = prime_cost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Drug [id=" + id + ", barcode=" + barcode + ", name=" + name
				+ ", description=" + description + ", dosageform=" + dosageform
				+ ", specifications=" + specifications + ", unit=" + unit
				+ ", prime_cost=" + prime_cost + ", price=" + price
				+ ", inventory=" + inventory + ", minimum=" + minimum + "]";
	}
	
}
