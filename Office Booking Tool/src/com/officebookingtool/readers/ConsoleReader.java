package com.officebookingtool.readers;

import java.util.Scanner;

public class ConsoleReader
{
	private Scanner scanner;

	public ConsoleReader()
	{
		scanner = new Scanner(System.in);
	}

	public <T> T read(InputReader<T> reader)
	{
		System.out.print(reader.getPrompt());

		String input = scanner.nextLine();
		if (reader.validate(input))
		{
			System.out.println(reader.getSuccessfulMessage());
			System.out.println();
			return reader.getValue(input);
		} else
		{
			System.out.println(reader.getErrorMessage());
			System.out.println();
			return read(reader);
		}
	}

}
