package com.officebookingtool.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * The CommandFactory class provides a way to create instances of Command objects based on a command name. The class uses a map to associate command
 * names with Command objects.
 */
public class CommandFactory
{

	private Map<String, Command> commandMap;

	/**
	 * Creates a new instance of the CommandFactory class and initializes the command map with mappings from command names to Command objects.
	 */
	public CommandFactory()
	{
		commandMap = new HashMap<>();
		commandMap.put("/login", new LoginCommand());
		commandMap.put("/commands", new ViewCommandsCommand());
		commandMap.put("/register", new RegisterCommand());
		commandMap.put("/addoffice", new AddOfficeCommand());
		commandMap.put("/makebook", new MakeABooking());
		commandMap.put("/officestatus", new ViewOfficeStatusCommand());
		commandMap.put("/mybookings", new ViewMyBookingsCommand());
	}

	/**
	 * Returns the Command object associated with the specified command name.
	 *
	 * @param commandName the name of the command to get.
	 * @return the Command object associated with the specified command name.
	 */
	public Command getCommand(String commandName)
	{
		return commandMap.get(commandName);
	}
}
