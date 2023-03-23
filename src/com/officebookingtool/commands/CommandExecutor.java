package com.officebookingtool.commands;

import com.officebookingtool.models.User;

/**
 * The CommandExecutor class is responsible for executing user commands based on the input received. It uses the CommandFactory class to retrieve the
 * appropriate Command object and execute it.
 */
public class CommandExecutor
{

	private final CommandFactory commandFactory;

	/**
	 * Constructs a new CommandExecutor object with the specified CommandFactory instance.
	 *
	 * @param commandFactory the CommandFactory instance to use for retrieving Command objects
	 */
	public CommandExecutor(CommandFactory commandFactory)
	{
		this.commandFactory = commandFactory;
	}

	/**
	 * Executes the specified user command by splitting the input string and retrieving the corresponding Command object from the CommandFactory. It then
	 * checks the user's login status and the type of command being executed to determine whether the command should be executed or if an error message
	 * should be displayed.
	 *
	 * @param input the user command to execute
	 */
	public void executeCommand(String input)
	{
		String[] tokens = input.split(" ");

		if (tokens.length != 1)
		{
			System.out.println("Unknown command");
			return;
		}

		String commandName = tokens[0];
		CommandContext context = CommandContext.getInstance();
		User loggedInUser = context.getLoggedInUser();

		Command command = commandFactory.getCommand(commandName);

		boolean isLoginOrRegisterCommand = (command instanceof LoginCommand || command instanceof RegisterCommand);
		boolean isUserLoggedIn = (loggedInUser != null);

		if (command == null)
		{
			System.out.println("Unknown command");
		} else if (command instanceof ViewCommandsCommand)
		{
			command.execute();
		} else if (isUserLoggedIn && isLoginOrRegisterCommand)
		{
			System.out.println("You are already logged!");
		} else if (!isUserLoggedIn && !isLoginOrRegisterCommand)
		{
			System.out.println("You have to be logged in to have access to this command");
		} else
		{
			command.execute();
		}
	}
}
