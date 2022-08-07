package finalproject;

import java.util.*;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class DefaultCharactersCreator
{
    /*
    This method returns a list of all the characters that will always be available
    */
    static final ArrayList<Character> makeCharacters()
    {
        ArrayList<Character> characters = new ArrayList<>();
        Map<String, Integer> moveStatMap = new HashMap<>();
        
        /*
        Balancing Notes:
        - Increase the effectiveness of all healing effects
        
        - Attack Damage Values and Fatigue Points
            - 75 to 85: 1 fatigue point
            - 100 to 110: 2 fatigue points
            - 130 to 150: 3 or more fatigue points
        */
        
        Character goblin = new Character("Jumblik the Goblin Alchemist", 
                "A little green goblin with a knack for potions and explosives", 550, 600, 115);
        characters.add(goblin);
        goblin.addAttack(new Attack("Shortsword", "Just a regular ol' shortsword", -100, 2));
        goblin.addAttack(new Attack("Goblin Claws", "A quick swipe with razor sharp Goblin claws", -75, 1));
        goblin.addSpell(new AttackSpell("Firebolt", "A small burst of flame energy", 150, -150));
        goblin.addSpell(new StatusSpell("Ray of Weakness", "A magical beam that will weaken your opponent", 300, 0, 0, -5, -5));
        goblin.addSpell(new HealSpell("Minor Heal", "A small and quick healing spell", 75, 150));
        setMoveStatMap(moveStatMap, 0, 0, -20, -30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        goblin.addSpell(new AttackSpell("Summon Bees", "Summons bees to poison your opponent", 250, moveStatMap));
        goblin.addItem(new AttackItem("Crude Bomb", "A large, and destructive, shrapnel bomb", 1, -70, -200));
        goblin.addItem(new HealItem("Greater Healing Potion", "A potion that will heal you a massive amount (once)", 1, 500));
        goblin.addItem(new AttackItem("Firecracker", "A small explosive to light and toss", 5, -50, -160));
        
        Character lorenzo = new Character("Lorenzo", 
                "The most forgettable brother of the three Italian plumber siblings", 650, 300, 95);
        characters.add(lorenzo);
        lorenzo.addAttack(new Attack("Punch", "A punch, not much more to say", -75, 1));
        lorenzo.addAttack(new Attack("Stomp", "Very effective against animalian or fungal opponents", -150, 3));
        lorenzo.addAttack(new Attack("Charge the Enemy", "Clumsily charge the enemy, hurting both parties involved", 0, -75, 0, -180, 0, 0, 3));
        lorenzo.addSpell(new AttackSpell("Fireball", "The effects of a floral power-up", 150, -150));
        lorenzo.addSpell(new AttackSpell("Ice Ball", "Essentially the same as fireball, but ice themed", 150, -150));
        lorenzo.addSpell(new HealSpell("Extra Life", "Contrary to popular belief, this just heals you", 100, 125));
        lorenzo.addSpell(new StatusSpell("Pent Up Aggression", "Your bottled up emotions are coming out in a violent way", 100, 5, 0, 0, 0));
        lorenzo.addItem(new AttackItem("Water Gun", "Shoots water, does damage", 2, 0, -120));
        lorenzo.addItem(new AttackItem("Hammer Throw", "A handyman's tool gone wild", 1, 0, -160));
        lorenzo.addItem(new HealItem("Mushroom", "An earthy, and healing, treat", 1, 300));
        
        Character herculad = new Character("Herculad, Son of Hercules",
                "We couldn't afford the rights to actual Hercules...", 700, 150, 170);
        characters.add(herculad);
        herculad.addAttack(new Attack("Sword Strike", "A hit from a masterfully crafted sword", -100, 2));
        herculad.addAttack(new Attack("Thunder Slap", "A slap so strong it makes the gods cower", -150, 3));
        herculad.addSpell(new StatusSpell("Boon of Ares", "A gift from Ares that will increase your attack power", 110, 7, 0, 0, 0));
        setMoveStatMap(moveStatMap, 0, 0, 50, 0, 0, 0, 0, 0, 0, -30, 0, 0, 0, 0, 0, 0);
        herculad.addSpell(new StatusSpell("Boon of Hades", "A fearsome gift that will decrease your opponent's max health and speed", 170, moveStatMap));
        herculad.addSpell(new HealSpell("Boon of Dionysus", "A gift of health-restoring wine.", 120, 170));
        herculad.addSpell(new StatusSpell("Boon of Aphrodite", "Makes your oppenent fall in love with you, lowering their defense", 170, 0, 10, 0, 0));
        setMoveStatMap(moveStatMap, 0, 0, 0, 0, 35, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0);
        herculad.addSpell(new StatusSpell("Boon of Poseidon", "A refreshing mist surrounds you, lowering fatigue and increased max mana a bit", 100, moveStatMap));
        setMoveStatMap(moveStatMap, 0, 0, 0, 0, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        herculad.addItem(new StatusItem("Ambrosia", "Refreshes your mana, resotring a lot of your spell power", 5, moveStatMap));
        setMoveStatMap(moveStatMap, 0, 0, 0, 0, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        herculad.addItem(new StatusItem("Pomegranate", "A delectable fruit that increases your maximum mana", 4, moveStatMap));
        herculad.addItem(new HealItem("The Cornucopia", "The horn of plenty, heals you for a lot", 1, 300));
        
        
        Character dave = new Character("Dave from Accounting",
                "This is the guy who writes your paycheck", 500, 600, 125);
        characters.add(dave);
        setMoveStatMap(moveStatMap, 0, 0, 0, -80, 0, 0, 0, 0, 0, -40, 0, 0, 0, 0, 0, 0);
        dave.addItem(new AttackItem("Stapler", "Pierces your opponent's flesh and sticks them to the ground", 15, moveStatMap));
        setMoveStatMap(moveStatMap, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 8, 0, -5, 0);
        dave.addSpell(new StatusSpell("Demotion", "You get demoted and become enraged, boosting your attack and lowering your defense >:)", 150, moveStatMap));
        setMoveStatMap(moveStatMap, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 8, 0);
        dave.addSpell(new StatusSpell("Promotion", "You now work behind a very heavy, solid, and defensive desk", 150, moveStatMap));
        dave.addItem(new HealItem("Water Cooler", "Take a little break and drink some water", 5, 75));
        dave.addItem(new HealItem("Lunchbox", "Take a big break to enjoy a ham sammy", 1, 300));
        setMoveStatMap(moveStatMap, -20, -20, 0, 0, -20, -20, 0, 0, -20, 0, -4, 0, -5, 0, -5, 0);
        dave.addItem(new StatusItem("Pack of Cigarettes", "Take a smoke break. Smoking is bad for you.", 12, moveStatMap));
        setMoveStatMap(moveStatMap, 0, -9999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        dave.addItem(new StatusItem("Punchcard", "Your shift is over, and in your attempt to leave the Fight Realm your is body is ripped apart.", 1, moveStatMap));
        dave.addAttack(new Attack("Pencil Gouge", "Stab your oppenent with a pencil. Gross.", -100, 2));
        dave.addAttack(new Attack("Brass Knuckles", "A powerful weapon, when wielded properly", -150, 3));
        setMoveStatMap(moveStatMap, 0, -100, 0, -180, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0);
        dave.addAttack(new Attack("Uppercut", "You punch so hard that it hurts your hand :(", moveStatMap));
        
        Character chimp = new Character("Chimp with Weapons",
                "This is an ape, just armed to the teeth (which he has a lot of)", 750, 150, 200);
        characters.add(chimp);
        chimp.addAttack(new Attack("Desert Eagle", "A standard issue .50 caliber handgun", -85, 1));
        chimp.addAttack(new Attack("AK-47", "The firearm most popular in action films", -120, 2));
        chimp.addAttack(new Attack("Sawed-Off Shotgun", "This illegal modification makes a shotgun a lot less predictable...", -140, 3));
        chimp.addAttack(new Attack("Bite", "Just get in there with your chompers", -120, 2));
        chimp.addAttack(new Attack("Scratch", "If long fingernails are good for anything, it's this", -85, 1));
        chimp.addSpell(new HealSpell("Nature's Blessing", "Your connection to the forest heals you", 125, 150));
        chimp.addSpell(new StatusSpell("Unintelligible Screeching", "It's nonsense, but boy is it terrifying", 75, 0, 0, 0, -5));
        chimp.addItem(new AttackItem("Rocket Launcher", "A massive explosion that'll hurt you and your opponent", 1, -150, -170));
        chimp.addItem(new AttackItem("Ancient Spear", "Thrown at high speeds with the aid of an atlatl in order to piece through hides", 3, 0, -80));
        setMoveStatMap(moveStatMap, 0, 50, 0, 0, 0, 0, 0, 0, 20, 0, -3, 0, 0, 0, 0, 0);
        chimp.addItem(new StatusItem("Field Rations", "Allows a meal while away from base", 3, moveStatMap));
        
        Character cleetus = new Character("Count Cleetus von Harding", 
                "A redneck vampire who hails from the Blue Ridge Mountains", 420, 700, 140);
        characters.add(cleetus);
        cleetus.addAttack(new Attack("Varmint Rifle", "A type of gun commonly used in rural areas to kill varmints", -80, 1));
        cleetus.addAttack(new Attack("Vampire Claws", "A quick swpie with undead claws", -100, 2));
        setMoveStatMap(moveStatMap, 0, 50, 0, 80, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0);
        cleetus.addAttack(new Attack("Bite", "Bite your opponent (and steal some of their blood)", moveStatMap));
        setMoveStatMap(moveStatMap, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, -5, 0, -5);
        cleetus.addSpell(new StatusSpell("Soul Drain", "Steal your opponent's soul energy, weakening them", 250, moveStatMap));
        setMoveStatMap(moveStatMap, -35, 170, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        cleetus.addSpell(new HealSpell("Blood Sacrifice", "Lose a small amount of your max health to heal", 170, moveStatMap));
        setMoveStatMap(moveStatMap, 50, 0, -50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        cleetus.addSpell(new AttackSpell("Life Drain", "Take some of your opponent's max health for yourself", 200, moveStatMap));
        cleetus.addSpell(new StatusSpell("Expert Turkey Call", "It's so good it even attracts your opponent and lowers their defense", 150, moveStatMap));
        cleetus.addItem(new HealItem("Deer Jerky", "Delicious and healing, made by your friend Travis", 2, 220));
        cleetus.addItem(new StatusItem("Moonshine", "Lowers inhibition, making you attack with more vigor", 3, 8, 0, 0, 0));
        cleetus.addItem(new StatusItem("Cross Necklace", "Cleetus endures constant pain to wear the symbol of his lord", 1, 0, 12, 0, 0));
        cleetus.addItem(new AttackItem("Wooden Stake", "Contrary to popular belief, vampires use these as weapons", 2, 0, -90));
        
        return characters;
    }
    
    private static void setMoveStatMap (Map<String, Integer> moveStatMap,
     int playerMaxHealth, int playerHealth, int enemyMaxHealth, int enemyHealth,
     int playerMaxMana, int playerMana, int enemyMaxMana, int enemyMana,
     int playerSpeed, int enemySpeed, int playerFatigue, int enemyFatigue,
     int playerAttack, int enemyAttack, int playerDefense, int enemyDefense)
    {
        moveStatMap.clear();
        
        moveStatMap.put("playerMaxHealth", playerMaxHealth);
        moveStatMap.put("playerHealth", playerHealth);
        moveStatMap.put("playerMaxMana", playerMaxMana);
        moveStatMap.put("playerMana", playerMana);
        moveStatMap.put("playerSpeed", playerSpeed);
        moveStatMap.put("playerFatigue", playerFatigue);
        moveStatMap.put("playerAttack", playerAttack);
        moveStatMap.put("playerDefense", playerDefense);
        
        moveStatMap.put("enemyMaxHealth", enemyMaxHealth);
        moveStatMap.put("enemyHealth", enemyHealth);
        moveStatMap.put("enemyMaxMana", enemyMaxMana);
        moveStatMap.put("enemyMana", enemyMana);
        moveStatMap.put("enemySpeed", enemySpeed);
        moveStatMap.put("enemyFatigue", enemyFatigue);
        moveStatMap.put("enemyAttack", enemyAttack);
        moveStatMap.put("enemyDefense", enemyDefense);
    }
}