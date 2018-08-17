package com.assignment5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAccount
 */
@WebServlet( "/new_account.do" )
public class NewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int accno=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		String id1=request.getParameter("id");
		String type=request.getParameter("type");
		String balance1=request.getParameter("balance");
		
		System.out.println(id1);
		System.out.println(balance1);
		
		
		if(id1== null || type==null || balance1==null){
//			response.sendRedirect("new_account.html");
			return;
		}
		int id=Integer.parseInt(id1);
		int balance=Integer.parseInt(balance1);
		String pin1=null;
		int j;
		StringBuilder sb = new StringBuilder();
	    String candidateChars="1234567890";
	    int length=4;
	    Random random = new Random();
	    
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
}
	    pin1=sb.toString();
		
		int pin=Integer.parseInt(pin1);
		
		PrintWriter out=response.getWriter();
		
		String driver="org.apache.derby.jdbc.ClientDriver";
		String url="jdbc:derby://localhost:1527/sample";
		String user="user";
		String pass="pass";
		try(Connection con=ConnectionUtil.getConnection(driver,url,user,pass)){
			Statement st=con.createStatement();
			
			//st.execute("CREATE TABLE Account(firstName  varchar(20),lastName varchar(20),Title varchar(3),Dob Date,email varchar(20),pass varchar(20),accno int primary key)");
			//accno=10000;
			st.close();
		} 
		
		
		catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println(accno);
		accno=accno+1;
		System.out.println(accno);
		Account acc=new Account(pin,id,balance,type);
		AccountDAO accdao=new AccountDAO();
		accdao.create(acc);
		int accno=accdao.fetch(pin);
		out.println("<h2>Your Account is created!</hr>");
		out.println("<h2>Your Account Number is:</hr>"+accno);
		out.println("<h2>Your Pin is:</hr>"+pin);
		doGet(request, response);
	}

}
