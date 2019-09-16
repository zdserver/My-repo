package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Patient;
import com.briup.dao.PatientDao;
import com.briup.exception.UserEception;
import com.briup.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientDao patientdao;


	@Override
	public Page<Patient> findAllPatients(int i, int j) {
		Page<Patient> page = patientdao.findAll(new PageRequest(i, j));
		return page;
	}

	@Override
	public void addPatient(Patient pat) throws UserEception {
		String str = findPatientByCardNo(pat.getCardNo());
		if(str=="该卡号已存在") {
			throw new UserEception("该卡号已存在");
		}else {
			Patient patient = patientdao.findByName(pat.getName());
			if(patient==null) {
				patientdao.save(pat);	
			}else {
				throw new UserEception("该用户已存在");
			}
		}			
	}

	@Override
	public void deletePatient(int id) {
		patientdao.delete(id);	
	}

	@Override
	public Patient findPatientrById(int id) {
		Patient patient = patientdao.findOne(id);
		return patient;
	}

	@Override
	public void updatePatient(Patient patient) {
		patientdao.save(patient);		
	}

	@Override
	public String findPatientByCardNo(String CardNo) {
		Patient patient = patientdao.findPatientByCardNo(CardNo);
		if(patient!=null) {
			return "该卡号已存在";
		}
		return "OK";
	}

	@Override
	public Patient findPatientByName(String name) {
		Patient patient = patientdao.findByName(name);
		if(patient==null) {
			return null;
		}
		return patient;
	}

}
