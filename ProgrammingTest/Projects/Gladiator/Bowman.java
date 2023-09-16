package Gladiator;

public class Bowman extends Gladiator
{

	public Bowman()
	{
		setName(nameGenerator());
		setTotalHealth(15 + getRandomInt(6)); // [15, 20]
		setHealth(getTotalHealth());
		setStrenth(4 + getRandomInt(9)); // [4, 12] damage
		setDexterity(5 + getRandomInt(11)); // [5, 15] [15% - 45%]
		setSpeed(1 + getRandomInt(2)); // [1, 2] how far you can move
		setWeapon("Long Bow");
		setAttackRange(3 + getRandomInt(3)); // [3, 5] distance you can attack
	}

	public void aiPlayTurn()
	{
		
	}

}
