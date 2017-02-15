package com.yw.serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yw.dao.GwcDao;
import com.yw.daoimpl.GwcDaoImpl;
import com.yw.model.Gwc;
import com.yw.model.User;
import com.yw.service.GwcService;

public class GwcServiceImpl implements GwcService {
	private GwcDao gd=new GwcDaoImpl();
	@Override
	public boolean addUser(Gwc g) {
		boolean bool=false;
		try {
			if(gd.insertGwc(g)>0){
				bool=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean editUser(Gwc g, Gwc g1) {
		boolean bool=false;
		try {
			if(gd.updateUser(g, g1)>0){
				bool=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return bool;
	}

	@Override
	public boolean removeUser(Gwc g) {
		boolean bool=false;
		try {
			if(gd.deleteGwc(g)>0){
				bool=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return bool;
	}

	@Override
	public List<Gwc> queryGwc(User u) {
		List<Gwc> ls=new ArrayList<Gwc>();
		try {
			ls=gd.selectAll(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	
}
