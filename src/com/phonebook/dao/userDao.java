package com.phonebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.phonebook.entities.user;


public class userDao 
{
	Connection con;

	public userDao(Connection con) {
		this.con = con;
	}
	
	public boolean saveUser(user user)
	{
		boolean f=false;
		try {
			String query="insert into user(name,email,password,mobile) values(?,?,?,?)";
			PreparedStatement psmt=this.con.prepareStatement(query);
			
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPassword());
			psmt.setInt(4, user.getMobile());
			
			psmt.executeUpdate();
			
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public user loginUser(String email,String password)
	{
		user user=null;
		try {
			String query="select * from user where email=? and password=?";
			PreparedStatement psmt=this.con.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, password);
			
			ResultSet rs=psmt.executeQuery();
			if(rs.next())
			{
				user=new user();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setMobile(rs.getInt(5));
				user.setProfile(rs.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	public boolean updateUser(user user)
	{
		boolean f=false;
		try {
			String query="update user set name=? , password=? , mobile=? where id=?";
			PreparedStatement psmt=this.con.prepareStatement(query);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			psmt.setInt(3, user.getMobile());
			psmt.setInt(4, user.getId());
			psmt.executeUpdate();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}
