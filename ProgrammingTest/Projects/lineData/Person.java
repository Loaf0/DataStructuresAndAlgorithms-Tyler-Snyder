package lineData;

public class Person
{
	String name;
	Person nextPerson;
	
	public Person() 
	{
		name = "no named guy";
	}
	
	public Person(String newName) 
	{
		name = newName;
	}
	
	public void setNextPerson(Person newNextPerson) 
	{
		nextPerson = newNextPerson;
	}
	
	public Person getNextPerson() 
	{
		return nextPerson;
	}

	public String getName()
	{
		return name;
	}
	
}
