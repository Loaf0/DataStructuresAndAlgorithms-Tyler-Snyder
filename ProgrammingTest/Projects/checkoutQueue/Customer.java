package checkoutQueue;

import java.util.Random;

public class Customer
{
	private int numItems;
	
	public Customer(int upperLimit) 
	{
		Random rand = new Random();
		numItems = rand.nextInt(upperLimit)+1;
	}

	public int getNumItems()
	{
		return numItems;
	}
	
	public int removeItem() 
	{
		numItems--;
		return numItems;
	}
}
