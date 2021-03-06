package com.assignment5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/transfer.do")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
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
		doGet(request, response);
		String accno1=request.getParameter("accno1");
		String accno2=request.getParameter("accno2");
		String amt1=request.getParameter("amt");
		int accno=Integer.parseInt(accno1);
		int accnod=Integer.parseInt(accno2);
		int amt=Integer.parseInt(amt1);
		if(accno1== null || amt1==null || accno2==null){
			response.sendRedirect("index.html");
			return;
		}
		Transaction transaction=new Transaction();
		
			transaction.transfer(accno,accnod, amt);
	}

}
