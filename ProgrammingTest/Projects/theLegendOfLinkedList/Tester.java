package theLegendOfLinkedList;

public class Tester
{
	
	public static void main(String[] args)
	{
		Hero player = new Hero(1, 1, 1, 1, 1); //MaxLife, Attack, Defense, Speed, Money
		Event currentEvent = new Monster(true, 1);
		
		player.createHero("Grover", 2);
		player.printStats();
		
		currentEvent.interact(player, currentEvent);
		
		currentEvent = new StatChanges();
		
		currentEvent.interact(player, currentEvent);

		player.printStats();
		/*int battles = 0;
		while(player.getLife() > 0) 
		{
			player.battle(player, scaryMonster);
			scaryMonster = new Monster(false, 1 + battles);
			scaryMonster.printStats();
			player.printStats();
			battles++;
		}*/
		//System.out.println("You lived " + battles);
		
		//player.battle(player, scaryMonster);
		//player.printStats();
	}
}
