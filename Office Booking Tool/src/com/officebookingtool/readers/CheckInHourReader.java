package com.officebookingtool.readers;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class CheckInHourReader implements InputReader<LocalTime>
{

	@Override
	public LocalTime getValue(String input)
	{
		LocalTime time = LocalTime.parse(input);
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
			LocalTime time = LocalTime.parse(input);
			int hour = time.getHour();
			int minute = time.getMinute();
			if (hour < 8 || hour > 19 || minute != 0)
			{
				return false;
			}
			return true;
		} catch (DateTimeParseException e)
		{
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
