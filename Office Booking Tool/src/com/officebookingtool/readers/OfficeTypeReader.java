package com.officebookingtool.readers;

import java.util.Arrays;
import java.util.List;

public class OfficeTypeReader implements InputReader<String>
{

	List<String> allowedOfficeTypes = Arrays.asList("modern", "vintage", "garden", "artistic");

	@Override
	public String getValue(String input)
	{
		return input.trim().toLowerCase();
	}

	@Override
	public String getErrorMessage()
	{
		return "Invalid input. Please enter one of the following office types: "
				+ String.join(", ", allowedOfficeTypes);
	}

	@Override
	public boolean validate(String input)
	{
		return allowedOfficeTypes.contains(input.toLowerCase().trim());
	}

	@Override
	public String getSuccessfulMessage()
	{
		return "Office type entered successfully!";
	}

	@Override
	public String getPrompt()
	{
		return "Enter office type: ";
	}

}
