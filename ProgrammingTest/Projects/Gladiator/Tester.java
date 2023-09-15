package Gladiator;
public class Tester 
{
	public static void main(String[] args) 
	{
		//Gladiator glad = new Gladiator(null, 0, 0, 0, 0, 0, null, 0, 0, 0);
		NameGenerator nameGen = new NameGenerator();
		
		for(int i = 0; i < 20; i++)
		{
			System.out.print(nameGen.fullNameGenerator() + "\n");
		}
	}
}
