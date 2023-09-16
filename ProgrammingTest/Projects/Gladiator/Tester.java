package Gladiator;

public class Tester
{
	public static void main(String[] args)
	{
		//NameGenerator nameGen = new NameGenerator();
		Arena arena = new Arena("Gladiator Arena Test", 5, 5);
		Bowman bow = new Bowman();
		Swordsman sword = new Swordsman();
		
		bow.setTeam(0);
		
		arena.addGladiator(bow, 3, 4);
		arena.addGladiator(sword, 4, 2);
		
		arena.arenaPrinter();
		
		arena.printInfo();
	
		//System.out.print(nameGen.fullNameGenerator() + "\n");
		
	}
}