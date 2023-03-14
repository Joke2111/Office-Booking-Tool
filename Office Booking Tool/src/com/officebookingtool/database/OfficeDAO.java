package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.officebookingtool.Office;
import com.officebookingtool.Reservation;
import com.officebookingtool.User;

public class OfficeDAO
{

	private static final String INSERT_OFFICE_SQL = "INSERT INTO office (name, type) VALUES (?, ?)";

	public static boolean addOffice(Office office)
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
				return true;
			}
			return false;

		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
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

	private static final String SELECT_ALL_OFFICES_SQL = "SELECT name, type FROM office";

	public static List<Office> getAllOffices()
	{
		List<Office> offices = new ArrayList<>();

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_OFFICES_SQL))
		{
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next())
			{
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");

				Office office = new Office(name, type);
				offices.add(office);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return offices;
	}

	private static final String SELECT_NUMBER_OF_OFFICES_SQL = "SELECT COUNT(*) FROM office";

	public static Integer getNumberOfOffices()
	{
		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(SELECT_NUMBER_OF_OFFICES_SQL))
		{
			ResultSet rs = statement.executeQuery();
			if (rs.next())
			{
				return rs.getInt(1);
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

	private static final String GET_OFFICE_BY_ID_SQL = "SELECT name, type FROM office WHERE id = ?";

	public static Office getOfficeById(Integer officeNumber)
	{
		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(GET_OFFICE_BY_ID_SQL))
		{
			statement.setInt(1, officeNumber);

			ResultSet rs = statement.executeQuery();
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
			/// de ce mai tb sa arat exceptia cand eu dau return si practic o tratez in
			/// service
			return null;
		}
	}

	private static final String SELECT_REZERVATIONS_SQL = "SELECT booking.check_in_date, booking.check_out_date, office.name "
			+ "FROM booking " + "JOIN office ON booking.office_id = office.id " + "JOIN user ON booking.user_id = user.id "
			+ "WHERE user.username = ?";

	public static List<Reservation> getBookings(User user)
	{
		List<Reservation> bookings = new ArrayList<>();

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement stmt = connection.prepareStatement(SELECT_REZERVATIONS_SQL))
		{
			stmt.setString(1, user.getUsername());
			ResultSet rs = stmt.executeQuery();

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
		}
		return bookings;
	}
}
