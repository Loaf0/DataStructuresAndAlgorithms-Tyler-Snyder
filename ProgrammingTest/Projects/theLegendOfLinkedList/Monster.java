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
			setMaxLife((rand.nextInt(10)+1) * difficulty);
			setLife(getMaxLife());
			setAttack((rand.nextInt(5)+1) * difficulty);
			setDefense((rand.nextInt(5)+1) * difficulty);
			setSpeed((rand.nextInt(2)+1) * difficulty);
			setMoney((rand.nextInt(10)+1) * difficulty);
			setXp((rand.nextInt(80)+1) * difficulty);
			setName(nameGen.bossNameGenerator());
		}
		else
		{
			setMaxLife((rand.nextInt(5)+3) * difficulty);
			setLife(getMaxLife());
			setAttack((rand.nextInt(2)+1) * difficulty);
			setDefense((rand.nextInt(2)+1) * difficulty);
			setSpeed((rand.nextInt(1)+1) * difficulty);
			setMoney((rand.nextInt(5)+1) * difficulty);
			setXp((rand.nextInt(50)+1) * difficulty);
			setName(nameGen.enemyTypeGenerator());
		}
	}
}
