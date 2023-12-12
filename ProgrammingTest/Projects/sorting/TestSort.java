package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestSort
{

	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		TylerSort ts = new TylerSort();
		Random rand = new Random();

		int randomNumberSize = 20000;

		for (int x = 1; x <= 10; x++)
		{
			arr.clear();
			for (int i = 0; i < randomNumberSize * x; i++)
			{
				// arr.add(Math.abs(i-100));
				arr.add(Math.abs(rand.nextInt() % 1000));
			}

			System.out.println("Array filled with " + randomNumberSize * x + " random numbers.");

			long timer = System.currentTimeMillis();

			ts.bubbleSort(arr);

			timer = System.currentTimeMillis() - timer;

			System.out.println("Milliseconds to sort : " + timer);
			System.out.println("Sorting Status : " + ts.validate(arr));
			System.out.println("----------------------------------------");
		}

	}
}
