package com.officebookingtool.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.officebookingtool.Booking;

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
}
