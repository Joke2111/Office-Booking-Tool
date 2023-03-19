package com.officebookingtool;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The BookingValidation class provides a static method to check if a booking is possible based on a specified check-in date,
 * check-out date, and a list of existing bookings.
 */
public class BookingValidation
{
    /**
     * Checks if a new booking is possible by comparing the specified check-in and check-out dates with existing bookings.
     * 
     * @param checkInDate The check-in date of the new booking.
     * @param checkOutDate The check-out date of the new booking.
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
}
