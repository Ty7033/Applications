package com.company;
import java.util.Scanner;

/**
 * This is a class that implements the Command interface. It is used to create the FindPlace Command in the
 *  Maps Application.
 *
 *  @author  Tracy Yip 
 */
public class FindPlace implements Command
{
    private String destination;//A String that stores the destination being searched

    /**
     * This is a constructor that creates a new FindPlace Command with the inputs passed in the scanner.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public FindPlace(Scanner scanner)
    {
        this.gatherInfo(scanner);
    }

    /**
     * This is a method that takes in information from the user to set the destination for the Command.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public void gatherInfo(Scanner scanner)
    {
        System.out.println("Please enter a location:");
        destination=scanner.nextLine();
        String tempDestination=destination;
        if(tempDestination.trim().isEmpty())
        {
            System.out.println("Does not accept empty input. Try again.");
            this.gatherInfo(scanner);
        }
    }

    /**
     * This is a method that checks if the FindPlace Command can be added to the stack passed in the parameter.
     *
     * @param stack
     *    The stack that the Command is being pushed onto
     * @return
     *    A boolean that indicates whether the Command can be added to the stack
     */
    public boolean validCommand(CommandStack stack)
    {
        try{
            if(stack.peek() instanceof FindPlace || stack.peek() instanceof PlanRoute ||stack.peek() instanceof StartNavigation)
            {
                return true;
            }
        }
        catch(CustomEmptyStackException q)
        {
            return true;
        }
        return false;
    }

    /**
     * A method used to get the destination in the FindPlace Command
     *
     * @return
     *    The destination of the Command
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * A method that organizes the information of the FindPlace Command to be printed on the current screen display
     *
     * @return
     *    A string representation of the Command in long form
     */
    public String toString()
    {
        return "Showing results for " + destination;
    }

    /**
     * A method that organizes the information of the FindPlace Command to be printed on the stack display
     *
     * @return
     *    A string representation of the Command in short form
     */
    public String toShortString()
    {
        return "->F:"+ destination;
    }
}
