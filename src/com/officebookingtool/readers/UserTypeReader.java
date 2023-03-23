package com.officebookingtool.readers;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Implementation of the {@link InputReader} interface for reading the type of an user from the console.
 */
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
		String userTypes = String.join(", ", allowedUserTypes);

		return "Available users types: " + userTypes + "\n" + "Enter user type: ";
	}

}
