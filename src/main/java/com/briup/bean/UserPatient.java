package com.briup.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 挂号
 * */
@Entity
@Table(name="userpatient")
public class UserPatient {
	@Id
	@GeneratedValue
	private Integer id;
	//挂号费
	private double price;
	//是否会诊
	private String status;
	//症状
	private String symptom;
	//医生建议
	private String advice;
	//病人主诉
	private String complained;
	//既往史
	@Column(name="pastmedicalhistory")
	private String pastMedicalHistory;
	//现病史
	@Column(name="historyofpresentillness")
	private String historyOfPresentIllness;
	//检查结果
	@Column(name="physicalexamresult")
	private String physicalExamResult;
	@JoinColumn(name="user_id")
	@ManyToOne
	private User user;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@JoinColumn(name="patient_id")
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Patient patient;
	public UserPatient(){}

	public UserPatient(Integer id, double price, String status, String symptom,
			String advice, String complained, String pastMedicalHistory,
			String historyOfPresentIllness, String physicalExamResult, Date date) {
		super();
		this.id = id;
		this.price = price;
		this.status = status;
		this.symptom = symptom;
		this.advice = advice;
		this.complained = complained;
		this.pastMedicalHistory = pastMedicalHistory;
		this.historyOfPresentIllness = historyOfPresentIllness;
		this.physicalExamResult = physicalExamResult;
		this.date = date;
	}



	public UserPatient(Integer id, double price, String status, String symptom,
			String advice, User user, Patient patient) {
		super();
		this.id = id;
		this.price = price;
		this.status = status;
		this.symptom = symptom;
		this.advice = advice;
		this.user = user;
		this.patient = patient;
	}
	
	public String getComplained() {
		return complained;
	}

	public void setComplained(String complained) {
		this.complained = complained;
	}

	public String getPastMedicalHistory() {
		return pastMedicalHistory;
	}

	public void setPastMedicalHistory(String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}

	public String getHistoryOfPresentIllness() {
		return historyOfPresentIllness;
	}

	public void setHistoryOfPresentIllness(String historyOfPresentIllness) {
		this.historyOfPresentIllness = historyOfPresentIllness;
	}

	public String getPhysicalExamResult() {
		return physicalExamResult;
	}

	public void setPhysicalExamResult(String physicalExamResult) {
		this.physicalExamResult = physicalExamResult;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	/*@Override
	public String toString() {
		return "UserPatient [id=" + id + ", price=" + price + ", status="
				+ status + ", symptom=" + symptom + ", advice=" + advice + "]";
	}*/

	@Override
	public String toString() {
		return "UserPatient [id=" + id + ", price=" + price + ", status=" + status + ", symptom=" + symptom
				+ ", advice=" + advice + ", complained=" + complained + ", pastMedicalHistory=" + pastMedicalHistory
				+ ", historyOfPresentIllness=" + historyOfPresentIllness + ", physicalExamResult=" + physicalExamResult
				+ ", user=" + user + ", date=" + date + ", patient=" + patient + "]";
	}
	
	
}
