package com.officebookingtool.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector
{
	private static Connection connection;
	private static Properties props;

	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			props = new Properties();
			InputStream input = DatabaseConnector.class.getResourceAsStream("/resources/database.properties");
			props.load(input);
		} catch (ClassNotFoundException e)
		{
			throw new RuntimeException("Could not load JDBC driver", e);
		} catch (IOException e)
		{
			throw new RuntimeException("Could not read database properties file", e);
		}
	}

	public static Connection getConnection()
	{
		try
		{
			if (connection == null)
				connection = DriverManager.getConnection(props.getProperty("database_url"), props.getProperty("database_user"),
						props.getProperty("database_password"));
			return connection;
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
}
