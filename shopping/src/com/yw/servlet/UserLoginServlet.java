package com.yw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yw.model.User;
import com.yw.service.UserService;
import com.yw.serviceimpl.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {
	private UserService us = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		User u1 = new User();
		u1.setUname(uname);
		u1.setUpass(upass);
		User u = us.login(u1);
		HttpSession session =req.getSession();//通过请求信息得到session对象，用来封装用户信息
		if(u!=null)
		{
			session.setAttribute("user",u);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else
		{
			resp.sendRedirect("loginFail.jsp");
		}
	}
}
