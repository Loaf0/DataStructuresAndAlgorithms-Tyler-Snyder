package queueLab;

import java.util.Scanner;

/**
 * Simulate the check-in process of an airline.
 */
public class AirLineCheckinSim
{
// Data Fields
	/** Queue of frequent flyers. */
	private PassengerQueue frequentFlyerQueue = new PassengerQueue("Frequent Flyer");
	/** Queue of regular passengers. */
	private PassengerQueue regularPassengerQueue = new PassengerQueue("Regular Passenger");
	/**
	 * Maximum number of frequent flyers to be served before a regular passenger
	 * gets served.
	 */
	private int frequentFlyerMax;
	/** Maximum time to service a passenger. */
	private int maxProcessingTime;
	/** Total simulated time. */
	private int totalTime;
	/** If set true, print additional output. */
	private boolean showAll;
	/** Simulated clock. */
	private int clock = 0;
	/** Time that the agent will be done with the current passenger. */
	private int timeDone;
	/**
	 * Number of frequent flyers served since the last regular passenger was served.
	 */
	private int frequentFlyersSinceRP;

	public void startServe()
	{
		if (!frequentFlyerQueue.isEmpty() && ((frequentFlyersSinceRP <= frequentFlyerMax) || regularPassengerQueue.isEmpty()))
		{
			// Serve the next frequent flyer.
			frequentFlyersSinceRP++;
			timeDone = frequentFlyerQueue.update(clock, showAll);
		}
		else if (!regularPassengerQueue.isEmpty())
		{
			// Serve the next regular passenger.
			frequentFlyersSinceRP = 0;
			timeDone = regularPassengerQueue.update(clock, showAll);
		}
		else if (showAll)
		{
			System.out.println("Time is " + clock + " server is idle");
		}
	}

	public void runSimulation()
	{
		for (clock = 0; clock < totalTime; clock++)
		{
			frequentFlyerQueue.checkNewArrival(clock, showAll);
			regularPassengerQueue.checkNewArrival(clock, showAll);
			if (clock >= timeDone)
			{
				startServe();
			}
		}
	}

	/** Method to show the statistics. */
	public void showStats()
	{
		System.out.println("\nThe number of regular passengers served was " + regularPassengerQueue.getNumServed());
		double averageWaitingTime = (double) regularPassengerQueue.getTotalWait() / (double) regularPassengerQueue.getNumServed();
		System.out.println(" with an average waiting time of " + averageWaitingTime);
		System.out.println("The number of frequent flyers served was " + frequentFlyerQueue.getNumServed());
		averageWaitingTime = (double) frequentFlyerQueue.getTotalWait() / (double) frequentFlyerQueue.getNumServed();
		System.out.println(" with an average waiting time of " + averageWaitingTime);
		System.out.println("Passengers in frequent flyer queue: " + frequentFlyerQueue.size());
		System.out.println("Passengers in regular passenger queue: " + regularPassengerQueue.size());
	}
	
	public void enterData()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Frequent Flyers per hour : ");
		int input = scan.nextInt();
		frequentFlyerQueue.setArrivalRate(input);

		System.out.println("Enter Regular Flyers per hour : ");
		input = scan.nextInt();
		regularPassengerQueue.setArrivalRate(input);

		System.out.println("Enter max Frequent Flyers between Regular Flyers : ");
		input = scan.nextInt();
		frequentFlyerMax = input;

		System.out.println("Enter max processing time(minutes) : ");
		input = scan.nextInt();
		maxProcessingTime = input;
		Passenger.setMaxProcessingTime(maxProcessingTime);

		System.out.println("Enter total simulated time(minutes) : ");
		input = scan.nextInt();
		totalTime = input;

		System.out.println("Do you want to see all the data ('y'/'n') : ");
		char charInput = scan.next().toLowerCase().charAt(0);

		if ('y' == charInput)
			showAll = true;
		else
			showAll = false;

		scan.close();
	}	
}