package com.capgemini.phonesimulatorapplication.bean;

import java.io.Serializable;

public class ContactInformation implements Serializable {
	
	
	private int number;
	private String name;
	private String groups;
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "ContactInformation [number=" + number + ", name=" + name + ", groups=" + groups + "]";
	}
	

}
