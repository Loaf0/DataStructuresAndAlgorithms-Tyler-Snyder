package theLegendOfLinkedList;

/*
 * Entity class use as base for rest of living (or undead) creatures
 */
public class Entity
{
	private String name;
	private int maxLife;
	private int life;
	private int attack;
	private int defense;
	private int speed;
	private int money;
	private int level;
	private int xp;

	public Entity(String name, int newMaxLife, int newAttack, int newDefense, int newSpeed, int newMoney) //MaxLife, Attack, Defense, Speed, Money
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
	}
	
	/**
	 * refresh and add stats with level up
	 */
	public void level()
	{
		life = maxLife;
	}

	/**
	 * @param entity - the target for the attack
	 * @return boolean - true if entity dies false if otherwise
	 */
	public boolean attack(Entity entity)
	{
		entity.setLife((int) entity.getLife() - (attack * entity.getDefense() / 10));

		if (entity.getLife() < 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
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
