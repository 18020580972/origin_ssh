package com.yw.service;

import java.util.List;

import com.yw.model.User;



public interface UserService {
	public boolean addUser(User u);
	
	public boolean editUser(User  u,User u1);
	
	public boolean removeUser(User u);
	
	public List<User> queryUser(String str);
	
	public User login(User u);
	
	public User getUser(int id);
	
	public User CheckUser(String uname);
}
