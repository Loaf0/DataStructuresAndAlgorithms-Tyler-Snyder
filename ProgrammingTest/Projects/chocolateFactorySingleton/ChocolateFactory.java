package chocolateFactorySingleton;

public class ChocolateFactory
{
	private static ChocolateFactory instanceCopy;
	
	private ChocolateFactory() 
	{
		
	}
	
	public void makeChocolate() 
	{
		System.out.println("Make Chocolate");
		
	}
	
	public static ChocolateFactory getInstance() 
	{
		if(instanceCopy == null)
			instanceCopy = new ChocolateFactory();
		return instanceCopy;
	}
}
