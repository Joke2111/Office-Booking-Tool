package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.officebookingtool.models.User;

/**
 * The UserDAO class is responsible for accessing and manipulating user data in the database.
 */
public class UserDAO
{

	/**
	 * The SQL query used to insert a new user into the database.
	 */
	private static final String INSERT_USER_SQL = "INSERT INTO user (username, access_level, type, password) VALUES (?, ?, ?, ?)";

	/**
	 * Adds a new user to the database.
	 *
	 * @param user The user to add.
	 * @return true if the user was successfully added, false otherwise.
	 */
	public static boolean addUser(User user)
	{
		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL))
		{
			statement.setString(1, user.getUsername());
			statement.setInt(2, user.getAccessLevel());
			statement.setString(3, user.getUserType());
			statement.setString(4, user.getPasswordEncrypted());

			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0)
			{
				return true;
			}
			return false;

		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}

	}

	/**
	 * The SQL query used to retrieve the ID of a user by their username.
	 */
	private static final String FIND_USER_ID_SQL = "SELECT id FROM user WHERE username = ?";

	/**
	 * Finds the ID of a user in the database by their username.
	 *
	 * @param user The user to find.
	 * @return The ID of the user, or null if the user was not found.
	 */
	public static Integer findUserId(User user)
	{
		ResultSet rs = null;

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(FIND_USER_ID_SQL))
		{
			statement.setString(1, user.getUsername());

			rs = statement.executeQuery();
			if (rs.next())
			{
				return rs.getInt("id");
			} else
			{
				return null;
			}
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		} finally
		{
			if (rs != null)
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
		}
	}

	/**
	 * The SQL query used to retrieve a user from the database by their username.
	 */
	private static final String GET_USER_BY_USERNAME_SQL = "SELECT * FROM user WHERE username = ?";

	/**
	 * Retrieves a user from the database by their username.
	 *
	 * @param username The username of the user to retrieve.
	 * @return The User object representing the user, or null if the user was not found.
	 */
	public static User getUserByUsername(String username)
	{
		ResultSet rs = null;

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(GET_USER_BY_USERNAME_SQL))
		{
			statement.setString(1, username);

			rs = statement.executeQuery();
			if (rs.next())
			{
				int accessLevel = rs.getInt("access_level");
				String type = rs.getString("type");
				String passwordEncrypted = rs.getString("password");
				User user = new User(username, accessLevel, type, passwordEncrypted);
				return user;
			} else
			{
				return null;
			}
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		} finally
		{
			if (rs != null)
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
		}
	}

	/**
	 * 
	 * SQL query for validating user login.
	 */
	private static final String LOGIN_SQL = "SELECT username FROM user WHERE username = ? AND password = ?";

	/**
	 * 
	 * Validates user login by checking the credentials against the database.
	 * 
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return true if the credentials are valid, false otherwise
	 */
	public static boolean validateLogin(String username, String password)
	{
		ResultSet rs = null;

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(LOGIN_SQL))
		{
			statement.setString(1, username);
			statement.setString(2, password);

			rs = statement.executeQuery();

			if (rs.next())
			{
				return true;
			} else
			{
				return false;
			}
		} catch (SQLException e)
		{
			return false;
		} finally
		{
			if (rs != null)
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
		}
	}

}
