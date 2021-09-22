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
	public void addCustomer(String f_name, String l_name, double debit_balance, int card_id ) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into customers (f_name,l_name,debit_balance,card_id)"
					+ "values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, f_name);
			ps.setString(2, l_name);
			ps.setDouble(3, debit_balance);
			ps.setInt(4,card_id);
			ps.executeUpdate();
			//String sql2 = "select customer_id from customers where f_name = "
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	
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

	@Override
	public List<Customer> getCustomerByCard(String card) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String cardCap = card.substring(0, 1).toUpperCase() + card.substring(1);
			ResultSet rs = null;
			String sql = "SELECT * FROM customers INNER JOIN credit_cards ON customers.card_id = credit_cards.card_id WHERE card_name = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cardCap);
			
			rs = ps.executeQuery();
			List<Customer> customerList = new ArrayList<>();
			while(rs.next()) {
				Customer c = new Customer(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getInt(5));
				customerList.add(c);
			}
			return customerList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteCustomer(int customer_id) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "delete from customers where customer_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer_id);
			ps.executeUpdate();
			
			System.out.println("Deleting customer " + customer_id);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
