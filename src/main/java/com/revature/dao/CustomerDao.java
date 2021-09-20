package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerDao implements CustomerDaoInterface {

	@Override
	public List<Customer> getCustomers() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from customers";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			
			List<Customer> customerList = new ArrayList<>();
			
			while (rs.next()) {
				
				Customer c = new Customer();
				c.setCustomer_id(rs.getInt(0));
				c.setF_name(rs.getString(1));
				c.setL_name(rs.getString(2));
				c.setDebit_balance(rs.getDouble(3));
				c.setCard_id(rs.getInt(4));
				
				customerList.add(c);
			}
			return customerList;
		}
		catch(SQLException e) {
			System.out.println("Caught exception in getCustomer");
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> getCustomerById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from customers where customer_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			List<Customer> customerList = new ArrayList<>();
			while(rs.next()) {
				Customer c = new Customer(
						rs.getInt(0),
						rs.getString(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getInt(4)
						);
				
				customerList.add(c);
			}
			return customerList;
			
		}
		catch(SQLException e) {
			System.out.println("Problem with connection");
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

}
