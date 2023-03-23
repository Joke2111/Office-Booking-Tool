package com.officebookingtool.commands;

import com.officebookingtool.models.User;

public class CommandContext
{

	private static CommandContext instance;
	private User loggedInUser;

	private CommandContext()
	{
	}

	public static CommandContext getInstance()
	{
		if (instance == null)
		{
			instance = new CommandContext();
		}
		return instance;
	}

	public User getLoggedInUser()
	{
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser)
	{
		this.loggedInUser = loggedInUser;
	}
}
