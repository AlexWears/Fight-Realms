package finalproject;

import java.util.*;
import java.io.Serializable;

/**
 * @author Alex
 * @pawprint awwkvr
 */
public abstract class Move implements Serializable
{
    /*
    This is essentially a list of all the things that moves can change.
    
    Their values are ints in the amount that the specified stat will change.
    
    Not all of these will be changed in every move, the ones that can be will
        be required by the constructor for the sepcific kind of move.
 
    playerMaxHealth, playerHealth, enemyMaxHealth, enemyHealth; //Every Move
    playerMaxMana, playerMana, enemyMaxMana, enemyMana; //Spells, Items
    playerSpeed, enemySpeed; //Every Move
    playerFatigue, enemyFatigue; //Attacks
    playerAttack, enemyAttack; //Spells, Items
    playerDefense, enemyDefense; //Spells, Items
*/
    private String name;
    private String description;
    
    private final Map<String, Integer> stats = new HashMap<>();
    
    protected abstract void resolve(Character player, Character enemy);
    
    /*k
    No-arg constructor, sets every stat to zero and inputs them in the map
    */
    public Move(String name, String description)
    {
        this.name = name;
        this.description = description;
        
        stats.put("playerMaxHealth", 0);
        stats.put("playerHealth", 0);
        stats.put("playerMaxMana", 0);
        stats.put("playerMana", 0);
        stats.put("playerSpeed", 0);
        stats.put("playerFatigue", 0);
        stats.put("playerAttack", 0); // -25 to 25 (percentages)
        stats.put("playerDefense", 0); // -25 to 25 (percentages)
        
        stats.put("enemyMaxHealth", 0);
        stats.put("enemyHealth", 0);
        stats.put("enemyMaxMana", 0);
        stats.put("enemyMana", 0);
        stats.put("enemySpeed", 0);
        stats.put("enemyFatigue", 0);
        stats.put("enemyAttack", 0); // -25 to 25 (percentages)
        stats.put("enemyDefense", 0); // -25 to 25 (percentages)
    }
    
    /*
    This constructor takes a Map<String, Integer> argument
    Stats that are listed inside will be affected as such
    */
    public Move(String name, String description, Map<String, Integer> creationStats)
    {
        this(name, description);
        
        for (String statName : creationStats.keySet())
        {
            if (stats.containsKey(statName))
            {
                stats.put(statName, creationStats.get(statName));
            }
        }
    }
    
    /*
    This method will afftect the stats the same way for every kind of move
    DRY
    */
    public void changeStats(Character player, Character enemy)
    {
        player.changeMaxHealth(this.getPlayerMaxHealth());
        player.changeHealth(this.getPlayerHealth());
        player.changeMaxMana(this.getPlayerMaxMana());
        player.changeMana(this.getPlayerMana());
        player.changeSpeed(this.getPlayerSpeed());
        player.changeFatigue(this.getPlayerFatigue());
        player.changeAttack(this.getPlayerAttack()*.01F);
        player.changeDefense(this.getPlayerDefense()*.01F);
        
        enemy.changeMaxHealth(this.getEnemyMaxHealth());
        //More player attack, less enemy defense = more damage
        //Less player attack, more enemy defense = less damage
        int enemyHealthChange;
        enemy.changeHealth(enemyHealthChange = (int) (this.getEnemyHealth() * (player.getAttack() / enemy.getDefense())));
        enemy.changeMaxMana(this.getEnemyMaxMana());
        enemy.changeMana(this.getEnemyMana());
        enemy.changeSpeed(this.getEnemySpeed());
        enemy.changeFatigue(this.getEnemyFatigue());
        enemy.changeAttack(this.getEnemyAttack()*.01F);
        enemy.changeDefense(this.getEnemyDefense()*.01F);
        
        if (this.getEnemyHealth() > 0)
            printStatChangeMessage(String.format(
                    "%s was healed for %d health!", enemy, enemyHealthChange));
        if (this.getEnemyHealth() < 0 && !(this instanceof Attack))
            printStatChangeMessage(String.format(
                    "%s was damaged for %d health!", enemy, -enemyHealthChange));
        else if (this.getEnemyHealth() < 0 && this instanceof Attack)
        {
            float damageSubtraction = 0F;
        
            if (player.getFatigue() > 3)
                damageSubtraction += .2;
            if (player.getFatigue() > 7)
                damageSubtraction += .2;
            if (player.getFatigue() > 11)
                damageSubtraction += .2;
            
            printStatChangeMessage(String.format(
                    "%s was damaged for %d health!", enemy, -(int)((1-damageSubtraction) * enemyHealthChange)));
        }
        if (this.getEnemyMaxHealth() > 0)
            printStatChangeMessage(String.format(
                    "%s's max health was increased!", enemy));
        if (this.getEnemyMaxHealth() < 0)
            printStatChangeMessage(String.format(
                    "%s's max health was decreased!", enemy));
        if (this.getEnemyMana() > 0)
            printStatChangeMessage(String.format(
                    "%s gained %d mana!", enemy, this.getEnemyMana()));
        if (this.getEnemyMana() < 0)
            printStatChangeMessage(String.format(
                    "%s lost %d mana!", enemy, -this.getEnemyMana()));
        if (this.getEnemyMaxMana() > 0)
            printStatChangeMessage(String.format(
                    "%s's max mana was increased!", enemy));
        if (this.getEnemyMaxHealth() < 0)
            printStatChangeMessage(String.format(
                    "%s's max mana was decreased!", enemy));
        if (this.getEnemySpeed() > 0)
            printStatChangeMessage(String.format(
                    "%s's speed was increased!", enemy));
        if (this.getEnemySpeed() < 0)
            printStatChangeMessage(String.format(
                    "%s's speed was decreased!", enemy));
        if (this.getEnemyAttack() > 0)
            printStatChangeMessage(String.format(
                    "%s's attack power was increased!", enemy));
        if (this.getEnemyAttack() < 0)
            printStatChangeMessage(String.format(
                    "%s's attack power was decreased!", enemy));
        if (this.getEnemyDefense() > 0)
            printStatChangeMessage(String.format(
                    "%s's defense was increased!", enemy));
        if (this.getEnemyDefense() < 0)
            printStatChangeMessage(String.format(
                    "%s's defense was decreased!", enemy));
        
        /*
        Player Stat Change Messages
        */
        
        if (this.getPlayerHealth() > 0)
            printStatChangeMessage(String.format(
                    "%s was healed for %d health!", player, this.getPlayerHealth()));
        if (this.getPlayerHealth() < 0)
            printStatChangeMessage(String.format(
                    "%s was damaged for %d health!", player, -this.getPlayerHealth()));
        if (this.getPlayerMaxHealth() > 0)
            printStatChangeMessage(String.format(
                    "%s's max health was increased!", player));
        if (this.getPlayerMaxHealth() < 0)
            printStatChangeMessage(String.format(
                    "%s's max health was decreased!", player));
        if (this.getPlayerMana() > 0)
            printStatChangeMessage(String.format(
                    "%s gained %d mana!", player, this.getPlayerMana()));
        if (this.getPlayerMana() < 0)
            printStatChangeMessage(String.format(
                    "%s lost %d mana!", player, -this.getPlayerMana()));
        if (this.getPlayerMaxMana() > 0)
            printStatChangeMessage(String.format(
                    "%s's max mana was increased!", player));
        if (this.getPlayerMaxHealth() < 0)
            printStatChangeMessage(String.format(
                    "%s's max mana was decreased!", player));
        if (this.getPlayerSpeed() > 0)
            printStatChangeMessage(String.format(
                    "%s's speed was increased!", player));
        if (this.getPlayerSpeed() < 0)
            printStatChangeMessage(String.format(
                    "%s's speed was decreased!", player));
        if (this.getPlayerAttack() > 0)
            printStatChangeMessage(String.format(
                    "%s's attack power was increased!", player));
        if (this.getPlayerAttack() < 0)
            printStatChangeMessage(String.format(
                    "%s's attack power was decreased!", player));
        if (this.getPlayerDefense() > 0)
            printStatChangeMessage(String.format(
                    "%s's defense was increased!", player));
        if (this.getPlayerDefense() < 0)
            printStatChangeMessage(String.format(
                    "%s's defense was decreased!", player));
        System.out.println();
        
        if (player.getAttack() > 1.25)
            player.setAttack(1.25F);
        if (player.getAttack() < .75)
            player.setAttack(.75F);
        if (player.getDefense() > 1.25)
            player.setDefense(1.25F);
        if (player.getDefense() < .75)
            player.setDefense(.75F);
        
        if (enemy.getAttack() > 1.25)
            enemy.setAttack(1.25F);
        if (enemy.getAttack() < .75)
            enemy.setAttack(.75F);
        if (enemy.getDefense() > 1.25)
            enemy.setDefense(1.25F);
        if (enemy.getDefense() < .75)
            enemy.setDefense(.75F);
        
        if (player.getHealth() > player.getMaxHealth())
            player.setHealth(player.getMaxHealth());
        if (player.getMana() > player.getMaxMana())
            player.setMana(player.getMaxMana());
        if (player.getMana() < 0)
            player.setMana(0);
        if (enemy.getHealth() > enemy.getMaxHealth())
            enemy.setHealth(enemy.getMaxHealth());
        if (enemy.getMana() > enemy.getMaxMana())
            enemy.setMana(enemy.getMaxMana());
        if (enemy.getMana() < 0)
            enemy.setMana(0);
        if (enemy.getFatigue() > 12)
            enemy.setFatigue(12);
        if (enemy.getFatigue() < 0)
            enemy.setFatigue(0);
        if (player.getFatigue() > 12)
            player.setFatigue(12);
        if (player.getFatigue() < 0)
            player.setFatigue(0);
    }
    
    private void printStatChangeMessage(String message)
    {
        System.out.println(message);
        PrintUtil.sleep();
    }
    
    //Setters; this list of methods is quite long, but necessary
    final public void setPlayerMaxHealth(int maxHealth)
    {
        stats.put("playerMaxHealth", maxHealth);
    }
    final public void setPlayerHealth(int health)
    {
        stats.put("playerHealth", health);
    }
    final public void setPlayerMaxMana(int maxMana)
    {
        stats.put("playerMaxMana", maxMana);
    }
    final public void setPlayerMana(int mana)
    {
        stats.put("playerMana", mana);
    }
    final public void setPlayerSpeed(int speed)
    {
        stats.put("playerSpeed", speed);
    }
    final public void setPlayerFatigue(int fatigue)
    {
        stats.put("playerFatigue", fatigue);
    }
    final public void setPlayerAttack(int attack)
    {
        stats.put("playerAttack", attack);
    }
    final public void setPlayerDefense(int defense)
    {
        stats.put("playerDefense", defense);
    }
    
    final public void setEnemyMaxHealth(int maxHealth)
    {
        stats.put("enemyMaxHealth", maxHealth);
    }
    final public void setEnemyHealth(int health)
    {
        stats.put("enemyHealth", health);
    }
    final public void setEnemyMaxMana(int maxMana)
    {
        stats.put("enemyMaxMana", maxMana);
    }
    final public void setEnemyMana(int mana)
    {
        stats.put("enemyMana", mana);
    }
    final public void setEnemySpeed(int speed)
    {
        stats.put("enemySpeed", speed);
    }
    final public void setEnemyFatigue(int fatigue)
    {
        stats.put("enemyFatigue", fatigue);
    }
    final public void setEnemyAttack(int attack)
    {
        stats.put("enemyAttack", attack);
    }
    final public void setEnemyDefense(int defense)
    {
        stats.put("enemyDefense", defense);
    }
    
    //Getters; same story as the setters above
    final public String getName()
    {
        return this.name;
    }
    final public String getDescription()
    {
        return this.description;
    }
    final public int getPlayerMaxHealth()
    {
        return stats.get("playerMaxHealth");
    }
    final public int getPlayerHealth()
    {
        return stats.get("playerHealth");
    }
    final public int getPlayerMaxMana()
    {
        return stats.get("playerMaxMana");
    }
    final public int getPlayerMana()
    {
        return stats.get("playerMana");
    }
    final public int getPlayerSpeed()
    {
        return stats.get("playerSpeed");
    }
    final public int getPlayerFatigue()
    {
        return stats.get("playerFatigue");
    }
    final public int getPlayerAttack()
    {
        return stats.get("playerAttack");
    }
    final public int getPlayerDefense()
    {
        return stats.get("playerDefense");
    }
    
    final public int getEnemyMaxHealth()
    {
        return stats.get("enemyMaxHealth");
    }
    final public int getEnemyHealth()
    {
        return stats.get("enemyHealth");
    }
    final public int getEnemyMaxMana()
    {
        return stats.get("enemyMaxMana");
    }
    final public int getEnemyMana()
    {
        return stats.get("enemyMana");
    }
    final public int getEnemySpeed()
    {
        return stats.get("enemySpeed");
    }
    final public int getEnemyFatigue()
    {
        return stats.get("enemyFatigue");
    }
    final public int getEnemyAttack()
    {
        return stats.get("enemyAttack");
    }
    final public int getEnemyDefense()
    {
        return stats.get("enemyDefense");
    }
    
    public void printAllStats()
    {
        System.out.printf("""
                          Name: %s
                          Player Max Health: %s
                          Player Health: %s
                          Player Max Mana: %s
                          Player Mana: %s
                          Player Speed: %s
                          Player Fatigue: %s
                          Player Attack: %s
                          Player Defense: %s
                          
                          Enemy Max Health: %s
                          Enemy Health: %s
                          Enemy Max Mana: %s
                          Enemy Mana: %s
                          Enemy Speed: %s
                          Enemy Fatigue: %s
                          Enemy Attack: %s
                          Enemy Defense: %s
               """, this.getName(), this.getPlayerMaxHealth(), this.getPlayerHealth(),
               this.getPlayerMaxMana(), this.getPlayerMana(),
               this.getPlayerSpeed(), this.getPlayerFatigue(), 
               this.getPlayerAttack(), this.getPlayerDefense(),
               this.getEnemyMaxHealth(), this.getEnemyHealth(),
               this.getEnemyMaxMana(), this.getEnemyMana(),
               this.getEnemySpeed(), this.getEnemyFatigue(),
               this.getEnemyAttack(), this.getEnemyDefense());
    }
    
    @Override
    public String toString()
    {
        return this.getName();
    }
}
