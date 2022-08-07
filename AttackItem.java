package finalproject;

import java.util.Map;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class AttackItem extends Item
{
    /*
    The two constructors take arguments for move name and description
    and that correspond to the stats that they change
    */
    AttackItem(String name, String desription, int uses, int playerHealth, int enemyHealth)
    {
        super(name, desription, uses);
        this.setPlayerHealth(playerHealth);
        this.setEnemyHealth(enemyHealth);
    }
    AttackItem(String name, String description, int uses, int playerMaxHealth, int playerHealth, int enemyMaxHealth, int enemyHealth,
        int playerSpeed, int enemySpeed)
    {
        this(name, description, uses, playerHealth, enemyHealth);
        this.setPlayerMaxHealth(playerMaxHealth);
        this.setEnemyMaxHealth(enemyMaxHealth);
        this.setPlayerSpeed(playerSpeed);
        this.setEnemySpeed(enemySpeed);
    }
    AttackItem(String name, String description, int uses, Map<String, Integer> statMap)
    {
        super(name, description, uses, statMap);
    }
}
