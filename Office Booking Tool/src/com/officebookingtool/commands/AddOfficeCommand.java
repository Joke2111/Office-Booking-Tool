package com.officebookingtool.commands;

import com.officebookingtool.User;
import com.officebookingtool.services.OfficeService;

public class AddOfficeCommand implements Command
{
	protected static final int ADMIN_ACCESS_LEVEL = 5;

	@Override
	public void execute()
	{
		{
			CommandContext context = CommandContext.getInstance();
			User loggedInUser = context.getLoggedInUser();

			if (loggedInUser == null)
			{
				System.out.println("You have to be loged in to have acces to this command");
				return;
			} else
			{
				int loggedUserAccessLevel = loggedInUser.getAccessLevel();
				if (loggedUserAccessLevel == ADMIN_ACCESS_LEVEL)
				{
					OfficeService.AddOffice();
				} else
				{
					System.out.println("You don't have the required access level to use this command!");
				}
			}

		}

	}

}
