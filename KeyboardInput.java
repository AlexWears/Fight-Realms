package finalproject;

import java.util.*;
import java.util.Scanner;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class KeyboardInput
{
    private static final Scanner keyboard = new Scanner(System.in);
    
    public static int getIntRange(int lower, int upper)
    {
        int input = lower - 1;
        
        while (lower > input)
        {
            try
            {
                input = keyboard.nextInt();
                
                if (lower > input || input > upper)
                {
                    System.out.println("Please enter an integer in range.");
                    input = lower - 1;
                }
                
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter an integer value.");
                keyboard.next();
            }
        }
        
        return input;
    }
    
    public static char getCharacter(char ... possibleChars)
    {
        while (true)
        {
            try
            {
                char input = keyboard.next().charAt(0);
                
                for (char c : possibleChars)
                {
                    if (c == input)
                        return input;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid character.");
                keyboard.next();
            }  
        }
    }
    
    public static String getString()
    {
        while (true)
        {
            try
            {
                String str = keyboard.next();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid string.");
                keyboard.next();
            }
        }
    }
 
    public static void enterToContinue()
    {
        System.out.println("Press enter to continue");
        try
        {
            keyboard.nextLine();
        }
        catch (InputMismatchException e)
        {
            
        }
    }
    
    public static void eatLine()
    {
        try
        {
            keyboard.nextLine();
        }
        catch (InputMismatchException e)
        {
            
        }
    }
    
    public static final Character chooseCharacter(ArrayList<Character> characters)
    {
        while (true)
        {
            System.out.println("Which character would you like?");

            System.out.println("1: View Character Descriptions");
            for (int i = 1; i <= characters.size(); i++)
            {
                System.out.printf("%d: %s\n", i+1, characters.get(i-1).getName());
            }
            
            int choice = KeyboardInput.getIntRange(1, characters.size()+1);
            
            if (choice == 1)
            {
                while (true)
                {
                    System.out.println("What character would you like more info on?");
                    System.out.println("(Enter 0 to exit description mode)");
                    
                    for (int i = 1; i <= characters.size(); i++)
                    {
                        System.out.printf("%d: %s\n", i, characters.get(i-1).getName());
                    }
                    
                    choice = KeyboardInput.getIntRange(0, characters.size());
                    
                    if (choice == 0)
                    {
                        break;
                    }
                    else
                    {
                        System.out.printf("%s\n", characters.get(choice-1).getDescription());
                        try
                        {
                            keyboard.nextLine();
                        }
                        catch (Exception e)
                        {

                        }
                        KeyboardInput.enterToContinue();
                    }
                }
            }
            else
            {
                PrintUtil.sleep();
                return characters.get(choice-2);
            }
        }
    }
}