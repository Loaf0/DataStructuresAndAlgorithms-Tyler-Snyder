package theLegendOfLinkedList;

import java.util.Scanner;

public class Tester
{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Hero player = new Hero(1, 1, 1, 1, 1); //MaxLife, Attack, Defense, Speed, Money
		
		//Hero creation make method in gameEngine class
		System.out.print("Enter name : ");
		String name = scan.next();
		int background = -1;
		
		while(background > 5 || background < 1)
		{
			System.out.print("Choose a Background (enter the corresponding number): \n"
					+ "(1) Impoverished \n"
					+ "(2) Fighter \n"
					+ "(3) Rogue \n"
					+ "(4) Nobel \n"
					+ "(5) Warrior \n");
			background = scan.nextInt();
			
			if(background > 5 || background < 1) 
			{
				System.out.println("Please enter a number between 0 and 4. ");
			}
		}
		
		player.createHero(name, background-1);
		//scan.close();
		//end of hero creation method
		
		
		//startDungeonCrawler method in gameEngine class
		//Scanner scan = new Scanner(System.in);
		Dungeon dgn = new Dungeon();
		dgn.generateDungeon();
		
		while(player.getLife() > 0)
		{
			int choice = -1;
			while(choice > 4 || choice < 1)
			{
			System.out.print("What will you do? (enter the corresponding number): \n"
					+ "(1) View Map \n"
					+ "(2) Get Character Stats \n"
					+ "(3) Enter Room On Left " + "(The Room Contains : " + dgn.getPrevEvent().getName() + ")\n"
					+ "(4) Enter Room On Right" + "(The Room Contains : " + dgn.getNextEvent().getName() + ")\n");
			choice = scan.nextInt();
				if(choice == 1)
					dgn.map();
				else if(choice == 2)
					player.printStats();
				else if(choice == 3)
					dgn.enter(player, 'l');
				else if(choice == 4)
					dgn.enter(player, 'r');
				else
					System.out.println("Please enter a number between 1 and 4");
			}
				
		}
		int clearedFloors = dgn.getDifficulty() - 1;
		System.out.println(player.getName() + " has cleared " + clearedFloors + " floor(s) of the dungeon! ");
		scan.close();
		//end of crawling method
		
		//dgn.printAll();
		//Event leftEvent = dgn.getPrevEvent();
		//Event rightEvent = dgn.getNextEvent();

		//player.interact(player, leftEvent);
		//player.interact(player, rightEvent);
		
		
		
//		Event currentEvent = new Monster(false, 1); 
//		currentEvent.interact(player, currentEvent);
//		
//		currentEvent = new StatChanges();
//		currentEvent.interact(player, currentEvent);
		
		
		//for(int i = 0; i < 8; i++)
//			dgn.add(1);
//		
		
			
		//dgn.printAllBack();
		
		
		
		//dgn.printAllBackwards();
		
		//currentEvent.interact(player, currentEvent);

		//player.printStats();
		
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
