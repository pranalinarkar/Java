package com.pranali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CustomerDAO implements DAO<Customer> {
	private static final String SQL_SELECT_ID="select customer_id, firstName, lastName,email from Customer where customer_id=?";
	private static final String SQL_INSERT="insert into Customer values(?,?,?,?)";
	private static final String SQL_SELECT="select * from Customer";

	@Override
	public void create(Customer object) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setInt(1, object.getId());
			ps.setString(2, object.getFirstName());
			ps.setString(3, object.getLastName());
			ps.setString(4, object.getEmail());
			ps.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		List<Customer> list=new LinkedList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			Statement st=con.createStatement();
			ResultSet rs  = st.executeQuery(SQL_SELECT);
			while(rs.next()){
				Customer c=new Customer(rs.getInt("customer_id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"));
				list.add(c);
			}
			return list;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public Customer findById(int i) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			Customer e = new Customer();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setEmail(rs.getString(4));
			}

			return e;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

}
