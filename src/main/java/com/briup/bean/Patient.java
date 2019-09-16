package com.briup.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 病人
 * */
@Entity
@SequenceGenerator(sequenceName="patient_id_seq",name="pat_seq")
public class Patient {
	@Id
	@GeneratedValue(generator="pat_seq")
	private Integer id;
	private String name;
	private int age;
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	private String merriage;
	private String address;
	@Column(name="drugallergy")
	private String drugAllergy;
	//private String cardNo;
	@Column(name="cardno")
	private String cardNo;
	private double balance;
	//private List<User> users;
	public Patient(){}
	
	
	public Patient(Integer id, String name, int age, String gender, Date birth,
			String merriage, String address, String drugAllergy, String cardNo,
			double balance) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birth = birth;
		this.merriage = merriage;
		this.address = address;
		this.drugAllergy = drugAllergy;
		this.cardNo = cardNo;
		this.balance = balance;
	}


	/*public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}*/


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMerriage() {
		return merriage;
	}

	public void setMerriage(String merriage) {
		this.merriage = merriage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDrugAllergy() {
		return drugAllergy;
	}

	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", birth=" + birth + ", merriage="
				+ merriage + ", address=" + address + ", drugAllergy="
				+ drugAllergy + ", cardNo=" + cardNo + ", balance=" + balance
				+ "]";
	}
	
}
