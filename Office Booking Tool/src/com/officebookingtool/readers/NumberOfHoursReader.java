package com.officebookingtool.readers;

public class NumberOfHoursReader implements InputReader<Integer>
{

	@Override
	public Integer getValue(String input)
	{
		return Integer.parseInt(input);
	}

	@Override
	public String getErrorMessage()
	{
		return "Invalid input. The number should be an integer from 1 to 12";
	}

	@Override
	public boolean validate(String input)
	{
		try
		{
			int value = Integer.parseInt(input); // Parse the input String to an int value
			return value >= 1 && value <= 12; // Check if the parsed value is between 1 and 5 (inclusive)
		} catch (NumberFormatException e)
		{
			// If the input string cannot be parsed as an integer, return false
			return false;
		}
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "The number of hours has been entered successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Enter the number of hours for which you wish to book the office: ";
	}

}
