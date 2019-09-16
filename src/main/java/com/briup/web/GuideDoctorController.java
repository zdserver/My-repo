package com.briup.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Patient;
import com.briup.exception.UserEception;
import com.briup.service.PatientService;
@RestController
public class GuideDoctorController {
	@Autowired
	private PatientService paService;
	@RequestMapping(value="/patient",method=RequestMethod.POST)
	public String test1(Patient pat,HttpSession session) {
		try {
			paService.addPatient(pat);
			return "OK";
		} catch (UserEception e) {
			session.setAttribute("msg", e.getMessage());
			return e.getMessage();
		}
	}
	@RequestMapping(value="/patient/{id}",method=RequestMethod.DELETE)
	public String test2(@PathVariable(value="id",required=false) int id) {
		paService.deletePatient(id);
		return "OK";
	}
	@RequestMapping(value="/patient/{id}",method=RequestMethod.GET)
	public Patient test3(@PathVariable(value="id",required=false) int id) {
		Patient patient = paService.findPatientrById(id);
		return patient;
	}
	@RequestMapping(value="/patient",method=RequestMethod.PUT)
	public String test4(Patient patient) {
		paService.updatePatient(patient);
		return "修改成功";
	}
	@RequestMapping(value="/patient",method=RequestMethod.DELETE)
	public String test5(@RequestParam("ids") int[] id) {
		for(int i=0;i<id.length;i++) {
			paService.deletePatient(id[i]);
		}
		return "OK";
	}
}
