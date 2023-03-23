package com.officebookingtool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.officebookingtool.commands.CommandExecutor;
import com.officebookingtool.commands.CommandFactory;
import com.officebookingtool.database.*;

/**
 * The {@code OfficeBookingTool} class is responsible for running the Office Booking Tool application. It provides the main method to start the
 * application, which includes setting up the CommandExecutor and listening to user input from the command line. When the user exits the application,
 * it closes the database connection.
 */
public class OfficeBookingTool
{
	private static void runApp()
	{
		System.out.println("Welcome to the Office Booking Tool!\n"
				+ "To access the booking system, please log in or register. You can type /commands for details on available commands.");

		CommandExecutor executor = new CommandExecutor(new CommandFactory());

		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			System.out.print("\n> ");
			String input = scanner.nextLine();
			System.out.println();

			if (input.equals("/exit"))
			{
				System.out.println("Thank you for using our application!\n");
				break;
			}

			executor.executeCommand(input);
		}

		scanner.close();
	}

	public static void main(String[] args)
	{

		runApp();

		Connection connection = DatabaseConnector.getConnection();
		try
		{
			connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
