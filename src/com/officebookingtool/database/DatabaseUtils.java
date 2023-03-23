package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DatabaseUtils
{
	private static final String SELECT_DATETIME_SQL = "SELECT NOW()";

	public static LocalDateTime getDbDateTime()
	{
		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(SELECT_DATETIME_SQL))
		{

			ResultSet rs = statement.executeQuery();

			if (rs.next())
			{
				LocalDateTime timestamp = rs.getTimestamp(1).toLocalDateTime();
				return timestamp;
			} else
			{
				return null;
			}
		} catch (SQLException e)
		{
			return null;
		}
	}

	private static final String SELECT_TIME_SQL = "SELECT TIME_FORMAT(NOW(), '%H:%i')";

	public static LocalTime getDbTime()
	{
		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(SELECT_TIME_SQL))
		{

			ResultSet rs = statement.executeQuery();

			if (rs.next())
			{
				LocalTime time = LocalTime.parse(rs.getString(1));
				return time;
			} else
			{
				return null;
			}
		} catch (SQLException e)
		{
			return null;
		}
	}

}
