package com.phonebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.phonebook.entities.contact;

public class contactDao
{
	private Connection con;

	public contactDao(Connection con) {
		this.con = con;
	}
	public boolean saveContact(contact contact)
	{
		boolean f=false;
		try {
			String query="insert into contact(name,email,mobile,uid) values(?,?,?,?)";
			PreparedStatement psmt=this.con.prepareStatement(query);
			psmt.setString(1, contact.getName());
			psmt.setString(2, contact.getEmail());
			psmt.setInt(3, contact.getMobile());
			psmt.setInt(4, contact.getUid());
			
			psmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		return f;
	}
	
	
	
	public ArrayList<contact> getContactDetails(int uid)
	{
		ArrayList<contact> clist=new ArrayList<contact>();
		try {
			String query="select * from contact where uid=?";
			PreparedStatement psmt=this.con.prepareStatement(query);
			psmt.setInt(1, uid);
			
			ResultSet rs=psmt.executeQuery();
			while(rs.next())
			{
				contact contact=new contact();
				contact.setId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setMobile(rs.getInt(4));
				contact.setUid(rs.getInt(5));
				
				clist.add(contact);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clist;
	}
	
	
	
	public boolean deleteContact(int id,int uid)
	{
		boolean f=false;
		try {
			String query="delete from contact where id=? and uid=?";
			PreparedStatement psmt=this.con.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.setInt(2, uid);
			psmt.executeUpdate();
			
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	public boolean updateContact(String name,String email,int mobile,int id)
	{
		boolean f=false;
		try {
			String q="update contact set name=?, email=?, mobile=? where id=?";
			PreparedStatement psmt=this.con.prepareStatement(q);
			psmt.setString(1, name);
			psmt.setString(2, email);
			psmt.setInt(3, mobile);
			psmt.setInt(4, id);
			psmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
}
