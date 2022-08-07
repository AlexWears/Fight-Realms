package finalproject;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class Rest extends Move
{
    public Rest()
    {
        super("Rest", "A short rest to restore your health, fatigue, and magical energies");
    }
    
    @Override
    protected void resolve(Character player, Character enemy)
    {
        
        /*
        This works, but make it look prettier
        */
        player.setFatigue(0);
        
        if ((player.getHealth() + (player.getMaxHealth() / 20)) < player.getMaxHealth())
            player.changeHealth((player.getMaxHealth() / 20));
        else
            player.setHealth(player.getMaxHealth());
        
        if ((player.getMana() + (player.getMaxMana() / 3)) < player.getMaxMana())
            player.changeMana((player.getMaxMana() / 3));
        else
            player.setMana(player.getMaxMana());
    }
}
