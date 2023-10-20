package lineData;

public class LinkedLineTester
{
	public static void main(String[] args) 
	{
		LinkedLine line = new LinkedLine();
		line.offer("Grover");
		line.offer("Garry");
		line.offer("George");
		line.offer("Gabrielle");
		line.offer("Giovanni");
		
		line.print();
		System.out.println("\nTaking first Person");
		
		line.poll();
		line.print();
	}
}
