package gladiator;

public class Arena
{
	private Gladiator[][] gladiators;
	private String arenaName;

	public Arena(String name)
	{
		gladiators = new Gladiator[3][3];
		setArenaName(name);
	}

	public Arena(String name, int height, int length)
	{
		gladiators = new Gladiator[height][length];
		setArenaName(name);
	}

	public boolean addGladiator(Gladiator gladiator, int xPos, int yPos)
	{
		if (gladiators[yPos][xPos] instanceof Gladiator)
		{
			System.out.println("ERROR - There already exists a gladiator here");
			return false;
		}
		else
		{
			gladiator.setCoords(xPos, yPos);
			gladiators[yPos][xPos] = gladiator;

			return true;
		}
	}

	public void arenaPrinter()
	{
		int height = gladiators.length;
		int length = gladiators[0].length;
		String output = "";

		System.out.println(arenaName);

		for (int y = height-1; y > 0; y--)
		{
			for (int x = 0; x < length; x++)
			{
				if (gladiators[y][x] instanceof Gladiator)
				{
					output = gladiators[y][x].getName();
				}
				else
				{
					output = "(" + x + ", " + y + ")";
				}

				System.out.printf("%-12s", output);
			}
			System.out.println(); //new line between loops
		}
		System.out.println(); // print new line after look is over
	}

	public void printInfo() 
	{
		int height = gladiators.length;
		int length = gladiators[0].length;
		
		for (int y = height-1; y >= 0; y--)
		{
			for (int x = 0; x < length; x++)
			{
				if(gladiators[y][x] instanceof Gladiator) 
				{
					System.out.println(gladiators[y][x].getFullName()
							+ "\nWeapon : " + gladiators[y][x].getWeapon()
							+ "\nHealth : " + gladiators[y][x].getHealth() + "/" + gladiators[y][x].getTotalHealth()
							+ "\nStrength : " + gladiators[y][x].getStrength()
							+ "\nDexterity : " + gladiators[y][x].getDexterity()
							+ "\nSpeed : " + gladiators[y][x].getSpeed()
							+ "\nAttack Range : " + gladiators[y][x].getAttackRange() + "\n");
				}
			}
		}
	}
	
	public boolean printInfo(int x, int y) //specific location
	{
//		if(player) // when adding player class
//		{
//			System.out.println(); //dummy code
//		}else
		if(!(x > 0 || x < gladiators[0].length) || !(y > 0 || y < gladiators.length)) 
		{
			System.out.println("Coordinates out of bounds");
			return false;
		}
		else if(gladiators[y][x] instanceof Gladiator) 
		{
			System.out.println(gladiators[y][x].getFullName()
					+ "\nWeapon : " + gladiators[y][x].getWeapon()
					+ "\nHealth : " + gladiators[y][x].getHealth() + "/" + gladiators[y][x].getTotalHealth()
					+ "\nStrength : " + gladiators[y][x].getStrength()
					+ "\nDexterity : " + gladiators[y][x].getDexterity()
					+ "\nSpeed : " + gladiators[y][x].getSpeed()
					+ "\nAttack Range : " + gladiators[y][x].getAttackRange());
			return true;
		}
		else
		{
			System.out.println("Space is empty");
		}
		
		return true;
	}
	
	public Gladiator[][] getArray()
	{
		return gladiators;
	}

	public String getArenaName()
	{
		return arenaName;
	}

	public void setArenaName(String arenaName)
	{
		this.arenaName = arenaName;
	}
}
