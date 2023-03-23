package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.officebookingtool.models.Office;
import com.officebookingtool.models.Reservation;
import com.officebookingtool.models.User;

/**
 * This class represents a Data Access Object (DAO) for the Office table in the database.
 */
public class OfficeDAO
{

	/**
	 * The SQL statement to insert a new office into the Office table.
	 */
	private static final String INSERT_OFFICE_SQL = "INSERT INTO office (name, type) VALUES (?, ?)";

	/**
	 * Adds a new office to the database.
	 *
	 * @param office The office object to add to the database.
	 * @return True if the office was successfully added, false otherwise.
	 */
	public static boolean addOffice(Office office)
	{
		// Get a connection to the database.
		Connection connection = DatabaseConnector.getConnection();

		try (PreparedStatement statement = connection.prepareStatement(INSERT_OFFICE_SQL))
		{
			// Set the parameters for the prepared statement.
			statement.setString(1, office.getOfficeName());
			statement.setString(2, office.getOfficeType());

			// Execute the prepared statement and get the number of rows affected.
			int rowsInserted = statement.executeUpdate();

			// Return true if at least one row was inserted, false otherwise.
			if (rowsInserted > 0)
			{
				return true;
			}

			return false;

		} catch (SQLException e)
		{
			// Print the error message to the console and return false.
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * The SQL statement to find the ID of an office in the Office table by its name.
	 */
	private static final String FIND_OFFICE_ID_SQL = "SELECT id FROM office WHERE name = ?";

	/**
	 * Finds the ID of the specified office in the database.
	 *
	 * @param office The office object to find the ID for.
	 * @return The ID of the specified office, or null if the office was not found in the database.
	 */
	public static Integer findOfficeId(Office office)
	{
		ResultSet rs = null;

		// Get a connection to the database.
		Connection connection = DatabaseConnector.getConnection();

		try (PreparedStatement statement = connection.prepareStatement(FIND_OFFICE_ID_SQL))
		{
			// Set the parameters for the prepared statement.
			statement.setString(1, office.getOfficeName());

			// Execute the prepared statement and get the result set.
			rs = statement.executeQuery();

			// Return the ID of the office if it was found, or null otherwise.
			if (rs.next())
			{
				return rs.getInt("id");
			}

		} catch (SQLException e)
		{
			// Print the error message to the console.
			System.out.println(e.getMessage());

		} finally
		{
			// Close the result set if it is not null.
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * The SQL statement to select all offices in the Office table.
	 */
	private static final String SELECT_ALL_OFFICES_SQL = "SELECT name, type FROM office";

	/**
	 * Retrieves all offices from the database.
	 *
	 * @return A list of Office objects representing all offices in the database.
	 */
	public static List<Office> getAllOffices()
	{
		List<Office> offices = new ArrayList<>();

		ResultSet resultSet = null;

		// Get a connection to the database.
		Connection connection = DatabaseConnector.getConnection();

		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_OFFICES_SQL))
		{
			resultSet = statement.executeQuery();

			// Iterate through the result set and create Office objects for each row.
			while (resultSet.next())
			{
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				Office office = new Office(name, type);
				offices.add(office);
			}

		} catch (SQLException e)
		{
			// Print the error message to the console.
			e.printStackTrace();

		} finally
		{
			// Close the result set if it is not null.
			if (resultSet != null)
			{
				try
				{
					resultSet.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return offices;
	}

	/**
	 * The SQL statement to select the number of offices in the Office table.
	 */
	private static final String SELECT_NUMBER_OF_OFFICES_SQL = "SELECT COUNT(*) FROM office";

	/**
	 * Retrieves the number of offices in the database.
	 *
	 * @return The number of offices in the database, or null if an error occurred.
	 */
	public static Integer getNumberOfOffices()
	{
		ResultSet rs = null;

		// Get a connection to the database.
		Connection connection = DatabaseConnector.getConnection();

		try (PreparedStatement statement = connection.prepareStatement(SELECT_NUMBER_OF_OFFICES_SQL))
		{
			rs = statement.executeQuery();

			// If the result set contains data, return the count.
			if (rs.next())
			{
				return rs.getInt(1);
			} else
			{
				return null;
			}

		} catch (SQLException e)
		{
			// Print the error message to the console.
			System.out.println(e.getMessage());

		} finally
		{
			// Close the result set if it is not null.
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * The SQL query string used to retrieve an office by its ID.
	 */
	private static final String GET_OFFICE_BY_ID_SQL = "SELECT name, type FROM office WHERE id = ?";

	/**
	 * Retrieves an office from the database based on its ID.
	 *
	 * @param officeNumber the ID of the office to retrieve
	 * @return the Office object with the specified ID, or null if no such office exists
	 */
	public static Office getOfficeById(Integer officeNumber)
	{
		ResultSet rs = null;

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(GET_OFFICE_BY_ID_SQL))
		{
			statement.setInt(1, officeNumber);

			rs = statement.executeQuery();

			if (rs.next())
			{
				String name = rs.getString("name");
				String type = rs.getString("type");

				Office office = new Office(name, type);
				return office;

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
	 * The SQL query string used to retrieve {@link Reservation} by user.
	 */
	private static final String SELECT_REZERVATIONS_SQL = "SELECT booking.check_in_date, booking.check_out_date, office.name "
			+ "FROM booking " + "JOIN office ON booking.office_id = office.id " + "JOIN user ON booking.user_id = user.id "
			+ "WHERE user.username = ?";

	/**
	 * Retrieves a list of reservations for a given user.
	 *
	 * @param user the User object for which to retrieve reservations
	 * @return a List of Reservation objects representing the user's reservations
	 */
	public static List<Reservation> getBookings(User user)
	{
		List<Reservation> bookings = new ArrayList<>();

		ResultSet rs = null;

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement stmt = connection.prepareStatement(SELECT_REZERVATIONS_SQL))
		{
			stmt.setString(1, user.getUsername());
			rs = stmt.executeQuery();

			while (rs.next())
			{
				LocalDateTime checkInTime = rs.getTimestamp("check_in_date").toLocalDateTime();
				LocalDateTime checkOutTime = rs.getTimestamp("check_out_date").toLocalDateTime();
				String officeName = rs.getString("name");
				bookings.add(new Reservation(checkInTime, checkOutTime, officeName));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
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
		return bookings;
	}
}
