package com.company;
import java.util.EmptyStackException;

/**
 * This exception class is thrown to check if the stack is empty.
 *
 *  @author  Tracy Yip Student ID: 114527635 Recitation: R-03
 */
public class CustomEmptyStackException extends EmptyStackException
{
    /**
     * Constructs an CustomEmptyStackException
     */
    public CustomEmptyStackException() {
    }

    /**
     * Constructs an CustomEmptyStackException that passes
     * a specified string given in the parameter to its
     * super class (EmptyStackException)
     *
     * @param in
     *    A specified string of message that is desired to be printed
     */
    public CustomEmptyStackException(String in)
    {
       System.out.println(in);
    }
}
