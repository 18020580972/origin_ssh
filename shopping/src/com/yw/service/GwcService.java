package com.yw.service;

import java.util.List;

import com.yw.model.Gwc;
import com.yw.model.User;



public interface GwcService {
	public boolean addUser(Gwc g);
	
	public boolean editUser(Gwc g,Gwc g1);
	
	public boolean removeUser(Gwc g);
	
	public List<Gwc> queryGwc(User u);
}
