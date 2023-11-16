package myTree;

public class TreeTester
{
	public static void main(String[] args) 
	{
		MyBinaryTree bTree = new MyBinaryTree();
		
		int[] arr = {6, 4, 3, 2, 22, 64, 100 , 86, 35, 33 , 25, 7}; 
		
		bTree.add(arr);
		//bTree.add(10);
		
		System.out.println(bTree.getSize());
		int target = 5;
		System.out.println("the tree contains " + target + " : " + bTree.contains(target) );
		
		bTree.printPreorder();
		
		bTree.printPostorder();
	}
}
