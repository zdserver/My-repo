package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.exception.UserEception;
import com.briup.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findUserByName(String name) {
		User user = userDao.findByName(name);
		if(user!=null) {
			return user;
		}
		return null;
	}

	@Override
	public User findUserById(int id) {
		User user = userDao.findOne(id);
		return user;
	}

	@Override
	public void deleteUserById(int id) {
		userDao.delete(id);		
	}

	@Override
	public Page<User> findAllUsers(int page, int size) {
		Page<User> page2 = userDao.findAll(new PageRequest(page, size));
		return page2;
	}

	@Override
	public void addUser(User user) throws UserEception{
		User user2 = userDao.findByName(user.getName());
		if(user2==null) {
			userDao.save(user);	
		}else {
			throw new UserEception("该用户已存在");
		}
	}

	@Override
	public void updateUser(User user) {
		userDao.save(user);
		
	}

	@Override
	public List<User> findUserBydept(int id) {
		List<User> list = userDao.findByDepartmentId(id);
		if(list==null) {
			return null;
		}
		return list;
	}

}
