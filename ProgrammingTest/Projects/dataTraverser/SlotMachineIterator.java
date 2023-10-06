package dataTraverser;

public class SlotMachineIterator
{
	public static void main(String[] args)
	{
		SlotMachine slots = new SlotMachine(5);
		
		while(slots.hasNext()) 
		{
			System.out.println(slots.pull());
		}
	}
}
