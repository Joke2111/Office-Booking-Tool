package com.officebookingtool.commands;

import com.officebookingtool.services.OfficeService;

/**
 * 
 * This class represents a command to view the available hours of an office on a specific day.
 * 
 * It implements the {@link Command} interface.
 */
public class ViewOfficeStatusCommand implements Command
{

	@Override
	public void execute()
	{
		OfficeService.viewOfficeStatus();
	}
}
