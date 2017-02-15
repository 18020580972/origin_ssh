package com.yw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yw.model.User;
import com.yw.service.UserService;
import com.yw.serviceimpl.UserServiceImpl;

public class UserRegistServlet  extends HttpServlet{
	private UserService us = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
	
		String phone = req.getParameter("phone");
		User u = new User();
		u.setUname(uname);
		u.setUpass(upass);
		u.setPhone(phone);
		
		boolean bool = us.addUser(u);
		if(bool)
		{
			resp.sendRedirect("Login.jsp");
		}else
		{
			resp.sendRedirect("fail.jsp");
		}
	}

}
