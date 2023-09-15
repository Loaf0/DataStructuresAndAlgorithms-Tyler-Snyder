package Pokemon;

public class Battler
{
    public static void main(String[] args)
    {
        Pokemon battleSimulator = new Pokemon();

        Arcanine arcanine = new Arcanine(); //is there a way to only declare the ones i want?
        Growlithe growlithe = new Growlithe(); // it kinda wastes run time declaring all of them
        Gengar gengar = new Gengar();
        Jolteon jolteon = new Jolteon();
        Electrode electrode = new Electrode();

        Pokemon[] pokedex = {arcanine, growlithe, gengar, jolteon, electrode};

        int rand1 = 0;
        int rand2 = 0;

        while(rand1 == rand2) //loop if both random numbers are the same
        {
            rand1 = battleSimulator.getRandomInt(pokedex.length);
            rand2 = battleSimulator.getRandomInt(pokedex.length);
        }

        battleSimulator.battle(pokedex[rand1], pokedex[rand2]);

    }
}
