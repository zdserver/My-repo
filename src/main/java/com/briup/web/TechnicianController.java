package com.briup.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TechnicianController {
	@RequestMapping("/html/entryCheckResult")
	public String test1() {
		return "html/entryCheckResult";
	}

}
