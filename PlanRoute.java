package com.company;
import java.util.Scanner;

/**
 * This is a class that implements the Command interface. It is used to create the PlanRoute command in the
 *  Maps Application.
 *
 *  @author  Tracy Yip 
 */
public class PlanRoute implements Command
{
    private String source;//A string that stores the starting point of the trip
    private String destination;//A String that stores the final destination of the trip

    /**
     * This is a constructor that creates a new PlanRoute command with the inputs passed in the scanner.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    public PlanRoute (Scanner scanner)
    {
        gatherInput(scanner);
    }

    /**
     * This is a method that takes in information from the user to set the source and destination for the command.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     */
    private void gatherInput(Scanner scanner)
    {
        System.out.println("Please enter a source:");
        source=scanner.nextLine();
        String tempSource=source;
        if(tempSource.trim().isEmpty())
        {
            System.out.println("Does not accept empty input. Try again.");
            this.gatherInput(scanner);
        }
        else
        {
            System.out.println("Please enter a destination:");
            destination=scanner.nextLine();
            String tempDestination=destination;
            if(tempDestination.trim().isEmpty())
            {
                System.out.println("Does not accept empty input");
                this.gatherInput(scanner);
            }
        }
    }

    /**
     * This is a method that checks if the PlanRoute command can be added to the stack passed in the parameter.
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
            if(stack.peek() instanceof PlanRoute || stack.peek() instanceof FindPlace|| stack.peek() instanceof StartNavigation)
            {
                return true;
            }
        }
       catch (CustomEmptyStackException w)
       {
           return true;
       }
        return false;
    }

    /**
     * A method used to get the source in the PlanRoute command
     *
     * @return
     *    The source of the command
     */
    public String getSource()
    {
        return source;
    }

    /**
     * A method used to get the destination in the PlanRoute command
     * @return
     *    The destination of the command
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * A method that organizes the information of the PlanRoute command to be printed on the current screen display
     *
     * @return
     *    A string representation of the command in long form
     */
    public String toString()
    {
        return "Planning route from " + source + " to "+ destination;
    }

    /**
     * A method that organizes the information of the PlanRoute command to be printed on the stack display
     *
     * @return
     *    A string representation of the command in short form
     */
    public String toShortString()
    {
        return "->P:" + source + "-"+ destination;
    }
}
