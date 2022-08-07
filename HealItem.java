package finalproject;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class HealItem extends Item
{
    HealItem(String name, String description, int uses, int playerHealth)
    {
        super(name, description, uses);
        this.setPlayerHealth(playerHealth);
    }
}
