package com.officebookingtool.services;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.officebookingtool.Booking;
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

		int idOfCurrentUser = UserDAO.findUserId(user);
		int idOfCurrentOffice = OfficeDAO.findOfficeId(office);

		Booking booking = new Booking(idOfCurrentUser, idOfCurrentOffice, checkInDate, checkOutDate);

		// Adding a new user, office, booking to the database

		boolean isBookingAdded = BookingDAO.addBooking(booking);

		if (isBookingAdded)
		{
			System.out.println("Booking added successfully");
			return (booking);
		} else
		{
			System.out.println("Booking addition failed");
			/// restructurat return-ul !!!
			return AddBooking(user, office);
		}

	}
}
