package com.yw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yw.model.Gwc;
import com.yw.model.User;
import com.yw.service.GwcService;
import com.yw.serviceimpl.GwcServiceImpl;

public class GwcRemove extends HttpServlet {

		private GwcService gs=new GwcServiceImpl();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String sname = req.getParameter("sname");
			
			HttpSession session =req.getSession();//通过请求信息得到session对象，用来封装用户信息
			User u=(User)session.getAttribute("user");
			Gwc g=new Gwc();
			g.setGid(u.getGwc());
			g.setSname(sname);
			if(gs.removeUser(g)){
				req.getRequestDispatcher("gwc.jsp").forward(req, resp);
			}else{
				
			}
		
		}
	}

