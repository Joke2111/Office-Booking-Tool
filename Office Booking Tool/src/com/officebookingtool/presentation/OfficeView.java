package com.officebookingtool.presentation;

import com.officebookingtool.readers.*;

public class OfficeView
{
	static ConsoleReader reader = new ConsoleReader();

	public static String getOfficeType()
	{
		String officeType = reader.read(new OfficeTypeReader());
		return officeType;
	}

	public static String getOfficeName()
	{
		String officeName = reader.read(new OfficeNameReader());
		return officeName;
	}

	public static Integer getOfficeSelected()
	{
		Integer officeNumber = reader.read(new OfficeSelectedReader());
		return officeNumber;
	}
}
