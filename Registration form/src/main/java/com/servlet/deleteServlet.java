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
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private registerService userService;
	private Connection con;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("Processing");
		 try {
				con=ConnectionUtil.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
	        System.out.println(con);
	       boolean success = false;
			try {
					userService = new registerService(con);
			       success = userService.removeuser(Integer.parseInt(id));
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
