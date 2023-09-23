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
	
	public TylerDataHolder(int arrayLength)
	{
		friends = new String[arrayLength];
		size = friends.length;
		pointer = 0;
	}
	
	public String get(int index) 
	{
		return friends[index];
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
	
	public void addFriend(int position, String friendName) 
	{
		if(pointer < size) 
		{
			for(int i = friends.length; i < position; i--) 
			{
				friends[i] = friends[i+1];
			}
			friends[position] = friendName;
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
	
	public boolean removeFriend(String target)
	{	
		for(int i = 0; i < friends.length; i++)
		{
			if(friends[i] == target) 
			{
				for(int x = i; x < friends.length; x++)
				{
					if(x+1 < friends.length) 
					{
						friends[x] = friends[x+1];
					}
				}
				pointer--;
				return true;
			}
		}
		return false;
	}
	
	public int getSize() //not array size but the amount of elements in arraylist
	{
		return pointer;
	}
	
	public int getLength()
	{
		return friends.length;
	}
	
	public void printArray()
	{
		for(int i = 0; i < size; i++) 
		{
			if(friends[i] != null)
			{
				System.out.println(friends[i]);				
			}
		}
	}
	
	public void clear() 
	{
		for(int i = 0; i < friends.length; i++) 
		{
			friends[i] = null;
		}
	}
	
	public TylerDataHolder deepClone() 
	{
		TylerDataHolder cloneArray = new TylerDataHolder(friends.length);
		for(int i = 0; i < friends.length; i++) 
		{
			cloneArray.addFriend(friends[i]);
		}
		return cloneArray;
	}
	
	public boolean isEmpty() 
	{
		for(int i = 0; i < friends.length; i++) 
		{
			if(friends[i] == null)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean doesExist(String target) 
	{
		for(int i = 0; i < friends.length; i++) 
		{
			if(friends[i] == target)
			{
				return true;
			}
		}
		return false;
	}
}
