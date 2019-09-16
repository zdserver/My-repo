package com.briup.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Patient;



public interface PatientDao extends JpaRepository<Patient, Integer>{

	Patient findByName(String name);

	Patient findPatientByCardNo(String cardNo);

}
