package com.capgemini.shoppingdevelopmentapplication.factory;

import com.capgemini.shoppingdevelopmentapplication.bean.UserBean;
import com.capgemini.shoppingdevelopmentapplication.dao.Dao;
import com.capgemini.shoppingdevelopmentapplication.dao.DaoImpl;

public class Factory {
	
private Factory() {
		
	}
	public static Dao instanceOfDaoImpl() {
		Dao dao=new DaoImpl();
		return dao;
		
	}
	
	public static UserBean getUserBean() {
		
		return new UserBean();
	}

}
