package com.officebookingtool.readers;

import com.officebookingtool.database.OfficeDAO;

public class OfficeSelectedReader implements InputReader<Integer>
{

	@Override
	public Integer getValue(String input)
	{
		return Integer.parseInt(input);
	}

	@Override
	public String getErrorMessage()
	{
		return "Invalid number! Please select a number from the options listed above.";
	}

	@Override
	public boolean validate(String input)
	{
		Integer numberOfOffices = OfficeDAO.getNumberOfOffices();
		try
		{
			int value = Integer.parseInt(input); // Parse the input String to an int value
			return value >= 1 && value <= numberOfOffices; // Check if the parsed value is between 1 and 5 (inclusive)
		} catch (NumberFormatException e)
		{
			// If the input string cannot be parsed as an integer, return false
			return false;
		}
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "Office selected successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Please enter the office number you are interested in: ";
	}

}
