package genericDataBox;

public class DataBox <E> //elements mean generic data
{
	//generics E for element T for type K for key V for value
	
	private E obj;
	
	public void setIt(E newValue) 
	{
		obj = newValue;
	}
	
	public E getIt() 
	{
		if(obj instanceof Integer)
		{
			return obj;
		}
		
		return obj;
	}
}
