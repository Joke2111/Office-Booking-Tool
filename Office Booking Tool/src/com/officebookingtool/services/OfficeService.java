package com.officebookingtool.services;

import com.officebookingtool.Office;
import com.officebookingtool.database.OfficeDAO;
import com.officebookingtool.presentation.OfficeView;

public class OfficeService
{
	static public Office AddOffice()
	{
		OfficeView officeView = new OfficeView();

		String officeName = officeView.getOfficeName();
		String officeType = officeView.getOfficeType();

		Office office = new Office(officeName, officeType);

		boolean isOfficeAdded = OfficeDAO.addOffice(office);

		if (isOfficeAdded)
		{
			System.out.println("Office added successfully");
			return (office);
		} else
		{
			System.out.println("Office addition failed");
			return AddOffice();
		}
	}
}
