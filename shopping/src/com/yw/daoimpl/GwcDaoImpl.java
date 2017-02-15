package com.yw.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yw.dao.GwcDao;
import com.yw.model.Gwc;
import com.yw.model.User;
import com.yw.util.DBHelper;

public class GwcDaoImpl implements GwcDao {
	private DBHelper dbh = DBHelper.getDBHelper();
	User u=new User();
	@Override
	public int insertGwc(Gwc g) throws SQLException {
			
			// 准备数据库环境
				String sql = "insert into gwc values(?,?,?,?)";
				// 准备链接对象
				Connection con = dbh.getConection();
				// 准备执行对象
				PreparedStatement ps = con.prepareStatement(sql);
				// 传参
				ps.setInt(1,g.getGid());
				ps.setString(2, g.getSname());
				ps.setInt(3, g.getSum());
				ps.setDouble(4, g.getJiage());
				int num = ps.executeUpdate();
				// 关闭
				dbh.close(con, null, ps, null);
				return num;
	}

	@Override
	public int deleteGwc(Gwc g) throws SQLException {
		String sql = "delete from gwc";
		sql += " where 1=1";
		
		if (g.getGid() != 0 && g.getSname()  != null) {
			sql += " and id = '"+g.getGid()+"'";
		
			sql += " and sname = '"+g.getSname()+"'";
		
	}
		
		Connection con = dbh.getConection();
		Statement s = con.createStatement();
		System.out.println(sql);
		int num = s.executeUpdate(sql);
		dbh.close(con, s, null, null);
		return num;
	}

	@Override
	public List<Gwc> selectAll(User u) throws SQLException {
		String sql = "select * from gwc  where id = ?";
		Connection con = dbh.getConection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setInt(1,u.getGwc());
		ResultSet rs = ps.executeQuery();
		List<Gwc> ls=new ArrayList<Gwc>();
		
		if(rs.next())
		{
			Gwc g= new Gwc();
			g.setGid(rs.getInt("id"));
			g.setSname(rs.getString("sname"));
			g.setSum(rs.getInt("sum"));
			g.setJiage(rs.getDouble("jiage"));
			ls.add(g);
		}
		return ls;
	}

	@Override
	public int getGwId(User u) throws SQLException {
		String sql = "select id from user  where uname = ? and upass =?";
		Connection con = dbh.getConection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, u.getUname());
		ps.setString(2,u.getUpass());
		ResultSet rs = ps.executeQuery();
		int maxid = 0;
		if(rs.next())
		{
			maxid = rs.getInt("id");
		}
		return maxid;
		
	}

/*
 * (non-Javadoc)修改购物车数量
 * @see com.yw.dao.GwcDao#updateUser(com.yw.model.Gwc, com.yw.model.Gwc)
 */
	@Override
	public int updateUser(Gwc g, Gwc g1) throws SQLException {
		String sql = "update Gwc set ";
		
		if(g.getSum()!=0){
			sql += "sum = '"+g.getSum()+"',";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " where 1=1";
		if (g.getGid() != 0 && g1.getSname()  != null) {
				sql += " and id = '"+g1.getGid()+"'";
			
				sql += " and sname = '"+g1.getSname()+"'";
			
		}
		
		Connection con = dbh.getConection();
		Statement s = con.createStatement();
		System.out.println(sql);
		int num = s.executeUpdate(sql);
		dbh.close(con, s, null, null);
		return num;
	}

	

}
