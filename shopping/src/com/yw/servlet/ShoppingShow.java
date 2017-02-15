package com.yw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yw.model.Shopping;
import com.yw.service.ShoppingService;
import com.yw.serviceimpl.ShoppingServiceImpl;
import net.sf.json.JSONArray;

public class ShoppingShow extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShoppingService ss=new ShoppingServiceImpl();
		List<Shopping> ls=ss.showAll();
		JSONArray ja=JSONArray.fromObject(ls);
		resp.getWriter().println(ja);
	}

}
