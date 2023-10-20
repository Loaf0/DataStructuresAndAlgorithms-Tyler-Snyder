/*
* @author Tyler Snyder
* @date 10/18/23
* Entity class use as base for rest of living (or undead) creatures
*/

package theLegendOfLinkedList;

import java.util.Random;

public class Entity extends Event
{
	private Random rand;
	private String name;
	private int maxLife;
	private int life;
	private int attack;
	private int defense;
	private int speed;
	private int money;
	private int level;
	private int xp;
	private int xpRequirement;

	public Entity()
	{
		name = "";
		maxLife = 1;
		life = 1;
		attack = 1;
		defense = 1;
		speed = 1;
		money = 0;
		level = 0;
		xp = 0;
		xpRequirement = 100;
		rand = new Random();
	}

	public Entity(String name, int newMaxLife, int newAttack, int newDefense, int newSpeed, int newMoney) // MaxLife, Attack, Defense, Speed, Money
	{
		name = "";
		maxLife = newMaxLife;
		life = maxLife;
		attack = newAttack;
		defense = newDefense;
		speed = newSpeed;
		money = newMoney;
		level = 0;
		xp = 0;
		xpRequirement = 100;
		rand = new Random();
	}

	/**
	 * @param entity - the attacker
	 * @param entity - the target for the attack
	 * @return boolean - true if entity dies false if otherwise
	 */
	public boolean attack(Entity attacker, Entity defender)
	{
		int randInt = rand.nextInt(10);
		int dmg = 0;

		if (randInt >= 5) // 10% crit chance to ingore armor stops stalemate
		{
			dmg = (attacker.getAttack() - (defender.getDefense()));
		}
		else if (randInt == 0)// crit
		{
			dmg = attacker.getAttack() * 2;
		}
		else // armor avoid
		{
			dmg = attacker.getAttack();
		}

		if (dmg > 0)// so you can't accidentally heal enemies
		{
			defender.setLife(defender.getLife() - dmg);
			System.out.println(attacker.getName() + "'s attack dealt " + dmg + " damage!");
		}
		else
		{
			System.out.println(attacker.getName() + "'s attack was blocked!");
		}

		if (defender.getLife() < 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * compare speed of two entites
	 * 
	 * @param entity - the target for the speed comparison
	 * @return boolean - true if entity dies false if otherwise
	 */
	public boolean compareSpeed(Entity entity)
	{
		if (speed > entity.getSpeed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * execute on level up
	 * 
	 * @param entity - the target for the attack
	 */
	public void levelUp()
	{
		System.out.println(name + " has leveled up!");
		maxLife++;
		attack++;
		defense++;
		speed++;
		level++;
		life = maxLife;
		xpRequirement += 25;
	}

	/**
	 * the calculations for gaining xp
	 */
	public void gainXp(int addedXp)
	{
		xp += addedXp;
		while (xp >= xpRequirement) // in case of double level up
		{
			xp -= xpRequirement;
			levelUp();
		}
	}

	/**
	 * Print player stats
	 */
	public void printStats() // MaxLife, Attack, Defense, Speed, Money
	{
		System.out.println("Name : " + name + "\nHealth : " + life + "/" + maxLife + "\nAttack : " + attack + "\nDefense : " + defense + "\nSpeed : " + speed + "\nXP : " + xp + "\nLevel : " + level
				+ "\nGold : " + money);
	}

	/**
	 * @return the maxLife
	 */
	public int getMaxLife()
	{
		return maxLife;
	}

	/**
	 * @param maxLife - the maxLife to set
	 */
	public void setMaxLife(int maxLife)
	{
		this.maxLife = maxLife;
	}

	/**
	 * @return the life
	 */
	public int getLife()
	{
		return life;
	}

	/**
	 * @param life - the life to set
	 */
	public void setLife(int life)
	{
		this.life = life;
	}

	/**
	 * @return the attack
	 */
	public int getAttack()
	{
		return attack;
	}

	/**
	 * @param attack - the attack to set
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
	 * @param defense - the defense to set
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
	 * @param speed - the speed to set
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
	 * @param money - the money to set
	 */
	public void setMoney(int money)
	{
		this.money = money;
	}

	/**
	 * @return the level
	 */
	public int getLevel()
	{
		return level;
	}

	/**
	 * @param level - the level to set
	 */
	public void setLevel(int level)
	{
		this.level = level;
	}

	/**
	 * @return the xp
	 */
	public int getXp()
	{
		return xp;
	}

	/**
	 * @param xp - the xp to set
	 */
	public void setXp(int xp)
	{
		this.xp = xp;
	}

	/**
	 * @return the Name
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * @param name - the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

}
