package sorting;

import java.util.ArrayList;

public class TylerSort
{
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> arr)
	{
		boolean loop = true;
		boolean swap = false;

		while (loop)
		{
			swap = false;
			for (int i = 0; i < arr.size() - 1; i++)
			{
				if (arr.get(i) > arr.get(i + 1))
				{
					int temp = arr.get(i);
					arr.set(i, arr.get(i + 1));
					arr.set(i + 1, temp);
					swap = true;
				}
			}

			if (!swap)
			{
				loop = false;
			}

		}
		return arr;
	}

	public ArrayList<Integer> selectionSort(ArrayList<Integer> arr)
	{
		boolean loop = true;
		int position = 0;
		int lowestPosition = 0;
		int lowest = 0;
		boolean swap;

		while (loop)
		{
			swap = false;
			if (position < arr.size())
			{
				lowest = arr.get(position);
			}
			for (int i = position; i < arr.size(); i++)
			{
				if (arr.get(i) < lowest)
				{
					lowest = arr.get(i);
					lowestPosition = i;
					swap = true;
				}
			}

			int temp = arr.get(position);
			arr.set(position, lowest);
			arr.set(lowestPosition, temp);

			position++;

			if (swap == false)
			{
				loop = false;
			}
		}
		return arr;
	}

	public ArrayList<Integer> insertionSort(ArrayList<Integer> arr)
	{
		int size = arr.size();
		for (int i = 1; i < size; i++)
		{
			int temp = arr.get(i);
			int x = i - 1;

			while (x >= 0 && arr.get(x) > temp) // swap numbers to correct position
			{
				arr.set(x + 1, arr.get(x));
				x--;
			}
			arr.set(x + 1, temp);
		}
		return arr;
	}

	public ArrayList<Integer> mergeSort(ArrayList<Integer> arr)
	{
		if (arr.size() > 1)
		{
			int midPoint = arr.size() / 2;

			ArrayList<Integer> firstArr = new ArrayList<Integer>();
			ArrayList<Integer> secondArr = new ArrayList<Integer>();

			for (int i = 0; i < midPoint; i++)
			{
				firstArr.add(arr.get(i));
			}

			for (int i = midPoint; i < arr.size(); i++)
			{
				secondArr.add(arr.get(i));
			}

			mergeSort(firstArr);
			mergeSort(secondArr);

			int l = 0;
			int r = 0;
			arr.clear();

			while (l < firstArr.size() && r < secondArr.size())
			{
				if (firstArr.get(l) > secondArr.get(r))
				{
					arr.add(secondArr.get(r));
					r++;
				}
				else
				{
					arr.add(firstArr.get(l));
					l++;
				}
			}

			while (l < firstArr.size())
			{
				arr.add(firstArr.get(l));
				l++;
			}

			while (r < secondArr.size())
			{
				arr.add(secondArr.get(r));
				r++;
			}
		}
		return arr;
	}

	public ArrayList<Integer> randSort(ArrayList<Integer> arr)
	{

		return arr;
	}

	public ArrayList<Integer> shellSort(ArrayList<Integer> arr) //broken destroys first 2
	{
		int interval = 1;
		int elements = arr.size();
		int i = 0;

		while (interval <= elements / 3)
		{
			interval = interval * 3 + 1;
		}
		while (interval > 0)
		{
			System.out.print("iteration " + i + " ");
			for (int outer = interval; outer < elements; outer++)
			{
				int valueToInsert = arr.get(outer);
				int inner = outer;
				while (inner > interval - 1 && arr.get(inner - interval) >= valueToInsert)
				{
					arr.set(inner, inner - interval);
					inner -= interval;
					System.out.println(" item moved :" + arr.get(inner));
				}
				arr.set(inner, valueToInsert);
				System.out.println(" item inserted :" + valueToInsert + ", at position :" + inner);
			}
			interval = (interval - 1) / 3;
			i++;
		}
		return arr;
	}

	public void print(ArrayList<Integer> arr)
	{
		if (arr.size() > 0)
		{
			for (int i = 0; i < arr.size() - 1; i++)
			{
				System.out.print(arr.get(i) + ", ");
			}
			System.out.print(arr.get(arr.size() - 1));
			System.out.println();
		}
	}
}
