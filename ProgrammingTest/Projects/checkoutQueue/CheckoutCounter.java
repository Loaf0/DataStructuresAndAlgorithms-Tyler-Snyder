package checkoutQueue;

import java.util.LinkedList;
import java.util.Queue;

public class CheckoutCounter
{
	private Queue<Customer> queue;
	private int maxLength;
	private int customers;
	private int waitTime;
	private int freeTime;
	private int items;
	
	public CheckoutCounter() 
	{
		queue = new LinkedList<Customer>();
		setWaitTime(0);
		setFreeTime(0);
		setMaxLength(0);
		setCustomers(0);
	}
	
	public void runTick(int globalClock) //tick happens every 5 seconds
	{
		int size = queue.size();
		
		if(size > maxLength) 
		{
			maxLength = size;
		}
		
		if(size > 0) 
		{
			Customer customer = queue.poll(); 
			waitTime = globalClock - customer.getArrival();
			customer.setArrival(globalClock); //calc time waiting in line
			
			globalClock += customer.getNumItems() * 5; //calc time needed
			items += customer.getNumItems();
			
			customer.setDeparture(globalClock);
		}
	}
	
	public void addCustomer(Customer person, int globalClock) 
	{ 
		if(queue.size() < 1) //time it takes to mesure between customers
		{
			freeTime = freeTime + (globalClock - person.getArrival());			
		}
		customers++;
		queue.offer(person);
	}
	
	public int getSize() 
	{
		return queue.size();
	}
	
	public boolean isEmpty() 
	{
		return queue.isEmpty();
	}

	public int getCustomers()
	{
		return customers;
	}

	public void setCustomers(int customers)
	{
		this.customers = customers;
	}

	public int getMaxLength()
	{
		return maxLength;
	}

	public void setMaxLength(int maxLength)
	{
		this.maxLength = maxLength;
	}

	public int getItems()
	{
		return items;
	}

	public void setItems(int items)
	{
		this.items = items;
	}

	public int getFreeTime()
	{
		return freeTime;
	}

	public void setFreeTime(int freeTime)
	{
		this.freeTime = freeTime;
	}

	public int getWaitTime()
	{
		return waitTime;
	}

	public void setWaitTime(int waitTime)
	{
		this.waitTime = waitTime;
	}
	
	
}
