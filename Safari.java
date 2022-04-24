package com.company;
import java.util.Scanner;

/**
 * This is an extended class from Application that is responsible for adding and removing valid Safari Commands in
 * the CommandStack.
 *
 *  @author  Tracy Yip 
 */
public class Safari extends Application
{
    private CommandStack stack=new CommandStack();// Initiates a CommandStack that stores Safari commands
    private String response;//A String that keeps track of the new options chosen by users

    /**
     * This method takes in the option chosen by users and initiates the corresponding Command to add to stack.
     *
     * @param scanner
     *    A scanner that takes in the user inputs
     * @throws InvalidCommandException
     *    When the user enters an option that is not in the menu for Safari
     */
    public void readCommand(Scanner scanner) throws InvalidCommandException
    {
        String newOption= scanner.nextLine();
        response=newOption;
        if(newOption.equals("G") ||newOption.equals("g"))
        {
            GoogleSomething one= new GoogleSomething(scanner);
            stack.push(one);
        }
        else if(newOption.equals("F") ||newOption.equals("f"))
        {
            GoToBookmark one= new GoToBookmark(scanner);
            stack.push(one);
        }
        else if(newOption.equals("L") ||newOption.equals("l"))
        {
            FollowLink one= new FollowLink(scanner);
            stack.push(one);
        }
        else if(!isCommonCommands(newOption))
        {
            throw new InvalidCommandException("You have entered an invalid command. Please try again.");
        }
    }

    /**
     * This method checks whether the option chosen by users is the shared options between Maps and Safari.
     *
     * @param option
     *    The string inputted by users
     * @return
     *    A boolean that indicates whether the string corresponds to one of the common Commands between Maps and Safari.
     */
    public static boolean isCommonCommands(String option)
    {
        if(option.equalsIgnoreCase("B") ||option.equalsIgnoreCase("S")||option.equalsIgnoreCase("H"))
        {
            return true;
        }
        return false;
    }

    /**
     * This method removes the most recent Command on the stack to restore the application to its previous state
     * before the recent Command was added.
     *
     * @throws CustomEmptyStackException
     *    When the user tries to remove a Command from an empty stack.
     */
    public void goBack() throws CustomEmptyStackException
    {
        if(!stack.isEmpty())
        {
            stack.pop();
        }
        else
        {
            throw new CustomEmptyStackException();
        }
    }

    /**
     * A method used to get the response in this class
     *
     * @return
     *    The string that holds the user's response
     */
    public String getResponse()
    {
        return response;
    }
    
    /**
     * The method organizes the Commands in the stack in a string format to be printed.
     *
     * @return
     *    A String that indicates the Commands in the stack
     */
    public String toString()
    {
        return "[Home->SafariHome"+ stack.toString();
    }

    /**
     * A method that gets the stack in the application.
     *
     * @return
     *    The stack in this class
     */
    public CommandStack getStack()
    {
        return stack;
    }
}
