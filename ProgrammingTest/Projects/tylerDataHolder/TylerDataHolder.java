package tylerDataHolder;

public class TylerDataHolder
{
	private String[] friends;
	private int size;
	private int pointer;
	
	public TylerDataHolder()
	{
		friends = new String[10];
		size = friends.length;
		pointer = 0;
	}
	
	public void addFriend(String friendName)
	{
		if(pointer < size)
		{
			friends[pointer] = friendName;
			pointer++;
		}
		else
		{
			size += size;
			String[] newFriends = new String[size];
			
			for(int i = 0; i < friends.length; i++) 
			{
				newFriends[i] = friends[i];
			}
			
			newFriends[pointer] = friendName;
			
			friends = newFriends;
			
		}
	}
	
	public void removeFriend(int position)
	{	
		for(int i = position; i < friends.length; i++)
		{
			if(i+1 < friends.length) 
			{
				friends[i] = friends[i+1];
			}
		}
		
		pointer--;
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public void printArray()
	{
		for(int i = 0; i < friends.length; i++) 
		{
			if(friends[i] != null)
			{
				System.out.println(friends[i]);				
			}
		}
	}
	
}
