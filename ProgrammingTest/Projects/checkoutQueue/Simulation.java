package checkoutQueue;

import java.util.Scanner;

public class Simulation
{
	private int numSuper; // The number of items allowed in the superExpress line
	private int numExp; // The number of items allowed in the express line
	
	private int arrivalRate; // The arrival rate of customers per hour
	private int maxItems; // The maximum number of items
	private int maxSimTime; // The simulation time

	private int amountOfSuperExpress;
	private int amountOfExpress;
	private int amountOfCheckout;
	
	public Simulation() 
	{
		numSuper = 10; // The number of items allowed in the superExpress line
		numExp = 20; // The number of items allowed in the express line
		
		arrivalRate = 80; // The arrival rate of customers per hour
		maxItems = 30; // The maximum number of items
		maxSimTime = 120; // The simulation time

		amountOfSuperExpress = 1;
		amountOfExpress = 2;
		amountOfCheckout = 3;
	}
	
	public void enterData() 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Max Number of Items");
		maxItems = scan.nextInt();
		
		System.out.println("Enter Max Number of Items for a Super Express Lane");
		numSuper = scan.nextInt();
		
		System.out.println("Enter Max Number of Items for a Express Lane");
		numExp = scan.nextInt();
		
		System.out.println("Enter the customer arrival rate");
		arrivalRate = scan.nextInt();
		
		System.out.println("Enter the max simulation time :");
		maxSimTime = scan.nextInt();
		
		System.out.println("Enter the number of standard checkouts :");
		amountOfCheckout = scan.nextInt();
		
		scan.close();
	}
	
	public void startSimulation()
	{
		

		CheckoutCounter superExpressCheckout = new CheckoutCounter();
		CheckoutCounter[] expressCheckouts = new CheckoutCounter[amountOfExpress];
		CheckoutCounter[] checkouts = new CheckoutCounter[amountOfCheckout];

		fillArray(expressCheckouts, 2);
		fillArray(checkouts, amountOfCheckout);

		int customers = maxSimTime / 60 * arrivalRate;
		int timeBetweenCustomers = maxSimTime / customers;

		for (int globalClock = 0; globalClock < maxSimTime * 60; globalClock += 5)
		{
			//System.out.println("Time:" + globalClock);
			if (customers != 0)
			{
				if (Math.random() * maxSimTime >= timeBetweenCustomers)
				{
					Customer nextCustomer = new Customer(maxItems);
					customers--;

					if (nextCustomer.getNumItems() > numExp) // normal checkouts
					{
						int min = 0;

						for (int j = 0; j < amountOfCheckout; j++)
						{
							if (checkouts[j].getSize() <= checkouts[min].getSize())
							{
								min = j;
							}
						}
						checkouts[min].addCustomer(nextCustomer, globalClock);
					}
					else if (nextCustomer.getNumItems() <= numExp && nextCustomer.getNumItems() > numSuper) // express checkouts
					{
						if (expressCheckouts[0].getSize() <= expressCheckouts[1].getSize())
						{
							expressCheckouts[0].addCustomer(nextCustomer, globalClock);
						}
						else
						{
							expressCheckouts[1].addCustomer(nextCustomer, globalClock);
						}
					}
					else // super express checkouts
					{
						superExpressCheckout.addCustomer(nextCustomer, globalClock);
					}

				}

			}
			superExpressCheckout.runTick(globalClock);
			expressCheckouts[0].runTick(globalClock);
			expressCheckouts[1].runTick(globalClock);
			for (int j = 0; j < amountOfCheckout; j++)
			{
				checkouts[j].runTick(globalClock);
			}

		}

		System.out.println("Super Express Checkout" + "\n     Customers : " + superExpressCheckout.getCustomers() + "\n    Customers per hour : " + superExpressCheckout.getCustomers()/(maxSimTime/60) 
				+ "\n     Items : " + superExpressCheckout.getItems() + "\n    Items per hour : " + superExpressCheckout.getItems()/(maxSimTime/60) 
				+ "\n     Max Line Length : " + superExpressCheckout.getMaxLength() + "\n    Average wait : " + (superExpressCheckout.getWaitTime())/superExpressCheckout.getCustomers() );

		System.out.println("Express Checkout 1" + "\n    Customers : " + expressCheckouts[0].getCustomers() + "\n    Customers per hour : " + expressCheckouts[0].getCustomers()/(maxSimTime/60) 
				+ "\n    Items : " + expressCheckouts[0].getItems() + "\n    Items per hour : " + expressCheckouts[0].getItems()/(maxSimTime/60)
				+ "\n    Max Line Length : " + expressCheckouts[0].getMaxLength() + "\n    Average wait : " + (expressCheckouts[0].getWaitTime())/expressCheckouts[0].getCustomers() );

		System.out.println("Express Checkout 2" + "\n   Customers : " + expressCheckouts[1].getCustomers() + "\n    Customers per hour : " + expressCheckouts[1].getCustomers()/(maxSimTime/60) 
				+ "\n   Items : " + expressCheckouts[1].getItems() + "\n    Items per hour : " + expressCheckouts[1].getItems()/(maxSimTime/60)
				+ "\n   Max Line Length : " + expressCheckouts[1].getMaxLength() + "\n    Average wait : " + (expressCheckouts[1].getWaitTime())/expressCheckouts[1].getCustomers() );

		int totalCheckoutWait = 0;
		int totalCheckoutFree = 0;
		for (int i = 0; i < amountOfCheckout; i++)
		{
			totalCheckoutWait += checkouts[i].getWaitTime();
			totalCheckoutFree += checkouts[i].getFreeTime();
			System.out.println(
					"Checkout " + (i + 1) + "\n    Customers : " + checkouts[i].getCustomers() + "\n    Customers per hour : " + checkouts[i].getCustomers()/(maxSimTime/60) + "\n    Items : " + checkouts[i].getItems() + "\n    Items per hour : " + checkouts[i].getItems()/(maxSimTime/60) + "\n    Max Line Length : " + checkouts[i].getMaxLength() + "\n    Average wait : " + (checkouts[i].getWaitTime())/checkouts[i].getCustomers() );
		}
		
		//Average wait time
		customers = maxSimTime / 60 * arrivalRate;
		System.out.println("Total Average Wait Time : " + (superExpressCheckout.getWaitTime() + expressCheckouts[0].getWaitTime() + expressCheckouts[1].getWaitTime() + totalCheckoutWait)/ customers / (amountOfCheckout + amountOfExpress + amountOfSuperExpress)
				+ "\nTotal Wait Time : " + (superExpressCheckout.getWaitTime() + expressCheckouts[0].getWaitTime() + expressCheckouts[1].getWaitTime() + totalCheckoutWait)
				+ "\nTotal Average Free Time : " + (superExpressCheckout.getFreeTime() + expressCheckouts[0].getFreeTime() + expressCheckouts[1].getFreeTime() + totalCheckoutFree)/ customers / (amountOfCheckout + amountOfExpress + amountOfSuperExpress)
				+ "\nTotal Free Time : " + (superExpressCheckout.getFreeTime() + expressCheckouts[0].getFreeTime() + expressCheckouts[1].getFreeTime() + totalCheckoutFree)
				+ "\nTotal Customers : " + customers);
	}

	public static void fillArray(CheckoutCounter[] checkouts, int size)
	{
		for (int i = 0; i < size; i++)
		{
			checkouts[i] = new CheckoutCounter();
		}
	}
	
	
}
