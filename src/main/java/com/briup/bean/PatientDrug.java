package com.briup.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 处方类
 * */
@Entity
public class PatientDrug {
	@Id
	private Integer id;
	private double cost;
	@JoinColumn(name="patient_id")
	@ManyToOne
	private Patient patient;
	@JoinColumn(name="drug_id")
	@ManyToOne
	private Drug drug;
	private int num;
	
	public PatientDrug(){}
	public PatientDrug(Integer id, double cost, int num) {
		super();
		this.id = id;
		this.cost = cost;
		this.num = num;
	}

	public PatientDrug(Integer id, double cost, Patient patient, Drug drug) {
		super();
		this.id = id;
		this.cost = cost;
		this.patient = patient;
		this.drug = drug;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	@Override
	public String toString() {
		return "PatientDrug [id=" + id + ", cost=" + cost + "]";
	}
	
}
