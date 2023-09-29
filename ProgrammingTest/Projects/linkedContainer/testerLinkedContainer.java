package linkedContainer;

public class testerLinkedContainer
{
	
	public static void main(String[] args) 
	{
		
		
		LinkedContainer lc = new LinkedContainer();
		
		lc.add("First");
		lc.add("Second");
		lc.add("Third");
		lc.add("Fourth");
		lc.add("Fifth");
		lc.printAll();
		
		
		System.out.println("removing 2");
		lc.remove(2);
		lc.printAll();
		/*System.out.println("There are " + lc.getSize() + " boxes");
		
		System.out.println("Swapping First box");
		//lc.removeFirst();
		lc.remove("First");
		lc.addFirst("New First");
		
		lc.printAll();
		
		System.out.println("Testing get at position");
		System.out.println(lc.getData(1));
		
		lc.clear();
		lc.printAll();*/
	}
}
