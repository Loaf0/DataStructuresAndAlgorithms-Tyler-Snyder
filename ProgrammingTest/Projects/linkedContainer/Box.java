package linkedContainer;

public class Box
{
	private String data;
	private int boxId;
	private static int size;
	private Box nextBox;
	
	public Box(String newData) 
	{
		size++;
		boxId = size;
		data = newData;
	}
	
	public String getData(int targetId) 
	{
		
		if(nextBox == null) 
		{
			nextBox = new Box(null);
		}
		
		if(targetId != boxId) 
		{
			return nextBox.getData(targetId);
		}
		else
		{
			return data;
		}
	}
	
	public void add(int index, String newData)
	{
		if(nextBox == null) 
		{
			nextBox = new Box(null);
		}
		
		if(index != boxId) 
		{
			
			nextBox.add(index, newData);
		}
		else
		{
			data = newData;
		}
	}
	
	public int getSize() 
	{
		return size;
	}
}
