package com.org.Service;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;
import com.org.Generic.LdapConnectivity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> myMapVariable;
		String userName = request.getParameter("Username");
		String password = request.getParameter("password");
		
		
		
		try {
		
//		sqlConnectionFactory sql = new sqlConnectionFactory();
//		connection = sql.getConnection();
//		
//		System.out.println("the data retrieved from connection is =" + connection);
		myMapVariable = LdapConnectivity.authenticateAD(userName, password);
		if(myMapVariable != null){
			System.out.println("this is matching Username" + myMapVariable.get("sAMAccountName") + userName);
			if(myMapVariable.get("sAMAccountName").equalsIgnoreCase(userName)){
				request.setAttribute("Title", myMapVariable.get("title"));
				request.getRequestDispatcher("HomePage.jsp").forward(request,response);
				}
			
		}else{
			request.getRequestDispatcher("Login.jsp").forward(request,response);
		}
		
		
		
//		System.out.println("map Variables : " + myMapVariable);
//		
//		System.out.println("TITLE :- "+myMapVariable.get("title"));
//		System.out.println("Name :- "+myMapVariable.get("sAMAccountName"));
//		System.out.println("Domain :- "+myMapVariable.get("memberOf"));
//		System.out.println("Manager :- "+myMapVariable.get("manager"));

		
		
		//create a separate class
		

		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
