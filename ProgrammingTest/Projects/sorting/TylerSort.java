package sorting;

import java.util.Random;

import java.util.ArrayList;

public class TylerSort
{
	Random rand;

	public TylerSort()
	{
		rand = new Random();
	}

	public void bubbleSort(ArrayList<Integer> arr)
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
	}

	public void selectionSort(ArrayList<Integer> arr)
	{
		boolean loop = true;
		int position = 0;
		int lowestPosition = 0;
		int lowest = 0;
		boolean swap = false;

		while (loop)
		{

			if (position < arr.size())
			{
				lowest = arr.get(position);

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
			}

			position++;

			if (swap == false || position >= arr.size())
			{
				loop = false;
			}
		}
	}

	public void insertionSort(ArrayList<Integer> arr)
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
	}

	public void mergeSort(ArrayList<Integer> arr)
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
	}

	public void shellSort(ArrayList<Integer> arr) // written from blackboard provided psudocode on tutorialspoint.com
	{
		int interval = 0;
		int valueToInsert = -1;
		int inner = -1;

		while (interval < arr.size() / 3) // 0 1 3 10 31 64
		{
			interval = interval * 3 + 1;
		}

		while (interval > 0)
		{
			for (int outer = interval; outer < arr.size(); outer++)
			{
				valueToInsert = arr.get(outer);
				inner = outer;

				while (inner > interval - 1 && arr.get(inner - interval) >= valueToInsert)
				{
					arr.set(inner, arr.get(inner - interval));
					inner -= interval;
				}

				arr.set(inner, valueToInsert);
			}

			interval = (interval - 1) / 3;
		}
	}

	public void quickSort(ArrayList<Integer> arr) // alternate method to use same input format as other sorting algorithms
	{
		int first = 0;
		int last = arr.size()-1;
		
		if (first < last)
		{
			int pivIndex = partition(arr, first, last);
			quickSort(arr, first, pivIndex - 1);
			quickSort(arr, pivIndex + 1, last);
		}

	}
	
	public void quickSort(ArrayList<Integer> arr, int first, int last) // written from book page 409
	{
		if (first < last)
		{
			int pivIndex = partition(arr, first, last);
			quickSort(arr, first, pivIndex - 1);
			quickSort(arr, pivIndex + 1, last);
		}

	}

	public int partition(ArrayList<Integer> arr, int first, int last) // used for quick sort seperations
	{
		int pivot = arr.get(first);
		int up = first;
		int down = last;

		do
		{
			while (up < last && pivot >= arr.get(up))
			{
				up++;
			}

			while (pivot < arr.get(down))
			{
				down--;
			}

			if (up < down)
			{
				int temp = arr.get(up);
				arr.set(up, arr.get(down));
				arr.set(down, temp);
			}
		} while (up < down);
		{
			int temp = arr.get(first);
			arr.set(first, arr.get(down));
			arr.set(down, temp);
		}

		return down;
	}

	public void heapSort(ArrayList<Integer> arr)// based on the algorithm by Michael Sambol https://youtu.be/2DmK_H7IdTo also used the book and https://www.mygreatlearning.com/blog/heap-sort/ for deeper understanding
	{
		//turning array into heap
		int size = arr.size();

		for (int i = size/2 - 1; i >= 0; i--)
		{
			heapify(arr, size, i);
		}
		
		//sorting using heapify
		for(int i = size -1; i >= 0; i--) 
		{
			//swap with "root"
			int temp = arr.get(i);
			arr.set(i, arr.get(0));
			arr.set(0, temp);
			//double check root because it got swapped after sorting last element
			heapify(arr, i, 0);
		}
		
	}

	public void heapify(ArrayList<Integer> arr, int size, int i) 
	{
		// these are the "Nodes" of the binary tree
		int leftNode = 2 * i; //formula for children of parent
		int rightNode = (2 * i) + 1; 
		int largest = i; //root node

		if (size > leftNode && arr.get(leftNode) > arr.get(largest))
		{
			largest = leftNode;
		}
		if (size > rightNode && arr.get(rightNode) > arr.get(largest)) //double check
		{
			largest = rightNode;
		}
		if (largest != i)
		{
			int temp = arr.get(i);
			arr.set(i , arr.get(largest));
			arr.set(largest, temp);
			
			heapify(arr, size, largest);
		}
	}

	public boolean validate(ArrayList<Integer> arr)
	{
		for (int i = 0; i < arr.size() - 1; i++)
		{
			if (arr.get(i) > arr.get(i + 1))
			{
				return false;
			}
		}
		return true;
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
