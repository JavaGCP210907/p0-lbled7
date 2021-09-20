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
				c.setCustomer_id(rs.getInt(1));
				c.setF_name(rs.getString(2));
				c.setL_name(rs.getString(3));
				c.setDebit_balance(rs.getDouble(4));
				c.setCard_id(rs.getInt(5));
				
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
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into customers (f_name,l_name,debit_balance,card_id)"
					+ "values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getF_name());
			ps.setString(2, customer.getL_name());
			ps.setDouble(3, customer.getDebit_balance());
			ps.setInt(4,customer.getCard_id());
			
			ps.executeUpdate();
			
			System.out.println("Customer" + customer.getF_name()+ "created");
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
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
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getInt(5)
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
