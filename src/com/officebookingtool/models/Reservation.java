package com.officebookingtool.models;

import java.time.LocalDateTime;

/**
 * The Reservation class represents a booking only with checkInDate, checkOutDate and additionally officeName. It is used for displaying the bookings of a user.
 */
public class Reservation
{
	private LocalDateTime checkInDate;
	private LocalDateTime checkOutDate;
	private String officeName;

	public Reservation(LocalDateTime checkInDate, LocalDateTime checkOutDate, String officeName)
	{
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.officeName = officeName;
	}

	public LocalDateTime getCheckInDate()
	{
		return checkInDate;
	}

	public LocalDateTime getCheckOutDate()
	{
		return checkOutDate;
	}

	public String getOfficeName()
	{
		return officeName;
	}
}
