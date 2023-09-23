package genericDataBox;

public class DataBoxTester
{

	public static void main(String[] args)
	{
		DataBox<String> myStringBox = new DataBox<>();
		myStringBox.setIt("Fun String");
		System.out.println(myStringBox.getIt());
		
		DataBox<Integer> myIntBox = new DataBox<>();
		myIntBox.setIt(123);
		System.out.println(myIntBox.getIt());
	}

}
