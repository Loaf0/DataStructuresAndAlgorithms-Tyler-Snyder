package theLegendOfLinkedList;

public class Room
{
	private Event event;
	private Boolean isExit;
	private Room nextRoom;
	private Room prevRoom;
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

	public void setEvent(Event newEvent)
	{
		event = newEvent;
		roomName = event.getName();
	}

	public void setPrevRoom(Room newPrevRoom)
	{
		prevRoom = newPrevRoom;
	}

	public void setNextRoom(Room newNextRoom)
	{
		nextRoom = newNextRoom;
	}

	public void setName(String newRoomName)
	{
		roomName = newRoomName;
	}

	public void isExit()
	{
		isExit = true;
	}

	public Event getEvent()
	{
		return event;
	}

	public Room getPrevRoom()
	{
		return prevRoom;
	}

	public Room getNextRoom()
	{
		return nextRoom;
	}

	public String getName()
	{
		return roomName;
	}

	public Boolean getIsExit()
	{
		return isExit;
	}
}
