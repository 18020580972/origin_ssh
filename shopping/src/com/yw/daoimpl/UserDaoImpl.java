package com.yw.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yw.dao.UserDao;
import com.yw.model.User;
import com.yw.util.DBHelper;

public  class UserDaoImpl implements UserDao {
	private DBHelper dbh = DBHelper.getDBHelper();

	@Override
	public int insertUser(User u) throws SQLException {
		// 准备数据库环境
		String sql = "insert into user values(?,?,?,?,?)";
		// 准备链接对象
		Connection con = dbh.getConection();
		// 准备执行对象
		PreparedStatement ps = con.prepareStatement(sql);
		// 传参
		ps.setInt(1,getMaxId());
		ps.setString(2, u.getUname());
		ps.setString(3, u.getUpass());
		ps.setString(4, u.getPhone());
		ps.setInt(5, getMaxId());
		int num = ps.executeUpdate();
		// 关闭
		dbh.close(con, null, ps, null);
		return num;
	}

	@Override
	public int updateUser(User u,User u1) throws SQLException {
		String sql = "update user set ";
		if (u.getId() != 0) {
			sql += "id ="+u.getId()+",";
		}
		if (u.getUname() != null) {
			sql += "uname = '"+u.getUname()+"',";
		}
		if (u.getUpass() != null) {
			sql += "upass = '"+u.getUpass()+"',";
		}
		
		if (u.getGwc()!= 0) {
			sql += "gwc = "+u.getGwc()+",";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " where 1=1";
		if (u1.getId() != 0) {
			sql += " and id = "+u1.getId()+"";
		}
		if (u1.getUname() != null) {
			sql += " and uname = '"+u1.getUname()+"'";
		}
		if (u1.getUpass() != null) {
			sql += " and upass = '"+u1.getUpass()+"'";
		}
		if (u1.getGwc()!= 0) {
			sql += " and gwc = "+u1.getGwc()+"";
		}
		Connection con = dbh.getConection();
		Statement s = con.createStatement();
		
		int num = s.executeUpdate(sql);
		dbh.close(con, s, null, null);
		return num;
	}

	@Override
	public int deleteUser(User u1) throws SQLException {
		String sql = "delete from user";
		sql += " where 1=1";
		if (u1.getId() != 0) {
			sql += " and id = "+u1.getId()+"";
		}
		if (u1.getUname() != null) {
			sql += " and uname = '"+u1.getUname()+"'";
		}
		if (u1.getUpass() != null) {
			sql += " and upass = '"+u1.getUpass()+"'";
		}
		if (u1.getGwc() != 0) {
			sql += " and gwc = "+u1.getGwc()+"";
		}
		
		Connection con = dbh.getConection();
		Statement s = con.createStatement();
		System.out.println(sql);
		int num = s.executeUpdate(sql);
		dbh.close(con, s, null, null);
		return num;
	}

	
	public int getMaxId() throws SQLException
	{
		String sql = "select max(ifnull(id,0)) as maxid from user";
		Connection con = dbh.getConection();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		int maxid = 0;
		if(rs.next())
		{
			maxid = rs.getInt("maxid");
		}
		return maxid+1;
	}

	@Override
	public User getUser(User u) throws SQLException {
		String sql = "select * from user  where uname = ? and upass =?";
		Connection con = dbh.getConection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, u.getUname());
		ps.setString(2,u.getUpass());
		ResultSet rs = ps.executeQuery();
		User u1 = null;
		if(rs.next())
		{
			u1= new User();
			u1.setId(rs.getInt("id"));
			u1.setUname(rs.getString("uname"));
			u1.setUpass(rs.getString("upass"));
			u1.setPhone(rs.getString("phone"));
			u1.setGwc(rs.getInt("gwc"));
		}
		return u1;
	}
	
	
	@Override
	public User getUser(int id) throws SQLException {
		String sql = "select * from user  where id = ?";
		Connection con = dbh.getConection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		User u1 = null;
		if(rs.next())
		{
			u1= new User();
			u1.setId(rs.getInt("id"));
			u1.setUname(rs.getString("uname"));
			u1.setUpass(rs.getString("upass"));
			u1.setPhone(rs.getString("phone"));
			u1.setGwc(rs.getInt("gwc"));
		}
		return u1;
	}

	@Override
	public User getUser(String uname) throws SQLException {
		String sql = "select * from user where uname = ?";
		Connection con = dbh.getConection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		User u1 = null;
		if(rs.next())
		{
			u1= new User();
			u1.setId(rs.getInt("id"));
			u1.setUname(rs.getString("uname"));
			u1.setUpass(rs.getString("upass"));
			u1.setPhone(rs.getString("phone"));
			u1.setGwc(rs.getInt("gwc"));
		}
		return u1;
	}

	@Override
	public List<User> selectAll(String str) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
