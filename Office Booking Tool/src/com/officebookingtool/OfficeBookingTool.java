package com.officebookingtool;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.officebookingtool.commands.CommandExecutor;
import com.officebookingtool.database.*;
import com.officebookingtool.presentation.BookingView;
import com.officebookingtool.presentation.OfficeView;
import com.officebookingtool.services.*;

public class OfficeBookingTool
{
	public static void main(String[] args)
	{

		System.out.println("Welcome to the Office Booking Tool!\n"
				+ "To access the booking system, please log in or register. You can type /commands for details on available commands.");

		CommandExecutor executor = new CommandExecutor();
		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			String input = scanner.nextLine();

			if (input.equals("/exit"))
			{
				break;
			}

			executor.executeCommand(input);
		}

		scanner.close();

		// User registeredUser = UsersService.Register();
		// User logedUser = UsersService.Login();

		// Office selectedOffice = OfficeService.SelectOffice();
		// Booking addedBooking = BookingService.AddBooking(logedUser, selectedOffice);

		// Office addedOffice = OfficeService.AddOffice();

		// OfficeService.ViewFormatedBookings(OfficeDAO.getBookings(logedUser));
		// OfficeService.ViewOfficeStatus();

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
