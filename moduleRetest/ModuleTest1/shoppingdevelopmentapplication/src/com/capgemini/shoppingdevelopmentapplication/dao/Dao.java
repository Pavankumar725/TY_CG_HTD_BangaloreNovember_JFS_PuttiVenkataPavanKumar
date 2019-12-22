package com.capgemini.shoppingdevelopmentapplication.dao;

import java.util.List;

import com.capgemini.shoppingdevelopmentapplication.bean.UserBean;

public interface Dao {
	public List<UserBean> getAllItems();
	public boolean addDetails(UserBean user);
	public UserBean searchProduct(String name);

}
