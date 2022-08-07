package finalproject;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class Character implements Serializable
{
    /*
    Listed are all of the stats and move lists for a specific character
    */
    private int maxHealth, health;
    private int maxMana, mana;
    private int speed;
    private int fatigue; //0-3: No effect, 4-7: -20% damage, 8-11: -40% damage, 12 (max): -60% damage
    private float attack, defense;
    private String name;
    private String description;
    
    /*
    Move lists; each one should have a maximium of 5 moves. Not for any
    mechanical reason, I just think that more would look ugly. However, 
    you are the programmer, so it's left to you
    */    
    private ArrayList<Attack> attacks = new ArrayList<>();
    private ArrayList<Spell> spells = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    protected Move rest = new Rest();
    
    public Character(String name, String description, int maxHealth, int maxMana, int speed)
    {
        this.setName(name);
        this.setDescription(description);
        this.setMaxHealth(maxHealth);
        this.setHealth(maxHealth);
        this.setMaxMana(maxMana);
        this.setMana(maxMana);
        this.setSpeed(speed);
        this.setFatigue(0);
        this.setAttack(1);
        this.setDefense(1);
    }
    public Character(Character character)
    {
        this(character.getName(), character.getDescription(), character.getMaxHealth(),
                character.getMaxMana(), character.getSpeed());
        this.attacks = character.attacks;
        this.spells = character.spells;
        this.items = character.items;
    }
    
    //Move Adders; adds move of stated type
    public void addAttack(Attack attack)
    {
        attacks.add(attack);
    }
    public void addSpell(Spell spell)
    {
        spells.add(spell);
    }
    public void addItem(Item item)
    {
        items.add(item);
    }
    //********************
    
    //Setters; sets the repspective stat or other member variable to argument
    final public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }
    final public void setHealth(int health)
    {
        this.health = health;
    }
    final public void setMaxMana(int maxMana)
    {
        this.maxMana = maxMana;
    }
    final public void setMana(int mana)
    {
        this.mana = mana;
    }
    final public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    final public void setFatigue(int fatigue)
    {
        this.fatigue = fatigue;
    }
    final public void setAttack(float attack)
    {
        this.attack = attack;
    }
    final public void setDefense(float defense)
    {
        this.defense = defense;
    }
    final public void setName(String name)
    {
        this.name = name;
    }
    final public void setDescription(String description)
    {
        this.description = description;
    }
    //********************
    
    //Getters; returns specified stat or other member variable
    public int getMaxHealth()
    {
        return maxHealth;
    }
    public int getHealth()
    {
        return health;
    }
    public int getMaxMana()
    {
        return maxMana;
    }
    public int getMana()
    {
        return mana;
    }
    public int getSpeed()
    {
        return speed;
    }
    public int getFatigue()
    {
        return fatigue;
    }
    public float getAttack()
    {
        return attack;
    }
    public float getDefense()
    {
        return defense;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    
    public ArrayList<Attack> getAttackList()
    {
        return attacks;
    }
    public ArrayList<Spell> getSpellList()
    {
        return spells;
    }
    public ArrayList<Item> getItemList()
    {
        return items;
    }
    public int getAttackListSize()
    {
        return attacks.size();
    }
    public int getSpellListSize()
    {
        return spells.size();
    }
    public int getItemListSize()
    {
        return items.size();
    }
    //********************
    
    //Changers; Increases stat by argument
    public void changeMaxHealth(int change)
    {
        this.maxHealth += change;
    }
    public void changeHealth(int change)
    {
        this.health += change;
    }
    public void changeMaxMana(int change)
    {
        this.maxMana += change;
    }
    public void changeMana(int change)
    {
        this.mana += change;
    }
    public void changeSpeed(int change)
    {
        this.speed += change;
    }
    public void changeFatigue(int change)
    {
        this.fatigue += change;
    }
    public void changeAttack(float change)
    {
        this.attack += change;
    }
    public void changeDefense(float change)
    {
        this.defense += change;
    }
    //********************
    
    public void printAllStats()
    {
        System.out.println("Max Health: " + this.getMaxHealth());
        System.out.println("Current Health: " + this.getHealth());
        System.out.println("Max Mana: " + this.getMaxMana());
        System.out.println("Current Mana: " + this.getMana());
        System.out.println("Fatigue: " + this.getFatigue());
        System.out.println("Speed: " + this.getSpeed());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Defense: " + this.getDefense());
    }
    
    @Override
    public String toString()
    {
        return String.format("%s", this.getName());
    }
}
