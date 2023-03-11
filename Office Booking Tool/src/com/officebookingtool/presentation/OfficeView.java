package com.officebookingtool.presentation;

import com.officebookingtool.readers.ConsoleReader;
import com.officebookingtool.readers.OfficeNameReader;
import com.officebookingtool.readers.OfficeTypeReader;

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
}
