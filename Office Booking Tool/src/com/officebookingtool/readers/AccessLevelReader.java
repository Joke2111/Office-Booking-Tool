package com.officebookingtool.readers;

public class AccessLevelReader implements InputReader<Integer> /// toate T urile o sa fie inlocuite cu tipul lui
																/// InputReader, adica in acest caz Integer
{

	@Override
	public String getErrorMessage()
	{
		return "Please enter a number from 1 to 5!";
	}

	@Override
	public boolean validate(String input)
	{
		try
		{
			int value = Integer.parseInt(input); // Parse the input String to an int value
			return value >= 1 && value <= 5; // Check if the parsed value is between 1 and 5 (inclusive)
		} catch (NumberFormatException e)
		{
			// If the input string cannot be parsed as an integer, return false
			return false;
		}
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "Access level entered successfully!";
	}

	@Override
	public Integer getValue(String input)
	{
		/// transform din string in int (dar nu numai)
		return Integer.parseInt(input);
	}

	@Override
	public String getPrompt()
	{
		return "Enter access level (choose a number between 1 and 5): ";
	}

}
