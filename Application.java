package com.company;
import java.util.Scanner;

/**
 * This is an abstract class for two applications (Safari and Maps).
 *
 *  @author  Tracy Yip Student ID: 114527635 Recitation: R-03
 */
abstract class Application
{
   protected CommandStack stack;// A CommandStack used to keep track of the Commands in application
   abstract void readCommand(Scanner scanner) throws InvalidCommandException;//Reads the user inputted options and creates & push the corresponding commands
   abstract void goBack() throws CustomEmptyStackException;//Pops the Command on the top
}



