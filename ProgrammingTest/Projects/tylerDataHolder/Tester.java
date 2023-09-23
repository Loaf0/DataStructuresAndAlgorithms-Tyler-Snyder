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
		test.addFriend("Nimrod");
		test.addFriend(2, "Jobe");
		test.addFriend("Tammy");
		test.addFriend("Taylor");
		test.addFriend("Timmy");
		test.addFriend("Joesph");
		test.removeFriend(1);
		test.removeFriend("Timmy");
		
		System.out.println("Array Empty? : " + test.isEmpty());
		System.out.println("Does Joel Exist? : " + test.doesExist("Joel"));
		
		TylerDataHolder newFriendsList = test.deepClone();
		
		test.printArray();
		
		System.out.println("\nClearing Intial ArrayList (printing deep cloned array)");
		test.clear();
		test.printArray();
		
		newFriendsList.printArray();
		
	}
}
	