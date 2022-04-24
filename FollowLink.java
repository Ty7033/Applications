package com.company;
import java.util.Scanner;

/**
 * This is a class that implements the Command interface. It is used to create the FollowLink command in the
 *  Safari Application.
 *
 *  @author  Tracy Yip 
 */
public class FollowLink implements Command
{
    private String link;//A string that stores the link entered by users

    /**
     * This is a constructor that creates a new FollowLink Command with the inputs passed in the scanner.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public FollowLink(Scanner scanner)
    {
       gatherInfo(scanner);
    }

    /**
     * This is a method that takes in information from the user to set the link for the Command.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public void gatherInfo(Scanner scanner)
    {
        System.out.println("Please enter a link:");
        link= scanner.nextLine();
        String tempLink=link;
        if(tempLink.trim().isEmpty())
        {
            System.out.println("Does not accept empty input. Try again.");
            this.gatherInfo(scanner);
        }
    }

    /**
     * This is a method that checks if the FollowLink Command can be added to the stack passed in the parameter.
     *
     * @param stack
     *    The stack that the Command is being pushed onto
     * @return
     *    A boolean that indicates whether the Command can be added to the stack
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
            return false;
        }
        return false;
    }

    /**
     * A method used to get the link in the FollowLink Command
     *
     * @return
     *    The source of the Command
     */
    public String getLink()
    {
        return link;
    }

    /**
     * A method that organizes the information of the FollowLink Command to be printed on the current screen display
     *
     * @return
     *    A string representation of the Command in long form
     */
    public String toString()
    {
        return link;
    }

    /**
     * A method that organizes the information of the FollowLink Command to be printed on the stack display
     *
     * @return
     *    A string representation of the Command in short form
     */
    public String toShortString()
    {
        return "->L:"+ link;
    }
}
