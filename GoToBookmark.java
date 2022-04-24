package com.company;
import java.util.Scanner;

/**
 * This is a class that implements the Command interface. It is used to create the GoToBookmark command in the
 *  Safari Application.
 *
 *  @author  Tracy Yip 
 */
public class GoToBookmark implements Command
{
    private String bookmark;//A string that stores the bookmark entered by users

    /**
     * This is a constructor that creates a new GoToBookmark command with the inputs passed in the scanner.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public GoToBookmark(Scanner scanner)
    {
       gatherInfo(scanner);
    }

    /**
     * This is a method that takes in information from the user to set the bookmark for the command.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public void gatherInfo(Scanner scanner)
    {
        System.out.println("Please enter bookmark name:");
        bookmark=scanner.nextLine();
        String tempBookmark=bookmark;
        if(tempBookmark.trim().isEmpty())
        {
            System.out.println("Does not accept empty input. Try again.");
            this.gatherInfo(scanner);
        }
    }

    /**
     * This is a method that checks if the GoToBookmark command can be added to the stack passed in the parameter.
     *
     * @param stack
     *    The stack that the command is being pushed onto
     * @return
     *    A boolean that indicates whether the command can be added to the stack
     */
    public boolean validCommand(CommandStack stack)
    {
        try
        {
            if(stack.peek() instanceof GoogleSomething || stack.peek() instanceof GoToBookmark|| stack.peek() instanceof FollowLink)
            {
                return true;
            }
        }
        catch(CustomEmptyStackException r)
        {
            return true;
        }
        return false;
    }

    /**
     * A method used to get the bookmark in the GoToBookmark command
     *
     * @return
     *    The bookmark of the command
     */
    public String getBookmark()
    {
        return bookmark;
    }

    /**
     * A method that organizes the information of the GoToBookmark command to be printed on the current screen display
     *
     * @return
     *    A string representation of the command in long form
     */
    public String toString()
    {
        return "Showing results for "+ bookmark;
    }

    /**
     * A method that organizes the information of the GoToBookmark command to be printed on the stack display
     *
     * @return
     *    A string representation of the command in short form
     */
    public String toShortString()
    {
        return "->F:" + bookmark;
    }
}
