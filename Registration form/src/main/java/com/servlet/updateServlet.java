package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.registerService;
import com.util.ConnectionUtil;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private registerService Service;
	private Connection con;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		 try {
				con=ConnectionUtil.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		 System.out.println(con);
	        Service = new registerService(con);
	        boolean success=false;
			try {
				success = Service.updateUser(Integer.parseInt(id), firstName, lastName, email, password);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();     
			}
			if(success)
			{
				response.sendRedirect("register.jsp");
			}
	}
}
