package theLegendOfLinkedList;

public class Room
{
	private Event event;
	private Boolean cleared;
	private Room nextRoom;
	private Room prevRoom;
	private String roomName;

	public Room(Event newEvent)
	{
		event = newEvent;
		nextRoom = null;
		prevRoom = null;
		roomName = newEvent.getName();
	}

	public Room(Event newEvent, Room newNextRoom, Room newPrevRoom)
	{
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

	public void setCleared(Boolean newCleared)
	{
		cleared = newCleared;
	}

	public void clear()
	{
		cleared = true;
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

	public Boolean getCleared()
	{
		return cleared;
	}
}
