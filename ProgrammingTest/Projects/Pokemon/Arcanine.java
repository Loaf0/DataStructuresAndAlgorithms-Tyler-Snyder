package Pokemon;

public class Arcanine extends Pokemon
{
    
    public Arcanine()
    {
        setName("Arcanine");
        setHp(90);
        setAttack(110);
        setDefense(80);
        setSpAttack(100);
        setSpDefense(80);
        setSpeed(95);
    }
    
    public void aiMoveList(Pokemon pokemon)
    {
        int move = getRandomInt(3);
        if(move == 0)
        {
            headbutt(pokemon);
        }
        else if(move == 1)
        {
            mudSlap(pokemon);
        }
        else
        {
            dragonBreath(pokemon);
        }
    }
    
    public void headbutt(Pokemon pokemon)
    {
        System.out.println(getName() + " has used Headbutt on " + pokemon.getName());
        attack(pokemon, 10);
    }
    
    public void mudSlap(Pokemon pokemon)
    {
        System.out.println(getName() + " has used Mud Slap on " + pokemon.getName());
        attack(pokemon, 20);
    }
    
    public void dragonBreath(Pokemon pokemon)
    {
        System.out.println(getName() + " has used Dragon Breath on " + pokemon.getName());
        spAttack(pokemon, 30);
    }
}
