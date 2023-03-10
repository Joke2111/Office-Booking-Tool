package com.officebookingtool.readers;

import java.util.Arrays;
import java.util.List;

public class UserTypeReader implements InputReader<String>
{

	List<String> allowedUserTypes = Arrays.asList("developer", "tester", "product manager", "database administrator");

	@Override
	public String getValue(String input)
	{
		return input.trim().toLowerCase();
	}

	@Override
	public String getErrorMessage()
	{
		return "Invalid input. Please enter one of the following user types: " + String.join(", ", allowedUserTypes);
	}

	@Override
	public boolean validate(String input)
	{
		return allowedUserTypes.contains(input.toLowerCase().trim());
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "User type entered successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Enter user type: ";
	}

}
