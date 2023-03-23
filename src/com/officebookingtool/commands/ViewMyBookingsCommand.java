package com.officebookingtool.commands;

import com.officebookingtool.database.OfficeDAO;
import com.officebookingtool.models.User;
import com.officebookingtool.services.OfficeService;

/**
 * 
 * This class represents a command to view all bookings made by the current user.
 * 
 * It implements the {@link Command} interface.
 */
public class ViewMyBookingsCommand implements Command
{
	/**
	 * 
	 * This method executes the command by retrieving the current user from the CommandContext, calling the OfficeDAO to get all bookings made by the
	 * current user, and then calling the OfficeService to format and print the list of bookings to the console.
	 */
	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();
		OfficeService.viewFormatedBookings(OfficeDAO.getBookings(loggedInUser));
	}

}