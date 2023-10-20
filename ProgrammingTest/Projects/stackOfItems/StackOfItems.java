package stackOfItems;

public class StackOfItems
{
	String[] arr;
	int size;

	public StackOfItems()
	{
		arr = new String[10];
		size = 0;
	}
	
	public void push(String newItem) // adds to last / top
	{
		if (size > arr.length) // check if there is room
		{
			String[] tempArr = new String[arr.length * 2];

			for (int i = 0; i < size; i++)
			{
				arr[i] = tempArr[i];
			}

			arr = tempArr;
		}
		arr[size] = newItem;
		size++;
	}

	public String pop() // grabs top and removes
	{
		if(size > 0)
		{
			String temp = arr[size-1];
			arr[size-1] = null;
			size--;
			return temp;
		}
		return null;
	}

	public String peek() // return last item
	{
		if(size > 0) 
		{
			return arr[size-1];
		}
		else 
		{
			return null;
		}
	}

	public int search(String target)
	{
		int index = -1;

		for (int i = 0; i < size; i++)
		{
			if (arr[i] == target)
				index = i;
		}

		return index;
	}

	public void empty() // empty array
	{
		arr = null;
	}

	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		if (size == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void print() 
	{
		String[] list = new String[size];
		System.out.println(size);
		int position = 0;
		
		while(peek() != null)
		{
			list[position] = pop();
			position++;
		}
		
		for(int i = 0; i < list.length; i++) 
		{
			System.out.println(i + ":" + list[i]);
		}
	}
}
