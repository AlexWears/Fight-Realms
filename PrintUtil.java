package finalproject;

import java.util.concurrent.TimeUnit;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class PrintUtil
{
    public static void intro()
    {
        System.out.printf("""
                          In a dimension adjacent to our own and every other, lesser
                          gods, billionaires, powerful sorcerers, and anyone else with
                          immense power gather. With their combined will, and magical assistance,
                          they are able to summon anyone they desire to fight to the death for
                          their amusement.\n
                          """);
        PrintUtil.sleep(2);
        System.out.printf("Welcome to ...\n\n");
        PrintUtil.sleep(1);
        System.out.printf("""
                          *****  *****    ****   *    *  *******
                          *        *     *       *    *     *
                          ***      *    *        *    *     *
                          *        *    *  ****  ******     *
                          *        *    *    **  *    *     *
                          *      *****   **** *  *    *     *
                          
                          ******   ******   *****   *        *    *    *****
                          *     *  *       *     *  *       * *  * *  *    
                          ******   *       *******  *       *  *   *   ****
                          *  *     ****    *     *  *       *      *       *
                          *   *    *       *     *  *       *      *  *    *
                          *    *   ******  *     *  ******  *      *   ****\n
                          """);
    }
    
    public static final void sleep()
    {
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e)
        {
            
        }
    }
    
    public static final void sleep(int seconds)
    {
        try
        {
            TimeUnit.SECONDS.sleep(seconds);
        }
        catch (Exception e)
        {
            
        }
    }
    
    public static void printStats(Character character)
    {
        System.out.printf("*** %s's Stats ***\n", character.getName());
        
        System.out.printf("Health: ");
        
        int healthStars = (int) (((float)character.getHealth() / (float)character.getMaxHealth()) * 20);
        for(int i = 0; i < healthStars; i++)
        {
            System.out.printf("*");
        }
        for(int i = 0; i < 20 - healthStars; i++)
        {
            System.out.printf("_");
        }
        System.out.printf(" (%d/%d)\n", character.getHealth(), character.getMaxHealth());
        
        System.out.printf("Mana: ");
        int manaStars = (int) (((float)character.getMana() / (float)character.getMaxMana()) * 20);
        for(int i = 0; i < manaStars; i++)
        {
            System.out.printf("*");
        }
        for(int i = 0; i < 20 - manaStars; i++)
        {
            System.out.printf("_");
        }
        System.out.printf(" (%d/%d)\n", character.getMana(), character.getMaxMana());
    }
}
