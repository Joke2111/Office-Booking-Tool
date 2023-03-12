package com.officebookingtool;

import java.time.LocalDateTime;
import java.util.List;

public class BookingValidation
{
	public static boolean isBookingPossible(LocalDateTime CheckInDate, LocalDateTime CheckOutDate, List<Booking> existingBookings)
	{
		for (Booking existingBooking : existingBookings)
		{
			if (CheckInDate.isBefore(existingBooking.getCheckOutDate()) && existingBooking.getCheckInDate().isBefore(CheckOutDate))
				return false;
		}
		return true;
	}
}
