package com.officebookingtool.readers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateReader implements InputReader<LocalDateTime>
{

	// Helper method to get the number of days in a month for a given year
	private static int daysInMonth(int month, int year)
	{
		if (month == 2)
		{
			if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			{
				return 29; // leap year
			} else
			{
				return 28; // non-leap year
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
		// Create a DateTimeFormatter to parse the input string
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		// Parse the input string into a LocalDateTime object
		LocalDateTime dateTime = LocalDateTime.parse(input + " 00:00", formatter);

		// Return the LocalDateTime object
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
		// Check that the input string has the correct length and format
		if (input.length() != 10 || input.charAt(2) != '-' || input.charAt(5) != '-')
		{
			return false;
		}

		// Extract the day, month, and year from the string
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

		// Check that the day, month, and year are valid
		if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1)
		{
			return false;
		}

		// Check that the number of days is valid for the given month and year
		if (day > daysInMonth(month, year))
		{
			return false;
		}

		// The date is valid
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
