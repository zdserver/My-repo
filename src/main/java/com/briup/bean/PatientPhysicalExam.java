package com.briup.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 化验单
 * */
@Entity
public class PatientPhysicalExam {
	@Id
	private Integer id;
	private double cost;
	@JoinColumn(name="patient_id")
	@ManyToOne
	private Patient patient;
	@JoinColumn(name="physical_id")
	@ManyToOne
	private PhysicalExam physicalExam;
	public PatientPhysicalExam(){}
	public PatientPhysicalExam(Integer id, double cost) {
		super();
		this.id = id;
		this.cost = cost;
	}
	public PatientPhysicalExam(Integer id, double cost, Patient patient,
			PhysicalExam physicalExam) {
		super();
		this.id = id;
		this.cost = cost;
		this.patient = patient;
		this.physicalExam = physicalExam;
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
	public PhysicalExam getPhysicalExam() {
		return physicalExam;
	}
	public void setPhysicalExam(PhysicalExam physicalExam) {
		this.physicalExam = physicalExam;
	}
	@Override
	public String toString() {
		return "PatientPhysicalExam [id=" + id + ", cost=" + cost + "]";
	}
	
}
