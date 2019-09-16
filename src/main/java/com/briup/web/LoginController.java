package com.briup.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.briup.bean.User;
import com.briup.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/index")
	public String index(HttpSession session) {
		User u = (User) session.getAttribute("user");
		if(u==null) {
			return "error";
		}
		return "index";
	}
	@RequestMapping("/user/login")
	@ResponseBody
	public String userLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		User user = userService.findUserByName(name);
		session.setAttribute("user", user);
		if(user==null) {
			return "用户名错误";
		}
		else if(!user.getPassword().equals(pwd)) {
			return "密码错误";
		}
		else {
			return "OK";
		}
	}
	@RequestMapping("/user/logout")
	public String test(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}

}
