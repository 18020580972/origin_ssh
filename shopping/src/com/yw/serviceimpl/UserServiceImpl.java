package com.yw.serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yw.dao.UserDao;
import com.yw.daoimpl.UserDaoImpl;
import com.yw.model.User;
import com.yw.service.UserService;

public class UserServiceImpl implements UserService {
private UserDao userDao = new UserDaoImpl();
	
	
	@Override
	public boolean addUser(User u) {
		int num;
		boolean bool  = false;
		try {
			num = userDao.insertUser(u);
			if(num>0)
			{
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean editUser(User u, User u1) {
		int num;
		boolean bool  = false;
		try {
			num = userDao.updateUser(u, u1);
			if(num>0)
			{
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean removeUser(User u) {
		int num;
		boolean bool  = false;
		try {
			num = userDao.deleteUser(u);
			if(num>0)
			{
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public List<User> queryUser(String str) {
		List<User> ls = new ArrayList<User>();
		try {
			ls =  userDao.selectAll(str);
		} catch (SQLException e) {
			// TODO Auto-generated 
		}
		return ls;
	}

	@Override
	public User login(User u) {
		User u1 = null;
		try {
			 u1 = userDao.getUser(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u1;
	}

	@Override
	public User getUser(int id) {
		User u1 = null;
		try {
			 u1 = userDao.getUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u1;
	}

	@Override
	public User CheckUser(String uname) {
		User u1 = null;
		try {
			 u1 = userDao.getUser(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u1;
	}


}
