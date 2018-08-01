package com.pranali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CardDAO implements DAO<Card> {
	private static final String SQL_SELECT_ID="select id, expiry, customer_id,balance,credit_limit from Card where id=?";
	private static final String SQL_INSERT="insert into Card values(?,?,?,?,?)";
	private static final String SQL_SELECT="select * from Card";
	@Override
	public void create(Card object) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setInt(1, object.getId());
			ps.setDate(2, object.getExpiry());
			ps.setInt(3, object.getCustomer_id());
			ps.setFloat(4, object.getBalance());
			ps.setString(5, object.getCredit_limit());
			ps.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Card> findAll() {
		// TODO Auto-generated method stub
		List<Card> list=new LinkedList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			Statement st=con.createStatement();
			ResultSet rs  = st.executeQuery(SQL_SELECT);
			while(rs.next()){
				Card c=new Card(rs.getInt("id"),rs.getDate("expiry"),rs.getInt("customer_id"),rs.getFloat("balance"),rs.getString("credit_limit"));
				list.add(c);
			}
			return list;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Card findById(int i) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			Card e = new Card();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setExpiry(rs.getDate(2));
				e.setCustomer_id(rs.getInt(3));
				e.setBalance(rs.getFloat(4));
				e.setCredit_limit(rs.getString(5));
			}

			return e;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

}
