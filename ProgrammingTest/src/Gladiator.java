import java.util.Random;

public class Gladiator
{
	private Random rand;
	private NameGenerator nameGen;
	
	private String name;
	private int totalHealth; // max health
	private int health; // current Gladiator health
	private int strenth; // affects dmg
	private int dexterity; // affects dodge max 20 dexterity dodge (3% per point max chance 60% dodge)
	private int speed; // units distance per turn

	private String weapon;
	private int attackRange; // in meters

	private int xPos;
	private int yPos;
	
	public Gladiator(String name, int totalHealth, int health, int strength, int dexterity, int speed, String weapon, int attackRange, int xPos, int yPos)
	{
		rand = new Random();
		this.name = name;
		this.totalHealth = totalHealth;
		this.health = health;
		this.strenth = strength;
		this.dexterity = dexterity;
		this.speed = speed;
		this.weapon = weapon;
		this.attackRange = attackRange;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Gladiator() 
	{
		
	}

	public boolean damage(Gladiator gladiator, int damage) // attempt to deal damage
	{
		if ((gladiator.getDexterity() * 3) > (getRandomInt(100) + 1)) // attack dodged
		{
			return false;
		} else // attack hit
		{
			gladiator.setHealth(gladiator.getHealth() - damage);
			return true;
		}
	}

	public int getRandomInt(int upperLimit) // random int from [zero, limit)
	{
		return rand.nextInt(upperLimit);
	}

	public boolean isInDistance(Gladiator gladiator) // distance calculation < speed
	{
		return Math.sqrt(Math.pow(gladiator.getXPos() - getXPos(), 2) + Math.pow(gladiator.getYPos() - getYPos(), 2)) <= speed;
	}

	public String nameGenerator()
	{
		return nameGen.fullNameGenerator();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getTotalHealth()
	{
		return totalHealth;
	}

	public void setTotalHealth(int totalHealth)
	{
		this.totalHealth = totalHealth;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getStrenth()
	{
		return strenth;
	}

	public void setStrenth(int strenth)
	{
		this.strenth = strenth;
	}

	public int getDexterity()
	{
		return dexterity;
	}

	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public String getWeapon()
	{
		return weapon;
	}

	public void setWeapon(String weapon)
	{
		this.weapon = weapon;
	}

	public int getAttackRange()
	{
		return attackRange;
	}

	public void setAttackRange(int attackRange)
	{
		this.attackRange = attackRange;
	}

	public int getXPos()
	{
		return xPos;
	}

	public void setXPos(int xPos)
	{
		this.xPos = xPos;
	}

	public int getYPos()
	{
		return yPos;
	}

	public void setYPos(int yPos)
	{
		this.yPos = yPos;
	}
	
	public void setCoords(int x, int y) 
	{
		xPos = x;
		yPos = y;
	}

}
