package com.officebookingtool.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

import com.officebookingtool.Office;
import com.officebookingtool.database.BookingDAO;
import com.officebookingtool.database.OfficeDAO;
import com.officebookingtool.presentation.BookingView;
import com.officebookingtool.presentation.OfficeView;

public class OfficeService
{
	static public Office AddOffice()
	{
		String officeType = OfficeView.getOfficeType();
		String officeName = OfficeView.getOfficeName();

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

		Integer officeNumber = OfficeView.getOfficeSelected();

		return OfficeDAO.getOfficeById(officeNumber);
	}

	static public void ViewOfficeStatus()
	{
		int[] HourArray = new int[12];

		/// implementation of the hour array system

		String officeName = SelectOffice().getOfficeName();
		LocalDateTime date = BookingView.getDate();
		List<SimpleEntry<Integer, Integer>> bookings = BookingDAO.viewBookings(date, officeName);
	}

}
