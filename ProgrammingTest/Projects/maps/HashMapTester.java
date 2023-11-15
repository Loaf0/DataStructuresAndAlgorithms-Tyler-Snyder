package maps;

import java.util.HashMap;

public class HashMapTester
{
	public static void main(String[] args) 
	{
		HashMap<Integer, String> hMap = new HashMap<>();
		hMap.put(5, "Coconut");
		hMap.put(8, "Mango");
		hMap.put(2, "Watermelon");
		hMap.put(14, "Apple");
		
		//tMap.put(2, "Override");
		
		System.out.println(hMap);
		
		for(int currentInt : hMap.keySet()) 
		{
			System.out.println("Key: " + currentInt + "\n Name: " + hMap.get(currentInt));
		}
		
	}
}
