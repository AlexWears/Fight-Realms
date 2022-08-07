package finalproject;

import java.util.*;

/**
 * @author Alex
 * @pawprint awwkvr
 */
public class AttackSpell extends Spell
{
    /*
    The two constructors take arguments for move name and description
    and that correspond to the stats that they change
    */
    public AttackSpell(String name, String description, int manaCost, int enemyHealth)
    {
        super(name, description, manaCost);
        this.setEnemyHealth(enemyHealth);
    }
    public AttackSpell(String name, String description, int manaCost, int playerMaxHealth, int playerHealth, int enemyMaxHealth, int enemyHealth)
    {
        this(name, description, manaCost, enemyHealth);
        this.setPlayerMaxHealth(playerMaxHealth);
        this.setPlayerHealth(playerHealth);
        this.setEnemyMaxHealth(enemyMaxHealth);
    }
    AttackSpell(String name, String description, int manaCost, Map<String, Integer> moveStatMap)
    {
        super(name, description, manaCost, moveStatMap);
    }
}
