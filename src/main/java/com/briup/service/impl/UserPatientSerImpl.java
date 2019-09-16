package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Patient;
import com.briup.bean.UserPatient;
import com.briup.dao.PatientDao;
import com.briup.dao.UserPatientDao;
import com.briup.exception.UserEception;
import com.briup.service.UserPatientSer;
@Service
public class UserPatientSerImpl implements UserPatientSer{
	@Autowired
	private UserPatientDao usDao;
	@Autowired
	private PatientDao psDao;
	@Override
	public Page<UserPatient> findAllUSs(int i, int j) {
		PageRequest request = new PageRequest(i, j);
		Page<UserPatient> pages = usDao.findAll(request);
		if(pages!=null) {
			return pages;
		}
		return null;
	}
	@Override
	public void deleteUserP(int id) {
		usDao.delete(id);
		
	}
	@Override
	public void addUserP(UserPatient dept) throws UserEception {
		Patient patient=new Patient();
		patient.setName(dept.getPatient().getName());
		patient.setId(dept.getPatient().getId());
		dept.setPatient(patient);
		usDao.save(dept);
		
		
	}
	@Override
	public UserPatient getUserP(int id) {
		UserPatient category = usDao.findOne(id);
		return category;
	}
	@Override
	public void updateUserP(UserPatient userP) {
		Patient patient=new Patient();
		patient.setName(userP.getPatient().getName());
		patient.setId(userP.getPatient().getId());
		userP.setPatient(patient);
		usDao.save(userP);
		
	}

}
