package com.briup.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.User;
import com.briup.exception.UserEception;

public interface UserService {
	public User findUserByName(String name);
	public User findUserById(int id);
	public void deleteUserById(int id);
	public Page<User> findAllUsers(int i, int j);
	public void addUser(User user) throws UserEception;
	public void updateUser(User user);
	public List<User> findUserBydept(int id);
}
