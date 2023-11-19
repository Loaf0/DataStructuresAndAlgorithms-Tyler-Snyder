package checkoutQueue;

import java.util.LinkedList;
import java.util.Queue;

public class CheckoutCounter
{
	private Queue<Customer> queue;
	private int customers;
	private int maxLength;
	private int freeTime;
	private int timeWaited;
	private int timeElapsed; //in minutes
	private boolean running;
	
	public CheckoutCounter() 
	{
		queue = new LinkedList<Customer>();
		setMaxLength(0);
		setCustomers(0);
		setTimeWaited(0);
		setTimeElapsed(0);
	}
	
	public void fillArr(CheckoutCounter[] checkouts, int size) 
	{
		for(int i = 0; i < size; i++) 
		{
			checkouts[i] = new CheckoutCounter();
		}
		setMaxLength(checkouts.length);
	}
	
	public void runTick()
	{
		Customer currentCustomer = null;
		
		if(currentCustomer == null)
		{
			currentCustomer = queue.poll();
		}
		
		if(queue.size() >= 0) 
		{
			if(currentCustomer.getNumItems() <= 0) 
			{
				currentCustomer = queue.poll();
			}
			currentCustomer.removeItem();
			timeElapsed += 5;
			
			if(queue.size() > 0) 
			{
				timeWaited += 5;
			}
			
			running = true;
		}
		else
		{
			timeElapsed += 5;
			setFreeTime(getFreeTime() + 5);
			running = false;
		}
	}
	
	public void addCustomer(Customer person) 
	{
		queue.size();
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

	public int getTimeWaited()
	{
		return timeWaited;
	}

	public void setTimeWaited(int timeWaited)
	{
		this.timeWaited = timeWaited;
	}

	public int getTimeElapsed()
	{
		return timeElapsed;
	}

	public void setTimeElapsed(int timeElapsed)
	{
		this.timeElapsed = timeElapsed;
	}

	public boolean isRunning()
	{
		return running;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}

	public int getFreeTime()
	{
		return freeTime;
	}

	public void setFreeTime(int freeTime)
	{
		this.freeTime = freeTime;
	}

	public int getMaxLength()
	{
		return maxLength;
	}

	public void setMaxLength(int maxLength)
	{
		this.maxLength = maxLength;
	}
	
	
}
