/*
* @author Tyler Snyder
* @date 10/18/23
* The individual rooms held by the dungeon class (They each contain events)
*/

package theLegendOfLinkedList;

public class Room
{
	private Event event;
	private Room nextRoom;
	private Room prevRoom;
	private Boolean isExit;
	private String roomName;

	public Room(Event newEvent)
	{
		isExit = false;
		event = newEvent;
		nextRoom = null;
		prevRoom = null;
		roomName = newEvent.getName();
	}

	public Room(Event newEvent, Room newNextRoom)
	{
		isExit = false;
		event = newEvent;
		nextRoom = newNextRoom;
		roomName = newEvent.getName();
	}
	
	public Room(Event newEvent, Room newNextRoom, Room newPrevRoom)
	{
		isExit = false;
		event = newEvent;
		nextRoom = newNextRoom;
		prevRoom = newPrevRoom;
		roomName = newEvent.getName();
	}

	/**
	 * overrides the current event in a room
	 * @param event - new event
	 */
	public void setEvent(Event newEvent)
	{
		event = newEvent;
		roomName = event.getName();
	}

	/**
	 * sets the prev room
	 * @param Room - new room
	 */
	public void setPrevRoom(Room newPrevRoom)
	{
		prevRoom = newPrevRoom;
	}

	/**
	 * sets the next room
	 * @param Room - new next room
	 */
	public void setNextRoom(Room newNextRoom)
	{
		nextRoom = newNextRoom;
	}

	/**
	 * sets the name
	 * @param String - the name of the room
	 */
	public void setName(String newRoomName)
	{
		roomName = newRoomName;
	}

	/**
	 * sets the room to an exit
	 */
	public void isExit()
	{
		isExit = true;
	}

	/**
	 * gets the current event
	 */
	public Event getEvent()
	{
		return event;
	}

	/**
	 * gets the previous room
	 */
	public Room getPrevRoom()
	{
		return prevRoom;
	}

	/**
	 * gets the next room
	 */
	public Room getNextRoom()
	{
		return nextRoom;
	}

	/**
	 * gets the name of the room
	 */
	public String getName()
	{
		return roomName;
	}

	/**
	 * get if the room is an exit
	 * @return boolean - if its and exit
	 */
	public Boolean getIsExit()
	{
		return isExit;
	}
}
