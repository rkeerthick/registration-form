package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.registerService;
import com.util.ConnectionUtil;

/**
 * Servlet implementation class editServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private registerService Service;
	private Connection con;
	private User user;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(request.getParameter("id"));
		HttpSession session = request.getSession();
		 try {
				con=ConnectionUtil.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
	        System.out.println(con);
	       
			try {
					Service = new registerService(con);
			        user = Service.getuser(id);
			        con.close();
			} catch (SQLException e) {
				e.printStackTrace();     
			}
			if(user!=null)
			{
				session.setAttribute("user", user);
				response.sendRedirect("editRecord.jsp");
			}
		
	}

}
