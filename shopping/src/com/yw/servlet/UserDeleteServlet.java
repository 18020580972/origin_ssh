package com.yw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yw.model.User;
import com.yw.service.UserService;
import com.yw.serviceimpl.UserServiceImpl;




public class UserDeleteServlet extends HttpServlet {
	private UserService us = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u = new User();
		u.setId(Integer.parseInt(req.getParameter("id")));
		boolean bool = us.removeUser(u);
		if(bool)
		{
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else
		{
			
		}
	}
}

