package maps;

import java.util.TreeMap;

public class TreeMapTester
{
	public static void main(String[] args) 
	{
		TreeMap<Integer, String> tMap = new TreeMap<>();
		tMap.put(5, "Coconut");
		tMap.put(8, "Mango");
		tMap.put(2, "Watermelon");
		tMap.put(14, "Apple");
		
		//tMap.put(2, "Override");
		
		System.out.println(tMap);
		
		for(int currentInt : tMap.keySet()) 
		{
			System.out.println("Key: " + currentInt + "\n Name: " + tMap.get(currentInt));
		}
		
	}
}
