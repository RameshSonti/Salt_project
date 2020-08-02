package com.dal.csvreader.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class provide mysql connection
 * 
 *
 */
public class MySQLConnector {

	//static block run at the time of class loading into jvm
	static {
		try {
			// Load MySQL driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public static Connection createNewConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "test", "test");
		} catch (SQLException e) {
			System.err.println("Exception occured while creating database connection " + e);
		}
		return null;
	}
}
