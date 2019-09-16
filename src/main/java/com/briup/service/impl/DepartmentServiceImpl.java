package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.briup.bean.Department;
import com.briup.dao.DepartmentDao;
import com.briup.exception.DeptEception;
import com.briup.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public Page<Department> findAllDept(int page,int size) {
		PageRequest request = new PageRequest(page, size);
		Page<Department> pages = deptDao.findAll(request);
		if(pages!=null) {
			return pages;
		}
		return null;
	}

	@Override
	public void deleteDept(int id) {
		deptDao.delete(id);
	}

	@Override
	public void addDept(Department dept) throws DeptEception {
		Department dept1 = deptDao.findByName(dept.getName());
		if(dept1==null) {
			deptDao.save(dept);
		}else{
			throw new DeptEception("部门名称重复");
		}
	}

	@Override
	public void updateDept(Department dept) {
		deptDao.save(dept);		
	}

	@Override
	public Department getDept(int id) {
		Department department = deptDao.findOne(id);
		return department;
	}

	@Override
	public List<Department> findAllDepts() {
		List<Department> list = deptDao.findAll();
		return list;
	}
	
}
