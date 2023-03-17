package com.officebookingtool.commands;

import com.officebookingtool.User;
import com.officebookingtool.database.OfficeDAO;
import com.officebookingtool.services.OfficeService;

public class ViewMyBookingsCommand implements Command
{

	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();
		if (loggedInUser == null)
		{
			System.out.println("You have to be loged in to have acces to this command");
		} else
		{
			OfficeService.ViewFormatedBookings(OfficeDAO.getBookings(loggedInUser));
		}
	}

}
