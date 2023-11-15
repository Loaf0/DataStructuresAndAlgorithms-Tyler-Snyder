package sorting;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSort
{
	
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(9,8,7,6,5,4,3,2,1));
		//ArrayList<Integer> arr = new ArrayList<Integer>();
		TylerSort ts = new TylerSort();
		//Random rand = new Random();		
		
		/*int randomNumberSize = 13500;
		
		for(int i = 0; i < randomNumberSize; i++)
		{
			arr.add(Math.abs(rand.nextInt() % 100));
		}*/
		
		//long mergeTime = System.currentTimeMillis();
		ts.mergeSort(arr);
		//mergeTime = System.currentTimeMillis() - mergeTime;
		ts.print(arr);
		//System.out.println("Bubble sort time :"  + mergeTime);
	}
}
