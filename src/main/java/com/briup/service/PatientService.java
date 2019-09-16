package com.briup.service;

import org.springframework.data.domain.Page;

import com.briup.bean.Patient;
import com.briup.exception.UserEception;

public interface PatientService {
	public Page<Patient> findAllPatients(int i, int j);
	public void addPatient(Patient pat) throws UserEception;
	public void deletePatient(int id);
	public Patient findPatientrById(int id);
	public void updatePatient(Patient patient);
	public String findPatientByCardNo(String CardNo);
	public Patient findPatientByName(String name);
}
