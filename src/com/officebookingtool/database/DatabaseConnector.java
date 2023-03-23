package com.officebookingtool.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The DatabaseConnector class provides a utility for creating and obtaining a connection to a MySQL database.
 */
public class DatabaseConnector
{

	/**
	 * The connection object for the MySQL database.
	 */
	private static Connection connection;

	/**
	 * The properties object for the MySQL database connection.
	 */
	private static Properties props;

	/**
	 * A static initializer block that loads the MySQL JDBC driver and reads the database properties file.
	 *
	 * @throws RuntimeException if the JDBC driver cannot be loaded or the database properties file cannot be read.
	 */
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

	/**
	 * Returns a connection to the MySQL database.
	 *
	 * @return the connection to the MySQL database
	 * @throws RuntimeException if the connection cannot be established
	 */
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
