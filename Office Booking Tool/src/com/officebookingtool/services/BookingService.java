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

public class BookingService
{
	static public Booking AddBooking(User user, Office office)
	{
		BookingView bookingView = new BookingView();

		System.out.println("Please enter your booking details:");

		LocalDateTime date = bookingView.getDate();
		LocalTime checkInHour = bookingView.getCheckInHour();
		Integer numberOfHours = bookingView.getNumberOfHours();

		LocalTime checkOutHour = checkInHour.plusHours(numberOfHours);

		LocalDateTime checkInDate = LocalDateTime.of(date.toLocalDate(), checkInHour);
		LocalDateTime checkOutDate = LocalDateTime.of(date.toLocalDate(), checkOutHour);

		List<Booking> existingBookings = BookingDAO.getAllExistingBookings();

		Booking booking;

		if (BookingValidation.isBookingPossible(checkInDate, checkOutDate, existingBookings))
		{
			System.out.println("Details inserted successfully!");

			int idOfCurrentUser = UserDAO.findUserId(user);
			int idOfCurrentOffice = OfficeDAO.findOfficeId(office);

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
				return AddBooking(user, office);
			}

		} else
		{
			System.out.println("Error: Booking overlaps with an existing reservation");
			return null;
		}

	}
}
