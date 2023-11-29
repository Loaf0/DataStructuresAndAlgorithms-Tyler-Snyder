package sets;

public class Set
{
	String[] set;
	int pointer;
	
	public Set() 
	{
		set = new String[10];
		pointer = 0;
	}
	
	public Set(String[] newSet) 
	{
		int dupes = 0;
		for(int x = 0; x < newSet.length-1; x++) 
		{
			for(int y = x+1; y < newSet.length; y++) 
			{
				if(newSet[x].equals(newSet[y]))
				{
					dupes++;
				}
			}
		}
		
		if(dupes > 0) 
		{
			set = new String[10];
			pointer = 0;
		}
		else 
		{
			set = newSet;
			pointer = newSet.length;
		}
	}
	
	public boolean add(String input) 
	{
		boolean canAdd = true;
		for(int x = 0; x < set.length; x++) 
		{
			if(input.equals(set[x])) 
			{
				canAdd = false;
			}
		}
		
		if(canAdd) 
		{
			//move to larger
			if(set.length-1 <= pointer) 
			{
				String[] newSet = new String[set.length*2];
				for(int x = 0; x < set.length; x++) 
				{
					newSet[x] = set[x];
				}
				set = newSet;
			}
			
			set[pointer] = input;
			pointer++;
			
			return true;
		}
		return false;
	}
	
	public Set union(Set set2) 
	{
		Set output = new Set();
		
		for(int x = 0; x < set.length; x++) 
		{
			output.add(set[x]);
		}
		
		String[] newSet2 = set2.getArray();
		for(int y = 0; y < newSet2.length; y++) 
		{
			output.add(newSet2[y]);
		}
		
		return output;
	}
	
	public Set intersect(Set set2) 
	{
		Set output = union(set2);
		
		String[] newSet2 = set2.getArray();
		for(int y = 0; y < newSet2.length; y++) 
		{
			if(contains(newSet2[y]) && set2.contains(newSet2[y])) 
			{
				output.remove(newSet2[y]);
			}
		}
		
		return output;
	}
	
	
	public Set compliment(Set globalSet)//Wrong
	{
		return intersect(globalSet);
	}
	
	
	public boolean contains(String target) 
	{
		for(int y = 0; y < set.length; y++) 
		{
			if(target.equals(set[y]))
				return true;
		}
		return false;
	}
	
	public boolean remove(String target) 
	{
		for(int y = 0; y < set.length; y++) 
		{
			if(set[y].equals(target)) 
			{
				for(int x = y; x < set.length-1; x++) 
				{
					set[x] = set[x+1];
				}
				set[set.length-1] = "";
				pointer--;
				return true;
			}
		}
		return false;
	}
	
	public void clear() 
	{
		set = new String[10];
		pointer = 0;
	}
	
	public int size() 
	{
		return pointer;
	}
	
	private String[] getArray() 
	{
		return set;
	}
	
	public String toString() 
	{
		String output = "";
		for(int i = 0; i < pointer-1; i++) //didnt add last number check yet
		{
			//if(set[i] != "" && set[i] != null)
				output = output + set[i] + ", ";
		}
		return output + set[pointer-1];
	}
	
	
	
}
