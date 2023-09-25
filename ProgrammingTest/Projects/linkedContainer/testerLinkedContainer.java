package linkedContainer;

public class testerLinkedContainer
{
	
	public static void main(String[] args) 
	{
		LinkedContainer lc = new LinkedContainer();
		
		lc.add(1, "First");
		lc.add(2, "Second");
		lc.add(3, "Third");
		lc.add(5, "Fifth");
		
		lc.printAll();
	}
}
