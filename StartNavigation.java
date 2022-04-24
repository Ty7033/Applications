package com.company;

/**
 * This is a class that implements the Command interface. It is used to create the StartNavigation Command in the
 *  Maps Application.
 *
 *  @author  Tracy Yip 
 */
public class StartNavigation implements Command
{
    private String source;//A string that stores the starting point of the trip
    private String destination;//A string that stores the final destination of the trip

    /**
     * This is a method that takes in information from a previous Command added onto the stack.
     *
     * @param commandStack
     *    The stack that the Command is being pushed onto
     */
    public StartNavigation(CommandStack commandStack)
    {
        try{
            if(commandStack.peek() instanceof FindPlace)
            {
                destination=((FindPlace) commandStack.peek()).getDestination();
            }
            else if (commandStack.peek() instanceof PlanRoute)
            {
                source=((PlanRoute) commandStack.peek()).getSource();
                destination=((PlanRoute) commandStack.peek()).getDestination();
            }
        }
       catch (CustomEmptyStackException y)
       {
           System.out.println("No route or destination!");
       }
    }

    /**
     * This is a method that checks if the StartNavigation Command can be added to the stack passed in the parameter.
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
            if(stack.peek() instanceof FindPlace|| stack.peek() instanceof PlanRoute)
            {
                return true;
            }
        }
        catch (CustomEmptyStackException e)
        {
            return false;
        }
        return false;
    }

    /**
     * A method used to get the source in the StartNavigation Command
     *
     * @return
     *    The source of the Command
     */
    public String getSource()
    {
        return source;
    }

    /**
     * A method used to get the destination in the StartNavigation Command
     *
     * @return
     *    The destination of the Command
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * A method that organizes the information of the StartNavigation Command to be printed on the current screen display
     *
     * @return
     *    A string representation of the Command in long form
     */
    public String toString()
    {
        if(source==null)
        {
            return "Navigating to "+ destination;
        }
        return "Navigating from "+ source + " to "+ destination;
    }

    /**
     * A method that organizes the information of the StartNavigation Command to be printed on the stack display
     *
     * @return
     *    A string representation of the Command in short form
     */
    public String toShortString()
    {
        String output="->N:";
        if(source!=null)
        {
            output+= source + "-" ;
        }
        return output+=destination;
    }
}
