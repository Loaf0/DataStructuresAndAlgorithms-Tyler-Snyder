package Gladiator;

public class Swordsman extends Gladiator
{

	public Swordsman()
	{
		setName(nameGenerator());
		setTotalHealth(35 + getRandomInt(11)); // [35, 45]
		setHealth(getTotalHealth());
		setStrenth(7 + getRandomInt(4)); // [7, 10] damage
		setDexterity(2 + getRandomInt(3)); // [2, 4] [10% - 20%]
		setSpeed(2 + getRandomInt(2)); // [2, 3] how far you can move
		setWeapon("Sword");
		setAttackRange(1); // [1, 1] distance you can attack
	}

	public void aiPlayTurn()
	{
		
	}

}
