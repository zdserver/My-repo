package com.briup.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.bean.Category;
import com.briup.bean.Department;
import com.briup.bean.Drug;
import com.briup.bean.Patient;
import com.briup.bean.User;
import com.briup.bean.UserPatient;
import com.briup.service.CategoryService;
import com.briup.service.DepartmentService;
import com.briup.service.DrugService;
import com.briup.service.PatientService;
import com.briup.service.UserPatientSer;
import com.briup.service.UserService;
@Controller
public class viewController {
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService paService;
	@Autowired
	private CategoryService caService;
	@Autowired
	private DrugService drugService;
	@Autowired
	private UserPatientSer usService;
	@RequestMapping(value="/dept",method=RequestMethod.GET)
	public String test(HttpSession session,HttpServletRequest request) {
		String page=request.getParameter("page");
		String size = request.getParameter("size");
		Page<Department> page2=null;
		if(page==null&&size==null) {			
			page2 = deptService.findAllDept(0,5);
		}
		else {
			page2 = deptService.findAllDept(Integer.parseInt(page),Integer.parseInt(size));
		}
		session.setAttribute("page", page2);
		return "html/dept";
	}
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String test1(HttpSession session,HttpServletRequest request) {
		String page=request.getParameter("page");
		String size = request.getParameter("size");
		Page<User> page2=null;
		if(page==null&&size==null) {			
			page2 = userService.findAllUsers(0,5);
		}
		else {
			page2 = userService.findAllUsers(Integer.parseInt(page),Integer.parseInt(size));
		}
		session.setAttribute("page", page2);
		return "html/user";
	}
	@RequestMapping(value="/patient",method=RequestMethod.GET)
	public String test2(HttpSession session,HttpServletRequest request) {
		String page=request.getParameter("page");
		String size = request.getParameter("size");
		Page<Patient> page2=null;
		if(page==null&&size==null) {			
			page2 = paService.findAllPatients(0,5);
		}
		else {
			page2 = paService.findAllPatients(Integer.parseInt(page),Integer.parseInt(size));
		}
		session.setAttribute("page", page2);
		return "html/patient";
	}
	@RequestMapping(value="/category",method=RequestMethod.GET)
	public String test3(HttpSession session,HttpServletRequest request) {
		String page=request.getParameter("page");
		String size = request.getParameter("size");
		Page<Category> page2=null;
		if(page==null&&size==null) {			
			page2 = caService.findAllCategorys(0,5);
		}
		else {
			page2 = caService.findAllCategorys(Integer.parseInt(page),Integer.parseInt(size));
		}
		session.setAttribute("page", page2);
		return "html/category";
	}
	@RequestMapping("/drug")
	public String test4(HttpSession session,HttpServletRequest request) {
		String page=request.getParameter("page");
		String size = request.getParameter("size");
		Page<Drug> page2=null;
		if(page==null&&size==null) {			
			page2 = drugService.findAllDrugs(0,5);
		}
		else {
			page2 = drugService.findAllDrugs(Integer.parseInt(page),Integer.parseInt(size));
		}
		session.setAttribute("page", page2);
		return "html/drug";
	}
	@RequestMapping("/register")
	public String test5(HttpSession session,HttpServletRequest request) {
		String page=request.getParameter("page");
		String size = request.getParameter("size");
		Page<UserPatient> page2=null;
		if(page==null&&size==null) {			
			page2 = usService.findAllUSs(0,5);
		}
		else {
			page2 = usService.findAllUSs(Integer.parseInt(page),Integer.parseInt(size));
		}
		session.setAttribute("page", page2);
		return "html/register";
	}
	@RequestMapping("/pe")
	public String test00() {
		return "html/pe";
	}
}
