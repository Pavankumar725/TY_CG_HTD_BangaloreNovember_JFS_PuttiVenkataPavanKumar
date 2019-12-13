package com.capgemini.phonesimulatorapplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.phonesimulatorapplication.bean.ContactInformation;
import com.capgemini.phonesimulatorapplication.dao.ContactInfoDaoImpl;

public class ContactInfoController {


	public static void main(String[] args) {

		ContactInfoDaoImpl contactInfoDaoImpl=new ContactInfoDaoImpl();

		Scanner sc=new Scanner(System.in);

		while(true) {

			System.out.println("enter ur choice");
			System.out.println("1.get all contacts");
			System.out.println("2.Add contact");
			System.out.println("3.delete contact");
			System.out.println("4.search contact");

			int ch=sc.nextInt();


					switch(ch) {
					case 1: ContactInformation contactInformation=new ContactInformation();
					  List<ContactInformation>  list1= new  ArrayList<ContactInformation>();
					  System.out.println(contactInfoDaoImpl.getAllContacts());
					  break;
					  
					case 2:
						ContactInformation d1=new ContactInformation();

						System.out.println("enter contact number");
						d1.setNumber(sc.nextInt());
						System.out.println("enter contactname");
						d1.setName(sc.toString());
						System.out.println("enter contactgroup");
						d1.setGroups(sc.toString());
						




						break;
					   

					}



		}

	}

}
