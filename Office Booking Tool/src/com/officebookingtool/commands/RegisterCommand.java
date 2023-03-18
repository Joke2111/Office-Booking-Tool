package com.officebookingtool.commands;

import com.officebookingtool.User;
import com.officebookingtool.services.UsersService;

public class RegisterCommand implements Command
{

	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();
		if (loggedInUser == null)
		{
			context.setLoggedInUser(UsersService.Register());
		} else
		{
			System.out.println("You are already logged!");
		}
	}

}
