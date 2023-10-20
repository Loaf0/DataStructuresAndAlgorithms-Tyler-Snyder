package theLegendOfLinkedList;

import java.util.Random;

public class Monster extends Entity
{
	MonsterNameGen nameGen;
	private Random rand;
	
	/**
	 * @param boolean - true if boss false otherwise
	 * @param difficulty - starts at 1 each floor 
	 */
	public Monster(Boolean boss, int difficulty) 
	{
		nameGen = new MonsterNameGen();
		rand = new Random();
		
		if (boss)
		{
			setMaxLife((rand.nextInt(10)+1) * difficulty/2);
			setLife(getMaxLife());
			setAttack((rand.nextInt(5)+1) * difficulty/2);
			setDefense((rand.nextInt(5)+1) * difficulty/2);
			setSpeed((rand.nextInt(2)+1) * difficulty/2);
			setMoney((rand.nextInt(10)+1) * difficulty/2);
			setXp((rand.nextInt(80)+20) * difficulty/2);
			setName(nameGen.bossNameGenerator());
		}
		else
		{
			setMaxLife((rand.nextInt(5)+3) * difficulty/2);
			setLife(getMaxLife());
			setAttack((rand.nextInt(2)+1) * difficulty/2);
			setDefense((rand.nextInt(2)+1) * difficulty/2);
			setSpeed((rand.nextInt(1)+1) * difficulty/2);
			setMoney((rand.nextInt(5)+1) * difficulty/2);
			setXp((rand.nextInt(50)+1) * difficulty/2);
			setName(nameGen.enemyTypeGenerator());
		}
	}
}
