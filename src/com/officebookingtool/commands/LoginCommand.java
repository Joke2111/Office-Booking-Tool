package com.officebookingtool.commands;

import com.officebookingtool.services.UsersService;

public class LoginCommand implements Command
{

	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		context.setLoggedInUser(UsersService.login());
	}

}
