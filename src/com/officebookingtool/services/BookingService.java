package com.officebookingtool.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.officebookingtool.commands.AddOfficeCommand;
import com.officebookingtool.commands.CommandContext;
import com.officebookingtool.database.*;
import com.officebookingtool.models.*;
import com.officebookingtool.presentation.BookingView;
import com.officebookingtool.presentation.OfficeView;

/**
 * The BookingService class provides methods to add a booking and select an office for a user.
 */
public class BookingService
{

	/**
	 * Checks if a new booking is possible by comparing the specified check-in and check-out dates with existing bookings.
	 * 
	 * @param checkInDate      The check-in date of the new booking.
	 * @param checkOutDate     The check-out date of the new booking.
	 * @param existingBookings The list of existing bookings to compare with.
	 * @return true if the new booking is possible, false otherwise.
	 */
	public static boolean isBookingPossible(LocalDateTime CheckInDate, LocalDateTime CheckOutDate, List<Booking> existingBookings)
	{
		for (Booking existingBooking : existingBookings)
		{
			if (CheckInDate.isBefore(existingBooking.getCheckOutDate()) && existingBooking.getCheckInDate().isBefore(CheckOutDate))
				return false;
		}
		return true;
	}

	/**
	 * Checks if the company has any offices. If there are no offices, the method terminates the program if the logged-in user does not have admin access.
	 * Otherwise, it prompts the user to add an office.
	 * 
	 * @return true if the company has at least one office, false otherwise
	 */
	static public boolean checkNumberOfOffices()
	{
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();

		Integer numberOfOffices = OfficeDAO.getNumberOfOffices();
		if (numberOfOffices == null || numberOfOffices == 0)
		{
			int userAccessLevel = loggedInUser.getAccessLevel();
			if (userAccessLevel != AddOfficeCommand.ADMIN_ACCESS_LEVEL)
			{
				System.out.println("The company has no office at this moment. Please contact someone who can add offices!");
				System.out.println("Exiting program...");
				System.exit(0); // terminate the program
			} else if (userAccessLevel == AddOfficeCommand.ADMIN_ACCESS_LEVEL)
			{
				System.out.println(
						"The company has no office at this moment. Please add an office since you have the required access level!");
				return false;
			}
		}
		return true;
	}

	/**
	 * Adds a new booking for the given user.
	 * 
	 * @param user The user for whom the booking is being made.
	 * @return The newly added booking, or null if the booking failed to be added.
	 */
	static public Booking addBooking(User user)
	{

		if (!checkNumberOfOffices())
			return null;

		System.out.println("Please enter your booking details:");

		Office office = selectOffice();

		LocalDate date = BookingView.getDate().toLocalDate();

		LocalTime checkInHour = BookingView.getCheckInHour();

		LocalDateTime currentDateTime = DatabaseUtils.getDbDateTime();

		LocalTime dbTime = DatabaseUtils.getDbTime();

		if (date.isEqual(currentDateTime.toLocalDate()) && checkInHour.compareTo(dbTime) < 0)
		{
			System.out.println("Error: The time you entered has already passed. Please select a future time and try again.");
			return null;
		}

		Integer numberOfHours = BookingView.getNumberOfHours();

		if ((checkInHour.getHour() + numberOfHours) > 20)
		{
			System.out.println("Error: Our offices can only be booked from 8:00 to 20:00");
			return null;
		}

		LocalTime checkOutHour = checkInHour.plusHours(numberOfHours);

		LocalDateTime checkInDate = LocalDateTime.of(date, checkInHour);
		LocalDateTime checkOutDate = LocalDateTime.of(date, checkOutHour);

		int idOfCurrentOffice = OfficeDAO.findOfficeId(office);

		List<Booking> existingBookings = BookingDAO.getAllExistingBookings(idOfCurrentOffice);

		Booking booking;

		if (isBookingPossible(checkInDate, checkOutDate, existingBookings))
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
				System.out.println("Error: Booking addition failed");
				return null;
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
	static public Office selectOffice()
	{
		if (!checkNumberOfOffices())
			return null;

		System.out.println("Here is a list with our offices (name & type):");

		List<Office> offices = OfficeDAO.getAllOffices();

		int i = 1;
		for (Office office : offices)
		{
			System.out.println(i + ". " + office.getOfficeName() + " Office - " + office.getOfficeType());
			i++;
		}

		System.out.println();

		Integer officeNumber = OfficeView.getOfficeSelected();

		return OfficeDAO.getOfficeById(officeNumber);
	}
}
