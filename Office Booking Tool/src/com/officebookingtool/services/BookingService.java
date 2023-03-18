package com.officebookingtool.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.officebookingtool.Booking;
import com.officebookingtool.BookingValidation;
import com.officebookingtool.Office;
import com.officebookingtool.User;
import com.officebookingtool.database.*;
import com.officebookingtool.presentation.BookingView;
import com.officebookingtool.presentation.OfficeView;

/**
 * The BookingService class provides methods to add a booking and select an office for a user.
 */
public class BookingService
{

	/**
	 * Adds a new booking for the given user.
	 * 
	 * @param user The user for whom the booking is being made.
	 * @return The newly added booking, or null if the booking failed to be added.
	 */
	static public Booking AddBooking(User user)
	{
		System.out.println("Please enter your booking details:");

		Office office = SelectOffice();

		LocalDateTime date = BookingView.getDate();

		LocalTime checkInHour = BookingView.getCheckInHour();
		Integer numberOfHours = BookingView.getNumberOfHours();

		if ((checkInHour.getHour() + numberOfHours) > 20)
		{
			System.out.println("Our offices can only be booked from 8:00 to 20:00");
			return null;
		}

		LocalTime checkOutHour = checkInHour.plusHours(numberOfHours);

		LocalDateTime checkInDate = LocalDateTime.of(date.toLocalDate(), checkInHour);
		LocalDateTime checkOutDate = LocalDateTime.of(date.toLocalDate(), checkOutHour);

		int idOfCurrentOffice = OfficeDAO.findOfficeId(office);

		List<Booking> existingBookings = BookingDAO.getAllExistingBookings(idOfCurrentOffice);

		Booking booking;

		if (BookingValidation.isBookingPossible(checkInDate, checkOutDate, existingBookings))
		{
			System.out.println("Details inserted successfully!");

			int idOfCurrentUser = UserDAO.findUserId(user);

			booking = new Booking(idOfCurrentUser, idOfCurrentOffice, checkInDate, checkOutDate);

			boolean isBookingAdded = BookingDAO.addBooking(booking);

			if (isBookingAdded)
			{
				System.out.println("Booking added successfully!");
				return (booking);
			} else
			{
				System.out.println("Booking addition failed");
				/// restructurat return-ul !!!
				return AddBooking(user);
			}

		} else
		{
			System.out.println("Error: Booking overlaps with an existing reservation");
			return null;
		}

	}

	/**
	 * Displays a list of all available offices and prompts the user to select one.
	 * 
	 * @return The office selected by the user.
	 */
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

		System.out.println();

		Integer officeNumber = OfficeView.getOfficeSelected();

		return OfficeDAO.getOfficeById(officeNumber);
	}
}
