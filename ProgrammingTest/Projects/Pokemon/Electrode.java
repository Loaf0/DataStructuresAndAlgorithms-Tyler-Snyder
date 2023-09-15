package Pokemon;

public class Electrode extends Pokemon
{

	public Electrode()
	{
		setName("Electrode");
		setHp(60);
		setAttack(50);
		setDefense(70);
		setSpAttack(80);
		setSpDefense(80);
		setSpeed(150);
	}

	public void aiMoveList(Pokemon pokemon)
	{
		int move = getRandomInt(3);
		if (move == 0)
		{
			reflect(pokemon);
		} else if (move == 1)
		{
			takeDown(pokemon);
		} else
		{
			selfDestruct(pokemon);
		}
	}

	public void reflect(Pokemon pokemon)
	{
		System.out.println(getName() + " has used reflect");
		System.out.println(getName() + "'s defense has been Greatly Increased!");
		setDefense(pokemon.getDefense() * 2);
	}

	public void takeDown(Pokemon pokemon)
	{
		System.out.println(getName() + " has used Take Down on " + pokemon.getName());
		spAttack(pokemon, 30);
	}

	public void selfDestruct(Pokemon pokemon)
	{
		System.out.println(getName() + " has used Self-Destruct on " + pokemon.getName());
		spAttack(pokemon, 300);
		setHp(0);
	}
}
