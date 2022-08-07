package finalproject;

import java.util.*;
import java.lang.Math;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class Attack extends Move
{
    //This constructor takes a series of integer arguments for the things that you want to change
    //If you want to reduce the stat, use a negative
    public Attack(String name, String description, int playerMaxHealth, int playerHealth, int enemyMaxHealth, int enemyHealth,
        int playerSpeed, int enemySpeed, int playerFatigue)
    {
        this(name, description, enemyHealth, playerFatigue);
        this.setPlayerMaxHealth(playerMaxHealth);
        this.setPlayerHealth(playerHealth);
        this.setEnemyMaxHealth(enemyMaxHealth);
        this.setPlayerSpeed(playerSpeed);
        this.setEnemySpeed(enemySpeed);
    }
    
    //A version of the above that affects less stats, if you want to make a more
    //basic attack
    public Attack(String name, String description, int enemyHealth, int playerFatigue)
    {
        super(name, description);
        this.setEnemyHealth(enemyHealth);
        this.setPlayerFatigue(playerFatigue);
    }
    
    //Takes a name and description argument, and a Map<String, Integer>
    //object in order to make more interesting attacks
    public Attack(String name, String description, Map<String, Integer> creationStats)
    {
        super(name, description, creationStats);
    }
    
    
    @Override
    /*
    Attack's resolve changes stats as appropriate for the move
    Attack's resolve also ensures that the attack adds fatigue points
    */
    protected void resolve(Character player, Character enemy)
    {
        float returnedHealth = 0F;
        
        if (player.getFatigue() > 3)
            returnedHealth += .2;
        if (player.getFatigue() > 7)
            returnedHealth += .2;
        if (player.getFatigue() > 11)
            returnedHealth += .2;
        
        changeStats(player, enemy);
        
        enemy.changeHealth((int) (Math.abs(this.getEnemyHealth()) * returnedHealth));
        
        if (this.getPlayerFatigue() == 0)
            player.changeFatigue(1);
        if (player.getFatigue() > 12)
            player.setFatigue(12);
    }
    
    @Override
    public String toString()
    {
        return super.toString() + String.format(" (Increases fatigue by %d points)", this.getPlayerFatigue());
    }
}
