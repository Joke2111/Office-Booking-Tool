package com.officebookingtool.commands;

/**
 * 
 * This class represents a command to view the available commands in the application.
 * 
 * It implements the {@link Command} interface.
 */
public class ViewCommandsCommand implements Command
{
	@Override
	public void execute()
	{
		System.out.println("Available commands:");
		System.out.println("/login - Command used to log in");
		System.out.println("/register - Command used to register a new user");
		System.out.println("/addoffice - Command used to add a new office *only for users with access level = "
				+ AddOfficeCommand.ADMIN_ACCESS_LEVEL + "*");
		System.out.println("/makebook - Command used to make a new booking");
		System.out.println("/officestatus - Command used to view available hours of an office on a specific day");
		System.out.println("/mybookings - Command used to view all the bookings made by the current user");
		System.out.println("/exit - Command used to exit the app");
	}

}
