package theLegendOfLinkedList;

class Event implements Interactable
{
	public void interact(Hero player, Event event)
	{
		if(event instanceof Monster) 
		{
			player.battle(player, (Monster) event);
		}
		else if (event instanceof StatChanges)
		{
			player.find(player, (StatChanges) event);
		}
//		else if (event instanceof Shop)
//		{
//			
//		}
//		
	}

	public String getName()
	{
		return "DEFAULT INTERACTABLE";
	}
}
