package com.yw.dao;

import java.sql.SQLException;
import java.util.List;

import com.yw.model.Gwc;
import com.yw.model.User;




public interface GwcDao {
	/*
	 * �������ݿ�
	 */
	public int insertGwc(Gwc g) throws SQLException ;
	
	
	/*
	 * ɾ��
	 */
	public int deleteGwc(Gwc g) throws SQLException;
	
	/*
	 * ��ѯ
	 */
	public List<Gwc> selectAll(User u) throws SQLException;
	
	
	/*
	 * �õ����id
	 */
	public int getGwId(User u) throws SQLException;
	/*
	 * �޸�
	 */
	
	public int updateUser(Gwc g,Gwc g1) throws SQLException;


	
	
	


}

