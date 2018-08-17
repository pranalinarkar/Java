package com.assignment5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
@WebServlet( "/new_user.do" )
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String stryr=request.getParameter("DOB");
		String pass1=request.getParameter("pass");
		String title=request.getParameter("title");
		String pan=request.getParameter("pan");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(stryr);
		System.out.println(title);
		
		if(fname== null || lname==null || stryr==null || title==null || email==null ||pan==null){
//			response.sendRedirect("new_account.html");
			return;
		}
		
	
		
		if(fname.length()<3&&lname.length()<3){
			System.out.println("Invalid name");		
		}
		else{
		PrintWriter out=response.getWriter();
		out.println("<h2>"+title+"\t"+fname+"\t"+lname+", Your Profile creation request is under processing.</hr>");
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
		
		
		UserDetails acc=new UserDetails(fname,lname,title,stryr,email,pass1,pan);
		UserDetailsDAO accdao=new UserDetailsDAO ();
		accdao.create(acc);
		int id=accdao.fetch(pan);
		out.println("<h2>Your Account is created!</hr>");
		out.println("<h2>Your ID is:</hr>"+id);
		doGet(request, response);
	
	}
	}
	}
