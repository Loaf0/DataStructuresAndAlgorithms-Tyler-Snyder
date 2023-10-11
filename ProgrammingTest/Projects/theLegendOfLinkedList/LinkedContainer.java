package theLegendOfLinkedList;

public class LinkedContainer // holds two values that contain data and contain next 
{
	private Room head;
	private int size;

	public LinkedContainer()
	{
		head = new Room(null);
	}

	public void remove(String target)
	{
		
	}
	
	public void removeFirst()
	{
		head = head.getNextRoom();
		size--;
	}
	
	public void removeLast() 
	{
		
	}

	public void addFirst(String newData)
	{
		
	}
	
	public String getData(int index) 
	{
		return "";
	}
	
	public void remove(int index) 
	{
		if(index == 0) 
		{
			removeFirst();
		}
		else 
		{
			//Loop through
		}
		size--;
	}

	public void add()
	{
		
		size++;
	}

	public void add(String newData, int index)
	{
		size++;
	}

	public int getSize()
	{
		return size;
	}

	public void printAll() //debug function
	{
		
	}

	public void clear()
	{
		head = new Room(null);
	}

}
