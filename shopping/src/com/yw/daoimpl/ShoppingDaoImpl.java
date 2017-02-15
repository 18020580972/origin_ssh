package com.yw.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yw.dao.ShoppingDao;
import com.yw.model.Shopping;
import com.yw.util.DBHelper;

public class ShoppingDaoImpl implements ShoppingDao {
	private DBHelper db=DBHelper.getDBHelper();
	/*
	 * 求最大id
	 */
public int Maxid() throws SQLException{
	String sql="select ifnull(max(id),0) as maxid from shopping";
	Connection conn=db.getConection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery(sql);
	int maxid = 0;
	if(rs.next())
	{
		maxid = rs.getInt("maxid");
	}
	db.close(conn, st, null, rs);
	return maxid+1;
	
}
	/*
	 * 添加商品
	 */
	@Override
	public int insertShopping(Shopping s) throws SQLException {
		String sql="insert into shopping values(?,?,?,?,?)";
		Connection conn=db.getConection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(0, Maxid());
		ps.setString(1, s.getPname());
		ps.setString(2, s.getUrl());
		ps.setDouble(3, s.getPrice());
		ps.setInt(4, Maxid());
		int num=ps.executeUpdate();
		db.close(conn, null, ps, null);
		return num;
	}
	/*
	 * (non-Javadoc)商品展示
	 * @see com.yw.dao.ShoppingDao#showShopping(java.lang.String)
	 */
	@Override
	public List<Shopping> showShopping(String str ) throws SQLException {
		String sql="select *from shopping where 1=1";
		if(str!=null){
			sql+=" and where pname like '%"+str+"%'";
		}
		Connection conn=db.getConection(); 
		PreparedStatement st=conn.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		List<Shopping> ls=new ArrayList<Shopping>();
		while(rs.next()){
			Shopping s=new Shopping();
			s.setId(rs.getInt("id"));
			s.setPname(rs.getString("pname"));
			s.setUrl(rs.getString("url"));
			s.setPrice(rs.getDouble("price"));
			s.setWid(rs.getInt("wid"));
			ls.add(s);
			
		}
		db.close(conn, st, null, rs);
		return ls;

	}

}
