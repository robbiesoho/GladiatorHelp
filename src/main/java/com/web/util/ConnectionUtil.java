package com.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	private String url = System.getenv("url");
//	private String password = System.getenv("password");
//	private String username = System.getenv("username");

//	private String testUrl = "jdbc:postgresql://portodb.czsfcl0hvotw.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=project1test_schema";
	private String url = "jdbc:postgresql://portodb.czsfcl0hvotw.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=project1_schema";
	private String password = "porto";
	private String username = "roberto";
	private static ConnectionUtil instance;

	private ConnectionUtil() {
	}

	public static ConnectionUtil getInstance() {
		if (instance == null) {
			instance = new ConnectionUtil();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
