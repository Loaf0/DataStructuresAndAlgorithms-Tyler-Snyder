package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestSort
{
	
	public static void main(String[] args)
	{
		//ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(9,8,7,6,5,4,3,2,1));
		//ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(6,8,7,9,1,3,2,4,5));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		TylerSort ts = new TylerSort();
		Random rand = new Random();	
		
		int randomNumberSize = 1000000;
		
		for(int i = 0; i < randomNumberSize; i++)
		{
			arr.add(Math.abs(i-100));
			arr.add(Math.abs(rand.nextInt() % 1000));
		}
		
		System.out.println("Array filled with " + randomNumberSize + " random numbers.");
		
		long timer = System.currentTimeMillis();
		
		ts.heapSort(arr);
		//ts.quickSort(arr, 0, arr.size() - 1);
		
		timer = System.currentTimeMillis() - timer;
		
		System.out.println("Milliseconds to sort : "  + timer);
		System.out.println("Sorting Status : " + ts.validate(arr));
		
		
	}
}
