package com.company;
import java.util.Scanner;

/**
 * This is a class that implements the Command interface. It is used to create the GoogleSomething command in the
 *  Safari Application.
 *
 *  @author  Tracy Yip Student ID: 114527635 Recitation: R-03
 */
public class GoogleSomething implements Command
{
    private String query;//A string that stores the query entered by users

    /**
     * This is a constructor that creates a new GoogleSomething command with the inputs passed in the scanner.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public GoogleSomething(Scanner scanner)
    {
        gatherInfo(scanner);
    }

    /**
     * This is a method that takes in information from the user to set the query for the command.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public void gatherInfo(Scanner scanner)
    {
        System.out.println("Please enter a query:");
        query=scanner.nextLine();
        String tempQuery=query;
        if(tempQuery.trim().isEmpty())
        {
            System.out.println("Does not accept empty input");
            this.gatherInfo(scanner);
        }
    }

    /**
     * This is a method that checks if the GoogleSomething command can be added to the stack passed in the parameter.
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
        catch (CustomEmptyStackException o)
        {
            return true;
        }
        return false;
    }

    /**
     * A method used to get the query in the GoogleSomething command
     *
     * @return
     *    The query of the command
     */
    public String getQuery()
    {
        return query;
    }

    /**
     * A method that organizes the information of the GoogleSomething command to be printed on the current screen display
     *
     * @return
     *    A string representation of the command in long form
     */
    public String toString()
    {
        return "Google: " + query;
    }

    /**
     * A method that organizes the information of the GoogleSomething command to be printed on the stack display
     *
     * @return
     *    A string representation of the command in short form
     */
    public String toShortString()
    {
        return "->G:"+ query;
    }
}
