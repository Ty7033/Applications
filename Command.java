package com.company;

/**
 * This is an interface for the Commands in the Maps and Safari Applications.
 *
 *  @author  Tracy Yip 
 */
interface Command
{
    /**
     * This is a method that checks if the Command can be added to the stack passed in the parameter.
     *
     * @param stack
     *    The stack that the command is being pushed onto
     * @return
     *    A boolean that indicates whether the command can be added to the stack
     */
    public boolean validCommand(CommandStack stack);

    /**
     * A method that organizes the information of the Command to be printed on the current screen display
     *
     * @return
     *    A string representation of the command in long form
     */
    public String toString();

    /**
     * A method that organizes the information of the Command to be printed on the stack display
     *
     * @return
     *    A string representation of the command in short form
     */
    public String toShortString();

}

