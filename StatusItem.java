package finalproject;

import java.util.Map;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class StatusItem extends Item
{
    public StatusItem(String name, String description, int uses, int playerAttack, int playerDefense, int enemyAttack, int enemyDefense)
    {
        super(name, description, uses);
        this.setPlayerAttack(playerAttack);
        this.setPlayerDefense(playerDefense);
        this.setEnemyAttack(enemyAttack);
        this.setEnemyDefense(enemyDefense);
    }
    StatusItem(String name, String description, int uses, Map<String, Integer> moveStatMap)
    {
        super(name, description, uses, moveStatMap);
    }
}
