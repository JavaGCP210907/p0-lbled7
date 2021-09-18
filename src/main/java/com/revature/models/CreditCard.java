package com.revature.models;

public class CreditCard {
	private int card_id;
	private String card_name;
	private int card_limit;
	
	public CreditCard(int card_id, String card_name, int card_limit) {
		super();
		this.card_id = card_id;
		this.card_name = card_name;
		this.card_limit = card_limit;
	}

	public CreditCard() {
		super();
		
	}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public int getCard_limit() {
		return card_limit;
	}

	public void setCard_limit(int card_limit) {
		this.card_limit = card_limit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + card_id;
		result = prime * result + card_limit;
		result = prime * result + ((card_name == null) ? 0 : card_name.hashCode());
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
		CreditCard other = (CreditCard) obj;
		if (card_id != other.card_id)
			return false;
		if (card_limit != other.card_limit)
			return false;
		if (card_name == null) {
			if (other.card_name != null)
				return false;
		} else if (!card_name.equals(other.card_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditCard [card_id=" + card_id + ", card_name=" + card_name + ", card_limit=" + card_limit + "]";
	}
	
	
	
	
	
}
