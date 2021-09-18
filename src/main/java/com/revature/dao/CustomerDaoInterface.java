package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDaoInterface {

	
	public List<Customer> getCustomers();
	public int addCustomer(Customer customer);
	public List<Customer> getCustomerById(int id);
}
