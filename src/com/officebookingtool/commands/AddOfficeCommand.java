package com.officebookingtool.commands;

import com.officebookingtool.models.User;
import com.officebookingtool.services.OfficeService;

public class AddOfficeCommand implements Command
{
	public static final int ADMIN_ACCESS_LEVEL = 5;

	@Override
	public void execute()
	{
		{
			CommandContext context = CommandContext.getInstance();
			User loggedInUser = context.getLoggedInUser();

			int loggedUserAccessLevel = loggedInUser.getAccessLevel();
			if (loggedUserAccessLevel == ADMIN_ACCESS_LEVEL)
			{
				OfficeService.addOffice();
			} else
			{
				System.out.println("You don't have the required access level to use this command!");
			}

		}

	}

}
