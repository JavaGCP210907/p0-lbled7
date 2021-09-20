package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.CreditCardDao;
import com.revature.dao.CustomerDao;



public class Menu {
		
	CreditCardDao ccDao = new CreditCardDao();
	CustomerDao cDao = new CustomerDao(); 
	
	
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
			System.out.println("Choose an option number 1-7, 0 to close");
			System.out.println("~~~~~~~~~~~~~~~~~");
			
			System.out.println("1 - View all customers");
			System.out.println("2 - View customer by id");
			System.out.println("3 - View credit cards");
			System.out.println("4 - View customers by card");
			System.out.println("5 - Add customer");
			System.out.println("6 - Delete customer");
			System.out.println("7 - Update card limit");
			
		
			int input  = scan.nextInt();
			scan.nextLine();
			
			
			switch(input) {
			case 0:{
				
				displayMenu = false;
				System.exit(0);
			}
			case 1:{
				List<Customer> customerList = cDao.getCustomers();
				System.out.println("----CUSTOMER LIST---");
				customerList.stream().forEach(System.out::println);
				break;
			}
			
			case 2:{
				System.out.println("Enter customer id: ");
				int id = scan.nextInt();
				List<Customer> customerList = cDao.getCustomerById(id);
				customerList.stream().forEach(System.out::println);
				break;
			}
			case 3:{
				List<CreditCard> cardList = ccDao.getCreditCards();
				cardList.stream().forEach(System.out::println);
				
				
			}
			case 4:{
				
				
				
			}
			case 5:{
				
				
			}
			
			
			
			
			
			
			
			}
			
			}
			//Use warn after deleting an employee
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

