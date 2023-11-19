package checkoutQueue;

public class RunSimulation
{
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		int numSuper = 10; //The number of items allowed in the superExpress line
		int numExp = 20; //The number of items allowed in the express line
		int numStandLines = 2; //The number of regular lines
		int arrivalRate = 10; //The arrival rate of customers per hour
		int maxItems = 20; //The maximum number of items
		int maxSimTime = 120; //The simulation time
		
		int amountOfSuperExpress = 1;
		int amountOfExpress = 2;
		int amountOfCheckout = 3;
		
		CheckoutCounter superExpressCheckout = new CheckoutCounter();
		CheckoutCounter[] expressCheckouts = new CheckoutCounter[amountOfExpress];
		CheckoutCounter[] checkouts = new CheckoutCounter[amountOfCheckout];
		
		fillArray(expressCheckouts, 2);
		fillArray(checkouts, amountOfCheckout);
		
		int customers = maxSimTime/60 * arrivalRate;
		int customersTaken = 0;
		
		boolean running = true;
		int globalClock = 0;
		while(running) 
		{
			if(globalClock >= maxSimTime / 60 * arrivalRate * customersTaken+1)
			{
				Customer nextCustomer = new Customer(maxItems);
				customersTaken++;
				
		        if(nextCustomer.getNumItems() < numSuper) //super express checkouts
				{
					superExpressCheckout.addCustomer(nextCustomer, globalClock);
				}
				else if(nextCustomer.getNumItems() < numExp) //express checkouts
				{
					if(expressCheckouts[0].getSize() <= expressCheckouts[1].getSize()) 
					{
						expressCheckouts[0].addCustomer(nextCustomer, globalClock);
					}
					else
					{
						expressCheckouts[0].addCustomer(nextCustomer, globalClock);
					}
				}
				else //normal checkouts
				{
					int min = 0;
					if(min != 0)
					{
						for(int j = 0; j < amountOfCheckout; j++) 
						{
							if(checkouts[j].getSize() < checkouts[min].getSize()) 
							{
								min = j;
							}
						}
					}
					checkouts[min].addCustomer(nextCustomer, globalClock);
				}
		    }
			System.out.println("Time : " + globalClock + " Customers Left " + (customers - customersTaken));
			
			globalClock += 5;
			
			if(maxSimTime*60 < globalClock)
			{
				running = false;
			}

		}
		
	}
	
	public static void fillArray(CheckoutCounter[] checkouts, int size) 
	{
		for(int i = 0; i < size; i++) 
		{
			checkouts[i] = new CheckoutCounter();
		}
	}
}
