package twoWayLinkedContainer;

public class TwoWayLinkedContainer // holds two values that
{
	private Box head;
	private int size;

	public TwoWayLinkedContainer()
	{
		head = new Box(null);
	}

	public void remove(String target)
	{
		if(target == head.getData())
		{
			head = head.getNextBox();	
		}
		else 
		{
			head.remove(target);
		}
		size--;
	}
	
	public void removeFirst()
	{
		head = head.getNextBox();
		size--;
	}
	
	public void removeLast() 
	{
		remove(size-1);
		size--;
	}

	public void addFirst(String newData)
	{
		Box temp = head;
		head = new Box(newData, temp);
		size++;
	}
	
	public String getData(int index) 
	{
		if(index < size)
		{
			return head.getData(index);
		}
		return "out of bounds";
	}
	
	public void remove(int index) 
	{
		if(index == 0) 
		{
			removeFirst();
		}
		else 
		{
			head.remove(index);
		}
		size--;
	}

	public void add(String newData)
	{
		head.add(newData);
		size++;
	}

	public void add(String newData, int index)
	{
		head.add(newData, index);
		size++;
	}

	public int getSize()
	{
		return size;
	}

	public void printAll()
	{
		if (head.getData() != null)
		{
			head.print();
		}
	}

	public void clear()
	{
		head = new Box(null);
	}

}
