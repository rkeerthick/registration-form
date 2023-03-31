package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.User;

public class updateUserDao {
		private Connection connection;
		public updateUserDao(Connection connection) {
			 this.connection = connection;
		}
		public boolean updateUser(User user) throws SQLException {
			 PreparedStatement stmt = null;
		        boolean result=false;
		        try {
		            String sql = "UPDATE users SET firstName=?, lastName=?, email=?, password=? where id=?";
		            stmt = connection.prepareStatement(sql);
		            stmt.setString(1, user.getFirstName());
		            stmt.setString(2, user.getLastName());
		            stmt.setString(3, user.getEmail());
		            stmt.setString(4, user.getPassword());
		            stmt.setInt(5, user.getId());
		            int rowCount  = stmt.executeUpdate();
		            if (rowCount == 0) {
		                System.out.println("update failed");
		            } else {
		                System.out.println("update successful, " + rowCount + " rows affected");
		                result=!result;
		            }  
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
		        finally {
		            if (stmt != null) {
		                stmt.close();
		            }
		        }
		        return result;
		}

	
}
