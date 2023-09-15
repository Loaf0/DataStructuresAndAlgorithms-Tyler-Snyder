package Pokemon;

public class Growlithe extends Pokemon
{
	public Growlithe()
	{
		setName("Growlithe");
		setHp(55);
		setAttack(70);
		setDefense(45);
		setSpAttack(75);
		setSpDefense(50);
		setSpeed(60);
	}

	public void aiMoveList(Pokemon pokemon)
	{
		int move = getRandomInt(3);
		if (move == 0)
		{
			flameWheel(pokemon);
		} else if (move == 1)
		{
			rockSmash(pokemon);
		} else
		{
			curse(pokemon);
		}
	}

	public void flameWheel(Pokemon pokemon)
	{
		System.out.println(getName() + " has used Flame Wheel on " + pokemon.getName());
		spAttack(pokemon, 10);
	}

	public void rockSmash(Pokemon pokemon)
	{
		System.out.println(getName() + " has used Rock Smash on " + pokemon.getName());
		attack(pokemon, 20);
	}

	public void curse(Pokemon pokemon)
	{
		System.out.println(getName() + " has used Curse on " + pokemon.getName());
		spAttack(pokemon, 30);
	}
}