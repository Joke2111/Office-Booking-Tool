package com.officebookingtool.commands;

import com.officebookingtool.User;
import com.officebookingtool.services.OfficeService;

public class ViewOfficeStatusCommand implements Command
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
			OfficeService.ViewOfficeStatus();
		}
	}
}
