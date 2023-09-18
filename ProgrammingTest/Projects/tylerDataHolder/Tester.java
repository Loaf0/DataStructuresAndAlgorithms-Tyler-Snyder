package tylerDataHolder;

public class Tester
{
	public static void main(String[] args) 
	{
		TylerDataHolder test = new TylerDataHolder();
		
		test.addFriend("James");
		test.addFriend("Joe");
		test.addFriend("Jorge");
		test.addFriend("Jewel");
		test.addFriend("jesus");
		test.addFriend("Jammy");
		test.addFriend("Joel");
		test.addFriend("Tyler");
		test.removeFriend(2);
		test.addFriend("Tammy");
		test.addFriend("Taylor");
		test.addFriend("Timmy");
		test.addFriend("Joesph");
		
		test.printArray();
		
		//System.out.println("TEST");
	}
}
