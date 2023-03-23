package com.officebookingtool.commands;

import com.officebookingtool.services.UsersService;

/**
 * The LoginCommand class implements the {@link Command} interface to define the logic for logging in a user. This command prompts the user to enter
 * their login credentials, and then sets the logged-in user in the CommandContext singleton.
 */
public class LoginCommand implements Command
{

	/**
	 * Executes the logic for logging in a user. This command prompts the user to enter their login credentials, and then sets the logged-in user in the
	 * CommandContext singleton.
	 */
	@Override
	public void execute()
	{
		CommandContext context = CommandContext.getInstance();
		context.setLoggedInUser(UsersService.login());
	}
}
