package com.phonebook.entities;

public class user
{
	private int id;
	private String name;
	private String email;
	private String password;
	private int mobile;
	private String profile;
	public user(int id, String name, String email, String password, int mobile) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	public user() {
	}
	public user(String name, String email, String password, int mobile) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	
	
	public user(String name, String password, int mobile, String profile) {
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.profile = profile;
	}
	public user(String email, String password) {
		this.email = email;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
