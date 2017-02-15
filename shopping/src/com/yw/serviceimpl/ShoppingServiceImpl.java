package com.yw.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import com.yw.dao.ShoppingDao;
import com.yw.daoimpl.ShoppingDaoImpl;
import com.yw.model.Shopping;
import com.yw.service.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService {
private ShoppingDao sd=new ShoppingDaoImpl();
	@Override
	public boolean addShopping(Shopping s) {
		boolean bool=false;
		try {
			if(sd.insertShopping(s)>0){
				bool=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return bool;
	}

	@Override
	public List<Shopping> showAll() {
		List<Shopping> ls=null;
		try {
			ls=sd.showShopping(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ls;
	}

}
