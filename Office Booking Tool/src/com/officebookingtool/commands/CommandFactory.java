package com.officebookingtool.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory
{
	private Map<String, Command> commandMap;

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

	public Command getCommand(String commandName)
	{
		return commandMap.get(commandName);
	}
}