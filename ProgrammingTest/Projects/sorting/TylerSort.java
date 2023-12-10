package sorting;
import java.util.Random;

import myTree.MyBinaryTree;

import java.util.ArrayList;


public class TylerSort
{
	Random rand;
	
	public TylerSort() 
	{
		rand = new Random();
	}
	
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

	public ArrayList<Integer> shellSort(ArrayList<Integer> arr) // written from blackboard provided psudocode on tutorialspoint.com
	{
		int interval = 0;
		int valueToInsert = -1;
		int inner = -1;
		
		while(interval < arr.size()/3) // 0 1 3 10 31 64
		{
			interval = interval * 3 + 1;
		}
		
		while(interval > 0) 
		{
			for(int outer = 0; outer < arr.size(); outer++) 
			{
				valueToInsert = arr.get(outer);
				inner = outer;
				
				while(inner > interval - 1 && arr.get(inner - interval) >= valueToInsert) 
				{
					arr.set(inner, inner - interval);
					inner -= interval;
				}
				
				arr.set(inner, valueToInsert);
			}
			interval = (interval - 1) / 3; 		
		}
		return arr;
	}

	public ArrayList<Integer> quickSort(ArrayList<Integer> arr) //algorithm written freehand based on this image https://www.geeksforgeeks.org/wp-content/uploads/gq/2014/01/QuickSort2.png
	{
		int pivot = (int) ((arr.size() - 1) * Math.random()); //from first to last of arr size
		int index = 0;
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		while(arr.size() > 1) 
		{
			if(arr.get(pivot) > arr.get(index)) 
			{
				left.add(arr.get(index));
				arr.remove(index);
				index--;
			}
			else if(arr.get(pivot) <= arr.get(index)) 
			{
				right.add(arr.get(index));
				arr.remove(index);
				index--;
			}
			index++;
		}
		
		
		System.out.println(pivot);
		System.out.println(left.toString());
		System.out.println(right.toString());
		return arr;
	}
	
	ArrayList<Integer> heapSort(ArrayList<Integer> arr)
	{
		return arr;
	}
	
	public boolean validate(ArrayList<Integer> arr) 
	{	
		for(int i = 0; i < arr.size()-1; i++) 
		{
			if(arr.get(i) <= arr.get(i+1)) 
			{
				return false;
			}
		}
		return true;
	}
	
	public int linearSearch(ArrayList<Integer> arr, int target) 
	{
		for(int i = 0; i < arr.size(); i++) 
		{
			if(arr.get(i) == target) 
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean binaryTreeSearch(ArrayList<Integer> arr, int target) 
	{
		MyBinaryTree bt = new MyBinaryTree();
		bt.add(arr);
		
		return bt.dftContains(target);
	}
	
	public boolean startBinarySearch(ArrayList<Integer> originalArr, int first, int last, int target, boolean useRecursion) 
	{
		ArrayList<Integer> arr = originalArr;
		mergeSort(arr);
		
		if(!useRecursion)
			return binarySearch(arr, first, last, target);
		else
			return recursiveBinarySearch(arr, first, last, target);
	}
	
	public boolean binarySearch(ArrayList<Integer> arr, int first, int last, int target) 
	{
		int middle = 0;
		
		while(first <= last) 
		{
			middle = (first + last) / 2;
			if(arr.get(middle) == target) 
			{
				return true;
			}
			if(arr.get(middle) < target)
			{
				first = middle;
			}
			else 
			{
				last = middle;
			}
		}	
		return false;
	}
	
	public boolean recursiveBinarySearch(ArrayList<Integer> arr, int first, int last, int target) 
	{
		int middle = 0;
		
		if(first <= last) 
		{
			middle = (first + last) / 2;
				
			if(arr.get(middle) == target) 
			{
				return true;
			}
			if(arr.get(middle) < target)
			{
				first = middle;
			}
			else 
			{
				last = middle;
			}
		}
					
		return recursiveBinarySearch(arr, first, last, target);
		
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
