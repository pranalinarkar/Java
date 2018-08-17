package com.assignment5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO implements DAO<Payment> {
	private static final String SQL_INSERT="insert into Payment values(?,?,?,?)";
	
	@Override
	public void create(Payment object) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			
			ps.setInt(1, object.getAccno());
			ps.setString(2, object.getType());
			ps.setString(3, object.getProvider());
			ps.setDouble(4, object.getAmt());
			
			ps.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
}
	}

}
