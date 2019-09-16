package com.briup.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Department;
import com.briup.exception.DeptEception;

public interface DepartmentService {
	public Page<Department> findAllDept(int page,int size);
	public void deleteDept(int id);
	public void addDept(Department dept) throws DeptEception;
	public void updateDept(Department dept);
	public Department getDept(int id);
	public List<Department> findAllDepts();
}
