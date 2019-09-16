package com.briup.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {
	@RequestMapping("/html/nodealPatient")
	public String test() {
		return "html/nodealPatient";
	}
	@RequestMapping("/html/dealedPatient")
	public String test1() {
		return "html/dealedPatient";
	}
	@RequestMapping("/html/prescription")
	public String test2() {
		return "html/prescription";
	}
	@RequestMapping("/html/selectPrescription")
	public String test3() {
		return "html/selectPrescription";
	}
	@RequestMapping("/html/check")
	public String test4() {
		return "html/check";
	}
	@RequestMapping("/html/selectCheck")
	public String test5() {
		return "html/selectCheck";
	}
	@RequestMapping("/html/diagnosis")
	public String test6() {
		return "html/diagnosis";
	}
	@RequestMapping("/html/MedicalRecordSelect")
	public String test7() {
		return "html/MedicalRecordSelect";
	}
}
