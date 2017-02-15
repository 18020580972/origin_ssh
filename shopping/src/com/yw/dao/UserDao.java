package com.yw.dao;

import java.sql.SQLException;
import java.util.List;

import com.yw.model.User;

public interface UserDao {
	
	/*
	 * 插入数据库
	 */
	public int insertUser(User u) throws SQLException ;
	
	/*
	 * 修改
	 */
	
	public int updateUser(User u,User u1) throws SQLException;
	
	/*
	 * 删除
	 */
	public int deleteUser(User u) throws SQLException;
	
	/*
	 * 查询
	 */
	public List<User> selectAll(String str) throws SQLException;
	
	
	/*
	 * 得到最大id
	 */
	public int  getMaxId()  throws SQLException;
	
	/*
	 * 根据用户信息查询用户
	 */
	public User getUser(User u) throws SQLException;
	
	/*
	 * 根据用户id查询用户细心
	 */
	public User getUser(int id) throws SQLException;
	/*
	 * 检查是否重名
	 */
	
	public User getUser(String uname) throws SQLException;

}
