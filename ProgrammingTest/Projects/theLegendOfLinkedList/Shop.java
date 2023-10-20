/*
* @author Tyler Snyder
* @date 10/18/23
* This handles the shop rooms in the dungeon class
*/

package theLegendOfLinkedList;

import java.util.Scanner;

public class Shop extends Event
{
	private String name;
	private Scanner shopScan;
	
	public Shop(Scanner scan) 
	{
		shopScan = scan;
		name = "Shop";
	}
	
	/**
	* controls the shop interaction
	* @param Hero that is entering the shop
	*/
	public void shopMenu(Hero player) 
	{ 
		int choice = -1;
		while(choice > 4 || choice < 1)
		{
		System.out.print("Welcome to my Inn! What would you like? \n"
				+ "(enter the corresponding number): \n"
				+ "(1) Buy a Meal   (15 Gold) - Regain all life\n"
				+ "(2) Rent a Room  (20 Gold) - Increase max life and regain all life\n"
				+ "(3) Get Trained  (50 Gold) - Gain a level up\n"
				+ "(4) Leave        (0  Gold)\n");
		
			if(shopScan.hasNextInt())
				choice = shopScan.nextInt();
			else
				shopScan.next();
			
			if(choice == 1)
			{
				if(player.getMoney() >= 15) 
				{
					player.setMoney(player.getMoney() - 15);
					player.setLife(player.getMaxLife());
					System.out.println("You sit down and enjoy a homecooked meal!");
				}
				else
				{
					System.out.println("Are you trying to scam me? You don't have enough gold. GET OUT! ");
				}
			}
			else if(choice == 2)
			{
				if(player.getMoney() >= 25) 
				{
					player.setMoney(player.getMoney() - 25);
					player.setLife(player.getMaxLife());
					System.out.println("You feel rest up ready to continue through the dungeons!");
				}
				else
				{
					System.out.println("You feel rest up ready to continue through the dungeons!");
				}
			}		
			else if(choice == 3)
			{
				if(player.getMoney() >= 50)
				{
					System.out.print("You train for hours with the shop keep!");
					player.levelUp();
				}
				else
				{
					System.out.println("Are you trying to scam me? You don't have enough gold. GET OUT! ");
				}
			}
			else if(choice == 4)
				System.out.println("You leave the shop with nothing!");
			else
				System.out.println("Please enter a number between 1 and 4");
		}	
	}
	
	/**
	* @return name of the room
	*/
	@Override
	public String getName() 
	{
		return name;
	}
}
