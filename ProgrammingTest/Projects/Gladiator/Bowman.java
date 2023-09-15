package Gladiator;

public class Bowman extends Gladiator
{

	public Bowman(int xPos, int yPos)
	{
		//super(xPos, yPos); how tf do i use super()??????
		setCoords(xPos, yPos); // spawn location
		setName(nameGenerator());
		setTotalHealth(15 + getRandomInt(6)); // [15, 20]
		setHealth(getTotalHealth());
		setStrenth(4 + getRandomInt(9)); //[4, 12] damage
		setDexterity(5 + getRandomInt(11)); // [5, 15] [15% - 45%]
		setSpeed(2 + getRandomInt(3)); // [2, 4]
		setWeapon("Long Bow");
		setAttackRange(10 + getRandomInt(6)); // [10, 15] 
	}
	
	public void aiPlayTurn() 
	{
		
	}
	
}
