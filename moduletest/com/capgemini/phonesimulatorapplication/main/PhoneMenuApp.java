package com.capgemini.phonesimulatorapplication.main;

import java.util.Scanner;

import com.capgemini.phonesimulatorapplication.controller.ContactInfoController;

public class PhoneMenuApp {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("enter ur option");
		System.out.println("1.Show  all Contacts");
		System.out.println("2.Search for a Contact");
		System.out.println("3.Operate on Contact");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:ContactInfoController.main(args);
		break;
			
		}
		
	}

	}
}
