package com.officebookingtool.commands;

import com.officebookingtool.models.User;
import com.officebookingtool.services.BookingService;

/**
 * The MakeABooking class implements the {@link Command} interface to define the logic for making a new booking. This command adds a new booking for
 * the currently logged-in user.
 */
public class MakeABooking implements Command
{

	/**
	 * Executes the logic for making a new booking. This command adds a new booking for the currently logged-in user.
	 */
	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();
		BookingService.addBooking(loggedInUser);
	}
}
