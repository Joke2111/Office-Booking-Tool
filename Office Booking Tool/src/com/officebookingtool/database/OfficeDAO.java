package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.officebookingtool.Office;

public class OfficeDAO
{

	private static final String INSERT_OFFICE_SQL = "INSERT INTO office (name, type) VALUES (?, ?)";

	public static void addOffice(Office office)
	{
		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(INSERT_OFFICE_SQL))
		{

			statement.setString(1, office.getOfficeName());
			statement.setString(2, office.getOfficeType());

			// Execute the prepared statement
			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0)
			{
				System.out.println("A new office was inserted successfully!");
			}
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private static final String FIND_OFFICE_ID_SQL = "SELECT id FROM office WHERE name = ?";

	public static Integer findOfficeId(Office office)
	{
		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(FIND_OFFICE_ID_SQL))
		{
			statement.setString(1, office.getOfficeName());

			ResultSet rs = statement.executeQuery();
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
		}
		return null;
	}
}
