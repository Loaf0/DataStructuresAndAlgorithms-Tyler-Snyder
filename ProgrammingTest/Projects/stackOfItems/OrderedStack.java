package stackOfItems;
import java.util.Collections;
import java.util.Stack;

public class OrderedStack
{
	public Stack<Integer> orderS(Stack<Integer> stack1, Stack<Integer> stack2) 
	{
		while(!stack2.isEmpty())
			stack1.add(stack2.pop());
		Collections.sort(stack1);
		
		return stack1;
	}
}
