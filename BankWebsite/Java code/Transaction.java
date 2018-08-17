package com.assignment5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction {

	private static final String SQL_SELECT_ID="select balance from Account where accno=?";
	private static final String SQL_INSERT="update account set balance = ? where accno = ?";
public Transaction() {
	super();
	
}
public void withdraw(int accno,long amount){
	try(Connection con = ConnectionUtil.getConnection()){
		PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
		ps.setInt(1, accno);
		ResultSet rs=ps.executeQuery();
		int balance=0;
		String balance1=null;
		if(rs.next()){
			 balance1=rs.getString("balance");
		}
		balance=Integer.parseInt(balance1);
			 if(balance>=amount){
				 balance-=amount;
				 System.out.println("Balance after withdraw"+balance);
				 PreparedStatement ps1 = con.prepareStatement(SQL_INSERT);
				 ps1.setDouble(1,balance);
				 ps1.setInt(2,accno);
				 ps1.execute();
			 }
		
	
	}catch(SQLException ex) {
		ex.printStackTrace();
}
}
public void deposit(int accno,long amount){
	try(Connection con = ConnectionUtil.getConnection()){
		PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
		ps.setInt(1, accno);
		ResultSet rs=ps.executeQuery();
		int balance=0;
		String balance1=null;
		if(rs.next()){
			 balance1=rs.getString("balance");
		}
		balance=Integer.parseInt(balance1);
			 
				 balance+=amount;
				 System.out.println("Balance after deposit"+balance);
				 PreparedStatement ps1 = con.prepareStatement(SQL_INSERT);
				 ps1.setDouble(1,balance);
				 ps1.setInt(2,accno);
				 ps1.execute();
		
	
	}catch(SQLException ex) {
		ex.printStackTrace();
}
}
public void transfer(int source,int destination,double amount){
	try(Connection con = ConnectionUtil.getConnection()){
		PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
		ps.setInt(1, source);
		ResultSet rs=ps.executeQuery();
		double balanceatsource=0;
		String balance1=null;
		if(rs.next()){
			 balance1=rs.getString("balance");
		}
		balanceatsource=Integer.parseInt(balance1);
		 if(balanceatsource>=amount){
			 balanceatsource-=amount;
		 }
		 PreparedStatement ps2 = con.prepareStatement(SQL_SELECT_ID);
			ps2.setInt(1, destination);
			ResultSet rs2=ps2.executeQuery();
			double balanceatdestination=0;
			String balance01=null;
			if(rs2.next()){
				 balance01=rs2.getString("balance");
			}
			balanceatdestination=Integer.parseInt(balance01); 
			balanceatdestination=balanceatdestination+amount;
				 System.out.println("Balance after deposit"+balanceatdestination);
				 PreparedStatement ps1 = con.prepareStatement(SQL_INSERT);
				 ps1.setDouble(1,balanceatdestination);
				 ps1.setInt(2,destination);
				
				 ps1.execute();
				 ps1.setDouble(1, balanceatsource);
				 ps1.setInt(2, source);
				 ps1.execute();
		
	
	}catch(SQLException ex) {
		ex.printStackTrace();
}
}
}