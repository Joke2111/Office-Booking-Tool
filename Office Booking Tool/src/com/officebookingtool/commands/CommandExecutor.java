package com.officebookingtool.commands;

public class CommandExecutor
{
	private CommandContext commandContext;

	public CommandExecutor()
	{
		this.commandContext = new CommandContext();
	}

	public void executeCommand(String input)
	{
		String[] tokens = input.split(" ");
		String commandName = tokens[0];

		Command command = commandContext.getCommand(commandName);
		if (command != null)
		{
			command.execute(commandContext, tokens);
		} else
		{
			System.out.println("Unknown command: " + commandName);
		}
	}
}