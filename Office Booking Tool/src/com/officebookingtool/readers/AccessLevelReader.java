package com.officebookingtool.readers;

public class AccessLevelReader implements InputReader<Integer>
{

	@Override
	public String getErrorMessage()
	{
		return "Invalid number! Please enter a number from 1 to 5!";
	}

	@Override
	public boolean validate(String input)
	{
		try
		{
			int value = Integer.parseInt(input);
			return value >= 1 && value <= 5;
		} catch (NumberFormatException e)
		{
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
		return Integer.parseInt(input);
	}

	@Override
	public String getPrompt()
	{
		return "Enter access level (choose a number between 1 and 5): ";
	}

}
