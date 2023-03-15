package com.officebookingtool.commands;

import com.officebookingtool.User;

public class CommandContext
{
	private User loggedInUser;

	public User getLoggedInUser()
	{
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser)
	{
		this.loggedInUser = loggedInUser;
	}

	public Command getCommand(String commandName)
	{
		// to be implemented
		return null;
	}
}
