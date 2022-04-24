package com.company;
import java.util.*;

/**
 * This class extends the built-in Stack class to create stacks that stores Commands given by users.
 * It has the push, pop, and peek to manipulate the stack.
 *
 *  @author  Tracy Yip 
 */
public class CommandStack extends Stack
{
    /**
     * This method adds a valid Command onto the stack.
     *
     * @param command
     *    The command that needs to be pushed onto the CommandStack
     * @throws InvalidCommandException
     *    When the command doesn't belong in and can't be added to the stack
     */
    public void push(Command command) throws InvalidCommandException
    {
        if(command.validCommand(this))
        {
            super.push(command);
            return;
        }
        throw new InvalidCommandException();
    }

    /**
     * This method removes the topmost Command on the stack.
     *
     * @return
     *    The command that is getting removed
     * @throws CustomEmptyStackException
     *    When the stack is empty
     */
    public Command pop() throws CustomEmptyStackException
    {
        if(!this.isEmpty())
        {
          return (Command) super.pop();
        }
        throw new CustomEmptyStackException("The stack is empty.");
    }

    /**
     * This method looks at the topmost Command on the stack.
     *
     * @return
     *    The command that is located at the top of the stack
     * @throws CustomEmptyStackException
     *    When the stack is empty
     */
    public Command peek() throws CustomEmptyStackException
    {
        if (this.isEmpty())
        {
            throw new CustomEmptyStackException();
        }
        else
        {
            return (Command) super.peek();
        }
    }

    /**
     * This method checks if the stack is empty.
     *
     * @return
     *    A boolean that indicates whether the stack is empty.
     */
    public boolean isEmpty()
    {
      return super.isEmpty();
    }

    /**
     * This method gets the string representation of the topmost Command on the stack in long form
     * to be displayed on the current screen.
     *
     * @return
     *    A String containing the topmost Command on the stack in long form
     */
    public String getScreenCommand()
    {
        try
        {
            return this.peek().toString();
        }
        catch(CustomEmptyStackException w)
        {
            System.out.println(w.getMessage());
        }
        return "";
    }

    /**
     * This method organizes the Commands on the stack in a string representation.
     *
     * @return
     *    A String containing all the Commands on the stack in short form
     */
    public String toString()
    {
        String output="";
        Iterator iterator= this.iterator();
        while(iterator.hasNext())
        {
            Command x=(Command)iterator.next();
            output+= x.toShortString();
        }
        return output;
    }
}
