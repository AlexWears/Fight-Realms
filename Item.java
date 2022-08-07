package finalproject;

import java.util.Map;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class Item extends Move
{
    private int uses;
    
    public Item(String name, String description, int uses)
    {
        super(name, description);
        this.uses = uses;
    }
    
    public Item(String name, String description, int uses, Map<String, Integer> creationStats)
    {
        super(name, description, creationStats);
        this.uses = uses;
    }
    
    @Override
    protected void resolve(Character player, Character enemy)
    {
        this.changeStats(player, enemy);
        this.use();
    }
    @Override
    public void printAllStats()
    {
        super.printAllStats();
        System.out.printf("Uses left: %d\n", uses);
    }
    
    public int getUses()
    {
        return uses;
    }
    public void setUses(int uses)
    {
        this.uses = uses;
    }
    private void use()
    {
        uses--;
    }
    
    @Override
    public String toString()
    {
        String toString = super.toString();
        return toString = toString + String.format(" (Uses Left: %d)", this.getUses());
    }
}
