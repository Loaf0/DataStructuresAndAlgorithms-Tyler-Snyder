package stackOfItems;

public class StackOfItemTesters
{
	
	public static void main(String[] args) 
	{
		StackOfItems deck = new StackOfItems();
		
		deck.push("test1");
		deck.push("test2");
		deck.push("test3");
		deck.push("test4");
		deck.push("test5");
		deck.push("test6");
		deck.push("test7");
		deck.print();
//		System.out.println("" + deck.search("test1")); 
		//System.out.println("" + deck.pop()); 
//		
//		deck.pop();
//		deck.pop();
//		deck.pop();
		//deck.print();
	}
}
