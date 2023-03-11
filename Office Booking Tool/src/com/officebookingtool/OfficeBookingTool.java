package com.officebookingtool;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.officebookingtool.database.*;
import com.officebookingtool.readers.*;
import com.officebookingtool.services.OfficeService;
import com.officebookingtool.services.UsersService;

public class OfficeBookingTool
{
	public static void main(String[] args)
	{

		ConsoleReader reader = new ConsoleReader();

		User registeredUser = UsersService.Register();
		User logedUser = UsersService.Login();
		Office addedOffice = OfficeService.AddOffice();

		/*
		
		
		/// BOOKING INFORMATIONS
		LocalDateTime date = reader.read(new DateReader());
		LocalTime checkInHour = reader.read(new CheckInHourReader());
		Integer numberOfHours = reader.read(new NumberOfHoursReader());
		
		LocalTime checkOutHour = checkInHour.plusHours(numberOfHours);
		
		LocalDateTime checkInDate = LocalDateTime.of(date.toLocalDate(), checkInHour);
		LocalDateTime checkOutDate = LocalDateTime.of(date.toLocalDate(), checkOutHour);
		
		Office office1 = new Office(officeName, officeType);
		
		OfficeDAO.addOffice(office1);
		
		int idOfCurrentUser = UserDAO.findUserId(user1);
		int idOfCurrentOffice = OfficeDAO.findOfficeId(office1);
		
		Booking booking1 = new Booking(idOfCurrentUser, idOfCurrentOffice, checkInDate, checkOutDate);
		
		// Adding a new user, office, booking to the database
		
		BookingDAO.addBooking(booking1);*/

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
