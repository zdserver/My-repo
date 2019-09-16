package com.briup.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 员工
 * */
@SequenceGenerator(sequenceName="user_id_seq",name="user_seq")
@Entity
@Table(name="users")
public class User {
	//员工号
	@Id
	@GeneratedValue(generator="user_seq")
	private Integer id;
	//员工真实姓名
	private String name;
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	private String phone;
	private String address;
	//省份证号
	private String card;
	//学历
	private String education;
	//级别
	private String position;
	//专业
	private String professional;
	//用户名
	@Column(name="username")
	private String userName;
	//密码
	private String password;
	@JoinColumn(name="department_id")
	@ManyToOne
	private Department department;
	@JoinColumn(name="role_id")
	@ManyToOne
	private Role role;
	public User(){}
	
	public User(Integer id, String name, String gender, Date birth,
			String phone, String address, String card, String education,
			String position, String professional, String userName,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
		this.card = card;
		this.education = education;
		this.position = position;
		this.professional = professional;
		this.userName = userName;
		this.password = password;
	}

	public User(Integer id, String name, String gender, Date birth,
			String phone, String address, String card, String education,
			String position, String professional, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
		this.card = card;
		this.education = education;
		this.position = position;
		this.professional = professional;
		this.department = department;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", birth=" + birth + ", phone=" + phone
				+ ", address=" + address + ", card=" + card + ", education=" + education + ", position=" + position
				+ ", professional=" + professional + ", userName=" + userName + ", password=" + password
				+ ", department=" + department + ", role=" + role + "]";
	}
	
	/*@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", birth=" + birth + ", phone=" + phone + ", address="
				+ address + ", card=" + card + ", education=" + education
				+ ", position=" + position + ", professional=" + professional
				+ "]";
	}*/
	
	
}
