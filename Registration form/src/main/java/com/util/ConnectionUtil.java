package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regform", "root", "abcdefg");
		if(con != null) System.out.println("Connected");
		else System.out.println("Not Connected");
		return con;
	}
}

