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
	private int internalClock;
	
	public CheckoutCounter() 
	{
		queue = new LinkedList<Customer>();
		internalClock = 0;
		setWaitTime(0);
		setFreeTime(0);
		setMaxLength(0);
		setCustomers(0);
		
	}
	
	public void runTick(int globalClock) //tick happens every 5 seconds
	{

		//System.out.println("Internal Time " + internalClock + " Global Time : " + globalClock);
		if(globalClock >= internalClock) 
		{
			int size = queue.size();
			
			if(size > maxLength) 
			{
				maxLength = size;
			}
			
			if(size > 0) 
			{
				internalClock = globalClock;
				
				Customer customer = queue.poll(); 
				waitTime = internalClock - customer.getArrival();
				customer.setArrival(internalClock); //calc time waiting in line
				
				internalClock += customer.getNumItems() * 5; //calc time needed
				items += customer.getNumItems();
				
				customer.setDeparture(internalClock);
				//System.out.println("from " + customer.getArrival() + " to " + customer.getDeparture() + " with " + customer.getNumItems() + "      Internal Time " + internalClock + " Starting Time : " + globalClock);
			}
			else
			{
				freeTime += 5;
			}
			
		}
		
	}
	
	public void addCustomer(Customer person, int globalClock) 
	{ 
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
