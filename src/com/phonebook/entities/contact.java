package com.phonebook.entities;

public class contact
{
	private int id;
	private String name;
	private String email;
	private int mobile;
	private int uid;
	
	public contact() {
	}
	public contact(int id, String name, String email, int mobile, int uid) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.uid = uid;
	}
	public contact(String name, String email, int mobile, int uid) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.uid = uid;
	}
	public contact(String name, String email, int mobile) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	
	public contact(int id, String name, String email, int mobile) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
