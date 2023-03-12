package com.officebookingtool.presentation;

import com.officebookingtool.readers.*;

public class OfficeView
{
	ConsoleReader reader = new ConsoleReader();

	public String getOfficeType()
	{
		String officeType = reader.read(new OfficeTypeReader());
		return officeType;
	}

	public String getOfficeName()
	{
		String officeName = reader.read(new OfficeNameReader());
		return officeName;
	}

	public Integer getOfficeSelected()
	{
		Integer officeNumber = reader.read(new OfficeSelectedReader());
		return officeNumber;
	}
}
