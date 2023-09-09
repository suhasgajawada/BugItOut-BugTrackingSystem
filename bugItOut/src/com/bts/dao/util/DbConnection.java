package com.bts.dao.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
public static Connection getConnection() throws ClassNotFoundException,SQLException {
		
		Class.forName(Driver.class.getName());
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bts","root","Nevereverhack@123");
		return connection;
		
	}
}
