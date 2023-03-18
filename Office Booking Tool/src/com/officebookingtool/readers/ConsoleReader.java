package com.officebookingtool.readers;

import java.util.Scanner;

/**
 * The ConsoleReader class provides a method to read user input from the console using an InputReader object.
 */
public class ConsoleReader
{
	private Scanner scanner;

	/**
	 * Creates a new ConsoleReader object and initializes a Scanner object to read from the console.
	 */
	public ConsoleReader()
	{
		scanner = new Scanner(System.in);
	}

    /**
     * Reads user input from the console using an InputReader object and returns the value as type T.
     * If the input is not valid, the user is prompted to re-enter their input until it is valid.
     *
     * @param reader the InputReader object used to read and validate user input
     * @param <T> the generic type of the value returned
     * @return the value entered by the user as type T
     */
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
