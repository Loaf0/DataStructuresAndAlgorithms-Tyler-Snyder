package vectors;

import java.util.Vector;

public class testVectors
{
	public static void main(String[] args)
	{
		//Vectors, (DEPRECATED) version of arrayLists
		Vector<String> vTest = new Vector<>();
		
		vTest.add("Hello");
		vTest.add("Hello");
		vTest.add("Hello Again!");
		vTest.remove(0);
		
		System.out.println(vTest);
		
		//for each loop
		//used to look at values inside of a collection
		//cannot manipulate data because of the iterator design pattern
		for(String singleElement : vTest) 
		{
			System.out.println(singleElement);
		}
	}
}
