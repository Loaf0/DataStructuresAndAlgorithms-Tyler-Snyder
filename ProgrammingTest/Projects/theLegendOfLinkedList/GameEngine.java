/*
* @author Tyler Snyder
* @date 10/19/23
* the GameEngine class handles player input controls the game
*/

package theLegendOfLinkedList;

import java.util.Random;
import java.util.Scanner;

public class GameEngine
{
	private MonsterNameGen nameGen;
	private Random rand;
	private Hero player;
	private Scanner scan;
	private int startDifficulty;
	
	public GameEngine() 
	{
		rand = new Random();
		startDifficulty = 0;
		nameGen = new MonsterNameGen();
		player = new Hero(1, 1, 1, 1, 1);
		scan = new Scanner(System.in);
	}
	
	/*
	* Load main menu and set up the game for the player
	*/
	public void StartMenu() 
	{
		int startChoice = -1;
		
		while(startChoice > 3 || startChoice < 1) 
		{
			System.out.println("The Legend Of Linked List"
					+ "\nEnter corresponding number :"
					+ "\n(1) Start Dungeon" // with Random Character or created character
					+ "\n(2) Start Dungeon From Deeper Floor"
					+ "\n(3) Exit");
			if(scan.hasNextInt())
				startChoice = scan.nextInt();
			else
				scan.next();
			
			if(startChoice > 3 || startChoice < 1) 
			{
				System.out.println("Please enter a number between 1 and 3. ");
			}
		}
		
		if(startChoice == 2)
		{
			int newDifficulty = -1;
			while(newDifficulty < 0) 
			{
				System.out.println("Enter Desired Starting Floor : ");
				if(scan.hasNextInt())
					newDifficulty = scan.nextInt();
				else
					scan.next();
				if(newDifficulty < 0) 
				{
					System.out.println("Please input a positive number. ");
				}
			}
			startDifficulty = newDifficulty;
			startChoice = 1;
		}
		if(startChoice == 1) 
		{
			int charCreationChoice = -1;
			while(charCreationChoice > 2 || charCreationChoice < 1) 
			{
				System.out.println("Character Creation"
						+ "\nEnter corresponding number :"
						+ "\n(1) Create Custom Character" // with Random Character or created character
						+ "\n(2) Use Random Character");
				
				if(scan.hasNextInt())
					charCreationChoice = scan.nextInt();
				else
					scan.next();
				
				if(charCreationChoice > 2 || charCreationChoice < 1) 
				{
					System.out.println("Please enter a number between 1 and 2. ");
				}
			}
			
			if(charCreationChoice == 1) 
			{
				characterCreator();
				enterDungeon();
			}
			else
			{
				player.createHero(nameGen.nameGenerator(), rand.nextInt(5)); //create random name and class for user
				enterDungeon();
			}
		}
		else if(startChoice == 3) 
		{
			System.out.println("Goodbye!");
		}
		scan.close(); //final executed line of code
	}
	
	/*
	* create a character for the player
	*/
	public void characterCreator()
	{
		System.out.print("Enter name : ");
		String name = scan.next();
		
		if(name == "") //if user doesnt add name give one
		{
			name = nameGen.nameGenerator();
		}
		
		int background = -1;
		
		while(background > 5 || background < 1)
		{
			System.out.print("Choose a Background (enter the corresponding number): \n"
					+ "(1) Impoverished \n"
					+ "(2) Fighter \n"
					+ "(3) Rogue \n"
					+ "(4) Nobel \n"
					+ "(5) Warrior \n");
			
			if(scan.hasNextInt())
				background = scan.nextInt();
			else
				scan.next();
			
			if(background > 5 || background < 1) 
			{
				System.out.println("Please enter a number between 0 and 4. ");
			}
		}
		
		player.createHero(name, background-1);
	}
		
	/*
	* start the dungeon crawling game
	*/
	public void enterDungeon() 
	{
		Dungeon dgn = new Dungeon(startDifficulty, scan);
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
			
				if(scan.hasNextInt())
					choice = scan.nextInt();
				else
					scan.next();
				
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
	}
}
