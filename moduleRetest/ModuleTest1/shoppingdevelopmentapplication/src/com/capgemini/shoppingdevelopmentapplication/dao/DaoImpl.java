package com.capgemini.shoppingdevelopmentapplication.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.shoppingdevelopmentapplication.bean.UserBean;
import com.capgemini.shoppingdevelopmentapplication.factory.Factory;

public class DaoImpl implements Dao {
	

	FileReader reader;
	Properties prop;
	UserBean user = Factory.getUserBean();

	public DaoImpl() {
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			System.out.println("hello");
			
		}
	}
	
	List<UserBean> list=new ArrayList<UserBean>();
	
	@Override
	public List<UserBean> getAllItems() {
		try( Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(prop.getProperty("Query1"))){
			
			
			while(rs.next()) {
				user=new UserBean();
				user.setProductid(rs.getInt(1));
				user.setProductname(rs.getString(2));
				user.setProductcolor(rs.getString(3));
				user.setProductdesc(rs.getString(4));
				user.setProductcost(rs.getInt(5));
				user.setNoofproducts(rs.getInt(6));
				
				list.add(user);
				
			}
			
			

	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	
	}

	@Override
	public boolean addDetails(UserBean user) {
		
		
		try( Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("add"))){
			
			pstmt.setInt(1, user.getProductid());
			pstmt.setString(2, user.getProductname());
			pstmt.setString(3, user.getProductcolor());
			pstmt.setString(4, user.getProductdesc());
			pstmt.setInt(5, user.getProductcost());
			pstmt.setInt(6, user.getNoofproducts());
			
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else
			{
				return false;
			}
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
	
		return false;
	}

	@Override
	public UserBean searchProduct(String name) {
		
		try( Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));PreparedStatement pstmt= conn.prepareStatement(prop.getProperty("search"))){
			pstmt.setString(1,name);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
			user=new UserBean();
			user.setProductid(rs.getInt(1));
			user.setProductname(rs.getString(2));
			user.setProductcolor(rs.getString(3));
			user.setProductdesc(rs.getString(4));
			user.setProductcost(rs.getInt(5));
			user.setNoofproducts(rs.getInt(6));
			
			return user;
			}
			else
			{
				System.err.println("enter valid product name");
			}
			
				
				
			
				
				
			}catch(Exception e) {
				e.getMessage();
			}
			
		
		
		
		
		return null;
	}
		
}
