package stackOfItems;

import java.util.Stack;

public class StackOfItemTesters
{
	
	public static void main(String[] args) 
	{
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		s1.add(3);
		s1.add(1);
		s1.add(6);
		s2.add(2);
		s2.add(5);
		s2.add(7);
		OrderedStack os = new OrderedStack();
		
		System.out.println(os.orderS(s1, s2));
		
		/*String input = "restser";
		Palendrome pal = new Palendrome();
		
		pal.fillPalendrome(input);
		System.out.println(pal.buildReverse());
		System.out.println(pal.isPalendrome());
		*/
		/*StackOfItems deck = new StackOfItems();
		
		deck.push("test1");
		deck.push("test2");
		deck.push("test3");
		deck.push("test4");
		deck.push("test5");
		deck.push("test6");
		deck.push("test7");
		deck.print();*/
//		System.out.println("" + deck.search("test1")); 
		//System.out.println("" + deck.pop()); 
//		
//		deck.pop();
//		deck.pop();
//		deck.pop();
		//deck.print();
	}
}
