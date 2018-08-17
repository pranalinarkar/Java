package com.assignment5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DAO <Account>{
	private static final String SQL_INSERT="insert into Account (pin,id,balance,type)values(?,?,?,?)";
	private static final String SQL_SELECT="select accno from Account where pin=?";
	private static final String SQL = "select * from account where id=?";
	@Override
	public void create(Account object) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			
			
			ps.setInt(1, object.getPin());
			ps.setInt(2, object.getId());
			
			ps.setDouble(3, object.getBalance());
			ps.setString(4, object.getType());
		
			ps.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
}
	}
	public int fetch(int pin){
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			ps.setInt(1, pin);
			ResultSet rs = ps.executeQuery();
			rs.next();
		System.out.println(rs.getInt(1));
			int accno=rs.getInt(1);
			return accno;
			
		
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return 0;
}
	}
	
	public static List<Account> getAccount(int id){
		List<Account> accounts=new ArrayList<>(); 
		try
	      {
	      
	         Connection con=ConnectionUtil.getConnection();
	         //Statement statement = con.createStatement() ;
	        PreparedStatement ps=con.prepareStatement(SQL);
	        ps.setInt(1, id);
	        
	         ResultSet rs = ps.executeQuery();
	         while(rs.next()){
	        	 Account account=new Account();
	         account.setAccno(rs.getInt("accno"));
	         account.setPin(rs.getInt("pin"));
	         account.setId(rs.getInt("id"));
	         account.setBalance(rs.getDouble("balance"));
	         account.setType(rs.getString("type"));
	         accounts.add(account);}
	     }
	     catch(SQLException e)
	     {e.printStackTrace();
	     }
		return accounts;
	}

}
     