package Gladiator;

public class Tester
{
	public static void main(String[] args)
	{
		//NameGenerator nameGen = new NameGenerator();
		Arena arena = new Arena("Gladiator Arena Test", 10, 10);
		Bowman bow1 = new Bowman();
		Bowman bow2 = new Bowman();
		
		arena.addGladiator(bow1, 9, 5);
		arena.addGladiator(bow2, 0, 5);
		
		arena.arenaPrinter();
		System.out.println();
		
		arena.printInfo(9, 5);
		System.out.println();
		
		arena.printInfo(0, 5);
		System.out.println();
		//System.out.print(nameGen.fullNameGenerator() + "\n");
		
	}
}