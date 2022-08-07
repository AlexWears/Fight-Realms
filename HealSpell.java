package finalproject;

import java.util.Map;

/**
 * @author Alex
 * @pawprint awwkvr
 */
public class HealSpell extends Spell
{
    public HealSpell(String name, String description, int manaCost, int playerHealing)
    {
        super(name, description, manaCost);
        this.setPlayerHealth(playerHealing);
    }
    HealSpell(String name, String description, int manaCost, Map<String, Integer> statMap)
    {
        super(name, description, manaCost, statMap);
    }
}
