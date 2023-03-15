package com.officebookingtool.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory
{
	public static Map<String, Command> createCommands()
	{
		Map<String, Command> commands = new HashMap<>();

		commands.put("/login", new LoginCommand());
		commands.put("/register", new RegisterCommand());
		commands.put("/addoffice", new AddOfficeCommand());
		commands.put("/makebook", new MakeABooking());
		commands.put("/viewavailablebookings", new ViewAvailableBookingsCommand());
		commands.put("/viewallbookings", new ViewAllBookingsCommand());

		return commands;
	}
}