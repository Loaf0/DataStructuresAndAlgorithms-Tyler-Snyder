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
		
		int customers = (maxSimTime / 60) * arrivalRate;
		
		for(int i = 0; i < customers; i++) 
		{
			Customer nextCustomer = new Customer(maxItems);
			
			if(nextCustomer.getNumItems() < numSuper) //super express checkouts
			{
				superExpressCheckout.addCustomer(nextCustomer);
			}
			else if(nextCustomer.getNumItems() < numExp) //express checkouts
			{
				if(expressCheckouts[0].getSize() <= expressCheckouts[1].getSize()) 
				{
					expressCheckouts[0].addCustomer(nextCustomer);
				}
				else
				{
					expressCheckouts[0].addCustomer(nextCustomer);
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
				checkouts[min].addCustomer(nextCustomer);
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
