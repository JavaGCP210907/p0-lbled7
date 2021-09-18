package com.revature.models;

public class Customer {
	private int customer_id;
	private String f_name;
	private String l_name;
	private double debit_balance;
	private int card_id;
	
	public Customer(int customer_id, String f_name, String l_name, double debit_balance, int card_id) {
		super();
		this.customer_id = customer_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.debit_balance = debit_balance;
		this.card_id = card_id;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public double getDebit_balance() {
		return debit_balance;
	}

	public void setDebit_balance(double debit_balance) {
		this.debit_balance = debit_balance;
	}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + card_id;
		result = prime * result + customer_id;
		long temp;
		temp = Double.doubleToLongBits(debit_balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (card_id != other.card_id)
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (Double.doubleToLongBits(debit_balance) != Double.doubleToLongBits(other.debit_balance))
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", f_name=" + f_name + ", l_name=" + l_name + ", debit_balance="
				+ debit_balance + ", card_id=" + card_id + "]";
	}
	
	
	
	
	
	


}
