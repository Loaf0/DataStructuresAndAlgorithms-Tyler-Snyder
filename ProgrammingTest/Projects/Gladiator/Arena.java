package Gladiator;

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
		if (gladiators[xPos][yPos] instanceof Gladiator)
		{
			System.out.println("ERROR - There already exists a gladiator here");
			return false;
		}
		else
		{
			gladiator.setCoords(xPos, yPos);
			gladiators[xPos][yPos] = gladiator;

			return true;
		}
	}

	public void arenaPrinter()
	{
		int height = gladiators.length;
		int length = gladiators[0].length;
		String output = "";

		System.out.println(arenaName);

		for (int y = height-1; y >= 0; y--)
		{
			for (int x = 0; x < length; x++)
			{
				if (gladiators[x][y] instanceof Gladiator)
				{
					output = gladiators[x][y].getName();
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
				if(gladiators[x][y] instanceof Gladiator) 
				{
					System.out.println(gladiators[x][y].getFullName()
							+ "\nWeapon : " + gladiators[x][y].getWeapon()
							+ "\nHealth : " + gladiators[x][y].getHealth() + "/" + gladiators[x][y].getTotalHealth()
							+ "\nStrenth : " + gladiators[x][y].getStrenth()
							+ "\nDexterity : " + gladiators[x][y].getDexterity()
							+ "\nSpeed : " + gladiators[x][y].getSpeed()
							+ "\nAttack Range : " + gladiators[x][y].getAttackRange() + "\n");
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
		else if(gladiators[x][y] instanceof Gladiator) 
		{
			System.out.println(gladiators[x][y].getFullName()
					+ "\nWeapon : " + gladiators[x][y].getWeapon()
					+ "\nHealth : " + gladiators[x][y].getHealth() + "/" + gladiators[x][y].getTotalHealth()
					+ "\nStrenth : " + gladiators[x][y].getStrenth()
					+ "\nDexterity : " + gladiators[x][y].getDexterity()
					+ "\nSpeed : " + gladiators[x][y].getSpeed()
					+ "\nAttack Range : " + gladiators[x][y].getAttackRange());
			return true;
		}
		else
		{
			System.out.println("Space is empty");
		}
		
		return true;
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
