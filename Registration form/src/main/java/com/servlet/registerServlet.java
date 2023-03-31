
package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.registerService;
import com.util.ConnectionUtil;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String firstName = request.getParameter("first-name");
		 String lastName = request.getParameter("last-name");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 
		 Connection connection = null;
		 
		 try {
//			 ConnectionUtil obj = new ConnectionUtil();
			 connection =    ConnectionUtil.getConnection();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 boolean result = false;
		 
		 try {
			 registerService obj = new registerService(connection);
			 result = obj.register(firstName, lastName, email, password);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 if(result)
		 {
			 response.sendRedirect("register.jsp");
		 }
	}

}
