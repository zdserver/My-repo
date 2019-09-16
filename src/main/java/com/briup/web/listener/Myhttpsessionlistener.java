package com.briup.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class Myhttpsessionlistener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		ServletContext c=session.getServletContext();
		int count=(int) c.getAttribute("count1");
		count++;
		c.setAttribute("count1", count);
		System.out.println("增加1");		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		ServletContext c=session.getServletContext();
		int count=(int) c.getAttribute("count1");
		count--;
		c.setAttribute("count1", count);
		System.out.println("减少1");
		
	}
	

}
