package sorting;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Random;

public class TestSort
{
	
	public static void main(String[] args)
	{
		//ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(9,8,7,6,5,4,3,2,1));
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(6,8,7,9,1,3,2,4,5));
		//ArrayList<Integer> arr = new ArrayList<Integer>();
		TylerSort ts = new TylerSort();
		//Random rand = new Random();	
		
//		int randomNumberSize = 100;
//		
//		for(int i = 0; i < randomNumberSize; i++)
//		{
//			arr.add(Math.abs(i-100));
//			arr.add(Math.abs(rand.nextInt() % 100));
//		}
		
		//long mergeTime = System.currentTimeMillis();
		
		System.out.println(ts.startBinarySearch(arr, 0, arr.size(), 10, false));
		//ts.insertionSort(arr)
		//mergeTime = System.currentTimeMillis() - mergeTime;
		ts.print(arr);
		//System.out.println("Bubble sort time :"  + mergeTime);
	}
}
