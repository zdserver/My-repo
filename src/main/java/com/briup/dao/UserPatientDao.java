package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.UserPatient;

public interface UserPatientDao extends JpaRepository<UserPatient, Integer>{


}
