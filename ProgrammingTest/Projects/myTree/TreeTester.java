package myTree;

public class TreeTester
{
	public static void main(String[] args)
	{
		MyIteratableBinaryTree bTree = new MyIteratableBinaryTree();

		int[] arr = {12, 11, 13, 8, 7, 9};

		bTree.add(10); //root term
		bTree.add(arr);

		System.out.println("Depth-first Traversal : Contains Method");
		System.out.println(bTree.dftContains(9));
		
		System.out.println("Breadth‐first Traversal : Contains Method");
		System.out.println(bTree.bfsContains(9));


		bTree.initilizeCurrent();
		System.out.println("Starting Iteration");
		while(bTree.hasNext()) 
		{
			System.out.print(bTree.next() + " ");
		}
		
		
	}
}
