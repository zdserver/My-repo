package com.briup.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.UserPatient;
import com.briup.exception.UserEception;
import com.briup.service.UserPatientSer;
@RestController
public class ChargeManController {
	@Autowired
	private UserPatientSer usService;
	@RequestMapping(value="/register/{id}",method=RequestMethod.DELETE)
	public String test(@PathVariable(value="id",required=false) int id) {
		usService.deleteUserP(id);
		return "OK";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String test1(UserPatient userP){
		try {
			usService.addUserP(userP);
			return "OK";
		} catch (UserEception e) {
			return e.getMessage();
		}
	}
	@RequestMapping(value="/register/{id}",method=RequestMethod.GET)
	public UserPatient test3(@PathVariable(value="id",required=false) int id) {
		UserPatient userP = usService.getUserP(id);
		return userP;
	}
	@RequestMapping(value="/register",method=RequestMethod.PUT)
	public String test4(UserPatient userP) {
		usService.updateUserP(userP);
		return "修改成功";
	}
	@RequestMapping(value="/register",method=RequestMethod.DELETE)
	public String test5(@RequestParam("ids") int[] id) {
		for(int i=0;i<id.length;i++) {
			usService.deleteUserP(id[i]);
		}
		return "OK";
	}
}
