package com.revature.models;

import java.util.InputMismatchException;
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
			int input = 8;
		
			try{input  = scan.nextInt();}
			catch(InputMismatchException e) {
				System.out.println("Try again! Enter a number please.");
			}
			scan.nextLine();
			
			
			switch(input) {
			case 0:{
				
				displayMenu = false;
				log.info("Application terminated by user");
				System.exit(0);
			}
			case 1:{
				List<Customer> customerList = cDao.getCustomers();
				System.out.println("----CUSTOMER LIST---");
				log.info("List returning..");
				customerList.stream().forEach(System.out::println);
				break;
			}
			
			case 2:{
				System.out.println("Enter customer id: ");
				int id = scan.nextInt();
				List<Customer> customerList = cDao.getCustomerById(id);
				log.info("List returning..");
				customerList.stream().forEach(System.out::println);
				break;
			}
			case 3:{
				List<CreditCard> cardList = ccDao.getCreditCards();
				
				try {
				cardList.stream().forEach(System.out::println);
				log.info("List returned");
				}
				catch(NullPointerException e) {
					System.out.println("No credit cards found");
					log.error("NullPointer exception caught");
				}
				break;
				
			}
			case 4:{
				System.out.println("Enter a card: Basic, Premier, Travel or Platinum");
				String card = scan.nextLine();
				String transformed = card.substring(0,1).toUpperCase()+card.substring(1);
				try {
				List<Customer> customerList = cDao.getCustomerByCard(card);
				customerList.stream().forEach(System.out::println);
				}
				catch(NullPointerException e) {
					System.out.println("No customers found!");
					log.error("NullPointerException no customers returned");
				}
				break;
				
			}
			case 5:{
				System.out.println("ADDING A CUSTOMER");
				System.out.println("__________________");
				
				System.out.println("Enter First Name: ");
				String f_name = scan.nextLine();
				System.out.println("Enter Last Name: ");
				String l_name = scan.nextLine();
				System.out.println("Enter debit balance: ");
				double debit_balance = scan.nextDouble();
				System.out.println("Enter credit card id: ");
				scan.nextLine();
				int card_id = scan.nextInt();
				cDao.addCustomer(f_name, l_name, debit_balance, card_id);
				log.info("Customer added");
				System.out.println("Customer successfully added with id = ");
				break;
				
			}
			case 6:{
				System.out.println("DELETING A CUSTOMER");
				System.out.println("____________________");
				System.out.println("Enter id to delete: ");
				int id = scan.nextInt();
				scan.nextLine();
				
				cDao.deleteCustomer(id);
				log.warn("Customer deleted from database");
				break;
			}
			
			case 7:{
				System.out.println("UPDATING CARD LIMIT");
				System.out.println("Enter Card to edit: ");
				String card = scan.nextLine();
				System.out.println("Enter new limit: ");
				int limit = scan.nextInt();
				ccDao.updateLimit(card, limit);
				log.info("Card updated");
				break;
				
			}
			
			
			
			
			
			
			}
			
			}
			//Use warn after deleting an employee
			 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

