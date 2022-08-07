package finalproject;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class FinalProject
{
    private static ArrayList<Character> characters;
            
    public static void main(String[] args)
    {   
        PrintUtil.intro();
        KeyboardInput.enterToContinue();
        playTheGame();
    }
    
    private static void playTheGame()
    {   
        characters = DefaultCharactersCreator.makeCharacters();
        
        Random rand = new Random();
        Character characterToRemove;
        PlayerCharacter player = new PlayerCharacter(characterToRemove = KeyboardInput.chooseCharacter(characters));
        characters.remove(characterToRemove);
        ComputerCharacter enemy = new ComputerCharacter(characters.get(rand.nextInt(characters.size())));
        
        while (player.getHealth() > 0 && enemy.getHealth() > 0)
        {
            PrintUtil.printStats(player);
            System.out.println();
            PrintUtil.printStats(enemy);
            System.out.println();
            if (player.getSpeed() > enemy.getSpeed())
            {
                player.takeTurn(enemy);
                
                if (player.getHealth() <= 0 || enemy.getHealth() <= 0)
                    break;
                
                PrintUtil.sleep(2);
                
                PrintUtil.printStats(player);
                System.out.println();
                PrintUtil.printStats(enemy);
                System.out.println();
                
                enemy.takeTurn(player);
            }
            else
            {
                enemy.takeTurn(player);
                
                if (player.getHealth() <= 0 || enemy.getHealth() <= 0)
                    break;
                
                PrintUtil.sleep(2);
                
                PrintUtil.printStats(player);
                System.out.println();
                PrintUtil.printStats(enemy);
                System.out.println();
                
                player.takeTurn(enemy);
            }
            
            KeyboardInput.eatLine(); KeyboardInput.enterToContinue();
        }
        
        if (player.getHealth() <= 0 && enemy.getHealth() <= 0)
        {
            System.out.printf("%s and %s both died at the same time.\n", player, enemy);
            PrintUtil.sleep();
            System.out.printf("There are no winners in the fight realm...");
        }
        else if (player.getHealth() <= 0)
        {
            System.out.printf("%s Won!\n", enemy.getName());
        }
        else
        {
            System.out.printf("%s Won!\n", player.getName());
        }
        
        PrintUtil.sleep(2);
        
        System.out.printf("Would you like to play again? [Y/N]  ");
       
        char c = KeyboardInput.getCharacter('Y', 'y', 'N', 'n');
        
        if (c == 'Y' || c == 'y')
            playTheGame();
        
        
    }
}
