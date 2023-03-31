package com.dao;
import com.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class userLoginDao {
	private Connection connection;
	public userLoginDao(Connection connection)
	{
		this.connection = connection;
	}
	
	public boolean addUser(User user) throws Exception
	{
		PreparedStatement ps = null;
		boolean result = false;
		int updateCnt = 0;
		try 
		{	
			String sql ="insert into users(firstName, lastName, email, password) values (?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			
			result = ps.execute();
			updateCnt = ps.getUpdateCount();
			
			if (updateCnt != 0) 
			{
                result=!result;
            }  
            
        }
        finally {
            if (ps != null) 
            {
                ps.close();
            }
        }
		
		return result;
	}
	
	public List<User> getUser() throws SQLException {
		 PreparedStatement stmt = null;
	     List<User> users = null;
	     try {
	    	String sql = "select * from users";
	    	stmt = connection.prepareStatement(sql);
	    	ResultSet rs =  stmt.executeQuery();
	    	users = new LinkedList<>();
	    	while(rs.next())
	    	{
	    		User user = new User();
	    		user.setId(rs.getInt(1));
	    		user.setFirstName(rs.getString(2));
	    		user.setLastName(rs.getString(3));
	    		user.setEmail(rs.getString(4));
	    		user.setPassword(rs.getString(5));
	    		users.add(user);
	    	}
	     }catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     return users;
		
	}

	public User editUser(int id) throws SQLException {
		PreparedStatement stmt = null;
		User user = new User();
	     try {
	    	String sql = "SELECT * FROM users WHERE id=?";
	    	stmt = connection.prepareStatement(sql);
	    	stmt.setInt(1, id);
	    	ResultSet rs =  stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		user.setId(rs.getInt(1));
	    		user.setFirstName(rs.getString(2));
	    		user.setLastName(rs.getString(3));
	    		user.setEmail(rs.getString(4));
	    		user.setPassword(rs.getString(5));
	    		
	    	}
	     }catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     return user;
	}
	
	public boolean removeUser(int id) {
		PreparedStatement stmt = null;
		boolean result = false;
	     try {
	    	String sql = "DELETE FROM users WHERE id=?";
	    	stmt = connection.prepareStatement(sql);
	    	stmt.setInt(1, id);
	    	int updatecount =  stmt.executeUpdate();
	    	if (updatecount == 0) {
                System.out.println("Insert failed");
            } else {
                result=!result;
            }  
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
		return result;
	}
}
