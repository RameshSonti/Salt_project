package com.dal.csv.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MYSQL Drive Loaded");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static Connection getNewConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "test", "test");
		} catch (SQLException e) {
			System.err.println("Exception occured while creating database connection " + e);
		}
		return null;

	}
}
