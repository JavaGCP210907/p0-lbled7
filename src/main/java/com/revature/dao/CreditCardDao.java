package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.CreditCard;
import com.revature.util.ConnectionUtil;

public class CreditCardDao implements CreditCardDaoInterface {

	@Override
	public List<CreditCard> getCreditCards() {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs = null;
			String sql = "select * from credit_cards order by card_id";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			List<CreditCard> cardList = new ArrayList<>();
			
			while(rs.next()) {
				
				CreditCard c = new CreditCard();
				c.setCard_id(rs.getInt(1));
				c.setCard_name(rs.getString(2));
				c.setCard_limit(rs.getInt(3));
				cardList.add(c);
				
				
				
			}
			return cardList;
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateLimit(String cardName, int limit) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE credit_cards set card_limit = ? where card_name = ?  ";
			String cN = cardName.substring(0,1).toUpperCase()+cardName.substring(1);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			ps.setString(2,cN );
			
			ps.executeUpdate();
			
			System.out.println("Credit card " + cN + "'s limit has been updated to " +"$"+ limit);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	}

}
