package sorting;

import java.util.ArrayList;

import myTree.MyBinaryTree;

public class TylerSearch
{
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
		//mergeSort(arr);
		
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
}
