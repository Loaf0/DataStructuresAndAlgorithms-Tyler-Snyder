package genericDataHolder;

public class GenericDataHolder<E>
{
	private E[] arr;
	private int size;
	private int pointer;

	@SuppressWarnings("unchecked")
	public GenericDataHolder()
	{
		arr = (E[]) new Object[10];
		size = arr.length;
		pointer = 0;
	}

	public E get(int index)
	{
		return arr[index];
	}

	public void addObject(E friendName)
	{
		if (pointer < size)
		{
			arr[pointer] = friendName;
			pointer++;
		}
		else
		{
			size += size;
			@SuppressWarnings("unchecked")
			E[] newArr = (E[]) new Object[size];

			for (int i = 0; i < arr.length; i++)
			{
				newArr[i] = arr[i];
			}

			newArr[pointer] = friendName;

			arr = newArr;
		}
	}

	public void addObject(int position, E friendName)
	{
		if (pointer < size)
		{
			for (int i = arr.length; i < position; i--)
			{
				arr[i] = arr[i + 1];
			}
			arr[position] = friendName;
		}

	}

	public void removeObject(int position)
	{
		for (int i = position; i < arr.length; i++)
		{
			if (i + 1 < arr.length)
			{
				arr[i] = arr[i + 1];
			}
		}

		pointer--;
	}

	public boolean removeObject(E target)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == target)
			{
				for (int x = i; x < arr.length; x++)
				{
					if (x + 1 < arr.length)
					{
						arr[x] = arr[x + 1];
					}
				}
				pointer--;
				return true;
			}
		}
		return false;
	}

	public int getSize() // not array size but the amount of elements in arraylist
	{
		return pointer;
	}

	public int getLength()
	{
		return arr.length;
	}

	public void printArray()
	{
		for (int i = 0; i < size; i++)
		{
			if (arr[i] != null)
			{
				System.out.println(arr[i]);
			}
		}
	}

	public void clear()
	{
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = null;
		}
	}

	public GenericDataHolder<E> deepClone()
	{
		GenericDataHolder<E> cloneArray = new GenericDataHolder<>();
		for (int i = 0; i < arr.length; i++)
		{
			cloneArray.addObject(arr[i]);
		}
		return cloneArray;
	}

	public boolean isEmpty()
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == null)
			{
				return false;
			}
		}
		return true;
	}

	public boolean doesExist(E target)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == target)
			{
				return true;
			}
		}
		return false;
	}
}
