package theLegendOfLinkedList;

import java.util.Random;

public class StatChanges extends Event
{
	Random rand;
	int itemID;
	int maxLife;
	int attack;
	int defense;
	int speed;
	int money;
	String roomName;
	String itemName;
	String itemDescription;

	public StatChanges()
	{
		rand = new Random();

		itemID = rand.nextInt(15);

		if (itemID == 0) // Sword1
		{
			attack = 1;
			itemName = "Rusty Sword";
			roomName = "Item";
			itemDescription = "You feel ready for battle!";
		}
		else if (itemID == 1) // sword2
		{
			attack = 2;
			itemName = "King's Sword";
			roomName = "Item";
			itemDescription = "You feel the strenth of 1000 Soldiers!";

		}
		else if (itemID == 2) // sword3
		{
			attack = 3;
			itemName = "Master Sword";
			roomName = "Item";
			itemDescription = "You feel it's power flowing into you!";

		}
		else if (itemID == 3) // Blindfold
		{
			speed = -1;
			attack = 3;
			itemName = "Magic Blindfold";
			roomName = "Item";
			itemDescription = "Covering your eyes you feel your other senses greatly increase!";

		}
		else if (itemID == 4) // shield1
		{
			defense = 1;
			itemName = "Broken Shield";
			roomName = "Item";
			itemDescription = "You feel sturdier!";

		}
		else if (itemID == 5) // shield2
		{
			defense = 2;
			attack = 1;
			itemName = "Ancient Shield";
			roomName = "Item";
			itemDescription = "You feel the battle knowledge of a long lost time!";

		}
		else if (itemID == 6) // shield3
		{
			defense = 3;
			itemName = "Hylian Shield";
			roomName = "Item";
			itemDescription = "You feel fortified!";
		}
		else if (itemID == 7) // Hermes Boots
		{
			speed = 1;
			itemName = "Hermes Boots";
			roomName = "Item";
			itemDescription = "You feel a weight lifted off your body!";

		}
		else if (itemID == 8) // Magic Berry
		{
			int berryroll = rand.nextInt(4);
			if(berryroll == 0) 
			{
				maxLife = 3;				
			}
			else if(berryroll == 1)
			{
				maxLife = 5;
			}
			else if(berryroll == 2)
			{
				maxLife = 7;
			}
			else 
			{
				maxLife = -3;
			}
			
			itemName = "Magic Berry";
			roomName = "Item";
			itemDescription = "You feel Strange...";

		}
		else if (itemID == 9) // Life Potion
		{
			maxLife = 5;
			itemName = "Life Potion";
			roomName = "Item";
			itemDescription = "You feel your wounds close!";
		}
		else if (itemID == 9) // Coin pouch
		{
			money = rand.nextInt(100) + 1; //so it can't be empty
			itemName = "Coin Pouch";
			roomName = "Item";
			itemDescription = "You found some Gold!!";
		}

		else if (itemID == 11) // mimic
		{
			maxLife = -1;
			itemName = "Mimic";
			roomName = "Item";
			itemDescription = "It's quiet. Too quiet... be careful, it's a trap!";
		}

		else if (itemID == 12) // bear trap
		{
			speed = -1;
			maxLife = -1;
			itemName = "Bear Trap";
			roomName = "Trap";
			itemDescription = "You feel something clamp around your ankle!";
			
		}
		else if (itemID == 13) // bear trap
		{
			speed = -1;
			defense = -2;
			itemName = "Pitfall";
			roomName = "Trap";
			itemDescription = "You feel the floor gives out below you!";
		}
		else if (itemID == 14) // Slime
		{
			attack = -2;
			itemName = "Slime trap";
			roomName = "Trap";
			itemDescription = "You feel yourself get covered in slime!";
		}
	}

	public String getItemDescription()
	{
		return itemDescription;
	}
	
	@Override
	public String getName()
	{
		return roomName;
	}

	public String getItemName()
	{
		return itemName;
	}
	
	/**
	 * @return the maxLife
	 */
	public int getMaxLife()
	{
		return maxLife;
	}

	/**
	 * @param maxLife the maxLife to set
	 */
	public void setMaxLife(int maxLife)
	{
		this.maxLife = maxLife;
	}

	/**
	 * @return the attack
	 */
	public int getAttack()
	{
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack)
	{
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense()
	{
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed()
	{
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	/**
	 * @return the money
	 */
	public int getMoney()
	{
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money)
	{
		this.money = money;
	}
}