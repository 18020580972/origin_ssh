package com.yw.model;

public class User {
	private int id;
	private String uname;
	private String upass;
	private String phone;
	private int gwc;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getGwc() {
		return gwc;
	}
	public void setGwc(int gwc) {
		this.gwc = gwc;
	}
	
}
