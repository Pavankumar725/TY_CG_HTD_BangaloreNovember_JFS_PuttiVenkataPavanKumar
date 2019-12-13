package com.capgemini.phonesimulatorapplication.dao;

import java.util.List;

import com.capgemini.phonesimulatorapplication.bean.ContactInformation;

public interface ContactInfoDao {
	
	
	public List<ContactInformation> getAllContacts();
	
	public  ContactInformation search(int contactname);
	
	public boolean addContact(ContactInformation c);
	
	public boolean deleteContact(int contactname);
	
	
	

}
