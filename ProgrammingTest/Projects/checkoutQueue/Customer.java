package checkoutQueue;

import java.util.Random;

public class Customer
{
	private int numItems;
	private int arrival;
	private int departure;
	
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

	public int getArrival()
	{
		return arrival;
	}

	public void setArrival(int arrival)
	{
		this.arrival = arrival;
	}

	public int getDeparture()
	{
		return departure;
	}

	public void setDeparture(int departure)
	{
		this.departure = departure;
	}
}
