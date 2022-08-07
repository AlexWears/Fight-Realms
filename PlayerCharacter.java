package finalproject;

import java.util.ArrayList;

/**
 * @author Alex
 * @pawprint awwkvr
 */

public class PlayerCharacter extends Character
{
    public PlayerCharacter(Character character)
    {
        super(character);
    }
    
    void takeTurn(Character enemy)
    {
        System.out.printf("*** %s's turn ***\n\n", this);
        PrintUtil.sleep();
        while (true)
        {
            System.out.printf("Please choose your move:\n1. Attack  2. Spell  "
                    + "3. Items  4. Rest\n");

            int moveChoice = KeyboardInput.getIntRange(1, 4);
            System.out.println();
            
            int end;
            if (moveChoice == 1)
            {
                end = this.pickAndResolveMove(this.getAttackList(), "attack", enemy);
            }
            else if (moveChoice == 2)
            {
                end = this.pickAndResolveMove(this.getSpellList(), "spell", enemy);
            }
            else if(moveChoice == 3)
            {
                end = this.pickAndResolveMove(this.getItemList(), "item", enemy);
                
                for (int i = 0; i < this.getItemListSize(); i++)
                {
                    if (this.getItemList().get(i).getUses() == 0 )
                        this.getItemList().remove(i);
                }
            }
            else
            {
                System.out.printf("%s rested!\n", this.getName());
                System.out.println();
                PrintUtil.sleep();
                rest.resolve(this, enemy);
                end = 0;
            }
            
            if (end != 1)
            {
                return;
            }
            
        }
    }
    
    private <T extends Move> int pickAndResolveMove(ArrayList<T> moveList, String moveTypeName, Character enemy)
    {
        if (moveList.isEmpty())
        {
            System.out.println("\nSorry, but you have no available moves of that type.\n");
            PrintUtil.sleep(2);
            return 1;
        }
        
        while(true)
        {
            System.out.printf("Enter the number to use the %s, enter 1 to enter description mode, enter 0 to go back\n", moveTypeName);
            try
            {
                if (moveList.get(0) instanceof Attack)
                    System.out.printf("(Fatigue points make your attacks do less damage, they go away with a rest)\n");
                if (moveList.get(0) instanceof Spell)
                    System.out.printf("(Spells cost mana, which you regain when you rest)\n");
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("\nSorry, but you have no moves of that type\n");
                PrintUtil.sleep(2);
                return 1;
            }
            System.out.println();
            System.out.println("1. See Description");

            int i = 2;
            for (var move : moveList)
            {
                System.out.printf("%d. %s\n", i, move); i++;
            }

            int moveChoice = KeyboardInput.getIntRange(0, moveList.size()+1);
            
            if (moveChoice == 0)
            {
                return 1;
            }
            else if (moveChoice == 1)
            {
                System.out.printf("\nWhich %s would you like to know more about?\n", moveTypeName);

                i = 1;
                for (var move : moveList)
                {
                    System.out.printf("%d. %s\n", i, move); i++;
                }
                moveChoice = KeyboardInput.getIntRange(1, moveList.size());
                System.out.println();

                System.out.println(moveList.get(moveChoice-1).getDescription());
                PrintUtil.sleep(2);
                System.out.println();
            }
            else
            {
                System.out.printf("%s used %s!\n", this.getName(), moveList.get(moveChoice-2).getName());
                PrintUtil.sleep();
                moveList.get(moveChoice-2).resolve(this, enemy);
                return 0;
            }
        }
    }
}
