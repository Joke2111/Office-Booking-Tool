package com.officebookingtool.commands;

import com.officebookingtool.models.User;

public class CommandExecutor
{
	private final CommandFactory commandFactory;

	public CommandExecutor(CommandFactory commandFactory)
	{
		this.commandFactory = commandFactory;
	}

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
