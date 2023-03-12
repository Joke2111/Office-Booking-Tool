package com.officebookingtool;

import java.sql.Connection;
import java.sql.SQLException;

import com.officebookingtool.database.*;
import com.officebookingtool.services.*;

public class OfficeBookingTool
{
	public static void main(String[] args)
	{
		// User registeredUser = UsersService.Register();
		User logedUser = UsersService.Login();

		Office selectedOffice = OfficeService.SelectOffice();
		// Office addedOffice = OfficeService.AddOffice();

		Booking addedBooking = BookingService.AddBooking(logedUser, selectedOffice);

		Connection connection = DatabaseConnector.getConnection();
		try
		{
			connection.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
