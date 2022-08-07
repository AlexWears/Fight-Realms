package finalproject;

import java.util.*;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class Spell extends Move
{
    int manaCost;
    
    public Spell(String name, String description, int manaCost)
    {
        super(name, description);
        this.setManaCost(manaCost);
    }
    public Spell(String name, String description, int manaCost, Map<String, Integer> creationStats)
    {
        super(name, description, creationStats);
        this.manaCost = manaCost;
    }
    
    @Override
    protected void resolve(Character player, Character enemy)
    {
        if (player.getMana() < this.manaCost)
        {
            System.out.printf("You do not have enough mana to use this spell.\n"
                    + "Mana Cost: %d Your Current Mana: %d\n", this.manaCost, player.getMana());
            try
            {
                ((PlayerCharacter) player).takeTurn(enemy);
                return;
            }
            catch(ClassCastException e)
            {
                return;
            }
        }
        
        player.changeMana(-this.manaCost);
        this.changeStats(player, enemy);
    }
    
    final public void setManaCost(int manaCost)
    {
        this.manaCost = manaCost;
    }
    public int getManaCost()
    {
        return this.manaCost;
    }
    
    @Override
    public void printAllStats()
    {
        super.printAllStats();
        System.out.printf("Mana Cost: %d\n", this.getManaCost());
    }
    
    @Override
    public String toString()
    {
        String toString = super.toString();
        return toString = toString + String.format(" (Mana Cost: %d)", this.getManaCost());
    }
}
