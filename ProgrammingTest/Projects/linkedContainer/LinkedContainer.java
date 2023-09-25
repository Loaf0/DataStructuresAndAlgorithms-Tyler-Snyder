package linkedContainer;

public class LinkedContainer //holds two values that 
{
	private Box nextBox;
	
	public LinkedContainer() 
	{
		nextBox = new Box(null);
	}
	
	public void add(int index, String newData) 
	{
		nextBox.add(index, newData);
	}
	
	public void printAll() 
	{
		int size = nextBox.getSize();
		for(int i = 1; i < size; i++) 
		{
			if(nextBox.getData(i) != null)
				System.out.println(nextBox.getData(i));
		}
	}
	
	
}
