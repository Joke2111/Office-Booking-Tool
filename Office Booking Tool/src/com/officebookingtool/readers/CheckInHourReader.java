package com.officebookingtool.readers;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class CheckInHourReader implements InputReader<LocalTime>
{

	@Override
	public LocalTime getValue(String input)
	{
		LocalTime time = LocalTime.parse(input); // parse the input string to a LocalTime object
		return time;
	}

	@Override
	public String getErrorMessage()
	{
		return "Invalid hour. The first available booking starts at 08:00 and the last booking is at 19:00";
	}

	@Override
	public boolean validate(String input)
	{
		try
		{
			LocalTime time = LocalTime.parse(input); // parse the input string to a LocalTime object
			int hour = time.getHour(); // get the hour from the LocalTime object
			int minute = time.getMinute(); // get the hour from the LocalTime object
			if (hour < 8 || hour > 19 || minute != 0)
			{ // check if the hour is outside the range of 8 to 19
				return false;
			}
			return true;
		} catch (DateTimeParseException e)
		{ // catch an exception if the input is not in the expected format
			return false;
		}
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "The check-in hour has been entered successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Enter the check-in hour in the following format HH:00 : ";
	}

}
