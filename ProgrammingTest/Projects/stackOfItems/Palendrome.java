package stackOfItems;

import java.util.Stack;

public class Palendrome
{
	String word;
	Stack<Character> wordStack;
	
	public Palendrome()
	{
		word = "";
		wordStack = new Stack<Character>();
	}
	
	public void fillPalendrome(String word)
	{
		this.word = word;
		for(int i = 0; i < word.length(); i++) 
		{
			wordStack.add(word.charAt(i));
		}
	}
	
	public String buildReverse() 
	{
		String output = "";
		
		while(!wordStack.isEmpty())
			output = output + wordStack.pop();
		fillPalendrome(word); // refill after use
		return output;
	}
	
	public boolean isPalendrome()
	{
		return word.equals(buildReverse());
	}
}
