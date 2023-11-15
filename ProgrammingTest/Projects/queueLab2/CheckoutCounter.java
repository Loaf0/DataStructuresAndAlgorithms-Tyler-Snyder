package queueLab2;

import java.util.LinkedList;
import java.util.Queue;

public class CheckoutCounter
{
	Queue<Customer> queue;
	
	public CheckoutCounter() 
	{
		queue = new LinkedList<Customer>();
	}
	
	public void addCustomer(Customer person) 
	{
		queue.offer(person);
	}
	
	public boolean isEmpty() 
	{
		return queue.isEmpty();
	}
}
