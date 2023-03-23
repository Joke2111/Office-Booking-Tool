package com.officebookingtool.presentation;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.officebookingtool.readers.*;

/**
 * The {@code BookingView} class provides static methods to read input from the user through the console, for the purpose of creating a booking.
 */
public class BookingView
{

	/**
	 * Reads and returns a {@code LocalDateTime} object from the user through the console.
	 *
	 * @return the date selected by the user.
	 */
	public static LocalDateTime getDate()
	{
		ConsoleReader reader = new ConsoleReader();
		LocalDateTime date = reader.read(new DateReader());
		return date;
	}

	/**
	 * Reads and returns a {@code LocalTime} object representing the check-in hour from the user through the console.
	 *
	 * @return the check-in hour selected by the user.
	 */
	public static LocalTime getCheckInHour()
	{
		ConsoleReader reader = new ConsoleReader();
		LocalTime checkInHour = reader.read(new CheckInHourReader());
		return checkInHour;
	}

	/**
	 * Reads and returns an integer representing the number of hours for the booking from the user through the console.
	 *
	 * @return the number of hours selected by the user.
	 */
	public static Integer getNumberOfHours()
	{
		ConsoleReader reader = new ConsoleReader();
		Integer numberOfHours = reader.read(new NumberOfHoursReader());
		return numberOfHours;
	}
}
