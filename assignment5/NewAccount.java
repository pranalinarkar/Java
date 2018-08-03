package com.assignment5;

import java.io.IOException;
import java.io.PrintWriter;

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
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String stryr=request.getParameter("DOB");
		String title=request.getParameter("title");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(stryr);
		System.out.println(title);
		
		if(fname== null || lname==null || stryr==null || title==null){
//			response.sendRedirect("new_account.html");
			return;
		}
		
	
		
		if(fname.length()<3&&lname.length()<3){
			System.out.println("Invalid name");		
		}
		else{
		PrintWriter out=response.getWriter();
		out.println("<h2>"+title+"\t"+fname+"\t"+lname+"your acccount creation request is under processing.</hr>");
		doGet(request, response);
	}}

}
