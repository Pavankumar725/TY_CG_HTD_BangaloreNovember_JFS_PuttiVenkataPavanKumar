package com.capgemini.shoppingdevelopmentapplication.bean;

import java.io.Serializable;

public class UserBean  implements Serializable{
	
	private int productid;
	private String productname;
	private String productcolor;
	private String productdesc;
	private int productcost;
	private int noofproducts;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductcolor() {
		return productcolor;
	}
	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public int getProductcost() {
		return productcost;
	}
	public void setProductcost(int productcost) {
		this.productcost = productcost;
	}
	public int getNoofproducts() {
		return noofproducts;
	}
	public void setNoofproducts(int noofproducts) {
		this.noofproducts = noofproducts;
	}
	@Override
	public String toString() {
		return "UserBean [productid=" + productid + ", productname=" + productname + ", productcolor=" + productcolor
				+ ", productdesc=" + productdesc + ", productcost=" + productcost + ", noofproducts=" + noofproducts
				+ "]";
	}
	
	
	

}
