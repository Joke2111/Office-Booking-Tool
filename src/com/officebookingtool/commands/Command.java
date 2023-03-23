package com.officebookingtool.commands;

/**
 * The Command interface defines the execute() method, which should be implemented by classes that represent different commands in a command-line
 * application.
 */
public interface Command
{

	/**
	 * Executes the logic associated with this command.
	 */
	void execute();
}
