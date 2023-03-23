package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.officebookingtool.models.User;

public class UserDAO
{
	private static final String INSERT_USER_SQL = "INSERT INTO user (username, access_level, type, password) VALUES (?, ?, ?, ?)";

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

	private static final String FIND_USER_ID_SQL = "SELECT id FROM user WHERE username = ?";

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

	private static final String GET_USER_BY_USERNAME_SQL = "SELECT * FROM user WHERE username = ?";

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

	private static final String LOGIN_SQL = "SELECT username FROM user WHERE username = ? AND password = ?";

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
