package com.bts.dao.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection= null;
		try {
		Class.forName(Driver.class.getName());
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugbase","root","Nevereverhack@123");
		
		}catch(SQLException e) {
			throw new SQLException(e.getMessage());
		}catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(e.getMessage());
		}
		return connection;
	}
}
