package finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Alex
 * @pawprint awwkvr
 */
public class ComputerCharacter extends Character
{   
    ArrayList<Move> moves = new ArrayList<>();
    Random rand = new Random();
    
    public ComputerCharacter(Character character)
    {
        super(character);
        moves.addAll(this.getAttackList());
        moves.addAll(this.getSpellList());
        moves.addAll(this.getItemList());
    }
    
    void takeTurn(Character enemy)
    {
        System.out.printf("*** %s's turn ***\n\n", this);
        PrintUtil.sleep(2);
        
        HashMap<Integer, Integer> moveMap = new HashMap<>();
        
        int restWeight = 0;
        int moveToUse = 0;
        int moveToUseWeight;
        
        for (int i = 0; i < moves.size(); i++)
        {
            Move currentMove = moves.get(i);
            int weight = 0;
            
            if (currentMove instanceof Attack)
            {
                if (this.getFatigue() >= 8)
                {
                    weight -= 100;
                    restWeight += 40;
                }
                if (this.getMaxHealth() > StatUtil.avgHealth)
                {
                    weight += 10;
                    
                    if (this.getFatigue() >= 4 || currentMove.getPlayerFatigue() <= 2)
                    {
                        weight += 20;
                    }
                    else
                    {
                        weight += 30;
                    }
                }
            }
            
            if (currentMove instanceof Spell spell)
            {
                weight += 20;
                if (this.getMaxMana() > StatUtil.avgMana)
                {
                    weight += 30;
                }
                
                if ((this.getMaxMana() / 3) < this.getMana())
                {
                    restWeight += 5;
                }
                
                if (currentMove instanceof AttackSpell)
                {
                    if (enemy.getHealth() < enemy.getMaxHealth() / 2)
                    {
                        weight += 40;
                    }
                }
                
                if (currentMove instanceof HealSpell)
                {
                    if (this.getHealth() < this.getMaxHealth() / 1.5)
                    {
                        weight += 50;
                    }
                    else if (this.getHealth() < this.getMaxHealth() / 3)
                    {
                        weight += 100;
                    }
                    else 
                    {
                        weight *= 0;
                    }
                }
                
                if (currentMove instanceof StatusSpell)
                {
                    if (enemy.getHealth() > enemy.getMaxHealth() / 1.5 && this.getHealth() > this.getMaxHealth() / 2)
                    {
                        weight += 40;
                    }
                }
                
                if (spell.manaCost > this.getMana())
                {
                    weight = 0;
                    restWeight += 10;
                }
            }
            
            if (currentMove instanceof Item item)
            {
                weight += 20;
                if (currentMove instanceof AttackItem)
                {
                    if (enemy.getHealth() < enemy.getMaxHealth() / 2)
                    {
                        weight += 40;
                    }
                }
                
                if (currentMove instanceof HealItem)
                {
                    if (this.getHealth() < this.getMaxHealth() / 1.5)
                    {
                        weight += 50;
                    }
                    else if (this.getHealth() < this.getMaxHealth() / 3)
                    {
                        weight += 100;
                    }
                    else 
                    {
                        weight *= 0;
                    }
                }
                
                if (currentMove instanceof StatusItem)
                {
                    if (enemy.getHealth() > enemy.getMaxHealth() / 1.5 && this.getHealth() > this.getMaxHealth() / 2)
                    {
                        weight += 40;
                    }
                }
                
                if (item.getUses() == 0 )
                {
                    weight *= 0;
                }
            }
            
            moveMap.put(i, weight);
        }
        
        moveToUseWeight = moveMap.get(0);
        
        for (int i = 1; i < moveMap.size(); i++)
        {
            int tempMoveWeight = moveMap.get(i);
            System.out.print(moves.get(i) + ": ");  
            System.out.print(tempMoveWeight + " ");
            
            if (Math.abs(tempMoveWeight - moveToUseWeight) < 20)
            {
                if (rand.nextInt(10) < 3)
                {
                    moveToUse = i;
                    moveToUseWeight = tempMoveWeight;
                }
            }
            else if (tempMoveWeight - moveToUseWeight > 20)
            {
                moveToUseWeight = tempMoveWeight;
            }
        }
//        System.out.printf("Rest weight = %d, move to use weight = %d, move to use = %s", restWeight, moveToUseWeight, moves.get(moveToUse).getName());
        if (restWeight > moveToUseWeight)
        {
            System.out.printf("%s rested!\n", this.getName());
            PrintUtil.sleep();
            rest.resolve(this, enemy);
        }
        else
        {
            System.out.printf("%s used %s!\n", this.getName(), moves.get(moveToUse).getName());
            moves.get(moveToUse).resolve(this, enemy);
        }
    }
}
