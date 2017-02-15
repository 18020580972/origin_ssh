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

public class GwcAdd extends HttpServlet {
	private GwcService gs=new GwcServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sname = req.getParameter("sname");
		String jiage=req.getParameter("jiage");
		HttpSession session =req.getSession();//ͨ��������Ϣ�õ�session����������װ�û���Ϣ
		User u=(User)session.getAttribute("user");
		Gwc g=new Gwc();
		g.setGid(u.getGwc());
		g.setSname(sname);
		g.setSum(1);
		g.setJiage(Double.valueOf(jiage));
	
		if(gs.addUser(g)){
			resp.getWriter().println("yes");
		}else{
			resp.getWriter().println("no");
		}
	}
	
}
