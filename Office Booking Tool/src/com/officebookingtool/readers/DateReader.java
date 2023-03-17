package com.officebookingtool.readers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateReader implements InputReader<LocalDateTime>
{
	private static int daysInMonth(int month, int year)
	{
		if (month == 2)
		{
			if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			{
				return 29;
			} else
			{
				return 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11)
		{
			return 30;
		} else
		{
			return 31;
		}
	}

	@Override
	public LocalDateTime getValue(String input)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		LocalDateTime dateTime = LocalDateTime.parse(input + " 00:00", formatter);

		return dateTime;
	}

	@Override
	public String getErrorMessage()
	{
		return "Invalid date! Make sure that the date is in the following format DD-MM-YYYY";
	}

	@Override
	public boolean validate(String input)
	{
		if (input.length() != 10 || input.charAt(2) != '-' || input.charAt(5) != '-')
		{
			return false;
		}

		int day, month, year;
		try
		{
			day = Integer.parseInt(input.substring(0, 2));
			month = Integer.parseInt(input.substring(3, 5));
			year = Integer.parseInt(input.substring(6, 10));
		} catch (NumberFormatException e)
		{
			return false;
		}

		if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1)
		{
			return false;
		}

		if (day > daysInMonth(month, year))
		{
			return false;
		}

		return true;
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "Date entered successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Enter the date in the following format DD-MM-YYYY: ";
	}

}
