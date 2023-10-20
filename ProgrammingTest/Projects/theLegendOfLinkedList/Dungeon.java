/*
* @author Tyler Snyder
* @date 10/18/23
* This is the linked list algorithm behind generating and navigating the dungeon crawler map
*/

package theLegendOfLinkedList;

import java.util.Random;
import java.util.Scanner;

public class Dungeon
{
	private Scanner dungeonScanner;
	private int difficulty;
	private Room prevRoom;
	private Room nextRoom;
	private int size;
	Random rand;

	public Dungeon(int diff, Scanner scan)
	{
		dungeonScanner = scan;
		rand = new Random();
		difficulty = diff;
		prevRoom = nextRoom;
	}

	/**
	 * control the clearing of left and right rooms
	 * 
	 * @param the  hero clearing the rooms
	 * @param char 'l' or 'r' to move left or right
	 */
	public void enter(Hero hero, char room)
	{
		if (prevRoom != null && nextRoom != null)
		{
			if (room == 'l')
			{
				hero.interact(hero, prevRoom.getEvent());
				if (prevRoom.getIsExit())
				{
					if (hero.getLife() >= 1)
						generateDungeon();
					System.out.println("You descend deeper into the dungeon!");
				}
				else
				{
					removePrev();

				}
			}
			else if (room == 'r')
			{
				hero.interact(hero, nextRoom.getEvent());
				if (nextRoom.getIsExit())
				{
					if (hero.getLife() > 0)
						generateDungeon();
					System.out.println("You descend deeper into the dungeon!");
				}
				else
				{
					removeFirst();
				}
			}
		}
	}

	/**
	 * randomly generate the dungeon
	 */
	public void generateDungeon()
	{
		int dungeonSize = rand.nextInt(4) + 4;
		incrementDifficulty();
		clear();

		for (int i = 0; i < dungeonSize; i++)
		{
			add();
		}
		size = dungeonSize;
		addExit();
	}

	/**
	 * removes the first room
	 */
	public void removeFirst()
	{
		nextRoom = nextRoom.getNextRoom();
		nextRoom.setPrevRoom(prevRoom);
		size--;
	}

	/**
	 * remove the previous room
	 */
	public void removePrev()
	{
		prevRoom = prevRoom.getPrevRoom();
		prevRoom.setNextRoom(nextRoom);
		size--;
	}

	/**
	 * add an exit to the dungeon
	 */
	public void addExit()
	{
		Event bossEvent = new Monster(true, difficulty);
		Room temp = nextRoom;
		for (int i = 0; i < size / 2; i++)
		{
			temp = temp.getNextRoom();
		}
		temp.setEvent(bossEvent);
		temp.isExit();
	}

	/**
	 * generate a random event
	 */
	public Event genRandEvent()
	{
		int roll = rand.nextInt(25);

		Event newEvent = new Monster(false, difficulty);

		if (roll < 15)
		{
			newEvent = new Monster(false, difficulty);
		}
		else if (roll < 23)
		{
			newEvent = new StatChanges();
		}
		else
		{
			newEvent = new Shop(dungeonScanner);
		}
		return newEvent;
	}

	/**
	 * adds a room with a random event
	 */
	public void add()
	{
		if (nextRoom == null)
		{
			nextRoom = new Room(genRandEvent());
			prevRoom = nextRoom;
		}
		else
		{
			add(genRandEvent());
		}
	}

	/**
	 * @param the event to be added to the new room
	 */
	public void add(Event newEvent)
	{
		if (nextRoom == null)
		{
			nextRoom = new Room(newEvent);
			prevRoom = nextRoom;
		}
		else
		{
			Room temp = nextRoom;
			nextRoom = new Room(newEvent, temp);
			temp.setPrevRoom(nextRoom);
		}
		size++;
	}

	/**
	 * Print the map of the dungeon
	 */
	public void map()
	{
		if (prevRoom != null && nextRoom != null)
		{
			Room temp = prevRoom;

			System.out.print("Current Dungeon :\n" + temp.getName());
			temp = temp.getPrevRoom();

			for (int i = 1; i < size; i++)
			{
				if (temp.getIsExit())
					System.out.print(" - - - " + "Staircase");
				else
					System.out.print(" - - - " + temp.getName());
				temp = temp.getPrevRoom();
			}
			System.out.println("");
		}
		else
		{
			System.out.println("There are no rooms left!");
		}
	}

	/**
	 * @return gets the name of the next room
	 */
	public String getEventName(int index)
	{
		return nextRoom.getEvent().getName();
	}

	/**
	 * @return the event of next room
	 */
	public Event getNextEvent()
	{
		return nextRoom.getEvent();
	}

	/**
	 * @return the event of the prev room
	 */
	public Event getPrevEvent()
	{
		return prevRoom.getEvent();
	}

	/**
	 * @return amount of rooms in dungeon
	 */
	public int getSize()
	{
		return size;
	}

	/**
	 * add one to the difficulty
	 */
	public void incrementDifficulty()
	{
		difficulty++;
	}

	/**
	 * @return current difficulty
	 */
	public int getDifficulty()
	{
		return difficulty;
	}

	/**
	 * Empties the dungeon
	 */
	public void clear()
	{
		nextRoom = null;
		prevRoom = null;
	}
}
