package com.officebookingtool.commands;

import com.officebookingtool.models.User;

/**
 * The CommandContext class is a singleton class that provides a way to store the user context for executing commands.
 */
public class CommandContext
{

	private static CommandContext instance;
	private User loggedInUser;

	/**
	 * Private constructor to enforce singleton pattern.
	 */
	private CommandContext()
	{
	}

	/**
	 * Returns the singleton instance of the CommandContext class.
	 *
	 * @return the singleton instance of the CommandContext class.
	 */
	public static CommandContext getInstance()
	{
		if (instance == null)
		{
			instance = new CommandContext();
		}
		return instance;
	}

	/**
	 * Returns the currently logged in user.
	 *
	 * @return the currently logged in user.
	 */
	public User getLoggedInUser()
	{
		return loggedInUser;
	}

	/**
	 * Sets the currently logged in user.
	 *
	 * @param loggedInUser the currently logged in user.
	 */
	public void setLoggedInUser(User loggedInUser)
	{
		this.loggedInUser = loggedInUser;
	}
}
