/*
* @author Tyler Snyder
* @date 10/18/23
* Event class the super class of all things contained in room able to distribute tasks to proper classes
*/

package theLegendOfLinkedList;

class Event implements Interactable
{
	/**
	 * controls of the player interacts with the rooms
	 * 
	 * @param Hero  that is exploring the dungeon
	 * @param event that the player is encountering
	 */
	public void interact(Hero player, Event event)
	{
		if (event instanceof Monster)
		{
			player.battle(player, (Monster) event);
		}
		else if (event instanceof StatChanges)
		{
			player.find(player, (StatChanges) event);
		}
		else if (event instanceof Shop) // rest area
		{
			player.buy(player, (Shop) event);
		}
	}

	/**
	 * @return event that the player is encountering
	 */
	public String getName()
	{
		return "DEFAULT INTERACTABLE";
	}
}
