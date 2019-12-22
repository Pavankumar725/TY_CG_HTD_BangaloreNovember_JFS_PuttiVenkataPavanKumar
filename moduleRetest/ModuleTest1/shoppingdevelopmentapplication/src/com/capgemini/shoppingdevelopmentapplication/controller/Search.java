package com.capgemini.shoppingdevelopmentapplication.controller;

import java.util.Scanner;

import com.capgemini.shoppingdevelopmentapplication.bean.UserBean;
import com.capgemini.shoppingdevelopmentapplication.dao.Dao;
import com.capgemini.shoppingdevelopmentapplication.factory.Factory;

public class Search {

	public static void search() {
		Dao d = Factory.instanceOfDaoImpl();
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("1.add the products");
			System.out.println("2.search the product by name");
			System.out.println("3. Back to home");
			System.out.println("Enter ur choice");
			int ch = sc.nextInt();
			switch (ch) {

			case 1:
				UserBean user = new UserBean();
				System.out.println("enter product id");
				user.setProductid(sc.nextInt());
				System.out.println("enter product name");
				user.setProductname(sc.next());
				System.out.println("enter product colour");
				user.setProductcolor(sc.next());
				System.out.println("enter product desc");
				user.setProductdesc(sc.next());
				System.out.println("enter product cost");
				user.setProductcost(sc.nextInt());
				System.out.println("enter no of products");
				user.setNoofproducts(sc.nextInt());

				if (d.addDetails(user)) {
					System.out.println("product details saved");
				} else {
					System.err.println("something went wrong");
				}
				break;

			case 2:
				UserBean user1 = new UserBean();

				System.out.println("enter product name to search");
				UserBean u = d.searchProduct(sc.next());
				if (u == null) {
					System.err.println("no product is there");
					Main.main(null);
				} else {
					System.out.println(u);
					
				while(true) {
					
				
				
					System.out.println("1.enter to buy the product ");
					System.out.println("2.back to search");
					System.out.println("3.Back menu");
					System.out.println("enter ur choice");
					switch (ch) {

					case 1:

					

						System.out.println("enter product id");
						user1.setProductid(sc.nextInt());

						System.out.println("enter card number");
						int cardnumber = sc.nextInt();
						System.out.println("enter cvv number");
						int cvv = sc.nextInt();
						System.out.println("enter products");
						int s = sc.nextInt();
						if (s > 0) {
							System.out.println("enter address for delivery");
							user1.setProductdesc(sc.next());
						System.out.println("user1.setProductid(sc.nextInt());");	
						
							
						} 
			

						else {
							System.out.println("no products");
						}
						break;

					case 2:
						Main.main(null);

						break;
					case 3:
						Search.search();
						break;
						
					

					}
					break;

				}
				break;
				}
			case 3:

				Main.main(null);
				break;

			}
		}
	}

}
