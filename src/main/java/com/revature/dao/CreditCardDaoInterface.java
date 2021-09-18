package com.revature.dao;

import java.util.List;

import com.revature.models.CreditCard;

public interface CreditCardDaoInterface {

	public List<CreditCard> getCreditCards();
	public void updateLimit(String cardName,int limit);
	
}