package com.capgemini.shoppingdevelopmentapplication.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.shoppingdevelopmentapplication.bean.UserBean;
import com.capgemini.shoppingdevelopmentapplication.dao.Dao;
import com.capgemini.shoppingdevelopmentapplication.factory.Factory;

public class Main {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		

		System.out.println("1.show all product details");
		
		System.out.println("2.Search for an item");
		
		System.out.println("enter ur choice");
		
		int ch=sc.nextInt();
		
		Dao d=Factory.instanceOfDaoImpl();

		System.out.println("shopping development application");
		
			
			switch(ch) {
			
			
			
			case 1:

				List<UserBean> list=d.getAllItems();
				if(list!=null) {
					for (UserBean user : list) {
						System.out.println(user);

					}

				}
				else {
					System.out.println("contact not present");
				}
				
				break;

				
			case 2:
				Search.search();
				break;
			


			}
		}

	}
	


