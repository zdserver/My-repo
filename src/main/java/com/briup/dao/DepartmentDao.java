package com.briup.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{
	public Department findByName(String name);
}
