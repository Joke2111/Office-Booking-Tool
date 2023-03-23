package com.officebookingtool.commands;

import com.officebookingtool.models.User;
import com.officebookingtool.services.BookingService;

public class MakeABooking implements Command
{

	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();
		BookingService.addBooking(loggedInUser);
	}

}
