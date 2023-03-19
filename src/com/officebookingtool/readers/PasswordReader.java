package com.officebookingtool.readers;

public class PasswordReader implements InputReader<String>
{

	@Override
	public String getValue(String input)
	{
		return input;
	}

	@Override
	public String getErrorMessage()
	{
		return "Password must have at least 5 characters!";
	}

	@Override
	public boolean validate(String input)
	{
		return input.length() >= 5;
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "Password entered successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Enter password: ";
	}

}
