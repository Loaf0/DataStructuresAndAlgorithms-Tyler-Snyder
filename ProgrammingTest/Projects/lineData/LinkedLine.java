package lineData;

import java.util.LinkedList;

public class LinkedLine
{
	LinkedList<Person> line;
	int size;
	
	public LinkedLine() 
	{
		line = new LinkedList<Person>();
		size = 0;
	}
	
	public void offer(String name)
	{
		line.offer(new Person(name));
		size++;
	}
	
	public Person poll()
	{
		return line.poll();
	}
	
	public Person peek() 
	{
		return line.peek();
	}

	public void print() 
	{
		@SuppressWarnings("unchecked")
		LinkedList<Person> temp = (LinkedList<Person>) line.clone();
		
		for(int i = temp.size(); i > 0; i--)
		{
			System.out.println(temp.poll().getName());
		}
	}
	
}
