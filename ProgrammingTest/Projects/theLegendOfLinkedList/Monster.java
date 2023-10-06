package theLegendOfLinkedList;

public class Monster extends Entity
{
	MonsterNameGen nameGen;
	
	public Monster(String name, int maxLife, int attack, int defense, int speed, int money) //Name, MaxLife, Attack, Defense, Speed, Money
	{
		super(name, maxLife, attack, defense, speed, money);
		nameGen = new MonsterNameGen();
	}
}
