package com.briup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Department;
import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.exception.DeptEception;
import com.briup.exception.UserEception;
import com.briup.service.DepartmentService;
import com.briup.service.RoleService;
import com.briup.service.UserService;
@RestController
public class DictionaryManagerMan {
	@Autowired
	private DepartmentService deptService;	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@RequestMapping(value="/dept/{id}",method=RequestMethod.DELETE)
	public String test(@PathVariable(value="id",required=false) int id) {
		deptService.deleteDept(id);
		return "OK";
	}
	@RequestMapping(value="/dept",method=RequestMethod.POST)
	public String test1(Department dept) {
		try {
			deptService.addDept(dept);
			return "OK";
		} catch (DeptEception e) {
			return e.getMessage();
		}
	}
	@RequestMapping(value="/dept/{id}",method=RequestMethod.GET)
	public Department test3(@PathVariable(value="id",required=false) int id) {
		Department department = deptService.getDept(id);
		return department;
	}
	@RequestMapping(value="/dept",method=RequestMethod.PUT)
	public String test4(Department dept) {
		deptService.updateDept(dept);
		return "修改成功";
	}
	@RequestMapping(value="/dept",method=RequestMethod.DELETE)
	public String test5(@RequestParam("ids") int[] id) {
		for(int i=0;i<id.length;i++) {
			deptService.deleteDept(id[i]);
		}
		return "OK";
	}
	@RequestMapping(value="/selectDept",method=RequestMethod.GET)
	public List<Department> test6() {
		List<Department> list = deptService.findAllDepts();
		return list;
	}
	@RequestMapping(value="/selectRoles",method=RequestMethod.GET)
	public List<Role> test7() {
		List<Role> list = roleService.findAllRoles();
		return list;
	}
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String test8(User user) {
		try {
			userService.addUser(user);
			return "添加成功";
		} catch (UserEception e) {
			return e.getMessage();
		}
	}
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String test9(@PathVariable(value="id",required=false) int id) {
		userService.deleteUserById(id);
		return "OK";
	}
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public User test10(@PathVariable(value="id",required=false) int id) {
		User user = userService.findUserById(id);
		return user;
	}
	@RequestMapping(value="/user",method=RequestMethod.DELETE)
	public String test11(@RequestParam("ids") int[] id) {
		for(int i=0;i<id.length;i++) {
			userService.deleteUserById(id[i]);
		}
		return "OK";
	}
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public String test12(User user) {
		userService.updateUser(user);
		return "修改成功";
	}
	@RequestMapping(value="/findUserWithDeptByDeptId",method=RequestMethod.GET)
	public List<User> test13(@RequestParam("id") int id) {
		List<User> list=userService.findUserBydept(id);
		return list;
	}
}
