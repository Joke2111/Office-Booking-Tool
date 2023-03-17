package com.officebookingtool.commands;

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

		Command command = commandFactory.getCommand(commandName);

		if (command == null)
		{
			System.out.println("Unknown command");
		} else
		{
			command.execute();
		}
	}
}
