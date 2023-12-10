package javaReflection;

import pokemon.*;
import java.lang.reflect.*;

public class ReflectionTesting
{
	public static void main(String[] args) 
	{
		
	// reflection is built into java, it allows access to all methods constructors and fields ----> even if they are private
	//java spring framework used for xml
	// https://www.baeldung.com/learn-spring-course  go to digital ocean
	
	Pokemon growlithe = new Growlithe();
	//Class<?> clazz = growlithe.getClass();
	
	System.out.println(growlithe.getClass());
	//System.out.println(growlithe.getConstructors());
	
	Class<?> pokeClass = growlithe.getClass();
	
	int pokeMods = pokeClass.getModifiers();
	System.out.println(Modifier.isPublic(pokeMods));
	
	//ield field = pokeClass.getDeclaredField("name");
	//field.setAccessible(true);
	//field.set(growlithe, "Not Growlithe");
	
	//growlithe.getMethods();
	
	
	}
}
