package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector
{
	private static Connection connection;

	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			throw new RuntimeException("Could not load JDBC driver", e);
		}
	}

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/officebookingtool";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "joke2111";

	public static Connection getConnection()
	{
		try
		{
			if (connection == null)
				connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
			return connection;
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}

	}
}
