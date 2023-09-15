package Pokemon;

public class Gengar extends Pokemon
{

	public Gengar()
	{
		setName("Gengar");
		setHp(60);
		setAttack(65);
		setDefense(60);
		setSpAttack(130);
		setSpDefense(75);
		setSpeed(110);
	}

	public void aiMoveList(Pokemon pokemon)
	{
		int move = getRandomInt(3);
		if (move == 0)
		{
			smog(pokemon);
		} else if (move == 1)
		{
			energyBall(pokemon);
		} else
		{
			payback(pokemon);
		}
	}

	public void smog(Pokemon pokemon)
	{
		System.out.println(getName() + " has used Smog on " + pokemon.getName());
		spAttack(pokemon, 10);
	}

	public void energyBall(Pokemon pokemon)
	{
		System.out.println(getName() + " has used Energy Ball on " + pokemon.getName());
		spAttack(pokemon, 20);
	}

	public void payback(Pokemon pokemon)
	{
		System.out.println(getName() + " has used Payback on " + pokemon.getName());
		attack(pokemon, 30);
	}
}
