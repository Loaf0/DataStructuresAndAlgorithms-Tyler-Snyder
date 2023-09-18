package gladiator;

public class Tester
{
	public static void main(String[] args)
	{
		//NameGenerator nameGen = new NameGenerator();
		Arena arena = new Arena("Gladiator Arena Test", 9, 5);
		Bowman bow = new Bowman();
		//Bowman bow2 = new Bowman();
		Swordsman sword = new Swordsman();
		//Swordsman sword2 = new Swordsman();
		
		bow.setTeam(0);
		sword.setTeam(1);
		
		arena.addGladiator(bow, 1, 2);
		arena.addGladiator(sword, 2, 2);
		
		arena.arenaPrinter();
		
		arena.printInfo();
		
		bow.aiPlayTurn(arena.getArray());
		
		arena.printInfo();
	
		//System.out.print(nameGen.fullNameGenerator() + "\n");
		
	}
}