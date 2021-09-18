package com.revature.models;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Menu {
		
	
	
	public void displayMenu() {
		
		
		Logger log = LogManager.getLogger(Menu.class);
		
		
		
		boolean displayMenu = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*----------------------------------------------------*");
		System.out.println(" WELCOME TO BLEDSOE BANK CUSTOMER MANAGEMENT SYSTEM");
		System.out.println("*----------------------------------------------------*");
		
		while (displayMenu) {
			log.info("Initial menu activated");
			
			System.out.println("~~~~~~~~~~~~~~~~~");
			System.out.println("Choose an option number 1-6");
			System.out.println("~~~~~~~~~~~~~~~~~");
			
			System.out.println("1 - View all customers");
			System.out.println("2 - View customer by id");
			System.out.println("3 - View credit cards");
			System.out.println("4 - View customers by card");
			System.out.println("5 - Add customer");
			System.out.println("6 - Delete customer");
			System.out.println("7 - Update card limit");
			
		
			int input  = scan.nextInt();
			
			switch(input) {
			
			case 1:{
				List<Customer> = 
			}
			
			
			
			
			
			
			
			
			
			
			}
			//Use warn after deleting an employee
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
