package pokemon;

public class Jolteon extends Pokemon
{
    
    public Jolteon()
    {
        setName("Jolteon");
        setHp(65);
        setAttack(65);
        setDefense(60);
        setSpAttack(110);
        setSpDefense(95);
        setSpeed(130);
    }
    
    public void aiMoveList(Pokemon pokemon)
    {
        int move = getRandomInt(3);
        if(move == 0)
        {
            tickle(pokemon);
        }
        else if(move == 1)
        {
            doublekick(pokemon);
        }
        else
        {
            thunderBolt(pokemon);
        }
    }
    
    public void tickle(Pokemon pokemon)
    {
        System.out.println(getName() + " has used Tickle on " + pokemon.getName());
        System.out.println(pokemon.getName() + "'s attack and defense has been lowered!");
        pokemon.setDefense(pokemon.getDefense()*2/3);
        pokemon.setAttack(pokemon.getAttack()*2/3);
    }
    
    public void doublekick(Pokemon pokemon)
    {
        System.out.println(getName() + " has used Double Kick on " + pokemon.getName());
        spAttack(pokemon, 10);
        spAttack(pokemon, 10);
    }
    
    public void thunderBolt(Pokemon pokemon)
    {
        System.out.println(getName() + " has used Thunder Bolt on " + pokemon.getName());
        spAttack(pokemon, 30);
    }    
}
