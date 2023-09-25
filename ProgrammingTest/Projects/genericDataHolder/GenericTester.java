package genericDataHolder;

public class GenericTester
{

		public static void main(String[] args) 
		{
			GenericDataHolder<String> stringArrList = new GenericDataHolder<>();
			stringArrList.addObject("String1");
			stringArrList.addObject("String2");
			stringArrList.addObject("String3");
			//stringArrList.addObject(2);
			stringArrList.printArray();
			
			GenericDataHolder<Integer> intArrList = new GenericDataHolder<>();
			intArrList.addObject(1);
			System.out.println(intArrList.get(0));
			
			System.out.println("Now Printing DeepCloned Array");

			GenericDataHolder<String> deepCloneArrList = stringArrList.deepClone();
			deepCloneArrList.printArray();
			
		}
		
}
