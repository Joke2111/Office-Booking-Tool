package com.officebookingtool.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

import com.officebookingtool.database.BookingDAO;
import com.officebookingtool.database.OfficeDAO;
import com.officebookingtool.models.Office;
import com.officebookingtool.models.Reservation;
import com.officebookingtool.presentation.BookingView;
import com.officebookingtool.presentation.OfficeView;

/**
 * The OfficeService class contains methods to add an office, view available time intervals, view the formatted bookings, and view the office status.
 */
public class OfficeService
{
	/**
	 * Adds a new office to the database.
	 * 
	 * @return The office that was added, or recursively calls the method if the addition fails.
	 */
	static public Office addOffice()
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
			return null;
		}
	}

	/**
	 * Displays the available time intervals for a selected office and date.
	 * 
	 * @param bookings A list of SimpleEntry<Integer, Integer> objects representing booking start and end times.
	 */
	public static void displayAvailableTimeIntervals(List<SimpleEntry<Integer, Integer>> bookings)
	{
		boolean[] myArray = new boolean[12];
		boolean isFullyBooked = true;

		for (SimpleEntry<Integer, Integer> booking : bookings)
		{
			Integer bookingStart = booking.getKey() - 8;
			Integer bookingEnd = booking.getValue() - 8;

			for (int i = bookingStart; i < bookingEnd; i++)
				myArray[i] = true;

		}

		for (int i = 0; i <= 11; i++)
		{
			if (myArray[i] == false)
			{
				isFullyBooked = false;

				LocalTime leftHour = LocalTime.of(i + 8, 0, 0);
				LocalTime rightHour = LocalTime.of(i + 9, 0, 0);
				System.out.println(leftHour + " - " + rightHour + " -> free");
			}
		}
		if (isFullyBooked)
		{
			System.out.println("This office is fully booked for this day!");
		}
	}

	/**
	 * Displays the status of the selected office meaning that the user can view the available time intervals.
	 */
	static public void viewOfficeStatus()
	{
		Office selectedOffice = BookingService.selectOffice();
		if (selectedOffice == null)
		{
			return;
		}
		String officeName = selectedOffice.getOfficeName();
		LocalDateTime date = BookingView.getDate();
		List<SimpleEntry<Integer, Integer>> bookings = BookingDAO.viewBookings(date, officeName);

		displayAvailableTimeIntervals(bookings);

	}

	/**
	 * Displays the formatted bookings for the logged-in user.
	 * 
	 * @param bookings A list of Reservation objects representing the user's bookings.
	 */
	public static void viewFormatedBookings(List<Reservation> bookings)
	{
		if (bookings.size() == 0)
		{
			System.out.println("You have not made any bookings yet!");
		} else
		{
			System.out.println("These are your bookings:");

			for (int i = 0; i < bookings.size(); i++)
			{
				Reservation booking = bookings.get(i);
				LocalDateTime checkInTime = booking.getCheckInDate();
				LocalDateTime checkOutTime = booking.getCheckOutDate();
				String officeName = booking.getOfficeName();

				String message = String.format("%d. %s %s to %s at the %s Office", i + 1,
						checkInTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
						checkInTime.format(DateTimeFormatter.ofPattern("HH:mm")), checkOutTime.format(DateTimeFormatter.ofPattern("HH:mm")),
						officeName);
				System.out.println(message);
			}
		}
	}

}
