package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDaoInterface {

	
	public List<Customer> getCustomers();
	
	public List<Customer> getCustomerById(int id);
	public List<Customer> getCustomerByCard(String card);
	void addCustomer(String f_name, String l_name, double debit_balance, int card_id);
	void deleteCustomer(int customer_id);
}
