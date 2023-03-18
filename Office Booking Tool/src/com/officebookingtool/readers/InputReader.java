package com.officebookingtool.readers;

/**
 * Generic interface for reading input values of type T.
 * 
 * @param <T> the type of input value to be read
 */
public interface InputReader<T>
{

	/**
	 * Returns the input value of type T read from the given string input.
	 * 
	 * @param input the string input to be read
	 * @return the input value of type T
	 */
	T getValue(String input);

	/**
	 * Returns the error message to be displayed in case the input value is invalid.
	 * 
	 * @return the error message to be displayed
	 */
	String getErrorMessage();

	/**
	 * Validates the given string input and returns true if it is valid, false otherwise.
	 * 
	 * @param input the string input to be validated
	 * @return true if the input is valid, false otherwise
	 */
	boolean validate(String input);

	/**
	 * Returns the successful message to be displayed in case the input value is valid.
	 * 
	 * @return the successful message to be displayed
	 */
	String getSuccessfulMessage();

	/**
	 * Returns the prompt message to be displayed to the user for entering the input value.
	 * 
	 * @return the prompt message to be displayed
	 */
	String getPrompt();
}
