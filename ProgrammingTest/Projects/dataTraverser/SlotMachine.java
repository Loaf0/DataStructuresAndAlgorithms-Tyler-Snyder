package dataTraverser;

import java.util.Random;

public class SlotMachine implements Iterator
{
	private int coins; 
	private int gamesPlayed;
	private Random rand;
	
	public SlotMachine() 
	{
		rand = new Random();
		coins =  0;
	}
	
	public SlotMachine(int newCoins) 
	{
		rand = new Random();
		coins =  newCoins;
	}
	
	public void remove() 
	{
		coins--;
	}
	
	
	public String next() 
	{
		gamesPlayed++;
	
		coins--;
		if (rand.nextInt(2) != 0) 
		{
			coins = coins + 2;
		}
		 
		return "" + coins;
	}
	
	public String pull() 
	{
		return next();
	}
	
	public boolean hasNext() 
	{
		if(coins > 0) 
		{
			return true;
		}
		else
		{
			System.out.println("You played " + gamesPlayed + " games without going broke");
			return false;
		}
	}
}
