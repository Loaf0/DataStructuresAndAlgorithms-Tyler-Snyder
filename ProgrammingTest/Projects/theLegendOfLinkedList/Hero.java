package theLegendOfLinkedList;

public class Hero extends Entity
{
	public Hero(int maxLife, int attack, int defense, int speed, int money) //Name, MaxLife, Attack, Defense, Speed, Money
	{
		super("Player", maxLife, attack, defense, speed, money);
	}
	
	public void createHero(String name, int background) 
	{
		if(background == 0) // impoverished
		{
			setMaxLife(5);
			setLife(5);
			setAttack(3);
			setDefense(3);
			setSpeed(4);
			setMoney(0);
			setName(name.replaceAll(" ", "") + " The Impoverished"); //clean spaces off
		}
		else if(background == 1) // fighter
		{
			setMaxLife(10);
			setLife(10);
			setAttack(5);
			setDefense(5);
			setSpeed(5);
			setMoney(15);
			setName(name.replaceAll(" ", "") + " The Fighter");
		}
		else if(background == 2) // rogue
		{
			setMaxLife(4);
			setLife(4);
			setAttack(10);
			setDefense(3);
			setSpeed(10);
			setMoney(20);
			setName(name.replaceAll(" ", "") + " The Rogue");
		}
		else if(background == 3) // noble
		{
			setMaxLife(8);
			setLife(8);
			setAttack(4);
			setDefense(3);
			setSpeed(3);
			setMoney(100);
			setName(name.replaceAll(" ", "") + " The Noble");
		}
		else if(background == 4) // warrior
		{
			setMaxLife(10);
			setLife(10);
			setAttack(4);
			setDefense(7);
			setSpeed(2);
			setMoney(10);
			setName(name.replaceAll(" ", "") + " The Warrior");
		}
	} 
	
	public void find(Hero player, StatChanges event)
	{
		System.out.println("You Found a " + event.getItemName());
		if(getMaxLife() + event.getMaxLife() > 0) 
		{
			setMaxLife(getMaxLife() + event.getMaxLife());
		}
		else //cant die from items or traps
		{
			setMaxLife(1);
		}
		
		if(getMaxLife() < getLife()) 
		{
			setLife(getMaxLife());
		}
		
		setAttack(getAttack() + event.getAttack());
		setDefense(getDefense() + event.getDefense());
		setSpeed(getSpeed() + event.getSpeed());
		setMoney(getMoney() + event.getMoney());
		
		System.out.println(event.getItemDescription());
	}
}
