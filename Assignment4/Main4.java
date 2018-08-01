package com.pranali;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver="org.apache.derby.jdbc.ClientDriver";
		String url="jdbc:derby://localhost:1527/sample";
		String user="user";
		String pass="pass";
		try(Connection con=ConnectionUtil.getConnection(driver,url,user,pass)){
			Statement st=con.createStatement();
			st.execute("CREATE TABLE Customer(customer_id int primary key,firstName varchar(20),lastName varchar(20),email varchar(20))");
			st.execute("CREATE TABLE Card(id int primary key,expiry Date,customer_id int references Customer(customer_id) ,balance float,credit_limit varchar(20))");
			st.close();
			Customer c=new Customer(1,"Priyal","Narkar","pnarkar@gmail.com");
			Customer c2=new Customer(2,"Nikhil","Narkar","pnarkar@gmail.com");

			
			 //Date date1=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);  
Card c1=new Card(1, java.sql.Date.valueOf("2018-01-01"),2,10000,"100");
		CustomerDAO cus=new CustomerDAO();
		cus.create(c);
		cus.create(c2);
		System.out.println(cus.findById(2).toString());
List<Customer> list=cus.findAll();
Iterator<Customer> it= list.iterator();
while(it.hasNext()){
	System.out.println(it.next().toString());
}
CardDAO ca=new CardDAO();
ca.create(c1);
System.out.println(ca.findById(1).toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
