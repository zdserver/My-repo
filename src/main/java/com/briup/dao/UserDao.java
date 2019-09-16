package com.briup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.briup.bean.User;

public interface UserDao extends JpaRepository<User, Integer>{
	public User findByName(String name);
	@Query("select u from User u where u.department.id=?1")
	public List<User> findByDepartmentId(int id);
}
