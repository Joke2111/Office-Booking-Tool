package com.officebookingtool;

import java.time.LocalDateTime;

public class Booking
{
	private int lastInsertedUserId;
	private int lastInsertedOfficeId;
	private LocalDateTime checkInDate;
	private LocalDateTime checkOutDate;

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
