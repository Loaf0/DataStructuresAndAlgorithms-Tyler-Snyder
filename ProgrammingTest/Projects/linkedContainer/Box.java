package linkedContainer;

public class Box
{
	private String data;
	private Box nextBox;

	public Box(String newData)
	{
		data = newData;
		nextBox = null;
	}
	
	public Box(String newData, Box box)
	{
		data = newData;
		nextBox = box;
	}

	public String getData()
	{
		return data;
	}
	
	public String getData(int index)
	{
		if(index == 0) 
		{
			return data;
		}
		else 
		{
			return nextBox.getData(index - 1);
		}
	}

	public void add(String newData)
	{
		if (data == null)
		{
			data = newData;
		}
		else
		{
			if (nextBox == null)
			{
				nextBox = new Box(null);
			}
			
			nextBox.add(newData);
		}
	}

	public void set(String newData, int index)
	{
		if (index == 0)
		{
			data = newData;
		}
		else
		{
			if (nextBox == null)
			{
				nextBox = new Box(null);
			}
			nextBox.add(newData, index - 1);
		}
	}

	public void add(String newData, int index)
	{
		if (index == 0)
		{
			data = newData;
		}
		else
		{
			if (nextBox == null)
			{
				nextBox = new Box(null);
			}
			nextBox.add(newData, index - 1);
		}
	}

	// remove just assign over the part of the chain and clip it out

	public void remove(String target) 
	{
		if(nextBox != null && nextBox.getData() == target) 
		{
			nextBox = nextBox.getNextBox();
			
		}
		else 
		{
			nextBox.remove(target);	
		}
	}
	
	public void remove(int index) 
	{
		if(index == 1) 
		{
			nextBox = nextBox.getNextBox();;
		}
		else 
		{
			nextBox.remove(index - 1);
		}
	}

	public void print()
	{
		System.out.println(data);

		if (nextBox != null && nextBox.getData() != null)
		{
			nextBox.print();
		}
	}

	public String getNextData()
	{
		return nextBox.getData();
	}

	public void setNextData(String newData)
	{
		nextBox.setData(newData);
	}
	
	public void setNextBox(Box newNextBox)
	{
		nextBox.setBox(newNextBox);
	}
	
	public void setBox(Box newNextBox)
	{
		nextBox = newNextBox;
	}

	public void setData(String newData)
	{
		data = newData;
	}
	
	public Box getNextBox() 
	{
		return nextBox;
	}
}
