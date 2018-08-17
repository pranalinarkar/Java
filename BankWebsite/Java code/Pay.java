package com.assignment5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Pay
 */
@WebServlet( "/pay-bills.do" )
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL_SELECT="select balance from account where accno=?"; 
	private static final String SQL_INSERT1="update account set balance=? where accno=?";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double balance=0.0;
		String type=request.getParameter("title");
		String accno1=request.getParameter("accno");
		//String etype=request.getParameter("Electric Bill");
		//String ptype=request.getParameter("Phone Bill");
		String amount=request.getParameter("amt");
		System.out.println(type);
		double amt=Double.parseDouble(amount);
		int accno=Integer.parseInt(accno1);
		String provider=null;
		 HttpSession session=request.getSession();
		 String id1=(String) session.getAttribute("id");
	int id=Integer.parseInt(id1);
		if(type==null){
//			response.sendRedirect("new_account.html");
			return;
		}
		if(type.equals("Electric Bill")){
			provider=(String) request.getParameter("Provider1");
		}
		else{
			 provider=(String) request.getParameter("Provider2");
		}
		
		System.out.println(provider);
		
		PrintWriter out=response.getWriter();
		
		
		String driver="org.apache.derby.jdbc.ClientDriver";
		String url="jdbc:derby://localhost:1527/sample";
		String user="user";
		String pass="pass";
		try(Connection con=ConnectionUtil.getConnection(driver,url,user,pass)){
			Statement st=con.createStatement();
			
			//st.execute("CREATE TABLE Payment(accno int references Account(accno),Type varchar(20),Provider varchar(20) ,amount numeric)");
			PreparedStatement ps=con.prepareStatement(SQL_SELECT);
			ps.setInt(1, accno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				 balance=rs.getDouble("balance");
			}
			if(balance>=amt){
				Payment acc=new Payment(accno,type, provider,amt,id);
				PaymentDAO paydao=new PaymentDAO();
				paydao.create(acc);
				System.out.println(acc.toString());
			out.println("<h2>Payment Successful</hr>");
			PreparedStatement ps1=con.prepareStatement(SQL_INSERT1);
			balance-=amt;
			ps1.setDouble(1, balance);
			ps1.setInt(2, accno);
			ps1.executeUpdate();
			}
			else{
				out.println("Insufficient Balance");
			}
			st.close();
		} 
		
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		doGet(request, response);
	
	
	
	}
}
