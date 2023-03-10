package com.officebookingtool;

public class Office
{
	private String officeName;
	private String officeType;

	public Office(String officeName, String officeType)
	{
		this.officeName = officeName;
		this.officeType = officeType;
	}

	public String getOfficeName()
	{
		return officeName;
	}

	public void setOfficeName(String officeName)
	{
		this.officeName = officeName;
	}

	public String getOfficeType()
	{
		return officeType;
	}

	public void setOfficeType(String officeType)
	{
		this.officeType = officeType;
	}
}
