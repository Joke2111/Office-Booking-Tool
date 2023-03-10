package com.officebookingtool.readers;

public class UsernameReader implements InputReader<String>
{

	@Override
	public String getValue(String input)
	{
		return input;
	}

	@Override
	public String getErrorMessage()
	{
		return "Invalid username! Username must have at least 3 characters.\nSpaces and special characters except from period, underscore and hyphen are not allowed!";
	}

	@Override
	public boolean validate(String input)
	{
		if (input.matches("^[a-zA-Z0-9._-]{3,}$"))
			return true;
		return false;
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "Username entered successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Enter username: ";
	}

}
