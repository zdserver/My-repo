package com.briup.service;

import org.springframework.data.domain.Page;

import com.briup.bean.UserPatient;
import com.briup.exception.UserEception;

public interface UserPatientSer {

	Page<UserPatient> findAllUSs(int i, int j);

	void deleteUserP(int id);

	void addUserP(UserPatient dept)throws UserEception;

	UserPatient getUserP(int id);

	void updateUserP(UserPatient userP);

}
