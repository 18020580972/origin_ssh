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

public class UserUpdateServlet extends HttpServlet {
	private UserService us = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		String jues = req.getParameter("box");
		String phone = req.getParameter("phone");
		
		User u = new User();
		u.setUname(uname);
		u.setUpass(upass);
		u.setPhone(phone);
		u.setId(Integer.parseInt(req.getParameter("userid")));
		User u1 = new User();
		u1.setId(Integer.parseInt(req.getParameter("userid")));
		boolean bool =us.editUser(u, u1);
		if(bool)
		{
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}
		else
		{
			//¸üÐÂÊ§°Ü
		}
		
	}
}
