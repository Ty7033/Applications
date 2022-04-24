package com.company;
import java.util.Scanner;

/**
 * This class runs a menu-driven application that lets the users choose to go into the Maps and Safari Applications
 * and Commands to their respective stacks.
 *
 *  @author  Tracy Yip Student ID: 114527635 Recitation: R-03
 */
public class iCatchUp
{
    public static Maps Maps;//An instance of Maps application
    public static Safari Safari;//An instance of Safari application
    public static Application currentApp;//An Application to keep track of the current application the program is on
    public static CommandStack current;//An CommandStack to keep track of the current stack the program is on
    public static String currentOption;//A String that stores the newest option entered by users

    /**
     * This method starts the overall program that prompts the user to interact with the applications. It prompts
     * them to enter options in the homeScreen after initializing an instance of Maps and Safari.
     */
    public static void main(String[] args)
    {
        Maps=new Maps();
        Safari= new Safari();
        Scanner scan= new Scanner(System.in);
        System.out.println("Welcome to the iPhony pocket telegraph simulator. You are on the home screen.");
        homeCommands(scan);
    }

    /**
     * This method checks if the user entered a valid HomeScreen option when choosing from the menu.
     *
     * @param option
     *    The string entered by users
     * @return
     *    A boolean that indicates whether the choice is valid
     */
    public static boolean validHomeScreen(String option)
    {
        String [] list = {"s", "S", "M", "m", "Q", "q"};
        for(int i=0; i<list.length; i++)
        {
            if(list[i].equals(option))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This method prints the menu for the Safari application.
     */
    public static void printSafariMenu()
    {
        System.out.println("Safari Options:\n"  + "     G) Google Something\n" +  "     F) Go to a favorite (bookmark)\n" +
            "     L) Follow a link\n" + "     H) Home Screen\n" + "     S) Switch to Maps\n" + "     B) Back");
    }

    /**
     * This method prints the menu for the Maps application.
     */
    public static void printMapsMenu()
    {
        System.out.println("Maps Options:\n" + "     F) Find a place\n" + "     P) Plan a route\n" + "     N) Start Navigation\n" + "     H) Home Screen\n" +
             "     S) Switch to Safari\n" + "     B) Back");
    }

    /**
     * This method prints the menu for the HomeScreen.
     */
    public static void printHomeOptions()
    {
        System.out.println("Home Options:\n" + "    S) Safari\n" + "    M) Maps\n" + "    Q) Quit");
    }

    /**
     * This method runs when the user is in the Safari application. It prints the information of the CommandStack
     * in the app and the current screen. It also prompts the user to interact with the options available in the app.
     *
     * @param scanner
     *    A scanner used to take in user inputs
     */
    public static void safariScreen(Scanner scanner)
    {
        currentApp= Safari;
        System.out.println(Safari.toString());
        if(Safari.getStack().isEmpty())
        {
            System.out.println("Current Screen: Safari Home");
        }
        else
        {
            System.out.println("Current Screen: "+ current.getScreenCommand());
        }
        printSafariMenu();
        System.out.println("Please select an option: ");
        safariCheck(scanner);
    }

    /**
     * This method is called upon when the user enters an option listed in the Safari menu. It passes the option
     * to the Safari application to checks if it is valid and goes about initiating the corresponding Command
     * in Safari.
     *
     * @param scanner
     *    A scanner that takes in input from users
     */
   public static void safariCheck(Scanner scanner)
   {
       try{
           Safari.readCommand(scanner);
           String newOption= Safari.getResponse();
           if(isCommonCommands(newOption))
           {
               handleCommonFunctions(newOption, scanner);
           }
       }
       catch(InvalidCommandException x)
       {
           System.out.println(x.getMessage());
           safariScreen(scanner);
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
     * This method is called on when the Back, Switch, or Home option is chosen. It does the corresponding action
     * to the option inputted by users.
     *
     * @param options
     *    The string entered by users when choosing an option
     * @param scanner
     *    A scanner that takes in input from users
     */
    public static void handleCommonFunctions(String options, Scanner scanner)
    {
        if(options.equalsIgnoreCase("B"))
        {
            try
            {
                currentApp.goBack();
            }
           catch(CustomEmptyStackException x)
           {
               homeCommands(scanner);
           }
        }
        else if(options.equalsIgnoreCase("S"))
        {
            if(currentApp instanceof Maps)
            {
                currentApp=Safari;
                current=Safari.getStack();
                currentOption="S";
                safariScreen(scanner);
            }
            else
            {
                currentApp=Maps;
                current=Maps.getStack();
                currentOption="m";
                mapsScreen(scanner);
            }
        }
        else if(options.equalsIgnoreCase("H"))
        {
            homeCommands(scanner);
        }
    }

    /**
     * This method runs when the user is in the Maps application. It prints the information of the CommandStack
     * in the app and the current screen. It also prompts the user to interact with the options available in the app.
     *
     * @param scanner
     *    A scanner used to take in user inputs
     */
    public static void mapsScreen(Scanner scanner)
    {
        currentApp= Maps;
        System.out.println(Maps.toString());
        if(Maps.getStack().isEmpty())
        {
            System.out.println("Current Screen: Maps Home");
        }
        else
        {
            System.out.println("Current Screen: "+ current.getScreenCommand());
        }
        printMapsMenu();
        System.out.println("Please select an option: ");
        mapsCheck(scanner);
    }

    /**
     * This method is called upon when the user enters an option listed in the Maps menu. It passes the option
     * to the Maps application to checks if it is valid and goes about initiating the corresponding Command
     * in Maps.
     *
     * @param scanner
     *    A scanner that takes in input from users
     */
    public static void mapsCheck(Scanner scanner)
    {
            try{
                Maps.readCommand(scanner);
                String newOption= Maps.getResponse();
                if(isCommonCommands(newOption))
                {
                    handleCommonFunctions(newOption, scanner);
                }
            }
            catch(InvalidCommandException x)
            {
                System.out.println(x.getMessage());
                mapsScreen(scanner);
            }
    }

    /**
     * This method is called when the user is in the HomeScreen. It takes users into the application chosen
     * and allows them to interact with either the Maps or Safari app.
     *
     * @param scanner
     *    A scanner that takes in input from users
     *
     */
    public static void homeCommands(Scanner scanner)
    {
        printHomeOptions();
        System.out.println("Please enter an option: ");
        String option=scanner.nextLine();
        if(!validHomeScreen(option))
        {
            System.out.println("You have entered an invalid option. Please try again.");
            System.out.println("Please select an option: ");
            option= scanner.nextLine();
        }
        currentOption=option;
        while(!option.equals("Q") && !option.equals("q"))
        {
            System.out.println("Stack Debug:");
            if(option.equals("S")|| option.equals("s"))
            {
                current=Safari.getStack();
                safariScreen(scanner);
                option=currentOption;
            }
            else if (option.equals("M")|| option.equals("m"))
            {
                current=Maps.getStack();
                mapsScreen(scanner);
                option=currentOption;
            }
        }
        System.out.println("Sorry to see you go, tell the iPod I said hi!");
        System.exit(0);
    }
}
