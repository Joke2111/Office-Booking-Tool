package com.officebookingtool.readers;

/**
 * 
 * Implementation of the {@link InputReader} interface for reading an office name from the console.
 */
public class OfficeNameReader implements InputReader<String>
{

	@Override
	public String getValue(String input)
	{
		return input;
	}

	@Override
	public String getErrorMessage()
	{
		return "Invalid username! Office name must have at least 3 characters. Special characters are not allowed!";
	}

	@Override
	public boolean validate(String input)
	{
		if (input.matches("^[a-zA-Z0-9 ]{3,}$"))
			return true;
		return false;
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "Office name entered successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Enter office name: ";
	}

}
