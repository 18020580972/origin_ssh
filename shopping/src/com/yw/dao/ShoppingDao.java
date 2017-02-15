package com.yw.dao;

import java.sql.SQLException;
import java.util.List;

import com.yw.model.Shopping;

public interface ShoppingDao {
	int insertShopping(Shopping s) throws SQLException;
	
	List<Shopping> showShopping(String str) throws SQLException;

}
