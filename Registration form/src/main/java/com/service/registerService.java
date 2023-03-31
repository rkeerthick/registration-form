package com.service;

import java.sql.Connection;
import java.util.List;
import java.sql.*;

import com.dao.updateUserDao;
import com.dao.userLoginDao;
import com.model.User;


public class registerService {
	private userLoginDao userLoginDao ;
	private updateUserDao userupdate;
	public registerService(Connection connection)
	{
		userLoginDao = new userLoginDao(connection);
		userupdate = new updateUserDao(connection);
	}
	
	public boolean register(String firstName, String lastName, String email, String password) throws Exception
	{
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		return userLoginDao.addUser(user);
	}
	
	 public List<User> getUsers() throws SQLException {
			return userLoginDao.getUser();
	    	
    }
	public User getuser(String id) throws NumberFormatException, SQLException {
		System.out.println(id);
		return userLoginDao.editUser(Integer.parseInt(id));
	}
	public boolean updateUser(int id, String firstName, String lastName, String email, String password) throws SQLException {
		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		return  userupdate.updateUser(user);
	}
	
	public boolean removeuser(int id) {
		return userLoginDao.removeUser(id);
	}
}
