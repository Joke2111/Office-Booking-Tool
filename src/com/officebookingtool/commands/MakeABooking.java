package com.officebookingtool.commands;

import com.officebookingtool.User;
import com.officebookingtool.services.BookingService;

public class MakeABooking implements Command
{

	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();
		if (loggedInUser == null)
		{
			System.out.println("You have to be logged in to have access to this command");
		} else
		{
			BookingService.AddBooking(loggedInUser);
		}

	}

}
