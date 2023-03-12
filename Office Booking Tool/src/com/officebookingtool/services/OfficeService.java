package com.officebookingtool.services;

import java.util.List;

import com.officebookingtool.Office;
import com.officebookingtool.database.OfficeDAO;
import com.officebookingtool.presentation.OfficeView;

public class OfficeService
{
	static public Office AddOffice()
	{
		OfficeView officeView = new OfficeView();

		String officeType = officeView.getOfficeType();
		String officeName = officeView.getOfficeName();

		Office office = new Office(officeName, officeType);

		boolean isOfficeAdded = OfficeDAO.addOffice(office);

		if (isOfficeAdded)
		{
			System.out.println("Office added successfully");
			return (office);
		} else
		{
			System.out.println("Office addition failed");
			/// restructurat return-ul !!!
			return AddOffice();
		}
	}

	static public Office SelectOffice()
	{
		System.out.println("Here is a list with our offices (name & type):");

		List<Office> offices = OfficeDAO.getAllOffices();

		int i = 1;
		for (Office office : offices)
		{
			System.out.println(i + ". " + office.getOfficeName() + " - " + office.getOfficeType());
			i++;
		}

		OfficeView officeView = new OfficeView();
		Integer officeNumber = officeView.getOfficeSelected();

		return OfficeDAO.getOfficeById(officeNumber);
	}

	// nu e added office, o sa fie selected office

}
