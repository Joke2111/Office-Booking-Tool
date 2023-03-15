package com.officebookingtool.commands;

public interface Command
{
	public default void execute(CommandContext context, String[] tokens)
	{
	}

}
