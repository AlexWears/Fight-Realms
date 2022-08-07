package finalproject;

import java.util.Map;

/**
 * @author Alex
 * @pawprint awwkvr
 */
public class StatusSpell extends Spell
{
    public StatusSpell(String name, String description, int manaCost, int playerAttack, int playerDefense, int enemyAttack, int enemyDefense)
    {
        super(name, description, manaCost);
        this.setPlayerAttack(playerAttack);
        this.setPlayerDefense(playerDefense);
        this.setEnemyAttack(enemyAttack);
        this.setEnemyDefense(enemyDefense);
    }
    StatusSpell(String name, String description, int manaCost, Map<String, Integer> statMap)
    {
        super(name, description, manaCost, statMap);
    }
}
