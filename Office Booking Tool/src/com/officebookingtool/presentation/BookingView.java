package com.officebookingtool.presentation;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.officebookingtool.readers.*;

public class BookingView
{
	ConsoleReader reader = new ConsoleReader();

	public LocalDateTime getDate()
	{
		LocalDateTime date = reader.read(new DateReader());
		return date;
	}

	public LocalTime getCheckInHour()
	{
		LocalTime checkInHour = reader.read(new CheckInHourReader());
		return checkInHour;
	}

	public Integer getNumberOfHours()
	{
		Integer numberOfHours = reader.read(new NumberOfHoursReader());
		return numberOfHours;
	}

}
