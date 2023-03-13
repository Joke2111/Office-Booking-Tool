package com.officebookingtool.presentation;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.officebookingtool.readers.*;

public class BookingView
{
	private static ConsoleReader reader = new ConsoleReader();

	public static LocalDateTime getDate()
	{
		LocalDateTime date = reader.read(new DateReader());
		return date;
	}

	public static LocalTime getCheckInHour()
	{
		LocalTime checkInHour = reader.read(new CheckInHourReader());
		return checkInHour;
	}

	public static Integer getNumberOfHours()
	{
		Integer numberOfHours = reader.read(new NumberOfHoursReader());
		return numberOfHours;
	}

}
