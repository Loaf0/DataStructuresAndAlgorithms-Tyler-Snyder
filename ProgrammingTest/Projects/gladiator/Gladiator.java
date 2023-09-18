package gladiator;

import java.util.Random;

public class Gladiator
{
	private Random rand;
	private NameGenerator nameGen;
	
	private String name;
	private int totalHealth; // max health
	private int health; // current Gladiator health
	private int strength; // affects dmg
	private int dexterity; // affects dodge max 20 dexterity dodge (3% per point max chance 60% dodge)
	private int speed; // units distance per turn
	private int team; // player team 0 - AI team 1
	
	private String weapon; // weapon name
	private int attackRange; // in meters
	
	private int xPos;
	private int yPos;
	
	public Gladiator()
	{
		rand = new Random();
		nameGen = new NameGenerator();
		setTeam(1);
	}

	public Gladiator(int xPos, int yPos)
	{
		rand = new Random();
		nameGen = new NameGenerator();
		this.yPos = yPos;
		this.xPos = xPos;
		setTeam(1);
	}

	public Gladiator(String name, int totalHealth, int health, int strength, int dexterity, int speed, String weapon, int attackRange, int xPos, int yPos)
	{
		rand = new Random();
		nameGen = new NameGenerator();
		this.name = name;
		this.totalHealth = totalHealth;
		this.health = health;
		this.strength = strength;
		this.dexterity = dexterity;
		this.speed = speed;
		this.weapon = weapon;
		this.attackRange = attackRange;
		this.xPos = xPos;
		this.yPos = yPos;
		setTeam(1);
	}
	
	public void aiPlayTurn(Gladiator[][] gladiator) 
	{
		Gladiator nearestTarget = null;
		int tempDist = -1;
		boolean nearestFound = false;
		
		for (int y = gladiator.length-1; y >= 0; y--)
		{
			for (int x = 0; x < gladiator[0].length; x++)
			{
				if(gladiator[y][x] instanceof Gladiator) 
				{
					tempDist = (int)distance(gladiator[y][x]);
					System.out.println(tempDist);
					if(tempDist > 0 && tempDist > distance(nearestTarget) && team != gladiator[y][x].getTeam())
					{
						nearestTarget = gladiator[y][x];
						nearestFound = true;
					}
						
				}
			}
		}
		
		if(nearestFound) 
		{
			System.out.println("the closest enemy " + getName() + " is " + nearestTarget.getName());
			
			if(distance(nearestTarget) < attackRange)
			{
				damage(nearestTarget, getStrength());
				System.out.println("Attacking!");
			}
			else 
			{
				System.out.println("move closer please");
			}
		}
		else 
		{
			System.out.println("ERROR : No enemy found");
		}
	}
	
	public boolean damage(Gladiator gladiator, int damage) // attempt to deal damage
	{
		int rng = getRandomInt(100) + 1;
		if(rng > 95)
		{
			System.out.println("Critical Hit!");
			gladiator.setHealth(gladiator.getHealth() - damage);
			return true;
		}
		else if ((gladiator.getDexterity() * 3) > (rng)) // attack dodged
		{
			return false;
		}
		else // attack hit
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
	
	public double distance(Gladiator gladiator) // distance calculation < speed
	{
		if(gladiator == null) 
		{
			return -1.0;
		}
		return Math.sqrt(Math.pow(gladiator.getXPos() - getXPos(), 2) + Math.pow(gladiator.getYPos() - getYPos(), 2));
	}

	public String nameGenerator()
	{
		return nameGen.fullNameGenerator();
	}

	public String getName()
	{
		return name.substring(0, name.indexOf(' '));
	}
	
	public String getFullName()
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

	public int getStrength()
	{
		return strength;
	}

	public void setStrength(int strength)
	{
		this.strength = strength;
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
	

	public int getTeam()
	{
		return team;
	}

	
	public void setTeam(int team)
	{
		this.team = team;
	}

}
