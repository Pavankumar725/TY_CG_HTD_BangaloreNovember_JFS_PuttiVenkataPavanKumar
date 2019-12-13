package com.capgemini.phonesimulatorapplication.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.phonesimulatorapplication.bean.ContactInformation;

public class ContactInfoDaoImpl implements ContactInfoDao{
	

	FileReader reader;
	Properties prop;

	 ContactInformation info;
	
	public ContactInfoDaoImpl() {
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
		
			System.out.println("hello");
		}
	
	}
	
	


	@Override
	public List<ContactInformation> getAllContacts() {
		List<ContactInformation> list=new ArrayList<ContactInformation>();
		try(Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = con.createStatement();
				ResultSet rst = stmt.executeQuery(prop.getProperty("query")))
		{
			while(rst.next())
			{
				 ContactInformation info=new ContactInformation();
				info.setNumber(rst.getInt(1));
				info.setName(rst.getString(2));
				info.setGroups(rst.getString(3));
				
				
			}
			return list;
		}
		catch(Exception e)
		{
			
		}
		return null;
		
	}

	@Override
	public ContactInformation search(int contactname) {
		try(Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("")))
		{
			pstmt.setInt(1, contactname);
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
			{
				info=new ContactInformation();
				info.setName(rst.getString(1));
				info.setNumber(rst.getInt(2));
				info.setGroups(rst.getString(3));
				
				
			}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	@Override
	public boolean addContact(ContactInformation c) {
		
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("insertQuery"))){
			pstmt.setInt(1, c.getNumber());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getGroups());
		

			int count = pstmt.executeUpdate();

			if (count > 0)
				return true;		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	

	@Override
	public boolean deleteContact(int contactname) {
		
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("deleteQuery"))) {
			pstmt.setInt(1, contactname);

			int count = pstmt.executeUpdate();
			if (count > 0)
				return true;
		} catch (Exception e) {

		}
		
		return false;
	}
	
	
	

}
