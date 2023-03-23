package com.officebookingtool.commands;

import com.officebookingtool.database.OfficeDAO;
import com.officebookingtool.models.User;
import com.officebookingtool.services.OfficeService;

public class ViewMyBookingsCommand implements Command
{

	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();
		OfficeService.viewFormatedBookings(OfficeDAO.getBookings(loggedInUser));
	}

}