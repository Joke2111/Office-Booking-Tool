package com.officebookingtool;

import java.time.LocalDateTime;

/**
 * The Booking class represents a booking with a user ID, office ID, check-in date, and check-out date.
 * The class provides getters and setters for the last inserted user/office id and for the check in/out date
 */
public class Booking
{
	private int lastInsertedUserId;
	private int lastInsertedOfficeId;
	private LocalDateTime checkInDate;
	private LocalDateTime checkOutDate;

	  /**
     * Constructs a new booking with the specified user ID, office ID, check-in date, and check-out date.
     * 
     * @param lastInsertedUserId The ID of the user who made the booking.
     * @param lastInsertedOfficeId The ID of the office that was booked.
     * @param checkInDate The check-in date of the booking.
     * @param checkOutDate The check-out date of the booking.
     */
	public Booking(int lastInsertedUserId, int lastInsertedOfficeId, LocalDateTime checkInDate,
			LocalDateTime checkOutDate)
	{
		this.lastInsertedUserId = lastInsertedUserId;
		this.lastInsertedOfficeId = lastInsertedOfficeId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public int getLastInsertedUserId()
	{
		return lastInsertedUserId;
	}

	public void setLastInsertedUserId(int lastInsertedUserId)
	{
		this.lastInsertedUserId = lastInsertedUserId;
	}

	public int getLastInsertedOfficeId()
	{
		return lastInsertedOfficeId;
	}

	public void setLastInsertedOfficeId(int lastInsertedOfficeId)
	{
		this.lastInsertedOfficeId = lastInsertedOfficeId;
	}

	public LocalDateTime getCheckInDate()
	{
		return checkInDate;
	}

	public void setCheckInDate(LocalDateTime checkInDate)
	{
		this.checkInDate = checkInDate;
	}

	public LocalDateTime getCheckOutDate()
	{
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDateTime checkOutDate)
	{
		this.checkOutDate = checkOutDate;
	}
}
