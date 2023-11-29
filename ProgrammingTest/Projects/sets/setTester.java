package sets;

public class setTester
{
	public static void main(String[] args) 
	{
		String[] arr1 = {"s", "a", "d"};
		Set set1 = new Set(arr1);
		
		String[] arr2 = {"s", "a", "d", "j", "k"};
		Set set2 = new Set(arr2);
		
		Set set3 = set1.union(set2);
		System.out.println( "Union : \n" + set3.toString() + "    Size :" + set3.size());
		
		set3 = set1.intersect(set2);
		System.out.println( "Intersect : \n" + set3.toString() + "    Size :" + set3.size());
		
		set3 = set1.compliment(set2);
		System.out.println( "Compliment : \n" + set3.toString() + "    Size :" + set3.size());
		
		
		
		
	}
}
