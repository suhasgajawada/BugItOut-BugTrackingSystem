package com.bts.dao.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
public static Connection getConnection() {
		Connection connection= null;
		try {
		Class.forName(Driver.class.getName());
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugbase","root","Nevereverhack@123");
		
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
