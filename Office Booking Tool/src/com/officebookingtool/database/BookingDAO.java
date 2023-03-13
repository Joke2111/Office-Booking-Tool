package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import com.officebookingtool.Booking;
import com.officebookingtool.Office;

public class BookingDAO
{

	private static final String INSERT_BOOKING_SQL = "INSERT INTO booking (user_id, office_id, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";

	public static boolean addBooking(Booking booking)
	{/// de modificat pt login si rezolvat exeptionurile

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING_SQL))
		{

			statement.setInt(1, booking.getLastInsertedUserId());
			statement.setInt(2, booking.getLastInsertedOfficeId());
			statement.setObject(3, booking.getCheckInDate());
			statement.setObject(4, booking.getCheckOutDate());

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

	private static final String SELECT_ALL_BOOKINGS_SQL = "SELECT * FROM booking";

	public static List<Booking> getAllExistingBookings()
	{
		List<Booking> existingBookings = new ArrayList<>();

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOKINGS_SQL))
		{
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next())
			{
				int lastInsertedUserId = resultSet.getInt("user_id");
				int lastInsertedOfficeId = resultSet.getInt("office_id");
				LocalDateTime checkInDate = resultSet.getTimestamp("check_in_date").toLocalDateTime();
				LocalDateTime checkOutDate = resultSet.getTimestamp("check_out_date").toLocalDateTime();

				Booking booking = new Booking(lastInsertedUserId, lastInsertedOfficeId, checkInDate, checkOutDate);

				existingBookings.add(booking);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return existingBookings;
	}

	private static final String GET_BOOKED_INTERVALS_SQL = "SELECT HOUR(check_in_date), HOUR(check_out_date) " + "FROM booking "
			+ "JOIN office ON booking.office_id = office.id " + "JOIN user ON booking.user_id = user.id " + "WHERE DATE(check_in_date) = ? "
			+ "AND office.name = ?";

	public static List<SimpleEntry<Integer, Integer>> viewBookings(LocalDateTime date, String officeName)
	{
		List<SimpleEntry<Integer, Integer>> bookings = new ArrayList<>();

		Connection connection = DatabaseConnector.getConnection();
		try (PreparedStatement stmt = connection.prepareStatement(GET_BOOKED_INTERVALS_SQL))
		{

			stmt.setDate(1, java.sql.Date.valueOf(date.toLocalDate()));
			stmt.setString(2, officeName);

			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				int checkInDate = rs.getInt(1);
				int checkOutDate = rs.getInt(2);
				SimpleEntry<Integer, Integer> interval = new SimpleEntry<>(checkInDate, checkOutDate);
				bookings.add(interval);
			}
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
			System.out.println("ai intrat pe catch");
		}
		return bookings;
	}

}
