package com.company;

public class InvalidCommandException extends Exception
{
    /**
     * Constructs an InvalidCommandException that passes
     * a string to its super class (Exception)
     */
    public InvalidCommandException()
    {
        super("This command cannot be done. Please try another command.");
    }

    /**
     * Constructs an InvalidCommandException that passes
     * a specified string given in the parameter to its
     * super class (Exception)
     *
     * @param in
     *    A specified string of message that is desired to be printed
     */
    public InvalidCommandException(String in)
    {
        super(in);
    }
}
