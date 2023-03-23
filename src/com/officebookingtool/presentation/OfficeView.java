package com.officebookingtool.presentation;

import com.officebookingtool.readers.*;

/**
 * The {@code OfficeView} class provides static methods to read input from the user through the console, for the purpose of selecting an office.
 */
public class OfficeView
{

	/**
	 * Reads and returns a {@code String} representing the type of office selected by the user.
	 *
	 * @return the type of office selected by the user.
	 */
	public static String getOfficeType()
	{
		ConsoleReader reader = new ConsoleReader();
		String officeType = reader.read(new OfficeTypeReader());
		return officeType;
	}

	/**
	 * Reads and returns a {@code String} representing the name of the office selected by the user.
	 *
	 * @return the name of the office selected by the user.
	 */
	public static String getOfficeName()
	{
		ConsoleReader reader = new ConsoleReader();
		String officeName = reader.read(new OfficeNameReader());
		return officeName;
	}

	/**
	 * Reads and returns an {@code Integer} representing the number of the office selected by the user.
	 *
	 * @return the number of the office selected by the user.
	 */
	public static Integer getOfficeSelected()
	{
		ConsoleReader reader = new ConsoleReader();
		Integer officeNumber = reader.read(new OfficeSelectedReader());
		return officeNumber;
	}
}
