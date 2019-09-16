package com.briup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.briup.service.DepartmentService;
import com.briup.service.PatientService;
import com.briup.service.UserService;
import com.briup.service.impl.DepartmentServiceImpl;
import com.briup.service.impl.PatientServiceImpl;
import com.briup.service.impl.UserServiceImpl;
@Configuration
public class UserConfig {
	@Bean
	public UserService getRole() {
		return new UserServiceImpl();
	}
	@Bean
	public DepartmentService getDept() {
		return new DepartmentServiceImpl();
	}

}
