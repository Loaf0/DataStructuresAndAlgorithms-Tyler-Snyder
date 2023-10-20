package queueLab;

public class AirLineCheckinTester
{
	public static void main(String args[])
	{
		AirLineCheckinSim sim = new AirLineCheckinSim();
		sim.enterData();
		sim.runSimulation();
		sim.showStats();
		System.exit(0);
	}
}
