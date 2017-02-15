package com.yw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yw.model.User;
import com.yw.service.UserService;
import com.yw.serviceimpl.UserServiceImpl;

public class UserUpdateUserServlet extends HttpServlet{
	private UserService us = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User u = us.getUser(Integer.parseInt(id));
		req.setAttribute("updateUser", u);
		req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
	}
}
