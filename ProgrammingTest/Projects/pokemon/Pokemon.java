package pokemon;

import java.util.Random;

public class Pokemon
{
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private int exp;
    
    private Random rand;
    
    public Pokemon()
    {
        exp = 0;
        rand = new Random();
    }
    
    public void battle(Pokemon pokemon1, Pokemon pokemon2)
    {
        while(pokemon1.isAlive() && pokemon2.isAlive())            
        {
            if(pokemon1.getSpeed() > pokemon2.getSpeed())
            {
                pokemon1.aiMoveList(pokemon2);
                if(pokemon2.isAlive())
                {
                    pokemon2.aiMoveList(pokemon1);
                }
            }
            else
            {
                pokemon2.aiMoveList(pokemon1);
                if(pokemon1.isAlive())
                {
                    pokemon1.aiMoveList(pokemon2);
                }
            }
                
            pokemon1.printHp();
            pokemon2.printHp();
        }
        
        results(pokemon1, pokemon2);
    }
    
    public void results(Pokemon pokemon1, Pokemon pokemon2)
    {
        if(pokemon1.getHp() <= 0 && pokemon2.getHp() <= 0)
        {
            System.out.println("The pokemon have both fainted, There is no Winner.");
        }
        else if(pokemon1.getHp() > pokemon2.getHp())
        {
            System.out.println(pokemon1.getName() + " has Won!");
        }
        else
        {
            System.out.println(pokemon2.getName() + " has Won!");
        }
        
    }
    
    public void aiMoveList(Pokemon pokemon)
    {
        int move = getRandomInt(3);
        if(move == 0)
        {
            attack(pokemon, 10);
            System.out.println(getName() + " has used NULL ATTACK on " + pokemon.getName());
        }
        else if(move == 1)
        {
            attack(pokemon, 20);
            System.out.println(getName() + " has used NULL ATTACK on " + pokemon.getName());
        }
        else
        {
            attack(pokemon, 30);
            System.out.println(getName() + " has used NULL ATTACK on " + pokemon.getName());
        }
    }
    
    public int getRandomInt(int upperLimit)
    {
        return rand.nextInt(upperLimit);
    }
    
    public int gainExp(int newExp)
    {
        exp += newExp;
        return exp;
    }
    
    public void attack(Pokemon pokemon, int dmg) //for physical moves
    {
        int crit = getRandomInt(16);
        
        if(dmg + (attack - pokemon.getDefense()) / 5 > 0)
        {
            dmg = dmg + (attack - pokemon.getDefense()) / 5; // add the difference between attack and defense/20 gets added to dmg
        }
        else //so you cant heal off pokemons attack
        {
            dmg = 0;
        }
        
        if(crit == 0)
        {
            dmg *= 2;
            System.out.println("It was a Critical Success!");
        }
        
        int hp = pokemon.getHp();
        hp -= dmg;
        pokemon.setHp(hp);
        
        System.out.println("It Dealt " + dmg + " Damage");
    }
    
    public void spAttack(Pokemon pokemon, int dmg) //for special moves
    {
        int crit = getRandomInt(16);
        //boolean didCrit = false;
        
        if(dmg + (spAttack - pokemon.getSpDefense()) / 5 > 0)
        {
            dmg = dmg + (spAttack - pokemon.getSpDefense()) / 5; // add the difference between attack and defense/20 gets added to dmg
        }
        else //so you cant heal off pokemons attack
        {
            dmg = 0;
        }
        
        if(crit == 0)
        {
            dmg *= 2;
            System.out.println("It was a Critical Success!");
        }
        
        if(crit == 1)
        {
            System.out.println("The Attack Missed!");
        }
        else
        {
            int hp = pokemon.getHp();
            hp -= dmg;
            pokemon.setHp(hp);
            
            System.out.println("It Dealt " + dmg + " Damage");
        }
    }
    
    public void printHp()
    {
        if(hp > 0)
        {
            System.out.println(name + " has " + hp + "HP");
        }
        else
        {
            System.out.println(name + " has fainted!");
        }
    }

    public boolean isAlive()
    {
        if(hp > 0)
        {
            return true;   
        }
        else
        {
            return false;
        }
    }
    
    public void setHp(int newHp) 
    {
        hp = newHp;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    public void setAttack(int newAttack)
    {
        attack = newAttack;
    }
    
    public void setDefense(int newDefense)
    {
        defense = newDefense;
    }
    
    public void setSpAttack(int newSpAttack)
    {
        spAttack = newSpAttack;
    }
    
    public void setSpDefense(int newSpDefense)
    {
        spDefense = newSpDefense;
    }
    
    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
    
    public void setExp(int newExp) //use gainExp() to gain this should only be used to set to specific vaules
    {
        exp = newExp;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHp()
    {
        return hp;
    }
    
    public int getAttack()
    {
        return attack;
    }
    
    public int getDefense()
    {
        return defense;
    }
    
    public int getSpAttack()
    {
        return spAttack;
    }
    
    public int getSpDefense()
    {
        return spDefense;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public int getExp()
    {
        return exp;
    }
    
    
    
}
