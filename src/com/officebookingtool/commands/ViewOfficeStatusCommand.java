package com.officebookingtool.commands;

import com.officebookingtool.services.OfficeService;

public class ViewOfficeStatusCommand implements Command
{

	@Override
	public void execute()
	{
		OfficeService.viewOfficeStatus();
	}
}
