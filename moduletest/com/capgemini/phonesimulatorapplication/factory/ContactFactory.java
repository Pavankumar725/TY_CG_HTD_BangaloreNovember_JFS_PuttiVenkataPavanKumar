package com.capgemini.phonesimulatorapplication.factory;

import com.capgemini.phonesimulatorapplication.dao.ContactInfoDaoImpl;
import com.capgemini.phonesimulatorapplication.dao.ContactInfoDao;

public class ContactFactory {
	

	

	public static ContactInfoDaO instanceOfContactInfodaoImpl() {
		ContactInfoDao dao = new ContactInfoDaoImpl();
		return dao;
	}


}
