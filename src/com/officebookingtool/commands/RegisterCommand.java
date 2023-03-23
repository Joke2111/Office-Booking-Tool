package com.officebookingtool.commands;

import com.officebookingtool.services.UsersService;

/**
 * The RegisterCommand class implements the {@link Command} interface to define the logic for registering a new user. This command prompts the user to
 * enter their registration details, and then sets the logged-in user in the CommandContext singleton.
 */
public class RegisterCommand implements Command
{

	/**
	 * Executes the logic for registering a new user. This command prompts the user to enter their registration details, and then sets the logged-in user
	 * in the CommandContext singleton.
	 */
	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		context.setLoggedInUser(UsersService.register());
	}
}
