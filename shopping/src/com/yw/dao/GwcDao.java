package com.yw.dao;

import java.sql.SQLException;
import java.util.List;

import com.yw.model.Gwc;
import com.yw.model.User;




public interface GwcDao {
	/*
	 * 插入数据库
	 */
	public int insertGwc(Gwc g) throws SQLException ;
	
	
	/*
	 * 删除
	 */
	public int deleteGwc(Gwc g) throws SQLException;
	
	/*
	 * 查询
	 */
	public List<Gwc> selectAll(User u) throws SQLException;
	
	
	/*
	 * 得到最大id
	 */
	public int getGwId(User u) throws SQLException;
	/*
	 * 修改
	 */
	
	public int updateUser(Gwc g,Gwc g1) throws SQLException;


	
	
	


}

