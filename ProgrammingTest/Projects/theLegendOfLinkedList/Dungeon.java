package theLegendOfLinkedList;

import java.util.Random;

public class Dungeon
{
	private int difficulty;
	private Room prevRoom;
	private Room nextRoom;
	private int size;
	Random rand;

	public Dungeon() // rand size between 5-8
	{
		rand = new Random();
		difficulty = 0;
		prevRoom = nextRoom;
	}

	public void enter(Hero hero, char room)
	{
		if(prevRoom != null && nextRoom != null) 
		{
			if (room == 'l')
			{
				hero.interact(hero, prevRoom.getEvent());
				if(prevRoom.getIsExit()) 
				{
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
				if(nextRoom.getIsExit()) 
				{
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

	public void generateDungeon() 
	{
		int dungeonSize = rand.nextInt(4)+4;
		incrementDifficulty();
		clear();
		
		for(int i = 0; i < dungeonSize; i++) 
		{
			add();
		}
		addExit();
		
		size = dungeonSize;
	}
	
	public void removeFirst()
	{
		nextRoom = nextRoom.getNextRoom();
		nextRoom.setPrevRoom(prevRoom);
		size--;
	}

	public void removePrev()
	{
		prevRoom = prevRoom.getPrevRoom();
		prevRoom.setNextRoom(nextRoom);
		size--;
	}

	public void addExit()
	{
		Event bossEvent = new Monster(true, difficulty); 
		Room temp = nextRoom;
		for(int i = 0; i < size/2; i++) 
		{
			temp = temp.getNextRoom();
		}
		temp.setEvent(bossEvent);
		temp.isExit();
	}

	public Event genRandEvent()
	{
		int roll = rand.nextInt(3);

		Event newEvent = new Monster(false, difficulty);

		if (roll == 0 || roll == 1)
		{
			newEvent = new Monster(false, difficulty);
		}
		else
		{
			newEvent = new StatChanges();
		}

		return newEvent;
	}

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

	public String getEventName(int index) // only grabs first rn
	{
		return nextRoom.getEvent().getName(); // room.getEvent.getName();
	}

	public Event getNextEvent()
	{
		return nextRoom.getEvent();
	}

	public Event getPrevEvent()
	{
		return prevRoom.getEvent();
	}

	public int getSize()
	{
		return size;
	}

	public void map()
	{
		if(prevRoom != null && nextRoom != null) 
		{
			Room temp = prevRoom;
	
			System.out.print("Current Dungeon :\n" + temp.getName());
			temp = temp.getPrevRoom();
			
			for (int i = 1; i < size; i++)
			{
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
	
	public void incrementDifficulty()
	{
		difficulty++;
	}
	
	public int getDifficulty()
	{
		return difficulty;
	}
	
	public void clear()
	{
		nextRoom = null;
		prevRoom = null;
	}
}
