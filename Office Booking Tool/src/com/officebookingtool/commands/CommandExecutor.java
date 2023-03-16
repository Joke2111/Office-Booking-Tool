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
		String commandName = tokens[0];

		Command command = commandFactory.getCommand(commandName);
		command.execute();
	}
}
